package cn.elitecode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 主应用程序启动类
 */
@SpringBootApplication(scanBasePackages = "${elitecode.info.base-package}")
public class ECServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ECServerApplication.class, args);
    }
}
