package ui;

import entiteti.TaxiSluzba;
import pomocneKlase.PrijavaRegistracija;
import korisnici.Osoba;
import pomocneKlase.UpisivanjeUFajl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class Prijava extends JFrame {

    private JPanel prijava;
    private JTextField textField1;
    private JTextField passwordField1;
    private JButton prijaviSeButton;
    private JButton registracijaBtn;
    private TaxiSluzba sluzba;

    public Prijava(TaxiSluzba taxiSluzba) {

        add(prijava);
        setSize(800, 400);
        setTitle("Click&GO");
        setLocationRelativeTo(null);
        sluzba = taxiSluzba;

        prijaviSeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String korisnickoIme = textField1.getText();
                String lozinka = passwordField1.getText();
                PrijavaRegistracija prijavaNaSistem = new PrijavaRegistracija();
                Osoba prijavljeniKorsinik = prijavaNaSistem.prijavaNaSistem(korisnickoIme, lozinka, taxiSluzba.getListaOsoba());


                if (prijavljeniKorsinik != null) {
                    System.out.println("prijavlajni ste kao korisnik " + prijavljeniKorsinik.getIme());
                    prijava.setVisible(false);
                    if (prijavljeniKorsinik.getUloga().equals("korisnik")) {
                        KorisnickiEkran k = new KorisnickiEkran(prijavljeniKorsinik, taxiSluzba);
                        k.setVisible(true);
                        setVisible(false);
                    } else if (prijavljeniKorsinik.getUloga().equals("dispecer")) {
                        EkranDispecer enkranDis = new EkranDispecer(prijavljeniKorsinik, taxiSluzba);
                        enkranDis.setVisible(true);
                        setVisible(false);
                    } else if (prijavljeniKorsinik.getUloga().equals("vozac")) {
                        EkranVozac ekranVozac = new EkranVozac(prijavljeniKorsinik, taxiSluzba);
                        ekranVozac.setVisible(true);
                        setVisible(false);
                    }
                } else {
                    JOptionPane.showMessageDialog( new Frame(),
                            "Ne postoji tra??eni korisnik.",
                            "Gre??ka",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        registracijaBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Registracija registracija = new Registracija(taxiSluzba);
                registracija.setVisible(true);
                setVisible(false);
            }
        });
    }

    protected void processWindowEvent(WindowEvent ev) {
        super.processWindowEvent(ev);
        if (ev.getID() == WindowEvent.WINDOW_CLOSING) {

            UpisivanjeUFajl upis = new UpisivanjeUFajl();
            upis.upisiTaxiSluzbu(sluzba);

            System.out.println("ZATVARANJE PROZORA");
            System.exit(0);
        }
    }
}