package com.chassoft.twitter.bot.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import twitter4j.Status;

@Data
@NoArgsConstructor
@ToString
public class Tweet {

    private Status status;
    private String responseText;

    public Tweet(Status status) {
        this.status = status;
    }

    public Sign getSign() {
        if(status.getText().toUpperCase().contains(Sign.ARIES.name())){
            return Sign.ARIES;
        }
        if(status.getText().toUpperCase().contains(Sign.TOURO.name())){
            return Sign.TOURO;
        }
        if(status.getText().toUpperCase().contains(Sign.GEMEOS.name())){
            return Sign.GEMEOS;
        }
        if(status.getText().toUpperCase().contains(Sign.CANCER.name())){
            return Sign.CANCER;
        }
        if(status.getText().toUpperCase().contains(Sign.LEAO.name())){
            return Sign.LEAO;
        }
        if(status.getText().toUpperCase().contains(Sign.VIRGEM.name())){
            return Sign.VIRGEM;
        }
        if(status.getText().toUpperCase().contains(Sign.LIBRA.name())){
            return Sign.LIBRA;
        }
        if(status.getText().toUpperCase().contains(Sign.ESCORPIAO.name())){
            return Sign.ESCORPIAO;
        }
        if(status.getText().toUpperCase().contains(Sign.SAGITARIO.name())){
            return Sign.SAGITARIO;
        }
        if(status.getText().toUpperCase().contains(Sign.CAPRICORNIO.name())){
            return Sign.CAPRICORNIO;
        }
        if(status.getText().toUpperCase().contains(Sign.AQUARIO.name())){
            return Sign.AQUARIO;
        }
        if(status.getText().toUpperCase().contains(Sign.PEIXES.name())){
            return Sign.PEIXES;
        }
        return null;
    }

    public String getFromDecorator(){
        return "@" + this.getStatus().getUser().getScreenName() + " ";
    }

    public enum Sign {
        ARIES,
        TOURO,
        GEMEOS,
        CANCER,
        LEAO,
        VIRGEM,
        LIBRA,
        ESCORPIAO,
        SAGITARIO,
        CAPRICORNIO,
        AQUARIO,
        PEIXES;
    }
}
