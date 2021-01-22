package com.gtop.work.datasource.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * 数据源2
 * @author hongzw@citycloud.com.cn
 */
@Configuration
@MapperScan(basePackages = "com.gtop.work.datasource.dao.second", sqlSessionFactoryRef = "secondSqlSessionFactory")
public class SecondDatasourceConfig {

    @Bean(name = "secondDatasource")
    @ConfigurationProperties("second.datasource")
    public DataSource springDatasource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "secondSqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("secondDatasource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource);
        sessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources("classpath*:mapper/second/*.xml"));
        return sessionFactoryBean.getObject();
    }

    @Bean(name = "secondTransactionManager")
    public DataSourceTransactionManager testTransactionManager(@Qualifier("secondDatasource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "secondSqlSessionTemplate")
    public SqlSessionTemplate testSqlSessionTemplate(@Qualifier("secondSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
