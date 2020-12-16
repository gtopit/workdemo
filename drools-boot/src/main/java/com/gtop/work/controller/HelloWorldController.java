package com.gtop.work.controller;

import com.gtop.work.service.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hongzw@citycloud.com.cn
 */
@RestController
public class HelloWorldController {

    @Autowired
    private HelloWorldService helloWorldService;

    @GetMapping("/helloWorld")
    public String helloWorld() {
        helloWorldService.helloWorldRule();
        return "ok";
    }

}
