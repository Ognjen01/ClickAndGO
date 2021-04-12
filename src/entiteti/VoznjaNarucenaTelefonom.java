package entiteti;

public class VoznjaNarucenaTelefonom extends Voznja{
    private final String tipNarucivanje = "telefon";
    // private int trajanjeVoznje = super.getTrajanje(); Da lu ovo ovako treba da nasleđujemo pa da varijablu stavimo u konstruktor

    public VoznjaNarucenaTelefonom(){
    super();
    }

    public String getTipNarucivanje() {
        return tipNarucivanje;
    }
}
