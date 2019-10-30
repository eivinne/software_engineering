package Controller;

import Data.ArrangementData;
import Model.Arrangement;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

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


public class brukerForsideController extends Controller{

    @FXML
    private Button gaaTilMinSideBtn, loggUtBtn, sokIArrangementerBtn, visAlleArrangementBtn, gaaTilArrangementBtn;

    @FXML
    private AnchorPane rootPane;

    @FXML
    private TextField sokIArrangementerTxt;

    @FXML
    private ListView<Arrangement> brukerSideArrangementerList;

    @FXML
    private ComboBox<String> velgKategoriCombo = new ComboBox<>();

    private static Arrangement valgtArrangement;

    @FXML
    private void initialize() {

        brukerSideArrangementerList.setItems(omgjorArrangementListe(ArrangementData.getArrangementListe()));

        velgKategoriCombo.getItems().add("Alle kategorier");
        velgKategoriCombo.getItems().add("Ski");
        velgKategoriCombo.getItems().add("Løp");
        velgKategoriCombo.getItems().add("Sykkel");
    }


    @FXML
    private void loadMinSide() {
        settPane(rootPane,"../minSide.fxml");
       /* AnchorPane pane = FXMLLoader.load(getClass().getResource("../minSide.fxml"));
        rootPane.getChildren().setAll(pane); */
    }

    @FXML
    private void loggUt() {
        utlogging(rootPane);
    }

    @FXML
    public void gaaTilArrangementside() {
        valgtArrangement = brukerSideArrangementerList.getSelectionModel().getSelectedItem();
        System.out.println(valgtArrangement);
        gaaTilArrangementside(valgtArrangement, rootPane);
    }

}








