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
    // 局部设置可以覆盖掉全局设置对当前局部设置进行修改的远程调用接口的设置
    /**
     * loadbalance 设置负载均衡的方式（局部设置负载均衡）：
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
    /**
     * cluster 设置dubbo集群容错机制（局部设置）：
     *      failover：失败自动切换，当出现失败时重试其它服务器，通常用于读操作，但重试会带来更长延迟。可通过retries="2" 来设置重试次数(2中不包含第一次)。
     *      failfast：快速失败，只发起一次调用，失败立即报错，通常用于非幂等性的写操作，比如新增记录
     *      failsafe：失败安全，出现异常时，直接忽略。通常用于写入审计日志等操作
     *      failback：失败自动恢复，后台记录失败请求，定时重发。通常用于消息通知操作
     *      forking：并行调用多个服务器，只要一个成功即返回。通常用于实时性要求较高的读操作，但需要浪费更多服务资源。可通过 forks="2" 来设置最大并行数。
     *      broadcast：广播调用所有提供者，逐个调用，任意一台报错则报错 。通常用于通知所有提供者更新缓存或日志等本地资源信息
     * 可以在application配置文件中配置    dubbo.consumer.cluster=     retries=
     */
    @Reference(version = "${project.service.version}", loadbalance = "consistenthash", cluster = "failfast")
    private DemoService demoService;

    @RequestMapping("/test")
    public String test() {
        for( int i=0; i<119; i++ ) {
            demoService.sayHello("lpf");
        }
        return demoService.sayHello("lpf");
    }
}
