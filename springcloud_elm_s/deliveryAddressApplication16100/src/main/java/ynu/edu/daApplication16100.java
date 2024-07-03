package ynu.edu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("ynu.edu.mapper")
public class daApplication16100 {
    public static void main(String[] args) {
        SpringApplication.run(daApplication16100.class,args);
    }

}
