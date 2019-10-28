package Controller;

import Data.ArrangementData;
import Model.Arrangement;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.lang.reflect.Array;

public class NyttArrangementController extends Controller {

    @FXML
    Label arrangementTittelLabel;
    @FXML
    TextField arrangementTittelTxt;
    @FXML
    ImageView arrangementBildeImg;
    @FXML
    TextField arrangementDatoTxt;
    @FXML
    TextField arrangementTidspunktTxt;
    @FXML
    TextField arrangementStedTxt;
    @FXML
    TextArea arrangementBeskrivelseTxt;

    @FXML
    private AnchorPane rootPane;

    @FXML
    private void initialize() {
        arrangementTittelLabel.setText("Nytt Arrangement");

    }

    @FXML
    private void tilbakeTilMineArrangementer() throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../arrangorView.fxml"));
        rootPane.getChildren().setAll(pane);
    }

    public void hentInput() throws IOException {

        String tittel = "";
        String beskrivelse = "";
        String dato = "";
        String tidspunkt = "";
        String sted = "";
        if(arrangementTittelTxt.getText() != null) {
            tittel = arrangementTittelTxt.getText();
        }

        if(arrangementBeskrivelseTxt.getText() != null) {
            beskrivelse = arrangementBeskrivelseTxt.getText();
        }
        if(arrangementDatoTxt.getText() != null) {
            dato = arrangementDatoTxt.getText();
        }
        if(arrangementTidspunktTxt.getText() != null) {
            tidspunkt = arrangementTidspunktTxt.getText();
        }
        if(arrangementStedTxt.getText() != null) {
            sted = arrangementStedTxt.getText();
        }

        Arrangement nyttArrangement = new Arrangement(tittel, beskrivelse, dato, tidspunkt, sted);

        settPane(rootPane,"../arrangorView.fxml");
    }
}
