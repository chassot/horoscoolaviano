package com.chassoft.twitter.bot.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import twitter4j.Status;

import java.text.Normalizer;

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
        if(normalize(status.getText().toUpperCase()).contains(Sign.ARIES.name())){
            return Sign.ARIES;
        }
        if(normalize(status.getText().toUpperCase()).contains(Sign.TOURO.name())){
            return Sign.TOURO;
        }
        if(normalize(status.getText().toUpperCase()).contains(Sign.GEMEOS.name())){
            return Sign.GEMEOS;
        }
        if(normalize(status.getText().toUpperCase()).contains(Sign.CANCER.name())){
            return Sign.CANCER;
        }
        if(normalize(status.getText().toUpperCase()).contains(Sign.LEAO.name())){
            return Sign.LEAO;
        }
        if(normalize(status.getText().toUpperCase()).contains(Sign.VIRGEM.name())){
            return Sign.VIRGEM;
        }
        if(normalize(status.getText().toUpperCase()).contains(Sign.LIBRA.name())){
            return Sign.LIBRA;
        }
        if(normalize(status.getText().toUpperCase()).contains(Sign.ESCORPIAO.name())){
            return Sign.ESCORPIAO;
        }
        if(normalize(status.getText().toUpperCase()).contains(Sign.SAGITARIO.name())){
            return Sign.SAGITARIO;
        }
        if(normalize(status.getText().toUpperCase()).contains(Sign.CAPRICORNIO.name())){
            return Sign.CAPRICORNIO;
        }
        if(normalize(status.getText().toUpperCase()).contains(Sign.AQUARIO.name())){
            return Sign.AQUARIO;
        }
        if(normalize(status.getText().toUpperCase()).contains(Sign.PEIXES.name())){
            return Sign.PEIXES;
        }
        return null;
    }

    public String getFromDecorator(){
        Sign sign = getSign();
        String text ="";
        if(sign != null){
            text = sign.toString() + ": ";
        }
        return "@" + this.getStatus().getUser().getScreenName() + " " + text;
    }

    public static String normalize(String str) {
        return Normalizer.normalize(str, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
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
        PEIXES
    }
}
