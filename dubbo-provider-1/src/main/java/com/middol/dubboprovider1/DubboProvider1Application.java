package com.middol.dubboprovider1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author lipiaofei
 * @version 1.0
 * @date 2019/03/08 11:02
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class DubboProvider1Application {

    public static void main(String[] args) {
        SpringApplication.run(DubboProvider1Application.class, args);
    }
}
