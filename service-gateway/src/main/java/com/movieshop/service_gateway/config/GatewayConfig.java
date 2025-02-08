package com.movieshop.service_gateway.config;

import com.movieshop.service_gateway.utils.JwtUtil;
import jakarta.ws.rs.core.HttpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

  @Autowired
  private JwtUtil jwtUtil;

    @Bean
    public GlobalFilter tokenForwardingFilter() {
        return (exchange, chain) -> {
            String token = exchange.getRequest().getHeaders().getFirst(HttpHeaders.AUTHORIZATION);
            if (token != null) {
                String myToken = token.substring(7);
                String myUser = jwtUtil.extractUsername(myToken);

                jwtUtil.validateToken(myToken,myUser);

                exchange.getRequest().mutate()
                        .header(HttpHeaders.AUTHORIZATION, token)
                        .build();
            }

            return chain.filter(exchange);
        };
    }
}
