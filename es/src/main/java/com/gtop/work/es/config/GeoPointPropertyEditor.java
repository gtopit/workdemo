package com.gtop.work.es.config;

import com.alibaba.fastjson.JSON;
import org.elasticsearch.common.geo.GeoJson;
import org.elasticsearch.common.geo.GeoPoint;
import org.springframework.data.elasticsearch.core.geo.GeoJsonPoint;
import org.springframework.data.geo.Point;

import java.beans.PropertyEditorSupport;

/**
 * @author hongzw@citycloud.com.cn
 */
public class GeoPointPropertyEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        GeoPoint geoPoint =JSON.parseObject(text, GeoPoint.class);
        setValue(geoPoint);
    }

}
