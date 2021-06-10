package ui;

import entiteti.Automobil;
import entiteti.TaxiSluzba;
import enumeracije.TipVozila;
import korisnici.Osoba;
import korisnici.Vozac;
import pomocneKlase.BrisanjeEntiteta;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class OperacijeAutomobili extends JFrame {
    private JPanel panel1;
    private JLabel labelAutomobili;
    private JPanel panel2;
    private JScrollPane sp;
    private JTable table1;
    private JPanel panel3;
    private JButton prikaziAutomobile;
    private JButton dodajAutomobilBtn;
    private JButton izmeniAutomobilBtn;
    private JButton obrisiAutomobilBtn;
    private JButton nazadBtn;

    private BrisanjeEntiteta brisanjeEntiteta;

    public OperacijeAutomobili(TaxiSluzba taxiSluzba){

        setSize(800, 400);
        setTitle("Click&GO - Operacije sa automobilima");
        setLocationRelativeTo(null);

        this.brisanjeEntiteta = new BrisanjeEntiteta();

        initTabela(taxiSluzba);

        this.prikaziAutomobile(taxiSluzba);
        this.dodajAutomobil(taxiSluzba);
        this.izmeniAutomobil(taxiSluzba);
        this.obrisiAutomobil(taxiSluzba);
        this.nazad();
    }

    public void initTabela(TaxiSluzba taxiSluzba){

        List<Automobil> listaAutomobila = new ArrayList<Automobil>();;
        for (Automobil automobil: taxiSluzba.getListaAutomovila()){
            listaAutomobila.add(automobil);
        }

        int brojAutomobila = listaAutomobila.size();
        String data[][] = new String[brojAutomobila][8];

        int index= 0;
        for (Automobil automobil: listaAutomobila) {
            data[index] = automobil.toArrayString();
            index++;
        }

        String column[]={"ID Automobila","Model","Proizvođač", "Datum registracije", "Broj vozila", "Broj registracije", "Tip vozila", "ID Vozača"};

        table1.setModel(new DefaultTableModel(data, column));
        table1.setAutoCreateRowSorter(true);
        add(panel1);
    }

    private void prikaziAutomobile(TaxiSluzba taxiSluzba) {
        prikaziAutomobile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                initTabela(taxiSluzba);
            }
        });
    }

    private void dodajAutomobil(TaxiSluzba taxiSluzba) {
        dodajAutomobilBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DodavanjeAutomobila dodavanjeAutomobila = new DodavanjeAutomobila(taxiSluzba);
                dodavanjeAutomobila.setVisible(true);
            }
        });
    }

    private void izmeniAutomobil(TaxiSluzba taxiSluzba) {
        izmeniAutomobilBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int idPozicija = table1.getSelectedRow();
                    int idAutomobila = Integer.parseInt((String) table1.getValueAt(idPozicija, 0));
                    IzmenaAutomobila izmenaAutomobila = new IzmenaAutomobila(taxiSluzba, idAutomobila);
                    izmenaAutomobila.setVisible(true);
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog( new Frame(),
                            "Morate selektovati red u tabeli!",
                            "Greška",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        });
    }

    private void obrisiAutomobil(TaxiSluzba taxiSluzba) {
        obrisiAutomobilBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    int confirmed = JOptionPane.showConfirmDialog(null,
                            "Da li ste sigurni da želite da obrišete automobil?", "Brisanje automobila",
                            JOptionPane.YES_NO_OPTION);

                    int idPozicija = table1.getSelectedRow();

                    String idAutomobilaZaBrisanje = (String) table1.getValueAt(idPozicija, 0);

                    if (confirmed == JOptionPane.YES_OPTION) {

                        int id = Integer.parseInt(idAutomobilaZaBrisanje);

                        for (Automobil automobil : taxiSluzba.getListaAutomovila()) {
                            if (automobil.getAutomobilID() == id) {
                                taxiSluzba.getListaAutomovila().remove(automobil);
                                System.out.println("AUTO OBRISAN " + automobil.toString());
                                break;
                            }
                        }

                        initTabela(taxiSluzba);
                        System.out.println("TABELA JE OSVJEZANA");

                        JOptionPane.showMessageDialog(null,
                                "Automobil uspešno obrisan!", "Brisanje automobila",
                                JOptionPane.INFORMATION_MESSAGE);

                        for (Automobil automobil : taxiSluzba.getListaAutomovila()) {
                            System.out.println(automobil.toString());
                        }
                    }
                } catch (Exception e1){
                    JOptionPane.showMessageDialog(null,
                            "Niste selektovali automobil!", "Brisanje automobila",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        });
    }

    private void nazad() {
        nazadBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
    }
}