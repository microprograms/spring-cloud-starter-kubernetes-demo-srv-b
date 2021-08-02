package com.github.microprograms.spring_cloud_starter_kubernetes_demo_srv_b;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class SpringCloudStarterKubernetesDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudStarterKubernetesDemoApplication.class, args);
	}

}
