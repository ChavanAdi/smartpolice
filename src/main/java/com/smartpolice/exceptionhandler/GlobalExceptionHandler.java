package com.smartpolice.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	
	
	@ExceptionHandler(SuperAdminServiceException.class)
    public ResponseEntity<String> superAdminServiceException(SuperAdminServiceException superAdminServiceException)
    {
    	return new ResponseEntity<String>(superAdminServiceException.getMsg(),HttpStatus.valueOf(superAdminServiceException.getStatuscode()));
    }
	
	@ExceptionHandler(PoliceStationServiceException.class)
    public ResponseEntity<String> PoliceStationServiceException(PoliceStationServiceException policeStationServiceException)
    {
    	return new ResponseEntity<String>(policeStationServiceException.getMsg(),HttpStatus.valueOf(policeStationServiceException.getStatuscode()));
    }
	
	@ExceptionHandler(UserServiceException.class)
    public ResponseEntity<String> UserServiceException(UserServiceException userServiceException)
    {
    	return new ResponseEntity<String>(userServiceException.getMsg(),HttpStatus.valueOf(userServiceException.getStatuscode()));
    }
	
	@ExceptionHandler(ShopServiceException.class)
    public ResponseEntity<String> ShopServiceException(ShopServiceException shopServiceException)
    {
    	return new ResponseEntity<String>(shopServiceException.getMsg(),HttpStatus.valueOf(shopServiceException.getStatuscode()));
    }
	
	@ExceptionHandler(OpearatorServiceException.class)
    public ResponseEntity<String> OpearatorServiceException(OpearatorServiceException opearatorServiceException)
    {
    	return new ResponseEntity<String>(opearatorServiceException.getMsg(),HttpStatus.valueOf(opearatorServiceException.getStatuscode()));
    }
	
	@ExceptionHandler(DeviceServiceException.class)
    public ResponseEntity<String> DeviceServiceException(DeviceServiceException deviceServiceException)
    {
    	return new ResponseEntity<String>(deviceServiceException.getMsg(),HttpStatus.valueOf(deviceServiceException.getStatuscode()));
    }
	
	@ExceptionHandler(HeartBeatServiceException.class)
    public ResponseEntity<String> HeartBeatServiceException(HeartBeatServiceException heartBeatServiceException)
    {
    	return new ResponseEntity<String>(heartBeatServiceException.getMsg(),HttpStatus.valueOf(heartBeatServiceException.getStatuscode()));
    }
	
	@ExceptionHandler(PanicServiceException.class)
    public ResponseEntity<String> PanicServiceException(PanicServiceException panicServiceException)
    {
    	return new ResponseEntity<String>(panicServiceException.getMsg(),HttpStatus.valueOf(panicServiceException.getStatuscode()));
    }
	
	@ExceptionHandler(ImageServiceException.class)
    public ResponseEntity<String> imageServiceException(ImageServiceException imageServiceException)
    {
    	return new ResponseEntity<String>(imageServiceException.getMsg(),HttpStatus.valueOf(imageServiceException.getStatuscode()));
    }
}
