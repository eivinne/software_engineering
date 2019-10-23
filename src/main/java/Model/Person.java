package Model;

import javafx.collections.ObservableList;

import java.util.ArrayList;

public abstract class Person {
    private String fornavn;
    private String etternavn;
    private int alder;
    private String epost;
    private String brukernavn;
    private String passord;

    private static ArrayList<Person> brukerListe = new ArrayList<>();



    public Person(String fornavn, String etternavn, int alder, String epost, String brukernavn, String passord){
        this.fornavn = fornavn;
        this.etternavn = etternavn;
        this.alder = alder;
        this.epost = epost;
        this.brukernavn = brukernavn;
        this.passord = passord;
        brukerListe.add(this);



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

    public static ArrayList<Person> getBrukerListe(){
        return brukerListe;
    }
}
