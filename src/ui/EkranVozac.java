package ui;

import entiteti.TaxiSluzba;
import korisnici.Osoba;

import javax.swing.*;

public class EkranVozac extends JPanel {
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton nazadBtn;
    private JLabel imeVozaca;
    private JPanel panelVozaca;

    public EkranVozac(Osoba prijavljeniVozac, TaxiSluzba taxiSluzba){
        add(panelVozaca);
        imeVozaca.setText(prijavljeniVozac.getIme());
    }
}
