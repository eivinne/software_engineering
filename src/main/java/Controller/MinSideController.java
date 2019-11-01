package Controller;

import Model.Arrangement;
import Model.Deltager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;

public class MinSideController extends Controller {

    @FXML
    private AnchorPane rootPane;

    @FXML
    private Label listeLabel;

    @FXML
    private ListView<Arrangement> minSideArrangementerListe;
    @FXML
    private Label utskriftLabel;
    private Deltager innloggetBruker = (Deltager) Controller.getInnlogget();

    @FXML
    private void initialize() {
        minSideArrangementerListe.setItems(omgjorArrangementListe(innloggetBruker.getPaameldteArrangement()));
        if (!getUtskriftString().equals("")) {
            utskriftLabel.setText(getUtskriftString());
            setUtskriftString("");
        }
    }


    public void visPaameldteArrangement(ActionEvent actionEvent) {
        minSideArrangementerListe.setItems(omgjorArrangementListe(innloggetBruker.getPaameldteArrangement()));
        listeLabel.setText("Påmeldte Arrangement");
    }

    public void visInteressertArrangementBtn(ActionEvent actionEvent) {
        minSideArrangementerListe.setItems(omgjorArrangementListe(innloggetBruker.getInteresserteArrangement()));
        listeLabel.setText("Interesserte Arrangement");
    }

    public void visTidligereArrangement(ActionEvent actionEvent) {
        minSideArrangementerListe.setItems(omgjorArrangementListe(innloggetBruker.getFerdigeArrangement()));
        listeLabel.setText("Tidligere Arrangement");

    }

    public void gaaTilArrangementSideBtn(ActionEvent actionEvent) {
        setValgtArrangement(minSideArrangementerListe.getSelectionModel().getSelectedItem());
        if (Controller.getValgtArrangement() != null) {
            settPane(rootPane,"../brukerArrangementSide.fxml");
        }
        else
            System.out.print("Velg et arrangement");
    }

    public void tilbakeTilAlleArrangementer(ActionEvent actionEvent) {
        settPane(rootPane, "../brukerForside.fxml");
    }
}
