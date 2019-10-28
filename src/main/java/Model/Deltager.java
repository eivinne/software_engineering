package Model;

import javafx.collections.ObservableList;

import java.time.LocalDate;
import java.util.ArrayList;

public class Deltager extends Person {
    private ArrayList<Arrangement> ferdigeArrangement = new ArrayList<>();
    private ArrayList<Arrangement> paameldteArrangement = new ArrayList<>();
    private ArrayList<Arrangement> interesserteArrangement = new ArrayList<>();

    public Deltager(String fornavn, String etternavn, int alder, String epost, String brukernavn, String passord){
        super(fornavn,etternavn,alder,epost, brukernavn, passord);
    }

    public void meldDegPaa(Arrangement arr){
        if (arr.getDato().isBefore(LocalDate.now()))
            System.out.println("Du kan ikke melde deg på tidligere arrangement");
        else {
            paameldteArrangement.add(arr);
            arr.leggTilDeltager(this);
        }

    }

    public void meldInteresse(Arrangement arr){
        if (arr.getDato().isBefore(LocalDate.now()))
            System.out.println("Du kan ikke melde deg på tidligere arrangement");
        else {
            interesserteArrangement.add(arr);
            arr.leggTilInteressert(this);
        }
    }

    public ArrayList<Arrangement> getPaameldteArrangement() {
        for(Arrangement etArrangemang: paameldteArrangement){
            if(etArrangemang.getDato().isBefore(LocalDate.now())) {
                if(paameldteArrangement.size()!=0) {
                    ferdigeArrangement.add(etArrangemang);
                    paameldteArrangement.remove(etArrangemang);
                }
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
