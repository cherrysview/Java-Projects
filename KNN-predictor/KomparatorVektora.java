package oop_sep1_23_Polic_Visnja_mp22435;

import java.util.Comparator;

public class KomparatorVektora implements Comparator<Vektor> {

    private Vektor targetVektor;
    private Metrika metrika;

    public KomparatorVektora(Vektor targetVektor, Metrika metrika){
        this.targetVektor = targetVektor;
        this.metrika = metrika;
    }

    @Override
    public int compare(Vektor o1, Vektor o2) {
        Vektor subo1 = o1.podvektor(0,o1.velicina()-2);
        Vektor subo2 = o2.podvektor(0,o2.velicina()-2);

        double rastojanje1 = metrika.rastojanje(subo1,targetVektor);
        double rastojanje2 = metrika.rastojanje(subo2, targetVektor);

        return Double.compare(rastojanje1,rastojanje2);
    }
}
