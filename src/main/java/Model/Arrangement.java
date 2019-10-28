package Model;

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

    public Arrangement(String tittel, String beskrivelse, LocalDate dato, String tidspunkt, String lokasjon, int aldersgrense, String kategori) {
        this.tittel = tittel;
        this.beskrivelse = beskrivelse;
        this.dato = dato;
        this.tidspunkt = tidspunkt;
        this.lokasjon = lokasjon;
        this.aldersgrense = aldersgrense;
        this.kategori = kategori;
        ArrangementData.getArrangementListe().add(this);

    }
    public Arrangement(String tittel, String beskrivelse, LocalDate dato, String tidspunkt, String lokasjon, String kategori) {
        this.tittel = tittel;
        this.beskrivelse = beskrivelse;
        this.dato = dato;
        this.tidspunkt = tidspunkt;
        this.lokasjon = lokasjon;
        this.kategori = kategori;
        ArrangementData.getArrangementListe().add(this);
    }

    public Arrangement (String tittel) {
        this.tittel = tittel;
    }

    public void leggTilDeltager(Deltager deltager){
        paameldteListe.add(deltager);
    }

    public void leggTilInteressert(Deltager deltager){
        interesserteListe.add(deltager);
    }


    @Override
    public String toString() {
        return this.getTittel() + " " + this.getDato();
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
}
