package ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UnosInfoApliciranje extends JFrame{
    private JPanel panel1;
    private JTextField textField1;
    private JCheckBox petFredlyCheckBox;
    private JButton aplicirajButton;
    private JButton odustaniButton;

    public UnosInfoApliciranje(){
        setSize(500, 250);
        setTitle("Click&GO");
        setLocationRelativeTo(null);

        add(panel1);

        odustaniButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

    }
}
