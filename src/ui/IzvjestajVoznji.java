package ui;

import entiteti.TaxiSluzba;
import entiteti.Voznja;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
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
                int zahtjevanaGodina = Integer.parseInt(godine);

                String odabraniDatum = dan + "/" + mjesec + "/" + godine;


                // Logika za izvještaje:

                if (dan.equals("Nije odabrano") && mjesec.equals("Nije odabrano")){

                    // Logika izvjestaja godisnjeg

                    List<Voznja> listaOdgovarajucihVoznji = new ArrayList<Voznja>();

                    for (Voznja voznja: taxiSluzba.getListaVoznji()
                        ) {

                        int godinaNadjeneNarudzbe = voznja.getVremeNarudzbine().getYear() + 1900;
                        if (godinaNadjeneNarudzbe == zahtjevanaGodina) {
                            System.out.println("Narudzbina jeste u trazenoj godini");
                            listaOdgovarajucihVoznji.add(voznja);
                        }
                    }

                    RezultatiIzvjestajaVoznji rezultati = new RezultatiIzvjestajaVoznji(listaOdgovarajucihVoznji);
                    rezultati.setVisible(true);

                } else if (dan.equals("Nije odabrano") && !mjesec.equals("Nije odabrano")){

                    // Logika za mjesecni izvjestaj

                    List<Voznja> listaOdgovarajucihVoznji = new ArrayList<Voznja>();
                    int zahtjevaniMjesec = Integer.parseInt(mjesec);

                    for (Voznja voznja: taxiSluzba.getListaVoznji()
                         ) {
                        int godinaNadjeneNarudzbe = voznja.getVremeNarudzbine().getYear() + 1900;
                        int mjesecVoznje = voznja.getVremeNarudzbine().getMonth() + 1;

                        if (mjesecVoznje == zahtjevaniMjesec && zahtjevanaGodina == godinaNadjeneNarudzbe){
                            listaOdgovarajucihVoznji.add(voznja);
                        }
                    }

                    RezultatiIzvjestajaVoznji rezultati = new RezultatiIzvjestajaVoznji(listaOdgovarajucihVoznji);
                    rezultati.setVisible(true);

                } else if(!dan.equals("Nije odabrano") && !mjesec.equals("Nije odabrano") && !sedmicniIzvjestaj.isSelected()){

                    // Logika za dnevni izvjestaj

                    List<Voznja> listaOdgovarajucihVoznji = new ArrayList<Voznja>();

                    for (Voznja voznja: taxiSluzba.getListaVoznji()
                    ) {

                        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                        String strDate = dateFormat.format(voznja.getVremeNarudzbine());
                        System.out.println(strDate + " / " + odabraniDatum);

                        if (strDate.equals(odabraniDatum)){
                            System.out.println("Voznja se desila trazenog datuma");
                            listaOdgovarajucihVoznji.add(voznja);
                        }
                    }

                    RezultatiIzvjestajaVoznji rezultati = new RezultatiIzvjestajaVoznji(listaOdgovarajucihVoznji);
                    rezultati.setVisible(true);

                } else if(!dan.equals("Nije odabrano") && !mjesec.equals("Nije odabrano") && sedmicniIzvjestaj.isSelected()) {

                    // Logika za sedmicni izvjestaj

                    List<Voznja> listaOdgovarajucihVoznji = new ArrayList<Voznja>();

                    Date date1= null;
                    try {
                        date1 = new SimpleDateFormat("dd/MM/yyyy").parse(odabraniDatum);
                    } catch (ParseException parseException) {
                        parseException.printStackTrace();
                    }

                    Calendar zaSedamDana = Calendar.getInstance();
                    zaSedamDana.setTime(date1);
                    zaSedamDana.add(Calendar.DAY_OF_MONTH, 7);

                    System.out.println(date1 + "/" + zaSedamDana.getTime());

                    for (Voznja voznja: taxiSluzba.getListaVoznji()
                         ) {
                        if(voznja.getVremeNarudzbine().before(zaSedamDana.getTime()) && voznja.getVremeNarudzbine().after(date1)){
                            listaOdgovarajucihVoznji.add(voznja);
                            System.out.println("Voznja pripada odgovarajucem intervalu!");
                        }
                    }

                    RezultatiIzvjestajaVoznji rezultati = new RezultatiIzvjestajaVoznji(listaOdgovarajucihVoznji);
                    rezultati.setVisible(true);
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
