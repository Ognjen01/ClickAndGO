package com.infinty;

import entiteti.Automobil;
import entiteti.TaxiSluzba;
import entiteti.Voznja;
import korisnici.Osoba;
import pomocneKlase.*;
import ui.Prijava;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;


public class Main {

    public static void main(String[] args) {

        // komnetar

        // ZA SADA JE MAIN JOŠ UVIJEK ZA TESTIRANJE KODA U NJEMU SE NE NALAZI NIKAKVA KONKRETNA IMPLEMENTACIJA!!!

        // Učitavanje listi koje se prosleđuju u TaxiSluzbu

        // TODO: Instancirati učitavanja unutar same klase taxi sluzbe
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

        Prijava prijava = new Prijava(taxiSluzba);
        prijava.setVisible(true);


        UpisivanjeUFajl upis = new UpisivanjeUFajl();
        upis.upisiTaxiSluzbu(taxiSluzba);


        // TODO: - Napraviti upisivanje u fajl tako da se na X (izlaz iz glavnog prozora) upišu sve liste u fajlove
        //       - Potrebno dodati samo taj osluškivač za pritisak na X


    }

}
/*

package ui;

        import entiteti.TaxiSluzba;
        import korisnici.Osoba;
        import korisnici.Vozac;

        import javax.swing.*;
        import java.awt.*;
        import java.util.ArrayList;
        import java.util.List;

public class OperacijeVozaci extends JFrame {
    private JButton prikazVozacaBtn;
    private JButton dodajVozacaBtn;
    private JButton izmjenaVozacaBtn;
    private JButton brisanjeVozacaBtn;
    private JPanel panelOpcija;
    private JPanel panelTabele;
    private JTable table1;
    private JScrollPane sp;

    public OperacijeVozaci(TaxiSluzba taxiSluzba){
        /*
        setSize(800, 400);
        setTitle("Click&GO");
        setLocationRelativeTo(null);
        panelTabele.setPreferredSize(new Dimension(400, 40));
        add(panelOpcija);

        List<Vozac> listaVozaca = new ArrayList<Vozac>();;
        for (Osoba osoba: taxiSluzba.getListaOsoba()){
            if(osoba instanceof Vozac){
                listaVozaca.add((Vozac) osoba);
                System.out.println(osoba.getUloga() + " " + osoba.getIme());
            }
        }

        int brojVozaca = listaVozaca.size();
        String data[][] = new String[brojVozaca][11];

        int index= 0;
        for (Vozac vozac: listaVozaca
             ) {
            System.out.println(vozac.getIme());
            data[index] = vozac.toArrayString();
            index++;
        }

        String column[]={"ID","Mušterija ID","Vozač ID", "Adresa polaska", "Adresa destinacije", "Status", "Dužina (km)", "Trajanje (min)", "Cena (RSD)", "Datum i vreme", "Jos Nesto"};

        table1 = new JTable(data, column);

        sp = new JScrollPane(table1);
        add(sp);



    }
}


         */