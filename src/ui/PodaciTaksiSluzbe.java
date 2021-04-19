package ui;

import javax.swing.*;
import java.io.*;

public class PodaciTaksiSluzbe extends JFrame
{
    private JPanel PodaciTaksiSluzbeFrame;
    private JLabel lblPIB;
    private JLabel lblNaziv;
    private JLabel lblAdresa;
    private JLabel lblCenaStarta;
    private JLabel lblCenaPoKilometru;
    private JTextField txtPIB;
    private JTextField txtNaziv;
    private JTextField txtAdresa;
    private JTextField txtCenaStarta;
    private JTextField txtCenaPoKilometru;
    private JButton btnIzmeni;

    public PodaciTaksiSluzbe()
    {
        add(PodaciTaksiSluzbeFrame);
        setTitle("Click&Go - Podaci o taksi sluzbi");
        setResizable(false);
        setSize(400,500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File("src/fajlovi/podaciOTaksiSluzbi.txt"))));
            String line = null;

            while((line = br.readLine()) != null){
                String[] split = line.split("\\|");
                txtPIB.setText(split[0].trim());
                txtNaziv.setText(split[1].trim());
                txtAdresa.setText(split[2].trim());
                txtCenaStarta.setText(split[3].trim());
                txtCenaPoKilometru.setText(split[4].trim());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
