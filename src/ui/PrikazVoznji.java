package ui;

import entiteti.TaxiSluzba;
import entiteti.Voznja;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class PrikazVoznji extends JFrame {

    private JPanel panelTabele;
    private JTable tabelaVoznji;
    private JScrollPane sp;

    public PrikazVoznji(TaxiSluzba taxiSluzba) {
        setSize(800, 400);
        setTitle("Click&GO");
        setLocationRelativeTo(null);

        // TODO: Doraditi algoritam
        int brojVoznji = taxiSluzba.getListaVoznji().size();
        String data[][] = new String[brojVoznji][10];

        int index = 0;
        for (Voznja voznja: taxiSluzba.getListaVoznji()
             ) {

            data[index]= voznja.toStringArray();
            index++;
        }

        String column[]={"ID","Mušterija ID","Vozač ID", "Adresa polaska", "Adresa destinacije", "Status", "Dužina (km)", "Trajanje (min)", "Cena (RSD)", "Datum i vreme"};
        tabelaVoznji.setModel(new DefaultTableModel(data, column));
        add(panelTabele);
        
    }
}
