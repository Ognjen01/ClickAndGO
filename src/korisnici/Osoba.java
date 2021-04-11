package korisnici;

public abstract class Osoba {
     String ime;
     String prezime;
     String korisnickoIme;
     String lozinka;
     long jmbg;
     String adresa;
     char pol;
     int brojTelefona;
     String uloga;

     // Da li nam je uopšte potreban konstruktor ako je klasa apstraktna?

     /*

    Osoba(String ime,
          String prezime,
          String korisnickoIme,
          String lozinka,
          long jmbg,
          String adresa,
          char pol,
          int brojTelefona,
          String uloga){

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

      */



     public String getIme() {
          return ime;
     }
}
