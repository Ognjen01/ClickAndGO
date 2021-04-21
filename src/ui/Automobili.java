package ui;

import javax.swing.*;
import javax.swing.table.JTableHeader;
import java.awt.*;

public class Automobili extends JFrame {
    private JPanel AutomobiliFrame;
    private JScrollPane AutomobiliScrollPane;
    private JTable AutomobiliTable;
    private JButton btnDodaj;
    private JButton btnIzbrisi;
    private JButton btnIzmeni;
    private JButton btnPretrazi;
    private JTextField txtModel;
    private JTextField txtProizvodjac;
    private JTextField txtGodinaProizvodnje;
    private JTextField txtRegistracija;
    private JTextField txtBrojTaksija;
    private JLabel lblModel;
    private JLabel lblProizvodjac;
    private JLabel lblGodinaProizvodnje;
    private JLabel lblRegistracija;
    private JLabel lblBrojVozila;

    public Automobili()
    {
        add(AutomobiliFrame);
        setTitle("Click&Go - prikaz automobila");
        setResizable(false);
        setSize(600,400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        /*
        Object[] zaglavlje = {"Model","Proizvodjac","Godina proizvodnje","Registracija","Broj vozila","Vrsta vozila"};
        Object[][] prikaz = new Object[3][zaglavlje.length];
        AutomobiliTable = new JTable(prikaz,zaglavlje);
        AutomobiliScrollPane = new JScrollPane(AutomobiliTable);
         */
    }
}
