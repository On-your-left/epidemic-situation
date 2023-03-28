package cn.wj.bishe;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cn.wj.bishe.mapper")
public class OutbreakServersApplication {
    public static void main(String[] args) {
        SpringApplication.run(OutbreakServersApplication.class, args);
    }
}
