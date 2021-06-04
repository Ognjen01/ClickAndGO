package ui;

import entiteti.TaxiSluzba;
import entiteti.Voznja;
import entiteti.VoznjaNarucenaAplikacijom;
import entiteti.VoznjaNarucenaTelefonom;
import enumeracije.StatusVoznje;
import korisnici.Osoba;
import korisnici.Vozac;
import pomocneKlase.BinarnaPretraga;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class LicitacijaProzor extends JFrame {
    private JPanel panel1;
    private JTable tabelaAktuelnihVoznji;
    private JButton aplicirajBtn;
    private JButton nazadBtn;
    private JButton osvjeziTabeluButton;

    public LicitacijaProzor(TaxiSluzba taxiSluzba, Osoba trenutnoPrijevljeniVozac){
        setSize(800, 400);
        setTitle("Click&GO - Učestvovanje u aukciji");
        setLocationRelativeTo(null);

        add(panel1);
        osvjeziTabele(taxiSluzba);


        nazadBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        aplicirajBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try{

                    int idPozicijaVoznje = tabelaAktuelnihVoznji.getSelectedRow();
                    int idVoznjazaDodjelu =Integer.parseInt((String) tabelaAktuelnihVoznji.getValueAt(idPozicijaVoznje, 0));


                    UnosInfoApliciranje unosInfoApliciranje = new UnosInfoApliciranje(taxiSluzba, idVoznjazaDodjelu, (Vozac) trenutnoPrijevljeniVozac); // Proslijediti mu informacije
                    unosInfoApliciranje.setVisible(true);

                } catch (Exception exception){
                    JOptionPane.showMessageDialog( new Frame(),
                            "Niste odabrali vožnju!",
                            null,
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        osvjeziTabeluButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                osvjeziTabele(taxiSluzba);
            }
        });


    }

    public  void osvjeziTabele(TaxiSluzba taxiSluzba) {

        // Postavljanje informacija vožnji
        BinarnaPretraga binarnaPretraga = new BinarnaPretraga();
        List<Voznja> listaKreiranihVoznji = new ArrayList<Voznja>();

        for (Voznja voznja : taxiSluzba.getListaVoznji()
        ) {
            if ((voznja instanceof VoznjaNarucenaAplikacijom) && (voznja.getStatus() == StatusVoznje.NA_CEKANJU))
                 {
                listaKreiranihVoznji.add(voznja);
            }
        }

        int brojVoznji = listaKreiranihVoznji.size();
        String data[][] = new String[brojVoznji][11];

        int index = 0;
        for (Voznja voznja : listaKreiranihVoznji
        ) {
            data[index] = voznja.toStringArray();
            data[index][10] = "aplikacija";
            data[index][1] = binarnaPretraga.pronadjiOsobuBinarySearch(taxiSluzba.getListaOsoba(), voznja.getIdMusterije()).getIme();
            index++;
            System.out.println((voznja instanceof VoznjaNarucenaAplikacijom) + " / " + (voznja instanceof VoznjaNarucenaTelefonom));
        }

        String column[] = {"ID", "Mušterija", "Vozač ID", "Adresa polaska", "Adresa destinacije", "Status", "Dužina (km)", "Trajanje (min)", "Cena (RSD)", "Datum i vreme", "Tip naručivanja"};
        tabelaAktuelnihVoznji.setModel(new DefaultTableModel(data, column));
        tabelaAktuelnihVoznji.setAutoCreateRowSorter(true);
    }
}
