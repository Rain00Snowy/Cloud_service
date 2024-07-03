package ynu.edu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClients;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import ynu.edu.rule.CustomerRandom;
import ynu.edu.rule.CustomerThreeTimesLoadBalancer;

@EnableFeignClients
@SpringBootApplication
@LoadBalancerClient(name="provider-server",configuration = CustomerThreeTimesLoadBalancer.class)

public class ConsumerApplication16000 {

//    @LoadBalanced//实现负载均衡 默认轮询
    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication16000.class,args);
    }
}
