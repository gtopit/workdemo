package com.gtop.work.es;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * feign扫描包为feign接口所在包
 * @author hongzw@citycloud.com.cn
 */
@SpringBootApplication
public class EsApp {
    public static void main(String[] args) {
        SpringApplication.run(EsApp.class);
    }
}
