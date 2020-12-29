package com.gtop.work.feign.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hongzw@citycloud.com.cn
 */
@RestController
public class TestController {

    @GetMapping("/v1/hello")
    public String hello1() {
        return "hello v1";
    }

    @GetMapping("/v2/hello")
    public String hello2() {
        return "hello v2";
    }

}
