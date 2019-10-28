import Controller.arrangorController;
import Data.ArrangementData;
import Model.Arrangement;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.*;


public class arrangorControllerTest {


    //Sjekker om innholdet i de to listene er det samme før og etter omgjøring fra ArrayList til ObservableList.
    @Test
    void omgjorArrangementListeTest() {
        arrangorController tester = new arrangorController();
        ArrayList<Arrangement> expected = ArrangementData.hentArrangementData();
        ObservableList<Arrangement> actual = tester.omgjorArrangementListe(ArrangementData.hentArrangementData());

        assertEquals(expected, actual);

    }

}


    /*@Test
    void testTallUtskrift() throws TooNegativeException {
        TallUtskrift tester = new TallUtskrift();

        assertEquals("1", tester.tallUtskrift(1));
        assertEquals("17", tester.tallUtskrift(17));

        assertEquals("Hi", tester.tallUtskrift(3));
        assertEquals("Of", tester.tallUtskrift(5));

        assertEquals("HiOf", tester.tallUtskrift(15));
    }

    @ParameterizedTest
    @ValueSource(ints = { 3, 9, 27, 81 })
    void testDeleligMedTre(int argument) throws TooNegativeException {
        TallUtskrift tester2 = new TallUtskrift();
        assertEquals("Hi", tester2.tallUtskrift(argument));
    }*/
