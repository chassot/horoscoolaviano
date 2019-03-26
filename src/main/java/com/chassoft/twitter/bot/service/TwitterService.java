package com.chassoft.twitter.bot.service;

import com.chassoft.twitter.bot.domain.Tweet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import twitter4j.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@PropertySource("classpath:tweet-base.properties")
public class TwitterService {

    //FIXME Externalize to a properties
    public static final String SEPARATOR = "#";
    private Logger logger = LoggerFactory.getLogger(TwitterService.class);

    @Value("${localuser}")
    private String DEFAULT_USER;

    @Value("${aries}")
    private String aries;
    @Value("${touro}")
    private String touro;
    @Value("${gemeos}")
    private String gemeos;
    @Value("${cancer}")
    private String cancer;
    @Value("${leao}")
    private String leao;
    @Value("${virgem}")
    private String virgem;
    @Value("${libra}")
    private String libra;
    @Value("${escorpiao}")
    private String escorpiao;
    @Value("${sagitario}")
    private String sagitario;
    @Value("${capricornio}")
    private String capricornio;
    @Value("${aquario}")
    private String aquario;
    @Value("${peixes}")
    private String peixes;

    public void sendTweet(Tweet tweet) {
        //put user on content
        Twitter twitter = TwitterFactory.getSingleton();
        try {
            StatusUpdate statusUpdate = new StatusUpdate(tweet.getResponseText());
            statusUpdate.setInReplyToStatusId(tweet.getId());
            twitter.updateStatus(statusUpdate);
        } catch (TwitterException e) {
            logger.error("Something gone Wild");
            e.printStackTrace();
        }
    }

    public void checkNewTweets(){
        List<Tweet> tweets = getTweetsToMe();
        for (Tweet tweet : tweets) {
            if(tweet.getText().contains(DEFAULT_USER)){
                sendTweet(getContent(tweet));
            }
        }
    }

    private Tweet getContent(Tweet tweet){
        String content = "";
        switch (tweet.getSign()){
            case ARIES: content = getSignPhrase(aries);
                        break;
            case LEAO: content = getSignPhrase(leao);
                        break;
            case LIBRA:content = getSignPhrase(libra);
                        break;
            case TOURO:content = getSignPhrase(touro);
                        break;
            case AQUARIO:content = getSignPhrase(aquario);
                        break;
            case CANCER:content = getSignPhrase(cancer);
                        break;
            case CAPRICORNIO:content = getSignPhrase(capricornio);
                        break;
            case ESCORPIAO:content = getSignPhrase(escorpiao);
                        break;
            case GEMEOS:content = getSignPhrase(gemeos);
                        break;
            case PEIXES:content = getSignPhrase(peixes);
                        break;
            case SAGITARIO:content = getSignPhrase(sagitario);
                        break;
            case VIRGEM:content = getSignPhrase(virgem);
                        break;
        }
        tweet.setResponseText(tweet.getFromDecorator() + content);
        return tweet;

    }

    private String getSignPhrase(String basePhrases){
        String tweetContent = null;
        String[] phrases = basePhrases.split(SEPARATOR);
        tweetContent = phrases[getRandomNumberInRange(0, phrases.length-1)];

        return tweetContent;
    }

    private int getRandomNumberInRange(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    private List<Tweet> getTweetsToMe(){
        List<Tweet> tweets = new ArrayList<>();
        try {
            Twitter twitter = TwitterFactory.getSingleton();
            List<Status> statuses = null;
            statuses = twitter.getMentionsTimeline();
            for (Status status : statuses) {
                tweets.add(new Tweet(status.getUser().getScreenName(), status.getText(), status.getId()));
            }
        } catch (TwitterException e) {
            e.printStackTrace();
        }
        return tweets;
    }

}
