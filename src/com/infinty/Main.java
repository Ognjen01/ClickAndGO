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


        DoublyLinkedList<Osoba> listaOsoba = new DoublyLinkedList<Osoba>(); // TODO: DoublyLinkedList
        UcitavanjeKorisnika vratiListuOsoba = new UcitavanjeKorisnika();

        DoublyLinkedList<Voznja> listaVoznjiObj = new DoublyLinkedList<Voznja>();// TODO: DoublyLinkedList
        UcitavanjeVoznji vratiListuvoznji = new UcitavanjeVoznji();

        DoublyLinkedList<Automobil> automobilList = new DoublyLinkedList<Automobil>();// TODO: DoublyLinkedList
        UcitavanjeEntiteta ucitavanjeEntiteta = new UcitavanjeEntiteta();

        listaVoznjiObj = vratiListuvoznji.iteracijaKrozListuStringova(listaVoznji);// TODO: DoublyLinkedList
        listaOsoba = vratiListuOsoba.iteracijaKrozListuStringova(lista);// TODO: DoublyLinkedList
        automobilList = ucitavanjeEntiteta.ucitajListuAutomobila(listaAutomobila);// TODO: DoublyLinkedList

        vratiListuOsoba.apdejtujListe(listaOsoba, listaVoznjiObj, automobilList);


        TaxiSluzba taxiSluzba = new TaxiSluzba(listaOsoba, automobilList, listaVoznjiObj);// TODO: DoublyLinkedList

        Prijava prijava = new Prijava(taxiSluzba);
        prijava.setVisible(true);


        //TODO: TESTIRANJE LISTE, SORTIRANJA I BINARNE PRETRAGE:

        DoublyLinkedList<Osoba> listaUcitanohOsoba = new DoublyLinkedList<>();

        for (String[] nizEntitetaOsobe : lista
        ) {
            Osoba ucitanaOsoba = vratiListuOsoba.odluciKojegKorisnikaInstancirati(nizEntitetaOsobe);
            System.out.println(ucitanaOsoba.getIme());
            listaUcitanohOsoba.add(ucitanaOsoba);
            System.out.println("ENTITET DODAT U DOUBLEY LINKED LIST");
        }

        System.out.println("================= \n POČETNO: ");

        for (Osoba osoba : listaUcitanohOsoba
        ) {
            System.out.println(osoba.getIdKorisnika());
        }

        // SORTIRANJE DOUBLY LINKED LISTE!!

        for (int i = 0; i < listaUcitanohOsoba.size(); i++){
            for (int j = 0; j < listaUcitanohOsoba.size(); j++){

                if(listaUcitanohOsoba.getElement(i).getIdKorisnika() < listaUcitanohOsoba.getElement(j).getIdKorisnika()){
                    Osoba prenos = listaUcitanohOsoba.getElement(i);
                    //System.out.println("i: "+ listaUcitanohOsoba.getElement(i) + " j: " + listaUcitanohOsoba.getElement(j));
                    listaUcitanohOsoba.set(i, listaUcitanohOsoba.getElement(j));
                    listaUcitanohOsoba.set(j, prenos);
                }
            }
        }


        System.out.println("================= \n KONAČNO: ");

        for (Osoba osoba : listaUcitanohOsoba
        ) {
            System.out.println(osoba.getIdKorisnika());
        }


    }



}
