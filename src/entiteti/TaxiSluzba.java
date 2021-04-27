package entiteti;

import korisnici.Osoba;

import java.util.List;

public class TaxiSluzba {

    private String naziv = "Click&GO";
    private int pib;
    private String adresa = "Bulevar Despota Stefana 5A";
    private int cijenaStarta = 180;
    private int cijenaPoKilometru = 60;
    private List<Osoba> listaOsoba = null;
    private List<Automobil> listaAutomovila = null;
    private List<Voznja> listaVoznji = null;

    // TODO: Ognjen će dodati algoritam za prosledjivanje listi u objekat
    //      kako bi se objekat mogao prosledjivati kroz izbrsavanje programa


    // Geteri i seteri za entitet TaxiSluzba

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

    public List<Automobil> getListaAutomovila() {
        return listaAutomovila;
    }

    public List<Osoba> getListaOsoba() {
        return listaOsoba;
    }

    public List<Voznja> getListaVoznji() {
        return listaVoznji;
    }

    public void setListaAutomovila(List<Automobil> listaAutomovila) {
        this.listaAutomovila = listaAutomovila;
    }

    public void setListaOsoba(List<Osoba> listaOsoba) {
        this.listaOsoba = listaOsoba;
    }

    public void setListaVoznji(List<Voznja> listaVoznji) {
        this.listaVoznji = listaVoznji;
    }
}
