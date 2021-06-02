package ui;

import entiteti.TaxiSluzba;
import entiteti.Voznja;
import entiteti.VoznjaNarucenaAplikacijom;
import entiteti.VoznjaNarucenaTelefonom;
import enumeracije.StatusVoznje;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PokretanjeAukcije extends JFrame {
    private JPanel panel1;
    private JScrollPane sp;
    private JTable tabelaVoznji;
    private JButton osvjeziBtn;
    private JButton pokreniAukcijuButton;
    private JButton nazadBtn;

    public PokretanjeAukcije (TaxiSluzba taxiSluzba){
        setSize(800, 400);
        setTitle("Click&GO - Aktivne aukcije");
        setLocationRelativeTo(null);

        osvjeziTabelu(taxiSluzba);

        pokreniAukcijuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO: Pokretanje algoritma aukcije
            }
        });

        osvjeziBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                osvjeziTabelu(taxiSluzba);
            }
        });

        nazadBtn.addActionListener(new ActionListener() {
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

        for (Voznja voznja: taxiSluzba.getListaVoznji()
        ) {
            if (voznja instanceof VoznjaNarucenaAplikacijom && voznja.getStatus() == StatusVoznje.NA_CEKANJU) {
                data[index][0] = voznja.getIdVoznje();
                data[index][1] = voznja.getIdMusterije();
                data[index][2] = voznja.getIdVozaca();
                data[index][3] = voznja.getAdresaPolaska();
                data[index][4] = voznja.getAdresaDestinacije();
                data[index][5] = voznja.getStatus();
                data[index][6] = voznja.getDuzina();
                data[index][7] = voznja.getTrajanje();
                data[index][8] = voznja.getCenaVoznje();
                data[index][9] = voznja.getVremeNarudzbine();

                if (voznja instanceof VoznjaNarucenaTelefonom) {
                    data[index][10] = "telefon";
                } else {
                    data[index][10] = "aplikacija";
                }

                index++;
                System.out.println((voznja instanceof VoznjaNarucenaAplikacijom) + " / " + (voznja instanceof VoznjaNarucenaTelefonom));
            }
        }

        String column[]={"ID","Mušterija ID","Vozač ID", "Adresa polaska", "Adresa destinacije", "Status", "Dužina (km)", "Trajanje (min)", "Cena (RSD)", "Datum i vreme", "Tip naručivanja"};
        TableModel tableModel = new DefaultTableModel(data, column);
        tabelaVoznji.setModel(tableModel);

        tabelaVoznji.setAutoCreateRowSorter(true);
        add(panel1); }

}
