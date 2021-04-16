package korisnici;

public abstract class Osoba {

     private int idKorisnika;
     private String ime;
     private String prezime;
     private String korisnickoIme;
     private String lozinka;
     private String jmbg; // Mora biti string jer pojedini jmbg počinju sa 0
     private String adresa;
     private char pol;
     private String brojTelefona;
     private String uloga;

     // Da li nam je uopšte potreban konstruktor ako je klasa apstraktna?



    Osoba(int idKorisnika,
          String ime,
          String prezime,
          String korisnickoIme,
          String lozinka,
          String jmbg,
          String adresa,
          char pol,
          String brojTelefona,
          String uloga){

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


    }

    // Kreiran prazan konstruktor po preporuci asistenta
      Osoba(){
           this.ime = "";
           this.prezime = "";
           this.korisnickoIme = "";
           this.lozinka = "";
           this.jmbg = "";
           this.adresa = "";
           this.pol = 'm';
           this.brojTelefona = "";
           this.uloga = "";
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

    public char getPol() {
        return pol;
    }

    public void setPol(char pol) {
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
