package ui;

import entiteti.TaxiSluzba;
import entiteti.Voznja;
import korisnici.Osoba;
import korisnici.Vozac;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OcjenjivanjeVozaca extends JFrame {
    private JPanel panel1;
    private JTextField ocjenaPolje;
    private JButton ocjeniBtn;
    private JButton odustaniButton;

    public OcjenjivanjeVozaca(TaxiSluzba taxiSluzba, int idVozaca, int idVoznje){

        setSize(400, 200);
        setTitle("Click&GO - ocjenjivanje vožnje");
        setLocationRelativeTo(null);

        add(panel1);

        ocjeniBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int unesenaOcjena = Integer.parseInt(ocjenaPolje.getText());

                for (Osoba vozac: taxiSluzba.getListaOsoba()
                ) {
                    if (vozac instanceof Vozac){
                        if(vozac.getIdKorisnika() == idVozaca && idVozaca != 0){
                            ((Vozac) vozac).setProsjecnaOcjena(
                                    (((Vozac) vozac).getProsjecnaOcjena() + unesenaOcjena) / 2
                            );
                        }
                    }

                }

                for (Voznja voznja : taxiSluzba.getListaVoznji()) {
                    if(voznja.getIdVoznje() == idVoznje){
                        voznja.setOcjenjena(true);
                    }
                }

                JOptionPane.showMessageDialog(null, "Uspješno ste ocjenili vožnju.", "" , JOptionPane.INFORMATION_MESSAGE);
                setVisible(false);
            }
        });

        odustaniButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
    }
}
