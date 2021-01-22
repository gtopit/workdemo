package com.gtop.work.datasource.controller;

import com.gtop.work.datasource.service.ITestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hongzw@citycloud.com.cn
 */
@RestController
public class TestController {

    @Autowired
    private ITestService testService;

    @GetMapping("/spring/{id}")
    public String spring(@PathVariable("id") Integer id) {
        return testService.getUser(id);
    }

    @GetMapping("/second/{id}")
    public String second(@PathVariable("id") Integer id) {
        return testService.getOrder(id);
    }

}
