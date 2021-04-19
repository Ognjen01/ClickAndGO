package funkcije;

import korisnici.Osoba;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.List;

public class PrijavaRegistracija {

    /*
    TODO: 1. Izmjeniti algoritam za prijavu tako da pretražuje po listi stringova
          2. Nakon nađenog korisnika generisati novi objekat prijavljeniKorisnik
          3. Prijava se vrši isključivo na osnovu prethodno učitanih fajlova u nizove!!!
     */

    // Pronalaženje traženog korisnika u fajlu:

    public Osoba prijavaNaSistem(String korisnikckoIme, String lozinka, List<Osoba> listaKorisnika){
        Osoba prjavljeniKorisnik = null;
        for (Osoba korisnik: listaKorisnika) {
            System.out.println("Trazeni: " + korisnikckoIme + " " + lozinka + " ; Nađeni: " + korisnik.getIme() + " " + korisnik.getLozinka());
            if (korisnikckoIme.equals(korisnik.getKorisnickoIme()) && lozinka.equals(korisnik.getLozinka())){
                prjavljeniKorisnik = korisnik;
                break;
            }


        }
        return prjavljeniKorisnik;
    }


    // TODO: Implementovati funkciju regostracija!!!
    public void registracija(){

    }
}
