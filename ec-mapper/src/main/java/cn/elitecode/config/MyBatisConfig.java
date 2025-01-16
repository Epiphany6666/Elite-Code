package cn.elitecode.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * MyBatis相关配置
 */
@Configuration
@MapperScan("cn.elitecode.mapper")
public class MyBatisConfig {
}
