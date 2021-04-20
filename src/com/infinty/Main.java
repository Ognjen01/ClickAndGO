package com.infinty;

import entiteti.Automobil;
import entiteti.Voznja;
import funkcije.*;
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

        A apdejtovanjeListe = new A();
        apdejtovanjeListe.apdejtujListe(listaOsoba, listaVoznjiObj);



        for (Osoba osopa: listaOsoba
             ) {
            System.out.println("Ovo je ime osobe: " + osopa.getIme() + ", a ovo JMBG osobe: " + osopa.getLisaVoznji());

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

        PrijavaRegistracija prijava = new PrijavaRegistracija();
        Osoba prijevljeniKorisnik = prijava.prijavaNaSistem("slobo", "slobo123", listaOsoba);
        System.out.println("Prijavljeni korisnik je: " + prijevljeniKorisnik.getIme() + " " + prijevljeniKorisnik.getPrezime());

    }




}


// Algoritam za dodjelu voznji korisnicima
// Algoritam je smješten u drugu klasu zbog povratnog void tipa
// Ovu funkciju premjestiti u neku drugu klasu

class A {
    public void apdejtujListe(List<Osoba> listaOsoba, List<Voznja> listaVznji){

        for (Voznja voznja: listaVznji
        ) {
            int idMusterije = voznja.getIdMusterije();
            int idVozaca = voznja.getIdVozaca();
            for (Osoba osoba : listaOsoba
            ) {

                if (idMusterije == osoba.getIdKorisnika() || idVozaca == osoba.getIdKorisnika()){
                    // sisitem za dodavanje u listu
                    System.out.println(idMusterije + "//"  + voznja.getIdMusterije()+ "//" + idVozaca + "//" + voznja.getIdVozaca() + " voznja dodata korisnik " + osoba.getUloga());
                    osoba.dodajVoznjuUListu(voznja);
                }

            }
        }

    }
}



