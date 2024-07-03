package ynu.edu;

import org.springframework.cloud.openfeign.EnableFeignClients;
import ynu.edu.rule.CustomerLoadBalancerConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import ynu.edu.rule.CustomerThreeTimesLoadBalancer;
import ynu.edu.rule.ThreeTimesLoadBalancer;


@SpringBootApplication
@EnableFeignClients
@LoadBalancerClient(name="provider-server",configuration = CustomerThreeTimesLoadBalancer.class)
public class ConsumerApplication16001 {

//    在主启动类 将restTemp示例放入spring组件中
//    @Bean
//    @LoadBalanced//实现负载均衡
//    public RestTemplate getRestTemplate(){
//        return new RestTemplate();
//    }

    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication16001.class,args);
    }
}
