package br.com.bluelimit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "br.com.bluelimit")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}