package com.gtop.work.demo.spring.self.editor;

import java.beans.PropertyEditorSupport;

/**
 * 用于解析Address
 * 参考ResourceEditorRegistrar的registerCustomEditors方法
 * 因此需要一个实现PropertyEditorRegistrar接口的自定义类AddressPropertyEditorRegistrar，
 * 然后将AddressPropertyEditorRegistrar注册到spring容器，
 * 借助CustomEditorConfigurer类，但是CustomEditorConfigurer类是什么时候被创建的？
 *  答案是CustomEditorConfigurer类实现了BeanFactoryPostProcessor，
 *  因此在调用AbstractApplicationContext类invokeBeanFactoryPostProcessors方法时初始化
 * 最后通过CustomEditorConfigurer发现存在两种方式将自定义editor注册到spring，
 *  1、propertyEditorRegistrars（即编写的AddressPropertyEditorRegistrar类）
 *  2、customEditors（不需要AddressPropertyEditorRegistrar，直接将Address和AddressPropertyEditor以key-value形式保存）
 * @author hongzw@citycloud.com.cn
 */
public class AddressPropertyEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        String[] arrTest = text.split("_");
        Address address = new Address();
        address.setProvince(arrTest[0]);
        address.setCity(arrTest[1]);
        address.setArea(arrTest[2]);
        setValue(address);
    }

}
