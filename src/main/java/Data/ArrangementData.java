package Data;

import Model.Arrangement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDate;
import java.util.ArrayList;

public class ArrangementData {


    private static ArrayList<Arrangement> arrangementListe = new ArrayList<>();

    public static ArrayList<Arrangement> hentArrangementData() {

        if(arrangementListe.size() == 0) {
            Arrangement holmenKollStafetten = new Arrangement("Holmenkoll Stafetten", "Det jogges", LocalDate.parse("2020-03-03"), "12:00", "Holmenkollen", "Loping");
            Arrangement birkebeineren = new Arrangement("Birkebeiner løpet", "Det gås på ski", LocalDate.parse("2020-04-04"), "08:00", "Skogen", "Ski");
        }
        return arrangementListe;
    }

    public static ArrayList<Arrangement> getArrangementListe() {
        return arrangementListe;
    }

}
