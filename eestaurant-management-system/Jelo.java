package oop_sep1_22_Polic_Visnja_mp22435;

import java.util.Map;
import java.util.TreeMap;

public abstract class Jelo {

    private String naziv;
    private Map<Sastojak, Double> spisakSastojaka = new TreeMap<>();
    private double osnovnaCena;

    public Jelo(String naziv, Map<Sastojak,Double> spisakSastojaka){
        this.naziv = naziv;
        this.spisakSastojaka = spisakSastojaka; // mozda mora new ThreeMap(spisakSastojaka)

        double suma = 0.0;
        for (Map.Entry<Sastojak, Double> jelo: spisakSastojaka.entrySet()){
            Sastojak s = jelo.getKey();
            suma += s.cenaZaKolicinu(jelo.getValue());
        }

        this.osnovnaCena = suma;

    }

    public double getOsnovnaCena() {
        return osnovnaCena;
    }

    public abstract double izracunajCenu(boolean popust);

    @Override
    public String toString() {

        return naziv + ": " + String.format("%.1f", osnovnaCena) + "\n";

    }
}
