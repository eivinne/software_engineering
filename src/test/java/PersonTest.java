import Data.PersonData;
import Model.Arrangor;
import Model.Deltager;
import Model.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {
    public Deltager deltager;
    public Arrangor arrangor;

    @BeforeEach
    public void setup(){
        PersonData.genererBrukere();
        deltager = (Deltager) PersonData.getBrukerListe().get(0);
        arrangor = (Arrangor) PersonData.getBrukerListe().get(1);

    }

    @Test
    public void erArrangorTest(){
        //Tester funksjon som skjekker om en bruker er arrangør
        assertTrue(arrangor.erArrangor());
        assertFalse(deltager.erArrangor());
    }

    @Test
    public void validerBrukerTest(){
        //Tester at stub som skal validere om brukere har konto eller ei fungerer som den skal
        assertSame(Person.validerBruker("Bruker","passord123"),0);
        assertSame(Person.validerBruker("Arrangør1","drossap123"),1);
        assertSame(Person.validerBruker("Ikke","enBruker"),-1);
    }
}
