package funkcije;

import korisnici.Osoba;

import java.util.List;

public class DodavanjeKorisnika {

    public Osoba dodajKorisnika(List<Osoba> listaOsoba, Osoba osoba){
        listaOsoba.add(osoba);

        return (Osoba) listaOsoba;
    }


}
