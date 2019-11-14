package Controller;

import Model.Arrangement;
import Model.Deltager;
import Model.Person;
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
    private Deltager innloggetDeltager = (Deltager) Person.getInnlogget();


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
        ledigePlasserTxt.setText(String.valueOf(etArrangement.antallLedigePlasser()));
    }

    public void meldPaaArrangementKnappTrykket(ActionEvent actionEvent) {
        if (innloggetDeltager.alleredePaameldt(valgt)){
            setUtskriftString("Du er allerede meldt på dette arrangementet");
        }
        else if(valgt.sjekkOmArrangementErFulltEllerHarVaert()) {
            sendTilBetalingsLosning();
        }
        utskriftLabel.setText(getUtskriftString());
        setUtskriftString("");

    }

    public void sendTilBetalingsLosning() {
        settPane(rootPane, "../betalingsLosning.fxml");
    }

    public void interessertIArrangementKnappTrykket(ActionEvent actionEvent) {

        innloggetDeltager.meldInteresse(valgt);
        utskriftLabel.setText(getUtskriftString());
        setUtskriftString("");

    }
}

