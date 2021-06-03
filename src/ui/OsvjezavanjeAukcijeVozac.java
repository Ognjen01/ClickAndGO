package ui;

import entiteti.TaxiSluzba;
import entiteti.Voznja;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OsvjezavanjeAukcijeVozac extends JFrame {

    private JPanel panel1;
    private JLabel poruka;
    private JButton osvjeziBtn;

    public OsvjezavanjeAukcijeVozac(TaxiSluzba taxiSluzba, int idVozaca, int idVoznje){

        setSize(500, 250);
        setTitle("Click&GO - Rezultati aukcije");
        setLocationRelativeTo(null);
        add(panel1);
        poruka.setText("Još uvijek nema rezultat aukcije, molimo osvježavajte rezultate redovno!");

        osvjeziBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                osvjeziRezultate(taxiSluzba, idVozaca, idVoznje);
            }
        });

    }

    public void osvjeziRezultate(TaxiSluzba taxiSluzba, int idVozaca, int idVoznje){
        int statusAukcije = 0;
        for (Voznja voznja: taxiSluzba.getListaVoznji()){
            if (voznja.getIdVoznje() == idVoznje) {
                if (voznja.getIdVozaca() == idVozaca) {
                    statusAukcije = 1;
                } else if (voznja.getIdVozaca() == 0) {
                    statusAukcije = 2;
                } else if (voznja.getIdVozaca() != 0) {
                    statusAukcije = 3;
                }
            }
        }

        if(statusAukcije == 1){
            System.out.println("ČESTITAMO OSVOJILI STE VOŽNJU, VOZAČ: " + idVozaca);

            setVisible(false);
            ZavrsavanjeVoznje zavrsavanjeVoznje = new ZavrsavanjeVoznje(taxiSluzba,idVoznje);
            zavrsavanjeVoznje.setVisible(true);


        } else  if (statusAukcije == 2){

            System.out.println("VOŽNJA JOŠ UVIJEK NIJE DODJLJENA, VOZAČ: " + idVozaca);
            setVisible(false);
            OsvjezavanjeAukcijeVozac osvjezavanjeAukcijeVozac = new OsvjezavanjeAukcijeVozac(taxiSluzba, idVozaca, idVoznje);
            osvjezavanjeAukcijeVozac.setVisible(true);

        } else if (statusAukcije == 3){
            System.out.println("NA ŽALOST NISTE DOBILI VOŽNJU, VIŠE SREĆE DRUGI PUT! VOZAČ:" + idVozaca);

            setVisible(false);

            JOptionPane.showMessageDialog( new Frame(),
                    "Na žalost niste osvojili aukciju, više srece drugi put.",
                    "",
                    JOptionPane.WARNING_MESSAGE);
        }




    }
}
