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
    private Label arrangementTittelLabel;
    @FXML
    private TextField arrangementTittelTxt;
    @FXML
    private ImageView arrangementBildeImg;
    @FXML
    private DatePicker arrangementDatoPicker;
    @FXML
    private TextField arrangementTidspunktTxt;
    @FXML
    private TextField arrangementStedTxt;
    @FXML
    private TextField antallPlasserTxt;
    @FXML
    private TextArea arrangementBeskrivelseTxt;
    @FXML
    private ToggleGroup lopsKategori;
    @FXML
    private RadioButton skiRadioBtn, lopRadioBtn, sykkelRadioBtn;
    @FXML
    private Label utskriftLabel;

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
    private void tilbakeTilMineArrangementer() {
        settPane(rootPane,"../arrangorView.fxml");
    }

    public void fyllInnArrangementInfo(Arrangement etArrangement) {
        arrangementTittelLabel.setText(etArrangement.getTittel());
        arrangementDatoPicker.setValue(etArrangement.getDato());
        arrangementTidspunktTxt.setText(etArrangement.getTidspunkt());
        arrangementStedTxt.setText(etArrangement.getLokasjon());
        arrangementBeskrivelseTxt.setText(etArrangement.getBeskrivelse());
        arrangementTittelTxt.setText(etArrangement.getTittel());
        antallPlasserTxt.setText(String.valueOf(etArrangement.getKapasitet()));
        if(etArrangement.getKategori() == "Løp") {
            lopsKategori.selectToggle(lopRadioBtn);
        }
        else if (etArrangement.getKategori() == "Ski"){
            lopsKategori.selectToggle(skiRadioBtn);
        } else {
            lopsKategori.selectToggle(sykkelRadioBtn);
        }
    }

    public void redigerArrangement(ActionEvent actionEvent) {
        String antallPlasser = antallPlasserTxt.getText();
        int antallPlasserInt = 0;

        try{
            antallPlasserInt = Integer.parseInt(antallPlasser);
        } catch (NumberFormatException nfe) {
            System.out.println("");
        }

        if(arrangementTittelTxt.getText().equals("") || arrangementBeskrivelseTxt.getText().equals("") || arrangementStedTxt.getText().equals("") || arrangementDatoPicker.getValue() == null ||arrangementDatoPicker.getValue().equals("") || antallPlasserTxt.getText().equals("") || arrangementTidspunktTxt.getText().equals("") || lopsKategori.getSelectedToggle() == null) {
            utskriftLabel.setText("Alle felter må være fylt inn.");

        }else if (antallPlasserInt <= 0){
            utskriftLabel.setText("Antall plasser må fylles ut med et tall og det må være større enn 0.");
        }
        else {
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
