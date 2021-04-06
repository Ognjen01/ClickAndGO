package com.infinty;
import java.io.*;

public interface OsnovneFunkcije{

    public static String[] prijavaNaSistem(String korisnickoIme, String lozinka){
        String[] korisnik = null;
        try{
            File fajl = new File("src/fajlovi/korisnici.txt");
            BufferedReader reader = new BufferedReader(new FileReader(fajl));
            String red;

            while((red = reader.readLine()) != null) {
                System.out.println(red);
                String[] niz = red.split("\\|");
                System.out.println(niz[1]);

                if (niz[2].equals(korisnickoIme) && niz[3].equals(lozinka)) {
                    System.out.println("Dobrodosao "+ niz[0]);
                    korisnik = niz;
                    break;
                }
            }

        } catch (Exception e){
            System.out.println("Doslo je do greke " + e);
            return null;
        }
        return korisnik;
    }
}
