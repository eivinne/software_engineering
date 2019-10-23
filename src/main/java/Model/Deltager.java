package Model;

import javafx.collections.ObservableList;

public class Deltager extends Person {
    private ObservableList<Arrangement> ferdigeArrangement;
    private ObservableList<Arrangement> kommendeArrangement;

    public Deltager(String fornavn, String etternavn, int alder, String epost,String brukernavn, String passord){
        super(fornavn,etternavn,alder,epost, brukernavn, passord);
    }

    public ObservableList<Arrangement> getFerdigeArrangement() {
        return ferdigeArrangement;
    }

    public ObservableList<Arrangement> getKommendeArrangement() {
        return kommendeArrangement;
    }
}
