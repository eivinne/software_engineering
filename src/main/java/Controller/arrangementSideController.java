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

public class arrangementSideController {

    @FXML
    Label arrangementTittelLabel;
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
    private Arrangement valgt = arrangorController.getValgtArrangement();


    @FXML
    private void initialize() {
    arrangementTittelLabel.setText(valgt.getTittel());
    arrangementDatoTxt.setText(valgt.getDato());
    arrangementTidspunktTxt.setText(valgt.getTidspunkt());
    arrangementStedTxt.setText(valgt.getLokasjon());
    }

    @FXML
    private void tilbakeTilMineArrangementer() throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../arrangorView.fxml"));
        rootPane.getChildren().setAll(pane);
    }

    public void fyllInnArrangementInfo(Arrangement etArrangement) {
        arrangementTittelLabel.setText(etArrangement.getTittel());
        arrangementDatoTxt.setText(etArrangement.getDato());
        arrangementTidspunktTxt.setText(etArrangement.getTidspunkt());
        arrangementStedTxt.setText(etArrangement.getLokasjon());
        arrangementBeskrivelseTxt.setText(etArrangement.getBeskrivelse());
    }

}