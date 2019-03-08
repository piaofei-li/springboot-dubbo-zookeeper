package com.middol.dubboprovider2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class DubboProvider2Application {

    public static void main(String[] args) {
        SpringApplication.run(DubboProvider2Application.class, args);
    }

}
