package ui;

import entiteti.Automobil;
import entiteti.TaxiSluzba;
import korisnici.Dispecer;
import korisnici.Osoba;
import pomocneKlase.BrisanjeEntiteta;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class OperacijeDispeceri extends JFrame {

    private JPanel panel1;
    private JLabel labelDispeceri;
    private JPanel panel2;
    private JScrollPane sp;
    private JTable table1;
    private JPanel panel3;
    private JButton osveziBtn;
    private JButton dodajBtn;
    private JButton izmeniBtn;
    private JButton obrisiBtn;
    private JButton nazadBtn;
    private JLabel naslov;

    private BrisanjeEntiteta brisanjeEntiteta;

    public OperacijeDispeceri(TaxiSluzba taxiSluzba){

        setSize(800, 400);
        setTitle("Click&GO - Operacije sa dispečerima");
        setLocationRelativeTo(null);

        this.brisanjeEntiteta = new BrisanjeEntiteta();

        this.initTabela(taxiSluzba);

        osveziBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                initTabela(taxiSluzba);
            }
        });

        dodajBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DodavanjeDispecera dodavanjeDispecera = new DodavanjeDispecera(taxiSluzba);
                dodavanjeDispecera.setVisible(true);
            }
        });

        izmeniBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int idPozicija = table1.getSelectedRow();
                    int idDispecera = Integer.parseInt((String) table1.getValueAt(idPozicija, 0));
                    IzmenaDispecera izmenaDispecera = new IzmenaDispecera(taxiSluzba, idDispecera);
                    izmenaDispecera.setVisible(true);
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog( new Frame(),
                            "Morate selektovati red u tabeli!",
                            "Greška",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        obrisiBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int confirmed = JOptionPane.showConfirmDialog(null,
                        "Da li ste sigurni da želite da obrišete dispečera?", "Brisanje dispečera",
                        JOptionPane.YES_NO_OPTION);
                int idPozicija = table1.getSelectedRow();
                String idDispeceraZaBrisanje = (String) table1.getValueAt(idPozicija, 0);

                if (confirmed == JOptionPane.YES_OPTION) {

                    int id = Integer.parseInt(idDispeceraZaBrisanje);
                    for (Osoba osoba: taxiSluzba.getListaOsoba()) {
                        if(osoba.getIdKorisnika() == id) {
                            brisanjeEntiteta.obrisiKorisnika(taxiSluzba.getListaOsoba(), id);
                            initTabela(taxiSluzba);
                            JOptionPane.showMessageDialog(null,
                                    "Dispečer uspešno obrisan!", "Brisanje dispečera",
                                    JOptionPane.INFORMATION_MESSAGE);
                            break;
                        }
                    }
                }
            }
        });

        nazadBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
    }

    public void initTabela(TaxiSluzba taxiSluzba){

        List<Dispecer> listaDispecera = new ArrayList<Dispecer>();;
        for (Osoba osoba: taxiSluzba.getListaOsoba()){
            if(osoba instanceof Dispecer && osoba.isAktivan())
                listaDispecera.add((Dispecer) osoba);
        }

        int brojDispecera = listaDispecera.size();
        String data[][] = new String[brojDispecera][8];

        int index= 0;
        for (Dispecer dispecer: listaDispecera) {
            data[index] = dispecer.toArrayString();
            index++;
        }

        String column[]={"ID Dispečera", "Ime","Prezime", "Korisničko ime", "Lozinka", "JMBG", "Adresa", "Pol", "Broj telefona", "Plata", "Broj telefonske linije", "Odeljenje"};

        table1.setModel(new DefaultTableModel(data, column));
        table1.setAutoCreateRowSorter(true);
        add(panel1);
    }

}