package Controller;

import Model.Arrangement;
import Model.Person;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.util.ArrayList;

public abstract class Controller {
    private static Person innlogget;
    //Metode som setter ny scene
    public void settPane(Pane pane, String fxml){
        try {
        AnchorPane nyPane = FXMLLoader.load(getClass().getResource(fxml));
        pane.getChildren().setAll(nyPane);

        }
        catch (IOException ioe){
            ioe.printStackTrace();
        }
    }

    public void utlogging(AnchorPane pane){
        settPane(pane,"../loginnskjerm.fxml");
        innlogget = null;
    }

    public static Person getInnlogget(){
        return innlogget;
    }
    public static void setInnlogget(Person person){
        innlogget = person;
    }

    public ObservableList<Arrangement> omgjorArrangementListe(ArrayList<Arrangement> arrangementListe) {
        ObservableList<Arrangement> omgjortListe = FXCollections.observableArrayList();

        omgjortListe.addAll(arrangementListe);
        return omgjortListe;
    }

    public void gaaTilArrangementside(Arrangement valgtArrangement, Pane rootPane) {
        if (valgtArrangement != null) {
            settPane(rootPane,"../arrangementSide.fxml");
        }
        else
            System.out.print("Velg et arrangement");
    }
}
