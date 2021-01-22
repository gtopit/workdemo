package com.gtop.work.boot.request;

import lombok.Data;

/**
 * @author hongzw@citycloud.com.cn
 */
@Data
public class MessageRequest {

    private Integer userId;

    private String userName;

    private String message;

}
