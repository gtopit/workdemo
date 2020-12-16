package com.gtop.work.demo.operator;

import com.gtop.work.demo.student.Student;
import org.drools.core.base.RuleNameEqualsAgendaFilter;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hongzw@citycloud.com.cn
 */
public class StudentTest {

    private KieServices ks;
    private KieContainer kc;

    private KieSession kieSession;

    @Before
    public void before() {
        ks = KieServices.get();
        kc = ks.getKieClasspathContainer();
    }

    @After
    public void after() {
        kieSession.dispose();
    }


    /**
     * update规则
     */
    @Test
    public void test1() {
        kieSession = kc.newKieSession("StudentKS");

        Student fact = new Student();
        fact.setAge(8);

        kieSession.insert(fact);

        kieSession.fireAllRules();

    }

    /**
     * insert规则
     */
    @Test
    public void test2() {
        kieSession = kc.newKieSession("StudentKS");

        Student fact = new Student();
        fact.setAge(10);

        kieSession.insert(fact);

        kieSession.fireAllRules();

    }

}
