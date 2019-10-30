package Model;

import Controller.brukerForsideController;
import Data.ArrangementData;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;

import java.time.LocalDate;
import java.util.ArrayList;

public class Arrangement {
    private String tittel, beskrivelse, tidspunkt, lokasjon;
    private LocalDate dato;
    private int aldersgrense;
    private ArrayList<Deltager> paameldteListe = new ArrayList<>();
    private ArrayList<Deltager> interesserteListe = new ArrayList<>();
    private Image arrangementsBilde;
    private String kategori;
    private Person arrangementEier;
    private int kapasitet;
    private int ledigePlasser;
    private boolean betaling;

    public Arrangement(String tittel, String beskrivelse, LocalDate dato, String tidspunkt, String lokasjon, int aldersgrense, String kategori, Person arrangementEier, int kapasitet) {
        this.tittel = tittel;
        this.beskrivelse = beskrivelse;
        this.dato = dato;
        this.tidspunkt = tidspunkt;
        this.lokasjon = lokasjon;
        this.aldersgrense = aldersgrense;
        this.kategori = kategori;
        this.arrangementEier = arrangementEier;
        this.kapasitet = kapasitet;
        ArrangementData.getArrangementListe().add(this);

    }
    public Arrangement(String tittel, String beskrivelse, LocalDate dato, String tidspunkt, String lokasjon, String kategori, Person arrangementEier, int kapasitet) {
        this.tittel = tittel;
        this.beskrivelse = beskrivelse;
        this.dato = dato;
        this.tidspunkt = tidspunkt;
        this.lokasjon = lokasjon;
        this.kategori = kategori;
        this.arrangementEier = arrangementEier;
        ArrangementData.getArrangementListe().add(this);
    }

    public Arrangement (String tittel) {
        this.tittel = tittel;
    }

    public boolean sjekkOmArrangementErFulltEllerHarVaert() {
        if(kapasitet <= paameldteListe.size()) {
            System.out.println("Arrangementet er fullt! Du får ikke meldt deg på.");
            return false;
        }
        else if (this.getDato().isBefore(LocalDate.now())) {
            System.out.println("Du kan ikke melde deg på tidligere arrangement");
            return false;
        }
        else {
            return true;
        }
    }

    public void hvisBetalingStatusGodkjentMeldPaaArrangement(boolean erGodkjent, Deltager deltager) {
        if(erGodkjent) {
            paameldteListe.add(deltager);
            System.out.println("Du er nå påmeldt!");
            System.out.println(paameldteListe);
        }else{
            System.out.println("Betalingen ble ikke godkjent, vennligst prøv igjen.");
            System.out.println(paameldteListe);
        }
    }

    /*public int leggTilDeltager(Deltager deltager, boolean betalingOK){
        int returnInt = -1;
        if(!betalingOK){
            System.out.println("INGEN FATTIGE!");
        }
        else if (this.getDato().isBefore(LocalDate.now())) {
            System.out.println("Du kan ikke melde deg på tidligere arrangement");
            returnInt = 0;
        }
        else {
            returnInt = 1;
            deltager.meldDegPaa(this);
            paameldteListe.add(deltager);
        }
        return returnInt;
    }

    public int leggTilInteressert(Deltager deltager){
        int returnInt = -1;
        if (!this.getDato().isBefore(LocalDate.now()))
        interesserteListe.add(deltager);

        return returnInt;
    }*/


    @Override
    public String toString() {
        return this.getTittel() + " " + this.getDato() + " Kategori: " + this.getKategori();
    }

    public Image getArrangementsBilde() {
        return arrangementsBilde;
    }

    public void setArrangementsBilde(Image arrangementsBilde) {
        this.arrangementsBilde = arrangementsBilde;
    }

    public String getTittel() {
        return tittel;
    }

    public void setTittel(String tittel) {
        this.tittel = tittel;
    }

    public String getBeskrivelse() {
        return beskrivelse;
    }

    public void setBeskrivelse(String beskrivelse) {
        this.beskrivelse = beskrivelse;
    }

    public LocalDate getDato() {
        return dato;
    }

    public void setDato(LocalDate dato) {
        this.dato = dato;
    }

    public String getTidspunkt() {
        return tidspunkt;
    }

    public void setTidspunkt(String tidspunkt) {
        this.tidspunkt = tidspunkt;
    }

    public String getLokasjon() {
        return lokasjon;
    }

    public void setLokasjon(String lokasjon) {
        this.lokasjon = lokasjon;
    }

    public int getAldersgrense() {
        return aldersgrense;
    }

    public void setAldersgrense(int aldersgrense) {
        this.aldersgrense = aldersgrense;
    }

    public ArrayList<Deltager> getPaameldteListe() {
        return paameldteListe;
    }

    public void setPaameldteListe(ArrayList<Deltager> paameldteListe) {
        this.paameldteListe = paameldteListe;
    }

    public ArrayList<Deltager> getInteresserteListe() {
        return interesserteListe;
    }

    public void setInteresserteListe(ArrayList<Deltager> interesserteListe) {
        this.interesserteListe = interesserteListe;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public Person getArrangementEier() {
        return arrangementEier;
    }

    public void setArrangementEier(Person arrangementEier) {
        this.arrangementEier = arrangementEier;
    }

}
