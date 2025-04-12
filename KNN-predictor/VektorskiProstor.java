package KNN_predictor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class VektorskiProstor {

    ArrayList<String> naziviKoordinata;
    ArrayList<Vektor> vektori;

    public VektorskiProstor(){
        this.naziviKoordinata = new ArrayList<>();
        this.vektori = new ArrayList<>();
    }

    public ArrayList<String> getNaziviKoordinata() {
        return naziviKoordinata;
    }

    public ArrayList<Vektor> getVektori() {
        return vektori;
    }

    public void ucitajIzFajla(String filePath) {


        try {
            List<String> linije = Files.readAllLines(Paths.get(filePath));

            String koordinate = linije.get(0);

            for (String koordinata: koordinate.split(" ")){
                naziviKoordinata.add(koordinata);
            }

            for (int i = 1; i < linije.size(); i++) {
                String linija = linije.get(i);
                Vektor v = new Vektor();
                for (String broj: linija.split(" ")){
                    v.dodajElement(Double.parseDouble(broj));
                }
                vektori.add(v);
            }

        } catch (IOException e) {
            System.err.println("Nije uspelo otvaranje datoteke!");
            System.exit(1);
        } catch (NumberFormatException e1){
            System.err.println("Nedozvoljen format brojeva u datoteci!");
            System.exit(1);
        }

    }


    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append(naziviKoordinata).append("\n");
        for (Vektor v: vektori) {
            sb.append(v).append("\n");
        }


        return sb.toString();
    }
}
