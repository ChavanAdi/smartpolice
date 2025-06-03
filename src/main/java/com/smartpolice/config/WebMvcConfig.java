package com.smartpolice.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer{
	
	 @Override
	    public void addResourceHandlers(ResourceHandlerRegistry registry) {
	        registry.addResourceHandler("/**")
	                .addResourceLocations("classpath:/static/");
	    }
	
	
	 @Override
     public void addCorsMappings(CorsRegistry registry) {
         registry.addMapping("/**")  // Applies to all endpoints
                 .allowedOrigins("http://172.105.47.237")  // Your React/Angular app URL
                 .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                 .allowedHeaders("*")
                 .allowCredentials(true);  // Optional, for cookies/auth headers
     }
}
