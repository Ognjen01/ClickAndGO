package ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        Object[] zaglavlje = {"ID","Model","Proizvodjac","Godina proizvodnje","Registracija","Broj vozila","Vrsta vozila","Vozač"};
        Object[][] prikaz = new Object[3][zaglavlje.length];
        JTable model = new JTable(prikaz,zaglavlje);
        AutomobiliScrollPane = new JScrollPane(model);

        add(AutomobiliTable);
        add(AutomobiliScrollPane);
*/

        btnDodaj.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DodavanjeIzmenaAutomobila dodavanjeIzmenaAutomobila = new DodavanjeIzmenaAutomobila();
                dodavanjeIzmenaAutomobila.setVisible(true);
            }
        });



    }
}
