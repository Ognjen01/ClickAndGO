package ui;

import entiteti.TaxiSluzba;
import entiteti.Voznja;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class IzvjestajVoznji extends JFrame {

    private JPanel panel1;
    private JComboBox daniComboBox;
    private JComboBox mjeseciComboBox;
    private JComboBox godineComboBox;
    private JRadioButton sedmicniIzvjestaj;
    private JButton kreirajIzvještajButton;
    private JButton odustaniBtn;

    public IzvjestajVoznji(TaxiSluzba taxiSluzba){
        setSize(600, 300);
        setTitle("Click&GO - Izvještaj vožnji");
        setLocationRelativeTo(null);

        add(panel1);

        // Popunjavanje dana
        daniComboBox.addItem("Nije odabrano");
        for (int i = 1; i <= 31; i++){
            if (i < 10){
                String dan1 = "0" + i;
                daniComboBox.addItem(dan1);
            } else {
                daniComboBox.addItem(String.valueOf(i));
            }
        }

        //Popunjavanje mjeseci
        mjeseciComboBox.addItem("Nije odabrano");
        for (int i = 1; i <= 12; i++){
            if(i < 10){
                String mjesec = "0" + i;
                mjeseciComboBox.addItem(mjesec);
            } else {
                mjeseciComboBox.addItem(String.valueOf(i));
            }
        }


        //Popunjavanje godina
        int trenutnaGodina = Calendar.getInstance().get(Calendar.YEAR);
        System.out.println("TRENUTNA GODINA: " + trenutnaGodina);

        for (int i = 2018; i <= trenutnaGodina; i++){
            godineComboBox.addItem(String.valueOf(i));
        }


        kreirajIzvještajButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String dan = (String) daniComboBox.getSelectedItem();
                String mjesec = (String) mjeseciComboBox.getSelectedItem();
                String godine = (String) godineComboBox.getSelectedItem();

                System.out.println("ODABRANI DATUM: " + dan + "/" + mjesec + "/" + godine);

                String odabraniDatum = dan + "/" + mjesec + "/" + godine;

                // TODO: Logika za izvještaje:

                if (dan.equals("Nije odabrano") && mjesec.equals("Nije odabrano")){

                    // Logika izvjestaja godisnjeg
                    int zahtjevanaGodina = Integer.parseInt(godine);
                    List<Voznja> listaOdgovarajucihVoznji = new ArrayList<Voznja>();

                    for (Voznja voznja: taxiSluzba.getListaVoznji()
                        ) {

                        int godinaNadjeneNarudzbe = voznja.getVremeNarudzbine().getYear() + 1900;
                        if (godinaNadjeneNarudzbe == zahtjevanaGodina) {
                            System.out.println("Narudzbina jeste u trazenoj godini");
                            listaOdgovarajucihVoznji.add(voznja);
                        }
                    }

                } else if (dan.equals("Nije odabrano") && !mjesec.equals("Nije odabrano")){

                    // Logika za mjesecni izvjestaj

                } else if(!dan.equals("Nije odabrano") && !mjesec.equals("Nije odabrano") && !sedmicniIzvjestaj.isSelected()){

                    // Logika za dnevni izvjestaj

                } else if(!dan.equals("Nije odabrano") && !mjesec.equals("Nije odabrano") && sedmicniIzvjestaj.isSelected()) {

                    // Logika za sedmicni izvjestaj

                }

            }
        });


        odustaniBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
    }
}
