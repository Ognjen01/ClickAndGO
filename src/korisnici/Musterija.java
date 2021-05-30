package korisnici;

import entiteti.Voznja;
import enumeracije.Pol;

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
                     Pol pol,
                     String brojTelefona,
                     String uloga,
                     boolean aktivan,
                     List<Voznja> voznjeMusterije) {
        super(idKorisnika, ime, prezime, korisnickoIme, lozinka, jmbg, adresa, pol, brojTelefona, uloga, aktivan);
        this.voznjeMusterije = voznjeMusterije;
    }

    // Prazan konstruktor

    public Musterija() {
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

    public String[] toArrayString(){

        String nizObjekata[] = new String[] {
                String.valueOf(idKorisnika),
                ime,
                prezime,
                korisnickoIme,
                jmbg,
                adresa,
                String.valueOf(pol),
                brojTelefona
        };

        return nizObjekata;
    }
}
