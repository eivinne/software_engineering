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
        Arrangement holmenKollStafetten = new Arrangement("Holmenkoll Stafetten", "Det jogges", LocalDate.parse("2020-03-03"), "12:00", "Holmenkollen", "Løp", arrangor1, 100);
        Arrangement haldenLopet = new Arrangement("Halden løpet", "Det gås på ski", LocalDate.parse("2020-07-01"), "08:00", "Halden", "Ski", arrangor2,150);
        Arrangement bergensRittet = new Arrangement("Bergens Rittet", "Det gås på ski", LocalDate.parse("2020-01-29"), "08:00", "Bergen", "Sykkel", arrangor1,400);
        Arrangement VM = new Arrangement("Verdensmesterskapet", "Det gås på ski", LocalDate.parse("2020-02-16"), "08:00", "Holmenkollen", "Ski", arrangor1,5000);
        Arrangement birkebeineren = new Arrangement("Birkebeiner løpet", "Det gås på ski", LocalDate.parse("2020-09-24"), "08:00", "Halden", "Ski", arrangor2,120);
    }


    /*public static ArrayList<Arrangement> sokArr(String sok){
        ArrayList<Arrangement> returnArr = new ArrayList<>();
        for(Arrangement etArr: arrangementListe){
            if (etArr.getTittel().toLowerCase().contains(sok.toLowerCase()) || etArr.getLokasjon().toLowerCase().contains(sok.toLowerCase()))
                returnArr.add(etArr);
        }
        return returnArr;
    }*/

    public static ArrayList<Arrangement> sokArr(String sok, String kategori) {
        ArrayList<Arrangement> returnArr = new ArrayList<>();
        for (Arrangement etArr:arrangementListe){
            if(sok == "" && kategori == "") {
                returnArr = arrangementListe;
                System.out.println(arrangementListe);
                return returnArr;
            }
            if(kategori == "") {
                if (etArr.getTittel().toLowerCase().contains(sok.toLowerCase()) || etArr.getLokasjon().toLowerCase().contains(sok.toLowerCase()))
                    returnArr.add(etArr);
            } else {
                if ((etArr.getTittel().toLowerCase().contains(sok.toLowerCase()) || etArr.getLokasjon().toLowerCase().contains(sok.toLowerCase())) && (etArr.getKategori().equals(kategori))) {
                    returnArr.add(etArr);
                }
            }
        }
        return returnArr;
    }

    /*public static ArrayList<Arrangement> sokArr(String sok, String kategori){
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
    }*/


}
