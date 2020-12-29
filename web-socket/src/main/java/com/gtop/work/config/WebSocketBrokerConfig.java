package com.gtop.work.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.*;


/**
 * @author hongzw@citycloud.com.cn
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketBrokerConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/websocket/broker").setAllowedOrigins("*").withSockJS();
    }
    
}
