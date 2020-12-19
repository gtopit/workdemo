package com.gtop.work.service;

import com.alibaba.fastjson.JSON;
import com.gtop.work.entity.L2Position;
import com.gtop.work.handler.MyHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author hongzw@citycloud.com.cn
 */
@Service
public class MyService {

    @Autowired
    private MyHandler myHandler;

    private ScheduledExecutorService service = new ScheduledThreadPoolExecutor(1);

    public void schedule() {
        service.scheduleAtFixedRate(() -> {

            L2Position position = L2Position.builder().latitude("24.12314").longitude("114.123111").build();
            String positionString = JSON.toJSONString(position);
            myHandler.sendMessage(positionString);
        }, 1000, 5000, TimeUnit.MILLISECONDS);
    }

}
