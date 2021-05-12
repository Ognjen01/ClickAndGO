package ui;

import entiteti.TaxiSluzba;
import entiteti.Voznja;
import entiteti.VoznjaNarucenaAplikacijom;
import entiteti.VoznjaNarucenaTelefonom;
import korisnici.Osoba;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class PrikazVoznji extends JFrame {

    private JPanel panelTabele;
    private JScrollPane sp;
    private JTable tabelaVoznji;
    private JButton nazadBtn;
    private JButton osvjeziTabeluBtn;

    public PrikazVoznji(TaxiSluzba taxiSluzba) {
        setSize(800, 400);
        setTitle("Click&GO");
        setLocationRelativeTo(null);

        osvjeziTabelu(taxiSluzba);

        nazadBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        osvjeziTabeluBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                osvjeziTabelu(taxiSluzba);
            }
        });
        
    }

    public void osvjeziTabelu (TaxiSluzba taxiSluzba) {
// TODO: Doraditi algoritam
        int brojVoznji = taxiSluzba.getListaVoznji().size();
        String data[][] = new String[brojVoznji][11];

        int index = 0;
        for (Voznja voznja: taxiSluzba.getListaVoznji()
        ) {
            data[index]= voznja.toStringArray();
            if (voznja instanceof VoznjaNarucenaTelefonom){
                data[index][10] = "telefon";
            } else {
                data[index][10] = "aplikacija";
            }

            index++;
            System.out.println((voznja instanceof VoznjaNarucenaAplikacijom) + " / " + (voznja instanceof VoznjaNarucenaTelefonom));
        }

        String column[]={"ID","Mušterija ID","Vozač ID", "Adresa polaska", "Adresa destinacije", "Status", "Dužina (km)", "Trajanje (min)", "Cena (RSD)", "Datum i vreme", "Tip naručivanja"};
        tabelaVoznji.setModel(new DefaultTableModel(data, column));
        add(panelTabele);
    }
}
