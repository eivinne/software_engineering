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

    public void meldPaaArrangement(Arrangement arr) {
            if(alleredeInteressert(arr)) {
                interesserteArrangement.remove(arr);
                arr.getInteresserteListe().remove(this);
            }
            arr.getPaameldteListe().add(this);
            paameldteArrangement.add(arr);
            Controller.setUtskriftString("Du er nå påmeldt!");
        }


    public void betalingIkkeGodkjent(){
        Controller.setUtskriftString("Betalingen ble ikke godkjent, vennligst prøv igjen.");
    }

    public void meldInteresse(Arrangement arr){
        if (!alleredeInteressert(arr) && !arr.harVaert() && !alleredePaameldt(arr)) {
            interesserteArrangement.add(arr);
            arr.getInteresserteListe().add(this);
            Controller.setUtskriftString(("Du er lagt til i listen av interesserte."));
        }
    }

    public boolean alleredePaameldt(Arrangement arr){
        if (paameldteArrangement.contains(arr)){
            Controller.setUtskriftString("Du er allerede påmeldt.");
            return true;
        }
        else
            return false;
    }

    private boolean alleredeInteressert(Arrangement arr){
        if (interesserteArrangement.contains(arr)) {
            Controller.setUtskriftString("Du er allerede satt som interessert.");
            return true;
        }
        else
            return false;
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
