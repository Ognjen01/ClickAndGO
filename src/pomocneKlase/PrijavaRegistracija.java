package pomocneKlase;

import korisnici.Osoba;

import java.util.List;

public class PrijavaRegistracija {

    // Pronalaženje traženog korisnika u fajlu:

    public Osoba prijavaNaSistem(String korisnikckoIme, String lozinka, List<Osoba> listaKorisnika) {
        Osoba prijavljeniKorisnik = null;
        for (Osoba korisnik : listaKorisnika) {
            System.out.println("Trazeni: " + korisnikckoIme + " " + lozinka + " ; Nađeni: " + korisnik.getIme() + " " + korisnik.getLozinka());
            if (korisnikckoIme.equals(korisnik.getKorisnickoIme()) && lozinka.equals(korisnik.getLozinka())) {
                prijavljeniKorisnik = korisnik;
                break;
            }
        }
        if (prijavljeniKorisnik == null) {
            System.out.println("Nije pronađen korisnik molimo pokušajte ponovo ");
        }
        return prijavljeniKorisnik;
    }


    // TODO: Implementovati funkciju regostracija!!!
    public void registracija() {

    }
}
