package ui;

import entiteti.TaxiSluzba;
import entiteti.Voznja;
import entiteti.VoznjaNarucenaAplikacijom;
import entiteti.VoznjaNarucenaTelefonom;
import enumeracije.StatusVoznje;
import pomocneKlase.Aukcija;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IstorijaAukcija extends JFrame {
    private JPanel panel1;
    private JScrollPane sp;
    private JTable tabelaAukcija;
    private JButton dataljiAukcijeButton;
    private JButton nazadButton;

    public IstorijaAukcija(TaxiSluzba taxiSluzba){
        setSize(800, 400);
        setTitle("Click&GO - Učestvovanje u aukciji");
        setLocationRelativeTo(null);

        add(panel1);
        osvjeziTabelu(taxiSluzba);

        nazadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });


    }


    public void osvjeziTabelu (TaxiSluzba taxiSluzba) {

        int brojVoznji = taxiSluzba.getListaVoznji().size();
        Object[][] data = new Object[brojVoznji][11];

        int index = 0;

        for (Aukcija aukcija: taxiSluzba.getListaAukcija()
        ) {

                data[index][0] = aukcija.getIdVoznje();
                data[index][1] = aukcija.getPonudeZaVoznju().size();


                index++;


        }

        String column[]={"ID Vožnje","Broj ponuda"};
        TableModel tableModel = new DefaultTableModel(data, column);
        tabelaAukcija.setModel(tableModel);

        tabelaAukcija.setAutoCreateRowSorter(true);
        add(panel1); }

}

