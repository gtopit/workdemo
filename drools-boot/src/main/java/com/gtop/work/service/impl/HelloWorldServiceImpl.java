package com.gtop.work.service.impl;

import com.gtop.work.service.HelloWorldService;
import org.kie.api.KieBase;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author hongzw@citycloud.com.cn
 */
@Service
public class HelloWorldServiceImpl implements HelloWorldService {

    @Autowired
    private KieBase kieBase;


    @Override
    public void helloWorldRule() {
        KieSession kieSession = kieBase.newKieSession();
        kieSession.fireAllRules();
        kieSession.dispose();
    }

}
