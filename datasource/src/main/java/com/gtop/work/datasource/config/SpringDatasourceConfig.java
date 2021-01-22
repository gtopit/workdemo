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
 * 数据源1
 * @author hongzw@citycloud.com.cn
 */
@Configuration
@MapperScan(basePackages = "com.gtop.work.datasource.dao.spring", sqlSessionFactoryRef = "springSqlSessionFactory")
public class SpringDatasourceConfig {

    @Bean(name = "springDatasource")
    @Primary
    @ConfigurationProperties("spring.datasource")
    public DataSource springDatasource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "springSqlSessionFactory")
    @Primary
    public SqlSessionFactory sqlSessionFactory(@Qualifier("springDatasource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource);
        sessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources("classpath*:mapper/spring/*.xml"));
        return sessionFactoryBean.getObject();
    }

    @Bean(name = "springTransactionManager")
    @Primary
    public DataSourceTransactionManager testTransactionManager(@Qualifier("springDatasource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "springSqlSessionTemplate")
    @Primary
    public SqlSessionTemplate testSqlSessionTemplate(@Qualifier("springSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
