package com.gtop.work.demo.spring;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestCase {

    @Test
    public void testTag() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-gtoptag.xml");
        Object gtopTag = context.getBean("gtopTag");
        System.out.println(gtopTag);
    }

    @Test
    public void testEditor() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-editor.xml");
        Object student = context.getBean("student");
        System.out.println(student);
    }

}
