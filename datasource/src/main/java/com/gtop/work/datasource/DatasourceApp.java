package com.gtop.work.datasource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * feign扫描包为feign接口所在包
 * @author hongzw@citycloud.com.cn
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class DatasourceApp {
    public static void main(String[] args) {
        SpringApplication.run(DatasourceApp.class);
    }
}
