package pomocneKlase;

public class IzvestajVozacaPodaci {

    private int idVozaca;
    private int ukupanBrojVoznji;
    private double duzina;
    private double vreme;
    private double prosecnaDuzina;
    private double prosecnoVreme;

    public IzvestajVozacaPodaci(int idVozaca, int ukupanBrojVoznji, double duzina, double vreme, double prosecnaDuzina, double prosecnoVreme, double zarada, double prosecnaZarad) {
        this.idVozaca = idVozaca;
        this.ukupanBrojVoznji = ukupanBrojVoznji;
        this.duzina = duzina;
        this.vreme = vreme;
        this.prosecnaDuzina = prosecnaDuzina;
        this.prosecnoVreme = prosecnoVreme;
        this.zarada = zarada;
        this.prosecnaZarad = prosecnaZarad;
    }

    public int getIdVozaca() {
        return idVozaca;
    }

    public void setIdVozaca(int idVozaca) {
        this.idVozaca = idVozaca;
    }

    public int getUkupanBrojVoznji() {
        return ukupanBrojVoznji;
    }

    public void setUkupanBrojVoznji(int ukupanBrojVoznji) {
        this.ukupanBrojVoznji = ukupanBrojVoznji;
    }

    public double getDuzina() {
        return duzina;
    }

    public void setDuzina(double duzina) {
        this.duzina = duzina;
    }

    public double getVreme() {
        return vreme;
    }

    public void setVreme(double vreme) {
        this.vreme = vreme;
    }

    public double getProsecnaDuzina() {
        return prosecnaDuzina;
    }

    public void setProsecnaDuzina(double prosecnaDuzina) {
        this.prosecnaDuzina = prosecnaDuzina;
    }

    public double getProsecnoVreme() {
        return prosecnoVreme;
    }

    public void setProsecnoVreme(double prosecnoVreme) {
        this.prosecnoVreme = prosecnoVreme;
    }

    public double getZarada() {
        return zarada;
    }

    public void setZarada(double zarada) {
        this.zarada = zarada;
    }

    public double getProsecnaZarad() {
        return prosecnaZarad;
    }

    public void setProsecnaZarad(double prosecnaZarad) {
        this.prosecnaZarad = prosecnaZarad;
    }

    private double zarada;
    private double prosecnaZarad;

    public String[] toArrayString(){

        String nizObjekata[] = new String[] {
          String.valueOf(idVozaca),
          String.valueOf(ukupanBrojVoznji),
          String.valueOf(duzina),
          String.valueOf(vreme),
          String.valueOf(prosecnaDuzina),
          String.valueOf(prosecnoVreme),
          String.valueOf(zarada),
                String.valueOf(prosecnaZarad)
        };

        return nizObjekata;
    }
}
