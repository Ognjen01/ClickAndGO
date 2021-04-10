package entiteti;

public class TaxiSluzba {

    private String naziv = "Click&GO";
    private int pib;
    private String adresa = "Bulevar Despota Stefana 5A";
    private int cijenaStarta = 180;
    private int cijenaPoKilometru = 60;


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
}
