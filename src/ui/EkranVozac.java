package ui;

import entiteti.TaxiSluzba;
import korisnici.Osoba;

import javax.swing.*;

public class EkranVozac extends JPanel {
    private JButton istorijaVoznjiBtn;
    private JButton licitacijaBtn;
    private JButton statistikaBtn;
    private JButton odjavaBtn;
    private JLabel imeVozaca;
    private JPanel panelVozaca;

    public EkranVozac(Osoba prijavljeniVozac, TaxiSluzba taxiSluzba){
        add(panelVozaca);
        imeVozaca.setText(prijavljeniVozac.getIme());
    }
}
