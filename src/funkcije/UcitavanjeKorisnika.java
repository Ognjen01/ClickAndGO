package funkcije;

import entiteti.Automobil;
import entiteti.Voznja;
import korisnici.Dispecer;
import korisnici.Musterija;
import korisnici.Osoba;
import korisnici.Vozac;

import java.util.ArrayList;
import java.util.List;


public class UcitavanjeKorisnika {

    // TODO: Izmjeniti ucitavanje entiteta tako da uzima u obzir da li su aktivni ili nisu!!! Logičko brisanje

    // UČITAVANJE KORISNIKA
    // Isti algoritam se može koristiti i za učitavanje obrisanih korisnika

    //Funkcija koja prolazi kroz listu stringova, a vraća listu objekata klasa naslednica Osobe

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

        boolean aktivan;
        switch (niz[10]){
            case "true":
                aktivan = true;
                break;

            case "false":
                aktivan = false;
                break;

            default:
                aktivan = false;
        }

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
                    aktivan,
                    listaVoznjiMusterije

            );
            return novaMusterija;
        }
        else if (niz[9].equals("vozac")) {

            int plata = Integer.parseInt(niz[11]);
            int brojClanskeKarte = Integer.parseInt(niz[12]);
            double prosjecnaOcjena = Double.parseDouble(niz[13]);
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
                    aktivan,
                    plata,
                    brojClanskeKarte,
                    automobilVozaca,
                    listaVoznjiVozaca,
                    prosjecnaOcjena);

            return noviVozac;
        }

        else if (niz[9].equals("dispecer")){

            int plata = Integer.parseInt(niz[11]);
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
                    aktivan,
                    plata,
                    brTelefona,
                    niz[12]
            );
            return  noviDispecer;
        }
        else {
            System.out.println("Došlo je do greške prilikom kreiranja entiteta korinika");
            return null;
        }
    }

    // Ovu funckiju premjestiti u klasu opstih funkcija

    public void apdejtujListe(List<Osoba> listaOsoba, List<Voznja> listaVznji){

        for (Voznja voznja: listaVznji
        ) {
            int idMusterije = voznja.getIdMusterije();
            int idVozaca = voznja.getIdVozaca();
            for (Osoba osoba : listaOsoba
            ) {

                if (idMusterije == osoba.getIdKorisnika() || idVozaca == osoba.getIdKorisnika()){
                    // sisitem za dodavanje u listu
                    System.out.println(idMusterije + "//"  + voznja.getIdMusterije()+ "//" + idVozaca + "//" + voznja.getIdVozaca() + " voznja dodata korisnik " + osoba.getUloga());
                    osoba.dodajVoznjuUListu(voznja);
                }

            }
        }

    }
}
