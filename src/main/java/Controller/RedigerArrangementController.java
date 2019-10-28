package Controller;

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
    TextArea arrangementBeskrivelseTxt;
    @FXML
    ToggleGroup lopsKategori;

    @FXML
    private AnchorPane rootPane;

    private Arrangement valgt = arrangorController.getValgtArrangement();

    @FXML
    private void initialize() {
        fyllInnArrangementInfo(valgt);

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
    }

    public void redigerArrangement(ActionEvent actionEvent) {
        if(arrangementTittelTxt.getText() != null) {
            valgt.setTittel(arrangementTittelTxt.getText());
        }

        if(arrangementBeskrivelseTxt.getText() != null) {
            valgt.setBeskrivelse(arrangementBeskrivelseTxt.getText());
        }
        if(arrangementDatoPicker.getValue() != null) {
            valgt.setDato(arrangementDatoPicker.getValue());
        }
        if(arrangementTidspunktTxt.getText() != null) {
            valgt.setTidspunkt(arrangementTidspunktTxt.getText());
        }
        if(arrangementStedTxt.getText() != null) {
            valgt.setLokasjon(arrangementStedTxt.getText());
        }

        RadioButton selectedRadioButton = (RadioButton) lopsKategori.getSelectedToggle();
        valgt.setKategori(selectedRadioButton.getText());

        settPane(rootPane,"../arrangorView.fxml");
    }

}
