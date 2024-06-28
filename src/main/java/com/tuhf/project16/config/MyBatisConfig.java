package com.tuhf.project16.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.tuhf.project16.mapper")
public class MyBatisConfig {
}
