package com.gtop.work.demo.operator;

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
public class ComparisonOperatorTest {

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
     * 激活所有规则
     */
    @Test
    public void test1() {
        kieSession = kc.newKieSession("ComparisonOperatorKS");

        ComparisonOperatorEntity fact = new ComparisonOperatorEntity();
        fact.setName("张三");

        List<String> list = new ArrayList<>();
        list.add(fact.getName());
        fact.setList(list);

        kieSession.insert(fact);

        kieSession.fireAllRules();

    }

    /**
     * 指定激活规则
     */
    @Test
    public void test2() {
        kieSession = kc.newKieSession("ComparisonOperatorKS");

        ComparisonOperatorEntity fact = new ComparisonOperatorEntity();
        fact.setName("张三");

        List<String> list = new ArrayList<>();
        list.add(fact.getName());
        fact.setList(list);

        kieSession.insert(fact);

        kieSession.fireAllRules(new RuleNameEqualsAgendaFilter("rule_contains"));

    }

}
