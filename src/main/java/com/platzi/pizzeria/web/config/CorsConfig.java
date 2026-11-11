package com.platzi.pizzeria.web.config;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration 
public class CorsConfig {

    @Bean 
    CorsConfigurationSource corsConfigurationSource() {

        CorsConfiguration configurationSource = new CorsConfiguration();

        configurationSource.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
        configurationSource.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE"));
        configurationSource.setAllowedHeaders(Arrays.asList("*"));

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configurationSource);

        return source;
    }
}
