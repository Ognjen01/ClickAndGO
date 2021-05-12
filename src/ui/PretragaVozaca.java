package ui;

import entiteti.TaxiSluzba;

import javax.swing.*;

public class PretragaVozaca extends JFrame {
    private JPanel osnovniPanel;
    private JPanel panelPolja;
    private JPanel panelTabele;
    private JTextField imePolje;
    private JScrollPane sp;
    private JTable tabelaRezultatiPretrage;
    private JTextField textField1;
    private JTextField textField2;
    private JComboBox comboAutomobili;
    private JButton pretraziBtn;
    private JButton odustaniButton;

    public PretragaVozaca(TaxiSluzba taxiSluzba) {
        setSize(800, 400);
        setTitle("Click&GO");
        setLocationRelativeTo(null);

        add(osnovniPanel);

    }
}
