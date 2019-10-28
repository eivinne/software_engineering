package Data;

import Model.Person;

import java.util.ArrayList;

public class PersonData {
    private static ArrayList<Person> brukerListe = new ArrayList<>();

    public static ArrayList<Person> getBrukerListe(){
        return brukerListe;
    }

}
