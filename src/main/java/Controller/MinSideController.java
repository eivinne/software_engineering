package Controller;

import Model.Arrangement;
import Model.Deltager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;

public class MinSideController extends Controller {

    @FXML
    private AnchorPane rootPane;

    @FXML
    private Button tilbakeTilAlleArrangementerBtn;

    @FXML
    private ListView<Arrangement> interesserteArrangementerListe;
    @FXML
    private ListView<Arrangement> paaMeldteArrangementerListe;

    @FXML
    private ListView<Arrangement> tidligereArrangementListe;

    private Deltager innloggetBruker = (Deltager) Controller.getInnlogget();

    @FXML
    private void initialize() {
        interesserteArrangementerListe.setItems(omgjorArrangementListe(innloggetBruker.getInteresserteArrangement()));
        paaMeldteArrangementerListe.setItems(omgjorArrangementListe(innloggetBruker.getPaameldteArrangement()));
        tidligereArrangementListe.setItems(omgjorArrangementListe(innloggetBruker.getFerdigeArrangement()));

    }

    public void tilbakeTilAlleArrangementer(ActionEvent actionEvent) {
        settPane(rootPane, "../brukerForside.fxml");
    }
}
