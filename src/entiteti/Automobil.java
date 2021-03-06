package entiteti;

import enumeracije.TipVozila;

import java.sql.Date;

public class Automobil {

    private int automobilID;
    private String model;
    private String proizvodjac;
    private java.util.Date datumRegistracije;
    private int brojVozila;
    private String brojRegistracije;
    private TipVozila tipVozila;
    private int idVozaca;


    //konstruktori
    public Automobil() {
        setAutomobilID(0);
        setModel(null);
        setIdVozaca(0);
        setProizvodjac(null);
        setDatumRegistracije(null);
        setBrojVozila(0);
        setBrojRegistracije(null);
        setTipVozila(null);
    }

    @Override
    public String toString() {
        return automobilID + "|" +
                brojVozila + "|" +
                proizvodjac + "|" +
                model + "|" +
                getDatumRegistracijeString() + "|" +
                brojRegistracije + "|" +
                tipVozila + "|" +
                idVozaca + "\n";
    }

    public Automobil(
            int automobilID,
            int brojVozila,
            String proizvodjac,
            String model,
            java.util.Date datumRegistracije,
            String brojRegistracije,
            TipVozila tipVozila,
            int idVozaca) {
        this.model = model;
        this.proizvodjac = proizvodjac;
        this.datumRegistracije = datumRegistracije;
        this.brojVozila = brojVozila;
        this.brojRegistracije = brojRegistracije;
        this.tipVozila = tipVozila;
        this.automobilID = automobilID;
        this.idVozaca = idVozaca;
    }

    //geteri i seteri


    public int getIdVozaca() {
        return idVozaca;
    }

    public void setIdVozaca(int idVozaca) {
        this.idVozaca = idVozaca;
    }

    public TipVozila getTipVozila() {
        return tipVozila;
    }

    public void setTipVozila(TipVozila tipVozila) {
        this.tipVozila = tipVozila;
    }

    public void setAutomobilID(int automobilID) {
        this.automobilID = automobilID;
    }

    public void setDatumRegistracije(java.util.Date datumRegistracije) {
        this.datumRegistracije = datumRegistracije;
    }

    public int getAutomobilID() {
        return automobilID;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getProizvodjac() {
        return proizvodjac;
    }

    public void setProizvodjac(String proizvodjac) {
        this.proizvodjac = proizvodjac;
    }

    public java.util.Date getDatumRegistracije() {
        return datumRegistracije;
    }

    public void setDatumRegistracije(Date datumRegistracije) {
        this.datumRegistracije = datumRegistracije;
    }

    public int getBrojVozila() {
        return brojVozila;
    }

    public void setBrojVozila(int brojVozila) {
        this.brojVozila = brojVozila;
    }

    public String getBrojRegistracije() {
        return brojRegistracije;
    }

    public void setBrojRegistracije(String brojRegistracije) {
        this.brojRegistracije = brojRegistracije;
    }

    public String getDatumRegistracijeString(){
        String povratnaVrednost = "";
       povratnaVrednost += (datumRegistracije.getYear()+1900);
       povratnaVrednost += "-";
        if(datumRegistracije.getMonth()<10){
            povratnaVrednost += "0";
        }
        povratnaVrednost += datumRegistracije.getMonth()+1;
        povratnaVrednost += "-";

        if(datumRegistracije.getDate()<10){
            povratnaVrednost += "0";
        }
        povratnaVrednost += datumRegistracije.getDate();
        return povratnaVrednost;

    }

    public String[] toArrayString(){

        String nizObjekata[] = new String[] {
                String.valueOf(automobilID),
                model,
                proizvodjac,
                String.valueOf(datumRegistracije),
                String.valueOf(brojVozila),
                brojRegistracije,
                String.valueOf(tipVozila),
                String.valueOf(idVozaca)
        };

        return nizObjekata;
    }
}
