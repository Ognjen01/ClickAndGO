package ui;

import entiteti.TaxiSluzba;
import entiteti.Voznja;
import enumeracije.StatusVoznje;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ZavrsavanjeVoznje extends JFrame{
    private JPanel panel1;
    private JTextField trajanjePolje;
    private JTextField duzinaPolje;
    private JButton zavrsiVoznjuBtn;

    public ZavrsavanjeVoznje(TaxiSluzba taxiSluzba, int idVoznje){

        setSize(800, 400);
        setTitle("Click&GO - Prihvatanje vožnji");
        setLocationRelativeTo(null);

        add(panel1);


        zavrsiVoznjuBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    double duzina = Double.parseDouble(duzinaPolje.getText());
                    double trajanje = Double.parseDouble(trajanjePolje.getText());

                    int cijena = (int) (taxiSluzba.getCijenaPoKilometru() * duzina + taxiSluzba.getCijenaStarta());

                    for (Voznja voznja : taxiSluzba.getListaVoznji()
                    ) {
                        if (voznja.getIdVoznje() == idVoznje) {
                            voznja.setStatus(StatusVoznje.ZAVRSENA);

                            voznja.setCenaVoznje(cijena);
                            voznja.setTrajanje((int) trajanje);
                            voznja.setDuzina((int) duzina);
                        }
                    }

                    JOptionPane.showMessageDialog(new Frame(),
                            "Cijena vožnje je: " + cijena + " RSD",
                            null,
                            JOptionPane.INFORMATION_MESSAGE);

                    setVisible(false);
                } catch (Exception exception){
                    JOptionPane.showMessageDialog(new Frame(),
                            "Greška prilikom završavanje vožnje",
                            "Greška",
                            JOptionPane.WARNING_MESSAGE);
                }

            }
        });



    }
}
