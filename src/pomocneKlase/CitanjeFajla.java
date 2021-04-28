package pomocneKlase;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CitanjeFajla {

    // Funkcija koja čita red i vraća niz vrijednosti izdvojenih iz reda

    public String[] procitajRed(String red) {
        String[] nizElemenata = null;
        try {
            nizElemenata = red.split("\\|");
        } catch (Exception e) {
            System.out.println("Došlo je do greške u čitanju reda");
        }
        return nizElemenata;
    }

    // Funkcija koja prima naziv fajla i cita sve redove i vraca Listu stringova
    // Može se primjeniti za sve entitete i sva čitanja iz fajlova

    public List<String[]> procitajFajl(String nazivFajla) {
        List<String[]> podijeljeniRedovi = new ArrayList<String[]>();

        try {
            File fajl = new File("src/fajlovi/" + nazivFajla);
            BufferedReader reader = new BufferedReader(new FileReader(fajl));
            String[] niz;
            String red;
            while ((red = reader.readLine()) != null) {
                niz = procitajRed(red);
                podijeljeniRedovi.add(niz);
            }

        } catch (Exception e) {
            System.out.println("Došlo je do greke " + e);
            return null;
        }

        return podijeljeniRedovi;
    }

}
