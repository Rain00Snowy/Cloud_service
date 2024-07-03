package ynu.edu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("ynu.edu.mapper")
public class ordersApplication14100 {
    public static void main(String[] args) {
        SpringApplication.run(ordersApplication14100.class,args);
    }

}
