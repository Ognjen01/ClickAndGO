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

    //FUnkcija koja prolazi kroz listu stringova, a vraća listu objekata klasa naslednica Osobe

    public List<Osoba> iteracijaKrozListuStringova(List<String[]> listaEntiteta){
        List<Osoba> listaUcitanohOsoba = new ArrayList<Osoba>();


        for (String[] nizEntitetaOsobe: listaEntiteta
             ) {
            Osoba ucitanaOsoba = odluciKojegKorisnikaInstancirati(nizEntitetaOsobe);
            listaUcitanohOsoba.add(ucitanaOsoba);
        }
        return listaUcitanohOsoba;
    }

    // Funkcija koja odlučuje kojeg korisnika će instancirati i istovremeno ga instancira
    // Pozvana je od strane funkcije iteracijaKrozListuStringova

    public Osoba odluciKojegKorisnikaInstancirati(String[] niz) {

        int idKorisnika = Integer.parseInt(niz[0]);
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
                    niz[5],
                    niz[6],
                    pol,
                    niz[8],
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
                    niz[5],
                    niz[6],
                    pol,
                    niz[8],
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
            int brTelefonskeLinije = 1; // Greška sa preuzimanjem vrijdenosti iz niza za broj telefona
            // Potencijalno rješenje da se broj telefona čuva kao string

            Dispecer noviDispecer = new Dispecer(
                    idKorisnika,
                    niz[1],
                    niz[2],
                    niz[3],
                    niz[4],
                    niz[5],
                    niz[6],
                    pol,
                    niz[7],
                    niz[9],
                    plata,
                    brTelefona,
                    niz[11]
            );
            return  noviDispecer;
        }
        else {
            System.out.println("Došlo je do greške prilikom kreiranja entiteta korinika");
            return null;
        }


    }
}
