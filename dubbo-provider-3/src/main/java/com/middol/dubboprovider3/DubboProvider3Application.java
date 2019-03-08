package com.middol.dubboprovider3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class DubboProvider3Application {

    public static void main(String[] args) {
        SpringApplication.run(DubboProvider3Application.class, args);
    }

}
