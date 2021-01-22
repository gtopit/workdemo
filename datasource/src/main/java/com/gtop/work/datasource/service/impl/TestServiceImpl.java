package com.gtop.work.datasource.service.impl;

import com.gtop.work.datasource.dao.second.OrderDao;
import com.gtop.work.datasource.dao.spring.UserDao;
import com.gtop.work.datasource.service.ITestService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author hongzw@citycloud.com.cn
 */
@Service
public class TestServiceImpl implements ITestService {

    @Resource
    private UserDao userDao;

    @Resource
    private OrderDao orderDao;

    @Override
    public String getUser(Integer id) {
        return userDao.getUserById(id);
    }

    @Override
    public String getOrder(Integer id) {
        return orderDao.getOrderById(id);
    }
}
