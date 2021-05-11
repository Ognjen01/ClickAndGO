package ui;

import entiteti.TaxiSluzba;

import javax.swing.*;
import javax.swing.text.TabableView;

public class DodavanjeVozaca extends JFrame {

    private JPanel osnovniPanel;
    private JTextField imeVozacaPolje;
    private JTextField prezimeVozacaPolje;
    private JTextField korisnickoImeVozacaPolje;
    private JTextField lozinkaVozacaPolje;
    private JTextField jmbgVozacaPolje;
    private JTextField adresaVozacaPolje;
    private JRadioButton zenskiRadioButton;
    private JRadioButton muskiRadioButton;
    private JTextField brojTelefonaVozaca;
    private JTextField plataVozacaPolje;
    private JComboBox comboBox1;
    private JButton dodajVozacaButton;
    private JButton odustaniButton;

    public DodavanjeVozaca(TaxiSluzba taxiSluzba){

        setSize(500, 500);
        setTitle("Click&GO");
        add(osnovniPanel);

        ButtonGroup group = new ButtonGroup();
        group.add(zenskiRadioButton);
        group.add(muskiRadioButton);
    }
}
