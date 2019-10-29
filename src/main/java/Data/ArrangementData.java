package Data;

import Model.Arrangement;
import Model.Arrangor;
import Model.Person;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDate;
import java.util.ArrayList;

public class ArrangementData {


    private static ArrayList<Arrangement> arrangementListe = new ArrayList<>();

    public static ArrayList<Arrangement> hentArrangementData() {

        Person arrangor1 = PersonData.getBrukerListe().get(1);
        Person arrangor2 = PersonData.getBrukerListe().get(2);

        if(arrangementListe.size() == 0) {
            Arrangement holmenKollStafetten = new Arrangement("Holmenkoll Stafetten", "Det jogges", LocalDate.parse("2020-03-03"), "12:00", "Holmenkollen", "Loping", arrangor1);
            Arrangement birkebeineren = new Arrangement("Birkebeiner løpet", "Det gås på ski", LocalDate.parse("2020-04-04"), "08:00", "Skogen", "Ski", arrangor2);
        }
        return arrangementListe;
    }

    public static ArrayList<Arrangement> getArrangementListe() {
        return arrangementListe;
    }

}
