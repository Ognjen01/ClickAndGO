package ui;

import entiteti.TaxiSluzba;
import korisnici.Osoba;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EkranDispecer extends JPanel {
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


        imeDispecera.setText(prijavljeniDispecer.getIme());

        add(panelOpcija);

        teksiSluzbaIzmjene.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

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

            }
        });

        prikazVoznji.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

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



    }



}
