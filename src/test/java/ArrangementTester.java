import Data.ArrangementData;
import Data.PersonData;
import Model.Arrangement;
import Model.Arrangor;
import Model.Deltager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

public class ArrangementTester {

    @BeforeAll
    public static void setup() {

        ArrangementData.genererArrangement();
    }


    //Krav 4.6 fra dokumentasjonen
    //Sjekker at redigerArrangement-funksjonen fungerer.
    @Test
    public void redigerArrangementTest() {

        Arrangement etArrangement = ArrangementData.getArrangementListe().get(0);

        etArrangement.redigerArrangement(etArrangement, "entittel", "enbeskrivelse", LocalDate.now(), "10:00", "enlokasjon", 100, "Sykkel");

        assertTrue(etArrangement.getTittel() == "entittel");
        assertTrue(etArrangement.getBeskrivelse() == "enbeskrivelse");
    }

    //Tilhører også krav 4.6
    //Sjekker at opprettArrangement-funksjonen fungerer, samt at den kun legger til et arrangement
    //dersom det er en Arrangør som forsøker å opprette.
    @Test
    public void opprettArrangementTest() {

        String tittel = "tittel123", beskrivelse = "enbeskrivelse", tidspunkt = "12:00", lokasjon = "ikke her", kategori = "YOLO";
        LocalDate dato = LocalDate.now();
        int kapasitet = 100;
        Arrangor eier = (Arrangor) PersonData.getBrukerListe().get(1);
        Deltager deltager = (Deltager) PersonData.getBrukerListe().get(0);

        Arrangement.opprettNyttArrangement(eier, tittel, beskrivelse, dato, tidspunkt, lokasjon, kategori, kapasitet);
        Arrangement opprettetArrangement1 = ArrangementData.getArrangementListe().get(ArrangementData.getArrangementListe().size() - 1);

        assertTrue(ArrangementData.getArrangementListe().contains(opprettetArrangement1));
        assertTrue(opprettetArrangement1.getTittel() == "tittel123");
        assertFalse(opprettetArrangement1.getKapasitet() == 95);

        Arrangement.opprettNyttArrangement(deltager, "enAnnenTittel", beskrivelse, dato, tidspunkt, "her", kategori, kapasitet);
        Arrangement opprettetArrangement2 = ArrangementData.getArrangementListe().get(ArrangementData.getArrangementListe().size() - 1);

        assertFalse(opprettetArrangement2.getTittel() == "enAnnenTittel");
        assertFalse(opprettetArrangement2.getLokasjon() == "her");
    }

    //Tester om et arrangement sin dato har utgått/tilhører fortiden.
    @Test
    public void harVaertTest() {
        Arrangement arrangement1 = ArrangementData.getArrangementListe().get(1);
        Arrangement arrangement2 = ArrangementData.getArrangementListe().get(2);

        arrangement1.setDato(LocalDate.parse("2020-12-12"));
        arrangement2.setDato(LocalDate.parse("2010-12-12"));

        assertFalse(arrangement1.harVaert());
        assertTrue(arrangement2.harVaert());
    }


}
