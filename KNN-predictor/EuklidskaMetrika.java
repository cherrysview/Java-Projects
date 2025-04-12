package KNN_predictor;

public class EuklidskaMetrika implements Metrika{
    @Override
    public double rastojanje(Vektor u, Vektor v) {

        if(u.velicina()!=v.velicina()){
            throw new IllegalArgumentException("Vektori nisu iste duzine!");
        }


        double suma = 0.0;
        for (int i = 0; i < u.velicina(); i++) {
            suma += Math.pow(u.uzmiElement(i) - v.uzmiElement(i), 2);
        }

        return Math.sqrt(suma);

    }
}
