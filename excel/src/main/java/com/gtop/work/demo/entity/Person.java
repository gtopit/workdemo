package com.gtop.work.demo.entity;

import lombok.Builder;
import lombok.Data;

/**
 * @author hongzw@citycloud.com.cn
 */
@Builder
@Data
public class Person {

    private String gender;

    private Integer age;

    private Integer salary;

    private String username;

}
