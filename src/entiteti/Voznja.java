package entiteti;

import enumeracije.StatusVoznje;
import jdk.jshell.Snippet;
import korisnici.Musterija;
import korisnici.Vozac;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Voznja {

    private int idVoznje;
    private int idVozaca;
    private int idMusterije;
    private String adresaPolaska;
    private String adresaDestinacije;
    private StatusVoznje status;
    private double duzina;
    private double trajanje;
    private int cenaPoKilometru = 60;
    private int cenaStarta = 100;
    private int cenaVoznje;
    private Date vremeNarudzbine;
    private Musterija musterija;
    private Vozac vozac;
    private int cijena;
    private boolean ocjenjena;


    public Voznja(
            int idVoznje,
            int idVozaca,
            int idMusterije,
            String adresaPolaska,
            String adresaDestinacije,
            StatusVoznje status,
            double duzina,
            double trajanje,
            int cenaVoznje,
            Date vremeNarudzbine,
            Musterija musterija,
            Vozac vozac,
            boolean ocjenjena) {

        this.adresaPolaska = adresaPolaska;
        this.adresaDestinacije = adresaDestinacije;
        this.status = status;
        this.duzina = duzina;
        this.trajanje = trajanje;
        this.cenaPoKilometru = cenaPoKilometru;
        this.cenaStarta = cenaStarta;
        this.vremeNarudzbine = vremeNarudzbine;
        this.musterija = musterija;
        this.vozac = vozac;
        this.idMusterije = idMusterije;
        this.idVoznje = idVoznje;
        this.idVozaca = idVozaca;
        this.cenaVoznje = cenaVoznje;
        this.ocjenjena = ocjenjena;
    }

    public boolean isOcjenjena() {
        return ocjenjena;
    }

    public void setOcjenjena(boolean ocjenjena) {
        this.ocjenjena = ocjenjena;
    }

    public int getIdMusterije() {
        return idMusterije;
    }

    public void setIdMusterije(int idMusterije) {
        this.idMusterije = idMusterije;
    }

    public int getIdVozaca() {
        return idVozaca;
    }

    public void setIdVozaca(int idVozaca) {
        this.idVozaca = idVozaca;
    }

    public int getIdVoznje() {
        return idVoznje;
    }

    public void setIdVoznje(int idVoznje) {
        this.idVoznje = idVoznje;
    }

    public String getAdresaPolaska() {
        return adresaPolaska;
    }

    public void setAdresaPolaska(String adresaPolaska) {
        this.adresaPolaska = adresaPolaska;
    }

    public String getAdresaDestinacije() {
        return adresaDestinacije;
    }

    public void setAdresaDestinacije(String adresaDestinacije) {
        this.adresaDestinacije = adresaDestinacije;
    }

    public StatusVoznje getStatus() {
        return status;
    }

    public void setStatus(StatusVoznje status) {
        this.status = status;
    }

    public double getDuzina() {
        return duzina;
    }

    public void setDuzina(int duzina) {
        this.duzina = duzina;
    }

    public double getTrajanje() {
        return trajanje;
    }

    public void setTrajanje(int trajanje) {
        this.trajanje = trajanje;
    }

    public int getCenaPoKilometru() {
        return cenaPoKilometru;
    }

    public void setCenaPoKilometru(int cenaPoKilometru) {
        this.cenaPoKilometru = cenaPoKilometru;
    }

    public int getCenaStarta() {
        return cenaStarta;
    }

    public void setCenaStarta(int cenaStarta) {
        this.cenaStarta = cenaStarta;
    }

    public int getCenaVoznje() {
        return cenaVoznje;
    }

    public void setCenaVoznje(int cenaVoznje) {
        this.cenaVoznje = cenaVoznje;
    }

    public Date getVremeNarudzbine() {
        return vremeNarudzbine;
    }

    public void setVremeNarudzbine(Date vremeNarudzbine) {
        this.vremeNarudzbine = vremeNarudzbine;
    }

    public Musterija getMusterija() {
        return musterija;
    }

    public void setMusterija(Musterija musterija) {
        this.musterija = musterija;
    }

    public Vozac getVozac() {
        return vozac;
    }

    public void setVozac(Vozac vozac) {
        this.vozac = vozac;
    }

    public Voznja() {
        setIdVozaca(0);
        setIdMusterije(0);
        setIdVoznje(0);
        setAdresaDestinacije(null);
        setAdresaPolaska(null);
        setStatus(null);
        setDuzina(0);
        setTrajanje(0);
        setCenaVoznje(0);
        setVremeNarudzbine(null);
        setMusterija(null);
        setVozac(null);
    }

    @Override
    public String toString() {
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
        String datum = df.format(vremeNarudzbine);

        return idVoznje + "|" +
                idVozaca + "|" +
                idMusterije + "|" +
                adresaPolaska + "|" +
                adresaDestinacije + "|" +
                status + "|" +
                duzina + "|" +
                trajanje + "|" +
                cenaVoznje + "|" +
                datum + "|";

    }

    public String[] toStringArray(){
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
        //String datum = df.format(vremeNarudzbine);

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        System.out.println(vremeNarudzbine + getAdresaDestinacije());
        System.out.println(formatter.format(vremeNarudzbine));
        String datum = formatter.format(vremeNarudzbine);

        String nizObjekat[] = new String[] {
                String.valueOf(idVoznje),
        String.valueOf(idMusterije),
        String.valueOf(idVozaca),
        adresaPolaska,
        adresaDestinacije,
                String.valueOf(status),
        String.valueOf(duzina),
        String.valueOf(trajanje),
        String.valueOf(cenaVoznje),
        datum,
        null,
        null};
        return  nizObjekat;
    }
}

