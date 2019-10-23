package Model;

import javafx.collections.ObservableList;

public class Deltager extends Person {
    private ObservableList<Arrangement> ferdigeArrangement;
    private ObservableList<Arrangement> kommendeArrangement;

    public Deltager(String fornavn, String etternavn, int alder, String epost, String brukernavn, String passord){
        super(fornavn,etternavn,alder,epost, brukernavn, passord);
    }

    public ObservableList<Arrangement> getKommendeArrangement() {
        //NB!!
        //Dummyfunskjon dato variabel må endres i arrangement
        //Kopieres også til getFerdigArrangement
        for(Arrangement etArrangemang: kommendeArrangement){
            if(etArrangemang.getDato() != "123");
            ferdigeArrangement.add(etArrangemang);
            kommendeArrangement.remove(etArrangemang);
        }
        return kommendeArrangement;
    }

    public ObservableList<Arrangement> getFerdigeArrangement() {
        return ferdigeArrangement;
    }


}
