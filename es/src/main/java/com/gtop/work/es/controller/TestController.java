package com.gtop.work.es.controller;

import com.gtop.work.es.service.ITestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hongzw@citycloud.com.cn
 */
@RestController
public class TestController {

    @Autowired
    private ITestService testService;

    @GetMapping("/stringQuery")
    public String stringQuery() {
        return testService.stringQuery();
    }

    @GetMapping("/nativeSearchQuery")
    public String nativeSearchQuery() {
        return testService.nativeSearchQuery();
    }

    @GetMapping("/nativeSearchQuery2")
    public String nativeSearchQuery2() {
        return testService.nativeSearchQuery2();
    }

}
