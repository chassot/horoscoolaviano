package com.chassoft.twitter.bot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.chassoft.twitter.bot")
public class TwitterAutoBot {


    public static void main(String[] args) {
        SpringApplication.run(TwitterAutoBot.class, args);
    }

}