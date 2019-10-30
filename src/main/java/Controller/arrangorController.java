package Controller;

import Data.ArrangementData;
import Model.Arrangement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.util.ArrayList;

public class arrangorController extends Controller{

    @FXML private ListView<Arrangement> mineArrangementerListe;
    @FXML private Button nyttArrangementBtn;
    @FXML private Button seArrangementsideBtn;
    @FXML private TextField navnPaaArrangementTxt;
    @FXML private TextField arrangementDatoTxt;

    @FXML
    private AnchorPane rootPane;




    @FXML
    private void initialize() {

        mineArrangementerListe.setItems(omgjorArrangementListe(ArrangementData.getArrangementListe()));

    }

    @FXML
    public void gaaTilArrangementside() {
        setValgtArrangement(mineArrangementerListe.getSelectionModel().getSelectedItem());
        //System.out.println(valgtArrangement);
        gaaTilArrangementside(rootPane);
    }

    @FXML
    public void redigerArrangementside() {
        setValgtArrangement(mineArrangementerListe.getSelectionModel().getSelectedItem());
        if (getValgtArrangement() != null) {
            settPane(rootPane,"../redigerArrangement.fxml");
        }
        else
            System.out.print("Velg et arrangement");
    }

    public void opprettNyttArrangement() {
            settPane(rootPane,"../nyttArrangement.fxml");
    }



    @FXML
    private void loggUt() {
        utlogging(rootPane);
    }


}
