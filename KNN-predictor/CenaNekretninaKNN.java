package oop_sep1_23_Polic_Visnja_mp22435;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class CenaNekretninaKNN extends Application {

    public static void main(String[] args) {
        launch();
    }


    @Override
    public void start(Stage primaryStage) throws Exception {

        VBox root = new VBox(10);
        root.setPadding(new Insets(10,10,10,10));
/*

        HBox hbKvadratura = new HBox(10);
        HBox hbStruktura = new HBox(10);
        HBox hbSpratnost = new HBox(10);
        HBox hbUdaljenost = new HBox(10);
        HBox hbCena = new HBox(10);
        HBox hbBaza = new HBox(10);

        root.getChildren().addAll(hbKvadratura, hbStruktura, hbSpratnost, hbUdaljenost, hbCena, hbBaza);

        Label lbKvadratura = new Label("Kvadratura:");
        TextField tfKvadratura = new TextField("");
        Label lbIzbor = new Label("Izbor metrike:");

        hbKvadratura.getChildren().addAll(lbKvadratura,tfKvadratura, lbIzbor);

        Label lbStruktura = new Label("Struktura:");
        TextField tfStruktura = new TextField("");
        RadioButton rbEuklidska = new RadioButton("Euklidska metrika");

        hbStruktura.getChildren().addAll(lbStruktura,tfStruktura,rbEuklidska);

        Label lbSpratnost = new Label("Spratnost:");
        TextField tfSpratnost = new TextField("");
        RadioButton rbMenhetn = new RadioButton("Menhetn metrika");

        hbSpratnost.getChildren().addAll(lbSpratnost, tfSpratnost, rbMenhetn);

        ToggleGroup tg = new ToggleGroup();
        rbEuklidska.setToggleGroup(tg);
        rbMenhetn.setToggleGroup(tg);
        rbEuklidska.setSelected(true);

*/

        HBox hbPrvi = new HBox(10);
        HBox hbDrugi = new HBox(10);
        HBox hbTreci = new HBox(10);

        root.getChildren().addAll(hbPrvi,hbDrugi,hbTreci);

        VBox vbLabele = new VBox(10);
        VBox vbIzbori = new VBox(10);

        hbPrvi.getChildren().addAll(vbLabele,vbIzbori);

        Label lbKvadratura = new Label("Kvadratura:");
        Label lbStruktura = new Label("Struktura:");
        Label lbSpratnost = new Label("Spratnost:");
        Label lbUdaljenost = new Label("Udaljenost od centra:");

        lbKvadratura.setMinSize(150,25);
        lbStruktura.setMinSize(150,25);
        lbSpratnost.setMinSize(150,25);
        lbUdaljenost.setMinSize(150,25);


        TextField tfKvadratura = new TextField("");
        TextField tfStruktura = new TextField("");
        TextField tfSpratnost = new TextField("");
        TextField tfUdaljenost = new TextField("");

        HBox hbKvadratura = new HBox(10);
        HBox hbStruktura = new HBox(10);
        HBox hbSpratnost = new HBox(10);
        HBox hbUdaljenost = new HBox(10);

        hbKvadratura.getChildren().addAll(lbKvadratura, tfKvadratura);
        hbStruktura.getChildren().addAll(lbStruktura,tfStruktura);
        hbSpratnost.getChildren().addAll(lbSpratnost,tfSpratnost);
        hbUdaljenost.getChildren().addAll(lbUdaljenost,tfUdaljenost);

        vbLabele.getChildren().addAll(hbKvadratura,hbStruktura,hbSpratnost,hbUdaljenost);

        Label lbIzbor = new Label("Izbor metrike:");
        RadioButton rbEuklidska = new RadioButton("Euklidska metrika");
        RadioButton rbMenhetn = new RadioButton("Menhetn metrika");
        Label lbParametar = new Label("Vrednost parametra k:");
        TextField tfParametar = new TextField("");
        ToggleGroup tg = new ToggleGroup();
        rbEuklidska.setToggleGroup(tg);
        rbMenhetn.setToggleGroup(tg);
        rbEuklidska.setSelected(true);

        vbIzbori.getChildren().addAll(lbIzbor,rbEuklidska,rbMenhetn, lbParametar, tfParametar);

        Button btPredvidi = new Button("Predvidi cenu");
        Button btBaza = new Button("Ucitaj bazu podataka");

        Label lbCena = new Label("");
        lbCena.setTextFill(Color.BLUE);
        lbCena.setMinSize(150,25);
        Label lbGreska = new Label("");
        lbGreska.setTextFill(Color.RED);
        lbGreska.setMinSize(350,25);

        hbDrugi.getChildren().addAll(btPredvidi, lbCena);
        hbTreci.getChildren().addAll(lbGreska, btBaza);

        VektorskiProstor vp = new VektorskiProstor();

        btBaza.setOnAction(e->{
            btBaza.setDisable(true);
            vp.ucitajIzFajla("src/nekretnine.txt");
            System.out.println(vp);

        });

        btPredvidi.setOnAction(e->{
            try {
                double kvadratura = Double.parseDouble(tfKvadratura.getText().trim());
                double struktura = Double.parseDouble(tfStruktura.getText().trim());
                double spratnost = Double.parseDouble(tfSpratnost.getText().trim());
                double udaljenost = Double.parseDouble(tfUdaljenost.getText().trim());
                int k = Integer.parseInt(tfParametar.getText().trim());

                Vektor targetVektor = new Vektor();
                targetVektor.dodajElement(kvadratura);
                targetVektor.dodajElement(struktura);
                targetVektor.dodajElement(spratnost);
                targetVektor.dodajElement(udaljenost);

                Metrika metrika;

                if (rbEuklidska.isSelected())
                    metrika = new EuklidskaMetrika();
                else
                    metrika = new MenhetnMetrika();

                KNNPredikator prediktor = new KNNPredikator(vp, metrika, k);

                double cena = prediktor.predvidjanjeCiljnePromen(targetVektor);

                lbCena.setText(String.format("%.2f",cena));

            }catch (NumberFormatException exception){
                lbGreska.setText("Nedozvoljen format brojcanih unosa!");
            }

        });


        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("KNN prediktor cena nekretnina");
        primaryStage.show();

    }
}
