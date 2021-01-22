package com.gtop.work.datasource.dao.second;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author hongzw@citycloud.com.cn
 */
@Mapper
public interface OrderDao {

    String getOrderById(@Param("id") Integer id);

}
