package com.movieshop.movieservice.feign;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import jakarta.ws.rs.core.HttpHeaders;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


@Configuration
public class FeignConfig{

    @Bean
    public RequestInterceptor requestInterceptor() {
        return new RequestInterceptor() {
            @Override
            public void apply(RequestTemplate template) {
                // Retrieve the token from the SecurityContext or any other source
                String token = getTokenFromSecurityContext();
                if (token != null) {
                    template.header("Authorization", "Bearer " + token);
                }
            }
        };
    }
    private String getTokenFromSecurityContext() {
        // Get the authentication object from the SecurityContext (assuming it's already set)
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (attributes != null) {
            // Retrieve the Authorization header from the current request
            String authHeader = attributes.getRequest().getHeader(HttpHeaders.AUTHORIZATION);
            if (authHeader != null && authHeader.startsWith("Bearer ")) {
                return authHeader.substring(7);  // Remove the "Bearer " prefix
            }
        }
        return null;
    }
}
