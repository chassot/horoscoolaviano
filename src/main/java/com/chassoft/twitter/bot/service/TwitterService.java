package com.chassoft.twitter.bot.service;

import com.chassoft.twitter.bot.domain.Tweet;
import org.joda.time.DateTime;
import org.joda.time.Period;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import twitter4j.*;

import java.util.*;

@Service
public class TwitterService {
    private Logger logger = LoggerFactory.getLogger(TwitterService.class);

    @Value("${localuser}")
    private String DEFAULT_USER;

    @Autowired
    private PhrasesHandler phrasesHandler;

    private void sendTweet(Tweet tweet) {
        Twitter twitter = TwitterFactory.getSingleton();
        try {
            StatusUpdate statusUpdate = new StatusUpdate(tweet.getResponseText());
            statusUpdate.setInReplyToStatusId(tweet.getStatus().getId());
            logger.info(tweet.toString());
            twitter.updateStatus(statusUpdate);
        } catch (TwitterException e) {
            logger.error("Something gone Wild");
            e.printStackTrace();
        }
    }

    public void checkNewTweets(){
        logger.info("check new tweets");
        List<Tweet> tweets = getMyMentions();
        for (Tweet tweet : tweets) {
            if(isNew(tweet)){
                sendTweet(phrasesHandler.getContent(tweet));
            }
        }
    }

    private boolean isNew(Tweet tweet) {
        DateTime end = new DateTime(tweet.getStatus().getCreatedAt());
        Period diff = new Period(end, DateTime.now());

        return tweet.getStatus().getText().contains(DEFAULT_USER) &&
                diff.getYears() == 0 &&
                diff.getMonths() == 0 &&
                diff.getDays() == 0 &&
                diff.getHours() == 0 &&
                diff.getMinutes() == 0 &&
                diff.getSeconds() < 15;
    }

    private List<Tweet> getMyMentions(){
        List<Tweet> tweets = new ArrayList<>();
        try {
            List<Status> statuses = TwitterFactory.getSingleton().getMentionsTimeline();
            for (Status status : statuses) {
                tweets.add(new Tweet(status));
            }
        } catch (TwitterException e) {
            e.printStackTrace();
        }
        return tweets;
    }

}
