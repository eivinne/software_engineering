import Data.ArrangementData;
import Data.PersonData;
import Model.Arrangement;
import Model.Arrangor;
import Model.Deltager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

public class ArrangorTester {

    @BeforeAll
    public static void setup() {

        ArrangementData.genererArrangement();
    }

    //Knyttet til krav 4.8.b.1 - arrangorer skal kunne se hvilke arrangement de eier.
    @Test
    public void getArrangorArrangementTest() {
        Arrangor arrangor = (Arrangor) PersonData.getBrukerListe().get(1);
        ArrayList<Arrangement> alleArrangement = ArrangementData.getArrangementListe();
        ArrayList<Arrangement> arrangorSineArrangement = arrangor.getArrangorArrangement();

        assertNotEquals(alleArrangement, arrangorSineArrangement);
        assertFalse(arrangor.getArrangorArrangement().size() == 0);

        for(Arrangement etArrangement:arrangorSineArrangement) {
            assertTrue(etArrangement.getArrangementEier() == arrangor);
        }




    }


}
