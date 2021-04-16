package funkcije;

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

    // TODO: Da li je moguće napraviti preko generičke klase da se vraća drugačiji tip podatka??
    //      Sistem odluke će biti potreban i za učitavanje vožnji jer imamo dvije različite klase vožnji?

    public Osoba odluciKojegKorisnikaInstancirati(String[] niz) {

        if (niz[9].equals("korisnik")){
            int idKorisnika = Integer.parseInt(niz[0]);
            long jmbg = Long.parseLong(niz[5]);
            String p = niz[7];
            char pol = p.charAt(0);
            int brTelefona = Integer.parseInt(niz[8]);
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
            Vozac noviVozac = new Vozac(); // U konstruktor proslijediti pojedine vrijednosti niza, trenutno je prazan konstruktor
            // TODO: Potrebno dodati atribute u fajl i zatim je moguće generisati konstruktor kakav se teaži
            //      Trenutno nema odgovarajući niz u fajlu d abi mogao da generiše ispravan konstruktor
            return noviVozac;
        }

        else if (niz[9].equals("dispecer")){
            Dispecer noviDispecer = new Dispecer(); // U konstruktor proslijediti pojedine vrijednosti niza, trenutno je prazan konstruktor
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
