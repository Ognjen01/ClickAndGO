package ui;

import entiteti.TaxiSluzba;
import entiteti.Voznja;
import entiteti.VoznjaNarucenaAplikacijom;
import entiteti.VoznjaNarucenaTelefonom;
import enumeracije.StatusVoznje;
import pomocneKlase.Aukcija;
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
