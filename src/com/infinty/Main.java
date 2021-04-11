package com.infinty;

import entiteti.Automobil;
import entiteti.VoznjaNarucenaAplikacijom;
import funkcije.Registracija;
import korisnici.*;
import ui.KorisnickiEkran;
import ui.Prijava;


public class Main {

    public static void main(String[] args) {

        Automobil auto = new Automobil();

        //VoznjaNarucenaAplikacijom v = new VoznjaNarucenaAplikacijom();

        // Ovaj dio je samo proba instanciranja klase Vozac

        Vozac v = new Vozac("Markec", null, null, null, 99999999, null, 'm', 9999, null, 999, 9999, null);
        v.getAutomobil();
        v.getBrClanskeKarte();
         v.setAutomobil(auto);
        System.out.println(v.getIme());

        Registracija funkcije = new Registracija();

        funkcije.prijavaNaSistem("slobo", "slobo123");

        KorisnickiEkran k = new KorisnickiEkran();

        k.setVisible(true);


    }

}


