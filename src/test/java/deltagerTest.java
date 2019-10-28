import Model.Arrangement;
import Model.Deltager;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

public class deltagerTest {
    @Test //Tester at bruker kan melde seg på arrangemang.
    public void testPaamelding(){
        Deltager bruker = new Deltager("Sander","Kander",12,"kulKar123@hiof.no","Bruker","passord123");
        Arrangement etArr = new Arrangement("Birkebeiner løpet", "Det gås på ski", LocalDate.parse("2020-04-04"), "08:00", "Skogen", "Ski");
        bruker.meldDegPaa(etArr);
        assertTrue(bruker.getPaameldteArrangement().contains(etArr));
        assertTrue(etArr.getPaameldteListe().contains(bruker));
    }

}
