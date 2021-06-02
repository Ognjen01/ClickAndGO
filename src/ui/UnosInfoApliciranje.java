package ui;

import entiteti.TaxiSluzba;
import korisnici.Vozac;
import pomocneKlase.Aukcija;
import pomocneKlase.Ponuda;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UnosInfoApliciranje extends JFrame{
    private JPanel panel1;
    private JTextField vrijemePolje;
    private JCheckBox petFredlyCheckBox;
    private JButton aplicirajButton;
    private JButton odustaniButton;

    public UnosInfoApliciranje(TaxiSluzba taxiSluzba, int idVoznjeZaKojuSeAplicira, Vozac trenutnoPrijavljenVozac){
        setSize(500, 250);
        setTitle("Click&GO");
        setLocationRelativeTo(null);

        add(panel1);

        odustaniButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        aplicirajButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO: FORMIRANJE PONUDE I DODAVANJE U AUKCIJU ZA TU VOŽNJU

                try {
                    int vrijemeDolaska = Integer.parseInt(vrijemePolje.getText());
                    double prosjecnaOcjenaVozaca = trenutnoPrijavljenVozac.getProsjecnaOcjena();
                    int brojVoznjiVozaca = trenutnoPrijavljenVozac.getLisaVoznji().size();

                    Ponuda novaPonuda = new Ponuda(idVoznjeZaKojuSeAplicira, trenutnoPrijavljenVozac.getIdKorisnika(), trenutnoPrijavljenVozac.getKorisnickoIme(),prosjecnaOcjenaVozaca,brojVoznjiVozaca, vrijemeDolaska);


                    for (Aukcija aukcija : taxiSluzba.getListaAukcija()){
                        if (idVoznjeZaKojuSeAplicira == aukcija.getIdVoznje()){
                            aukcija.dodajPonuduUListu(novaPonuda);
                        }
                    }

                    int confirmed = JOptionPane.showConfirmDialog(null,
                            "Uspješno ste aplicirali za vožnju, molimo sačekajte rezultate!", "Molimo sačekajte",
                            JOptionPane.YES_NO_OPTION);

                    setVisible(false);
                } catch (Exception exception){
                    System.out.println("GREŠKA PRILIKOM KONKURISANJA ZA AUKCIJU");
                }

            }
        });

    }
}
