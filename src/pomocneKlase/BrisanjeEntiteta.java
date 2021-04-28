package pomocneKlase;

import korisnici.Osoba;

import java.util.List;


public class BrisanjeEntiteta {

    // Početni sistem za izmjenu atributa aktivnosti u listi objekata

    public void obrisiKorisnika(List<Osoba> listaOsoba, Osoba osoba) {
        for (Osoba nadjenaOsoba : listaOsoba) {
            if (osoba.getIdKorisnika() == nadjenaOsoba.getIdKorisnika()) {
                nadjenaOsoba.setAktivan(false);
            }
        }
    }
}
