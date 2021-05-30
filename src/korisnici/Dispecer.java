package korisnici;

import enumeracije.Pol;

public class Dispecer extends Osoba {

    private int plata;
    private int brTelefonskeLinije;
    private String odjeljenje;

    public Dispecer(
            int idKorisnika,
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
            int brTelefonskeLinije,
            String odjeljenje
    ) {
        super(idKorisnika, ime, prezime, korisnickoIme, lozinka, jmbg, adresa, pol, brojTelefona, uloga, aktivan);
        this.plata = plata;
        this.brTelefonskeLinije = brTelefonskeLinije;
        this.odjeljenje = odjeljenje;

    }

    public Dispecer() {
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
        setBrTelefonskeLinije(0);
        setOdjeljenje(null);
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
                aktivan + "|" +
                plata + "|" +
                brTelefonskeLinije + "|" +
                odjeljenje + "\n";
    }

    public String[] toArrayString(){

        String nizObjekata[] = new String[] {
                String.valueOf(idKorisnika),
                ime,
                prezime,
                korisnickoIme,
                lozinka,
                jmbg,
                adresa,
                String.valueOf(pol),
                brojTelefona,
                String.valueOf(plata),
                String.valueOf(brTelefonskeLinije),
                odjeljenje
        };

        return nizObjekata;
    }

}
