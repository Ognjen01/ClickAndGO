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

    public DoublyLinkedList<Ponuda> ucitajListuPonuda(List<String[]> listaPonuda){
        DoublyLinkedList<Ponuda> listPonuda = new DoublyLinkedList<Ponuda>();


        for (String[] ponuda : listaPonuda) {

            Ponuda ponuda1 = transformisiPonudu(ponuda);
            listPonuda.add(ponuda1);
        }

        return listPonuda;
    }

    private Ponuda transformisiPonudu(String[] ponudaString){
        Ponuda ponuda = new Ponuda(
                Integer.parseInt(ponudaString[0]),
                Integer.parseInt(ponudaString[1]),
                ponudaString[2],
                Double.parseDouble(ponudaString[3]),
                Integer.parseInt(ponudaString[4]),
                Integer.parseInt(ponudaString[5])
        );
        return ponuda;
    }

    public DoublyLinkedList<Aukcija> ucitajListuAukcija(DoublyLinkedList<Ponuda> listaPonuda){

        DoublyLinkedList<Aukcija> listaAukcija = new DoublyLinkedList<Aukcija>();

        for (Ponuda ponuda: listaPonuda
             ) {
            if (listaAukcija.isEmpty()){
                Aukcija aukcija = new Aukcija(ponuda.getIdVoznje(), null);
                listaAukcija.add(aukcija);
                System.out.println("DODATA PRVA AUKCIJA");
            } else {
                boolean postojiAukcijaZaPonudu = false;

                for (Aukcija aukcija : listaAukcija) {
                    if (ponuda.getIdVoznje() == aukcija.getIdVoznje()){
                        postojiAukcijaZaPonudu = true ;
                    }
                }

                if (!postojiAukcijaZaPonudu) {
                    Aukcija aukcija = new Aukcija(ponuda.getIdVoznje(), null);
                    listaAukcija.add(aukcija);
                }
            }
        }

        for (Ponuda ponuda: listaPonuda){
            for (Aukcija aukcija: listaAukcija){
                if(ponuda.getIdVoznje() == aukcija.getIdVoznje()){
                    aukcija.dodajPonuduUListu(ponuda);
                }
            }
        }


        return listaAukcija;
     }

    private void ubaciPonuduUAukciju(Aukcija aukcija, DoublyLinkedList<Ponuda> listaPonuda) {

        for (Ponuda ponuda: listaPonuda
             ) {
            if(ponuda.getIdVoznje() == aukcija.getIdVoznje()){
                aukcija.dodajPonuduUListu(ponuda);
            }
        }

    }

}
