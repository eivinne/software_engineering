package Controller;

import Model.Arrangement;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class arrangementSideController extends Controller {

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
    TextField ledigePlasserTxt;
    @FXML
    TextArea arrangementBeskrivelseTxt;

    @FXML
    private AnchorPane rootPane;
    private Arrangement valgt = getValgtArrangement();


    @FXML
    private void initialize() {
    fyllInnArrangementInfo(valgt);

    }

    @FXML
    private void tilbakeTilMineArrangementer() {
        settPane(rootPane,"../arrangorView.fxml");

    }

    public void fyllInnArrangementInfo(Arrangement etArrangement) {
        arrangementTittelLabel.setText(etArrangement.getTittel());
        arrangementDatoTxt.setText(etArrangement.getDato().toString());
        arrangementTidspunktTxt.setText(etArrangement.getTidspunkt());
        arrangementStedTxt.setText(etArrangement.getLokasjon());
        arrangementBeskrivelseTxt.setText(etArrangement.getBeskrivelse());
        ledigePlasserTxt.setText(String.valueOf(etArrangement.antallLedigePlasser()));

    }

}