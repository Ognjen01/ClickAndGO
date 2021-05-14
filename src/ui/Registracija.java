package ui;

import entiteti.TaxiSluzba;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Registracija extends JFrame {

    private JPanel osnovniPanel;
    private JTextField imePolje;
    private JTextField prezimePolje;
    private JTextField korisnickoImePolje;
    private JTextField lozinkaPolje;
    private JTextField jmbgMusterijePolje;
    private JTextField adresaVozacaPolje;
    private JTextField brojTelefonaPolje;
    private JButton registracijaBtn;
    private JButton odustaniButton;
    private JRadioButton muskiRadioButton;
    private JRadioButton zenskiradioButton;

    public Registracija(TaxiSluzba taxiSluzba){

        setSize(400, 400);
        setTitle("Click&GO");
        setLocationRelativeTo(null);
        add(osnovniPanel);

        odustaniButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Prijava prijava = new Prijava(taxiSluzba);
                prijava.setVisible(true);
                setVisible(false);
            }
        });

        registracijaBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // TODO: 1. Preuzeti polja
                //       2. Napraviti objekat Musterije
                //       3. Dodati u taxiSluzba.getListaOsoba().add(novaMusterija)

                Prijava prijava = new Prijava(taxiSluzba);
                prijava.setVisible(true);
                setVisible(false);

            }
        });
    }
}
