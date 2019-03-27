package com.chassoft.twitter.bot.service;

import com.chassoft.twitter.bot.domain.Tweet;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

import java.util.Random;

@PropertySource("classpath:tweet-base.properties")
public class PhrasesHandler {

    private final String SEPARATOR ="#";

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


    public Tweet getContent(Tweet tweet){
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


}
