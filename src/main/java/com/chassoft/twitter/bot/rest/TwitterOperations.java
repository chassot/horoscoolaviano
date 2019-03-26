package com.chassoft.twitter.bot.rest;

import com.chassoft.twitter.bot.service.TwitterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/bot")
public class TwitterOperations {

    private Logger logger = LoggerFactory.getLogger(TwitterOperations.class);

    @Autowired
    private TwitterService twitterService;

    @GetMapping(value = "/checknews")
    public ResponseEntity<String> checkNews() {
        twitterService.checkNewTweets();
        return new ResponseEntity<>("Welcome", HttpStatus.ACCEPTED);
    }
}