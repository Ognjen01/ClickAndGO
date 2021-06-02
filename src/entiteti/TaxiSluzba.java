package entiteti;

import collections.list.DoublyLinkedList;
import korisnici.Osoba;
import pomocneKlase.Aukcija;
import pomocneKlase.CitanjeFajla;

import java.util.List;

public class TaxiSluzba {

    private String naziv;
    private int pib;
    private String adresa;
    private int cijenaStarta;
    private int cijenaPoKilometru;
    private DoublyLinkedList<Osoba> listaOsoba ;
    private DoublyLinkedList<Automobil> listaAutomobila;
    private DoublyLinkedList<Voznja> listaVoznji;
    private DoublyLinkedList<Aukcija> listaAukcija;


    public TaxiSluzba(
            DoublyLinkedList<Osoba> listaOsoba, // TODO: DoublyLinkedList
            DoublyLinkedList<Automobil> listaAutomobila,// TODO: DoublyLinkedList
            DoublyLinkedList<Voznja> listaVoznji// TODO: DoublyLinkedList
    ){
        this.listaAutomobila = listaAutomobila;
        this.listaOsoba = listaOsoba;
        this.listaVoznji = listaVoznji;

        // Dio za učitavanje informacija o taksi službi iz fajla

        CitanjeFajla citanjeFajla = new CitanjeFajla();
        List<String[]> poljaTaxiSluzbe = citanjeFajla.procitajFajl("podaciOTaksiSluzbi.txt");
        String[] taxiSluzba = poljaTaxiSluzbe.get(0);

        int pib = Integer.parseInt(taxiSluzba[0]);
        String naziv = taxiSluzba[1];
        String adresa = taxiSluzba[2];
        int cijenaStarta = Integer.parseInt(taxiSluzba[3]);
        int cijenaPoKilometru = Integer.parseInt(taxiSluzba[4]);

        this.naziv = naziv;
        this.pib = pib;
        this.adresa = adresa;
        this.cijenaPoKilometru = cijenaPoKilometru;
        this.cijenaStarta = cijenaStarta;


    }


    // Geteri i seteri za entitet TaxiSluzba

    public DoublyLinkedList<Aukcija> getListaAukcija() {
        return listaAukcija;
    }

    public void setListaAukcija(DoublyLinkedList<Aukcija> listaAukcija) {
        this.listaAukcija = listaAukcija;
    }

    public int getCijenaPoKilometru() {
        return cijenaPoKilometru;
    }

    public int getCijenaStarta() {
        return cijenaStarta;
    }

    public int getPib() {
        return pib;
    }

    public String getAdresa() {
        return adresa;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public void setCijenaPoKilometru(int cijenaPoKilometru) {
        this.cijenaPoKilometru = cijenaPoKilometru;
    }

    public void setCijenaStarta(int cijenaStarta) {
        this.cijenaStarta = cijenaStarta;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public void setPib(int pib) {
        this.pib = pib;
    }

    public DoublyLinkedList<Automobil> getListaAutomovila() {
        return listaAutomobila;
    } // TODO: DoublyLinkedList

    public DoublyLinkedList<Osoba> getListaOsoba() {
        return listaOsoba;
    }// TODO: DoublyLinkedList

    public DoublyLinkedList<Voznja> getListaVoznji() {
        return listaVoznji;
    }// TODO: DoublyLinkedList

    public void setListaAutomovila(DoublyLinkedList<Automobil> listaAutomovila) {
        this.listaAutomobila = listaAutomovila;
    }

    public void setListaOsoba(DoublyLinkedList<Osoba> listaOsoba) {
        this.listaOsoba = listaOsoba;
    }

    public void setListaVoznji(DoublyLinkedList<Voznja> listaVoznji) {
        this.listaVoznji = listaVoznji;
    }
}
