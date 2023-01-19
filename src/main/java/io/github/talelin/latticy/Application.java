package io.github.talelin.latticy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author pedro@TaleLin
 * 启动入口类
 */
@RestController
@MapperScan(basePackages = {"io.github.talelin.latticy.mapper"})
@SpringBootApplication(scanBasePackages = {"io.github.talelin.latticy"})
public class Application {

    @Value("${server.port}")
    private Integer serverPort;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @RequestMapping("/")
    public String index() {
        return "PaimaiConsoleService: server.port=" + serverPort;
    }
}
