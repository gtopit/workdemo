package com.gtop.work.demo;

import com.gtop.work.demo.entity.Person;
import org.drools.decisiontable.InputType;
import org.drools.decisiontable.SpreadsheetCompiler;
import org.junit.Test;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieSession;
import org.kie.internal.utils.KieHelper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class TestRulesCase {

    @Test
    public void test() throws FileNotFoundException {

        ClassLoader loader = getClass().getClassLoader();
        URL url = loader.getResource("rules/excels/testRule.xlsx");
        File file = new File(url.getFile());

        InputStream input = new FileInputStream(file);

        SpreadsheetCompiler compiler = new SpreadsheetCompiler();

        String drl = compiler.compile(input, InputType.XLS);

        System.out.println(drl);

        KieHelper helper = new KieHelper();
        helper.addContent(drl, ResourceType.RDRL);
        KieSession kieSession = helper.build().newKieSession();

        List<String> list = new ArrayList<>();

        kieSession.setGlobal("listRules", list);

        Person person = new Person();
        person.setAge(50);
        person.setSalary(9000);
        person.setGender("女");

        kieSession.insert(person);

        kieSession.getAgenda().getAgendaGroup("sign").setFocus();

        kieSession.fireAllRules();

        list.forEach(e -> System.out.println(e));

        kieSession.dispose();

    }

}
