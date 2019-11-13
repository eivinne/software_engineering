package Model;

import Controller.Controller;
import Data.ArrangementData;
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

    public int getKapasitet() {
        return kapasitet;
    }

    public void setKapasitet(int kapasitet) {
        this.kapasitet = kapasitet;
    }

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
        this.kapasitet = kapasitet;
        ArrangementData.getArrangementListe().add(this);
    }

    public void hvisBetalingStatusGodkjentMeldPaaArrangement(boolean erGodkjent, Deltager deltager) {
        if(erGodkjent && !paameldteListe.contains(deltager)) {
            paameldteListe.add(deltager);
            deltager.getPaameldteArrangement().add(this);
            if(deltager.getInteresserteArrangement().contains(this)) {
                deltager.getInteresserteArrangement().remove(this);
            }
            if(interesserteListe.contains(deltager)) {
                interesserteListe.remove(deltager);
            }
            Controller.setUtskriftString("Du er nå påmeldt!");
            System.out.println(paameldteListe);
        }
        else{
            Controller.setUtskriftString("Betalingen ble ikke godkjent, vennligst prøv igjen.");
            System.out.println(paameldteListe);
        }
    }

    public boolean sjekkOmArrangementErFulltEllerHarVaert() {
        return  (!this.erFullt() && !this.harVaert());
    }

    //boolean som returnerer true om arrangementet er fullt
    public boolean erFullt(){
        if (antallLedigePlasser() <= 0) {
            Controller.setUtskriftString("Arrangementet er fullt!");
            return true;
        }
        else
            return false;
    }

    //boolean som returnerer true om arrangement allerede er over og setter en utskriftsstring
    public boolean harVaert(){
        if (this.dato.isBefore(LocalDate.now())) {
            Controller.setUtskriftString("Arrangementet har vært!");
            return true;
        }
        else
            return false;
    }

    public int antallLedigePlasser() {
        int ledigePlasser;
        ledigePlasser = this.getKapasitet() - this.paameldteListe.size();

        return ledigePlasser;
    }


    public Image getArrangementsBilde() {
        return arrangementsBilde;
    }

    public void setArrangementsBilde(Image arrangementsBilde) {
        this.arrangementsBilde = arrangementsBilde;
    }

    @Override
    public String toString() {
        return this.getTittel() + " " + this.getDato() + "  Sted: " + this.getLokasjon() + "  Kategori: " + this.getKategori();
    }

    public ArrayList<Deltager> getPaameldteListe(){
        return paameldteListe;
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

    public ArrayList<Deltager> getInteresserteListe() {
        return interesserteListe;
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

}
