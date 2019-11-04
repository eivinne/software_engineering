package Controller;

import Model.Arrangement;
import Model.Person;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.util.ArrayList;

public abstract class Controller {
    private static Person innlogget;
    private static Arrangement valgtArrangement;
    private static String utskriftString = "";

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

    public ObservableList<Arrangement> omgjorArrangementListe(ArrayList<Arrangement> arrangementListe) {
        ObservableList<Arrangement> omgjortListe = FXCollections.observableArrayList();

        omgjortListe.addAll(arrangementListe);
        return omgjortListe;
    }

    public void utlogging(AnchorPane pane){
        innlogget = null;
        settPane(pane,"../loginnskjerm.fxml");
    }

    public static void setUtskriftString(String utskift){utskriftString = utskift;}

    public String getUtskriftString(){
        return utskriftString;
    }

    public static Person getInnlogget(){
        return innlogget;
    }

    public static void setInnlogget(Person person){
        innlogget = person;
    }

    public static void resettInnlogget(){
        innlogget = null;
    }

    public static void setValgtArrangement(Arrangement arrangement){
        valgtArrangement = arrangement;
    }

    public static Arrangement getValgtArrangement(){
        return valgtArrangement;
    }

}
