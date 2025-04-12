package oop_Milica_Polic_Visnja_mp22435;

import java.util.Comparator;

public class KomparatorVakcina implements Comparator<Vakcina> {

    @Override
    public int compare(Vakcina o1, Vakcina o2) {

        if(o1 instanceof Fajzer && o2 instanceof SputnjikV)
            return -1;
        else if (o1 instanceof SputnjikV && o2 instanceof Fajzer) {
            return +1;
        } else if (o1 instanceof Fajzer && o2 instanceof Fajzer){
            return - Integer.compare(((Fajzer) o1).getJacinaDoze().getRbr(), ((Fajzer) o2).getJacinaDoze().getRbr());
        } else
            return Integer.compare(((SputnjikV) o1).getBrMeseci(), ((SputnjikV) o2).getBrMeseci());
    }

}
