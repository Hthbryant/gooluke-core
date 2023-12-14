package com.gooluke.core.configuration;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/**
 * @author 咕噜科
 * ClassName: DBConfiguration
 * date: 2022-06-13 19:51
 * Description:
 * version 1.0
 */
@Configuration
public class DBConfiguration {

    private static final Logger logger = LoggerFactory.getLogger(DBConfiguration.class);

    @Bean("dataSource")
    public DataSource dataSource(@Value("${jdbc.datasource.driverClassName}") String driverClassName,
                                 @Value("${jdbc.datasource.url}") String url,
                                 @Value("${jdbc.datasource.username}") String username,
                                 @Value("${jdbc.datasource.password}") String password
    ) {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName(driverClassName);
        druidDataSource.setUrl(url);
        druidDataSource.setUsername(username);
        druidDataSource.setPassword(password);
        return druidDataSource;
    }
    @Bean("sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) {
        try {
            SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
            sqlSessionFactoryBean.setDataSource(dataSource);
            PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
            Resource[] resources = resolver.getResources("classpath:/mapper/*.xml");
            Resource config = resolver.getResource("classpath:mybatis-config.xml");
            sqlSessionFactoryBean.setMapperLocations(resources);
            sqlSessionFactoryBean.setConfigLocation(config);
            return sqlSessionFactoryBean.getObject();
        } catch (Exception e) {
            logger.error("create sqlSessionFactoryBean error", e);
            throw new RuntimeException("create sqlSessionFactoryBean error");
        }
    }

}
