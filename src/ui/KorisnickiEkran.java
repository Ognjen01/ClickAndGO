package ui;
import java.awt.*;
import javax.swing.*;

public class KorisnickiEkran extends JPanel{

    private JPanel panel1;
    private JPanel panel2;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JPanel panel;

    public KorisnickiEkran(){
        panel1.setSize(100, 200);
        panel.setLayout(new GridLayout(1, 2));
        panel.add(panel1);
        panel.add(panel2);
        add(panel);
        setSize(400, 200);

    }




}
