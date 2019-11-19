import Data.ArrangementData;
import Model.Arrangement;
import Model.Arrangor;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


public class ArrangementDataTest {
    static Arrangor arrangor1;
    static Arrangor arrangor2;
    static Arrangement holmenKollStafetten;
    static Arrangement joggetur;
    static Arrangement birkebeineren;




    @BeforeAll
    public static void setup(){
     arrangor1 = new Arrangor("Maria", "Casino", 14, "minstLike@kul.no", "Arrangør1", "drossap123", "Gamblers");
     arrangor2 = new Arrangor("Roger", "Jebus", 94, "nestenLike@kul.no", "Arrangør2", "drossap123", "Halden IF");
     holmenKollStafetten = new Arrangement("Holmenkoll Stafetten", "Det jogges", LocalDate.parse("2020-03-03"), "12:00", "Holmenkollen", "Loping", arrangor1,120);
     joggetur = new Arrangement("joggetur", "Det jogges", LocalDate.parse("2022-04-04"), "10:00", "Bislett", "Loping", arrangor1,100);
     birkebeineren = new Arrangement("Birkebeiner løpet", "Det gås på ski", LocalDate.parse("2020-04-04"), "08:00", "Skogen", "Ski", arrangor2,120);
    }



    @Test
    public void testIfArrangementDataIsNotEmpty() {
        assertFalse(ArrangementData.getArrangementListe().isEmpty());
    }

    @Test
    public void testIfArrangement() {
        for(Arrangement etArr: ArrangementData.getArrangementListe()){
            assertTrue(etArr instanceof Arrangement);
        }
    }


    
    // Knyttet til krav 4.5.a.1 og 4.5.a.2, søk på kategori, navn og "andre nøkkelord" som i denne prototypen er
    // begrenset til søk på lokasjon.
   @Test
    public void testSok(){
        //Tester at det er mulig å søke
        assertTrue(ArrangementData.sokArr("Holmenkoll", "Alle kategorier").contains(holmenKollStafetten));
        assertTrue(ArrangementData.sokArr("Bislett", "Alle kategorier").contains(joggetur));
        assertTrue(ArrangementData.sokArr("Skogen", "Ski").contains(birkebeineren));

        //Tester søk som ikke gir noen resultater
        assertTrue(ArrangementData.sokArr("Tullogtøys","Alle kategorier").isEmpty());


        //Tester at det er mulig å søke på bare kategori
        assertFalse(ArrangementData.sokArr("","Ski").isEmpty());
        assertFalse(ArrangementData.sokArr("","Loping").isEmpty());


        assertTrue(ArrangementData.sokArr("Holmenkoll","Loping").contains(holmenKollStafetten));
        assertFalse(ArrangementData.sokArr("Holmenkoll","Loping").contains(joggetur));
        assertFalse(ArrangementData.sokArr("Holmenkoll","Loping").contains(birkebeineren));
    }



}
