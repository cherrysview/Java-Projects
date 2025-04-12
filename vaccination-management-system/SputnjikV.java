package oop_Milica_Polic_Visnja_mp22435;

import java.util.Random;

public class SputnjikV extends Vakcina{

    private String vector;
    private int brMeseci;


    public SputnjikV(String identifikator, String vector, int brMeseci) {
        super(identifikator);
        this.vector = vector;
        this.brMeseci = brMeseci;
    }

    public String getVector() {
        return vector;
    }

    public int getBrMeseci() {
        return brMeseci;
    }

    @Override
    public boolean vakcinisi() {

        broj++;
        Random rand = new Random(System.currentTimeMillis());
        int randInt = rand.nextInt(100);

        switch (getVector()){
            case "DNK": return true;
            case "RNK": return randInt<50;
            default: return false;
        }

    }

    @Override
    public String toString() {
        return getIdentifikator() + " " + vector + " " + brMeseci;
    }
}
