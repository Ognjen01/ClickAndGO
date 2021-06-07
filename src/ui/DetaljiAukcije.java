package ui;

import entiteti.TaxiSluzba;
import entiteti.Voznja;
import entiteti.VoznjaNarucenaAplikacijom;
import entiteti.VoznjaNarucenaTelefonom;
import enumeracije.StatusVoznje;
import pomocneKlase.Aukcija;
import pomocneKlase.BinarnaPretraga;
import pomocneKlase.Ponuda;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class DetaljiAukcije extends JFrame {
    private JPanel panel1;
    private JButton nazadButton;
    private JTable tabelaPonuda;
    private JLabel idVoznje;
    private JLabel musterijaPolje;
    private JLabel vozacPolje;
    private JLabel duzinaPolje;
    private JLabel cijenaPolje;
    private JLabel trajanjePolje;
    private JLabel adresaPolaskaPolje;
    private JLabel destinacijaPolje;
    private JLabel datumPolje;
    private JLabel detaljiVoznje;

    public DetaljiAukcije(TaxiSluzba taxiSluzba, int idVoznjeIAukcije){


        setSize(800, 400);
        setTitle("Click&GO - Detalji aukcije " + idVoznjeIAukcije);
        setLocationRelativeTo(null);

        add(panel1);
        osvjeziTabele(taxiSluzba, idVoznjeIAukcije);

        nazadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

    }

    public  void osvjeziTabele(TaxiSluzba taxiSluzba, int idVoznjeIAukcije) {
        BinarnaPretraga binarnaPretraga = new BinarnaPretraga();
        for (Voznja voznja: taxiSluzba.getListaVoznji()
             ) {

            if (idVoznjeIAukcije == voznja.getIdVoznje()){
                idVoznje.setText("  ID vožnje: " + voznja.getIdVoznje());
                musterijaPolje.setText("  Mušterija: " + binarnaPretraga.pronadjiOsobuBinarySearch(taxiSluzba.getListaOsoba(), voznja.getIdMusterije()).getKorisnickoIme());
                if(voznja.getIdVozaca() != 0 ){
                    vozacPolje.setText("  Vozač: " + binarnaPretraga.pronadjiOsobuBinarySearch(taxiSluzba.getListaOsoba(), voznja.getIdVozaca()).getKorisnickoIme());
                } else {
                    vozacPolje.setText("  Vozač još nije dodjeljen");
                }

                cijenaPolje.setText("  Cijena vožnje: " + voznja.getCenaVoznje());
                trajanjePolje.setText("Trajanje vožnje: " + voznja.getTrajanje());
                adresaPolaskaPolje.setText("Adresa polaska: " + voznja.getAdresaPolaska());
                destinacijaPolje.setText("Adresa destinacije: " + voznja.getAdresaDestinacije());
                datumPolje.setText("Datum: "+ voznja.getVremeNarudzbine());
                duzinaPolje.setText("  Dužina: " + voznja.getDuzina());
                break;
            }
        }


        Aukcija aukcija = new Aukcija(0,  null);

        for (Aukcija au : taxiSluzba.getListaAukcija()
        ) {
            if (au.getIdVoznje() == idVoznjeIAukcije)
            {
                aukcija = au;
            }
        }

        int brojPonuda = aukcija.getPonudeZaVoznju().size();
        String data[][] = new String[brojPonuda][11];

        int index = 0;
        for (Ponuda ponuda : aukcija.getPonudeZaVoznju()
        ) {
            data[index][0] = String.valueOf(ponuda.getIdVoznje());
            data[index][1] = String.valueOf(ponuda.getIdVozaca());
            data[index][2] = ponuda.getKorisnickoImeVozaca();
            data[index][3] = String.valueOf(ponuda.getProsjecnaOcjenaVozaca());
            data[index][4] = String.valueOf(ponuda.getBrojVoznjiVozaca());
            data[index][5] = String.valueOf(ponuda.getVrijemeDolaska());
            data[index][6] = String.valueOf(ponuda.getOcjenaPonude());
            System.out.println("OCJENA PONUDE: " + ponuda.getOcjenaPonude());

            index++;
        }

        String column[] = {"ID Vožnje", "ID Vozača", "Korisničko ime", "Prosječna ocjena", "Broj vožnji", "Vrijeme", "Ocjena ponude"};
        tabelaPonuda.setModel(new DefaultTableModel(data, column));
        tabelaPonuda.setAutoCreateRowSorter(true);
    }
}
