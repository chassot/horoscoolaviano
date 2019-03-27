package com.chassoft.twitter.bot;

import com.chassoft.twitter.bot.service.TwitterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication(scanBasePackages = "com.chassoft.twitter.bot")
@EnableScheduling
public class TwitterAutoBot {
    private Logger logger = LoggerFactory.getLogger(TwitterAutoBot.class);

    @Autowired
    private TwitterService twitterService;

    public static void main(String[] args) {
        SpringApplication.run(TwitterAutoBot.class, args);
    }

    @Scheduled(fixedRate = 15000)
    public void checkNewTweets(){
        twitterService.checkNewTweets();
    }
}