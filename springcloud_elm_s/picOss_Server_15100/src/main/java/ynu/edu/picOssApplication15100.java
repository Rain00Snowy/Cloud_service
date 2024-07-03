package ynu.edu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("ynu.edu.mapper")
public class picOssApplication15100 {
    public static void main(String[] args) {
        SpringApplication.run(picOssApplication15100.class,args);
    }

}
