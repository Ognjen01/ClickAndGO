package ui;

import korisnici.Osoba;

import java.awt.*;
import javax.swing.*;
import javax.xml.stream.Location;

public class KorisnickiEkran extends JPanel {

    private JPanel panel1;
    private JButton naruciVoznjuTelefonomButton;
    private JButton istorijaVoznjiButton;
    private JButton naruciVoznjuAplikacijomButton;
    private JLabel ime;
    private JPanel panelSlike;


    public KorisnickiEkran(Osoba prijavljeniKorisnik) {
        panel1.setSize(100, 200);
        panel1.setLocation(400, 400);
        add(panel1);


        ime.setText("Dobrodosli: " + prijavljeniKorisnik.getIme());


    }


}
