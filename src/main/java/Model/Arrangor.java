package Model;

import Data.ArrangementData;

import java.util.ArrayList;

public class Arrangor extends Person {
    //Indrettslag som arrangør ha tilknyttning til må legges inn som klassevariabel
    String indrettslag;
    public Arrangor (String fornavn, String etternavn, int alder, String epost, String brukernavn, String passord, String idrettslag){
        super(fornavn,etternavn,alder,epost, brukernavn, passord);
        this.indrettslag =  idrettslag;
    }

    public ArrayList<Arrangement> getArrangorArrangement(){
        ArrayList<Arrangement> returnList = new ArrayList<>();
        for (Arrangement etArr:ArrangementData.getArrangementListe()){
            if (etArr.getArrangementEier().equals(this)){
                returnList.add(etArr);
            }
        }
        return returnList;
    }

    public String getIndrettslag() {
        return indrettslag;
    }

    public void setIndrettslag(String indrettslag){
        this.indrettslag = indrettslag;
    }

}
