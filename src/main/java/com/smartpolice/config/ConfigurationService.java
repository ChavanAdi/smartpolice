package com.smartpolice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@Configuration
public class ConfigurationService {
	
	 private static ObjectMapper objectMapperInstance;
	  @Bean
	    public ObjectMapper objectMapper() {
	        if (objectMapperInstance == null) {
	            synchronized (MapperConfig.class) {
	                if (objectMapperInstance == null) {
	                    objectMapperInstance = new ObjectMapper();
	                    objectMapperInstance.registerModule(new JavaTimeModule());
	                    // ✅ Pretty Print JSON
	                    objectMapperInstance.enable(SerializationFeature.INDENT_OUTPUT);

	                    // ✅ Ignore Null Values in JSON Output
	                    objectMapperInstance.setSerializationInclusion(JsonInclude.Include.NON_NULL);

	                    // ✅ Additional Configurations if Needed
	                }
	            }
	        }
	        return objectMapperInstance;
	    }
}
