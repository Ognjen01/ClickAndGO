package ui;

import entiteti.TaxiSluzba;
import enumeracije.Pol;
import korisnici.Dispecer;
import korisnici.Osoba;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class IzmenaDispecera extends JFrame {
    private JPanel osnovniPanel;
    private JTextField imeInput;
    private JTextField prezimeInput;
    private JTextField korisnickoImeInput;
    private JTextField lozinkaInput;
    private JTextField jmbgInput;
    private JTextField adresaInput;
    private JTextField brojTelefonaInput;
    private JTextField plataInput;
    private JButton izmeniDispeceraBtn;
    private JButton odustaniBtn;
    private JComboBox polComboBox;
    private JTextField brojTelefonskeLinijeInput;
    private JTextField odeljenjeInput;

    public IzmenaDispecera(TaxiSluzba taxiSluzba, int idDispecera) {
        setSize(500, 600);
        setLocationRelativeTo(null);
        setTitle("Click&GO - Izmena dispečera");
        add(osnovniPanel);

        // Pronalaženje traženog dispecera
        Dispecer dispecerZaIzmenu = null;
        for (Osoba osoba : taxiSluzba.getListaOsoba()) {
            if (osoba.getIdKorisnika() == idDispecera && osoba instanceof Dispecer) {
                dispecerZaIzmenu = (Dispecer) osoba;
            }
        }

        for (Pol pol : Pol.values()) {
            polComboBox.addItem(pol.toString());
        }

        imeInput.setText(dispecerZaIzmenu.getIme());
        prezimeInput.setText(dispecerZaIzmenu.getPrezime());
        korisnickoImeInput.setText(dispecerZaIzmenu.getKorisnickoIme());
        lozinkaInput.setText(dispecerZaIzmenu.getLozinka());
        jmbgInput.setText(dispecerZaIzmenu.getJmbg());
        adresaInput.setText(dispecerZaIzmenu.getAdresa());
        polComboBox.setSelectedItem(dispecerZaIzmenu.getPol().toString());
        brojTelefonaInput.setText(dispecerZaIzmenu.getBrojTelefona());
        plataInput.setText(String.valueOf(dispecerZaIzmenu.getPlata()));
        brojTelefonskeLinijeInput.setText(String.valueOf(dispecerZaIzmenu.getBrTelefonskeLinije()));
        odeljenjeInput.setText(dispecerZaIzmenu.getOdjeljenje());


        izmeniDispeceraBtn.addActionListener(new ActionListener() {
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
                    int plata = Integer.parseInt(plataInput.getText());
                    int brTelefonskeLinije = Integer.parseInt(brojTelefonskeLinijeInput.getText());
                    String odeljenje = odeljenjeInput.getText();

                    /*if (
                            ime.equals("") ||
                                    prezime.equals("") ||
                                    korisnickoIme.equals("") ||
                                    lozinka.equals("") ||
                                    jmbg.equals("") ||
                                    adresa.equals("") ||
                                    brojTelefona.equals("")
                    ){
                        throw new Exception();
                    }*/

                    int confirmed = JOptionPane.showConfirmDialog(null,
                            "Da li ste sigurni da želite izmeniti dispečera", "Potvrdite izmenu",
                            JOptionPane.YES_NO_OPTION);

                    if (confirmed == JOptionPane.YES_OPTION) {
                        Dispecer osoba = new Dispecer();
                        osoba.setIme(ime);
                        osoba.setPrezime(prezime);
                        osoba.setKorisnickoIme(korisnickoIme);
                        osoba.setLozinka(lozinka);
                        osoba.setJmbg(jmbg);
                        osoba.setAdresa(adresa);
                        osoba.setPol(Pol.valueOf(pol));
                        osoba.setBrojTelefona(brojTelefona);
                        osoba.setPlata(plata);
                        osoba.setBrTelefonskeLinije(brTelefonskeLinije);
                        osoba.setOdjeljenje(odeljenje);

                        List<Osoba> sveOsobe = taxiSluzba.getListaOsoba();
                        for (int i = 0; i < sveOsobe.size(); i++) {
                            if (sveOsobe.get(i).getIdKorisnika() == idDispecera)
                                sveOsobe.set(i, osoba);
                        }

                        JOptionPane.showMessageDialog(null,
                                "Dispečer uspešno izmenjen!", "Izmena dispečera",
                                JOptionPane.INFORMATION_MESSAGE);
                        setVisible(false);
                    }

                } catch (Exception e1) {
                    System.out.println("Problem prilikom preuzimanja informacija iz polja" + e1);
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
