package com.github.microprograms.spring_cloud_starter_kubernetes_demo_srv_b.controller;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.github.microprograms.spring_cloud_starter_kubernetes_demo_srv_b.feign.SvrA;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/math")
public class MathController {
    private static final Logger log = LoggerFactory.getLogger(MathController.class);

    @Autowired
    private SvrA svrA;

    @RequestMapping("/areaCircle")
    public String areaCircle(Integer r) {
        log.info("areaCircle, r={}, calc...", r);
        Map<String, Object> map = new HashMap<>();
        // 计算pi
        map.put("startCalcPi", System.currentTimeMillis());
        double pi = JSON.parseObject(svrA.gridPi(999999999)).getDouble("pi"); // {"cost":2353,"start":1627877822728,"pi":3.1415926540361268,"end":1627877825081,"n":999999999}
        map.put("endCalcPi", System.currentTimeMillis());
        map.put("costCalcPi", (long) map.get("endCalcPi") - (long) map.get("startCalcPi"));
        // 计算面积
        map.put("start", System.currentTimeMillis());
        map.put("areaCircle", Math.pow(r, 2) * pi);
        map.put("r", r);
        map.put("end", System.currentTimeMillis());
        map.put("cost", (long) map.get("end") - (long) map.get("start"));
        log.info("areaCircle, r={}, result={}", r, JSON.toJSONString(map));
        return JSON.toJSONString(map);
    }

}
