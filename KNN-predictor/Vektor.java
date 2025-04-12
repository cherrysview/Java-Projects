package KNN_predictor;

import java.util.ArrayList;

public class Vektor {

    private ArrayList<Double> elementi;
    private int n;

    public Vektor(ArrayList<Double> elementi){
        this.elementi = elementi;
        this.n = elementi.size();
    }

    public Vektor(){
        this.elementi = new ArrayList<>();
        this.n = 0;
    }

    public int velicina(){
        return n;
    }

    public void dodajElement(Double e){
        elementi.add(e);
        n++;
    }
    public Double uzmiElement(int ind){

        if(ind<0 || ind>this.velicina()-1)
            throw new IndexOutOfBoundsException("Indeks je van dozvoljenih granica!");

        return elementi.get(ind);
    }

    public Vektor podvektor(int i, int j) {


        if (i < 0 || j > this.velicina() - 1) {
            throw new IllegalArgumentException("Opseg podvektora je van dozvoljenih granica!");
        }
        Vektor v = new Vektor();
        for (int k = i; k <= j; k++) {
            //Double element = this.uzmiElement(k);
            Double element = elementi.get(k);
            v.dodajElement(element);
        }

        return v;
    }

    @Override
    public String toString() {
        return elementi.toString();
    }
}
