package com.infinty;

import entiteti.Automobil;
import korisnici.*;
import ui.Prijava;


public class Main {

    public static void main(String[] args) {

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

        Prijava p = new Prijava();
        p.setVisible(true);



    }

}


