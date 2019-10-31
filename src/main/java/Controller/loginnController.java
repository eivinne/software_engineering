package Controller;

import Model.Person;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;


public class loginnController extends Controller {

    @FXML
    private TextField textNavn;

    @FXML
    private PasswordField textPassord;


    @FXML
    private  AnchorPane rootPane;

    @FXML
    private Label utskriftLabel;


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
            utskriftLabel.setText("Feil brukernavn / passord");

    }
}
