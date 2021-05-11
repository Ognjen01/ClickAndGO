package ui;

import entiteti.TaxiSluzba;
import korisnici.Osoba;
import korisnici.Vozac;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;

public class OperacijeVozaci extends JFrame {
    private JPanel panel1;
    private JLabel labelVozaci;
    private JScrollPane sp;
    private JTable table1;
    private JButton prikaziVozace;
    private JButton dodajVozacaBtn;
    private JButton izmjeniVozacaBtn;
    private JButton obrisiVozacaBtn;
    private JPanel panel2;
    private JPanel panel3;

    public OperacijeVozaci(TaxiSluzba taxiSluzba){

        setSize(800, 400);
        setTitle("Click&GO");
        setLocationRelativeTo(null);


        List<Vozac> listaVozaca = new ArrayList<Vozac>();;
        for (Osoba osoba: taxiSluzba.getListaOsoba()){
            if(osoba instanceof Vozac){
                listaVozaca.add((Vozac) osoba);
                System.out.println(osoba.getUloga() + " " + osoba.getIme());
            }
        }

        int brojVozaca = listaVozaca.size();
        String data[][] = new String[brojVozaca][11];

        int index= 0;
        for (Vozac vozac: listaVozaca
        ) {
            System.out.println(vozac.getIme());
            data[index] = vozac.toArrayString();
            index++;
        }

        String column[]={"Vozač ID","Ime","Prezime", "Korisničko ime", "JMBG", "Adresa", "Pol", "Broj telefona", "Prosječna ocjena", "Plata", "Automobil"};

        table1.setModel(new DefaultTableModel(data, column));

        add(panel1);
    }
}
