package ui;

import entiteti.TaxiSluzba;
import entiteti.Voznja;
import entiteti.VoznjaNarucenaAplikacijom;
import entiteti.VoznjaNarucenaTelefonom;
import enumeracije.StatusVoznje;
import korisnici.Musterija;
import korisnici.Osoba;
import korisnici.Vozac;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VoznjeMusterije extends JFrame{
    private JPanel panel1;
    private JButton ocjeniVoznjuButton;
    private JButton nazadButton;
    private JTable tabelaVoznji;
    private JScrollPane sp;

    public VoznjeMusterije(Musterija musterija, TaxiSluzba taxiSluzba){
        setSize(800, 400);
        setTitle("Click&GO - istorija vožnji mušterije " + musterija.getKorisnickoIme());
        setLocationRelativeTo(null);

        osvjeziTabelu(musterija);

        nazadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });


        ocjeniVoznjuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO: ALGORITAM ZA OCJENJIVANJE
                try {

                    int idPozicija = tabelaVoznji.getSelectedRow();// Druga funkcija za uzimanje reda
                    System.out.println("RED  "+idPozicija);
                    int idVoznje = (int) tabelaVoznji.getValueAt(idPozicija, 0);
                    System.out.println("ID VOZNJE "+idVoznje);
                    int idVozaca = Integer.parseInt(String.valueOf(tabelaVoznji.getValueAt(idPozicija, 2)));
                    System.out.println("ID VOZACA "+idVozaca);
                    boolean voznjaJeVecOCjenjena = true;
                    for (Voznja voznja : taxiSluzba.getListaVoznji()
                         ) {
                        if (voznja.getIdVoznje() == idVoznje && !voznja.isOcjenjena() ){
                            OcjenjivanjeVozaca ocjenjivanjeVozaca = new OcjenjivanjeVozaca(taxiSluzba, idVozaca, idVoznje);
                            ocjenjivanjeVozaca.setVisible(true);
                            voznjaJeVecOCjenjena = false;
                        }
                    }

                    if (voznjaJeVecOCjenjena){
                        JOptionPane.showMessageDialog(null, "Vožnja je već ocjenjena", "" , JOptionPane.WARNING_MESSAGE);

                    }

                } catch (Exception exception){
                    JOptionPane.showMessageDialog(null, "Niste odabrali vožnju.", "" , JOptionPane.WARNING_MESSAGE);
                    System.out.println(exception);
                }
            }
        });
    }

    public void osvjeziTabelu (Musterija musterija) {

        int brojVoznji = musterija.getLisaVoznji().size();
        Object[][] data = new Object[brojVoznji][11];

        int index = 0;

        for (Voznja voznja : musterija.getLisaVoznji()
        ) {
            if(voznja.getStatus() == StatusVoznje.ZAVRSENA) {
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

        String column[] = {"ID", "Mušterija ID", "Vozač ID", "Adresa polaska", "Adresa destinacije", "Status", "Dužina (km)", "Trajanje (min)", "Cena (RSD)", "Datum i vreme", "Tip naručivanja"};
        TableModel tableModel = new DefaultTableModel(data, column);
        tabelaVoznji.setModel(tableModel);

        tabelaVoznji.setAutoCreateRowSorter(true);
        add(panel1);
    }
}
