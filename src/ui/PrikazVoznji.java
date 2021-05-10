package ui;

import entiteti.TaxiSluzba;
import entiteti.Voznja;

import javax.swing.*;
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

        // TODO: Napraviti provjeru i prosleđivanje podataka voznji unutar tabele
        //      Broj polja i broj polja u objektima motaju biti isti!!!!
        int brojVoznji = taxiSluzba.getListaVoznji().size();
        String data[][] = new String[brojVoznji][10]; // TODO: NAkon ovoga proci kroz nizove i liste!!!

        int index = 0;
        for (Voznja voznja: taxiSluzba.getListaVoznji()
             ) {

            data[index]= voznja.toStringArray();
            index++;
        }


            String nizEntiteta[] = {"101","Amit","670000","101","Amit","670000","101","Amit","670000","101","Amit" };
             // iterirati kroz niz sa for i na index maks + 1 dodati novi niz
//             data[3] = nizEntiteta;




        String column[]={"ID","Mušterija ID","Vozač ID", "Adresa polaska", "Adresa destinacije", "Status", "Dužina", "Trajanje", "Cena", "Datum i vreme"};
        tabelaVoznji = new JTable(data,column);
        tabelaVoznji.setBounds(30,40,200,300);
        sp = new JScrollPane(tabelaVoznji);
        sp.setSize(100, 100); // Ne djeluje dodavanje dimenzija!!
        add(sp);
        
    }
}
