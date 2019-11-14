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
import java.time.LocalDate;

public class RedigerArrangementController extends Controller {

    @FXML
    private ImageView arrangementBildeImg;
    @FXML
    private Label arrangementTittelLabel;
    @FXML
    private TextField arrangementTittelTxt;
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
        sorgForBareTallInput(antallPlasserTxt);
    }

    @FXML
    public void slettArrangement(){
        valgt.slettArrangement();
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


        if(arrangementTittelTxt.getText().equals("") || arrangementBeskrivelseTxt.getText().equals("") || arrangementStedTxt.getText().equals("") || arrangementDatoPicker.getValue() == null ||arrangementDatoPicker.getValue().equals("") || antallPlasserTxt.getText().equals("") || arrangementTidspunktTxt.getText().equals("") || lopsKategori.getSelectedToggle() == null) {
            utskriftLabel.setText("Alle felter må være fylt inn.");

        }


        else {
            String tittel = arrangementTittelTxt.getText();
            String beskrivelse = arrangementBeskrivelseTxt.getText();
            LocalDate dato = arrangementDatoPicker.getValue();
            String tidspunkt = arrangementTidspunktTxt.getText();
            String lokasjon = arrangementStedTxt.getText();
            int antallPlasser = Integer.parseInt(antallPlasserTxt.getText());

            RadioButton selected = (RadioButton) lopsKategori.getSelectedToggle();
            String kategori = selected.getText();

            if (antallPlasser <= 0)
                utskriftLabel.setText("Antall plasser må fylles ut med et tall større enn 0.");
            else {
                valgt.redigerArrangement(tittel, beskrivelse, dato, tidspunkt, lokasjon, antallPlasser, kategori);
                settPane(rootPane, "../arrangorView.fxml");
            }
        }
    }


}
