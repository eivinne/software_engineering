package Controller;

import Model.Arrangement;
import Model.Deltager;
import Model.Person;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

public class BetalingsLosningsController extends Controller{

    @FXML
    private AnchorPane rootPane;
    private Arrangement valgt = getValgtArrangement();
    private Deltager innlogget = (Deltager) Person.getInnlogget();

    public void betalingGodkjent(ActionEvent actionEvent) {
        innlogget.meldPaaArrangement(valgt);
        settPane(rootPane, "../minSide.fxml");

    }

    public void betalingAvslatt(ActionEvent actionEvent) {
        innlogget.betalingIkkeGodkjent();
        settPane(rootPane, "../brukerForside.fxml");
    }
}
