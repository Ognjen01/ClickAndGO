package ui;

import collections.list.DoublyLinkedList;
import entiteti.Voznja;
import entiteti.VoznjaNarucenaAplikacijom;
import entiteti.VoznjaNarucenaTelefonom;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class RezultatiIzvestajaVozaca extends JFrame {
    private JPanel panel1;
    private JLabel ukupanBrojVoznji;
    private JLabel voznjePoruceneAplikacijom;
    private JLabel voznjePoruceneTelefonom;
    private JLabel prosjecnoTrajanje;
    private JLabel prosjecnaDuzina;
    private JLabel ukupnaZarada;
    private JButton stampajIzvještajButton;
    private JButton nazadButton;
    private JLabel ukKilometriLabel;
    private JLabel ukVremenaLabel;

    public RezultatiIzvestajaVozaca(DoublyLinkedList<Voznja> listaVoznji){
        setSize(400, 600);
        setTitle("Click&GO - Rezultati izvještaja");
        setLocationRelativeTo(null);

        add(panel1);

        double trajanje = 0;
        double duzina = 0;
        int ukupanBroj = 0;
        int aplikacija = 0;
        int telefon = 0;
        int ukZarada = 0;
        double prosTrajanje = 0;
        double prosDuzina = 0;
        double ukupnoKilometara = 0;
        double ukupnoVremena = 0;



            for (
        Voznja voznja : listaVoznji
                 ) {
            ukupanBroj++;

            if (voznja instanceof VoznjaNarucenaTelefonom){
                telefon++;
            } else if (voznja instanceof VoznjaNarucenaAplikacijom){
                aplikacija++;
            }

            trajanje += voznja.getTrajanje();
            duzina += voznja.getDuzina();

            ukZarada += voznja.getCenaVoznje();
            ukupnoKilometara += voznja.getDuzina();
            ukupnoVremena += voznja.getTrajanje();



        }

        prosTrajanje = trajanje / listaVoznji.size();
        prosDuzina = duzina / listaVoznji.size();

            ukupanBrojVoznji.setText(String.valueOf(ukupanBroj));
            voznjePoruceneAplikacijom.setText(String.valueOf(aplikacija));
            voznjePoruceneTelefonom.setText(String.valueOf(telefon));
            prosjecnoTrajanje.setText(String.valueOf(prosTrajanje));
            prosjecnaDuzina.setText(String.valueOf(prosDuzina));
            ukupnaZarada.setText(String.valueOf(ukZarada));
            ukKilometriLabel.setText(String.valueOf(ukupnoKilometara));
            ukVremenaLabel.setText(String.valueOf(ukupnoVremena));


            nazadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });


}
}

