package com.chassoft.twitter.bot.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class Tweet {

    private String from;
    private String text;
    private String to;
    private long id;
    private String responseText;

    public Tweet(String from, String text, long id) {
        this.from = from;
        this.text = text;
        this.id = id;
    }


    //find a proper pattern for this
    public Sign getSign() {
        if(text.toUpperCase().contains(Sign.ARIES.name())){
            return Sign.ARIES;
        }
        if(text.toUpperCase().contains(Sign.TOURO.name())){
            return Sign.TOURO;
        }
        if(text.toUpperCase().contains(Sign.GEMEOS.name())){
            return Sign.GEMEOS;
        }
        if(text.toUpperCase().contains(Sign.CANCER.name())){
            return Sign.CANCER;
        }
        if(text.toUpperCase().contains(Sign.LEAO.name())){
            return Sign.LEAO;
        }
        if(text.toUpperCase().contains(Sign.VIRGEM.name())){
            return Sign.VIRGEM;
        }
        if(text.toUpperCase().contains(Sign.LIBRA.name())){
            return Sign.LIBRA;
        }
        if(text.toUpperCase().contains(Sign.ESCORPIAO.name())){
            return Sign.ESCORPIAO;
        }
        if(text.toUpperCase().contains(Sign.SAGITARIO.name())){
            return Sign.SAGITARIO;
        }
        if(text.toUpperCase().contains(Sign.CAPRICORNIO.name())){
            return Sign.CAPRICORNIO;
        }
        if(text.toUpperCase().contains(Sign.AQUARIO.name())){
            return Sign.AQUARIO;
        }
        if(text.toUpperCase().contains(Sign.PEIXES.name())){
            return Sign.PEIXES;
        }
        return null;
    }

    public String getFromDecorator(){
        return "@" + this.getFrom() + " se liga::> ";
    }


    public enum Sign {
        ARIES("aries"),
        TOURO("touro"),
        GEMEOS("gemeos"),
        CANCER("cancer"),
        LEAO("leao"),
        VIRGEM("virgem"),
        LIBRA("libra"),
        ESCORPIAO("escorpiao"),
        SAGITARIO("sagitario"),
        CAPRICORNIO("capricornio"),
        AQUARIO("aquario"),
        PEIXES("peixes");

        Sign(String sign) {

        }
    }
}
