package com.reige.security.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author chenrui reige3@gmail.com
 * @date 2018/8/24.
 */
@SpringBootApplication(scanBasePackages={"com.reige.security"})
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
