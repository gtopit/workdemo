package com.gtop.work.demo.spring.self.tag;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.springframework.util.StringUtils;
import org.w3c.dom.Element;

/**
 * 用于解析xml文件中自定义的gtopTag标签
 * @author hongzw@citycloud.com.cn
 */
public class GtopTagBeanDefinitionParser extends AbstractSingleBeanDefinitionParser {

    @Override
    protected Class<?> getBeanClass(Element element) {
        return GtopTag.class;
    }

    @Override
    protected void doParse(Element element, BeanDefinitionBuilder builder) {

        String id = element.getAttribute("id");
        if (StringUtils.hasText(id)) {
            builder.addPropertyValue("id", id);
        }

        String member = element.getAttribute("member");
        if (StringUtils.hasText(member)) {
            builder.addPropertyValue("member", member);
        }

        String description = element.getAttribute("description");
        if (StringUtils.hasText(description)) {
            builder.addPropertyValue("description", description);
        }

    }

}
