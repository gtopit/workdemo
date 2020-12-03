package com.gtop.work.demo.entity;

import lombok.Builder;
import lombok.Data;

/**
 * @author hongzw@citycloud.com.cn
 */
@Builder
@Data
public class Person {

    private String username;

    private Integer age;

}
