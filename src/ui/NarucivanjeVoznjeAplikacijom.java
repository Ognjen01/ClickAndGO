package ui;

import entiteti.TaxiSluzba;
import entiteti.Voznja;
import entiteti.VoznjaNarucenaAplikacijom;
import enumeracije.StatusVoznje;
import korisnici.Musterija;
import korisnici.Osoba;
import pomocneKlase.UpisivanjeUFajl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class NarucivanjeVoznjeAplikacijom extends JFrame {

    private JPanel panel1;
    private JTextField txtAdresaPolaska;
    private JTextField txtAdresaDolaska;
    private JCheckBox petFriendlyCheck;
    private JTextArea txtNapomena;
    private JButton naruciBtn;
    private JButton odustaniBtn;
    private JLabel adresaPolaska;
    private JLabel adresaDolaska;

    private UpisivanjeUFajl upisivanjeUFajl;

    public NarucivanjeVoznjeAplikacijom(TaxiSluzba taxiSluzba, Osoba prijavljeniKorisnik){

        setSize(400, 200);
        setTitle("Click&GO - Naruči vožnju putem aplikacije");
        setLocationRelativeTo(null);
        upisivanjeUFajl = new UpisivanjeUFajl();

        add(panel1);


        naruciBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String adresaPolaska = txtAdresaPolaska.getText().trim();
                    String adresaDolaska = txtAdresaDolaska.getText().trim();
                    boolean petFriendly = Boolean.valueOf(petFriendlyCheck.getText());
                    String napomena = txtNapomena.getText();
                    int id = 0;
                    for (Voznja v : taxiSluzba.getListaVoznji()) {
                        if (v.getIdVoznje() > id) {
                            id = v.getIdVoznje();
                        }
                    }

                    int idVoznje = id + 1;
                    int idVozaca = 0; //Dok se vozacu ne dodeli voznja
                    int idMusterije = prijavljeniKorisnik.getIdKorisnika();
                    double duzina = 0;
                    double trajanje = 0;
                    int cenaVoznje = 0;
                    Date vremeNarudzbine = new Date();

                    StatusVoznje statusVoznje = StatusVoznje.NA_CEKANJU;

                    if (adresaPolaska.equals("") || adresaDolaska.equals("")) {
                        System.out.println("Niste uneli adrese.");
                        throw new Exception();
                    }

                    System.out.println(idVoznje + " " + idVozaca + " " + idMusterije + " " + adresaDolaska);
                    VoznjaNarucenaAplikacijom voznja = new VoznjaNarucenaAplikacijom(idVoznje, idVozaca, idMusterije, adresaPolaska, adresaDolaska, statusVoznje, duzina, trajanje, cenaVoznje, vremeNarudzbine, (Musterija) prijavljeniKorisnik, null, petFriendly, napomena);
                    System.out.println(voznja);
                    //voznja.setPetFrendly(true);
                    //voznja.setNapomena(String);
                    List<Voznja> sveVoznje = taxiSluzba.getListaVoznji();
                    sveVoznje.add(voznja);

                    try{
                        //ciscenje fajla
                        PrintWriter writer = new PrintWriter("src/fajlovi/voznje.txt");
                        writer.close();
                        upisivanjeUFajl.upisiSveVoznje(sveVoznje);
                        JOptionPane.showMessageDialog(null,
                                "Vožnja uspešno kreirana!", "Obaveštenje",
                                JOptionPane.INFORMATION_MESSAGE);
                        setVisible(false);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null,
                                "Desila se greška prilikom kreiranja vožnje", "Greška",
                                JOptionPane.INFORMATION_MESSAGE);
                    }

                    setVisible(false);

                }catch (Exception e1) {
                    JOptionPane.showMessageDialog( new Frame(),
                            "Greška pri naručivanju vožnje!",
                            "Greška",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        odustaniBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
    }
}
