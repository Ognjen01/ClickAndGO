package korisnici;

public abstract class Osoba {

     private int idKOorisnika;
     private String ime;
     private String prezime;
     private String korisnickoIme;
     private String lozinka;
     private long jmbg;
     private String adresa;
     private char pol;
     private int brojTelefona;
     private String uloga;

     // Da li nam je uopšte potreban konstruktor ako je klasa apstraktna?



    Osoba(String ime,
          String prezime,
          String korisnickoIme,
          String lozinka,
          long jmbg){

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
           this.jmbg = 0;
           this.adresa = "";
           this.pol = 'm';
           this.brojTelefona = 0;
           this.uloga = "";
      }



      // TODO: Generisati getere i setere
     public String getIme() {
          return ime;
     }
}
