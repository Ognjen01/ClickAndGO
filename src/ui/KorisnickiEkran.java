package ui;

import entiteti.TaxiSluzba;
import korisnici.Osoba;

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


    public KorisnickiEkran(Osoba prijavljeniKorisnik, TaxiSluzba taxiSluzba) {
        setSize(800, 400);
        setTitle("Click&GO");
        setLocationRelativeTo(null);
        panel1.setSize(100, 200);
        panel1.setLocation(400, 400);
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
    }


}
