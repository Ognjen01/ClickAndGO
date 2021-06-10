package ui;

import collections.list.DoublyLinkedList;
import entiteti.Automobil;
import entiteti.TaxiSluzba;
import entiteti.Voznja;
import enumeracije.TipVozila;
import korisnici.Osoba;
import korisnici.Vozac;
import pomocneKlase.CitanjeFajla;
import pomocneKlase.UcitavanjeKorisnika;
import pomocneKlase.UpisivanjeUFajl;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class DodavanjeAutomobila extends JFrame {

    private JPanel osnovniPanel;
    private JTextField modelField;
    private JTextField proizvodjacField;
    private JTextField datumRegistracijeField;
    private JTextField brojRegistracijeField;
    private JButton sacuvajButton;
    private JButton odustaniButton;
    private JComboBox tipVozilaField;
    private JComboBox vozacField;

    private UpisivanjeUFajl upisivanjeUFajl;
    private CitanjeFajla citanjeFajla;
    private UcitavanjeKorisnika ucitavanjeKorisnika;

    DoublyLinkedList<Osoba> sviKorisnici;
    DoublyLinkedList<Automobil> sviAutomobili;

    public DodavanjeAutomobila(TaxiSluzba taxiSluzba){
        super("Click&GO - Unos novog automobila");
        setSize(500, 600);
        setLocationRelativeTo(null);

        upisivanjeUFajl = new UpisivanjeUFajl();
        citanjeFajla = new CitanjeFajla();
        ucitavanjeKorisnika = new UcitavanjeKorisnika();

        List<String[]> korisniciString = citanjeFajla.procitajFajl("korisnici.txt");
        this.sviKorisnici = ucitavanjeKorisnika.iteracijaKrozListuStringova(korisniciString);
        this.sviAutomobili = taxiSluzba.getListaAutomovila();

        add(osnovniPanel);

        this.initForma(taxiSluzba);
        this.onClickSacuvajBtn(upisivanjeUFajl, taxiSluzba);
        this.onClickOdustaniBtn();
    }

    private void initForma(TaxiSluzba taxiSluzba) {
        //inicijalizovanje drop vrednosti
        DoublyLinkedList<String> vozaci = new DoublyLinkedList<>();
        vozacField.addItem(String.valueOf(0));
        for(Osoba osoba : sviKorisnici) {
            if(osoba.getUloga().equals("vozac")) {
                    vozaci.add(String.valueOf(osoba.getIdKorisnika()) + " - " + osoba.getKorisnickoIme());
                    vozacField.addItem(String.valueOf(osoba.getIdKorisnika()) + " - " + osoba.getKorisnickoIme());

            }
        }

        for(TipVozila tip : TipVozila.values()) {
            tipVozilaField.addItem(tip.toString());
        }
    }

    private void onClickSacuvajBtn(UpisivanjeUFajl upisivanjeUFajl, TaxiSluzba taxiSluzba) {
        this.sacuvajButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String model = modelField.getText();
                String proizvodjac = proizvodjacField.getText();
                String datumRegistracije = datumRegistracijeField.getText();

                Date datRegistracije = null;
                try {
                    datRegistracije = new SimpleDateFormat("dd-MM-yyyy").parse(datumRegistracije);
                } catch (ParseException parseException) {
                    JOptionPane.showMessageDialog(null,
                            "Neispravan format datuma!", "Unos automobila",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }

                int brojVozila = 0;
                int idVozila = 0;

                for (Automobil automobil: taxiSluzba.getListaAutomovila()
                     ) {
                    if(idVozila < automobil.getAutomobilID()){
                        brojVozila = automobil.getBrojVozila() + 1;
                        idVozila = automobil.getAutomobilID() + 1;
                    }
                }

                String brojRegistracije = brojRegistracijeField.getText();
                String tipVozila = tipVozilaField.getSelectedItem().toString();
                String vozac = vozacField.getSelectedItem().toString();



                int idKorisnika = Integer.parseInt(vozac.split(" - ")[0]);

                Automobil automobilToSave = new Automobil(idVozila, brojVozila, proizvodjac, model, datRegistracije, brojRegistracije, TipVozila.valueOf(tipVozila), idKorisnika);

                sviAutomobili.add(automobilToSave);

                try{
                    //ciscenje fajla
                    PrintWriter writer = new PrintWriter("src/fajlovi/automobili.txt");
                    writer.close();
                    upisivanjeUFajl.upisiSveAutomobile(sviAutomobili);
                    JOptionPane.showMessageDialog(null,
                            "Automobil uspešno sačuvan!", "Unos automobila",
                            JOptionPane.INFORMATION_MESSAGE);
                    setVisible(false);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null,
                            "Automobil uspešno sačuvan!", "Unos automobila",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
    }

    private void onClickOdustaniBtn() {
        this.odustaniButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
    }
}