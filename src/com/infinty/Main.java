package com.infinty;

import collections.list.DoublyLinkedList;
import entiteti.Automobil;
import entiteti.TaxiSluzba;
import entiteti.Voznja;
import entiteti.VoznjaNarucenaAplikacijom;
import enumeracije.StatusVoznje;
import korisnici.Osoba;
import pomocneKlase.*;
import ui.Prijava;

import java.util.List;


public class Main {

    public static void main(String[] args) {

        // Učitavanje listi koje se prosleđuju u TaxiSluzbu

        CitanjeFajla citajFajl = new CitanjeFajla();
        List<String[]> lista = citajFajl.procitajFajl("korisnici.txt");
        List<String[]> listaVoznji = citajFajl.procitajFajl("voznje.txt");
        List<String[]> listaAutomobila = citajFajl.procitajFajl("automobili.txt");
        List<String[]> listaPunudaString = citajFajl.procitajFajl("ponude.txt");


        DoublyLinkedList<Osoba> listaOsoba = new DoublyLinkedList<Osoba>();
        UcitavanjeKorisnika vratiListuOsoba = new UcitavanjeKorisnika();

        DoublyLinkedList<Voznja> listaVoznjiObj = new DoublyLinkedList<Voznja>();
        UcitavanjeVoznji vratiListuvoznji = new UcitavanjeVoznji();

        DoublyLinkedList<Automobil> automobilList = new DoublyLinkedList<Automobil>();
        UcitavanjeEntiteta ucitavanjeEntiteta = new UcitavanjeEntiteta();

        DoublyLinkedList<Ponuda> listPonuda = new DoublyLinkedList<Ponuda>();
        listPonuda = ucitavanjeEntiteta.ucitajListuPonuda(listaPunudaString);

        DoublyLinkedList<Aukcija> listaAukcija = new DoublyLinkedList<Aukcija>();


        listaVoznjiObj = vratiListuvoznji.iteracijaKrozListuStringova(listaVoznji);
        listaOsoba = vratiListuOsoba.iteracijaKrozListuStringova(lista);
        automobilList = ucitavanjeEntiteta.ucitajListuAutomobila(listaAutomobila);
        listaAukcija = ucitavanjeEntiteta.ucitajListuAukcija(listPonuda);

        vratiListuOsoba.apdejtujListe(listaOsoba, listaVoznjiObj, automobilList);

        // Dio za vožnje koje su kreirane ali nemaju ni jednu ponudu u fajlu ponuda

        for (Voznja voznja: listaVoznjiObj
             ) {
            int voznjaPostojiUAukciji = 0;
            if (voznja instanceof VoznjaNarucenaAplikacijom && voznja.getStatus() == StatusVoznje.NA_CEKANJU){
                voznjaPostojiUAukciji = 1;
                for (Aukcija au :
                        listaAukcija) {
                    if(au.getIdVoznje() == voznja.getIdVoznje()){
                        voznjaPostojiUAukciji = 3;
                    }
                }
            }
            if (voznjaPostojiUAukciji == 1) {
                Aukcija aukcija = new Aukcija(voznja.getIdVoznje(), null);
                listaAukcija.add(aukcija);
            }

        }


        TaxiSluzba taxiSluzba = new TaxiSluzba(listaOsoba, automobilList, listaVoznjiObj);
        taxiSluzba.setListaAukcija(listaAukcija);

        Prijava prijava = new Prijava(taxiSluzba);
        prijava.setVisible(true);


        //TODO: TESTIRANJE LISTE, SORTIRANJA I BINARNE PRETRAGE:

        BinarnaPretraga binarnaPretraga = new BinarnaPretraga();

        String ime = binarnaPretraga.pronadjiOsobuBinarySearch(listaOsoba, 100004).getKorisnickoIme();

        System.out.println(" \n \n \n \n REZULTAT BINARNE PRETRAGE " + ime + " \n \n \n \n");

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
