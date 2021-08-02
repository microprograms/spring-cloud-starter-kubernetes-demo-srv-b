package com.github.microprograms.spring_cloud_starter_kubernetes_demo_srv_b.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("spring-cloud-starter-kubernetes-demo-srv-a")
public interface SvrA {

    /**
     * {"cost":2353,"start":1627877822728,"pi":3.1415926540361268,"end":1627877825081,"n":999999999}
     * 
     * @param n
     * @return
     */
    @RequestMapping("/pi/gridPi")
    String gridPi(Integer n);
}
