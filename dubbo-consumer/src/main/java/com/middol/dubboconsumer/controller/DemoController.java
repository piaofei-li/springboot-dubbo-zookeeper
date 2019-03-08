package com.middol.dubboconsumer.controller;

import com.middol.dubbopublicapi.service.DemoService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lipiaofei
 * @version 1.0
 * @date 2019/03/08 11:10
 */
@RestController
public class DemoController {

    /**
     * loadbalance 设置负载均衡的方式（局部设置负再均衡）
     *      random：RandomLoadBalance:权重随机调用(dubbo中默认使用的方式)
     *          如果服务多实例权重相同，则进行随机调用；如果权重不同，按照总权重取随机数
     *      roundrobin：RoundRobinLoadBalance:权重轮询调度算法
     *          若权重相同则直接取模调用服务，循环调用多个服务，若权重不相同则根据权重的大小循环调用服务
     *      leastactive：LeastActiveLoadBalance:最少活跃次数
     *          取出多个实例中被调用的次数最少的实例，如果只有一个则调用其，多个且权重相同则随机返回，权重不同则通过总权重随机调用
     *      consistenthash：ConsistentHashLoadBalance:一致性hash
     *          相同参数的请求总是发到同一提供者
     *          如果当前接收请求的提供者挂掉时，会将发往其的请求平摊到其它提供者
     * 也可以在application配置文件中配置   dubbo.consumer.loadbalance=
     */
    @Reference(version = "${project.service.version}", loadbalance = "consistenthash")
    private DemoService demoService;

    @RequestMapping("/test")
    public String test() {
        for( int i=0; i<119; i++ ) {
            demoService.sayHello("lpf");
        }
        return demoService.sayHello("lpf");
    }
}
