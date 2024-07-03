package ynu.edu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfigApplication15000 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigApplication15000.class,args);
    }

}
//http://localhost:15000/service_consumer_16001-dev.yml