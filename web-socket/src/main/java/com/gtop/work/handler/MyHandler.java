package com.gtop.work.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.*;

/**
 * @author hongzw@citycloud.com.cn
 */
@Slf4j
public class MyHandler extends TextWebSocketHandler {

    private Set<WebSocketSession> sessionSet = new HashSet<>();

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        sessionSet.add(session);
        String payload = message.getPayload();
        log.info("当前链接总数为：{}。接收到新webSocket链接，当前内容为：{}", sessionSet.size(), payload);
        super.handleTextMessage(session, message);
    }

    public void sendMessage(String message) {

        Iterator<WebSocketSession> iterator = sessionSet.iterator();

        while (iterator.hasNext()) {
            try {
                iterator.next().sendMessage(new TextMessage(message));
            } catch (IOException e) {
                log.error("发送信息异常:{}", e.getMessage());
            }
        }
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        sessionSet.remove(session);
        super.afterConnectionClosed(session, status);
    }
}
