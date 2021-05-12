package ui;

import entiteti.TaxiSluzba;
import korisnici.Osoba;
import korisnici.Vozac;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IzmjenaVozaca extends JFrame {

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
    private JButton izmjeniVozacaButton;
    private JButton odustaniButton;
    private JTextField brojClanskeKartePolje;

    public IzmjenaVozaca(TaxiSluzba taxiSluzba, int idVozaca){

        setSize(500, 500);
        setTitle("Click&GO");
        add(osnovniPanel);

        System.out.println("Vozac za izmjenu u prozoru: " + idVozaca);

        // Pronalaženje traženog vozača
        Vozac vozacZaIzmjenu = null;
        for (Osoba osoba: taxiSluzba.getListaOsoba()
             ) {
            if (osoba.getIdKorisnika() == idVozaca && osoba instanceof Vozac){
                vozacZaIzmjenu = (Vozac) osoba;
            }
        }

        imeVozacaPolje.setText(vozacZaIzmjenu.getIme());
        prezimeVozacaPolje.setText(vozacZaIzmjenu.getPrezime());
        korisnickoImeVozacaPolje.setText(vozacZaIzmjenu.getKorisnickoIme());
        lozinkaVozacaPolje.setText(vozacZaIzmjenu.getLozinka());
        jmbgVozacaPolje.setText(vozacZaIzmjenu.getJmbg());
        adresaVozacaPolje.setText(vozacZaIzmjenu.getAdresa());
        brojClanskeKartePolje.setText(String.valueOf(vozacZaIzmjenu.getBrClanskeKarte()));

        if (vozacZaIzmjenu.getPol() == 'm') {
            muskiRadioButton.setSelected(true);
        } else if (vozacZaIzmjenu.getPol() == 'z') {
            zenskiRadioButton.setSelected(true);
        } else {
            System.out.println("Došlo je do greške prilikom preuzimanja vozača za izmjenud");
        }

        brojTelefonaVozaca.setText(vozacZaIzmjenu.getBrojTelefona());
        plataVozacaPolje.setText(String.valueOf(vozacZaIzmjenu.getPlata()));

        // TODO: Dodati automobil u drop down meni

        odustaniButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        izmjeniVozacaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String ime = imeVozacaPolje.getText();
                    String prezime = prezimeVozacaPolje.getText();
                    String korisnickoIme = korisnickoImeVozacaPolje.getText();
                    String lozinka = lozinkaVozacaPolje.getText();
                    String jmbg = jmbgVozacaPolje.getText();
                    String adresa = adresaVozacaPolje.getText();
                    String brojTelefona = brojTelefonaVozaca.getText();
                    int plata = Integer.parseInt(plataVozacaPolje.getText());
                    int brClanskeKarte = Integer.parseInt(brojClanskeKartePolje.getText());
                    // TODO: Pol prebaciti u enumeraciju
                    char pol = 'm';
                    if(muskiRadioButton.isSelected()){
                        pol = 'm';
                    } else if (zenskiRadioButton.isSelected()){
                        pol = 'z';
                    } else {
                        System.out.println("Problem sa polom");
                    }

                    int confirmed = JOptionPane.showConfirmDialog(null,
                            "Da li ste sigurni da želite izmjeniti vozača", "Potvrdite izmjenu",
                            JOptionPane.YES_NO_OPTION);

                    if(confirmed == JOptionPane.YES_OPTION) {
                        for (Osoba vozac : taxiSluzba.getListaOsoba()) {
                            if (idVozaca == vozac.getIdKorisnika() && vozac instanceof Vozac) {
                                vozac.setIme(ime);
                                vozac.setPrezime(prezime);
                                vozac.setJmbg(jmbg);
                                vozac.setKorisnickoIme(korisnickoIme);
                                ((Vozac) vozac).setBrClanskeKarte(brClanskeKarte);
                                vozac.setLozinka(lozinka);
                                ((Vozac) vozac).setPlata(plata);
                                vozac.setAdresa(adresa);
                                vozac.setBrojTelefona(brojTelefona);
                                vozac.setPol(pol);
                            }
                            setVisible(false);

                        }
                    }




                } catch (Exception e1) {
                    System.out.println("Problem prilikom preuzimanja informacija iz polja greska" + e1);
                }
            }
        });

    }
}
