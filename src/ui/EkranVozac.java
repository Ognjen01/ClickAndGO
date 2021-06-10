package ui;

import entiteti.TaxiSluzba;
import korisnici.Osoba;
import korisnici.Vozac;
import pomocneKlase.UpisivanjeUFajl;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class EkranVozac extends JFrame {
    private JButton istorijaVoznjiBtn;
    private JButton licitacijaBtn;
    private JButton statistikaBtn;
    private JButton odjavaBtn;
    private JLabel imeVozaca;
    private JPanel panelVozaca;
    private JButton prihvatanjeVoznji;
    private TaxiSluzba sluzba;

    public EkranVozac(Osoba prijavljeniVozac, TaxiSluzba taxiSluzba){
        sluzba = taxiSluzba;
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

        statistikaBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                IzvestajVozaca izvestajVozaca = new IzvestajVozaca(taxiSluzba, prijavljeniVozac.getIdKorisnika());
                izvestajVozaca.setVisible(true);
            }
        });

        istorijaVoznjiBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                VoznjeVozaca voznjeVozaca = new VoznjeVozaca(prijavljeniVozac1.getLisaVoznji());
                voznjeVozaca.setVisible(true);
            }
        });

        prihvatanjeVoznji.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PrihvatanjeOdbijanjeVoznji prihvatanjeOdbijanjeVoznji = new PrihvatanjeOdbijanjeVoznji(taxiSluzba, prijavljeniVozac1);
                prihvatanjeOdbijanjeVoznji.setVisible(true);
            }
        });

        licitacijaBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LicitacijaProzor licitacijaProzor = new LicitacijaProzor(taxiSluzba, prijavljeniVozac);
                licitacijaProzor.setVisible(true);
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
