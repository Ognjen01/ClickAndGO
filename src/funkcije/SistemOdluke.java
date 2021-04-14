package funkcije;

import korisnici.Dispecer;
import korisnici.Musterija;
import korisnici.Vozac;

import java.util.List;


public class SistemOdluke {

    public String iteracijaKrozListuStringova(List<String[]> listaEntiteta){
        for (String[] lista: listaEntiteta
             ) {
            odluciKojegKorisnikaInstancirati(lista);
        }
        return null;
    }

    public String odluciKojegKorisnikaInstancirati(String[] niz) {

        if (niz[9].equals("korisnik")){
            Musterija novaMusterija = new Musterija(); // U konstruktor proslijediti pojedine vrijednosti niza
        }
        else if (niz[9].equals("vozac")) {
            Vozac noviVozac = new Vozac(); // U konstruktor proslijediti pojedine vrijednosti niza
        }

        else if (niz[9].equals("dispecer")){
            Dispecer noviDispecer = new Dispecer(); // U konstruktor proslijediti pojedine vrijednosti niza
        }
        else {
            System.out.println("Došlo je do greške prilikom kreiranja entiteta korinika");
        }

        return null;
    }
}
