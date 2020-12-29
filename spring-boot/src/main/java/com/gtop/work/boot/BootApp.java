package com.gtop.work.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * feign扫描包为feign接口所在包
 * @author hongzw@citycloud.com.cn
 */
@SpringBootApplication
@EnableFeignClients(basePackages = {"com.gtop.work.feign.interfaces"})
public class BootApp {
    public static void main(String[] args) {
        SpringApplication.run(BootApp.class);
    }
}
