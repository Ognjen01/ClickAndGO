package com.infinty;

import entiteti.Automobil;
import entiteti.Voznja;
import funkcije.CitanjeFajla;
import funkcije.SistemOdluke;
import funkcije.UcitavanjeEntiteta;
import korisnici.*;
import ui.Prijava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Main {

    public static void main(String[] args) {

        // ZA SADA JE MAIN JOŠ UVIJEK ZA TESTIRANJE KODA U NJEMU SE NE NALAZI NIKAKVA KONKRETNA IMPLEMENTACIJA!!!

        CitanjeFajla citajFajl = new CitanjeFajla();
        List<String[]> lista = citajFajl.procitajFajl("korisnici.txt");
        String[] nizic = lista.get(0);
        System.out.println(Arrays.toString(nizic));

        List<Osoba> listaOsoba = new ArrayList<Osoba>();

        SistemOdluke vratiListuOsoba = new SistemOdluke();

        listaOsoba = vratiListuOsoba.iteracijaKrozListuStringova(lista);
        String[] slobo = lista.get(0);
        System.out.println(slobo[9]); // Niz za provjeru da li su mi objekti OK

        Osoba sloboObj = listaOsoba.get(0);
        for (Osoba osopa: listaOsoba
             ) {
            System.out.println();

        }
        System.out.println(sloboObj.getBrojTelefona());


    }

}


