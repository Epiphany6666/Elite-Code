package cn.elitecode.config;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * MyBatis相关配置
 */
@Configuration
@MapperScan(value = "cn.elitecode", annotationClass = Mapper.class)
public class MyBatisConfig {
}
