package edu.hogwarts.studentadmin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HogwartsPart3Application {

    public static void main(String[] args) {
        SpringApplication.run(HogwartsPart3Application.class, args);
        InitData initData = new InitData();
        initData.run();

    }

}
