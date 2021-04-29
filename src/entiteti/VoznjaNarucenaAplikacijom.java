package entiteti;

import korisnici.Musterija;
import korisnici.Vozac;

import java.util.Date;

public class VoznjaNarucenaAplikacijom extends Voznja {
    // TODO: Implemetnirati naručivanje putem aplikacije

    private final String tipNarucivanja = "aplikacija";
    private Date datum;

    public VoznjaNarucenaAplikacijom(
            int idVoznje,
            int idVozaca,
            int idMusterije,
            String adresaPolaska,
            String adresaDestinacije,
            String status,
            double duzina,
            double trajanje,
            int cenaVoznje,
            Date vremeNarudzbe,
            Musterija musterija,
            Vozac vozac
    ) {
        super(idVoznje, idVozaca, idMusterije, adresaPolaska,
                adresaDestinacije, status, duzina, trajanje,
                cenaVoznje, vremeNarudzbe, musterija, vozac); // Dovršiti konstruktor

    }

    public VoznjaNarucenaAplikacijom() {
    }

    ; // Prazan konstruktor za instanciranje prazne voznje...

    public String getTipNarucivanja() {
        return tipNarucivanja;
    }

    @Override
    public String toString() {
        return super.toString() + tipNarucivanja + "\n";
    }
}
