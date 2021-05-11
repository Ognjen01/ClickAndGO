package ui;

import entiteti.TaxiSluzba;
import korisnici.Osoba;
import korisnici.Vozac;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
                System.out.println(osoba.getUloga() + " " + osoba.getIme() + " AKTIVAN:" + osoba.isAktivan());
            }
        }

        int brojVozaca = listaVozaca.size();
        String data[][] = new String[brojVozaca][11];

        int index= 0;
        for (Vozac vozac: listaVozaca
        ) {
            if(vozac.isAktivan()) {
                System.out.println(vozac.getIme());
                data[index] = vozac.toArrayString();
                index++;
            }
        }

        String column[]={"Vozač ID","Ime","Prezime", "Korisničko ime", "JMBG", "Adresa", "Pol", "Broj telefona", "Prosječna ocjena", "Plata", "Automobil"};

        table1.setModel(new DefaultTableModel(data, column));

        add(panel1);


        dodajVozacaBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DodavanjeVozaca dodavanjeVozaca = new DodavanjeVozaca(taxiSluzba);
                dodavanjeVozaca.setVisible(true);
            }
        });


        izmjeniVozacaBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                IzmjenaVozaca izmjenaVozaca = new IzmjenaVozaca(taxiSluzba);
                izmjenaVozaca.setVisible(true);
            }
        });

        obrisiVozacaBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int confirmed = JOptionPane.showConfirmDialog(null,
                        "Da li ste sigurni da želite izbristi vozača imeVozača?", "Potvrdite brisanje",
                        JOptionPane.YES_NO_OPTION);
                int idPozicija = table1.getSelectedRow();// Druga funkcija za uzimanje reda
                String idVozacaZaBrisanje = (String) table1.getValueAt(idPozicija, 0);
                System.out.println(idPozicija + "//" + idVozacaZaBrisanje);

                if (confirmed == JOptionPane.YES_OPTION) {
                    // Funkcija za brisanje vozaca
                    int id = Integer.parseInt(idVozacaZaBrisanje);

                    for (Osoba osoba: taxiSluzba.getListaOsoba()
                         ) {
                        if(osoba.isAktivan() && osoba.getIdKorisnika() == id){
                            osoba.setAktivan(false);
                        }
                    }
                    // TODO: Napraviti funkciju koja ce da rafresuje tabelu nakon klika na YES

                }
            }
        });
    }
}
