package com.gtop.work.demo.spring.self.tag;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.springframework.util.StringUtils;
import org.w3c.dom.Element;

/**
 * 用于解析xml文件中自定义的gtopTag标签
 * xml文件解析过程：
 *  1、通过DelegatingEntityResolver创建BeansDtdResolver和PluggableSchemaResolver解析器（2.0之后是PluggableSchemaResolver），
 *    然后读取META-INF/spring.schemas文件映射成schemaMappings；
 *  2、将我们自定义的xml文件读取进内存，映射成Document对象；
 *  3、创建DefaultNamespaceHandlerResolver用于处理自定义命名空间标签，
 *    DefaultNamespaceHandlerResolver会将META-INF/spring.handlers文件读取映射成handlerMappings，
 *    handlerMappings保存了schema URI地址和默认Handler的对应关系；
 *  4、使用DefaultBeanDefinitionDocumentReader的parseBeanDefinitions方法解析xml中的元素，
 *    如果是默认元素，则使用默认的配置；如果是自定义元素，则根据元素找出命名空间Uri，根据Uri找到我们自定义的NamespaceHandler，
 *    然后会调用我们自定义NamespaceHandler的init方法，因此我们需要将parser在此方法内初始化，之后调用我们自定义parser的parse方法进行解析。
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
