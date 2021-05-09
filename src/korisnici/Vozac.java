package korisnici;

import entiteti.Automobil;
import entiteti.Voznja;

import java.util.List;

public class Vozac extends Osoba {

    public List<Voznja> voznjeVozaca; // da li je ovo moguće jer je ovo apstraktna klasa, a u listi moraju biti i one narucene telefonom i aplikacijom
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
                 char pol,
                 String brojTelefona,
                 String uloga,
                 boolean aktivan,
                 int plata,
                 int brClanskeKarte,
                 Automobil automobil,
                 List<Voznja> voznjeVozaca, // Lista nije navedena u fajlu ona se navodi na osnovu id vozaca u listi voznji
                 double prosjecnaOcjena
    ) {
        super(idKorisnika, ime, prezime, korisnickoIme, lozinka, jmbg, adresa, pol, brojTelefona, uloga, aktivan);
        this.plata = plata;
        this.brClanskeKarte = brClanskeKarte;
        this.automobil = automobil;
        this.voznjeVozaca = voznjeVozaca;
        this.prosjecnaOcjena = prosjecnaOcjena;
    }

    // TODO: Dodati prazna polja ali ne i prazne zagrade kao do sada
    public Vozac() {
        // Generisati prazna polja Vozaca
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

    public void setVoznjeVozaca(List<Voznja> voznjeVozaca) {
        this.voznjeVozaca = voznjeVozaca;
    }

    public List<Voznja> getVoznjeVozaca() {
        return voznjeVozaca;
    }

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
}
