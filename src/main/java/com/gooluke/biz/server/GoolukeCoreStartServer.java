package com.gooluke.biz.server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author 咕噜科
 * ClassName: GoolukeCoreStartServer
 * date: 2023-06-10 14:39
 * Description: 核心系统
 * version 1.0
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@ComponentScan(basePackages = "com.gooluke")
@MapperScan(basePackages = "com.gooluke.biz.integration.dao")
public class GoolukeCoreStartServer {

    public static void main(String[] args) {
        SpringApplication.run(GoolukeCoreStartServer.class,args);
    }

}
