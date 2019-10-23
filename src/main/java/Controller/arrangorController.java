package Controller;

import Data.ArrangementData;
import Model.Arrangement;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class arrangorController {

    @FXML private ListView<Arrangement> mineArrangementerListe;
    @FXML private Button nyttArrangementBtn;
    @FXML private Button seArrangementsideBtn;
    @FXML private TextField navnPaaArrangementTxt;
    @FXML private TextField arrangementDatoTxt;


    @FXML
    private void initialize() {

        mineArrangementerListe.setItems(ArrangementData.hentArrangementData());
        mineArrangementerListe.setOnMouseClicked(e -> {


            Arrangement selectedItem = mineArrangementerListe.getSelectionModel().getSelectedItem();
            if (selectedItem != null) {

                navnPaaArrangementTxt.setText(selectedItem.getTittel());
                arrangementDatoTxt.setText(selectedItem.getDato());
            }
        });

    }
}
