package ui;

import entiteti.Automobil;
import entiteti.TaxiSluzba;
import korisnici.Osoba;
import korisnici.Vozac;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
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
    private JButton nazadBtn;

    public OperacijeVozaci(TaxiSluzba taxiSluzba, Osoba prijvljeniDispecer){

        setSize(800, 400);
        setTitle("Click&GO");
        setLocationRelativeTo(null);

        postaviInformacijeTabele(taxiSluzba);




        prikaziVozace.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                postaviInformacijeTabele(taxiSluzba);
            }
        });

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
                //int idVozaca = 0;
                try {
                    int idPozicija = table1.getSelectedRow();// Druga funkcija za uzimanje reda
                    int idVozaca = Integer.parseInt((String) table1.getValueAt(idPozicija, 0));
                    IzmjenaVozaca izmjenaVozaca = new IzmjenaVozaca(taxiSluzba, idVozaca);
                    izmjenaVozaca.setVisible(true);
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog( new Frame(),
                            "Niste odabrali korisnika kojeg želite izmjeniti!",
                            null,
                            JOptionPane.WARNING_MESSAGE);                }
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

                int idAutomobilaObrisanogVozaca = 0;
                if (confirmed == JOptionPane.YES_OPTION) {
                    // Funkcija za brisanje vozaca
                    int id = Integer.parseInt(idVozacaZaBrisanje);

                    for (Osoba osoba: taxiSluzba.getListaOsoba()
                         ) {
                        try {

                            if (osoba.isAktivan() && osoba.getIdKorisnika() == id) {
                                osoba.setAktivan(false);
                                Vozac vozac = (Vozac) osoba;
                                idAutomobilaObrisanogVozaca = vozac.getAutomobil().getAutomobilID();
                            }
                        } catch (Exception e1) {
                            System.out.println("Greška prilikom brisanja ali je vozač obrisan");
                        }
                    }
                    // TODO: Napraviti funkciju koja ce da rafresuje tabelu nakon klika na  i setuje ID VOZAC u automobilu na 0

                    for (Automobil automobil : taxiSluzba.getListaAutomovila()
                         ) {
                        if(automobil.getAutomobilID() == idAutomobilaObrisanogVozaca){
                            automobil.setIdVozaca(0);
                            System.out.println("Oslobođen automobil "+automobil.getAutomobilID() + " / " + automobil.getIdVozaca());
                        }
                    }

                }
            }
        });

        nazadBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EkranDispecer ekranDispecer = new EkranDispecer(prijvljeniDispecer, taxiSluzba);
                ekranDispecer.setVisible(true);
                setVisible(false);
            }
        });
    }

    public void postaviInformacijeTabele(TaxiSluzba taxiSluzba){

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
        table1.setAutoCreateRowSorter(true);
        add(panel1);
    }
}
