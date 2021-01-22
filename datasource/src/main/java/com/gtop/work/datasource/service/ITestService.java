package com.gtop.work.datasource.service;

/**
 * @author hongzw@citycloud.com.cn
 */
public interface ITestService {

    /**
     * 根据用户id获取用户信息
     * @param id
     * @return
     */
    String getUser(Integer id);

    /**
     * 根据订单id获取订单信息
     * @param id
     * @return
     */
    String getOrder(Integer id);

}
