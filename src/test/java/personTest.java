import Controller.Controller;
import Data.PersonData;
import Model.Arrangor;
import Model.Deltager;
import Model.Person;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.*;

public class personTest {
    static Deltager bruker;
    static Arrangor arrangor;

    @BeforeAll
    public static void setup(){
    bruker =new Deltager("Sander","Kander",12,"kulKar123@hiof.no","Bruker","passord123");
    arrangor =new Arrangor("Maria","Casino",14,"minsLike@kul.no","Arrangør","drossap123","Gamblers");
    }

    @Test //tester funksjonen erArrangor
    public void erArrangorTest(){
        assertTrue(arrangor.erArrangor());
        assertFalse(bruker.erArrangor());

    }

    @Test//skjekker at brukere blir lagt til i brukerliste
    public void lagtiIListeTest(){
        assertTrue(PersonData.getBrukerListe().contains(bruker));
        assertTrue(PersonData.getBrukerListe().contains(arrangor));
    }

    @Test
    public void validerBrukerTest(){
        assertEquals(1,Person.validerBruker("Arrangør","drossap123"));
        assertTrue(Controller.getInnlogget().equals(arrangor));

        assertEquals(0,Person.validerBruker("Bruker","passord123"));
        assertTrue(Controller.getInnlogget().equals(bruker));

        assertEquals(-1,Person.validerBruker("Ikke","ISystemet"));
        assertNull(Controller.getInnlogget());
    }
}
