package ui;

import entiteti.Automobil;
import entiteti.TaxiSluzba;
import enumeracije.Pol;
import korisnici.Dispecer;
import korisnici.Osoba;
import korisnici.Vozac;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DodavanjeDispecera extends JFrame {

    private JPanel osnovniPanel;
    private JTextField imeInput;
    private JTextField prezimeInput;
    private JTextField korisnickoImeInput;
    private JTextField lozinkaInput;
    private JTextField jmbgInput;
    private JTextField adresaInput;
    private JTextField brojTelefonaInput;
    private JTextField plataInput;
    private JTextField odeljenjeInput;
    private JButton dodajDispeceraBtn;
    private JButton odustaniBtn;
    private JTextField brojTelefonskeLinijeInput;
    private JComboBox polComboBox;

    public DodavanjeDispecera(TaxiSluzba taxiSluzba) {
        setSize(500, 600);
        setLocationRelativeTo(null);
        setTitle("Click&GO - Dodavanje dispečera");
        add(osnovniPanel);

        for(Pol pol : Pol.values()) {
            polComboBox.addItem(pol.toString());
        }

        dodajDispeceraBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String ime = imeInput.getText();
                    String prezime = prezimeInput.getText();
                    String korisnickoIme = korisnickoImeInput.getText();
                    String lozinka = lozinkaInput.getText();
                    String jmbg = jmbgInput.getText();
                    String adresa = adresaInput.getText();
                    String pol = polComboBox.getSelectedItem().toString();
                    String brojTelefona = brojTelefonaInput.getText();
                    String plataTemp = plataInput.getText();
                    String brTelefonskeLinijeTemp = brojTelefonskeLinijeInput.getText();
                    String odeljenje = odeljenjeInput.getText();


                    // Proveera da li postoji korisničko ime
                    for (Osoba osoba : taxiSluzba.getListaOsoba()) {
                        if (osoba.getKorisnickoIme().equals(korisnickoIme)) {
                            JOptionPane.showMessageDialog(new Frame(),
                                    "Već postoji korisnik sa tim korisničkim imenom!",
                                    "Greška",
                                    JOptionPane.WARNING_MESSAGE);
                            throw new Exception();
                        }
                    }

                    int id = 0;
                    for (Osoba osoba: taxiSluzba.getListaOsoba()) {
                        int idDispecera = osoba.getIdKorisnika();
                        if (idDispecera >= id && osoba instanceof Dispecer) {
                            id = idDispecera + 2 ;
                        }
                    }

                    int plata = 0;
                    try{
                        plata = Integer.parseInt(plataTemp);
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(new Frame(),
                                "Plata mora biti ceo broj!",
                                "Greška",
                                JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    int brTelefonskeLinije = 0;
                    try{
                        brTelefonskeLinije = Integer.parseInt(brTelefonskeLinijeTemp);
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(new Frame(),
                                "Broj telefonske linije mora biti ceo broj!",
                                "Greška",
                                JOptionPane.ERROR_MESSAGE);
                        return;
                    }


                    Dispecer dispecer = new Dispecer(id, ime, prezime, korisnickoIme, lozinka, jmbg, adresa, Pol.valueOf(pol), brojTelefona, "dispecer", true, plata , brTelefonskeLinije, odeljenje);
                    taxiSluzba.getListaOsoba().add(dispecer);

                    JOptionPane.showMessageDialog(new Frame(),
                            "Dispečer uspešno sačuvan!",
                            "Unos novog dispečera",
                            JOptionPane.INFORMATION_MESSAGE);
                    setVisible(false);

                } catch (Exception e3) {
                    /*JOptionPane.showMessageDialog(new Frame(),
                            "Greška prilikom dodavanja dispečera, provjerite unete informacije!",
                            "Greška",
                            JOptionPane.WARNING_MESSAGE);*/
                    System.out.println(e);
                }

            }
        });

        odustaniBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
    }

}
