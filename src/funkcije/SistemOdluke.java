package funkcije;

import entiteti.Automobil;
import entiteti.Voznja;
import korisnici.Dispecer;
import korisnici.Musterija;
import korisnici.Osoba;
import korisnici.Vozac;

import java.util.ArrayList;
import java.util.List;


public class SistemOdluke {

    public List<Osoba> iteracijaKrozListuStringova(List<String[]> listaEntiteta){
        List<Osoba> listaUcitanohOsoba = new ArrayList<Osoba>();


        for (String[] nizEntitetaOsobe: listaEntiteta
             ) {
            Osoba ucitanaOsoba = odluciKojegKorisnikaInstancirati(nizEntitetaOsobe);
            listaUcitanohOsoba.add(ucitanaOsoba);
        }
        return listaUcitanohOsoba;
    }

    public Osoba odluciKojegKorisnikaInstancirati(String[] niz) {

        int idKorisnika = Integer.parseInt(niz[0]);
        long jmbg = Long.parseLong(niz[5]);
        String p = niz[7];
        char pol = p.charAt(0);
        int brTelefona = 1; // Greška sa preuzimanjem vrijednosti iz niza

        if (niz[9].equals("korisnik")){

            List<Voznja> listaVoznjiMusterije = new ArrayList<Voznja>();

            Musterija novaMusterija = new Musterija(
                    idKorisnika,
                    niz[1],
                    niz[2],
                    niz[3],
                    niz[4],
                    jmbg,
                    niz[6],
                    pol,
                    brTelefona,
                    niz[9],
                    listaVoznjiMusterije

            );
            return novaMusterija;
        }
        else if (niz[9].equals("vozac")) {

            int plata = Integer.parseInt(niz[10]);
            int brojClanskeKarte = Integer.parseInt(niz[11]);
            double prosjecnaOcjena = Double.parseDouble(niz[12]);
            Automobil automobilVozaca = new Automobil();
            List<Voznja> listaVoznjiVozaca = new ArrayList<Voznja>();

            Vozac noviVozac = new Vozac(
                    idKorisnika,
                    niz[1],
                    niz[2],
                    niz[3],
                    niz[4],
                    jmbg,
                    niz[6],
                    pol,
                    brTelefona,
                    niz[9],
                    plata,
                    brojClanskeKarte,
                    automobilVozaca,
                    listaVoznjiVozaca,
                    prosjecnaOcjena);

            return noviVozac;
        }

        else if (niz[9].equals("dispecer")){

            int plata = Integer.parseInt(niz[10]);
            int brTelefonskeLinije = 1; // Greška sa preuzimanjem vrijdenosti iz niza

            Dispecer noviDispecer = new Dispecer(
                    idKorisnika,
                    niz[1],
                    niz[2],
                    niz[3],
                    niz[4],
                    jmbg,
                    niz[6],
                    pol,
                    brTelefona,
                    niz[9],
                    plata,
                    brTelefona,
                    niz[11]
            ); // U konstruktor proslijediti pojedine vrijednosti niza, trenutno je prazan konstruktor
            return  noviDispecer;
        }
        else {
            System.out.println("Došlo je do greške prilikom kreiranja entiteta korinika");
            return null;
        }


    }
}

/*
    TODO: Ova funkcija iznad vraća niz osoba i ima fleksibilnost zato što ove klase ispod nasleđuju klasu osoba
        Sve korisnike vratiti u tri različita niza koji se razlikuju po tipu korisnika
        Uprostiti ovu klasu iznad da možda vraća upravo taj niz Osoba i da se u klasi nalazi sama iteracija kroz listu stringova
        Nina će napraviti obrnuti algoritak koji će koristiti za upisivanje u fajlove
 */

// U vozacu nece biti id automobila vec ce u automobilu biti id vozaca
