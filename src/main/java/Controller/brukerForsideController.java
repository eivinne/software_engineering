package Controller;

import Data.ArrangementData;
import Model.Arrangement;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
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
    @FXML
    private Label utskriftLabel;


    @FXML
    private void initialize() {
        brukerSideArrangementerList.setItems(omgjorArrangementListe(ArrangementData.getArrangementListe()));

        velgKategoriCombo.getItems().add("Alle kategorier");
        velgKategoriCombo.getItems().add("Ski");
        velgKategoriCombo.getItems().add("Løp");
        velgKategoriCombo.getItems().add("Sykkel");
        velgKategoriCombo.getSelectionModel().select(0);

        if (!getUtskriftString().equals("")) {
            utskriftLabel.setText(getUtskriftString());
            setUtskriftString("");
        }
    }


    @FXML
    private void loadMinSide() {
        settPane(rootPane,"../minSide.fxml");
    }

    @FXML
    public void gaaTilArrangementside() {
        setValgtArrangement(brukerSideArrangementerList.getSelectionModel().getSelectedItem());
        if (Controller.getValgtArrangement() != null) {
            settPane(rootPane,"../brukerArrangementSide.fxml");
        }
        else
            utskriftLabel.setText("Velg et arrangement");
    }

    public void sokIArrangementListe(ActionEvent actionEvent) {
        String sokefeltInput = sokIArrangementerTxt.getText();
        String valgtKategori = velgKategoriCombo.getValue();
        ArrayList<Arrangement> sokArrangement = ArrangementData.sokArr(sokefeltInput, valgtKategori);
        if (!sokArrangement.isEmpty()) {
            brukerSideArrangementerList.setItems(omgjorArrangementListe(sokArrangement));
            utskriftLabel.setText("");
        }
        else
        utskriftLabel.setText(getUtskriftString());

    }

    public void visAlleArrangementer(ActionEvent actionEvent) {
        brukerSideArrangementerList.setItems(omgjorArrangementListe(ArrangementData.getArrangementListe()));
    }

    @FXML
    private void loggUt() {
        utlogging(rootPane);
    }


}








