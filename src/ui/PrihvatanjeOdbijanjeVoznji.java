package ui;

import entiteti.TaxiSluzba;
import entiteti.Voznja;
import entiteti.VoznjaNarucenaAplikacijom;
import entiteti.VoznjaNarucenaTelefonom;
import enumeracije.StatusVoznje;
import korisnici.Osoba;
import korisnici.Vozac;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class PrihvatanjeOdbijanjeVoznji extends JFrame {

    private JPanel panel1;
    private JButton prihvatiVoznjuBtn;
    private JButton odbijVoznjuBtn;
    private JScrollPane sp;
    private JTable tabelaVoznji;
    private JTextField textField1;

    public PrihvatanjeOdbijanjeVoznji(TaxiSluzba taxiSluzba, Vozac prijavljeniVozac){
        setSize(800, 400);
        setTitle("Click&GO - Prihvatanje vožnji");
        setLocationRelativeTo(null);

        add(panel1);
        osvjeziTabelu(taxiSluzba, prijavljeniVozac);


        prihvatiVoznjuBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int idPozicijaVoznje = tabelaVoznji.getSelectedRow();
                int idVoznjazaPrihvatanje = Integer.parseInt((String) tabelaVoznji.getValueAt(idPozicijaVoznje, 0));

                for (Voznja voznja: taxiSluzba.getListaVoznji()
                     ) {
                    if(idVoznjazaPrihvatanje == voznja.getIdVoznje()){
                        voznja.setStatus(StatusVoznje.PRIHVACENA);
                    }
                }
            }
        });

        odbijVoznjuBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int idPozicijaVoznje = tabelaVoznji.getSelectedRow();
                int idVoznjazaPrihvatanje = Integer.parseInt((String) tabelaVoznji.getValueAt(idPozicijaVoznje, 0));

                for (Voznja voznja: taxiSluzba.getListaVoznji()
                ) {
                    if(idVoznjazaPrihvatanje == voznja.getIdVoznje()){
                        voznja.setStatus(StatusVoznje.ODBIJENA);
                    }
                }
            }
        });


    }

    public void osvjeziTabelu(TaxiSluzba taxiSluzba, Vozac prijavljeniVozac){

        List<Voznja> listaKreiranihVoznji = new ArrayList<Voznja>();

        for (Voznja voznja: taxiSluzba.getListaVoznji()
        ) {
            if ((voznja instanceof VoznjaNarucenaTelefonom) && (voznja.getStatus() == StatusVoznje.DODJELJENA) && (voznja.getIdVozaca() == prijavljeniVozac.getIdKorisnika())){
                listaKreiranihVoznji.add(voznja);
            }
        }

        int brojVoznji = listaKreiranihVoznji.size();
        String data[][] = new String[brojVoznji][11];

        int index = 0;
        for (Voznja voznja: listaKreiranihVoznji
        ) {
            data[index]= voznja.toStringArray();
            data[index][10] = "telefon";
            index++;
            System.out.println((voznja instanceof VoznjaNarucenaAplikacijom) + " / " + (voznja instanceof VoznjaNarucenaTelefonom));
        }

        String column[]={"ID","Mušterija ID","Vozač ID", "Adresa polaska", "Adresa destinacije", "Status", "Dužina (km)", "Trajanje (min)", "Cena (RSD)", "Datum i vreme", "Tip naručivanja"};
        tabelaVoznji.setModel(new DefaultTableModel(data, column));

    }
}
