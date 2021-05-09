package ui;

import entiteti.TaxiSluzba;
import korisnici.Osoba;

import java.awt.*;
import javax.swing.*;
import javax.xml.stream.Location;

public class KorisnickiEkran extends JPanel {

    private JPanel panel1;
    private JLabel ime;
    private JButton naruciAplikacijomBtn;
    private JButton naruciTelefonomBtn;
    private JButton odjavaBtn;
    private JButton izvjestajBtn;


    public KorisnickiEkran(Osoba prijavljeniKorisnik, TaxiSluzba taxiSluzba) {
        panel1.setSize(100, 200);
        panel1.setLocation(400, 400);
        add(panel1);

        ime.setText("Dobrodosli: " + prijavljeniKorisnik.getIme());
    }


}
