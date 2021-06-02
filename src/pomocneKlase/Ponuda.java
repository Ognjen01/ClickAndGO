package pomocneKlase;

import korisnici.Vozac;

public class Ponuda {
    private int idVoznje;
    private int idVozaca;
    private String korisnickoImeVozaca;
    private double prosjecnaOcjenaVozaca;
    private int brojVoznjiVozaca;
    private int vrijemeDolaska;
    private Vozac vozac;


    public Vozac getVozac() {
        return vozac;
    }

    public void setVozac(Vozac vozac) {
        this.vozac = vozac;
    }


    public int getIdVoznje() {
        return idVoznje;
    }

    public void setIdVoznje(int idVoznje) {
        this.idVoznje = idVoznje;
    }

    public int getIdVozaca() {
        return idVozaca;
    }

    public void setIdVozaca(int idVozaca) {
        this.idVozaca = idVozaca;
    }

    public String getKorisnickoImeVozaca() {
        return korisnickoImeVozaca;
    }

    public void setKorisnickoImeVozaca(String korisnickoImeVozaca) {
        this.korisnickoImeVozaca = korisnickoImeVozaca;
    }

    public double getProsjecnaOcjenaVozaca() {
        return prosjecnaOcjenaVozaca;
    }

    public void setProsjecnaOcjenaVozaca(double prosjecnaOcjenaVozaca) {
        this.prosjecnaOcjenaVozaca = prosjecnaOcjenaVozaca;
    }

    public int getBrojVoznjiVozaca() {
        return brojVoznjiVozaca;
    }

    public void setBrojVoznjiVozaca(int brojVoznjiVozaca) {
        this.brojVoznjiVozaca = brojVoznjiVozaca;
    }

    public int getVrijemeDolaska() {
        return vrijemeDolaska;
    }

    public void setVrijemeDolaska(int vrijemeDolaska) {
        this.vrijemeDolaska = vrijemeDolaska;
    }

    public Ponuda(
            int idVoznje,
            int idVozaca,
            String korisnickoImeVozaca,
            double prosjecnaOcjenaVozaca,
            int brojVoznjiVozaca,
            int vrijemeDolaska
    ){
        this.idVoznje = idVoznje;
        this.idVozaca = idVozaca;
        this.korisnickoImeVozaca = korisnickoImeVozaca;
        this.brojVoznjiVozaca = brojVoznjiVozaca;
        this.vrijemeDolaska = vrijemeDolaska;
        this.prosjecnaOcjenaVozaca = prosjecnaOcjenaVozaca;

    }


}
