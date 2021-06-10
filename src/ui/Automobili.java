package ui;

import collections.list.DoublyLinkedList;
import entiteti.Automobil;
import entiteti.TaxiSluzba;
import korisnici.Musterija;
import korisnici.Osoba;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Automobili extends JFrame {
    private JPanel AutomobiliFrame;
    private JScrollPane AutomobiliScrollPane;
    private JTable AutomobiliTable;
    private JButton btnPretrazi;
    private JTextField txtModel;
    private JTextField txtProizvodjac;
    private JTextField txtRegistracija;
    private JTextField txtBrojTaksija;
    private JLabel lblModel;
    private JLabel lblProizvodjac;
    private JLabel lblRegistracija;
    private JLabel lblBrojVozila;
    private JButton nazadButton;

    public Automobili(TaxiSluzba taxiSluzba) {
        add(AutomobiliFrame);
        setTitle("Click&Go - prikaz automobila");
        setResizable(false);
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        btnPretrazi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {

                    String proizvodjac = txtProizvodjac.getText();
                    String model = txtModel.getText();
                    String registracija = txtRegistracija.getText();
                    String brojAutomobila = txtBrojTaksija.getText();

                    DoublyLinkedList<Automobil> listaNadjenihAUtomobila = new DoublyLinkedList<Automobil>();
                    for (Automobil automobil: taxiSluzba.getListaAutomovila()
                         ) {
                        if ((proizvodjac.equals("") || proizvodjac.equals(automobil.getProizvodjac())) &&
                                (model.equals("") || model.equals(automobil.getModel())) &&
                                (registracija.equals("") || registracija.equals(automobil.getBrojRegistracije())) &&
                                (brojAutomobila.equals("") || Integer.parseInt(brojAutomobila) == automobil.getBrojVozila())
                        ){
                            System.out.println(proizvodjac + " / " + automobil.getProizvodjac());
                            System.out.println(model  + " / " + automobil.getModel());
                            System.out.println(registracija  + " / " +  automobil.getBrojRegistracije());
                            System.out.println(brojAutomobila  + " / " +  automobil.getBrojVozila());
                            listaNadjenihAUtomobila.add(automobil);
                        }

                    }
                    initTable(listaNadjenihAUtomobila);
                }catch (Exception e1){
                    JOptionPane.showMessageDialog( new Frame(),
                            "Došlo je do greške provjerite unose!",
                            null,
                            JOptionPane.WARNING_MESSAGE);
                }

            }
        });

        nazadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
    }

    public void initTable(DoublyLinkedList<Automobil> listaAutomobila) {


        int brojAutomobila = listaAutomobila.size();
        String data[][] = new String[brojAutomobila][8];

        int index= 0;
        for (Automobil automobil: listaAutomobila) {
            data[index] = automobil.toArrayString();
            index++;
        }

        String column[]={"ID Automobila","Model","Proizvođač", "Datum registracije", "Broj vozila", "Broj registracije", "Tip vozila", "ID Vozača"};

        AutomobiliTable.setModel(new DefaultTableModel(data, column));
        AutomobiliTable.setAutoCreateRowSorter(true);
        add(AutomobiliFrame);
    }
}
