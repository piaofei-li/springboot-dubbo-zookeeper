package com.middol.dubboprovider3.service.impl;

import com.middol.dubbopublicapi.service.DemoService;
import org.apache.dubbo.config.annotation.Service;

/**
 * @author lipiaofei
 * @version 1.0
 * @date 2019/03/08 13:14
 */
@Service(version = "${project.service.version}", weight = 100)
public class DemoServiceImpl implements DemoService {

    private static Integer num = 0;

    public String sayHello(String name) {
        System.out.println("sayHello接口被调用 ----- 3 -- "+(++num));
        return "Hello " + name;
    }
}
