package ynu.edu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("ynu.edu.mapper")

public class ProviderApplication11001 {
    public static void main(String[] args) {
        SpringApplication.run(ProviderApplication11001.class,args);
    }
}
