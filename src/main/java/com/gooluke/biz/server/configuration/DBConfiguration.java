package com.gooluke.biz.server.configuration;

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

    @Value("${jdbc.datasource.driverClassName}")
    private String jdbcDriveClassName;

    @Value("${jdbc.datasource.url}")
    private String jdbcUrl;

    @Value("${jdbc.datasource.password}")
    private String jdbcPassword;

    @Value("${jdbc.datasource.username}")
    private String jdbcUsername;

    @Bean("dataSource")
    public DataSource dataSource() {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName(jdbcDriveClassName);
        druidDataSource.setUrl(jdbcUrl);
        druidDataSource.setUsername(jdbcUsername);
        druidDataSource.setPassword(jdbcPassword);
        return druidDataSource;
    }

    @Bean("sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory() {
        try {
            SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
            factory.setDataSource(dataSource());
            /*DefaultResourceLoader defaultResourceLoader = new DefaultResourceLoader();
            Resource resource = defaultResourceLoader.getResource("classpath:mybatis-config.xml");
            factory.setConfigLocation(resource);*/
            PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
            Resource[] resources = resolver.getResources("classpath:/mapper/*.xml");
            factory.setMapperLocations(resources);
            return factory.getObject();
        } catch (Exception e) {
            logger.error("create sqlSessionFactoryBean error",e);
            throw new RuntimeException("create sqlSessionFactoryBean error");
        }
    }

}
