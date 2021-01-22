package com.gtop.work.es.entity;

import lombok.Data;
import org.elasticsearch.common.geo.GeoPoint;

/**
 * @author hongzw@citycloud.com.cn
 */
@Data
public class MonitorDevice {

    private String monitorCode;

    private String monitorName;

    private String address;

    private String createTime;

    private GeoPoint location;

}
