package com.smartpolice.config;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.annotation.PostConstruct;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.smartpolice.dto.ImageDto;
import com.smartpolice.entity.Esp32Data;
import com.smartpolice.entity.EventImageDetails;
import com.smartpolice.service.ImageService;

@Service
public class MosquittoSubscribeCameraService {

	//if wnat to change line no 58 & 195
	private static final String MQTT_BROKER = "tcp://172.105.47.237:1883"; // Replace with your Linode server IP
	private static final String MQTT_USERNAME = "inditech";
	private static final String MQTT_PASSWORD = "Inditech@1234";
//	private static final String CLIENT_ID = "mosquittoClient1";

	//private final int PORT = 8888;
	private static final String TOPIC2 = "allCases";
	private static final String TOPIC = "esp32/cam/image"; // Replace with your topic
	// private static final String TOPIC = "esp32/panic";
	private static final String TOPIC1 = "esp32/cam1/image";

	@Autowired
	ImageService imageService;
	private MqttClient mqttClient;

	
	private final ExecutorService executorService = Executors.newFixedThreadPool(20);// Once we have 10, process and publish
	private final List<EventImageDetails> imageBuffer = new ArrayList<>();
	private final Object bufferLock = new Object();

	@PostConstruct
	public void initializeMqttClient() {

		/*
		 * new Thread(() -> { try (ServerSocket serverSocket = new ServerSocket(PORT)) {
		 * System.out.println("TCP Server running on port " + PORT);
		 * 
		 * while (true) { Socket clientSocket = serverSocket.accept();
		 * System.out.println("New client connected: " + clientSocket.getInetAddress());
		 * 
		 * handleClient(clientSocket); } } catch (IOException e) { e.printStackTrace();
		 * } }).start();
		 */

		connectToMqttBroker();
	}

