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
    private  AnchorPane rootPane;


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
        textNavn.setText("Arrangør1");
        textPassord.setText("drossap123");

    }

    @FXML
    public void knappTrykk(){
        String brukernavn = textNavn.getText();
        String passord = textPassord.getText();
        int redirect = Person.validerBruker(brukernavn,passord);
        if (redirect == 1)
            settPane(rootPane,"../arrangorView.fxml");
        else if(redirect == 0)
            settPane(rootPane, "../brukerForside.fxml");
        else
            System.out.println("FEIL BRUKERNAVN ELLER PASSORD!");

        /*
        boolean valid = false;
          for (Person enPerson : Person.getBrukerListe()) {
            if (enPerson.getBrukernavn().equals(brukernavn) && enPerson.getPassord().equals(passord)) {
                if (enPerson.erArrangor()) {
                    settPane(rootPane, "../arrangorView.fxml");
                }
                else {
                    settPane(rootPane, "../brukerForside.fxml");
                }
                valid = true;
            }
        }
        if(!valid) {
            System.out.println("FEIL BRUKERNAVN ELLER PASSORD" + " " + textNavn.getText() + " " + textPassord.getText());
        }
        */
    }
}
