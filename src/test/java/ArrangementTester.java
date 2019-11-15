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
        PersonData.genererBrukere();
    }


    //Krav 4.6 fra dokumentasjonen
    //Sjekker at redigerArrangement-funksjonen fungerer.
    @Test
    public void redigerArrangementTest() {

        Arrangement etArrangement = ArrangementData.getArrangementListe().get(0);

        etArrangement.redigerArrangement("entittel", "enbeskrivelse", LocalDate.now(), "10:00", "enlokasjon", 100, "Sykkel");

        assertSame(etArrangement.getTittel(),"entittel");
        assertSame(etArrangement.getBeskrivelse(),"enbeskrivelse");
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
        assertSame(opprettetArrangement1.getTittel(),"tittel123");
        assertNotEquals(opprettetArrangement1.getKapasitet(),95);

        Arrangement.opprettNyttArrangement(deltager, "enAnnenTittel", beskrivelse, dato, tidspunkt, "her", kategori, kapasitet);
        Arrangement opprettetArrangement2 = ArrangementData.getArrangementListe().get(ArrangementData.getArrangementListe().size() - 1);

        assertNotEquals(opprettetArrangement2.getTittel(),"enAnnenTittel");
        assertNotEquals(opprettetArrangement2.getLokasjon(),"her");
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

    //Tester om et arrangement har ledige plasser eller er fullt.
    @Test
    public void erFulltTest() {
        Arrangement etArrangement = ArrangementData.getArrangementListe().get(0);
        etArrangement.setKapasitet(0);
        assertTrue(etArrangement.erFullt());
        etArrangement.setKapasitet(10);
        assertFalse(etArrangement.erFullt());
    }

    //Tester antallLedigePlasser-funksjonen, som skal trekke fra antall påmeldte i listen paameldtListe fra
    //arrangementets kapasitet.
    @Test
    public void antallLedigePlasserTest() {

        Arrangement etArrangement = ArrangementData.getArrangementListe().get(1);
        etArrangement.setKapasitet(10);
        assertEquals(10, etArrangement.antallLedigePlasser());

        Deltager deltager = (Deltager) PersonData.getBrukerListe().get(0);

        deltager.meldPaaArrangement(etArrangement);
        assertNotEquals(10, etArrangement.antallLedigePlasser());
    }

    //Sjekker om funksjonen for å slette arrangement fungerer.
    @Test
    public void slettArrangementTest() {

        Arrangor eier = (Arrangor) PersonData.getBrukerListe().get(1);
        Arrangement etArrangement = new Arrangement("etnyttarrangement", "Det gås på ski", LocalDate.parse("2020-02-16"), "08:00", "Holmenkollen", "Ski", eier,5000);

        assertTrue(ArrangementData.getArrangementListe().contains(etArrangement));

        etArrangement.slettArrangement();

        assertFalse(ArrangementData.getArrangementListe().contains(etArrangement));

    }

    @Test
    public void getPaameldtListeTest(){
        //Tester funksjon som henter deltagere i et arrangement
        Arrangement etArrangement = ArrangementData.getArrangementListe().get(3);
        Deltager bruker = (Deltager) PersonData.getBrukerListe().get(0);

        //melder deltager på arrangement
        bruker.meldPaaArrangement(etArrangement);

        //Skjekker at brukeren er blitt lagt til i listen av deltagere
        assertTrue(etArrangement.getPaameldteListe().contains(bruker));

        //Skjekker at det ikke er blitt lagt til duplikater/andre brukere
        assertEquals(1,etArrangement.getPaameldteListe().size());

    }

    @Test
    public void getInteresserteListeTest(){
        //Tester funksjon som henter liste over interesserte brukere for et arrangement
        Arrangement etArrangement = ArrangementData.getArrangementListe().get(3);
        Deltager bruker = (Deltager) PersonData.getBrukerListe().get(3);


        //melder bruker som interessert
        bruker.meldInteresse(etArrangement);

        //Skjekker at brukeren er blitt lagt til i listen av interesserte
        assertTrue(etArrangement.getInteresserteListe().contains(bruker));

        //Skjekker at det ikke er blitt lagt til duplikater/andre brukere
        assertEquals(1,etArrangement.getInteresserteListe().size());

    }


}