	@SuppressWarnings("unused")
	private void handleClient(Socket socket) {
		new Thread(() -> {
			try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
					PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {
				String inputLine;
				while ((inputLine = in.readLine()) != null) {
					System.out.println("Received: " + inputLine);
					try {
						processMessage(inputLine);
					} catch (MqttException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}).start();
	}

	private void processMessage(String message) throws MqttException, IOException {

		ObjectMapper mapper = new ObjectMapper();
		Esp32Data payload = mapper.readValue(message, Esp32Data.class);
		System.out.println(payload.getDeviceId());
		System.out.println(payload.getIncedentId());
		System.out.println(payload.getTime());
		System.out.println(payload.getDate());
		System.out.println(payload.getImage());

		byte[] imageBytes = Base64.getDecoder().decode(payload.getImage());
		System.out.println("-------->" + imageBytes.toString());
		String randomFileName = UUID.randomUUID().toString() + ".jpg";
		@SuppressWarnings("unused")
		CustomMultipartFile file = new CustomMultipartFile(imageBytes, randomFileName, "image/jpeg");
		//imageService.saveImage(payload.getDeviceId(), payload.getTimestamp(), file);
		publishImage(TOPIC1);
		System.out.println("-----Received Image Successfully-----");
		System.out.println("-------------------->Image Convert and Save to The DataBase");

	}

	@EventListener(ApplicationReadyEvent.class)
	public void onApplicationRestart() {
		System.out.println("🚀 Application restarted! Reconnecting to MQTT...");
		reconnectToMqttBroker();
	}

	public void connectToMqttBroker() {
		try {
			mqttClient = new MqttClient(MQTT_BROKER, MqttClient.generateClientId(), new MemoryPersistence());
			MqttConnectOptions options = new MqttConnectOptions();
			options.setCleanSession(true);
			options.setMaxInflight(1000);
			options.setUserName(MQTT_USERNAME); // ✅ Set username
			options.setPassword(MQTT_PASSWORD.toCharArray()); // ✅ Set password
			options.setAutomaticReconnect(true); // Auto-reconnect in case of failure
			

			mqttClient.connect(options);
			System.out.println("✅ Connected to MQTT Broker");

			mqttClient.setCallback(new MqttCallback() {
				@Override
				public void connectionLost(Throwable cause) {
					System.err.println("⚠️ Connection lost! Reconnecting...");
					reconnectToMqttBroker();
				}

				/*
				 * @Override public void messageArrived(String topic, MqttMessage message) {
				 * 
				 * try {
				 * 
				 * String jsonPayload = new String(message.getPayload());
				 * 
				 * ObjectMapper mapper = new ObjectMapper(); Esp32Data payload =
				 * mapper.readValue(jsonPayload, Esp32Data.class);
				 * System.out.println(payload.getDeviceId());
				 * System.out.println(payload.getTimestamp());
				 * System.out.println(payload.getImage());
				 * 
				 * byte[] imageBytes = Base64.getDecoder().decode(payload.getImage());
				 * System.out.println("-------->" + imageBytes.toString()); String
				 * randomFileName = UUID.randomUUID().toString() + ".jpg"; CustomMultipartFile
				 * file = new CustomMultipartFile(imageBytes, randomFileName, "image/jpeg");
				 * System.out.println("-----Received Image Successfully-----");
				 * 
				 * // imageService.saveImage1(file);
				 * imageService.saveImage(payload.getDeviceId(), payload.getTimestamp(), file);
				 * System.out.println(imageBytes.toString()); publishImage(TOPIC1);
				 * 
				 * System.out.println("Camera Image Recieved Successfullty");
				 * 
				 * } catch (Exception e) { e.printStackTrace(); reconnectToMqttBroker(); } }
				 */
				
				@Override
				public void messageArrived(String topic, MqttMessage message) throws JsonProcessingException, MqttException {
					
					if(topic.equals("allCases"))
					{
						 String jsonPayload = new String(message.getPayload());
						 System.out.println("----------->>"+jsonPayload);
						publishImage(TOPIC2);
					}else {
				    executorService.submit(() -> {
				        try {
				            String jsonPayload = new String(message.getPayload());
				            ObjectMapper mapper = new ObjectMapper();
				            Esp32Data payload = mapper.readValue(jsonPayload, Esp32Data.class);
				            
				            byte[] imageBytes = Base64.getDecoder().decode(payload.getImage());
				            String randomFileName = UUID.randomUUID().toString() + ".jpg";
				            CustomMultipartFile file = new CustomMultipartFile(imageBytes, randomFileName, "image/jpeg");
				            String deviceName = payload.getDeviceId();
				            String time = payload.getTime();
				            String date= payload.getDate();
				            String incidentId = payload.getIncedentId();
				            ImageDto imageDto = new ImageDto();
				            imageDto.setDeviceName(deviceName);
				            imageDto.setCaseGeneratedTime(LocalTime.parse(time));
				            imageDto.setCaseGeneratedDate(LocalDate.parse(date));
				            imageDto.setCaseId(incidentId);
				           EventImageDetails details= imageService.saveImage(imageDto, file);
				     
				            // Add to buffer
				            synchronized (bufferLock) {
				                imageBuffer.add(details);
				                if (imageBuffer.size() >= 20)  // Once we have 10, process and publish
				                	{

				                    publishBatch(imageBuffer);
				                    imageBuffer.clear();
				                }
				            }

				        } catch (Exception e) {
				            e.printStackTrace();
				            reconnectToMqttBroker();
				        }
				    });
				}
				}


				@Override
				public void deliveryComplete(IMqttDeliveryToken token) {
				}
			});

			mqttClient.subscribe(TOPIC, 1);
			mqttClient.subscribe(TOPIC2,2);
			System.out.println("✅ Subscribed to topic: " + TOPIC2);
			System.out.println("✅ Subscribed to topic: " + TOPIC);
		} catch (MqttException e) {
			System.err.println("❌ MQTT connection failed. Retrying...");
			e.printStackTrace();
			reconnectToMqttBroker();
		}
	}

	public void reconnectToMqttBroker() {
		  try {
		        if (mqttClient == null) {
		            System.out.println("MQTT client is null. Initializing connection...");
		            connectToMqttBroker();
		            return;
		        }

		        if (mqttClient.isConnected()) {
		            System.out.println("✅ Already connected to MQTT.");
		            return;
		        }

		        System.out.println("🔄 Attempting to reconnect to MQTT broker...");
		        mqttClient.reconnect();
		        System.out.println("✅ Reconnected successfully.");

		        mqttClient.subscribe(TOPIC, 1);
		        mqttClient.subscribe(TOPIC2, 2);
		        System.out.println("📡 Resubscribed to topics: " + TOPIC + ", " + TOPIC2);

		    } catch (MqttException e) {
		        System.err.println("❌ Error while reconnecting. Retrying in 5 seconds...");
		        e.printStackTrace();
		        try {
		            Thread.sleep(5000);
		        } catch (InterruptedException ignored) {
		        }
		        reconnectToMqttBroker();
		    }
	}

	public void publishImage(String topic) throws MqttException, JsonProcessingException {
		List<EventImageDetails> list = imageService.getAll();
		//EventImageDetails data=list.get(list.size()-1);
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonPayload = objectMapper.writeValueAsString(list);
		MqttMessage message = new MqttMessage(jsonPayload.getBytes());
		//message.setQos(1);
		//mqttClient.publish("esp32/cam1/image", message);
		
		
		//String jsonPayload1 = objectMapper.writeValueAsString(list);
		//MqttMessage message1 = new MqttMessage(jsonPayload.getBytes());
		message.setQos(1);
		mqttClient.publish("esp32/cam/all", message);
		System.out.println("Json Image Data Send Successfully----");
	}
	private void publishBatch(List<EventImageDetails> batch) {
	    try {
	        ObjectMapper mapper = new ObjectMapper();
	        mapper.registerModule(new JavaTimeModule());
	        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);  // Optional but recommended

	        String batchJson = mapper.writeValueAsString(batch);
	       // String batchJson = mapper.writeValueAsString(batch);
	        MqttMessage batchMessage = new MqttMessage(batchJson.getBytes());
	        batchMessage.setQos(1); // or whatever QoS you need
	        mqttClient.publish("esp32/cam1/image", batchMessage);
	        System.out.println("Published batch of 10 images!");
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

}
