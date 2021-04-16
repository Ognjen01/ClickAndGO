package funkcije;

import entiteti.Voznja;
import entiteti.VoznjaNarucenaAplikacijom;
import entiteti.VoznjaNarucenaTelefonom;
import korisnici.Osoba;
import korisnici.Vozac;

import java.util.ArrayList;
import java.util.List;

public class SistemOdlukeVoznje {
    public List<Voznja> iteracijaKrozListuStringova(List<String[]> listaEntiteta){
        List<Voznja> listaUcitanihVoznji = new ArrayList<Voznja>();


        for (String[] nizEntitetaVoznje: listaEntiteta
        ) {
            // Kreiranje Objekta voznje i dodavanje u listu
            Voznja novaVoznja = odluciKojuVoznjuUcitati(nizEntitetaVoznje);
            listaUcitanihVoznji.add(novaVoznja);
        }
        return listaUcitanihVoznji;
    }


    public Voznja odluciKojuVoznjuUcitati(String[] elementiVoznje) {
        if (elementiVoznje[10].equals("telefon")) {
            VoznjaNarucenaTelefonom novaVoznjaTelefon = new VoznjaNarucenaTelefonom(); // Popuniti konstruktore
            return novaVoznjaTelefon;
        } else if (elementiVoznje[10].equals("aplikacija")) {
            VoznjaNarucenaAplikacijom novaVoznjaAplikacija = new VoznjaNarucenaAplikacijom(); // popuniti konstrukor
            return novaVoznjaAplikacija;
        } else {
            System.out.println("Došlo je do greške prilikom učitavanja vožnji");
            return null;
        }
    }

}

// Prilikom prolaska kroz voznje i kreiranja njihovih objekata, možda kao ulaz u funkciju takođe uzeti
// listu onih vozača i dodijeliti im vožnje u njihovu listu vožnji
