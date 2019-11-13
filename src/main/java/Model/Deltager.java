package Model;

import Controller.Controller;

import java.time.LocalDate;
import java.util.ArrayList;

public class Deltager extends Person {
    private ArrayList<Arrangement> ferdigeArrangement = new ArrayList<>();
    private ArrayList<Arrangement> paameldteArrangement = new ArrayList<>();
    private ArrayList<Arrangement> interesserteArrangement = new ArrayList<>();

    public Deltager(String fornavn, String etternavn, int alder, String epost, String brukernavn, String passord){
        super(fornavn,etternavn,alder,epost, brukernavn, passord);
    }

    public void meldInteresse(Arrangement arr){
        boolean alleredeIListe = interesserteArrangement.contains(arr);
        if (!alleredeIListe && !arr.harVaert()) {
            interesserteArrangement.add(arr);
            arr.getInteresserteListe().add(this);
            Controller.setUtskriftString(("Du er lagt til i listen av interesserte."));
        } else if (alleredeIListe) {
            Controller.setUtskriftString("Du er allerede lagt til i listen av interesserte.");
        }
    }



    public ArrayList<Arrangement> getInteresserteArrangement(){
        oppdaterInteresseListe();
        return interesserteArrangement;
    }

    public ArrayList<Arrangement> getPaameldteArrangement() {
        oppdaterPaameldtListe();
        return paameldteArrangement;
    }

    public void oppdaterPaameldtListe(){
        for(Arrangement etArrangement: paameldteArrangement){
            if(etArrangement.harVaert()) {
                if(!paameldteArrangement.isEmpty()) {
                    ferdigeArrangement.add(etArrangement);
                    paameldteArrangement.remove(etArrangement);
                }
            }
        }
    }

    public void oppdaterInteresseListe(){
        for(Arrangement etArrangement: interesserteArrangement){
            if(etArrangement.harVaert())
                interesserteArrangement.remove(etArrangement);
        }
    }



    public ArrayList<Arrangement> getFerdigeArrangement() {
        return ferdigeArrangement;
    }

}
