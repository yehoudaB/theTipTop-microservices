package com.dsp.theTipTop;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class CorsConfiguration {

	//https://www.youtube.com/watch?v=Ly79YDERpas
	//https://github.com/codeforgeyt/one-to-many-web-service
    @Value("*")
    private String allowedOrigin;

    @Bean
    public WebMvcConfigurer getCorsConfiguration(){
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins(allowedOrigin)
                        .allowedMethods("GET", "POST", "PUT", "DELETE")
                        .allowedHeaders("*", "http://localhost:4200/", "https://dsp4-5archio19-ah-je-gh-yb.fr/");
            }
        };
    }
}