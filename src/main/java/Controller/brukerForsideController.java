package Controller;

import Data.ArrangementData;
import Model.Arrangement;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;



public class brukerForsideController extends Controller{

    @FXML
    private AnchorPane rootPane;

    @FXML
    private TextField sokIArrangementerTxt;

    @FXML
    private ListView<Arrangement> brukerSideArrangementerList;

    @FXML
    private ComboBox<String> velgKategoriCombo = new ComboBox<>();


    @FXML
    private void initialize() {

        brukerSideArrangementerList.setItems(omgjorArrangementListe(ArrangementData.getArrangementListe()));

        velgKategoriCombo.getItems().add("Alle kategorier");
        velgKategoriCombo.getItems().add("Ski");
        velgKategoriCombo.getItems().add("Løp");
        velgKategoriCombo.getItems().add("Sykkel");
    }


    @FXML
    private void loadMinSide() {
        settPane(rootPane,"../minSide.fxml");
       /* AnchorPane pane = FXMLLoader.load(getClass().getResource("../minSide.fxml"));
        rootPane.getChildren().setAll(pane); */
    }

    @FXML
    private void loggUt() {
        utlogging(rootPane);
    }

    @FXML
    public void gaaTilArrangementside() {
        setValgtArrangement(brukerSideArrangementerList.getSelectionModel().getSelectedItem());
        if (Controller.getValgtArrangement() != null) {
            settPane(rootPane,"../brukerArrangementSide.fxml");
        }
        else
            System.out.print("Velg et arrangement");
    }


    public void sokIArrangementListe(ActionEvent actionEvent) {

        String sokefeltInput = sokIArrangementerTxt.getText();
        String valgtKategori = velgKategoriCombo.getValue();
        if(valgtKategori == null || valgtKategori == "Alle kategorier") {
            valgtKategori = "";
        }
        brukerSideArrangementerList.setItems(omgjorArrangementListe(ArrangementData.sokArr(sokefeltInput, valgtKategori)));
    }


    public void visAlleArrangementer(ActionEvent actionEvent) {
        brukerSideArrangementerList.setItems(omgjorArrangementListe(ArrangementData.getArrangementListe()));
    }
}








