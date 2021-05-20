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

    public DodavanjeVozaca(TaxiSluzba taxiSluzba) {

        //TODO: Postoji problem kada je jednom pogriješi u dodavanju vozača, ne dozvoljava da se to ispravi i doda opet
        // Moguće da negdje zaostaju neke varijable ili uslovi ispravnosti!!!!!!!!!!!
        // Radi u većoj mjeri, manji nedostaci

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

                try {

                    Automobil automobilVozaca = null;
                    Pol polC = Pol.MUSKI;


                    String imeVozaca = imeVozacaPolje.getText();
                    String prezimeVozaca = prezimeVozacaPolje.getText();
                    String korisnickoIme = korisnickoImeVozacaPolje.getText();
                    String lozinkaVozaca = lozinkaVozacaPolje.getText();
                    String jmbgVozaca = jmbgVozacaPolje.getText();
                    String adresaVozaca = adresaVozacaPolje.getText();


                    if (
                            imeVozaca.equals("") ||
                                    prezimeVozaca.equals("") ||
                                    jmbgVozaca.equals("") ||
                                    adresaVozaca.equals("") ||
                                    korisnickoIme.equals("") ||
                                    lozinkaVozaca.equals("")
                    ){
                        throw new Exception();
                    }

                    // Provjera da li postoji korisničko ime

                    for (Osoba osoba : taxiSluzba.getListaOsoba()
                    ) {
                        if (osoba.getKorisnickoIme().equals(imeVozaca)) {
                            JOptionPane.showMessageDialog(new Frame(),
                                    "Već postoji uneseno korisničko ime",
                                    "Greška",
                                    JOptionPane.WARNING_MESSAGE);
                            throw new Exception();
                        }

                    }

                    // dodati enum
                    if (muskiRadioButton.isSelected()) {
                        polC = Pol.MUSKI;
                    } else if (zenskiRadioButton.isSelected()) {
                        polC = Pol.ZENSKI;
                    } else {
                        System.out.println("Niste odabrali pol");
                    }

                    String brTelefonaVozaca = brojTelefonaVozaca.getText();
                    int plata = Integer.parseInt(plataVozacaPolje.getText());
                    int brojClanskeKarte = Integer.parseInt(brojClanskeKartePolje.getText());
                    // Za aktivnost proslijediti true u konstruktor, uloga vozac, prosjecna ocjena nula

                    // Sistem generisanja ID vozaca

                    // TODO: Postoji problem sa uzastopnim dodoavanjem više vozača, generiše isti ID

                    int id = 0;
                    for (Osoba vozac: taxiSluzba.getListaOsoba()
                    ) {
                        int idVozaca = vozac.getIdKorisnika();
                        if (idVozaca >= id && vozac instanceof Vozac) {
                            id = idVozaca + 2 ;
                        }
                    }

                    System.out.println("\n ID NOVOKREIRANOG VOZACA : " + id + "\n");

                    // Dodjeljivanje automobila

                    String odabraniAutomobil = comboBox1.getSelectedItem().toString();

                    if (!odabraniAutomobil.equals("0")) {
                        for (Automobil automobil :
                                taxiSluzba.getListaAutomovila()) {
                            String nadjeniAutomobi = automobil.getModel() + " (ID " + automobil.getAutomobilID() + ")";

                            if (odabraniAutomobil.equals(nadjeniAutomobi)) {
                                automobil.setIdVozaca(id);
                                automobilVozaca = automobil;
                            }

                        }
                    }


                    Vozac dodatiVozac = new Vozac(id, imeVozaca, prezimeVozaca, korisnickoIme, lozinkaVozaca, jmbgVozaca, adresaVozaca, polC, brTelefonaVozaca, "vozac", true, plata, brojClanskeKarte, automobilVozaca, null, 0.0);
                    taxiSluzba.getListaOsoba().add(dodatiVozac);

                } catch (Exception e3) {
                    JOptionPane.showMessageDialog(new Frame(),
                            "Greška prilikom dodavanja vozača, provjerite unijete informacije!",
                            "Greška",
                            JOptionPane.WARNING_MESSAGE);
                    System.out.println(e);
                }

            }
        });

        odustaniButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
    }

}
