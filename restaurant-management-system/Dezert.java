package restaurant_management_system;

import java.util.Map;

public class Dezert extends Jelo{
    public Dezert(String naziv, Map<Sastojak, Double> spisakSastojaka) {
        super(naziv, spisakSastojaka);
        for (Map.Entry<Sastojak, Double> sastojak: spisakSastojaka.entrySet()){
            VrsteSastojaka vrstaSastojka = sastojak.getKey().getVrsta();
            if(vrstaSastojka == VrsteSastojaka.SLAN){
                throw new IllegalArgumentException("Jelo sadrzi pogresnu vrstu sastojka!");
            }
        }

    }

    @Override
    public double izracunajCenu(boolean popust) {
        return getOsnovnaCena();
    }
}
