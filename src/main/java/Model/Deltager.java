package Model;

import javafx.collections.ObservableList;

import java.time.LocalDate;
import java.util.ArrayList;

public class Deltager extends Person {
    private ArrayList<Arrangement> ferdigeArrangement;
    private ArrayList<Arrangement> paameldteArrangement;
    private ArrayList<Arrangement> interesserteArrangement;

    public Deltager(String fornavn, String etternavn, int alder, String epost, String brukernavn, String passord){
        super(fornavn,etternavn,alder,epost, brukernavn, passord);
    }

    public void meldDegPaa(Arrangement arr){
        paameldteArrangement.add(arr);
    }

    public void meldInteresse(Arrangement arr){
        interesserteArrangement.add(arr);
    }

    public ArrayList<Arrangement> getpaameldteArrangement() {
        for(Arrangement etArrangemang: paameldteArrangement){
            if(etArrangemang.getDato().isBefore(LocalDate.now())) {
                ferdigeArrangement.add(etArrangemang);
                paameldteArrangement.remove(etArrangemang);
            }
        }
        return paameldteArrangement;
    }

    public ArrayList<Arrangement> getInteresserteArrangement(){
        for(Arrangement etArrangemang: interesserteArrangement){
            if(etArrangemang.getDato().isBefore(LocalDate.now()))
                interesserteArrangement.remove(etArrangemang);
        }
        return interesserteArrangement;
    }

    public ArrayList<Arrangement> getFerdigeArrangement() {
        return ferdigeArrangement;
    }

}
