package Controller;

import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.IOException;

public class brukerForsideController extends Controller{

    @FXML
    private Button minSideBtn, loggUtBtn, searchFieldBtn;

    @FXML
    private AnchorPane rootPane;

    @FXML
    private TextField searchField;

    @FXML
    private ComboBox<String> velgKategoriCombo = new ComboBox<>();

    @FXML
    private void initialize() {

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

}








