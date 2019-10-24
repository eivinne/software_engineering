package Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;

public class Arrangement {
    private String tittel, beskrivelse, dato, tidspunkt, lokasjon;
    private int aldersgrense;
    private ObservableList<Deltager> deltagerListe = FXCollections.observableArrayList();
    private Image arrangementsBilde;

    public Arrangement(String tittel, String beskrivelse, String dato, String tidspunkt, String lokasjon, int aldersgrense) {
        this.tittel = tittel;
        this.beskrivelse = beskrivelse;
        this.dato = dato;
        this.tidspunkt = tidspunkt;
        this.lokasjon = lokasjon;
        this.aldersgrense = aldersgrense;
    }
    public Arrangement(String tittel, String beskrivelse, String dato, String tidspunkt, String lokasjon) {
        this.tittel = tittel;
        this.beskrivelse = beskrivelse;
        this.dato = dato;
        this.tidspunkt = tidspunkt;
        this.lokasjon = lokasjon;
        this.aldersgrense = aldersgrense;
    }

    public Arrangement (String tittel) {
        this.tittel = tittel;
    }

    public void setDeltagerListe(ObservableList<Deltager> deltagerListe) {
        this.deltagerListe = deltagerListe;
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

    public String getDato() {
        return dato;
    }

    public void setDato(String dato) {
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

    public ObservableList<Deltager> getDeltagerListe() {
        return deltagerListe;
    }
}
