package oop_Milica_Polic_Visnja_mp22435;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Vakcinacija extends Application {

    private List<Vakcina> vakcine = new ArrayList<>();
    private List<Grad> gradovi = new ArrayList<>();


    public static void main(String[] args) {
        launch();
    }
    @Override
    public void start(Stage primaryStage) throws Exception {


        // OKVIR
        VBox root = new VBox(10);
        root.setAlignment(Pos.CENTER);

        // delovi:
        HBox hbKomande = new HBox(10);
        hbKomande.setAlignment(Pos.CENTER);

        TextArea taGornji = new TextArea("");

        HBox hbVakcinisi = new HBox(10);
        hbVakcinisi.setAlignment(Pos.CENTER);

        TextArea taDonji = new TextArea("");

        root.getChildren().addAll(hbKomande, taGornji, hbVakcinisi, taDonji);

        // hbKomande:
        ToggleGroup tg = new ToggleGroup();
        RadioButton rbSortirano = new RadioButton("sortirano");
        RadioButton rbOriginalno = new RadioButton("originalno");

        rbSortirano.setToggleGroup(tg);
        rbOriginalno.setToggleGroup(tg);
        rbSortirano.setSelected(true);

        Button btUcitaj = new Button("Ucitaj");
        Button btIzvestaj = new Button("Izvestaj");

        hbKomande.getChildren().addAll(btUcitaj, rbSortirano, rbOriginalno, btIzvestaj);

        // hbVakcinisi
        Label lbGrad = new Label("Grad:");
        TextField tfGrad = new TextField("");
        Label lbJMBG = new Label("JMBG");
        TextField tfJMBG = new TextField("");
        Button btVakcinisi = new Button("Vakcinisi");

        hbVakcinisi.getChildren().addAll(lbGrad, tfGrad, lbJMBG, tfJMBG, btVakcinisi);

        // ------------------------------------------------------------------------

        btUcitaj.setOnAction(e->{
            Path datoteka = Paths.get("src/vakcine.txt");

            try {
                List<String> linije = Files.readAllLines(datoteka);
                vakcine = new ArrayList<>();
                for (String linija: linije){
                    String[] reci = linija.split(", ");

                    if(reci.length == 2){
                        Fajzer fajzer = new Fajzer(reci[0], Jacina.izBroja(Integer.parseInt(reci[1].trim())));
                        vakcine.add(fajzer);
                    } else if (reci.length == 3) {
                        SputnjikV sputnjik = new SputnjikV(reci[0].trim(), reci[1].trim(), Integer.parseInt(reci[2].trim()));
                        vakcine.add(sputnjik);
                    } else throw new RuntimeException("Dstoteka nije u pravilnom formatu!");
                }

                if(rbSortirano.isSelected()){
                    Comparator<Vakcina> komparator = new KomparatorVakcina();
                    Collections.sort(vakcine,komparator);
                }

                for (Vakcina vakcina : vakcine){
                    taGornji.appendText(vakcina.toString() + "\n");
                }
            } catch (Exception ex) {
                ex.getMessage();
            }
        });

        btVakcinisi.setOnAction(e->{
            String imeGrada = tfGrad.getText();
            String JMBG = tfJMBG.getText();

            Grad grad = null;
            for (Grad gr : gradovi) {
                if (gr.getIme().compareTo(imeGrada) == 0) { // znaci da du isti i ne treba da ga dodam u listu
                    grad = gr;
                }
            }

            // ako nakon ovog if uslovaje grad i dalje null, znaci da nije pronadjen u listi, pa treba da ga dodam
            if(grad == null){
                grad = new Grad(imeGrada);
                gradovi.add(grad);
            }


            if(vakcine.isEmpty()){
                taDonji.appendText("Nema vise vakcina!\n");
                return;
            }

            Vakcina v = vakcine.remove(0); // ovo ce da procita koja je vakcina u pitanju

            boolean uspehVakcinacije = v.vakcinisi(); // i u odnosu na to ce da proveri da li je vakcinacija uspesna

            grad.dodajOsobu(JMBG, uspehVakcinacije);

            taDonji.appendText(grad.getIme() + ": " +  JMBG + " je vakcinisan vakcinom " + v.getIdentifikator() + ".\n");
            if(uspehVakcinacije){
                taDonji.appendText("Vakcinacija je uspesna!\n");
            } else {
                taDonji.appendText("Vakcinacija nije uspesna!\n");
            }


        });

        btIzvestaj.setOnAction(e->{
            taDonji.setText("");
            for (Grad grad: gradovi){
                taDonji.appendText(grad.toString() + " \n");
                taDonji.appendText("Uspesno vakcinisanih: " + grad.getBrojUspesnoVakcinisanih() + "\n");
            }

            taDonji.appendText("\nUkupno vakcinisanih: " + Vakcina.broj);

        });

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Vakcinacija");
        primaryStage.show();

    }
}
