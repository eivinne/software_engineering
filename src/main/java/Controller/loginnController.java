package Controller;

import Model.Person;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;


import java.io.IOException;


public class loginnController extends Controller {
    @FXML
    private RadioButton radioBruker, radioArrangor;

    @FXML
    private TextField textNavn;

    @FXML
    private PasswordField textPassord;

    @FXML
    private Button loginnKnapp;

    @FXML
    private ToggleGroup loginnSom;

    @FXML
    private static AnchorPane rootPane;


    @FXML
    public void initialize(){


    }



    @FXML
    public void fyllBruker(){
    textNavn.setText("Bruker");
    textPassord.setText("passord123");

    }

    @FXML
    public void fyllArrangor(){
        textNavn.setText("Arrangør");
        textPassord.setText("drossap123");

    }

    @FXML
    public void knappTrykk(){
        for (Person enPerson : Person.getBrukerListe()) {
            if (enPerson.getBrukernavn().equals(textNavn.getText()) && enPerson.getPassord().equals(textPassord.getText())) {
                if (enPerson.erArrangor()){
                    settPane(rootPane,"../arrangorView.fxml");
            }

            }
            else
                System.out.println("FEIL BRUKERNAVN ELLER PASSORD" + " " + textNavn.getText() + " " + textPassord.getText());


        }
    }

}
