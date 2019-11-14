package Model;

import Data.PersonData;

public abstract class Person {
    public static Person innlogget;
    private String fornavn;
    private String etternavn;
    private int alder;
    private String epost;
    private String brukernavn;
    private String passord;


    public Person(String fornavn, String etternavn, int alder, String epost, String brukernavn, String passord){
        this.fornavn = fornavn;
        this.etternavn = etternavn;
        this.alder = alder;
        this.epost = epost;
        this.brukernavn = brukernavn;
        this.passord = passord;
        PersonData.getBrukerListe().add(this);
    }

    public static int validerBruker(String inptBruker, String inptPassord){
        int returnInt = -1;
        Person innlogget = null;
        for (Person enPerson : PersonData.getBrukerListe()){
            if(enPerson.brukernavn.equals(inptBruker)&& enPerson.passord.equals(inptPassord)){
                if(enPerson.erArrangor()) {
                    returnInt = 1;
                }
                else  {
                    returnInt = 0;
                }
                innlogget = enPerson;
                break;
            }
        }
        if (innlogget != null)
        setInnlogget(innlogget);
        else
            resettInnlogget();
        return returnInt;
    }

    public static Person getInnlogget(){
        return innlogget;
    }

    public static void setInnlogget(Person person){
        innlogget = person;
    }

    public static void resettInnlogget(){
        innlogget = null;
    }

    public boolean erArrangor(){
        return this instanceof Arrangor;
    }
}
