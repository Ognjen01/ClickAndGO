package korisnici;

public class Dispecer extends Osoba{

    private int plata;
    private int brTelefonskeLinije;
    private String odjeljenje;

    Dispecer(int idKorisnika,
            String ime,
             String prezime,
             String korisnickoIme,
             String lozinka,
             long jmbg,
             String adresa,
             char pol,
             int brojTelefona,
             String uloga,
             int plata,
             int brTelefonskeLinije,
             String odjeljenje
             ) {
            super(idKorisnika ,ime, prezime, korisnickoIme, lozinka, jmbg, adresa, pol, brojTelefona, uloga);
            this.plata = plata;
            this.brTelefonskeLinije = brTelefonskeLinije;
            this.odjeljenje = odjeljenje;

    }

    public Dispecer(){
        // Generisati prazna polja Dispecera
    }

    public int getBrTelefonskeLinije() {
        return brTelefonskeLinije;
    }

    public int getPlata() {
        return plata;
    }

    public void setPlata(int plata) {
        this.plata = plata;
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

}
