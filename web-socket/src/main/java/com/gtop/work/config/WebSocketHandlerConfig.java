package com.gtop.work.config;

import com.gtop.work.handler.MyHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

/**
 * @EnableWebSocket 和 @EnableWebSocketMessageBroker 注解只能使用其中一个
 * webSocket配置
 * @author hongzw@citycloud.com.cn
 */
//@Configuration
//@EnableWebSocket
public class WebSocketHandlerConfig implements WebSocketConfigurer {

    @Autowired
    @Lazy
    private MyHandler myHandler;

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(myHandler, "/websocket/handler");
    }

    @Bean
    public MyHandler myHandler() {
        return new MyHandler();
    }

}
