package com.infinty;

import ui.Prijava;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Main {

    public static void main(String[] args) {
        String[] korisnik = OsnovneFunkcije.prijavaNaSistem("saldja", "sladja123");
        System.out.println(korisnik[1]);
        Prijava prijava = new Prijava();
        prijava.setVisible(true);


    }




}


