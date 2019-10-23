package Controller;

import Model.Person;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;


public class loginnController {
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
    private AnchorPane hovedPane;

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
    public void knappTrykk() throws IOException {
        for (Person enPerson : Person.getBrukerListe()) {
            if (enPerson.getBrukernavn().equals(textNavn.getText()) && enPerson.getPassord().equals(textPassord.getText())) {
                AnchorPane pane = FXMLLoader.load(getClass().getResource("../minSide.fxml"));
                hovedPane.getChildren().setAll(pane);
            }
            else
                System.out.println("FEIL BRUKERNAVN ELLER PASSORD" + " " + textNavn.getText() + " " + textPassord.getText());


        }
    }
/*
        if(textPassord.getText().equals("passord123") && textNavn.getText().equals("Bruker")){
            AnchorPane pane = FXMLLoader.load(getClass().getResource("../brukerForside.fxml"));
            hovedPane.getChildren().setAll(pane);

        }
        else if (textPassord.getText().equals("drossap123") && textNavn.getText().equals("Arrangør")){
            AnchorPane pane = FXMLLoader.load(getClass().getResource("../arrangorView.fxml"));
            hovedPane.getChildren().setAll(pane);
        }
        else
            System.out.println("FEIL BRUKERNAVN ELLER PASSORD" + " " + textNavn.getText() + " " + textPassord.getText());

    }


*/
}
