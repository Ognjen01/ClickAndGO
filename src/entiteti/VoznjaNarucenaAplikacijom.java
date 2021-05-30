package entiteti;

import enumeracije.StatusVoznje;
import korisnici.Musterija;
import korisnici.Vozac;

import java.util.Date;

public class VoznjaNarucenaAplikacijom extends Voznja {

    private final String tipNarucivanja = "aplikacija";
    private boolean petFriendly;
    private String napomena;

    public VoznjaNarucenaAplikacijom(
            int idVoznje,
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
            boolean petFriendly,
            String napomena
    ) {
        super(idVoznje, idVozaca, idMusterije, adresaPolaska,
                adresaDestinacije, status, duzina, trajanje,
                cenaVoznje, vremeNarudzbe, musterija, vozac); // Dovršiti konstruktor
        this.petFriendly = petFriendly;
        this.napomena = napomena;

    }

    public VoznjaNarucenaAplikacijom() {
       setIdVozaca(0);
       setIdMusterije(0);
       setIdVoznje(0);
       setNapomena(null);
       setAdresaDestinacije(null);
       setAdresaPolaska(null);
       setStatus(null);
       setDuzina(0);
       setTrajanje(0);
       setCenaVoznje(0);
       setVremeNarudzbine(null);
       setMusterija(null);
       setVozac(null);

    }


    public String getTipNarucivanja() {
        return tipNarucivanja;
    }

    public void setPetFriendly(boolean petFriendly) {
        this.petFriendly = petFriendly;
    }

    public void setNapomena(String napomena) {
        this.napomena = napomena;
    }

    @Override
    public String toString() {
        return super.toString() + tipNarucivanja + "|" + petFriendly + "|" + napomena + "\n";
    }
}
