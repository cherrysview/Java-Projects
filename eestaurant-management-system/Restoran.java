package oop_sep1_22_Polic_Visnja_mp22435;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import javax.imageio.IIOException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Restoran extends Application {

    private static Map<String, Sastojak> dostupniSastojci = new TreeMap<>();
    private static List<UredjeniPar<Jelo,Boolean>> jelovnik = new ArrayList<>();

    public static void main(String[] args) {

        Path datoteka = Paths.get("src/sastojci.txt");

        try {
            List<String> linije = Files.readAllLines(datoteka);

            for (String linija: linije){
                String[] reci = linija.split(" ");
                String naziv = reci[1].trim();
                double cenaKG = Double.parseDouble(reci[2]);
                switch (reci[0]){
                    case "SLAN": dostupniSastojci.put(naziv, new Sastojak(naziv, VrsteSastojaka.SLAN, cenaKG)); break;
                    case "SLADAK": dostupniSastojci.put(naziv, new Sastojak(naziv, VrsteSastojaka.SLADAK, cenaKG)); break;
                    case "NEUTRALAN": dostupniSastojci.put(naziv, new Sastojak(naziv, VrsteSastojaka.NEUTRALAN, cenaKG)); break;
                    default: throw new IllegalArgumentException("Nedozvoljena vrsta sastojka!");
                }
            }


        }catch (IOException e){
            System.err.println("Neuspelo otvaranje datoteke: " + datoteka + ".");
            System.exit(1);
        }catch (IllegalArgumentException exception){
            System.err.println(exception.getMessage());
            System.exit(1);
        }

        //System.out.println(dostupniSastojci);


        Path datoteka2 = Paths.get("src/jelovnik.txt");

        try {
            List<String> linije = Files.readAllLines(datoteka2);

            for (String linija : linije) {
                String[] reci = linija.split(" ");
                String nazivJela = reci[1].trim();
                String tipJela = reci[0].trim();
                boolean dostupnostJela = true;

                Map<Sastojak, Double> spisakSastojaka = new TreeMap<>();
                for (int i = 2; i < reci.length; i += 2) {
                    String nazivSastojka = reci[i];
                    double kolicina = Double.parseDouble(reci[i + 1].trim());
                        if (dostupniSastojci.keySet().contains(nazivSastojka)) {
                            spisakSastojaka.put(dostupniSastojci.get(nazivSastojka), kolicina);
                        } else {
                            dostupnostJela = false;
                        }
                }

                switch (tipJela){
                    case "P": jelovnik.add(new UredjeniPar<>(new Predjelo(nazivJela, spisakSastojaka), dostupnostJela )); break;
                    case "G": jelovnik.add(new UredjeniPar<>(new GlavnoJelo(nazivJela, spisakSastojaka), dostupnostJela )); break;
                    case "D": jelovnik.add(new UredjeniPar<>(new Dezert(nazivJela, spisakSastojaka), dostupnostJela )); break;
                    default: throw new IllegalArgumentException("Nepoznat tip jela!");
                }
            }

        }catch (IOException e){
            System.err.println("Neuspelo otvaranje datoteke: " + datoteka2 + ".");
            System.exit(1);
        }

        //System.out.println(jelovnik);

        launch();
    }
    @Override
    public void start(Stage primaryStage) throws Exception {


        VBox root = new VBox(10);

        HBox hbGornji = new HBox(10);
        VBox vbPredjelo = new VBox(10);
        VBox vbGlavno = new VBox(10);
        VBox vbDezert = new VBox(10);
        HBox hbRadioDugmici = new HBox(10);
        HBox hbRacun = new HBox(10);
        HBox hbUkupno = new HBox(10);

        root.getChildren().addAll(hbGornji,hbRadioDugmici,hbRacun,hbUkupno);

        hbGornji.getChildren().addAll(vbPredjelo,vbGlavno,vbDezert);

        Label lbPredjelo = new Label("Predjelo:");
        lbPredjelo.setMinSize(150,25);
        Label lbGlavno = new Label("Glavno jelo: ");
        lbGlavno.setMinSize(150,25);
        Label lbDezert = new Label("Dezert:");
        lbDezert.setMinSize(150,25);

        vbPredjelo.getChildren().add(lbPredjelo);
        vbGlavno.getChildren().add(lbGlavno);
        vbDezert.getChildren().add(lbDezert);

        RadioButton rbPopust = new RadioButton("Popust na predjela 9-12h");
        RadioButton rbHappy = new RadioButton("Happy hour 17-18h");


        ToggleGroup tg = new ToggleGroup();
        rbPopust.setToggleGroup(tg);
        rbHappy.setToggleGroup(tg);
        //rbPopust.setSelected(true);

        VBox vbRadioDugmici = new VBox(10);

        vbRadioDugmici.getChildren().addAll(rbPopust,rbHappy);
        hbRadioDugmici.getChildren().addAll(vbRadioDugmici);

        Label lbPrazno = new Label("");
        lbPrazno.setMinSize(350,25);
        Button btRacun = new Button("Racun");

        hbRacun.getChildren().addAll(lbPrazno,btRacun);

        Label lbPrazno1 = new Label("");

        lbPrazno1.setMinSize(300,25);
        Label lbUkupno = new Label("");
        lbUkupno.setTextFill(Color.RED);

        hbUkupno.getChildren().addAll(lbPrazno1,lbUkupno);

        List<UredjeniPar<CheckBox, Jelo>> prikazUJelovniku = new ArrayList<>();

        for (UredjeniPar<Jelo, Boolean> jelo : jelovnik){
            CheckBox cbJelo = new CheckBox(jelo.getPrvi().toString());
            if(!jelo.getDrugi()){
                cbJelo.setDisable(true);
            }

            if(jelo.getPrvi() instanceof Predjelo){
                vbPredjelo.getChildren().add(cbJelo);
            } else if (jelo.getPrvi() instanceof GlavnoJelo) {
                vbGlavno.getChildren().add(cbJelo);
            } else if (jelo.getPrvi() instanceof Dezert) {
                vbDezert.getChildren().add(cbJelo);
            }

            prikazUJelovniku.add(new UredjeniPar<>(cbJelo, (jelo.getPrvi())));
        }

        btRacun.setOnAction(e-> {

            double racun = 0.0;
            for (UredjeniPar<CheckBox, Jelo> prikazanoJelo: prikazUJelovniku){
                CheckBox cbIzabrano = prikazanoJelo.getPrvi();
                Jelo izabranoJelo = prikazanoJelo.getDrugi();
                if(cbIzabrano.isSelected()){
                    if(izabranoJelo instanceof Predjelo){
                        racun += izabranoJelo.izracunajCenu(rbPopust.isSelected());
                    } else if (izabranoJelo instanceof GlavnoJelo) {
                        racun += izabranoJelo.izracunajCenu(rbHappy.isSelected());
                    } else
                        racun += izabranoJelo.izracunajCenu(false);
                }
            }

            String ukupno = String.format("%.1f", racun);

            lbUkupno.setText("UKUPNO: " + ukupno + " din." );


        });


        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Jelovnik");
        primaryStage.show();

    }
}
