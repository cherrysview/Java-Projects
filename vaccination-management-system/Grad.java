package oop_Milica_Polic_Visnja_mp22435;

import java.util.Map;
import java.util.TreeMap;

public class Grad {

    private String ime;
    private Map<String, Boolean> ljudi;

    private int brojUspesnoVakcinisanih;

    public Grad(String ime){ // ne prosledjujem Map zato sto su rekli da konstruktor pravi ime grada i praznu mapu
        this.ime = ime;
        this.ljudi = new TreeMap<>();
    }

    public String getIme() {
        return ime;
    }

    public Map<String, Boolean> getLjudi() {
        return ljudi;
    }

    void dodajOsobu(String jmbg, Boolean uspeh){
        ljudi.put(jmbg,uspeh);
        if(uspeh)
            brojUspesnoVakcinisanih++;
    }

    public int getBrojUspesnoVakcinisanih() {
        return brojUspesnoVakcinisanih;
    }

    @Override
    public String toString() {

        if(brojUspesnoVakcinisanih == 0)
            return "";

        StringBuilder sb = new StringBuilder();

        sb.append(ime).append(": \n");
        for (Map.Entry<String, Boolean> covek: ljudi.entrySet()){
            if(covek.getValue())
                sb.append(covek.getKey() + "\n");
        }

        return sb.toString();
    }
}
