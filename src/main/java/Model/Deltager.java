package Model;

import javafx.collections.ObservableList;

import java.util.ArrayList;

public class Deltager extends Person {
    private ArrayList<Arrangement> ferdigeArrangement;
    private ArrayList<Arrangement> kommendeArrangement;

    public Deltager(String fornavn, String etternavn, int alder, String epost, String brukernavn, String passord){
        super(fornavn,etternavn,alder,epost, brukernavn, passord);
    }

    /*public ArrayList<Arrangement> getKommendeArrangement() {
        //NB!!
        //Dummyfunskjon dato variabel må endres i arrangement
        for(Arrangement etArrangemang: kommendeArrangement){
            if(etArrangemang.getDato() != "123");
            {
                ferdigeArrangement.add(etArrangemang);
                kommendeArrangement.remove(etArrangemang);
            }
        }
        return kommendeArrangement;
    }*/

    public ArrayList<Arrangement> getFerdigeArrangement() {
        return ferdigeArrangement;
    }


}
