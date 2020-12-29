package com.gtop.work.feign.feignimpl;

import com.gtop.work.feign.interfaces.TestFeign;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hongzw@citycloud.com.cn
 */
@RestController
public class TestFeignController implements TestFeign {

    @Override
    public String testFeign(Integer id) {
        return "hello->" + id;
    }

}
