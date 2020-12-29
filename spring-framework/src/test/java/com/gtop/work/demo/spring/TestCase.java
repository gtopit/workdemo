package com.gtop.work.demo.spring;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.DecimalFormat;
import java.text.NumberFormat;

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

    @Test
    public void testComponentScan() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-componentscan.xml");
    }

    @Test
    public void test() {
        NumberFormat format = new DecimalFormat("0%");
        String format1 = format.format(1.5);
        System.out.println(format1);
    }

}
