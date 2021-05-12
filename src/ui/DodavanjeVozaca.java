package ui;

import entiteti.Automobil;
import entiteti.TaxiSluzba;
import enumeracije.Pol;
import korisnici.Osoba;
import korisnici.Vozac;

import javax.swing.*;
import javax.swing.text.TabableView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DodavanjeVozaca extends JFrame {

    private JPanel osnovniPanel;
    private JTextField imeVozacaPolje;
    private JTextField prezimeVozacaPolje;
    private JTextField korisnickoImeVozacaPolje;
    private JTextField lozinkaVozacaPolje;
    private JTextField jmbgVozacaPolje;
    private JTextField adresaVozacaPolje;
    private JRadioButton zenskiRadioButton;
    private JRadioButton muskiRadioButton;
    private JTextField brojTelefonaVozaca;
    private JTextField plataVozacaPolje;
    private JComboBox comboBox1;
    protected JButton dodajVozacaButton;
    protected JButton odustaniButton;
    private JTextField brojClanskeKartePolje;

    public DodavanjeVozaca(TaxiSluzba taxiSluzba){

        //TODO: DOODAVANJE DJELIMIČNO GOTOVO, DORADITI AUTOMOBIL
        //      SETOVATI SLOBONDNE AUTMOBILE U DROP DOWN MENI camboBox1

        setSize(500, 500);
        setTitle("Click&GO");
        add(osnovniPanel);

        ButtonGroup group = new ButtonGroup();
        group.add(zenskiRadioButton);
        group.add(muskiRadioButton);


        dodajVozacaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Vozac noviVozac = kreirajVozaca(taxiSluzba);
                taxiSluzba.getListaOsoba().add(noviVozac);

                System.out.println("vozac je dodat");
            }
        });
    }

    public Vozac kreirajVozaca (TaxiSluzba taxiSluzba){
        Vozac dodatiVozac = null;
        try {
            Automobil automobilVozaca = null;
            Pol pol;
            char polC = 'm';

            String imeVozaca = imeVozacaPolje.getText();
            String prezimeVozaca = prezimeVozacaPolje.getText();
            String korisnickoIme = korisnickoImeVozacaPolje.getText();
            String lozinkaVozaca = lozinkaVozacaPolje.getText();
            String jmbgVozaca = jmbgVozacaPolje.getText();
            String adresaVozaca = adresaVozacaPolje.getText();

            // dodati enum
            if(muskiRadioButton.isSelected()){
                pol = Pol.MUSKI;
                polC = 'm';
            } else if (zenskiRadioButton.isSelected()){
                pol = Pol.ZENSKI;
                polC = 'z';
            } else {
                System.out.println("Niste odabrali pol");
            }

            String brTelefonaVozaca = brojTelefonaVozaca.getText();
            int plata = Integer.parseInt(plataVozacaPolje.getText());
            int brojClanskeKarte = Integer.parseInt(brojClanskeKartePolje.getText());
            // Za aktivnost proslijediti true u konstruktor, uloga vozac, prosjecna ocjena nula

            int id  = generisanjeIdVozaca(taxiSluzba);

            dodatiVozac = new Vozac(id,imeVozaca, prezimeVozaca, korisnickoIme, lozinkaVozaca, jmbgVozaca, adresaVozaca, polC, brTelefonaVozaca,"vozac",true,plata,brojClanskeKarte,automobilVozaca,null,0.0);

        } catch (Exception e) {
            System.out.println("Neko od polja nije popunjeno molimo pokusajte ponovo");
        }

        return dodatiVozac;
    }

    public int generisanjeIdVozaca(TaxiSluzba taxiSluzba){
        int id = 0;
        for (Osoba vozac: taxiSluzba.getListaOsoba()
             ) {
            int idVozaca = vozac.getIdKorisnika();
            if (idVozaca > id && vozac instanceof Vozac) {
                id = idVozaca + 1;
            }
        }
        return id;
    }
}
