package korisnici;

import entiteti.Voznja;

import java.util.List;

public class Musterija extends Osoba {
    private List<Voznja> voznjeMusterije;


    public Musterija(int idKorisnika,
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
                     List<Voznja> voznjeMusterije) {
        super(idKorisnika, ime, prezime, korisnickoIme, lozinka, jmbg, adresa, pol, brojTelefona, uloga, aktivan);
        this.voznjeMusterije = voznjeMusterije;
    }

    // Prazan konstruktor

    public Musterija() {
        // Generisati prazna polja Musterije
    }

    public void naruciVoznjuTelefonom() {

    }

    public void naruciVoznjuAplikacijom() {

    }

    @Override
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
                aktivan + "\n";
    }

    // Da li ima potrebe za Overide funkcijama iz klase Osoba??
}
