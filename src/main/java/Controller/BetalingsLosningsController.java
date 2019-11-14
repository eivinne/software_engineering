package Controller;

import Model.Arrangement;
import Model.Deltager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

public class BetalingsLosningsController extends Controller{

    @FXML
    private AnchorPane rootPane;
    private Arrangement valgt = getValgtArrangement();
    private Deltager innlogget = (Deltager) getInnlogget();

    public void betalingGodkjent(ActionEvent actionEvent) {
        innlogget.hvisBetalingStatusGodkjentMeldPaaArrangement(true, valgt);
        settPane(rootPane, "../minSide.fxml");

    }

    public void betalingAvslatt(ActionEvent actionEvent) {
        innlogget.hvisBetalingStatusGodkjentMeldPaaArrangement(false, valgt);
        settPane(rootPane, "../brukerForside.fxml");
    }
}
