package ui;

import collections.list.DoublyLinkedList;
import korisnici.Musterija;
import korisnici.Osoba;
import pomocneKlase.IzvestajVozacaPodaci;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IzvestajVozacaDispecer extends JFrame {
    private JPanel panel1;
    private JTable tabelaIzvestaja;
    private JButton nazadButton;
    public IzvestajVozacaDispecer(DoublyLinkedList<IzvestajVozacaPodaci> izvestajVozacaPodacis){
        setSize(800, 400);
        setTitle("Click&GO - Izvještaj vožnji");
        setLocationRelativeTo(null);

        initTable(izvestajVozacaPodacis);
        add(panel1);

        nazadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

    }

    public void initTable(DoublyLinkedList<IzvestajVozacaPodaci> izvestajVozacaPodacis){
        int brojPOgodaka = izvestajVozacaPodacis.size();
        String data[][] = new String[brojPOgodaka][8];

        int index = 0;
        for (IzvestajVozacaPodaci iyvestaj: izvestajVozacaPodacis
        ) {


                data[index] = iyvestaj.toArrayString();
                index++;

        }

        String column[]={"ID","Ukupan broj","Ukupna Duzina", "Ukupno Vreme", "Prosecna Duzina", "Prosecno vreme", "Ukupna zarada", "Prosecna zarada"};
        tabelaIzvestaja.setModel(new DefaultTableModel(data, column));
        tabelaIzvestaja.setAutoCreateRowSorter(true);
        add(panel1);

    }
}
