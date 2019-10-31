package Controller;

import Model.Arrangement;
import Model.Deltager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;

public class MinSideController extends Controller {

    @FXML
    private AnchorPane rootPane;


    @FXML
    private ListView<Arrangement> minSideArrangementerListe;



    private Deltager innloggetBruker = (Deltager) Controller.getInnlogget();

    @FXML
    private void initialize() {
        minSideArrangementerListe.setItems(omgjorArrangementListe(innloggetBruker.getPaameldteArrangement()));
    }


    public void visPaameldteArrangement(ActionEvent actionEvent) {
        minSideArrangementerListe.setItems(omgjorArrangementListe(innloggetBruker.getPaameldteArrangement()));
    }

    public void visInteressertArrangementBtn(ActionEvent actionEvent) {
        minSideArrangementerListe.setItems(omgjorArrangementListe(innloggetBruker.getInteresserteArrangement()));
    }

    public void visTidligereArrangement(ActionEvent actionEvent) {
        minSideArrangementerListe.setItems(omgjorArrangementListe(innloggetBruker.getFerdigeArrangement()));

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
