package com.infinty;

import entiteti.Automobil;
import funkcije.CitanjeFajla;
import korisnici.*;
import ui.Prijava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Main {

    public static void main(String[] args) {

        // ZA SADA JE MAIN JOŠ UVIJEK ZA TESTIRANJE KODA U NJEMU SE NE NALAZI NIKAKVA KONKRETNA IMPLEMENTACIJA!!!

        Automobil auto = new Automobil();

        //VoznjaNarucenaAplikacijom v = new VoznjaNarucenaAplikacijom();

        // Ovaj dio je samo proba instanciranja klase Vozac

/*
        Vozac v = new Vozac("Markec", null, null, null, 99999999, null, 'm', 9999, null, 999, 9999, null);
        v.getAutomobil();
        v.getBrClanskeKarte();
         v.setAutomobil(auto);
        System.out.println(v.getIme());

 */

        // Sta ako nam se nakon KT1 pojavi potreba za još nekom klasom da li možemo mijenjati uml dijagram??

        CitanjeFajla citanjeFajla = new CitanjeFajla();
        List<String[]> listaKorisnika = citanjeFajla.procitajFajl("korisnici.txt");
        System.out.println(Arrays.toString(listaKorisnika.get(0)));
        String[] nizic = listaKorisnika.get(0);
        System.out.println(nizic[0]);

        /*
        Prijava p = new Prijava();
        p.setVisible(true);
         */



    }

}


