package com.gtop.work.demo.spring.self.tag;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * 初始化自定义标签解析器
 * @author hongzw@citycloud.com.cn
 */
public class GtopTagNamespaceHandler extends NamespaceHandlerSupport {
    @Override
    public void init() {
        registerBeanDefinitionParser("gtopTag", new GtopTagBeanDefinitionParser());
    }
}
