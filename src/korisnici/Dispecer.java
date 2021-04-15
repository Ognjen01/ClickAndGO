package korisnici;

public class Dispecer extends Osoba{

    private int plata;
    private int brTelefonskeLinije;
    private String odjeljenje;

    Dispecer(String ime,
             String prezime,
             String korisnickoIme,
             String lozinka,
             long jmbg,
             String adresa,
             char pol,
             int brojTelefona,
             String uloga
             ) {
            super(ime, prezime, korisnickoIme, lozinka, jmbg, adresa, pol, brojTelefona, uloga);
            this.plata = getPlata(); // ??? Zašto ovdje ne mogu da stavim samo plata?

    }

    public Dispecer(){
        // Generisati prazna polja DIspecera
    }

    public int getBrTelefonskeLinije() {
        return brTelefonskeLinije;
    }

    public int getPlata() {
        return plata;
    }

    public String getOdjeljenje() {
        return odjeljenje;
    }

    public void setBrTelefonskeLinije(int brTelefonskeLinije) {
        this.brTelefonskeLinije = brTelefonskeLinije;
    }

    public void setOdjeljenje(String odjeljenje) {
        this.odjeljenje = odjeljenje;
    }

    public void setPlata(int plata) {
        this.plata = plata;
    }
}
