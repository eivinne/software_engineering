import Data.ArrangementData;
import Data.PersonData;
import Model.Arrangement;
import Model.Arrangor;
import Model.Deltager;
import Model.Person;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class brukerTest {
    static Deltager bruker;
    static Arrangor arrangor;
    static Arrangement Holmekollen;
    static Arrangement haldenLopet;
    @BeforeAll
    public static void setup(){
        PersonData.genererBrukere();
        bruker = (Deltager)PersonData.getBrukerListe().get(0);
        arrangor = (Arrangor) PersonData.getBrukerListe().get(1);
        ArrangementData.genererArrangement();
        Holmekollen = ArrangementData.getArrangementListe().get(0);
        haldenLopet = ArrangementData.getArrangementListe().get(1);

    }
    //SLETTES?
    @Test //tester funksjonen erArrangor
    public void erArrangorTest(){
        assertTrue(arrangor.erArrangor());
        assertFalse(bruker.erArrangor());

    }
    //SLETTES?
    @Test//skjekker at brukere blir lagt til i brukerliste
    public void lagtiIListeTest(){
        assertTrue(PersonData.getBrukerListe().contains(bruker));
        assertTrue(PersonData.getBrukerListe().contains(arrangor));
    }
    //SLETTES?
   /* @Test
    public void validerBrukerTest(){
        assertEquals(1,Person.validerBruker("Arrangør","drossap123"));
        assertTrue(Person.getInnlogget().equals(arrangor));

        assertEquals(0,Person.validerBruker("Bruker","passord123"));
        assertTrue(Person.getInnlogget().equals(bruker));

        assertEquals(-1,Person.validerBruker("Ikke","ISystemet"));
        assertNull(Person.getInnlogget());
    }*/

    @Test
    public void oversikt_over_paameldte_og_interreserte_arrangement(){
        //Tester krav 4.8.a
        //Sjekker at en brukere har oversikt over arrangement de er påmeldt/ interresert i
        bruker.meldPaaArrangement(Holmekollen);
        assertTrue(bruker.getPaameldteArrangement().contains(Holmekollen));
        assertEquals(1,bruker.getPaameldteArrangement().size());

        bruker.meldInteresse(haldenLopet);
        assertTrue(bruker.getInteresserteArrangement().contains(haldenLopet));
        assertEquals(1,bruker.getInteresserteArrangement().size());


    }

    @Test
    public void oversikt_over_tidligere_deltatte_arrangementTest(){
        //Tester  krav 4.8.b
        //Sjekker at brukere har oversikt over tidligere arrangement
        bruker.meldPaaArrangement(Holmekollen);
        Holmekollen.redigerArrangement("Holmekollen","Det jogges", LocalDate.parse("2018-03-03"), "12:00", "Holmenkollen", 100, "Løp");
        assertTrue(bruker.getFerdigeArrangement().contains(Holmekollen));
    }

    @Test
    public void meldPaaArrangementTest(){
        //Tester funksjon som melder bruker på arrangement
        bruker.meldPaaArrangement(Holmekollen);

        //Tester at listen med påmelde arrangement hos bruker inneholder arrangementet
        assertTrue(bruker.getPaameldteArrangement().contains(Holmekollen));

        //Tester at bruker er en av påmelte på Holmekollen arrangementet
        assertTrue(Holmekollen.getPaameldteListe().contains(bruker));

        //Tester at det ikke blir lagt til dublikater selv om bruker prøver å melde seg på igjen
        bruker.meldPaaArrangement(Holmekollen);
        assertEquals(1,bruker.getPaameldteArrangement().size());
        assertEquals(1,Holmekollen.getPaameldteListe().size());
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
        assertEquals(1,haldenLopet.getInteresserteListe().size());
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
    public void alleredeInteressert(){
        //Tester funksjon som sjekker om bruker allerede er interresert
        //brukes i meldInteresse funksjon
        bruker.meldInteresse(haldenLopet);
        assertTrue(bruker.alleredeInteressert(haldenLopet));
        assertFalse(bruker.alleredeInteressert(Holmekollen));
    }






}
