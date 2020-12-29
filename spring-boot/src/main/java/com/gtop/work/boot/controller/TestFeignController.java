package com.gtop.work.boot.controller;

import com.gtop.work.feign.interfaces.TestFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hongzw@citycloud.com.cn
 */
@RestController
public class TestFeignController {

    @Autowired
    private TestFeign testFeign;

    @GetMapping("/test")
    public String test() {
        return  testFeign.testFeign(123);
    }

}
