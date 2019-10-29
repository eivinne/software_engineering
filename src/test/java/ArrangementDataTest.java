import Data.ArrangementData;
import Model.Arrangement;
import Model.Person;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


public class ArrangementDataTest {


    @Test
    public void testIfArrangementDataIsNotEmpty() {
        assertFalse(ArrangementData.hentArrangementData().isEmpty());
    }

    @Test
    public void testIfArrangement() {
        for(int i = 0; i<ArrangementData.hentArrangementData().size(); i++){
            assertTrue(ArrangementData.hentArrangementData().get(i) instanceof Arrangement);
        }
    }

}
