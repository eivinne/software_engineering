package Controller;

import Model.Person;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.io.IOException;

public abstract class Controller {
    private static Person innlogget;
    //Metode som setter ny scene
    public void settPane(Pane pane, String fxml){
        try {
        AnchorPane nyPane = FXMLLoader.load(getClass().getResource(fxml));
        pane.getChildren().setAll(nyPane);

        }
        catch (IOException ioe){
            System.out.println(ioe.getMessage());
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
}
