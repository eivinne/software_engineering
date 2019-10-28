import Data.PersonData;
import Model.Arrangor;
import Model.Deltager;
import Model.Person;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.*;

public class personTest {

    Deltager bruker = new Deltager("Sander","Kander",12,"kulKar123@hiof.no","Bruker","passord123");
    Arrangor arrangor = new Arrangor("Maria","Casino",14,"minsLike@kul.no","Arrangør","drossap123","Gamblers");
    @Test //metode som skjekker om en er arrangør
    public void rolleTest(){

        assertTrue(arrangor.erArrangor());
        assertFalse(bruker.erArrangor());

    }

    @Test//skjekker at brukere blir lagt til i brukerliste
    public void lagtiIListeTest(){
        assertTrue(PersonData.getBrukerListe().contains(bruker));
        assertTrue(PersonData.getBrukerListe().contains(arrangor));

    }
}
