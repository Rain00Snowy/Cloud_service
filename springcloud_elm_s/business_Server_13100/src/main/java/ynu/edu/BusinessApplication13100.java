package ynu.edu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("ynu.edu.mapper")
public class BusinessApplication13100 {
    public static void main(String[] args) {
        SpringApplication.run(BusinessApplication13100.class,args);
    }

}
