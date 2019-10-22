package Model;

public class Arrangor extends Person {
    //Indrettslag som arrangør ha tilknyttning til må legges inn som klassevariabel
    String indrettslag;
    public Arrangor (String fornavn, String etternavn, int alder, String epost, String passord, String idrettslag){
        super(fornavn,etternavn,alder,epost,passord);
        this.indrettslag =  idrettslag;
    }

    public String getIndrettslag() {
        return indrettslag;
    }

    public void setIndrettslag(String indrettslag){
        this.indrettslag = indrettslag;
    }
}
