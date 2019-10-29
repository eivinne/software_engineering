import Data.ArrangementData;
import Data.PersonData;
import Model.Arrangement;
import Model.Arrangor;
import Model.Person;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


public class ArrangementDataTest {



    @Test
    public void testIfArrangementDataIsNotEmpty() {
        assertFalse(ArrangementData.hentArrangementData().isEmpty());
    }

    @Test
    public void testIfArrangement() {
        for(int i = 0; i<ArrangementData.hentArrangementData().size(); i++){
            assertTrue(ArrangementData.hentArrangementData().get(i) instanceof Arrangement);
        }
    }

    @Test
    public void hentArrangorArrTest() {

        PersonData.genererBrukere();
        Arrangor arrangor1 = (Arrangor) PersonData.getBrukerListe().get(1);
        Arrangor arrangor2 = (Arrangor) PersonData.getBrukerListe().get(2);

        Arrangement holmenKollStafetten = new Arrangement("Holmenkoll Stafetten", "Det jogges", LocalDate.parse("2020-03-03"), "12:00", "Holmenkollen", "Loping", arrangor1);
        Arrangement joggetur = new Arrangement("joggetur", "Det jogges", LocalDate.parse("2022-04-04"), "10:00", "Bislett", "Loping", arrangor1);
        Arrangement birkebeineren = new Arrangement("Birkebeiner løpet", "Det gås på ski", LocalDate.parse("2020-04-04"), "08:00", "Skogen", "Ski", arrangor2);

        ArrangementData.getArrangementListe().add(holmenKollStafetten); //arrangor1 oppført som arrangementeier
        ArrangementData.getArrangementListe().add(joggetur); //arrangor1 oppført som arrangementeier
        ArrangementData.getArrangementListe().add(birkebeineren); //arrangor2 oppført som arrangementeier

        ArrayList<Arrangement> arrangor1SineArrangement = ArrangementData.hentArrangorArr(arrangor1);
        ArrayList<Arrangement> arrangor2SineArrangement = ArrangementData.hentArrangorArr(arrangor2);

        assertNotEquals(arrangor1SineArrangement, arrangor2SineArrangement);

        for(Arrangement etArr:arrangor1SineArrangement) {
            assertTrue(etArr.getArrangementEier() == arrangor1);
            assertFalse(etArr.getArrangementEier() == arrangor2);
        }
    }

    @Test
    public void testSok(){
        PersonData.genererBrukere();
        Arrangor arrangor1 = (Arrangor) PersonData.getBrukerListe().get(1);
        Arrangor arrangor2 = (Arrangor) PersonData.getBrukerListe().get(2);

        Arrangement holmenKollStafetten = new Arrangement("Holmenkoll Stafetten", "Det jogges", LocalDate.parse("2020-03-03"), "12:00", "Holmenkollen", "Loping", arrangor1);
        Arrangement joggetur = new Arrangement("joggetur", "Det jogges", LocalDate.parse("2022-04-04"), "10:00", "Bislett", "Loping", arrangor1);
        Arrangement birkebeineren = new Arrangement("Birkebeiner løpet", "Det gås på ski", LocalDate.parse("2020-04-04"), "08:00", "Skogen", "Ski", arrangor2);

        assertTrue(ArrangementData.sokArr("Holmenkoll").contains(holmenKollStafetten));
        assertTrue(ArrangementData.sokArr("Bislett").contains(joggetur));
        assertTrue(ArrangementData.sokArr("Skogen").contains(birkebeineren));
        System.out.println(ArrangementData.sokArr("Holmenkoll").size());

        assertTrue(ArrangementData.sokArr("Holmenkoll","Loping").contains(holmenKollStafetten));
        assertFalse(ArrangementData.sokArr("Holmenkoll","Loping").contains(joggetur));
        assertFalse(ArrangementData.sokArr("Holmenkoll","Loping").contains(birkebeineren));
        System.out.println(ArrangementData.sokArr("Holmenkoll","Loping").toString());



    }



}
