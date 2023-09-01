package com.project.demo;

import org.apache.catalina.filters.CorsFilter;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

@SpringBootApplication
public class SwadishtNamkinApplication {

	public static void main(String[] args) {
		SpringApplication.run(SwadishtNamkinApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	
	public FilterRegistrationBean<CorsFilter> corsFilter() {
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
		
        // Allow all origins. You can set specific origins using config.setAllowedOrigins(Arrays.asList("http://example.com"));
        config.addAllowedOrigin("*");
        
        // Allow specific HTTP methods (e.g., GET, POST, PUT, DELETE)
        config.addAllowedMethod("*");
        
        // Allow specific HTTP headers (e.g., Authorization, Content-Type)
        config.addAllowedHeader("*");
        
        // Allow cookies and credentials to be included in the request
        config.setAllowCredentials(true);
        
        source.registerCorsConfiguration("/**", config);
        
        FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean(new CorsFilter());
        bean.setOrder(0); // Set the order of the filter in the chain
        
        return bean;
	}
}
