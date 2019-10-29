package Model;

import Controller.Controller;
import Data.PersonData;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public abstract class Person {
    private String fornavn;
    private String etternavn;
    private int alder;
    private String epost;
    private String brukernavn;
    private String passord;


    private Person rolle;


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
        Controller.setInnlogget(innlogget);
        System.out.println(innlogget);
        return returnInt;
    }

    public boolean erArrangor(){
        return this instanceof Arrangor;
    }


    public String getFornavn(){
        return fornavn;
    }

    public String getEtternavn() {
        return etternavn;
    }

    public int getAlder(){
        return alder;
    }

    public String getEpost(){
        return epost;
    }

    public String getPassord() {
        return passord;
    }

    public String getBrukernavn() {
        return brukernavn;
    }

    public void setFornavn(String fornavn) {
        this.fornavn = fornavn;
    }

    public void setEtternavn(String etternavn) {
        this.etternavn = etternavn;
    }

    public void setAlder(int alder) {
        this.alder = alder;
    }

    public void setEpost(String epost){
        this.epost = epost;
    }

    public void setPassord(String passord){
        this.passord = passord;
    }

    public void setBrukernavn(String brukernavn) {
        this.brukernavn = brukernavn;
    }
}
