package ui;

import entiteti.Automobil;
import entiteti.TaxiSluzba;
import enumeracije.TipVozila;
import korisnici.Osoba;
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

public class IzmenaAutomobila extends JFrame {
    private JPanel osnovniPanel;
    private JTextField modelField;
    private JTextField proizvodjacField;
    private JTextField datumRegistracijeField;
    private JTextField brojVozilaField;
    private JTextField brojRegistracijeField;
    private JComboBox tipVozilaField;
    private JComboBox vozacField;
    private JButton izmeniButton;
    private JButton odustaniButton;

    private UpisivanjeUFajl upisivanjeUFajl;
    private CitanjeFajla citanjeFajla;
    private UcitavanjeKorisnika ucitavanjeKorisnika;

    List<Osoba> sviKorisnici;
    List<Automobil> sviAutomobili;

    public IzmenaAutomobila(TaxiSluzba taxiSluzba, Integer idAutomobila){
        super("Click&GO - Izmena automobila");
        setSize(500, 600);
        setLocationRelativeTo(null);


        upisivanjeUFajl = new UpisivanjeUFajl();
        citanjeFajla = new CitanjeFajla();
        ucitavanjeKorisnika = new UcitavanjeKorisnika();

        List<String[]> korisniciString = citanjeFajla.procitajFajl("korisnici.txt");
        this.sviKorisnici = ucitavanjeKorisnika.iteracijaKrozListuStringova(korisniciString);
        this.sviAutomobili = taxiSluzba.getListaAutomovila();

        add(osnovniPanel);

        this.initForma(taxiSluzba, idAutomobila);
        this.onClickIzmeniBtn(idAutomobila, upisivanjeUFajl);
        this.onClickOdustaniBtn();
    }

    private void initForma(TaxiSluzba taxiSluzba, int idAutomobila) {
        Automobil automobilZaIzmenu = null;
        for (Automobil automobil: taxiSluzba.getListaAutomovila()
        ) {
            if (automobil.getAutomobilID() == idAutomobila){
                automobilZaIzmenu = automobil;
            }
        }

        //preuzimanje svih korisnika iz fajla, posle cemo da ih koristimo kako bi napravili drop da moze da se promeni vozac


        List<String> vozaci = new ArrayList<>();
        for(Osoba osoba : sviKorisnici) {
            if(osoba.getUloga().equals("vozac")) {
                vozaci.add(String.valueOf(osoba.getIdKorisnika()) + " - " + osoba.getKorisnickoIme());
                vozacField.addItem(String.valueOf(osoba.getIdKorisnika()) + " - " + osoba.getKorisnickoIme());
            }
        }

        for(TipVozila tip : TipVozila.values()) {
            tipVozilaField.addItem(tip.toString());
        }

        modelField.setText(automobilZaIzmenu.getModel());
        proizvodjacField.setText(automobilZaIzmenu.getProizvodjac());
        datumRegistracijeField.setText(automobilZaIzmenu.getDatumRegistracijeString());
        brojVozilaField.setText(String.valueOf(automobilZaIzmenu.getBrojVozila()));
        brojRegistracijeField.setText(automobilZaIzmenu.getBrojRegistracije());
        tipVozilaField.setSelectedItem(automobilZaIzmenu.getTipVozila().toString());

        //setovanje trenutnog vozaca u dropdown-u na trenutni u objektu
        for(String vozac : vozaci) {
            if(Long.parseLong(vozac.split(" - ")[0]) == automobilZaIzmenu.getIdVozaca()) { //splitovanje jer smo iznad
                vozacField.setSelectedItem(vozac);
            }
        }
    }

    private void onClickIzmeniBtn(int idAutomobila, UpisivanjeUFajl upisivanjeUFajl) {
        this.izmeniButton.addActionListener(new ActionListener() {
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
                            "Neispravan format datuma!", "Izmena automobila",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }

                int brojVozila = 0;
                try{
                    brojVozila = Integer.parseInt(brojVozilaField.getText());
                } catch (NumberFormatException numberFormatException) {
                    JOptionPane.showMessageDialog(null,
                            "Broj vozila mora biti ceo broj!", "Izmena automobila",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }
                String brojRegistracije = brojRegistracijeField.getText();
                String tipVozila = tipVozilaField.getSelectedItem().toString();
                String vozac = vozacField.getSelectedItem().toString();




                int idKorisnika = Integer.parseInt(vozac.split(" - ")[0]);

                Automobil automobilToSave = new Automobil(idAutomobila, brojVozila, proizvodjac, model, datRegistracije, brojRegistracije, TipVozila.valueOf(tipVozila), idKorisnika);

                for(Automobil automobil : sviAutomobili) {
                    if(automobil.getAutomobilID() == idAutomobila) {
                        sviAutomobili.set(sviAutomobili.indexOf(automobil), automobilToSave);
                    }
                }

                try{
                    //ciscenje fajla
                    PrintWriter writer = new PrintWriter("src/fajlovi/automobili.txt");
                    writer.close();
                    upisivanjeUFajl.upisiSveAutomobile(sviAutomobili);
                    JOptionPane.showMessageDialog(null,
                            "Automobil uspešno izmenjen!", "Izmena automobila",
                            JOptionPane.INFORMATION_MESSAGE);
                    setVisible(false);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null,
                            "Desila se greška prilikom čuvanja automobila", "Izmena automobila",
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
