package com.gtop.work.es.config;

import org.elasticsearch.common.geo.GeoPoint;
import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;

/**
 * @author hongzw@citycloud.com.cn
 */
public class GeoPointPropertyEditorRegistrar implements PropertyEditorRegistrar {
    @Override
    public void registerCustomEditors(PropertyEditorRegistry registry) {
        registry.registerCustomEditor(GeoPoint.class, new GeoPointPropertyEditor());
    }
}