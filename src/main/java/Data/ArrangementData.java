package Data;

import Model.Arrangement;
import Model.Arrangor;
import Model.Person;

import java.time.LocalDate;
import java.util.ArrayList;

public class ArrangementData {


    private static ArrayList<Arrangement> arrangementListe = new ArrayList<>();

    public static ArrayList<Arrangement> getArrangementListe() {
        return arrangementListe;
    }

    public static void genererArrangement(){
        Person arrangor1 = PersonData.getBrukerListe().get(1);
        Person arrangor2 = PersonData.getBrukerListe().get(2);
        Arrangement holmenKollStafetten = new Arrangement("Holmenkoll Stafetten", "Det jogges", LocalDate.parse("2020-03-03"), "12:00", "Holmenkollen", "Loping", arrangor1, 100);
        Arrangement birkebeineren = new Arrangement("Birkebeiner løpet", "Det gås på ski", LocalDate.parse("2020-04-04"), "08:00", "Skogen", "Ski", arrangor2,150);
    }


    public static ArrayList<Arrangement> sokArr(String sok){
        ArrayList<Arrangement> returnArr = new ArrayList<>();
        for(Arrangement etArr: arrangementListe){
            if (etArr.getTittel().toLowerCase().contains(sok.toLowerCase()) || etArr.getLokasjon().toLowerCase().contains(sok.toLowerCase()))
                returnArr.add(etArr);
        }
        return returnArr;
    }

    public static ArrayList<Arrangement> sokArr(String sok, String kategori){
        ArrayList<Arrangement> returnArr = new ArrayList<>();
        for (Arrangement etArr:arrangementListe){
            if (etArr.getKategori().equals(kategori)){
                if (!sok.equals("")){
                    if (etArr.getTittel().toLowerCase().contains(sok.toLowerCase()) || etArr.getLokasjon().toLowerCase().contains(sok.toLowerCase()))
                        returnArr.add(etArr);
                }
                else
                    returnArr.add(etArr);
            }
        }
        return returnArr;
    }

    public static ArrayList<Arrangement> hentArrangorArr(Arrangor arrangor){
        ArrayList<Arrangement> returnList = new ArrayList<>();
        for (Arrangement etArr:arrangementListe){
            if (etArr.getArrangementEier() == arrangor){
                returnList.add(etArr);
            }
        }
        return returnList;
    }

}
