package ui;

import javax.swing.*;

public class PorukaKorisniku extends JFrame{
    private JPanel panel1;
    private JLabel poruka;

    public PorukaKorisniku(String porukaKOrisniku){
        add(panel1);
        setSize(200, 200);
        setTitle("Poruka");
        setLocationRelativeTo(null);
        poruka.setText(porukaKOrisniku);
    }

}
