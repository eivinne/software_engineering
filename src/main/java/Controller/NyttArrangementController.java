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
    private TextArea arrangementBeskrivelseTxt;
    @FXML
    private ToggleGroup lopsKategori;
    @FXML
    private Label utskriftLabel;
    @FXML
    private AnchorPane rootPane;


    @FXML
    private void initialize() {
        arrangementTittelLabel.setText("Nytt Arrangement");

    }

    @FXML
    private void tilbakeTilMineArrangementer() {
        settPane(rootPane,"../arrangorView.fxml");
    }

    public void hentInput() {

        String tittel = arrangementTittelTxt.getText();
        String beskrivelse = arrangementBeskrivelseTxt.getText();
        LocalDate dato = arrangementDatoPicker.getValue();
        String tidspunkt = arrangementTidspunktTxt.getText();
        String sted = arrangementStedTxt.getText();
        String kategori = "";
        if (lopsKategori.getSelectedToggle() != null) {
             kategori =String.valueOf(lopsKategori.getSelectedToggle());
        }
        if(!tittel.equals("") && !beskrivelse.equals("") && dato!=null && !tidspunkt.equals("") && !sted.equals("") && !kategori.equals("")) {
            Arrangement nyttArrangement = new Arrangement(tittel, beskrivelse, dato, tidspunkt, sted, kategori, Controller.getInnlogget(), 150);
            settPane(rootPane, "../arrangorView.fxml");
        }
        else
            utskriftLabel.setText("Fyll inn alle felt");
    }
}
