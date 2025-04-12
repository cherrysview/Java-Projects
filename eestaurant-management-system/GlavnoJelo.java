package oop_sep1_22_Polic_Visnja_mp22435;

import java.util.Map;

public class GlavnoJelo extends Jelo{
    public GlavnoJelo(String naziv, Map<Sastojak, Double> spisakSastojaka) {
        super(naziv, spisakSastojaka);

        for (Map.Entry<Sastojak, Double> sastojak: spisakSastojaka.entrySet()){
            VrsteSastojaka vrstaSastojka = sastojak.getKey().getVrsta();
            if(vrstaSastojka == VrsteSastojaka.SLADAK){
                throw new IllegalArgumentException("Jelo sadrzi pogresnu vrstu sastojka!");
            }
        }
    }

    @Override
    public double izracunajCenu(boolean popust) {

        if(popust)
            return getOsnovnaCena()*0.9;
        return getOsnovnaCena();
    }
}
