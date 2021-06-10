package ui;

import collections.list.DoublyLinkedList;
import entiteti.TaxiSluzba;
import entiteti.Voznja;
import entiteti.VoznjaNarucenaAplikacijom;
import entiteti.VoznjaNarucenaTelefonom;
import korisnici.Osoba;
import korisnici.Vozac;
import pomocneKlase.IzvestajVozacaPodaci;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class UnosVremenaZaIzvestaj extends JFrame{
    private JPanel panel1;
    private JComboBox daniComboBox;
    private JComboBox mjeseciComboBox;
    private JComboBox godineComboBox;
    private JRadioButton sedmicniIzvjestaj;
    private JButton kreirajIzvještajButton;
    private JButton odustaniBtn;

    public UnosVremenaZaIzvestaj(TaxiSluzba taxiSluzba ){
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
                    DoublyLinkedList<IzvestajVozacaPodaci> izvestajVozacaPodacis = new DoublyLinkedList<IzvestajVozacaPodaci>();
                    for (Osoba osoba: taxiSluzba.getListaOsoba()
                         ) {

                    if (osoba instanceof Vozac) {

                        double trajanje = 0;
                        double duzina = 0;
                        int ukupanBroj = 0;
                        int aplikacija = 0;
                        int telefon = 0;
                        int ukZarada = 0;
                        double prosTrajanje = 0;
                        double prosDuzina = 0;
                        double ukupnoKilometara = 0;
                        double ukupnoVremena = 0;
                        double prosecnaZarada = 0;
                        int brojPOgodaka = 0;

                        for (Voznja voznja : osoba.getLisaVoznji()
                        ) {

                            int godinaNadjeneNarudzbe = voznja.getVremeNarudzbine().getYear() + 1900;

                            if (godinaNadjeneNarudzbe == zahtjevanaGodina) {
                                System.out.println("Narudzbina jeste u trazenoj godini");

                                ukupanBroj++;

                                if (voznja instanceof VoznjaNarucenaTelefonom){
                                    telefon++;
                                } else if (voznja instanceof VoznjaNarucenaAplikacijom){
                                    aplikacija++;
                                }

                                trajanje += voznja.getTrajanje();
                                duzina += voznja.getDuzina();

                                ukZarada += voznja.getCenaVoznje();
                                ukupnoKilometara += voznja.getDuzina();
                                ukupnoVremena += voznja.getTrajanje();
                                brojPOgodaka += 1;
                            }

                        }
                        prosTrajanje = trajanje / brojPOgodaka;
                        prosDuzina = duzina / brojPOgodaka;
                        if (brojPOgodaka != 0) {
                            prosecnaZarada = ukZarada / brojPOgodaka;
                        }
                        IzvestajVozacaPodaci izvestajVozacaPodaci = new IzvestajVozacaPodaci(osoba.getIdKorisnika(),ukupanBroj,ukupnoKilometara,ukupnoVremena,prosDuzina,prosTrajanje,ukZarada,prosecnaZarada);
                        izvestajVozacaPodacis.add(izvestajVozacaPodaci);
                    }
                    }

                   IzvestajVozacaDispecer izvestajVozacaDispecer = new IzvestajVozacaDispecer(izvestajVozacaPodacis);
                    izvestajVozacaDispecer.setVisible(true);

                } else if (dan.equals("Nije odabrano") && !mjesec.equals("Nije odabrano")){

                    // Logika za mjesecni izvjestaj

                    int zahtjevaniMjesec = Integer.parseInt(mjesec);
                        DoublyLinkedList<IzvestajVozacaPodaci> izvestajVozacaPodacis = new DoublyLinkedList<IzvestajVozacaPodaci>();
                        for (Osoba osoba: taxiSluzba.getListaOsoba()
                        ) {

                            if (osoba instanceof Vozac) {

                                double trajanje = 0;
                                double duzina = 0;
                                int ukupanBroj = 0;
                                int aplikacija = 0;
                                int telefon = 0;
                                int ukZarada = 0;
                                double prosTrajanje = 0;
                                double prosDuzina = 0;
                                double ukupnoKilometara = 0;
                                double ukupnoVremena = 0;
                                double prosecnaZarada = 0;
                                int brojPOgodaka = 0;

                                for (Voznja voznja : osoba.getLisaVoznji()
                                ) {
                                    int mjesecVoznje = voznja.getVremeNarudzbine().getMonth() + 1;

                                    int godinaNadjeneNarudzbe = voznja.getVremeNarudzbine().getYear() + 1900;

                                    if (mjesecVoznje == zahtjevaniMjesec && zahtjevanaGodina == godinaNadjeneNarudzbe ) {
                                        System.out.println("Narudzbina jeste u trazenoj godini");

                                        ukupanBroj++;

                                        if (voznja instanceof VoznjaNarucenaTelefonom){
                                            telefon++;
                                        } else if (voznja instanceof VoznjaNarucenaAplikacijom){
                                            aplikacija++;
                                        }

                                        trajanje += voznja.getTrajanje();
                                        duzina += voznja.getDuzina();

                                        ukZarada += voznja.getCenaVoznje();
                                        ukupnoKilometara += voznja.getDuzina();
                                        ukupnoVremena += voznja.getTrajanje();
                                        brojPOgodaka += 1;
                                    }

                                }
                                prosTrajanje = trajanje / brojPOgodaka;
                                prosDuzina = duzina / brojPOgodaka;
                                if (brojPOgodaka != 0) {
                                    prosecnaZarada = ukZarada / brojPOgodaka;
                                }
                                IzvestajVozacaPodaci izvestajVozacaPodaci = new IzvestajVozacaPodaci(osoba.getIdKorisnika(),ukupanBroj,ukupnoKilometara,ukupnoVremena,prosDuzina,prosTrajanje,ukZarada,prosecnaZarada);
                                izvestajVozacaPodacis.add(izvestajVozacaPodaci);
                            }
                        }

                        IzvestajVozacaDispecer izvestajVozacaDispecer = new IzvestajVozacaDispecer(izvestajVozacaPodacis);
                        izvestajVozacaDispecer.setVisible(true);





                } else if(!dan.equals("Nije odabrano") && !mjesec.equals("Nije odabrano") && !sedmicniIzvjestaj.isSelected()){

                    // Logika za dnevni izvjestaj

                    DoublyLinkedList<IzvestajVozacaPodaci> izvestajVozacaPodacis = new DoublyLinkedList<IzvestajVozacaPodaci>();
                    for (Osoba osoba: taxiSluzba.getListaOsoba()
                    ) {

                        if (osoba instanceof Vozac) {

                            double trajanje = 0;
                            double duzina = 0;
                            int ukupanBroj = 0;
                            int aplikacija = 0;
                            int telefon = 0;
                            int ukZarada = 0;
                            double prosTrajanje = 0;
                            double prosDuzina = 0;
                            double ukupnoKilometara = 0;
                            double ukupnoVremena = 0;
                            double prosecnaZarada = 0;
                            int brojPOgodaka = 0;

                            for (Voznja voznja : osoba.getLisaVoznji()
                            ) {

                                DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                                String strDate = dateFormat.format(voznja.getVremeNarudzbine());
                                System.out.println(strDate + " / " + odabraniDatum);

                                if (strDate.equals(odabraniDatum) ) {
                                    System.out.println("Narudzbina jeste u trazenoj godini");

                                    ukupanBroj++;

                                    if (voznja instanceof VoznjaNarucenaTelefonom){
                                        telefon++;
                                    } else if (voznja instanceof VoznjaNarucenaAplikacijom){
                                        aplikacija++;
                                    }

                                    trajanje += voznja.getTrajanje();
                                    duzina += voznja.getDuzina();

                                    ukZarada += voznja.getCenaVoznje();
                                    ukupnoKilometara += voznja.getDuzina();
                                    ukupnoVremena += voznja.getTrajanje();
                                    brojPOgodaka += 1;
                                }

                            }
                            prosTrajanje = trajanje / brojPOgodaka;
                            prosDuzina = duzina / brojPOgodaka;
                            if (brojPOgodaka != 0) {
                                prosecnaZarada = ukZarada / brojPOgodaka;
                            }
                            IzvestajVozacaPodaci izvestajVozacaPodaci = new IzvestajVozacaPodaci(osoba.getIdKorisnika(),ukupanBroj,ukupnoKilometara,ukupnoVremena,prosDuzina,prosTrajanje,ukZarada,prosecnaZarada);
                            izvestajVozacaPodacis.add(izvestajVozacaPodaci);
                        }
                    }

                    IzvestajVozacaDispecer izvestajVozacaDispecer = new IzvestajVozacaDispecer(izvestajVozacaPodacis);
                    izvestajVozacaDispecer.setVisible(true);




                } else if(!dan.equals("Nije odabrano") && !mjesec.equals("Nije odabrano") && sedmicniIzvjestaj.isSelected()) {




                    DoublyLinkedList<IzvestajVozacaPodaci> izvestajVozacaPodacis = new DoublyLinkedList<IzvestajVozacaPodaci>();
                    for (Osoba osoba: taxiSluzba.getListaOsoba()
                    ) {

                        if (osoba instanceof Vozac) {

                            double trajanje = 0;
                            double duzina = 0;
                            int ukupanBroj = 0;
                            int aplikacija = 0;
                            int telefon = 0;
                            int ukZarada = 0;
                            double prosTrajanje = 0;
                            double prosDuzina = 0;
                            double ukupnoKilometara = 0;
                            double ukupnoVremena = 0;
                            double prosecnaZarada = 0;
                            int brojPOgodaka = 0;

                            for (Voznja voznja : osoba.getLisaVoznji()
                            ) {



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

                                if (voznja.getVremeNarudzbine().before(zaSedamDana.getTime()) && voznja.getVremeNarudzbine().after(date1 )) {
                                    System.out.println("Narudzbina jeste u trazenoj godini");

                                    ukupanBroj++;

                                    if (voznja instanceof VoznjaNarucenaTelefonom){
                                        telefon++;
                                    } else if (voznja instanceof VoznjaNarucenaAplikacijom){
                                        aplikacija++;
                                    }

                                    trajanje += voznja.getTrajanje();
                                    duzina += voznja.getDuzina();

                                    ukZarada += voznja.getCenaVoznje();
                                    ukupnoKilometara += voznja.getDuzina();
                                    ukupnoVremena += voznja.getTrajanje();
                                    brojPOgodaka += 1;
                                }

                            }
                            prosTrajanje = trajanje / brojPOgodaka;
                            prosDuzina = duzina / brojPOgodaka;
                            if (brojPOgodaka != 0) {
                                prosecnaZarada = ukZarada / brojPOgodaka;
                            }
                            IzvestajVozacaPodaci izvestajVozacaPodaci = new IzvestajVozacaPodaci(osoba.getIdKorisnika(),ukupanBroj,ukupnoKilometara,ukupnoVremena,prosDuzina,prosTrajanje,ukZarada,prosecnaZarada);
                            izvestajVozacaPodacis.add(izvestajVozacaPodaci);
                        }
                    }

                    IzvestajVozacaDispecer izvestajVozacaDispecer = new IzvestajVozacaDispecer(izvestajVozacaPodacis);
                    izvestajVozacaDispecer.setVisible(true);


                                    }
            }
        });
    }
}
