package com.infinty;

import entiteti.Voznja;
import funkcije.CitanjeFajla;
import funkcije.SistemOdlukeKorisnici;
import funkcije.SistemOdlukeVoznje;
import korisnici.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Main {

    public static void main(String[] args) {

        // ZA SADA JE MAIN JOŠ UVIJEK ZA TESTIRANJE KODA U NJEMU SE NE NALAZI NIKAKVA KONKRETNA IMPLEMENTACIJA!!!

        CitanjeFajla citajFajl = new CitanjeFajla();
        List<String[]> lista = citajFajl.procitajFajl("korisnici.txt");
        List<String[]> listaVoznji = citajFajl.procitajFajl("voznje.txt");

        String[] nizic = lista.get(0);
        System.out.println(Arrays.toString(nizic));

        List<Osoba> listaOsoba = new ArrayList<Osoba>();
        SistemOdlukeKorisnici vratiListuOsoba = new SistemOdlukeKorisnici();

        List<Voznja> listaVoznjiObj = new ArrayList<Voznja>();
        SistemOdlukeVoznje vratiListuvoznji = new SistemOdlukeVoznje();

        listaVoznjiObj = vratiListuvoznji.iteracijaKrozListuStringova(listaVoznji);

        listaOsoba = vratiListuOsoba.iteracijaKrozListuStringova(lista);

        Osoba sloboObj = listaOsoba.get(0);
        for (Osoba osopa: listaOsoba
             ) {
            System.out.println("Ovo je Osopa naky: " + osopa.getIme() + "//" + osopa.getJmbg());

        }
        System.out.println(sloboObj.getBrojTelefona());

        for (Voznja voznja: listaVoznjiObj
        ) {
            System.out.println("Ovo je Voznja naky: " + voznja.getAdresaDestinacije());

        }

    }

}


