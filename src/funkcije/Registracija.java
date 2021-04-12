package funkcije;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Registracija {

    //Funkcija za dobavljanje korisnika iz fajla
    // Nakon ovoga ovakav niz korisnika se uzima i pretvara u objekat u nekoj drugoj funkciji
    // TODO: Učitati sve fajlove u određene tipove lista i zatim prijavu i pretragu vršiti po tim tipovima podataka

    public String[] prijavaNaSistem(String korisnickoIme, String lozinka){
        String[] korisnik = null;
        try{
            File fajl = new File("src/fajlovi/korisnici.txt");
            BufferedReader reader = new BufferedReader(new FileReader(fajl));
            String red;

            while((red = reader.readLine()) != null) {
                String[] niz = red.split("\\|");

                if (niz[3].equals(korisnickoIme) && niz[4].equals(lozinka)) {
                    System.out.println("Korisnik " + niz[1] + " je prijavljen");
                    korisnik = niz;
                    break;
                }
            }

        } catch (Exception e){
            System.out.println("Došlo je do greke " + e);
            return null;
        }
        return korisnik;
    }

    //TODO: NAkon pretrage korisnika kreirati objekat u odnosu na ulogu koja se nalazi na tačno određe om indeksu u nizu

    // TODO: Implementovati funkciju regostracija!!!
    public void registracija(){

    }
}
