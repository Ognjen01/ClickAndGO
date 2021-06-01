package korisnici;

import collections.list.DoublyLinkedList;
import entiteti.Automobil;
import entiteti.Voznja;
import enumeracije.Pol;

import java.util.List;

public class Vozac extends Osoba {

    public DoublyLinkedList<Voznja> voznjeVozaca; // TODO: DoublyLinkedList
    private int plata;
    private int brClanskeKarte;
    private Automobil automobil;
    private double prosjecnaOcjena;


    public Vozac(int idKorisnika,
                 String ime,
                 String prezime,
                 String korisnickoIme,
                 String lozinka,
                 String jmbg,
                 String adresa,
                 Pol pol,
                 String brojTelefona,
                 String uloga,
                 boolean aktivan,
                 int plata,
                 int brClanskeKarte,
                 Automobil automobil,
                 DoublyLinkedList<Voznja> voznjeVozaca,
                 double prosjecnaOcjena
    ) {
        super(idKorisnika, ime, prezime, korisnickoIme, lozinka, jmbg, adresa, pol, brojTelefona, uloga, aktivan);
        this.plata = plata;
        this.brClanskeKarte = brClanskeKarte;
        this.automobil = automobil;
        this.voznjeVozaca = voznjeVozaca;
        this.prosjecnaOcjena = prosjecnaOcjena;
    }

    public Vozac() {
        setIdKorisnika(0);
        setIme(null);
        setPrezime(null);
        setKorisnickoIme(null);
        setLozinka(null);
        setJmbg(null);
        setAdresa(null);
        setPol(null);
        setBrojTelefona(null);
        setUloga(null);
        setAktivan(false);
        setPlata(0);
        setBrClanskeKarte(0);
        setAutomobil(null);
        setVoznjeVozaca(null);
        setProsjecnaOcjena(0);
    }


    public int getPlata() {
        return plata;
    }


    public void setPlata(int plata) {
        this.plata = plata;
    }


    public int getBrClanskeKarte() {
        return brClanskeKarte;
    }


    public void setBrClanskeKarte(int brClanskeKarte) {
        this.brClanskeKarte = brClanskeKarte;
    }


    public Automobil getAutomobil() {
        return automobil;
    }


    public void setAutomobil(Automobil automobil) {
        this.automobil = automobil;
    }

    public double getProsjecnaOcjena() {
        return prosjecnaOcjena;
    }

    public void setProsjecnaOcjena(double prosjecnaOcjena) {
        this.prosjecnaOcjena = prosjecnaOcjena;
    }

    public void setVoznjeVozaca(DoublyLinkedList<Voznja> voznjeVozaca) {
        this.voznjeVozaca = voznjeVozaca;
    }

    public DoublyLinkedList<Voznja> getVoznjeVozaca() {
        return voznjeVozaca;
    } // TODO: DoublyLinkedList

    public String toString() {
        return idKorisnika + "|" +
                ime + "|" +
                prezime + "|" +
                korisnickoIme + "|" +
                lozinka + "|" +
                jmbg + "|" +
                adresa + "|" +
                pol + "|" +
                brojTelefona + "|" +
                uloga + "|" +
                aktivan + "|" +
                plata + "|" +
                brClanskeKarte + "|" +
                prosjecnaOcjena + "\n";
    }

    public String[] toArrayString(){

        // Sisitem za dodjelu auta i popunjavanje tabele
        String modelIIdAutomobila;
        if (getAutomobil() != null){
            modelIIdAutomobila = String.valueOf(getAutomobil().getAutomobilID());
        } else {
            modelIIdAutomobila = "Automobil nije dodjeljen";
        }


        String nizObjekata[] = new String[] {
          String.valueOf(idKorisnika),
                ime,
                prezime,
                korisnickoIme,
                jmbg,
                adresa,
                String.valueOf(pol),
                brojTelefona,
                String.valueOf(prosjecnaOcjena),
                String.valueOf(plata),
                modelIIdAutomobila
        };

        return nizObjekata;
    }
}
