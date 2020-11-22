package cn.cy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("cn.cy.mapper")
@SpringBootApplication
public class DoubanparseApplication {

    public static void main(String[] args) {
        SpringApplication.run(DoubanparseApplication.class, args);
    }

}
