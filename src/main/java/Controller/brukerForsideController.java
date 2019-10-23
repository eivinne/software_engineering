package Controller;

import javafx.beans.value.ChangeListener;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.IOException;

public class brukerForsideController {

    @FXML
    private Button minSideBtn, loggUtBtn, searchFieldBtn;

    @FXML
    private AnchorPane rootPane;

    @FXML
    private TextField searchField;


    @FXML
    private void loadMinSide() throws IOException{
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../minSide.fxml"));
        rootPane.getChildren().setAll(pane);
    }

    @FXML
    private void loggUt() throws IOException{
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../loginnskjerm.fxml"));
        rootPane.getChildren().setAll(pane);
    }

}








