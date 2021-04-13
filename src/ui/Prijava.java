package ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Prijava extends JFrame {

    //TODO: Postaviti slike logoa aplikacije i tima

    private JPanel prijava;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JButton prijaviSeButton;

    public Prijava() {

        add(prijava);
        setSize(800, 400);
        setTitle("Click&GO");

        prijaviSeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                KorisnickiEkran k = new KorisnickiEkran();
                prijava.setVisible(false);
                //add(k);
            }
        });
    }
}
