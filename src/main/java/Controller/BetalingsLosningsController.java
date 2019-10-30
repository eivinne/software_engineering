package Controller;

import Model.Arrangement;
import Model.Deltager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

public class BetalingsLosningsController extends Controller{

    @FXML
    private AnchorPane rootPane;
    private Arrangement valgt = arrangorController.getValgtArrangement();

    public void betalingGodkjent(ActionEvent actionEvent) {
        valgt.hvisBetalingStatusGodkjentMeldPaaArrangement(true, (Deltager) getInnlogget());
        settPane(rootPane, "../minSide.fxml");

    }

    public void betalingAvslatt(ActionEvent actionEvent) {
        valgt.hvisBetalingStatusGodkjentMeldPaaArrangement(false, (Deltager) getInnlogget());
        settPane(rootPane, "../brukerForside.fxml");
    }
}
