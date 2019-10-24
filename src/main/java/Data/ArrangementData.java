package Data;

import Model.Arrangement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class ArrangementData {


    private final static ArrayList<Arrangement> arrangementListe = new ArrayList<>();

    public static ArrayList<Arrangement> hentArrangementData() {

        if(arrangementListe.size() == 0) {
            Arrangement holmenKollStafetten = new Arrangement("Holmenkoll Stafetten", "Det jogges", "20-03-2020", "12:00", "Holmenkollen", 12);
            Arrangement birkebeineren = new Arrangement("Birkebeiner løpet", "Det gås på ski", "20-01-2020", "08:00", "Skogen", 15);

            arrangementListe.add(holmenKollStafetten);
            arrangementListe.add(birkebeineren);
        }
        return arrangementListe;
    }

    public static ArrayList<Arrangement> getArrangementListe() {
        return arrangementListe;
    }

}
