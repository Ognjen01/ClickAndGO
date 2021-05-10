package ui;

import entiteti.Automobil;
import entiteti.TaxiSluzba;
import korisnici.Osoba;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EkranDispecer extends JFrame {
    private JLabel imeDispecera;
    private JButton teksiSluzbaIzmjene;
    private JButton operacijeVozaci;
    private JPanel panelOpcija;
    private JButton operacijeAutomobili;
    private JButton prikazVoznji;
    private JButton pretragaVozaca;
    private JButton dodjelaVoznji;
    private JButton pretragaAutomobila;
    private JButton izvjestajVoznji;
    private JButton izvjestajVozaca;
    private JButton odjava;

    public EkranDispecer(Osoba prijavljeniDispecer, TaxiSluzba taxiSluzba) {


        setSize(800, 400);
        setTitle("Click&GO");
        setLocationRelativeTo(null);
        imeDispecera.setText(prijavljeniDispecer.getIme());

        add(panelOpcija);

        teksiSluzbaIzmjene.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PodaciTaksiSluzbe podaciTaksiSluzbe = new PodaciTaksiSluzbe(); // DOdati objekat taxi sluzbe u konstruktor
                podaciTaksiSluzbe.setVisible(true);
                setVisible(false);
            }
        });

        operacijeVozaci.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        operacijeAutomobili.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DodavanjeIzmenaAutomobila dodavanjeIzmenaAutomobila = new DodavanjeIzmenaAutomobila();
                dodavanjeIzmenaAutomobila.setVisible(true);
                setVisible(false);
            }
        });

        prikazVoznji.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            PrikazVoznji prikazVoznji = new PrikazVoznji(taxiSluzba);
            prikazVoznji.setVisible(true);
            //setVisible(false);
            }
        });

        pretragaVozaca.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        dodjelaVoznji.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });


        pretragaAutomobila.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Automobili automobili = new Automobili();
                automobili.setVisible(true);
                setVisible(false);
            }
        });

        izvjestajVozaca.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        izvjestajVoznji.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        odjava.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Prijava nazadNaPrijavu = new Prijava(taxiSluzba);
                nazadNaPrijavu.setVisible(true);
                setVisible(false);
            }
        });


    }



}
