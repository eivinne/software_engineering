package Data;

import Model.Arrangor;
import Model.Deltager;
import Model.Person;

import java.util.ArrayList;

public class PersonData {
    private static ArrayList<Person> brukerListe = new ArrayList<>();


    public static void genererBrukere() {
        Deltager bruker = new Deltager("Sander", "Kander", 12, "kulKar123@hiof.no", "Bruker", "passord123");
        Arrangor arrangor1 = new Arrangor("Maria", "Casino", 14, "minstLike@kul.no", "Arrangør1", "drossap123", "Gamblers");
        Arrangor arrangor2 = new Arrangor("Roger", "Jebus", 94, "nestenLike@kul.no", "Arrangør2", "drossap123", "Halden IF");
        Deltager bruker2 = new Deltager("Husein","D",25,"husein@husein.no","huseind","niesuh");

    }

    public static ArrayList<Person> getBrukerListe(){
        return brukerListe;
    }

}
