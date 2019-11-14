package Controller;

import Model.Arrangement;
import Model.Arrangor;
import Model.Person;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.time.LocalDate;

public class NyttArrangementController extends Controller {

    @FXML
    Label arrangementTittelLabel, utskriftLabel;
    @FXML
    TextField arrangementTittelTxt;
    @FXML
    ImageView arrangementBildeImg;
    @FXML
    DatePicker arrangementDatoPicker;
    @FXML
    TextField arrangementTidspunktTxt;
    @FXML
    TextField arrangementStedTxt;
    @FXML
    TextField antallPlasserTxt;
    @FXML
    TextArea arrangementBeskrivelseTxt;
    @FXML
    ToggleGroup lopsKategori;
    @FXML
    private AnchorPane rootPane;

    @FXML
    private void initialize() {
        arrangementTittelLabel.setText("Nytt Arrangement");

    }

    @FXML
    private void tilbakeTilMineArrangementer() {
        settPane(rootPane,"../arrangorView.fxml");
    }

    public void hentInput() {

        String tittel = "";
        String beskrivelse = "";
        LocalDate dato;
        String tidspunkt = "";
        String sted = "";
        String kategori = "";
        String antallPlasser = "";
        antallPlasser = antallPlasserTxt.getText();
        int antallPlasserInt = 0;

        try{
            antallPlasserInt = Integer.parseInt(antallPlasser);
        } catch (NumberFormatException nfe) {
            System.out.println(nfe.getMessage() + " morendin");
        }
        //KASTER EN NULLPOINTER
        if(arrangementTittelTxt.getText().equals("") || arrangementBeskrivelseTxt.getText().equals("") || arrangementStedTxt.getText().equals("") || arrangementDatoPicker.getValue() == null ||arrangementDatoPicker.getValue().equals("") || antallPlasserTxt.getText().equals("") || arrangementTidspunktTxt.getText().equals("") || lopsKategori.getSelectedToggle() == null) {
            utskriftLabel.setText("Alle felter må være fylt inn.");

        }else if (antallPlasserInt <= 0){
            utskriftLabel.setText("Antall plasser må fylles ut med et tall og det må være større enn 0.");
        }
        else {
            tittel = arrangementTittelTxt.getText();
            beskrivelse = arrangementBeskrivelseTxt.getText();
            dato= arrangementDatoPicker.getValue();
            tidspunkt = arrangementTidspunktTxt.getText();
            sted = arrangementStedTxt.getText();
            RadioButton selected = (RadioButton) lopsKategori.getSelectedToggle();
            kategori = selected.getText();
            Arrangor arrangementEier = (Arrangor) Person.getInnlogget();

            Arrangement.opprettNyttArrangement(arrangementEier, tittel, beskrivelse, dato, tidspunkt, sted, kategori, antallPlasserInt);

            settPane(rootPane,"../arrangorView.fxml");
        }
    }
}
