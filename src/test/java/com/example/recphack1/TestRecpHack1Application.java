package com.example.recphack1;

import org.springframework.boot.SpringApplication;

public class TestRecpHack1Application {

    public static void main(String[] args) {
        SpringApplication.from(RecpHack1Application::main).with(TestcontainersConfiguration.class).run(args);
    }

}
