package oop_sep1_22_Polic_Visnja_mp22435;

public class Sastojak implements Comparable<Sastojak>{

    private String naziv;
    private VrsteSastojaka vrsta;
    private double cenaKG;

    public Sastojak(String naziv, VrsteSastojaka vrsta, double cenaKG){
        this.naziv = naziv;
        this.vrsta = vrsta;
        this.cenaKG = cenaKG;
    }

    public VrsteSastojaka getVrsta() {
        return vrsta;
    }

    public double cenaZaKolicinu(double kolicinaG){

        return kolicinaG/1000*cenaKG;
    }

    @Override
    public int compareTo(Sastojak o) {

        return o.naziv.compareTo(this.naziv);
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append(naziv).append(" - ").append(cenaKG).append("/kg").append("\n");

        return sb.toString();
    }

}
