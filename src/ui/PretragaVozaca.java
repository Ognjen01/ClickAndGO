package ui;

import entiteti.Automobil;
import entiteti.TaxiSluzba;
import entiteti.Voznja;
import korisnici.Osoba;
import korisnici.Vozac;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class PretragaVozaca extends JFrame {
    private JPanel osnovniPanel;
    private JPanel panelPolja;
    private JPanel panelTabele;
    private JTextField imePolje;
    private JScrollPane sp;
    private JTable tabelaRezultatiPretrage;
    private JTextField prezimePolje;
    private JTextField plataPolje;
    private JComboBox comboAutomobili;
    private JButton pretraziBtn;
    private JButton odustaniButton;

    public PretragaVozaca(TaxiSluzba taxiSluzba) {
        setSize(800, 400);
        setTitle("Click&GO");
        setLocationRelativeTo(null);

        add(osnovniPanel);

        // Prosleđuju se samo automobili koji su dodjeljeni jer po onima koji nisu nije moguća pretraga

        comboAutomobili.addItem(new String("Nije odabran automobil"));
        for (Automobil automobil : taxiSluzba.getListaAutomovila()) {
            if (automobil.getIdVozaca() != 0) {
                comboAutomobili.addItem(new String(automobil.getModel() + " (ID " + automobil.getAutomobilID() + ")"));
            }
        }

        odustaniButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        pretraziBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // TODO: 1. Preuzimanje vrijednosti iz polje
                //       2. Slektovanje vrijednosti iz lista koje imaju autribute iz polja
                //       3. Prosleđivanje takve liste vozača u tabelu
                //       4. Ako ne postoji ni jedan vozač prikazati dijalog upozorenja

                boolean plataDobarUnos = true;

                try{
                    String ime = imePolje.getText();
                    String prezime = prezimePolje.getText();
                    String plata = plataPolje.getText();
                    String auto = comboAutomobili.getSelectedItem().toString();

                    // Porediti kao ime.equals("")

                    List<Vozac> litsaNajdenihVozaca = new ArrayList<Vozac>();

                    for (Osoba nadjeniVozac: taxiSluzba.getListaOsoba()
                         ) {
                        if (nadjeniVozac instanceof Vozac){

                            // Preuzimanje automobila
                            Vozac nadjeniVozac1 = (Vozac)nadjeniVozac;
                            System.out.println(nadjeniVozac1.getIme() + " " + nadjeniVozac1.getPlata() + " " + nadjeniVozac1.getPrezime() + " " + nadjeniVozac1.getAutomobil().getModel() + " " + nadjeniVozac1.getAutomobil().getAutomobilID());

                            String automobilNadjenogVozaca = "";

                            if(nadjeniVozac1.getAutomobil().getModel() == null){
                                System.out.println("Vozac nema auto");
                            } else {
                                automobilNadjenogVozaca = nadjeniVozac1.getAutomobil().getModel() + " (ID " + nadjeniVozac1.getAutomobil().getAutomobilID() + ")";
                                System.out.println(automobilNadjenogVozaca);
                            }

                            // Parsiranje plate i odlučivanje da li format dobar
                            // Ako format nije dobar izbacuje se dijalog prozor kao upozorenje

                            int plataInt = 0;
                            try {
                                plataInt = Integer.parseInt(plata); // greska zbog praznog polja
                            } catch (Exception e2) {
                                System.out.println("Pogrešan unos u polju plata ili prazno polje");
                                plataDobarUnos = false;
                                if(plata.equals("")){
                                    plataDobarUnos = true;
                                }
                            }


                            if ((ime.equals("") || ime.equals(nadjeniVozac.getIme())) &&
                                    (prezime.equals("") || prezime.equals(nadjeniVozac.getPrezime())) &&
                                    (plata.equals("") || plataInt == nadjeniVozac1.getPlata()) &&
                                    (auto.equals("Nije odabran automobil") || auto.equals(automobilNadjenogVozaca))
                                    ){

                                System.out.println("Nađen je vozač " + nadjeniVozac.getIme() + " " + nadjeniVozac.getIdKorisnika() +"\n");
                                litsaNajdenihVozaca.add(nadjeniVozac1);
                                System.out.println("\n \n Vozač " +  nadjeniVozac1.getIme() + " je dodat u listu \n \n");
                            }
                        }


                        int brojVozaca = litsaNajdenihVozaca.size();
                        String data[][] = new String[brojVozaca][11];

                        int index= 0;
                        for (Vozac vozac: litsaNajdenihVozaca
                        ) {
                            if(vozac.isAktivan()) {
                                data[index] = vozac.toArrayString();
                                index++;
                            }
                        }



                        String column[]={"Vozač ID","Ime","Prezime", "Korisničko ime", "JMBG", "Adresa", "Pol", "Broj telefona", "Prosječna ocjena", "Plata", "Automobil"};

                        tabelaRezultatiPretrage.setModel(new DefaultTableModel(data, column));
                        tabelaRezultatiPretrage.setAutoCreateRowSorter(true);
                    }

                    if(litsaNajdenihVozaca.isEmpty()){
                        JOptionPane.showMessageDialog( new Frame(),
                                "Ne postoji niti jedan rezultat pretrage!",
                                null,
                                JOptionPane.WARNING_MESSAGE);
                    }


                } catch (Exception e1){
                    System.out.println("Ne mogu se prihvatiti vrijednosti " + e1 + " " + e1.getMessage());
                }

                if (!plataDobarUnos){
                    JOptionPane.showMessageDialog( new Frame(),
                            "Niste unijeli plavilan format plate u polje plate! Molimo pokušajte ponovo!",
                            "Greška",
                            JOptionPane.WARNING_MESSAGE);
                }

            }
        });

    }
}
