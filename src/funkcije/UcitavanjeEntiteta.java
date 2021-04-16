package funkcije;

import entiteti.Automobil;
import entiteti.Voznja;
import korisnici.Dispecer;
import korisnici.Musterija;
import korisnici.Vozac;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class UcitavanjeEntiteta {

    // TODO: Definisati da li će povratni tipovi biti List ili ArrayList
    //      Preispitati da li je ova forma uopšte potrebna

    public ArrayList<Vozac> ucitajVozace(){
        ArrayList<Vozac> vozaci = null;
        return vozaci;
    }

    public ArrayList<Musterija> ucitajMusterije(){
        ArrayList<Musterija> musterije = null;
        return musterije;
    }

    public ArrayList<Dispecer> ucitajDispecere(){
        ArrayList<Dispecer> dispeceri = null;
        return dispeceri;
    }

    public ArrayList<Voznja> ucitajVoznje() { // Kako Lista voznji kada je to apstrakta klasa kako ubaciti klase naslednice
        ArrayList<Voznja> voznje = null;
        return voznje;
    }

    public ArrayList<Automobil> ucitajAutomobile(){
        ArrayList<Automobil> automobili = null;
        return automobili;
    }

}
