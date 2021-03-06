package entiteti;

import enumeracije.StatusVoznje;
import korisnici.Musterija;
import korisnici.Vozac;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

public class VoznjaNarucenaTelefonom extends Voznja {

    private final String tipNarucivanje = "telefon";

    public VoznjaNarucenaTelefonom(int idVoznje,
                                   int idVozaca,
                                   int idMusterije,
                                   String adresaPolaska,
                                   String adresaDestinacije,
                                   StatusVoznje status,
                                   double duzina,
                                   double trajanje,
                                   int cenaVoznje,
                                   Date vremeNarudzbe,
                                   Musterija musterija,
                                   Vozac vozac,
                                   boolean ocjenjena
    ) {
        super(idVoznje, idVozaca, idMusterije, adresaPolaska,
                adresaDestinacije, status, duzina, trajanje,
                cenaVoznje, vremeNarudzbe, musterija, vozac, ocjenjena);

    }

    public String getTipNarucivanje() {
        return tipNarucivanje;
    }

    @Override
    public String toString() {
        return super.toString() + tipNarucivanje + "|" + isOcjenjena() + "\n";
    }
}
