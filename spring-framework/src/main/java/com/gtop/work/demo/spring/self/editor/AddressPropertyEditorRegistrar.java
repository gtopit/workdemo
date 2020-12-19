package com.gtop.work.demo.spring.self.editor;

import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;

/**
 * xml配置文件的CustomEditorConfigurer使用propertyEditorRegistrars属性添加才需要用到
 * @author hongzw@citycloud.com.cn
 */
public class AddressPropertyEditorRegistrar implements PropertyEditorRegistrar {
    @Override
    public void registerCustomEditors(PropertyEditorRegistry registry) {
        registry.registerCustomEditor(Address.class, new AddressPropertyEditor());
    }
}
