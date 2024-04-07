package org.example.ynu.edu;

import org.example.ynu.edu.rule.CustomRandomLoadBalancerConf;
import org.example.ynu.edu.rule.CustomThreeTimeLoadBalancerConf;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@LoadBalancerClient(name = "provider-server", configuration = CustomThreeTimeLoadBalancerConf.class)
public class ConsumerApplication16000 {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication16000.class,args);
    }
}
