package Controller;

import Model.Arrangement;
import Model.Deltager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class brukerArrangementSideController extends Controller {

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
    private Label utskriftLabel;

    @FXML
    private AnchorPane rootPane;
    private Arrangement valgt = arrangorController.getValgtArrangement();


    @FXML
    private void initialize() {
        fyllInnArrangementInfo(valgt);

    }

    public void tilbakeTilAlleArrangementer(ActionEvent actionEvent) {

        settPane(rootPane,"../brukerForside.fxml");

    }

    public void fyllInnArrangementInfo(Arrangement etArrangement) {
        arrangementTittelLabel.setText(etArrangement.getTittel());
        arrangementDatoTxt.setText(etArrangement.getDato().toString());
        arrangementTidspunktTxt.setText(etArrangement.getTidspunkt());
        arrangementStedTxt.setText(etArrangement.getLokasjon());
        arrangementBeskrivelseTxt.setText(etArrangement.getBeskrivelse());
        ledigePlasserTxt.setText(String.valueOf(etArrangement.antallLedigePlasser(etArrangement)));
    }

    public void meldPaaArrangement(ActionEvent actionEvent) {
        if (valgt.getPaameldteListe().contains(getInnlogget())){
            utskriftLabel.setText("Du er allerede meldt på dette arrangementet");
        }
        else if(valgt.sjekkOmArrangementErFulltEllerHarVaert()) {
            sendTilBetalingsLosning();
        }
        else {
            settPane(rootPane,"../brukerForside.fxml");
        }
    }

    public void sendTilBetalingsLosning() {
        settPane(rootPane, "../betalingsLosning.fxml");
    }

    public void interessertIArrangement(ActionEvent actionEvent) {
        Deltager innloggetBruker = (Deltager) getInnlogget();
        innloggetBruker.meldInteresse(valgt);

    }
}

