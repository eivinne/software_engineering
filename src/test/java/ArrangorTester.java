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
        assertNotEquals(arrangor.getArrangorArrangement().size(),0);

        for(Arrangement etArrangement:arrangorSineArrangement) {
            assertSame(etArrangement.getArrangementEier(),arrangor);
        }

    }

    @Test
    public void erEierAvArrangementTest(){
        //Tester funksjon som skjekker om en Arrangør er eier av et arrangement
        Arrangor arrangor = (Arrangor) PersonData.getBrukerListe().get(1);
        Arrangor ikkeEier = (Arrangor) PersonData.getBrukerListe().get(2);
        ArrayList<Arrangement> arrangorSineArrangement = arrangor.getArrangorArrangement();

        assertTrue(arrangor.erEierAvArrangement(arrangorSineArrangement.get(0)));
        assertFalse(ikkeEier.erEierAvArrangement(arrangorSineArrangement.get(0)));
    }


}
