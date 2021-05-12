package ui;

import entiteti.Automobil;
import entiteti.TaxiSluzba;
import enumeracije.Pol;
import korisnici.Osoba;
import korisnici.Vozac;

import javax.swing.*;
import javax.swing.text.TabableView;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    protected JButton dodajVozacaButton;
    protected JButton odustaniButton;
    private JTextField brojClanskeKartePolje;

    public DodavanjeVozaca(TaxiSluzba taxiSluzba){

        //TODO: DOODAVANJE DJELIMIČNO GOTOVO, DORADITI AUTOMOBIL

        setSize(500, 500);
        setTitle("Click&GO");
        add(osnovniPanel);

        ButtonGroup group = new ButtonGroup();
        group.add(zenskiRadioButton);
        group.add(muskiRadioButton);

        comboBox1.addItem(new String("0"));
        for (Automobil automobil : taxiSluzba.getListaAutomovila()) {
            if (automobil.getIdVozaca() == 0) {
                comboBox1.addItem(new String(automobil.getModel() + " (ID " + automobil.getAutomobilID() + ")"));
            }
        }

            dodajVozacaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Vozac noviVozac = kreirajVozaca(taxiSluzba);
                taxiSluzba.getListaOsoba().add(noviVozac);
            }
        });

        odustaniButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
    }

    public Vozac kreirajVozaca (TaxiSluzba taxiSluzba){
        Vozac dodatiVozac = null;
        try {
            Automobil automobilVozaca = null;
            Pol pol;
            char polC = 'm';

            String imeVozaca = imeVozacaPolje.getText();
            String prezimeVozaca = prezimeVozacaPolje.getText();
            String korisnickoIme = korisnickoImeVozacaPolje.getText();
            String lozinkaVozaca = lozinkaVozacaPolje.getText();
            String jmbgVozaca = jmbgVozacaPolje.getText();
            String adresaVozaca = adresaVozacaPolje.getText();

            // dodati enum
            if(muskiRadioButton.isSelected()){
                pol = Pol.MUSKI;
                polC = 'm';
            } else if (zenskiRadioButton.isSelected()){
                pol = Pol.ZENSKI;
                polC = 'z';
            } else {
                System.out.println("Niste odabrali pol");
            }

            String brTelefonaVozaca = brojTelefonaVozaca.getText();
            int plata = Integer.parseInt(plataVozacaPolje.getText());
            int brojClanskeKarte = Integer.parseInt(brojClanskeKartePolje.getText());
            // Za aktivnost proslijediti true u konstruktor, uloga vozac, prosjecna ocjena nula

            // TODO: Sistem dodjele automobila







            int id  = generisanjeIdVozaca(taxiSluzba);

            dodatiVozac = new Vozac(id,imeVozaca, prezimeVozaca, korisnickoIme, lozinkaVozaca, jmbgVozaca, adresaVozaca, polC, brTelefonaVozaca,"vozac",true,plata,brojClanskeKarte,automobilVozaca,null,0.0);

        } catch (Exception e) {
            JOptionPane.showMessageDialog( new Frame(),
                    "Greška prilikom dodavanja vozača, provjerite unijete informacije!",
                    "Greška",
                    JOptionPane.WARNING_MESSAGE);        }

        return dodatiVozac;
    }

    public int generisanjeIdVozaca(TaxiSluzba taxiSluzba){
        int id = 0;
        for (Osoba vozac: taxiSluzba.getListaOsoba()
             ) {
            int idVozaca = vozac.getIdKorisnika();
            if (idVozaca > id && vozac instanceof Vozac) {
                id = idVozaca + 1;
            }
        }
        return id;
    }
}
