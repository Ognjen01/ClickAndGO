package com.infinty;

import collections.list.ListNode;
import entiteti.Automobil;
import entiteti.TaxiSluzba;
import entiteti.Voznja;
import korisnici.Osoba;
import collections.list.DoublyLinkedList;
import pomocneKlase.*;
import ui.Prijava;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
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


        for (Integer osoba : listaUcitanohOsoba
        ) {
            System.out.println(osoba);
        }

/*
        for (Osoba osoba1: listaUcitanohOsoba
             ) {
            for ( Osoba osoba2: listaUcitanohOsoba
                 ) {
                if(osoba1.getIdKorisnika() > osoba2.getIdKorisnika()){

                    // Kreiranje novog ListNode
                    ListNode<Osoba> os1 = listaUcitanohOsoba.getElement(osoba1);
                    ListNode<Osoba> os2 = listaUcitanohOsoba.getElement(osoba2);

                    // Razmjena informacija između osoba
                    Osoba prenos = osoba1;
                    osoba1 = osoba2;
                    osoba2 = prenos;

                    // Postavljanje elementa na osobu, bez next i previous
                    listaUcitanohOsoba.getElement(osoba1).setElement(osoba2);
                    listaUcitanohOsoba.getElement(osoba2).setElement(prenos);

                    // Postavljanje čitavog ListNode
                    listaUcitanohOsoba.getElement(osoba1).setListNode(os2);
                    listaUcitanohOsoba.getElement(osoba2).setListNode(os1);

                }
            }
        }


 */

        for (Integer i: listaUcitanohOsoba){
            for (Integer j: listaUcitanohOsoba
                 ) {
                if (i > j) {
                    Integer prenos = i;
                    i = j;
                    j = prenos;
                    System.out.println("prenos");
                }
            }
        }


        System.out.println("=================");

        for (Integer osoba : listaUcitanohOsoba
        ) {
            System.out.println(osoba);
        }
    }
}
