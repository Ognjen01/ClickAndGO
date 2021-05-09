package ui;

import korisnici.Vozac;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class DodavanjeIzmenaAutomobila extends JFrame {
    private JPanel DodadavanjeAutomobilaFrame;
    private JLabel lblModel;
    private JLabel lblProizvodjac;
    private JLabel lblDatumRegistracije;
    private JLabel lblRegistarskaOznaka;
    private JLabel lblTipVozila;
    private JLabel lblVozac;
    private JTextField txtModel;
    private JTextField txtProizvodjac;
    private JComboBox cbVozac;
    private JComboBox cbTipVozila;
    private JTextField txtRegistarskaOznaka;
    private JButton btnDodaj;
    private JButton btnOdustani;

    private ArrayList<Vozac> listaVozaca;
    private String idVozaca;
    public int i;


    public DodavanjeIzmenaAutomobila() {

        // TODO: D0dati dugme za nazad

        add(DodadavanjeAutomobilaFrame);
        setTitle("Click&Go - Dodavanje automobila");
        setResizable(false);
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // TODO: !! Izmjeniti logiku pristupa fajlovima, ne pristupa se fajlovima nego listama !!

        listaVozaca = new ArrayList<Vozac>();

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File("src/fajlovi/korisnici.txt"))));
            String line = null;
            while ((line = br.readLine()) != null) {
                i++;
                String[] split = line.split("\\|");
                if (split[9].equals("vozac")) {
                    String vozac = split[1] + " " + split[2] + " " + "(ID: " + split[0] + ")";
                    cbVozac.addItem(new String(vozac));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        cbTipVozila.addItem(new String("auto"));
        cbTipVozila.addItem(new String("kombi"));

        btnDodaj.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                idVozaca = cbVozac.getSelectedItem().toString();
                idVozaca = idVozaca.replaceAll("\\D+", "");

                Random rand = new Random();
                int idVozila = rand.nextInt(100000);

                String automobil = idVozila + "|" + txtModel.getText() + "|" + txtProizvodjac.getText() + "|" + "DATUM REGISTRACIJE" + "|" + txtRegistarskaOznaka.getText() + "|" + cbTipVozila.getSelectedItem().toString() + "|" + idVozaca + "\n";

                int input = JOptionPane.showConfirmDialog(null,
                        "Zelite li potvrdite unos?", "Izaberite opciju...", JOptionPane.YES_NO_CANCEL_OPTION);

                if (input == 0) {
                    try {
                        Writer writer = new BufferedWriter(new FileWriter("src/fajlovi/automobili.txt", true));
                        writer.append(automobil);
                        writer.close();
                        JOptionPane.showMessageDialog(null,
                                "Uspešno ste dodali novo vozilo.");
                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }
                } else if (input == 1) {
                    JOptionPane.showMessageDialog(null,
                            "Odustali ste od unosa novog vozila.");
                }
            }
        });
    }
}
