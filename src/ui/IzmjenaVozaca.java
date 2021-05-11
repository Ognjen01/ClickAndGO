package ui;

import entiteti.TaxiSluzba;

import javax.swing.*;

public class IzmjenaVozaca extends JFrame {

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
    private JButton izmjeniVozacaButton;
    private JButton odustaniButton;

    public IzmjenaVozaca(TaxiSluzba taxiSluzba){

        setSize(500, 500);
        setTitle("Click&GO");
        add(osnovniPanel);
    }
}
