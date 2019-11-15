import Data.ArrangementData;
import Data.PersonData;
import Model.Arrangement;
import Model.Arrangor;
import Model.Deltager;
import Model.Person;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class brukerTest {

    //Lager deltagerer
    static Deltager bruker;
    static Deltager bruker2;
    static Deltager bruker3;
    //Lager arrangement
    static Arrangement Holmekollen;
    static Arrangement haldenLopet;
    static Arrangement bergensRittet;
    static Arrangement VM;

    //Setter
    @BeforeAll
    public static void setup(){
        PersonData.genererBrukere();
        bruker = (Deltager)PersonData.getBrukerListe().get(0);
        bruker2 = (Deltager) PersonData.getBrukerListe().get(3);
        bruker3 = new Deltager("Ussain","Bolt",30,"fastestMan@alive.no","bolt","tlob");
        ArrangementData.genererArrangement();
        Holmekollen = ArrangementData.getArrangementListe().get(0);
        haldenLopet = ArrangementData.getArrangementListe().get(1);
        bergensRittet = ArrangementData.getArrangementListe().get(2);
        VM = ArrangementData.getArrangementListe().get(3);

    }

    @Test
    public void meldPaaArrangementTest(){
        //Tester funksjon som melder bruker på arrangement
        bruker3.meldPaaArrangement(VM);

        //Tester at listen med påmelde arrangement hos bruker inneholder arrangementet
        assertTrue(bruker3.getPaameldteArrangement().contains(VM));

        //Tester at bruker er en av påmelte på Holmekollen arrangementet
        assertTrue(VM.getPaameldteListe().contains(bruker3));

        //Tester at det ikke blir lagt til dublikater selv om bruker prøver å melde seg på igjen
        bruker3.meldPaaArrangement(Holmekollen);
        assertEquals(1,bruker3.getPaameldteArrangement().size());
        assertEquals(1,VM.getPaameldteListe().size());
    }

    @Test
    public void getInteresserteArrangementTest(){
        //Tester krav 4.8.a
        //Sjekker at en brukere har oversikt over arrangement de er påmeldt
        //Setter 2 brukere som interesser i arrangement noen
        bruker.meldInteresse(haldenLopet);

        bruker2.meldInteresse(bergensRittet);
        bruker2.meldInteresse(haldenLopet);

        //sjekker arrangementt er lagt til i listen til bruker
        assertTrue(bruker.getInteresserteArrangement().contains(haldenLopet));
        assertTrue(bruker2.getInteresserteArrangement().contains(haldenLopet));
        assertTrue(bruker2.getInteresserteArrangement().contains(bergensRittet));

        //sjekker brukeren er lagt til i arrangementet sin liste (SKAL I ARRANGEMENT TESTER)
        assertTrue(haldenLopet.getInteresserteListe().contains(bruker));
        assertTrue(bergensRittet.getInteresserteListe().contains(bruker2));
        assertTrue(haldenLopet.getInteresserteListe().contains(bruker2));

        //Tester at det ikke er duplikater i listene
        assertEquals(1,bruker.getInteresserteArrangement().size());
        assertEquals(2,bruker2.getInteresserteArrangement().size());
        assertEquals(1,bergensRittet.getInteresserteListe().size());
        assertEquals(2,haldenLopet.getInteresserteListe().size());
    }

    @Test
    public void getPaameldeArrangementTest(){
        //Tester krav 4.8.a
        //Sjekker at en brukere har oversikt over arrangement de er interresert i
        bruker.meldPaaArrangement(haldenLopet);
        bruker2.meldPaaArrangement(haldenLopet);
        bruker2.meldPaaArrangement(bergensRittet);

        assertTrue(bruker.getPaameldteArrangement().contains(haldenLopet));
        assertTrue(bruker2.getPaameldteArrangement().contains(haldenLopet));
        assertTrue(bruker2.getPaameldteArrangement().contains(bergensRittet));

        //(SKAL I ARRANGEMENT TESTER)
        assertTrue(haldenLopet.getPaameldteListe().contains(bruker));
        assertTrue(haldenLopet.getPaameldteListe().contains(bruker2));
        assertTrue(bergensRittet.getPaameldteListe().contains(bruker2));

        assertEquals(1,bruker.getPaameldteArrangement().size());
        assertEquals(2,bruker2.getPaameldteArrangement().size());
        assertEquals(2,haldenLopet.getPaameldteListe().size());
        assertEquals(1,bergensRittet.getPaameldteListe().size());

    }


    @Test
    public void meldInteresseTest(){
        //Tester funksjon som lar bruker legge vise interesse i arrangement
        bruker.meldInteresse(haldenLopet);

        //Tester at arrangementet blir lagt til i brukeren sin interesse liste
        assertTrue(bruker.getInteresserteArrangement().contains(haldenLopet));

        //Tester at bruker er en av interreserte i arrangementet
        assertTrue(haldenLopet.getInteresserteListe().contains(bruker));

        //Tester at det ikke blir lagt til duplikater når brukeren prøver å melde interesse igjen
        bruker.meldInteresse(haldenLopet);
        assertEquals(1,bruker.getInteresserteArrangement().size());

        //(SKAL I ARRANGEMENT TESTER)
        assertEquals(1,haldenLopet.getInteresserteListe().size());
    }

    @Test
    public void getFerdigeArrangementTest(){
        //Tester  krav 4.8.b "Brukeren skal ha oversikt over tidligere arrangement"
        //Tester også funksjonen oppdaterPaameldListe som blir gat sammen med getFerdigeArrangement, getPaameldteArrangement og getInterreserteArranemetn

        //Melder bruker på arrangement
        bruker.meldPaaArrangement(Holmekollen);

        //Endrer arrangement dato til å være utgått
        Holmekollen.redigerArrangement("Holmekollen","Det jogges", LocalDate.parse("2018-03-03"), "12:00", "Holmenkollen", 100, "Løp");

        //Skjekker at det blir lagt til i ferdigeArrangemet listen
        assertTrue(bruker.getFerdigeArrangement().contains(Holmekollen));
    }

    @Test
    public void alleredePaameldtTest(){
        //Tester funksjon som sjekker om bruker allerede er påmeldt
        // brukes i meldPaaArangement funksjon
        bruker.meldPaaArrangement(Holmekollen);
        assertTrue(bruker.alleredePaameldt(Holmekollen));
        assertFalse(bruker.alleredePaameldt(haldenLopet));
    }

    @Test
    public void alleredeInteressertTest(){
        //Tester funksjon som sjekker om bruker allerede er interresert
        //brukes i meldInteresse funksjon
        bruker.meldInteresse(haldenLopet);
        assertTrue(bruker.alleredeInteressert(haldenLopet));
        assertFalse(bruker.alleredeInteressert(Holmekollen));
    }


    @Test
    public void oppdaterInteresseListeTest(){
        //Tester funksjon som fjerner utgåtte arrangement fra interessert listen til brukeren
        //Melder brukeren interessert
        bruker3.meldInteresse(bergensRittet);

        assertTrue(bruker3.getInteresserteArrangement().contains(bergensRittet));
        //Endrer dato slik at arrangementet er utgått
        bergensRittet.redigerArrangement("Bergensrittet", "Det sykles", LocalDate.parse("2019-01-29"), "08:00", "Bergen", 400,"Sykkel");

        //Kaller på oppdaterInteressertListe funksjonen
        bruker3.oppdaterInteresseListe();

        //Skjekker at arrangementet er blitt fjernet fra listetn.
        assertFalse(bruker3.getInteresserteArrangement().contains(bergensRittet));

    }










}
