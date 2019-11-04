package Controller;

import Data.ArrangementData;
import Model.Arrangement;
import Model.Arrangor;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.util.ArrayList;

public class arrangorController extends Controller{

    @FXML private Button nyttArrangementBtn;
    @FXML private Button seArrangementsideBtn;
    @FXML private TextField navnPaaArrangementTxt;
    @FXML private TextField arrangementDatoTxt;
    @FXML private ListView<Arrangement> mineArrangementerListe;
    @FXML private Label utskriftLabel;
    @FXML private ObservableList<Arrangement> alleArrangemantOmgjort = omgjorArrangementListe(ArrangementData.getArrangementListe());
    @FXML private AnchorPane rootPane;




    @FXML
    private void initialize() {
        mineArrangementerListe.setItems(alleArrangemantOmgjort);
    }

    @FXML
    public void visAlleArrangementer(){
        mineArrangementerListe.setItems(alleArrangemantOmgjort);
    }


    @FXML
    public void visMineArrangementer(){
        Arrangor arrangor = (Arrangor) getInnlogget();
        ArrayList<Arrangement> arrangorSineArr = arrangor.getArrangorArrangement();
        mineArrangementerListe.setItems(omgjorArrangementListe(arrangorSineArr));
    }

    @FXML
    public void redigerArrangementside() {
        Arrangor arrangor = (Arrangor) getInnlogget();
        setValgtArrangement(mineArrangementerListe.getSelectionModel().getSelectedItem());
        if (getValgtArrangement() != null) {
            if (arrangor.getArrangorArrangement().contains(getValgtArrangement()))
                settPane(rootPane,"../redigerArrangement.fxml");
            else
                utskriftLabel.setText("Du kan ikke endre arrangement du ikke eier");
        }
        else
            utskriftLabel.setText("Velg et arrangement");
    }

    @FXML
    public void gaaTilArrangementside() {
        setValgtArrangement(mineArrangementerListe.getSelectionModel().getSelectedItem());
        if (getValgtArrangement() != null)
            settPane(rootPane,"../arrangementSide.fxml");
        else
            utskriftLabel.setText("Velg et arrangement");
    }

    @FXML
    private void loggUt() {
        utlogging(rootPane);
    }

    public void opprettNyttArrangement() {
            settPane(rootPane,"../nyttArrangement.fxml");
    }




}
