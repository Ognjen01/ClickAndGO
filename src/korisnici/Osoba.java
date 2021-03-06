package korisnici;

import collections.list.DoublyLinkedList;
import entiteti.Voznja;
import enumeracije.Pol;

import java.util.ArrayList;
import java.util.List;

public abstract class Osoba {

    protected int idKorisnika;
    protected String ime;
    protected String prezime;
    protected String korisnickoIme;
    protected String lozinka;
    protected String jmbg; // Mora biti string jer pojedini jmbg počinju sa 0
    protected String adresa;
    protected Pol pol;
    protected String brojTelefona;
    protected String uloga;
    protected boolean aktivan;
    protected DoublyLinkedList<Voznja> lisaVoznji; // TODO: DoublyLinkedList


    Osoba(int idKorisnika,
          String ime,
          String prezime,
          String korisnickoIme,
          String lozinka,
          String jmbg,
          String adresa,
          Pol pol,
          String brojTelefona,
          String uloga,
          boolean aktivan) {

        this.idKorisnika = idKorisnika;
        this.ime = ime;
        this.prezime = prezime;
        this.korisnickoIme = korisnickoIme;
        this.lozinka = lozinka;
        this.jmbg = jmbg;
        this.adresa = adresa;
        this.pol = pol;
        this.brojTelefona = brojTelefona;
        this.uloga = uloga;
        this.aktivan = aktivan;
        this.lisaVoznji = new DoublyLinkedList<>();

    }

    // Kreiran prazan konstruktor po preporuci asistenta
    Osoba() {
        this.ime = "";
        this.prezime = "";
        this.korisnickoIme = "";
        this.lozinka = "";
        this.jmbg = "";
        this.adresa = "";
        this.pol = Pol.MUSKI;
        this.brojTelefona = "";
        this.uloga = "";
        this.aktivan = true;
    }


    public void setAktivan(boolean aktivan) {
        this.aktivan = aktivan;
    }

    public boolean isAktivan() {
        return aktivan;
    }

    public DoublyLinkedList<Voznja> getLisaVoznji() {
        return lisaVoznji;
    } // TODO: DoublyLinkedList

    public void dodajVoznjuUListu(Voznja voznja) {
        this.lisaVoznji.add(voznja);
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public int getIdKorisnika() {
        return idKorisnika;
    }

    public void setIdKorisnika(int idKorisnika) {
        this.idKorisnika = idKorisnika;
    }


    public Pol getPol() {
        return pol;
    }

    public void setPol(Pol pol) {
        this.pol = pol;
    }

    public String getBrojTelefona() {
        return brojTelefona;
    }

    public void setBrojTelefona(String brojTelefona) {
        this.brojTelefona = brojTelefona;
    }

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getUloga() {
        return uloga;
    }

    public void setUloga(String uloga) {
        this.uloga = uloga;
    }


}
