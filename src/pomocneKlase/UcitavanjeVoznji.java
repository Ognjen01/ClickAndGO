package pomocneKlase;

import entiteti.Voznja;
import entiteti.VoznjaNarucenaAplikacijom;
import entiteti.VoznjaNarucenaTelefonom;
import enumeracije.StatusVoznje;
import korisnici.Musterija;
import korisnici.Vozac;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UcitavanjeVoznji {
    public List<Voznja> iteracijaKrozListuStringova(List<String[]> listaEntiteta) {
        List<Voznja> listaUcitanihVoznji = new ArrayList<Voznja>();


        for (String[] nizEntitetaVoznje : listaEntiteta
        ) {
            // Kreiranje Objekta voznje i dodavanje u listu
            Voznja novaVoznja = odluciKojuVoznjuUcitati(nizEntitetaVoznje);
            listaUcitanihVoznji.add(novaVoznja);
        }
        return listaUcitanihVoznji;
    }


    public Voznja odluciKojuVoznjuUcitati(String[] elementiVoznje) {

        //TODO: Potrebno definisati enum za status voznje prilikom ucitavanja

        Musterija musterija = new Musterija();
        Vozac vozac = new Vozac();
        Date datum = null;
        try {
            datum = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(elementiVoznje[9]);
        } catch (ParseException e) {
            e.printStackTrace();
        }


        int idVoznje = Integer.parseInt(elementiVoznje[0]);
        int idVozaca = Integer.parseInt(elementiVoznje[1]);
        int idMusterije = Integer.parseInt(elementiVoznje[2]);
        double duzina = Double.parseDouble(elementiVoznje[6]);
        double trajanje = Double.parseDouble(elementiVoznje[7]);
        int cenaVoznje = Integer.parseInt(elementiVoznje[8]);
        StatusVoznje statusVoznje = StatusVoznje.valueOf(elementiVoznje[5]);
        System.out.println(cenaVoznje);
        if (elementiVoznje[10].equals("telefon")) {

            VoznjaNarucenaTelefonom novaVoznjaTelefon = new VoznjaNarucenaTelefonom(
                    idVoznje,
                    idVozaca,
                    idMusterije,
                    elementiVoznje[3],
                    elementiVoznje[4],
                    statusVoznje,
                    duzina,
                    trajanje,
                    cenaVoznje,
                    datum, // Ovdje treba date time format
                    musterija,
                    vozac
            ); // Popuniti konstruktore
            return novaVoznjaTelefon;

        } else if (elementiVoznje[10].equals("aplikacija")) {

            VoznjaNarucenaAplikacijom novaVoznjaAplikacija = new VoznjaNarucenaAplikacijom(
                    idVoznje,
                    idVozaca,
                    idMusterije,
                    elementiVoznje[3],
                    elementiVoznje[4],
                    statusVoznje,
                    duzina,
                    trajanje,
                    cenaVoznje,
                    datum, // Ovdje treba date time format
                    musterija,
                    vozac
            ); // Popuniti konstruktore
            return novaVoznjaAplikacija;

        } else {
            System.out.println("Došlo je do greške prilikom učitavanja vožnji");
            return null;
        }
    }

}

// Prilikom prolaska kroz voznje i kreiranja njihovih objekata, možda kao ulaz u funkciju takođe uzeti
// listu onih vozača i dodijeliti im vožnje u njihovu listu vožnji
