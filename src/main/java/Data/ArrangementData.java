package Data;

import Controller.Controller;
import Model.Arrangement;
import Model.Deltager;
import Model.Person;

import java.time.LocalDate;
import java.util.ArrayList;

public class ArrangementData {


    private static ArrayList<Arrangement> arrangementListe = new ArrayList<>();

    public static ArrayList<Arrangement> getArrangementListe() {
        return arrangementListe;
    }

    public static void genererArrangement(){
        PersonData.genererBrukere();
        Person arrangor1 = PersonData.getBrukerListe().get(1);
        Person arrangor2 = PersonData.getBrukerListe().get(2);
        Deltager bruker = (Deltager) PersonData.getBrukerListe().get(0);
        Arrangement holmenkollStafetten = new Arrangement("Holmenkollstafetten", "Det jogges", LocalDate.parse("2020-03-03"), "12:00", "Holmenkollen", "Løp", arrangor1, 100);
        Arrangement haldenLopet = new Arrangement("Haldenløpet", "Det gås på ski", LocalDate.parse("2020-07-01"), "08:00", "Halden", "Ski", arrangor2,150);
        Arrangement bergensRittet = new Arrangement("Bergensrittet", "Det sykles", LocalDate.parse("2020-01-29"), "08:00", "Bergen", "Sykkel", arrangor1,400);
        Arrangement VM = new Arrangement("Verdensmesterskapet", "Det gås på ski", LocalDate.parse("2020-02-16"), "08:00", "Holmenkollen", "Ski", arrangor1,5000);
        Arrangement birkebeineren = new Arrangement("Birkebeineren", "Det gås på ski", LocalDate.parse("2020-09-24"), "08:00", "Halden", "Ski", arrangor2,120);
        Arrangement sentrumsLopet = new Arrangement("Sentrumsløpet", "Det jogges", LocalDate.parse("2018-05-29"), "08:00", "Oslo", "Løp", arrangor2,120);
        bruker.getFerdigeArrangement().add(sentrumsLopet);
    }

    public static ArrayList<Arrangement> getArrangementListeUtenArrangementerSomHarVaert() {
        ArrayList<Arrangement> returnList = new ArrayList<>();
        for(Arrangement etArr : arrangementListe) {
            if(etArr.getDato().isBefore(LocalDate.now())) {
                returnList.add(etArr);
            }
        }
        return returnList;
    }

    public static ArrayList<Arrangement> sokArr(String sok, String kategori) {
        ArrayList<Arrangement> returnArr = new ArrayList<>();
        if (sok.equalsIgnoreCase("") && kategori.equalsIgnoreCase("Alle kategorier")) {
            Controller.setUtskriftString("Skriv inn søkeord eller velg en kategori");
        }
        else {
            for (Arrangement etArr : arrangementListe) {
                if (kategori.equalsIgnoreCase("Alle kategorier") && (etArr.getTittel().toLowerCase().contains(sok.toLowerCase()) || etArr.getLokasjon().toLowerCase().contains(sok.toLowerCase()))) {
                    returnArr.add(etArr);
                } else if ((etArr.getTittel().toLowerCase().contains(sok.toLowerCase()) || etArr.getLokasjon().toLowerCase().contains(sok.toLowerCase())) && (etArr.getKategori().equals(kategori))) {
                    returnArr.add(etArr);
                }
            }
        }
        return returnArr;
    }

}
