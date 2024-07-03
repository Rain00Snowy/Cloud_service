package ynu.edu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("ynu.edu.mapper")
public class FoodApplication12100 {
    public static void main(String[] args) {
        SpringApplication.run(FoodApplication12100.class,args);
    }

}
