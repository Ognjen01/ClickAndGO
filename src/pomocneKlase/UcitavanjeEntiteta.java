package pomocneKlase;

import collections.list.DoublyLinkedList;
import entiteti.Automobil;
import enumeracije.TipVozila;
import korisnici.Osoba;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UcitavanjeEntiteta {

    // UČITAVANJE AUTOMOBILA

    public DoublyLinkedList<Automobil> ucitajListuAutomobila(List<String[]> nizAutomobila) { // TODO: DoublyLinkedList

        DoublyLinkedList<Automobil> listaAutomobila = new DoublyLinkedList<Automobil>();

        for (String[] automobil : nizAutomobila) {

            Automobil automobil1 = transformisiAutomobil(automobil);
            listaAutomobila.add(automobil1);
        }

        for (int i = 0; i < listaAutomobila.size(); i++){
            for (int j = 0; j < listaAutomobila.size(); j++){

                if(listaAutomobila.getElement(i).getAutomobilID() < listaAutomobila.getElement(j).getAutomobilID()){
                    Automobil automobil = listaAutomobila.getElement(i);
                    listaAutomobila.set(i, listaAutomobila.getElement(j));
                    listaAutomobila.set(j, automobil);
                }
            }
        }


        return listaAutomobila;

    }

    private Automobil transformisiAutomobil(String[] automobil) {

        TipVozila tipVozila = TipVozila.valueOf(automobil[6]);


        Date datumRegistracije = null;
        try {
            datumRegistracije = new SimpleDateFormat("yyyy-MM-dd").parse(automobil[4]);
        } catch (ParseException e) {
            System.out.println("Došlo je do greške prilikom konverzije datuma");
        }
        int idAutomobila = Integer.parseInt(automobil[0]);
        int brojVozila = Integer.parseInt(automobil[1]);
        int idVozaca = Integer.parseInt(automobil[7]);

        Automobil auto = new Automobil(
                idAutomobila,
                brojVozila,
                automobil[2],
                automobil[3],
                datumRegistracije,
                automobil[5],
                tipVozila,
                idVozaca
        );

        return auto;
    }

}
