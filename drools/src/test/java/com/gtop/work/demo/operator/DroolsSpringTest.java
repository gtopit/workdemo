package com.gtop.work.demo.operator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kie.api.KieBase;
import org.kie.api.cdi.KBase;
import org.kie.api.cdi.KSession;
import org.kie.api.runtime.KieSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring.xml")
public class DroolsSpringTest {

    @KBase("kbase")
    private KieBase kieBase;

    // 不建议直接注入，而是通过KieBase每次新建
    @KSession("ksession")
    private KieSession kieSession;

    @Test
    public void test() {
        KieSession kieSession = kieBase.newKieSession();
        kieSession.fireAllRules();
        kieSession.dispose();
    }

    @Test
    public void test2() {
        kieSession.fireAllRules();
        kieSession.dispose();
    }
}
