package com.infinty;

import collections.list.DoublyLinkedList;
import entiteti.Automobil;
import entiteti.TaxiSluzba;
import entiteti.Voznja;
import korisnici.Osoba;
import pomocneKlase.*;
import ui.DodavanjeIzmenaAutomobila;
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
        List<String[]> listaPunudaString = citajFajl.procitajFajl("ponude.txt");


        DoublyLinkedList<Osoba> listaOsoba = new DoublyLinkedList<Osoba>(); // TODO: DoublyLinkedList
        UcitavanjeKorisnika vratiListuOsoba = new UcitavanjeKorisnika();

        DoublyLinkedList<Voznja> listaVoznjiObj = new DoublyLinkedList<Voznja>();// TODO: DoublyLinkedList
        UcitavanjeVoznji vratiListuvoznji = new UcitavanjeVoznji();

        DoublyLinkedList<Automobil> automobilList = new DoublyLinkedList<Automobil>();// TODO: DoublyLinkedList
        UcitavanjeEntiteta ucitavanjeEntiteta = new UcitavanjeEntiteta();

        DoublyLinkedList<Ponuda> listPonuda = new DoublyLinkedList<Ponuda>();
        listPonuda = ucitavanjeEntiteta.ucitajListuPonuda(listaPunudaString);

        DoublyLinkedList<Aukcija> listaAukcija = new DoublyLinkedList<Aukcija>();


        listaVoznjiObj = vratiListuvoznji.iteracijaKrozListuStringova(listaVoznji);// TODO: DoublyLinkedList
        listaOsoba = vratiListuOsoba.iteracijaKrozListuStringova(lista);// TODO: DoublyLinkedList
        automobilList = ucitavanjeEntiteta.ucitajListuAutomobila(listaAutomobila);// TODO: DoublyLinkedList
        listaAukcija = ucitavanjeEntiteta.ucitajListuAukcija(listPonuda);

        vratiListuOsoba.apdejtujListe(listaOsoba, listaVoznjiObj, automobilList);


        TaxiSluzba taxiSluzba = new TaxiSluzba(listaOsoba, automobilList, listaVoznjiObj);// TODO: DoublyLinkedList
        taxiSluzba.setListaAukcija(listaAukcija);

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

        System.out.println("================= \n OSOBE: ");

        for (Osoba osoba : listaOsoba
        ) {
            System.out.println(osoba.getIdKorisnika());
        }

        System.out.println("================= \n AUTOMOBILI: ");

        for (Automobil automobil : automobilList
        ) {
            System.out.println(automobil.getAutomobilID());
        }

        System.out.println("================= \n VOŽNJE: ");


        for (Voznja voznja : listaVoznjiObj
        ) {
            System.out.println(voznja.getIdVoznje());
        }

        System.out.println("================= \n PONUDE: ");

        for (Ponuda ponuda : listPonuda
        ) {
            System.out.println(ponuda.getIdVoznje() + " / " + ponuda.getKorisnickoImeVozaca());
        }

        System.out.println("================= \n AUKCIJA: ");

        for (Aukcija aukcija : taxiSluzba.getListaAukcija()
        ) {
            System.out.println("Aukcija: ");
            System.out.println(aukcija.getIdVoznje());
            System.out.println("Njene ponude: ");
            for (Ponuda ponuda : aukcija.getPonudeZaVoznju()){
                System.out.println( ponuda.getIdVoznje() + " / " +ponuda.getIdVozaca());
            }
        }


    }



}
