package com.infinty;

import collections.list.DoublyLinkedList;
import entiteti.Automobil;
import entiteti.TaxiSluzba;
import entiteti.Voznja;
import korisnici.Osoba;
import pomocneKlase.*;
import ui.Prijava;

import java.util.ArrayList;
import java.util.List;


public class Main {

    public static void main(String[] args) {

        // Učitavanje listi koje se prosleđuju u TaxiSluzbu

        CitanjeFajla citajFajl = new CitanjeFajla();
        List<String[]> lista = citajFajl.procitajFajl("korisnici.txt");
        List<String[]> listaVoznji = citajFajl.procitajFajl("voznje.txt");
        List<String[]> listaAutomobila = citajFajl.procitajFajl("automobili.txt");


        List<Osoba> listaOsoba = new ArrayList<Osoba>();
        UcitavanjeKorisnika vratiListuOsoba = new UcitavanjeKorisnika();

        List<Voznja> listaVoznjiObj = new ArrayList<Voznja>();
        UcitavanjeVoznji vratiListuvoznji = new UcitavanjeVoznji();

        List<Automobil> automobilList = new ArrayList<Automobil>();
        UcitavanjeEntiteta ucitavanjeEntiteta = new UcitavanjeEntiteta();

        listaVoznjiObj = vratiListuvoznji.iteracijaKrozListuStringova(listaVoznji);
        listaOsoba = vratiListuOsoba.iteracijaKrozListuStringova(lista);
        automobilList = ucitavanjeEntiteta.ucitajListuAutomobila(listaAutomobila);

        vratiListuOsoba.apdejtujListe(listaOsoba, listaVoznjiObj, automobilList);


        TaxiSluzba taxiSluzba = new TaxiSluzba(listaOsoba, automobilList, listaVoznjiObj);

        Prijava prijava = new Prijava(taxiSluzba);
        prijava.setVisible(true);


        UpisivanjeUFajl upis = new UpisivanjeUFajl();
        upis.upisiTaxiSluzbu(taxiSluzba);


        // TODO: - Napraviti upisivanje u fajl tako da se na X (izlaz iz glavnog prozora) upišu sve liste u fajlove

        //TODO: !! Provjera doubly linked liste !!

        DoublyLinkedList<Integer> listaUcitanohOsoba = new DoublyLinkedList<>();

        for (String[] nizEntitetaOsobe : lista
        ) {
            Osoba ucitanaOsoba = vratiListuOsoba.odluciKojegKorisnikaInstancirati(nizEntitetaOsobe);
            System.out.println(ucitanaOsoba.getIme());
            listaUcitanohOsoba.add(ucitanaOsoba.getIdKorisnika());
            System.out.println("ENTITET DODAT U DOUBLEY LINKED LIST");
        }

        System.out.println("================= \n POČETNO: ");

        for (Integer osoba : listaUcitanohOsoba
        ) {
            System.out.println(osoba);
        }

        // SORTIRANJE DOUBLY LINKED LISTE!!

        for (int i = 0; i < listaUcitanohOsoba.size(); i++){
            for (int j = 0; j < listaUcitanohOsoba.size(); j++){

                if(listaUcitanohOsoba.getElement(i) < listaUcitanohOsoba.getElement(j)){
                    Integer prenos = listaUcitanohOsoba.getElement(i);
                    System.out.println("i: "+ listaUcitanohOsoba.getElement(i) + " j: " + listaUcitanohOsoba.getElement(j));
                    listaUcitanohOsoba.set(i, listaUcitanohOsoba.getElement(j));
                    listaUcitanohOsoba.set(j, prenos);
                }
            }
        }


        System.out.println("================= \n KONAČNO: ");

        for (Integer osoba : listaUcitanohOsoba
        ) {
            System.out.println(osoba);
        }
    }
}
