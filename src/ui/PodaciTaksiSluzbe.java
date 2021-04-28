package ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class PodaciTaksiSluzbe extends JFrame {
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

    private int counter;

    public void CitanjePodatakaOTaksiSluzbi() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File("src/fajlovi/podaciOTaksiSluzbi.txt"))));
            String line = null;

            while ((line = br.readLine()) != null) {
                String[] split = line.split("\\|");
                txtPIB.setText(split[0].trim());
                txtNaziv.setText(split[1].trim());
                txtAdresa.setText(split[2].trim());
                txtCenaStarta.setText(split[3].trim());
                txtCenaPoKilometru.setText(split[4].trim());

                txtPIB.setEditable(false);
                txtNaziv.setEditable(false);
                txtAdresa.setEditable(false);
                txtCenaStarta.setEditable(false);
                txtCenaPoKilometru.setEditable(false);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public PodaciTaksiSluzbe() {
        add(PodaciTaksiSluzbeFrame);
        setTitle("Click&Go - Podaci o taksi sluzbi");
        setResizable(false);
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        counter = 1;
        CitanjePodatakaOTaksiSluzbi();

        btnIzmeni.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                counter++;
                if (counter % 2 == 0) {
                    txtPIB.setEditable(true);
                    txtNaziv.setEditable(true);
                    txtAdresa.setEditable(true);
                    txtCenaStarta.setEditable(true);
                    txtCenaPoKilometru.setEditable(true);
                } else {
                    txtPIB.setEditable(false);
                    txtNaziv.setEditable(false);
                    txtAdresa.setEditable(false);
                    txtCenaStarta.setEditable(false);
                    txtCenaPoKilometru.setEditable(false);
                    int input = JOptionPane.showConfirmDialog(null,
                            "Zelite li da nastavite?", "Izaberite opciju...", JOptionPane.YES_NO_CANCEL_OPTION);

                    if (input == 0) {
                        try {
                            String pib = txtPIB.getText();
                            String naziv = txtNaziv.getText();
                            String adresa = txtAdresa.getText();
                            String cenaStarta = txtCenaStarta.getText();
                            String cenaPoKilometru = txtCenaPoKilometru.getText();

                            String izmene = pib + "|" + naziv + "|" + adresa + "|" + cenaStarta + "|" + cenaPoKilometru;

                            Files.write(Paths.get("src/fajlovi/podaciOTaksiSluzbi.txt"), izmene.getBytes(StandardCharsets.UTF_8), StandardOpenOption.WRITE);

                            JOptionPane.showMessageDialog(null,
                                    "Uspešno ste izmenili podatke o taksi službi.");

                        } catch (Exception exception) {
                            exception.printStackTrace();
                        }
                    } else if (input == 1) {
                        JOptionPane.showMessageDialog(null,
                                "Odustali ste od izmene podataka taksi službe.");
                        CitanjePodatakaOTaksiSluzbi();
                    }
                }
            }
        });
    }
}
