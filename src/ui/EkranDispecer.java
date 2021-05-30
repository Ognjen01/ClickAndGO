package ui;

import entiteti.Automobil;
import entiteti.TaxiSluzba;
import korisnici.Osoba;
import pomocneKlase.UpisivanjeUFajl;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

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
    private JButton prikazMusterija;
    private JButton prikazAutomobilaButton;
    private JButton prikazDispeceraButton;
    private TaxiSluzba sluzba;

    public EkranDispecer(Osoba prijavljeniDispecer, TaxiSluzba taxiSluzba) {
        sluzba = taxiSluzba;

        setSize(800, 530);
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
            OperacijeVozaci operacijeVozaci = new OperacijeVozaci(taxiSluzba, prijavljeniDispecer);
            operacijeVozaci.setVisible(true);
            setVisible(false);
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
                PretragaVozaca pretragaVozaca = new PretragaVozaca(taxiSluzba);
                pretragaVozaca.setVisible(true);
            }
        });

        prikazMusterija.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PrikazMusterija prikazMusterija = new PrikazMusterija(taxiSluzba);
                prikazMusterija.setVisible(true);
            }
        });

        dodjelaVoznji.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            DodjelaVoznjiNarucenihTelefonom dodjela = new DodjelaVoznjiNarucenihTelefonom(taxiSluzba);
            dodjela.setVisible(true);
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
                IzvjestajVoznji izvjestajVoznji = new IzvjestajVoznji(taxiSluzba);
                izvjestajVoznji.setVisible(true);
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

        prikazAutomobilaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OperacijeAutomobili operacijeAutomobili = new OperacijeAutomobili(taxiSluzba);
                operacijeAutomobili.setVisible(true);
            }
        });

        prikazDispeceraButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OperacijeDispeceri operacijeDispeceri = new OperacijeDispeceri(taxiSluzba);
                operacijeDispeceri.setVisible(true);
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
