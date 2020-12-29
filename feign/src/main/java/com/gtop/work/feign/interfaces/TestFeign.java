package com.gtop.work.feign.interfaces;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * feignService为本服务名称
 * @author hongzw@citycloud.com.cn
 */
@FeignClient(name = "feignService")
public interface TestFeign {

    /**
     * test
     * @param id
     * @return
     */
    @RequestMapping(value = "/feign/testFeign", method = RequestMethod.GET)
    String testFeign(@RequestParam("id") Integer id);

}
