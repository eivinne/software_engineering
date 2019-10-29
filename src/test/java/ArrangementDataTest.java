import Data.ArrangementData;
import Data.PersonData;
import Model.Arrangement;
import Model.Arrangor;
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

    @Test
    public void hentArrangorArrTest() {

        ArrangementData arrData = new ArrangementData();

        PersonData.genererBrukere();
        Arrangor arrangor1 = (Arrangor) PersonData.getBrukerListe().get(1);
        Arrangor arrangor2 = (Arrangor) PersonData.getBrukerListe().get(2);

        
        arrData.hentArrangorArr(arrangor1);
    }

}
