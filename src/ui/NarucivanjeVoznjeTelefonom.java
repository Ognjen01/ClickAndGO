package ui;

import entiteti.TaxiSluzba;
import entiteti.Voznja;
import entiteti.VoznjaNarucenaTelefonom;
import enumeracije.StatusVoznje;
import korisnici.Musterija;
import korisnici.Osoba;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Random;

public class NarucivanjeVoznjeTelefonom extends JFrame {

    private JButton naruciBtn;
    private JPanel panel1;
    private JTextField adresaDestinacijePolje;
    private JTextField adresaPolaskaPolje;
    private JButton odustaniBtn;

    public NarucivanjeVoznjeTelefonom(TaxiSluzba taxiSluzba, Osoba prijavljenaMusterija) {

        setSize(400, 200);
        setTitle("Click&GO - Naruči vožnju");
        setLocationRelativeTo(null);

        add(panel1);

        odustaniBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        naruciBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String adresaPolaska = adresaPolaskaPolje.getText();
                    String adresaDestinacije = adresaDestinacijePolje.getText();

                    int idVoznje = 0;
                    for (Voznja voznja: taxiSluzba.getListaVoznji()
                         ) {
                        if(voznja.getIdVoznje() >= idVoznje){
                            idVoznje = voznja.getIdVoznje() + 1;
                        }
                    }


                    int idKorisnika = prijavljenaMusterija.getIdKorisnika();
                    int idVozaca = 0;
                    //TODO: Kada se dodjeli vožnja idMusterije se dodaje i mijenja se stanje
                    //      Kasnije se stanje mijenja na osnovu proteklog vremena, koliko vozacu treba da dodje, koliko traje voznja itd.

                    // Generisanje dužine vožnje kao random broja između 1 i 25 npr.

                    int min = 1;
                    int max = 15;
                    double duzinaVoznje = (int)Math.floor(Math.random()*(max-min+1)+min);
                    System.out.println("RANDOM GENERISAN BROJ: " + duzinaVoznje);

                    double trajanjeVoznje = duzinaVoznje * 2;
                    System.out.println("TRAJANJE VOZNJE: " + trajanjeVoznje);

                    System.out.println("CIJENA PO KILOMETRU: " + taxiSluzba.getCijenaPoKilometru() + " CIJENA STARTA: " + taxiSluzba.getCijenaStarta());

                    int cijena = (int) (taxiSluzba.getCijenaPoKilometru() * duzinaVoznje + taxiSluzba.getCijenaStarta());
                    System.out.println("CIJENA VOZNJE: " + cijena);

                    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                    Date datumKreiranja = new Date();
                    System.out.println(formatter.format(datumKreiranja));

                    StatusVoznje statusVoznje = StatusVoznje.KREIRANA;

                    if (adresaPolaska.equals("") || adresaDestinacije.equals("")) {
                        System.out.println("Niste unijeli adrese!");
                        throw new Exception();
                }


                    System.out.println(idKorisnika + " " + idVozaca + " " + idKorisnika + " " + adresaDestinacije);
                    VoznjaNarucenaTelefonom voznja = new VoznjaNarucenaTelefonom(idVoznje, idVozaca, idKorisnika, adresaPolaska, adresaDestinacije,statusVoznje,duzinaVoznje,trajanjeVoznje,cijena,datumKreiranja, (Musterija) prijavljenaMusterija,null);
                    System.out.println(voznja.toString());
                    taxiSluzba.getListaVoznji().add(voznja);

                } catch (Exception e1) {
                    JOptionPane.showMessageDialog( new Frame(),
                            "Greška pri naručivanju vožnje!",
                            "Greška",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        });

    }
}
