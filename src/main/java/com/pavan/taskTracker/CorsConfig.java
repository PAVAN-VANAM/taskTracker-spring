package com.pavan.taskTracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {

    @Value("${frontend.url}")
    private String frontendURl;

    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.addAllowedOriginPattern(frontendURl); // Allow all origins
        corsConfiguration.addAllowedHeader("*");        // Allow all headers
        corsConfiguration.addAllowedMethod("*");        // Allow all methods (GET, POST, PUT, DELETE, etc.)
        corsConfiguration.setAllowCredentials(true);    // Allow credentials like cookies

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfiguration); // Apply CORS to all endpoints

        return new CorsFilter(source);
    }
}
