package com.bxc.assemble.emailSender.core;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.bxc.assemble.emailSender.core.mapper")
public class EmailSendApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmailSendApplication.class, args);
    }


}
