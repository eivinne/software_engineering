package Model;

public abstract class Person {
    private String fornavn;
    private String etternavn;
    private int alder;
    private String epost;
    private String passord;


    public Person(String fornavn, String etternavn, int alder, String epost, String passord){
        this.fornavn = fornavn;
        this.etternavn = etternavn;
        this.alder = alder;
        this.epost = epost;
        this.passord = passord;

    }

    public String getFornavn(){
        return fornavn;
    }

    public String getEtternavn() {
        return etternavn;
    }

    public int getAlder(){
        return alder;
    }

    public String getEpost(){
        return epost;
    }

    //Lage en getter for passord


    public void setFornavn(String fornavn) {
        this.fornavn = fornavn;
    }

    public void setEtternavn(String etternavn) {
        this.etternavn = etternavn;
    }

    public void setAlder(int alder) {
        this.alder = alder;
    }

    public void setEpost(String epost){
        this.epost = epost;
    }

    public void setPassord(String passord){
        this.passord = passord;
    }
}