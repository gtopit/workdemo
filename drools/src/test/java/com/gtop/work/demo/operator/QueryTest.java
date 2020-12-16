package com.gtop.work.demo.operator;

import com.gtop.work.demo.student.Student;
import org.drools.core.base.RuleNameEqualsAgendaFilter;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.QueryResults;
import org.kie.api.runtime.rule.QueryResultsRow;

public class QueryTest {
    private KieServices ks;
    private KieContainer kc;

    private KieSession kieSession;

    @Before
    public void before() {
        System.setProperty("drools.dateformat", "yyyy-MM-dd HH:mm");
        ks = KieServices.get();
        kc = ks.getKieClasspathContainer();
        kieSession = kc.newKieSession("QueryKS");
    }

    @After
    public void after() {
        kieSession.dispose();
    }

    /**
     * query
     */
    @Test
    public void test() {

        Student stu = new Student();
        stu.setAge(20);
        kieSession.insert(stu);

        QueryResults student = kieSession.getQueryResults("query_student");
        int size = student.size();
        System.out.println("size=" + size);

        kieSession.fireAllRules();
    }

    /**
     * query
     */
    @Test
    public void test2() {

        Student stu = new Student();
        stu.setAge(20);
        stu.setName("Faker");
        kieSession.insert(stu);

        stu = new Student();
        stu.setAge(18);
        stu.setName("Uzi");
        kieSession.insert(stu);

        QueryResults student = kieSession.getQueryResults("query_student2", "Faker");
        for (QueryResultsRow s : student) {
            // stu为drl文件绑定对象
            Student stu1 = (Student) s.get("stu");
            System.out.println(stu1.getName());
        }
        kieSession.fireAllRules();
    }

    /**
     * function
     */
    @Test
    public void test3() {

        Student stu = new Student();
        stu.setAge(20);
        stu.setName("Faker");
        kieSession.insert(stu);

        kieSession.fireAllRules(new RuleNameEqualsAgendaFilter("rule_function"));

    }

}
