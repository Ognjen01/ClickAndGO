package ui;

import entiteti.TaxiSluzba;
import entiteti.Voznja;
import entiteti.VoznjaNarucenaAplikacijom;
import entiteti.VoznjaNarucenaTelefonom;
import enumeracije.StatusVoznje;
import korisnici.Osoba;
import korisnici.Vozac;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class DodjelaVoznjiNarucenihTelefonom extends JFrame {

    private JPanel osnvniPanel;
    private JButton osvjeziTabeleBtn;
    private JButton dodjeliVoznjuBtn;
    private JButton odustaniBtn;
    private JScrollPane sp1;
    private JScrollPane sp2;
    private JTable tabelaVoznji;
    private JTable tabelaVozaca;

    public DodjelaVoznjiNarucenihTelefonom(TaxiSluzba taxiSluzba) {
        setSize(1300, 400);
        setTitle("Click&GO - Dodjeljivanje vožnji naručenih telefonom");
        setLocationRelativeTo(null);


        add(osnvniPanel);

        // Popunjavanje tabela aktivnim vozačima i vožnjama koje su kreirane

        osvjeziTabele(taxiSluzba);

        odustaniBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        osvjeziTabeleBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                osvjeziTabele(taxiSluzba);
            }
        });

        dodjeliVoznjuBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // Dodjeljivanje vožnji

                try {

                    int idPozicijaVoznje = tabelaVoznji.getSelectedRow();
                    int idVoznjazaDodjelu =Integer.parseInt((String) tabelaVoznji.getValueAt(idPozicijaVoznje, 0));
                    System.out.println(idPozicijaVoznje + "//" + idVoznjazaDodjelu);

                    int idPozicijaVozaca = tabelaVozaca.getSelectedRow();
                    int idVozacaZaDodjelu = Integer.parseInt((String) tabelaVozaca.getValueAt(idPozicijaVozaca, 0));
                    System.out.println(idPozicijaVozaca + "//" + idVozacaZaDodjelu);

                    Voznja dodjeljenaVoznja = null;

                    for (Voznja voznja: taxiSluzba.getListaVoznji()){
                        if (idVoznjazaDodjelu == voznja.getIdVoznje()){
                            dodjeljenaVoznja = voznja;
                        }
                    }

                    Vozac vozacKomeJeDodjeljeno = null;

                    for (Osoba osoba: taxiSluzba.getListaOsoba()){
                        if((idVozacaZaDodjelu == osoba.getIdKorisnika()) && (osoba instanceof Vozac)){
                            vozacKomeJeDodjeljeno = (Vozac) osoba;
                        }
                    }

                    dodjeljenaVoznja.setIdVozaca(vozacKomeJeDodjeljeno.getIdKorisnika());
                    dodjeljenaVoznja.setStatus(StatusVoznje.DODJELJENA);
                    vozacKomeJeDodjeljeno.getLisaVoznji().add(dodjeljenaVoznja);

                    System.out.println("VOŽNJA JE DODJELJENA VOZAČU");

                    osvjeziTabele(taxiSluzba);

                }
                catch (Exception exception) {
                    JOptionPane.showMessageDialog( new Frame(),
                            "Niste selektovali vožnju ili vozača!",
                            null,
                            JOptionPane.WARNING_MESSAGE);
                }

            }
        });

    }

    public  void osvjeziTabele(TaxiSluzba taxiSluzba){

        // Postavljanje informacija vožnji

        List<Voznja> listaKreiranihVoznji = new ArrayList<Voznja>();

        for (Voznja voznja: taxiSluzba.getListaVoznji()
             ) {
            if ((voznja instanceof VoznjaNarucenaTelefonom) && (voznja.getStatus() == StatusVoznje.KREIRANA)){
                listaKreiranihVoznji.add(voznja);
            }
        }

        int brojVoznji = listaKreiranihVoznji.size();
        String data[][] = new String[brojVoznji][11];

        int index = 0;
        for (Voznja voznja: listaKreiranihVoznji
        ) {
            data[index]= voznja.toStringArray();
            data[index][10] = "telefon";
            index++;
            System.out.println((voznja instanceof VoznjaNarucenaAplikacijom) + " / " + (voznja instanceof VoznjaNarucenaTelefonom));
        }

        String column[]={"ID","Mušterija ID","Vozač ID", "Adresa polaska", "Adresa destinacije", "Status", "Dužina (km)", "Trajanje (min)", "Cena (RSD)", "Datum i vreme", "Tip naručivanja"};
        tabelaVoznji.setModel(new DefaultTableModel(data, column));



        // Postavljanje informacija vozača

        List<Vozac> listaVozaca = new ArrayList<Vozac>();;
        for (Osoba osoba: taxiSluzba.getListaOsoba()){
            if(osoba instanceof Vozac){
                listaVozaca.add((Vozac) osoba);
                System.out.println(osoba.getUloga() + " " + osoba.getIme() + " AKTIVAN:" + osoba.isAktivan());
            }
        }

        int brojVozaca = listaVozaca.size();
        String dataV[][] = new String[brojVozaca][11];

        int indexV = 0;
        for (Vozac vozac: listaVozaca
        ) {
            if(vozac.isAktivan() && (vozac.getAutomobil().getAutomobilID() != 0)) {
                System.out.println(vozac.getIme());
                dataV[indexV] = vozac.toArrayString();
                indexV++;
            }
        }

        String columnV[]={"Vozač ID","Ime","Prezime", "Korisničko ime", "JMBG", "Adresa", "Pol", "Broj telefona", "Prosječna ocjena", "Plata", "Automobil"};

        tabelaVozaca.setModel(new DefaultTableModel(dataV, columnV));

        if (listaKreiranihVoznji.isEmpty()){
            JOptionPane.showMessageDialog( new Frame(),
                    "Nema vožnji koje čekaju da dodjelu!",
                    null,
                    JOptionPane.WARNING_MESSAGE);
        }
    }
}
