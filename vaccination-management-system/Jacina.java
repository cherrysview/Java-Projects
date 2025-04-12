package oop_Milica_Polic_Visnja_mp22435;


public enum Jacina {

    SLABA(0),
    SREDNJA(1),
    JAKA(2);

    private int rbr;

    private Jacina(int rbr){
        this.rbr = rbr;
    }

    public int getRbr() {
        return rbr;
    }

    public static Jacina izBroja(int rbr){
        switch (rbr){
            case 0: return SLABA;
            case 1: return SREDNJA;
            case 2: return JAKA;
            default:/*
                System.err.println("Nije podrzana jacina!");
                return null;*/
                throw new IllegalArgumentException("Nedozvoljena vrednost za rbr!");
        }
    }

}
