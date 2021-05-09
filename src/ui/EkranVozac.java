package ui;

import entiteti.TaxiSluzba;
import korisnici.Osoba;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EkranVozac extends JFrame {
    private JButton istorijaVoznjiBtn;
    private JButton licitacijaBtn;
    private JButton statistikaBtn;
    private JButton odjavaBtn;
    private JLabel imeVozaca;
    private JPanel panelVozaca;

    public EkranVozac(Osoba prijavljeniVozac, TaxiSluzba taxiSluzba){
        setSize(800, 400);
        setTitle("Click&GO");
        setLocationRelativeTo(null);
        add(panelVozaca);
        imeVozaca.setText(prijavljeniVozac.getIme());

        odjavaBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Prijava nazadNaPrijavu = new Prijava(taxiSluzba);
                nazadNaPrijavu.setVisible(true);
                setVisible(false);
            }
        });
    }
}
