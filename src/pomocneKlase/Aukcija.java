package pomocneKlase;

import collections.list.DoublyLinkedList;
import entiteti.Voznja;

public class Aukcija {

    private int idVoznje;
    private DoublyLinkedList<Ponuda> ponudeZaVoznju = new DoublyLinkedList<Ponuda>();

    public Aukcija(int idVoznje, Ponuda ponuda){
        this.idVoznje = idVoznje;
    }

    public int getIdVoznje() {
        return idVoznje;
    }

    public void setIdVoznje(int idVoznje) {
        this.idVoznje = idVoznje;
    }


    public DoublyLinkedList<Ponuda> getPonudeZaVoznju() {
        return ponudeZaVoznju;
    }

    public void setPonudeZaVoznju(DoublyLinkedList<Ponuda> ponudeZaVoznju) {
        this.ponudeZaVoznju = ponudeZaVoznju;
    }

    public void dodajPonuduUListu(Ponuda ponuda){
        this.ponudeZaVoznju.add(ponuda);
    }


}
