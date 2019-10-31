package Controller;

import Data.ArrangementData;
import Model.Arrangement;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class RedigerArrangementController extends Controller {

    @FXML
    Label arrangementTittelLabel;
    @FXML
    TextField arrangementTittelTxt;
    @FXML
    ImageView arrangementBildeImg;
    @FXML
    DatePicker arrangementDatoPicker;
    @FXML
    TextField arrangementTidspunktTxt;
    @FXML
    TextField arrangementStedTxt;
    @FXML
    TextField antallPlasserTxt;
    @FXML
    TextArea arrangementBeskrivelseTxt;
    @FXML
    ToggleGroup lopsKategori;
    @FXML
    RadioButton skiRadioBtn, lopRadioBtn, sykkelRadioBtn;

    @FXML
    private AnchorPane rootPane;

    private Arrangement valgt = getValgtArrangement();

    @FXML
    private void initialize() {
        fyllInnArrangementInfo(valgt);

    }

    @FXML
    public void slettArrangement(){
        ArrangementData.getArrangementListe().remove(valgt);
        settPane(rootPane,"../arrangorView.fxml");
    }

    @FXML
    private void tilbakeTilMineArrangementer() throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../arrangorView.fxml"));
        rootPane.getChildren().setAll(pane);
    }

    public void fyllInnArrangementInfo(Arrangement etArrangement) {
        arrangementTittelLabel.setText(etArrangement.getTittel());
        arrangementDatoPicker.setValue(etArrangement.getDato());
        arrangementTidspunktTxt.setText(etArrangement.getTidspunkt());
        arrangementStedTxt.setText(etArrangement.getLokasjon());
        arrangementBeskrivelseTxt.setText(etArrangement.getBeskrivelse());
        arrangementTittelTxt.setText(etArrangement.getTittel());
        antallPlasserTxt.setText(String.valueOf(etArrangement.getKapasitet()));
    }

    public void redigerArrangement(ActionEvent actionEvent) {
        if(arrangementTittelTxt.getText().equals("") || arrangementBeskrivelseTxt.getText().equals("") || arrangementStedTxt.getText().equals("") || arrangementDatoPicker.getValue().equals("") || antallPlasserTxt.getText().equals("") ||arrangementTidspunktTxt.getText().equals("") || lopsKategori.getSelectedToggle() == null) {
            System.out.println("Alle felter må være fylt inn.");
        }else {
            valgt.setTittel(arrangementTittelTxt.getText());
            valgt.setBeskrivelse(arrangementBeskrivelseTxt.getText());
            valgt.setDato(arrangementDatoPicker.getValue());
            valgt.setTidspunkt(arrangementTidspunktTxt.getText());
            valgt.setLokasjon(arrangementStedTxt.getText());
            valgt.setKapasitet(Integer.parseInt(antallPlasserTxt.getText()));

            RadioButton selected = (RadioButton) lopsKategori.getSelectedToggle();
            valgt.setKategori(selected.getText());

            settPane(rootPane,"../arrangorView.fxml");
        }
    }


    /*public void redigerArrangement(ActionEvent actionEvent) {
        if(!arrangementTittelTxt.getText().equals("")) {
            valgt.setTittel(arrangementTittelTxt.getText());
        }

        if(!arrangementBeskrivelseTxt.getText().equals("")) {
            valgt.setBeskrivelse(arrangementBeskrivelseTxt.getText());
        }
        if(arrangementDatoPicker.getValue() != null) {
            valgt.setDato(arrangementDatoPicker.getValue());
        }
        if(!arrangementTidspunktTxt.getText().equals("")) {
            valgt.setTidspunkt(arrangementTidspunktTxt.getText());
        }
        if(!arrangementStedTxt.getText().equals("")) {
            valgt.setLokasjon(arrangementStedTxt.getText());
        }

        if (lopsKategori.getSelectedToggle() != null) {
            RadioButton selected = (RadioButton) lopsKategori.getSelectedToggle();
            valgt.setKategori(selected.getText());
        }

        settPane(rootPane,"../arrangorView.fxml");
    }*/

}
