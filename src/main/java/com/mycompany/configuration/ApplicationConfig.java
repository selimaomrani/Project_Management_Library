package com.mycompany.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author salima
 */
@Configuration
public class ApplicationConfig {
    
    @Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
    
}
