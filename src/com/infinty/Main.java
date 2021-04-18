package com.infinty;

import entiteti.Automobil;
import entiteti.Voznja;
import funkcije.CitanjeFajla;
import funkcije.SistemOdlukeKorisnici;
import funkcije.SistemOdlukeVoznje;
import funkcije.UcitavanjeEntiteta;
import korisnici.*;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Main {

    public static void main(String[] args) {

        // ZA SADA JE MAIN JOŠ UVIJEK ZA TESTIRANJE KODA U NJEMU SE NE NALAZI NIKAKVA KONKRETNA IMPLEMENTACIJA!!!

        CitanjeFajla citajFajl = new CitanjeFajla();
        List<String[]> lista = citajFajl.procitajFajl("korisnici.txt");
        List<String[]> listaVoznji = citajFajl.procitajFajl("voznje.txt");
        List<String[]> listaAutomobila = citajFajl.procitajFajl("automobili.txt");


        List<Osoba> listaOsoba = new ArrayList<Osoba>();
        SistemOdlukeKorisnici vratiListuOsoba = new SistemOdlukeKorisnici();

        List<Voznja> listaVoznjiObj = new ArrayList<Voznja>();
        SistemOdlukeVoznje vratiListuvoznji = new SistemOdlukeVoznje();

        List<Automobil> automobilList = new ArrayList<Automobil>();
        UcitavanjeEntiteta ucitavanjeEntiteta = new UcitavanjeEntiteta();

        listaVoznjiObj = vratiListuvoznji.iteracijaKrozListuStringova(listaVoznji);
        listaOsoba = vratiListuOsoba.iteracijaKrozListuStringova(lista);
        automobilList = ucitavanjeEntiteta.ucitajListuAutomobila(listaAutomobila);

        for (Osoba osopa: listaOsoba
             ) {
            System.out.println("Ovo je ime osobe: " + osopa.getIme() + ", a ovo JMBG osobe: " + osopa.getJmbg());

        }

        for (Voznja voznja: listaVoznjiObj
        ) {
            System.out.println("Ovo je adresa voznje: " + voznja.getAdresaDestinacije());

        }

        for (Automobil auto: automobilList
             ) {
            System.out.println("Ovo je automobila: " + auto.getModel() + " proizvodjaca " + auto.getProizvodjac());
        }

        // TODO: Potrebno doraditi sve algoritme za ucitavanje kako bi ucitavali entitete i u druge liste

    }

}


