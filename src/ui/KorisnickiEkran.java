package ui;

import entiteti.Automobil;
import entiteti.TaxiSluzba;
import korisnici.Osoba;
import korisnici.Vozac;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.xml.stream.Location;

public class KorisnickiEkran extends JFrame {

    private JPanel panel1;
    private JLabel ime;
    private JButton naruciAplikacijomBtn;
    private JButton naruciTelefonomBtn;
    private JButton odjavaBtn;
    private JButton izvjestajBtn;
    private JButton izmjeniProfil;
    private JButton obrisiProfil;


    public KorisnickiEkran(Osoba prijavljeniKorisnik, TaxiSluzba taxiSluzba) {
        setSize(800, 400);
        setTitle("Click&GO");
        setLocationRelativeTo(null);
        add(panel1);

        ime.setText("Dobrodosli: " + prijavljeniKorisnik.getIme());


        odjavaBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO : Doraditi odjavu, treba ukloniti prethodni JFrame
                Prijava nazadNaPrijavu = new Prijava(taxiSluzba);
                nazadNaPrijavu.setVisible(true);
                setVisible(false);
            }
        });

        naruciTelefonomBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NarucivanjeVoznjeTelefonom narucivanjeVoznjeTelefonom = new NarucivanjeVoznjeTelefonom(taxiSluzba, prijavljeniKorisnik);
                narucivanjeVoznjeTelefonom.setVisible(true);
            }
        });

        naruciAplikacijomBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        izvjestajBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        obrisiProfil.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int confirmed = JOptionPane.showConfirmDialog(null,
                        "Da li ste sigurni da želite izbristi Vaš profil?", "Potvrdite brisanje",
                        JOptionPane.YES_NO_OPTION);

                if (confirmed == JOptionPane.YES_OPTION) {

                    for (Osoba osoba : taxiSluzba.getListaOsoba()){
                        if(osoba.getIdKorisnika() == prijavljeniKorisnik.getIdKorisnika()){
                            osoba.setAktivan(false);
                        }
                    }

                    Prijava prijava = new Prijava(taxiSluzba);
                    prijava.setVisible(true);
                    setVisible(false);
                }
            }
        });

        izmjeniProfil.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                IzmjenaInformacijaMusterije izmjena = new IzmjenaInformacijaMusterije(taxiSluzba, prijavljeniKorisnik);
                izmjena.setVisible(true);
            }
        });

    }
}
