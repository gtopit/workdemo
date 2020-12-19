package com.gtop.work.entity;

import lombok.Builder;
import lombok.Data;

/**
 * 经纬度信息
 * @author hongzw@citycloud.com.cn
 */
@Builder
@Data
public class L2Position {

    private String longitude;

    private String latitude;

}
