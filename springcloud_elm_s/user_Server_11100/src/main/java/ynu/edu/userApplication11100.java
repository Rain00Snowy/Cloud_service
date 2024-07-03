package ynu.edu;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@MapperScan("ynu.edu.mapper")
@EnableFeignClients

public class userApplication11100 {
    @LoadBalanced
    public static void main(String[] args) {
        SpringApplication.run(userApplication11100.class,args);
    }
}
