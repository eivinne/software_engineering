import Model.Arrangement;
import Model.Arrangor;
import Model.Deltager;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

public class deltagerTest {
    Deltager bruker = new Deltager("Sander","Kander",12,"kulKar123@hiof.no","Bruker","passord123");
    Arrangor arrangor1 = new Arrangor("Maria", "Casino", 14, "minstLike@kul.no", "Arrangør1", "drossap123", "Gamblers");
    Arrangement etArr = new Arrangement("Birkebeiner løpet", "Det gås på ski", LocalDate.parse("2020-04-04"), "08:00", "Skogen", "Ski",arrangor1,123);
    Arrangement gammeltArr = new Arrangement("Gått ut på dato","Finnes ikke lenger",LocalDate.parse("2018-10-10"),"09:00","Borte",13,"Ski",arrangor1,123);

    @Test //Tester at bruker kan melde seg på arrangemang og at listene blir oppdatert.
    public void testPaamelding(){
        bruker.meldDegPaa(etArr);

        //Sjkker at det er mulig å melde seg på kommende arrangement
        assertTrue(bruker.getPaameldteArrangement().contains(etArr));

        //skjerkker at det ikke er mulig å melde seg på tidligere arrangement

    }

    @Test //Tester at bruker kan melde interesse
    public void testInterresert(){
        bruker.meldInteresse(etArr);
        bruker.meldInteresse(gammeltArr);

        //sjekker at man kan interessere seg i kommende arrangement
        assertTrue(bruker.getInteresserteArrangement().contains(etArr));

        //sjekker at det det ikke er mulig å melde interesse på tidligere arrangement
        assertFalse(bruker.getInteresserteArrangement().contains(gammeltArr));
    }



}
