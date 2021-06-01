package pomocneKlase;

import collections.list.DoublyLinkedList;
import entiteti.Voznja;
import entiteti.VoznjaNarucenaAplikacijom;
import entiteti.VoznjaNarucenaTelefonom;
import enumeracije.StatusVoznje;
import korisnici.Musterija;
import korisnici.Osoba;
import korisnici.Vozac;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UcitavanjeVoznji {
    public DoublyLinkedList<Voznja> iteracijaKrozListuStringova(List<String[]> listaEntiteta) { // TODO: DoublyLinkedList
        DoublyLinkedList<Voznja> listaUcitanihVoznji = new DoublyLinkedList<Voznja>();


        for (String[] nizEntitetaVoznje : listaEntiteta
        ) {
            // Kreiranje Objekta voznje i dodavanje u listu
            Voznja novaVoznja = odluciKojuVoznjuUcitati(nizEntitetaVoznje);
            listaUcitanihVoznji.add(novaVoznja);
        }

        for (int i = 0; i < listaUcitanihVoznji.size(); i++){
            for (int j = 0; j < listaUcitanihVoznji.size(); j++){

                if(listaUcitanihVoznji.getElement(i).getIdVoznje() < listaUcitanihVoznji.getElement(j).getIdVoznje()){
                    Voznja prenos = listaUcitanihVoznji.getElement(i);
                    listaUcitanihVoznji.set(i, listaUcitanihVoznji.getElement(j));
                    listaUcitanihVoznji.set(j, prenos);
                }
            }
        }

        return listaUcitanihVoznji;
    }


    public Voznja odluciKojuVoznjuUcitati(String[] elementiVoznje) {

        Musterija musterija = new Musterija();
        Vozac vozac = new Vozac();
        Date datum = null;
        try{
            datum = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(elementiVoznje[9]);
        } catch (ParseException e){
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
                    datum,
                    musterija,
                    vozac
            );
            return novaVoznjaTelefon;

        } else if (elementiVoznje[10].equals("aplikacija")) {

            boolean petFriendly = Boolean.valueOf(elementiVoznje[11]);
            String napomena = elementiVoznje[12];


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
                    datum,
                    musterija,
                    vozac,
                    petFriendly,
                    napomena
            ); // Popuniti konstruktore
            return novaVoznjaAplikacija;

        } else {
            System.out.println("Došlo je do greške prilikom učitavanja vožnji");
            return null;
        }
    }

}
