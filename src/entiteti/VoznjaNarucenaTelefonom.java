package entiteti;

import korisnici.Musterija;
import korisnici.Vozac;

import java.text.SimpleDateFormat;
import java.util.Date;

public class VoznjaNarucenaTelefonom extends Voznja {
    // TODO: Implemetnirati naručivanje putem telefonom

    private final String tipNarucivanje = "telefon";

    public VoznjaNarucenaTelefonom(int idVoznje,
                                   int idVozaca,
                                   int idMusterije,
                                   String adresaPolaska,
                                   String adresaDestinacije,
                                   String status,
                                   double duzina,
                                   double trajanje,
                                   int cenaVoznje,
                                   SimpleDateFormat vremeNarudzbe,
                                   Musterija musterija,
                                   Vozac vozac
    ) {
        super(idVoznje, idVozaca, idMusterije, adresaPolaska,
                adresaDestinacije, status, duzina, trajanje,
                cenaVoznje, vremeNarudzbe, musterija, vozac);

    }

    public VoznjaNarucenaTelefonom() {
    }

    ;

    public String getTipNarucivanje() {
        return tipNarucivanje;
    }

    @Override
    public String toString() {
        return super.toString() + tipNarucivanje + "\n";
    }
}
