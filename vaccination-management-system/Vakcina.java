package oop_Milica_Polic_Visnja_mp22435;

public abstract class Vakcina {

    private String identifikator;
    public static int broj = 0;

    public Vakcina(String identifikator){
        this.identifikator = identifikator;
    }

    public String getIdentifikator() {
        return identifikator;
    }

    public abstract boolean vakcinisi();

}
