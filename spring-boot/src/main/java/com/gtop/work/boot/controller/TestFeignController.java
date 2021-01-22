package com.gtop.work.boot.controller;

import com.gtop.work.boot.request.MessageRequest;
import com.gtop.work.feign.interfaces.TestFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hongzw@citycloud.com.cn
 */
@RestController
public class TestFeignController {

    @Value("${spring.profiles.active}")
    private String activeProfiles;

    @Autowired
    private TestFeign testFeign;

    @GetMapping("/testFeign")
    public String test() {
        return  testFeign.testFeign(123);
    }

    @PostMapping("/test")
    public String test2(@RequestBody MessageRequest request) {
        return request.getMessage();
    }

    @GetMapping("/test3")
    public String test3() {
        return activeProfiles;
    }

}
