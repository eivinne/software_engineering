import Model.Arrangement;
import Model.Arrangor;
import Model.Deltager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

public class deltagerTest {
    static Deltager bruker;
    static Arrangor arrangor1;
    static Arrangement etArr;
    static Arrangement gammeltArr;

    @BeforeAll
    public static void setup() {
        bruker = new Deltager("Sander", "Kander", 12, "kulKar123@hiof.no", "Bruker", "passord123");
        arrangor1 = new Arrangor("Maria", "Casino", 14, "minstLike@kul.no", "Arrangør1", "drossap123", "Gamblers");
        etArr = new Arrangement("Birkebeiner løpet", "Det gås på ski", LocalDate.parse("2020-04-04"), "08:00", "Skogen", "Ski", arrangor1, 123);
        gammeltArr = new Arrangement("Gått ut på dato", "Finnes ikke lenger", LocalDate.parse("2018-10-10"), "09:00", "Borte", 13, "Ski", arrangor1, 123);
    }

    @Test //Tester at bruker kan melde seg på arrangemang og at listene blir oppdatert.
    public void meldInteresseTest(){
        bruker.meldInteresse(etArr);
        //Sjkker at det er mulig å melde interesse for kommende arrangement
        assertTrue(bruker.getInteresserteArrangement().contains(etArr));

        //sjekker at det ikke er mulig å melde interesse for gamle arrangement
        bruker.meldInteresse(gammeltArr);
        assertFalse(bruker.getInteresserteArrangement().contains(gammeltArr));
    }

    @Test
    public void arrangementPaameldingTest(){
        etArr.hvisBetalingStatusGodkjentMeldPaaArrangement(true,bruker);
        assertTrue(bruker.getPaameldteArrangement().contains(etArr));
        assertTrue(etArr.getPaameldteListe().contains(bruker));
    }

    @Test
    public void sjekkOmArrangementErFulltEllerHarVaertTest(){
        //gammeltArr.sjekkOmArrangementErFulltEllerHarVaert()
    }
}
