package ui;

import entiteti.TaxiSluzba;
import enumeracije.Pol;
import korisnici.Osoba;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IzmjenaInformacijaMusterije extends JFrame{
    private JPanel osnovniPanel;
    private JTextField imePolje;
    private JTextField prezimePolje;
    private JTextField korisnickoImePolje;
    private JTextField lozinkaPolje;
    private JTextField jmbgPolje;
    private JTextField adresaPolje;
    private JRadioButton zenskiRadioButton;
    private JRadioButton muskiRadioButton;
    private JTextField brojTelefonaPolje;
    private JButton izmjeniMusterijuButton;
    private JButton odustaniButton;


    public IzmjenaInformacijaMusterije(TaxiSluzba taxiSluzba, Osoba musterija){

        setSize(500, 350);
        setTitle("Click&GO");
        setLocationRelativeTo(null);

        add(osnovniPanel);

        imePolje.setText(musterija.getIme());
        prezimePolje.setText(musterija.getPrezime());
        korisnickoImePolje.setText(musterija.getKorisnickoIme());
        lozinkaPolje.setText(musterija.getLozinka());
        jmbgPolje.setText(musterija.getJmbg());
        adresaPolje.setText(musterija.getAdresa());
        brojTelefonaPolje.setText(musterija.getBrojTelefona());


        ButtonGroup group = new ButtonGroup();
        group.add(zenskiRadioButton);
        group.add(muskiRadioButton);

        if (musterija.getPol() == Pol.MUSKI){
            muskiRadioButton.setSelected(true);
        } else if (musterija.getPol() == Pol.ZENSKI){
            zenskiRadioButton.setSelected(true);
        } else {
            System.out.println("Greska");
        }

        odustaniButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        izmjeniMusterijuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    String ime = imePolje.getText();
                    String prezime = prezimePolje.getText();
                    String korisnickoIme = korisnickoImePolje.getText();
                    String lozinka = lozinkaPolje.getText();
                    String adresa = adresaPolje.getText();
                    String jmbg = jmbgPolje.getText();
                    String brojTelefona = brojTelefonaPolje.getText();

                    Pol pol = null;
                    if (muskiRadioButton.isSelected()){
                        pol = Pol.MUSKI;
                    } else if (zenskiRadioButton.isSelected()){
                        pol = Pol.ZENSKI;
                    } else {
                        throw new Exception();
                    }

                    if (
                            ime.equals("") ||
                                    prezime.equals("") ||
                                    korisnickoIme.equals("") ||
                                    lozinka.equals("") ||
                                    adresa.equals("") ||
                                    jmbg.equals("") ||
                                    brojTelefona.equals("")
                    ) {
                        throw new Exception();
                    }

                    for (Osoba osoba: taxiSluzba.getListaOsoba()){
                        if (musterija.getIdKorisnika() == osoba.getIdKorisnika()){
                            osoba.setAdresa(adresa);
                            osoba.setBrojTelefona(brojTelefona);
                            osoba.setLozinka(lozinka);
                            osoba.setJmbg(jmbg);
                            osoba.setPrezime(prezime);
                            osoba.setIme(ime);
                            osoba.setKorisnickoIme(korisnickoIme);
                            osoba.setPol(pol);
                        }
                    }

                    JOptionPane.showMessageDialog( new Frame(),
                            "Uspješno izvršena izmjena informacija!",
                            null,
                            JOptionPane.INFORMATION_MESSAGE);

                    setVisible(false);

                } catch (Exception exception){
                    JOptionPane.showMessageDialog( new Frame(),
                            "Greška prilikom izmjene informacija, molimo pokušajte ponovo!",
                            "Greška",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        });



    }

}
