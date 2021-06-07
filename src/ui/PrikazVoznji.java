package ui;

import entiteti.TaxiSluzba;
import entiteti.Voznja;
import entiteti.VoznjaNarucenaAplikacijom;
import entiteti.VoznjaNarucenaTelefonom;
import korisnici.Osoba;
import korisnici.Vozac;
import pomocneKlase.BinarnaPretraga;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
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
    private JButton izbrisiVoznjuBtn;

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

        izbrisiVoznjuBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int confirmed = JOptionPane.showConfirmDialog(null,
                        "Da li ste sigurni da želite izbristi vožnju", "Potvrdite brisanje",
                        JOptionPane.YES_NO_OPTION);
                int idPozicija = tabelaVoznji.getSelectedRow();// Druga funkcija za uzimanje reda

                int idVoznjeZaBrisanje = (int) tabelaVoznji.getValueAt(idPozicija, 0);

                int idAutomobilaObrisanogVozaca = 0;
                if (confirmed == JOptionPane.YES_OPTION) {
                    // Funkcija za brisanje voznje
                    try {

                        for (Voznja voznja : taxiSluzba.getListaVoznji()
                        ) {
                            try {

                                if (voznja.getIdVoznje() == idVoznjeZaBrisanje) {
                                    taxiSluzba.getListaVoznji().remove(voznja);
                                }
                            } catch (Exception e1) {
                                System.out.println("Greška prilikom brisanja");
                            }
                        }
                    } catch (Exception exception){

                    }
                    osvjeziTabelu(taxiSluzba);
                }
            }
        });

    }

    public void osvjeziTabelu (TaxiSluzba taxiSluzba) {

        int brojVoznji = taxiSluzba.getListaVoznji().size();
        Object[][] data = new Object[brojVoznji][11];
        BinarnaPretraga binarnaPretraga = new BinarnaPretraga();

        int index = 0;

        for (Voznja voznja: taxiSluzba.getListaVoznji()
        ) {
            // Dodjeljivanje imena preko binarne prtrage
            String imeVozaca = " ";

            if (voznja.getIdVozaca() != 0) {
                 imeVozaca = binarnaPretraga.pronadjiOsobuBinarySearch(taxiSluzba.getListaOsoba(), voznja.getIdVozaca()).getKorisnickoIme();
            } else if (voznja.getIdVozaca() == 0){
                imeVozaca = "Nije dodjeljeno";
            }

            data[index][0] = voznja.getIdVoznje();
            data[index][1] = binarnaPretraga.pronadjiOsobuBinarySearch(taxiSluzba.getListaOsoba(), voznja.getIdMusterije()).getKorisnickoIme();
            data[index][2] = imeVozaca;
            //data[index][2] = voznja.getIdVozaca();
            data[index][3] = voznja.getAdresaPolaska();
            data[index][4] = voznja.getAdresaDestinacije();
            data[index][5] = voznja.getStatus();
            data[index][6] = voznja.getDuzina();
            data[index][7] = voznja.getTrajanje();
            data[index][8] = voznja.getCenaVoznje();
            data[index][9] = voznja.getVremeNarudzbine();

            if (voznja instanceof VoznjaNarucenaTelefonom){
                data[index][10] = "telefon";
            } else {
                data[index][10] = "aplikacija";
            }

            index++;
            System.out.println((voznja instanceof VoznjaNarucenaAplikacijom) + " / " + (voznja instanceof VoznjaNarucenaTelefonom));
        }

        String column[]={"ID","Mušterija ID","Vozač ID", "Adresa polaska", "Adresa destinacije", "Status", "Dužina (km)", "Trajanje (min)", "Cena (RSD)", "Datum i vreme", "Tip naručivanja"};
        TableModel tableModel = new DefaultTableModel(data, column);
        tabelaVoznji.setModel(tableModel);

        tabelaVoznji.setAutoCreateRowSorter(true);
        add(panelTabele);
    }
}
