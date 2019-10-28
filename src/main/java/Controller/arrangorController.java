package Controller;

import Data.ArrangementData;
import Model.Arrangement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.awt.image.AreaAveragingScaleFilter;
import java.io.IOException;
import java.util.ArrayList;

public class arrangorController extends Controller{

    @FXML private ListView<Arrangement> mineArrangementerListe;
    @FXML private Button nyttArrangementBtn;
    @FXML private Button seArrangementsideBtn;
    @FXML private TextField navnPaaArrangementTxt;
    @FXML private TextField arrangementDatoTxt;

    @FXML
    private AnchorPane rootPane;

    private static Arrangement valgtArrangement;


    @FXML
    private void initialize() {

        mineArrangementerListe.setItems(omgjorArrangementListe(ArrangementData.hentArrangementData()));

    }

    @FXML
    public void gaaTilArrangementside() {
        valgtArrangement = mineArrangementerListe.getSelectionModel().getSelectedItem();
        if (valgtArrangement != null) {
            settPane(rootPane,"../arrangementSide.fxml");
        }
        else
            System.out.print("Velg et arrangement");
    }

    @FXML
    public void redigerArrangementside() {
        valgtArrangement = mineArrangementerListe.getSelectionModel().getSelectedItem();
        if (valgtArrangement != null) {
            settPane(rootPane,"../redigerArrangement.fxml");
        }
        else
            System.out.print("Velg et arrangement");
    }

    public void opprettNyttArrangement() {
            settPane(rootPane,"../nyttArrangement.fxml");
    }

    public ObservableList<Arrangement> omgjorArrangementListe(ArrayList<Arrangement> arrangementListe) {
        ObservableList<Arrangement> omgjortListe = FXCollections.observableArrayList();

        omgjortListe.addAll(arrangementListe);
        return omgjortListe;
    }

    @FXML
    private void loggUt() {
        settPane(rootPane,"../loginnskjerm.fxml");
        /* AnchorPane pane = FXMLLoader.load(getClass().getResource("../loginnskjerm.fxml"));
        rootPane.getChildren().setAll(pane); */
    }

    public static Arrangement getValgtArrangement(){
        return valgtArrangement;
    }

}
