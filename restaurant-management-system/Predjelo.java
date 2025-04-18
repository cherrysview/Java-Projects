package restaurant_management_system;

import java.util.Map;

public class Predjelo extends Jelo{


    public Predjelo(String naziv, Map<Sastojak, Double> spisakSastojaka) {
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

        if(popust) {
           // double umanjenje = getOsnovnaCena() * 25 / 100;
            return getOsnovnaCena() * 0.75;
        }
        return getOsnovnaCena();
    }
}
