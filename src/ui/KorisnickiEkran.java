package ui;
import korisnici.Osoba;

import java.awt.*;
import javax.swing.*;

public class KorisnickiEkran extends JPanel{

    private JPanel panel1;

    private JButton naručiVožnjuTelefonomButton;
    private JButton prikažiListuVožnjiButton;
    private JButton naručiVožnjuAplikacijomButton;

    private JPanel panel;
    private JLabel ime;



    public KorisnickiEkran(Osoba prijavljeniKorisnik){
        panel1.setSize(100, 200);
        panel.setLayout(new GridLayout(1, 2));
        panel.add(panel1);
        add(panel);
        setSize(800, 800);

        ime.setText("Dobrodosli: " + prijavljeniKorisnik.getIme());


    }



}
