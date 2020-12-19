package com.gtop.work.demo.operator;

import com.gtop.work.demo.student.Student;
import org.drools.core.base.RuleNameEqualsAgendaFilter;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * @author hongzw@citycloud.com.cn
 */
public class AttrTest {

    private KieServices ks;
    private KieContainer kc;

    private KieSession kieSession;

    @Before
    public void before() {
        System.setProperty("drools.dateformat", "yyyy-MM-dd HH:mm");
        ks = KieServices.get();
        kc = ks.getKieClasspathContainer();
    }

    @After
    public void after() {
        if (null != kieSession) {
            kieSession.dispose();
        }
    }


    /**
     * 属性规则
     */
    @Test
    public void test1() {
        kieSession = kc.newKieSession("AttrKS");

        Student fact = new Student();
        fact.setAge(10);

        kieSession.insert(fact);

        kieSession.fireAllRules();

    }

    /**
     * agenda-group规则
     */
    @Test
    public void test2() {
        kieSession = kc.newKieSession("AttrKS");

        kieSession.getAgenda().getAgendaGroup("myagenda1").setFocus();

        kieSession.fireAllRules();

    }

    /**
     * timer规则
     */
    @Test
    public void test3() throws InterruptedException {
        kieSession = kc.newKieSession("AttrKS");

        new Thread(() -> kieSession.fireUntilHalt()).start();

        Thread.sleep(30000);

        kieSession.halt();

    }

    /**
     * date-effective
     */
    @Test
    public void test4() {
        kieSession = kc.newKieSession("AttrKS");
        kieSession.fireAllRules(new RuleNameEqualsAgendaFilter("rule_date_effective"));

    }

    /**
     * date-expires
     */
    @Test
    public void test5() {
        kieSession = kc.newKieSession("AttrKS");
        kieSession.fireAllRules(new RuleNameEqualsAgendaFilter("rule_date_expires"));

    }

    @Test
    public void test6() {
        boolean b = "北京市大区大街道".matches("北京\\S*大兴\\S*");
        System.out.println(b);
    }

}
