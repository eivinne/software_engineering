package Controller;

import Data.ArrangementData;
import Model.Arrangement;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.lang.reflect.Array;
import java.time.LocalDate;

public class NyttArrangementController extends Controller {

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
    TextArea arrangementBeskrivelseTxt;
    @FXML
    ToggleGroup lopsKategori;

    @FXML
    private AnchorPane rootPane;

    @FXML
    private void initialize() {
        arrangementTittelLabel.setText("Nytt Arrangement");

    }

    @FXML
    private void tilbakeTilMineArrangementer() throws IOException {
        settPane(rootPane,"../arrangorView.fxml");
    }

    public void hentInput() {

        String tittel = "";
        String beskrivelse = "";
        LocalDate dato = LocalDate.now();
        String tidspunkt = "";
        String sted = "";
        String kategori = "";
        if(arrangementTittelTxt.getText() != null) {
            tittel = arrangementTittelTxt.getText();
        }

        if(arrangementBeskrivelseTxt.getText() != null) {
            beskrivelse = arrangementBeskrivelseTxt.getText();
        }
        if(arrangementDatoPicker.getValue() != null) {
            dato = arrangementDatoPicker.getValue();
        }
        if(arrangementTidspunktTxt.getText() != null) {
            tidspunkt = arrangementTidspunktTxt.getText();
        }
        if(arrangementStedTxt.getText() != null) {
            sted = arrangementStedTxt.getText();
        }

        RadioButton selectedRadioButton = (RadioButton) lopsKategori.getSelectedToggle();
        if (selectedRadioButton != null)
        kategori = selectedRadioButton.getText();


        Arrangement nyttArrangement = new Arrangement(tittel, beskrivelse, dato, tidspunkt, sted, kategori,Controller.getInnlogget(),150);

        settPane(rootPane,"../arrangorView.fxml");
    }
}
