package com.gtop.work.controller;

import com.gtop.work.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author hongzw@citycloud.com.cn
 */
@Controller
public class MyController {

    @Autowired
    private MyService myService;

    @GetMapping("/index")
    public String index() {

        myService.schedule();

        return "index";
    }
}
