package br.com.bluelimit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication(scanBasePackages = "br.com.bluelimit")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}