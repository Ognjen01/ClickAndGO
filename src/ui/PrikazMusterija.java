package ui;

import entiteti.TaxiSluzba;
import entiteti.Voznja;
import entiteti.VoznjaNarucenaAplikacijom;
import entiteti.VoznjaNarucenaTelefonom;
import korisnici.Musterija;
import korisnici.Osoba;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PrikazMusterija extends JFrame {
    private JPanel panelTabele;
    private JScrollPane sp;
    private JTable tabelaMusterija;
    private JButton nazadBtn;
    private JButton osvjeziTabeluBtn;

    public PrikazMusterija(TaxiSluzba taxiSluzba) {

        setSize(800, 400);
        setTitle("Click&GO - Pregled aktivnih mušterija");
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
        int brojMusterija = taxiSluzba.getListaOsoba().size();
        String data[][] = new String[brojMusterija][8];

        int index = 0;
        for (Osoba osoba: taxiSluzba.getListaOsoba()
        ) {
            if (osoba instanceof Musterija) {
                Musterija musterija = (Musterija) osoba;

                data[index] = musterija.toArrayString();

                index++;
            }
        }

        String column[]={"ID","Ime","Prezime", "Korisničko ime", "JMBG", "Adresa prebivališta", "Pol", "Broj telefona"};
        tabelaMusterija.setModel(new DefaultTableModel(data, column));
        tabelaMusterija.setAutoCreateRowSorter(true);
        add(panelTabele);

    }


}
