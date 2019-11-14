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
        sorgForBareTallInput(antallPlasserTxt);
    }

    @FXML
    private void tilbakeTilMineArrangementer() {
        settPane(rootPane,"../arrangorView.fxml");
    }

    public void hentInput() {
        if(arrangementTittelTxt.getText().equals("") || arrangementBeskrivelseTxt.getText().equals("") || arrangementStedTxt.getText().equals("") || arrangementDatoPicker.getValue() == null ||arrangementDatoPicker.getValue().equals("") || antallPlasserTxt.getText().equals("") || arrangementTidspunktTxt.getText().equals("") || lopsKategori.getSelectedToggle() == null) {
            utskriftLabel.setText("Alle felter må være fylt inn.");

        }
        else {
            String tittel = arrangementTittelTxt.getText();
            String  beskrivelse = arrangementBeskrivelseTxt.getText();
            LocalDate dato= arrangementDatoPicker.getValue();
            String tidspunkt = arrangementTidspunktTxt.getText();
            String sted = arrangementStedTxt.getText();
            RadioButton selected = (RadioButton) lopsKategori.getSelectedToggle();
            String kategori = selected.getText();
            Arrangor arrangementEier = (Arrangor) Person.getInnlogget();
            int antallPlasserInt = Integer.valueOf(antallPlasserTxt.getText());

            if (antallPlasserInt <= 0)
                utskriftLabel.setText("Antall plasser må fylles ut med et tall større enn 0.");
            else {
                Arrangement.opprettNyttArrangement(tittel, beskrivelse, dato, tidspunkt, sted, kategori, arrangementEier, antallPlasserInt);
                settPane(rootPane, "../arrangorView.fxml");
            }
        }
    }
}
