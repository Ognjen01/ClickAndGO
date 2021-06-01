package ui;

import collections.list.DoublyLinkedList;
import entiteti.TaxiSluzba;
import entiteti.Voznja;
import enumeracije.Pol;
import korisnici.Musterija;
import korisnici.Osoba;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Registracija extends JFrame {

    private JPanel osnovniPanel;
    private JTextField imePolje;
    private JTextField prezimePolje;
    private JTextField korisnickoImePolje;
    private JTextField lozinkaPolje;
    private JTextField jmbgMusterijePolje;
    private JTextField adresaPolje;
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

        ButtonGroup group = new ButtonGroup();
        group.add(zenskiradioButton);
        group.add(muskiRadioButton);

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


                try {
                    String ime = imePolje.getText();
                    String prezime = prezimePolje.getText();
                    String korisnickoIme = korisnickoImePolje.getText();
                    String lozinka = lozinkaPolje.getText();
                    String jmbg = jmbgMusterijePolje.getText();
                    String adresaPrebivalista = adresaPolje.getText();
                    String brojTelefona = brojTelefonaPolje.getText(); // STring jer moze da pocinje sa 0 -> Potreban regex
                    Pol pol = null;

                    if (
                            ime.equals("") ||
                                    prezime.equals("") ||
                                    korisnickoIme.equals("") ||
                                    lozinka.equals("") ||
                                    jmbg.equals("") ||
                                    adresaPrebivalista.equals("") ||
                                    brojTelefona.equals("")
                    ){
                        throw new Exception();
                    }

                    if (muskiRadioButton.isSelected()){
                        pol = Pol.MUSKI;
                    } else if (zenskiradioButton.isSelected()){
                        pol = Pol.ZENSKI;
                    } else {
                        System.out.println("Niste odabrali pol!");
                    }

                    String uloga = "korisnik";
                    boolean aktivan = true;
                    DoublyLinkedList<Voznja> listaVoznji = null;

                    //  Generisanje ID korisnika!

                    int idKorisnika = 0;
                    for (Osoba osoba: taxiSluzba.getListaOsoba()
                         ) {
                        if((osoba instanceof Musterija) && (osoba.getIdKorisnika() > idKorisnika)) {
                            idKorisnika = osoba.getIdKorisnika() + 1;
                        }

                    }

                    System.out.println("GENERISAN ID: " + idKorisnika);
                    Musterija novaMusterija = new Musterija(
                            idKorisnika,
                            ime,
                            prezime,
                            korisnickoIme,
                            lozinka,
                            jmbg,
                            adresaPrebivalista,
                            pol,
                            brojTelefona,
                            uloga,
                            aktivan,
                            listaVoznji
                    );


                    taxiSluzba.getListaOsoba().add(novaMusterija);

                    Prijava prijava = new Prijava(taxiSluzba);
                    prijava.setVisible(true);
                    setVisible(false);

                } catch (Exception e1){
                    System.out.println("Greška prilikom registracije!");
                    JOptionPane.showMessageDialog( new Frame(),
                            "Greška prilikom regitracije, molimo pokušajte ponovo!",
                            "Greška",
                            JOptionPane.WARNING_MESSAGE);
                }

            }
        });
    }
}
