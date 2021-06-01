package pomocneKlase;

import collections.list.DoublyLinkedList;
import entiteti.Automobil;
import entiteti.Voznja;
import enumeracije.Pol;
import korisnici.Dispecer;
import korisnici.Musterija;
import korisnici.Osoba;
import korisnici.Vozac;

import java.util.ArrayList;
import java.util.List;


public class UcitavanjeKorisnika {

    // UČITAVANJE KORISNIKA

    //Funkcija koja prolazi kroz listu stringova, a vraća listu objekata klasa naslednica Osobe

    public DoublyLinkedList<Osoba> iteracijaKrozListuStringova(List<String[]> listaEntiteta) { // TODO: DoublyLinkedList

        DoublyLinkedList<Osoba> listaUcitanohOsoba = new DoublyLinkedList<Osoba>();


        for (String[] nizEntitetaOsobe : listaEntiteta
        ) {
            Osoba ucitanaOsoba = odluciKojegKorisnikaInstancirati(nizEntitetaOsobe);
            listaUcitanohOsoba.add(ucitanaOsoba);
        }

        for (int i = 0; i < listaUcitanohOsoba.size(); i++){
            for (int j = 0; j < listaUcitanohOsoba.size(); j++){

                if(listaUcitanohOsoba.getElement(i).getIdKorisnika() < listaUcitanohOsoba.getElement(j).getIdKorisnika()){
                    Osoba prenos = listaUcitanohOsoba.getElement(i);
                    listaUcitanohOsoba.set(i, listaUcitanohOsoba.getElement(j));
                    listaUcitanohOsoba.set(j, prenos);
                }
            }
        }


        return listaUcitanohOsoba;
    }

    // Funkcija koja odlučuje kojeg korisnika će instancirati i istovremeno ga instancira
    // Pozvana je od strane funkcije iteracijaKrozListuStringova

    public Osoba odluciKojegKorisnikaInstancirati(String[] niz) {

        boolean aktivan;
        switch (niz[10]) {
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
        Pol pol = Pol.valueOf(niz[7]);


        if (niz[9].equals("korisnik")) {

            DoublyLinkedList<Voznja> listaVoznjiMusterije = new DoublyLinkedList<Voznja>();

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
        } else if (niz[9].equals("vozac")) {

            int plata = Integer.parseInt(niz[11]);
            int brojClanskeKarte = Integer.parseInt(niz[12]);
            double prosjecnaOcjena = Double.parseDouble(niz[13]);
            Automobil automobilVozaca = new Automobil();
            DoublyLinkedList<Voznja> listaVoznjiVozaca = new DoublyLinkedList<Voznja>();

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
        } else if (niz[9].equals("dispecer")) {

            int plata = Integer.parseInt(niz[11]);
            int brTelefonskeLinije = Integer.parseInt(niz[12]);

            Dispecer noviDispecer = new Dispecer(
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
                    brTelefonskeLinije,
                    niz[13]
            );
            return noviDispecer;
        } else {
            System.out.println("Došlo je do greške prilikom kreiranja entiteta korinika");
            return null;
        }
    }

    public void apdejtujListe(DoublyLinkedList<Osoba> listaOsoba, DoublyLinkedList<Voznja> listaVoznji, DoublyLinkedList<Automobil> listaAutomobila) { // TODO: DoublyLinkedList

        for (Voznja voznja : listaVoznji
        ) {
            int idMusterije = voznja.getIdMusterije();
            int idVozaca = voznja.getIdVozaca();
            for (Osoba osoba : listaOsoba
            ) {

                if (idMusterije == osoba.getIdKorisnika() || idVozaca == osoba.getIdKorisnika()) {
                    // sisitem za dodavanje u listu
                    System.out.println(idMusterije + "//" + voznja.getIdMusterije() + "//" + idVozaca + "//" + voznja.getIdVozaca() + " voznja dodata korisnik " + osoba.getUloga());
                    osoba.dodajVoznjuUListu(voznja);
                }

            }
        }

        for (Automobil automobil: listaAutomobila
             ) {
            int idVozaca = automobil.getIdVozaca();
            for (Osoba vozac: listaOsoba
                 ) {
                if (vozac instanceof Vozac){
                    if (idVozaca == vozac.getIdKorisnika()){
                        ((Vozac) vozac).setAutomobil(automobil);
                    }
                }

            }
        }

    }
}
