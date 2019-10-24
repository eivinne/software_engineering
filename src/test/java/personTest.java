import Model.Arrangor;
import Model.Deltager;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class personTest {
    @Test
    public void rolleTest(){
        //Rolletest
        Deltager bruker = new Deltager("Sander","Kander",12,"kulKar123@hiof.no","Bruker","passord123");
        Arrangor arrangor = new Arrangor("Maria","Casino",14,"minsLike@kul.no","Arrangør","drossap123","Gamblers");
        assertTrue(true,);

    }
}
