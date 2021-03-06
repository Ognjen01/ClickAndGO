package pomocneKlase;

import collections.list.DoublyLinkedList;
import entiteti.Automobil;
import korisnici.Osoba;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;


public class BrisanjeEntiteta {

    // Početni sistem za izmjenu atributa aktivnosti u listi objekata

    UpisivanjeUFajl upisivanjeUFajl;

    public BrisanjeEntiteta() {
        this.upisivanjeUFajl = new UpisivanjeUFajl();
    }

    public void obrisiKorisnika(DoublyLinkedList<Osoba> listaOsoba, int id) {
        for (Osoba osoba : listaOsoba) {
            if (osoba.getIdKorisnika() == id) {
                osoba.setAktivan(false);
            }
        }
    }

    public void obrisiAutomobil(DoublyLinkedList<Automobil> sviAutomobili, int idAutomobila) {
        DoublyLinkedList<Automobil> automobiliToSave = sviAutomobili;
        for (Automobil automobil : sviAutomobili) {
            if (automobil.getAutomobilID() == idAutomobila) {
                automobiliToSave.remove(automobil);
            }
        }

        File fajl = new File("src/fajlovi/automobili.txt");
        try {
            FileWriter fw = new FileWriter(fajl,false);
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.upisivanjeUFajl.upisiSveAutomobile(automobiliToSave);
    }
}
