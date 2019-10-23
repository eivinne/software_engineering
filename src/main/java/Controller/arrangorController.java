package Controller;

import Data.ArrangementData;
import Model.Arrangement;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.awt.image.AreaAveragingScaleFilter;
import java.io.IOException;

public class arrangorController {

    @FXML private ListView<Arrangement> mineArrangementerListe;
    @FXML private Button nyttArrangementBtn;
    @FXML private Button seArrangementsideBtn;
    @FXML private TextField navnPaaArrangementTxt;
    @FXML private TextField arrangementDatoTxt;

    @FXML
    private AnchorPane rootPane;

    private static Arrangement valgtArrangement;


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

    @FXML
    private void gaaTilArrangementside() throws IOException{
        valgtArrangement = mineArrangementerListe.getSelectionModel().getSelectedItem();

        AnchorPane pane = FXMLLoader.load(getClass().getResource("../arrangementSide.fxml"));
        rootPane.getChildren().setAll(pane);



        System.out.print(pane.getProperties());

        /*FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("../arrangementSide.fxml"));

        arrangementSideController arrangementSideController = fxmlLoader.getController();
        arrangementSideController.fyllInnArrangementInfo(valgtArrangement);*/

    }

    public static Arrangement getValgtArrangement(){
        return valgtArrangement;
    }

}
