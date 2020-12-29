package com.gtop.work.controller;

import com.gtop.work.handler.MyHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;

/**
 * @author hongzw@citycloud.com.cn
 */
@Controller
public class MyController {

    //@Autowired
    //private MyHandler myHandler;

    @Autowired
    private SimpMessagingTemplate template;

    @GetMapping("/handler")
    public String handler() {

        return "handler";
    }

    @GetMapping("/handler/ack")
    @ResponseBody
    public String handlerAck() {
        String date = LocalDateTime.now().toString();
        //myHandler.sendMessage(date);
        return date;
    }

    @GetMapping("/broker")
    public String broker() {

        return "broker";
    }

    @GetMapping("/broker/ack")
    @ResponseBody
    public String brokerAck() {
        String date = LocalDateTime.now().toString();
        template.convertAndSend("/all/topicA", date);
        return date;
    }

}
