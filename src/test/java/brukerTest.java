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
    public void oversikt_over_tidligere_deltatte_arrangement(){
        //Tester  krav 4.8.b
        //Sjekker at brukere har oversikt over tidligere arrangement
        bruker.meldPaaArrangement(Holmekollen);
        Holmekollen.redigerArrangement("Holmekollen","Det jogges", LocalDate.parse("2018-03-03"), "12:00", "Holmenkollen", 100, "Løp");
        assertTrue(bruker.getFerdigeArrangement().contains(Holmekollen));
    }

}
