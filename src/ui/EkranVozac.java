package ui;

import entiteti.TaxiSluzba;
import korisnici.Osoba;
import korisnici.Vozac;

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
    private JButton prihvatanjeVoznji;

    public EkranVozac(Osoba prijavljeniVozac, TaxiSluzba taxiSluzba){
        setSize(800, 400);
        setTitle("Click&GO");
        setLocationRelativeTo(null);
        add(panelVozaca);
        imeVozaca.setText(prijavljeniVozac.getIme());

        Vozac prijavljeniVozac1 = (Vozac) prijavljeniVozac;

        odjavaBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Prijava nazadNaPrijavu = new Prijava(taxiSluzba);
                nazadNaPrijavu.setVisible(true);
                setVisible(false);
            }
        });

        prihvatanjeVoznji.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PrihvatanjeOdbijanjeVoznji prihvatanjeOdbijanjeVoznji = new PrihvatanjeOdbijanjeVoznji(taxiSluzba, prijavljeniVozac1);
                prihvatanjeOdbijanjeVoznji.setVisible(true);
            }
        });
    }
}
