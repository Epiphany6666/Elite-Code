package cn.elitecode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 主应用程序启动类
 */
@SpringBootApplication(scanBasePackages = "cn.elitecode")
public class ECMainApplication {
    public static void main(String[] args) {
        SpringApplication.run(ECMainApplication.class, args);
    }
}
