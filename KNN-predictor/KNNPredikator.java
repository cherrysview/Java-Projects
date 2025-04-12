package KNN_predictor;

import java.util.ArrayList;
import java.util.Collections;

public class KNNPredikator {

    private VektorskiProstor vp;
    private Metrika metrika;
    private int k;

    public KNNPredikator(VektorskiProstor vp, Metrika metrika, int k){
        this.vp = vp;
        this.metrika = metrika;
        this.k = k;
    }

    public double predvidjanjeCiljnePromen(Vektor targetVektor){

        ArrayList<Vektor> vektoriSort = new ArrayList<>(vp.getVektori());
        KomparatorVektora komparator = new KomparatorVektora(targetVektor, metrika);
        //Collections.sort(vektoriSort, komparator); // provari da li moze ovako

        Collections.sort(vektoriSort, komparator);

        double suma = 0.0;
        for (int i = 0; i < k; i++) {
            Vektor v =  vektoriSort.get(i);
            suma += v.uzmiElement(v.velicina()-1);
        }

        return suma/k;

    }





}
