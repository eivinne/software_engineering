import Data.PersonData;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PersonDataTest {

    @Test
    public void genererBrukereTest(){
        PersonData.genererBrukere();
        assertFalse(PersonData.getBrukerListe().isEmpty());
        assertEquals(PersonData.getBrukerListe().size(),4);
    }
}
