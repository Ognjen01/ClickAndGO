package com.infinty;

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

        // komnetar

        // ZA SADA JE MAIN JOŠ UVIJEK ZA TESTIRANJE KODA U NJEMU SE NE NALAZI NIKAKVA KONKRETNA IMPLEMENTACIJA!!!

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


        for (Osoba osopa: listaOsoba
             ) {
            System.out.println("Ovo je ime osobe: " + osopa.getIme() + ", a ovo JMBG osobe: " + osopa.getLisaVoznji() + osopa.isAktivan());

        }

        for (Voznja voznja: listaVoznjiObj
        ) {
            System.out.println("Ovo je adresa voznje: " + voznja.getAdresaDestinacije());

        }

        for (Automobil auto: automobilList
             ) {
            System.out.println("Ovo je automobila: " + auto.getModel() + " proizvodjaca " + auto.getProizvodjac());
        }


        System.out.println("\n\n\n\n\n\n\n ================================\n\nPocetak upisa!\n\n================================");
        UpisivanjeUFajl upis = new UpisivanjeUFajl();
        upis.upisiTaxiSluzbu(taxiSluzba);
        Prijava prijava = new Prijava(taxiSluzba);
        prijava.setVisible(true);

    }

}