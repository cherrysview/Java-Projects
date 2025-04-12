package oop_Milica_Polic_Visnja_mp22435;

import java.util.Random;

public class Fajzer extends Vakcina {

    private Jacina jacinaDoze;
    public Fajzer(String identifikator, Jacina jacinaDoze) {
        super(identifikator);
        this.jacinaDoze = jacinaDoze;
    }

    public Jacina getJacinaDoze() {
        return jacinaDoze;
    }

    @Override
    public boolean vakcinisi() {
        broj++;

        Random rand = new Random(System.currentTimeMillis());
        int randInt = rand.nextInt(100);
        switch (jacinaDoze){ // rekli su da uspesnost zavisi pd jacine doze
            case SLABA: return randInt<30; // a uspesnost je 30% ako je slucaj slaba
            case SREDNJA: return randInt<60; // itd.
            case JAKA: return randInt<90;
            default: return false; // inace je doslo do greske
        }
    }

    @Override
    public String toString() {
        return getIdentifikator() + " " + jacinaDoze;
    }
}
