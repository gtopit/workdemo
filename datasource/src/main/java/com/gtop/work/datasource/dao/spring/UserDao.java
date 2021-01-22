package com.gtop.work.datasource.dao.spring;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author hongzw@citycloud.com.cn
 */
@Mapper
public interface UserDao {

    /**
     * 根据用户id获取用户信息
     * @param id
     * @return
     */
    String getUserById(@Param("id") Integer id);

}
