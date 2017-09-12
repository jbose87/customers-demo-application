package com.zaloni.application.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.zaloni.application.common.util.CustomJsonDateDeserializer;

@Configuration
public class ObjectMappingRegistration {
	
	@Bean
	public ObjectMapper objectMapper() {

	    ObjectMapper objectMapper = new ObjectMapper();

	    SimpleModule simpleModule = new SimpleModule();
	    simpleModule.addDeserializer(Object.class, new CustomJsonDateDeserializer());
	    objectMapper.registerModule(simpleModule);


	    return objectMapper;
	}

}
