package pomocneKlase;

import entiteti.*;
import korisnici.Dispecer;
import korisnici.Musterija;
import korisnici.Osoba;
import korisnici.Vozac;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class UpisivanjeUFajl {

    private final String PUTANJA_DO_FAJLOVA = "src/fajlovi/";
    private final String KORISNICI_FAJL = "korisnici.txt";
    private final String AUTOMOBILI_FAJL = "automobili.txt";
    private final String VOZNJE_FAJL = "voznje.txt";
    /*
    TODO: 1. Napraviti funkciju koja će iterirati kroz listu učitanih objekata (učitan na početku izvršavanja programa), ova funkcija može biti univerzalna za sve liste
          2. U ovoj funkciji pozvati funkciju za pretvaranje objekta u niz, a može odma i u kompletan string
          3. Treća funkcija treba da taj String (koji je u stvari jedan objekat u pisanom formatu) upiše u fajl, po pravilnom rasporedu elemenata
          4. Ovi ciklusi se dešavaju unutar iteracije i svaki sledeći red se dodaje u fajl
          5. Prije početka ovog procesa neophodno je očistiti sve trenutne redove iz fajla
          6. Potrebno je implementirati upisivanje za sve entitete
          7. Vjerovatno će biti neophodan sistem odluke koji će odlučivati da li se upisuje musterija, vozač ili korisnik
          8. Neophodna je funkcija za svaki entitet jer su formati unutar fajlova različiti
          9. Po potrebi kreirati dodatne klase koje će pomoći upsiivanje u fajl
          10. Razloziti objekat TAXI SLUZBA za upisivanje u fajl, ova klasa će se prosledjivati kroz ozvrsavanje programa
     */

    public void upisiTaxiSluzbu(TaxiSluzba taxiSluzba){

        ocistiFajl(PUTANJA_DO_FAJLOVA + KORISNICI_FAJL);
        List<Osoba> osobe = taxiSluzba.getListaOsoba();
        upisiSveOsobe(osobe);


        ocistiFajl(PUTANJA_DO_FAJLOVA + AUTOMOBILI_FAJL);
        List<Automobil> automobili = taxiSluzba.getListaAutomovila();
        upisiSveAutomobile(automobili);

        /*
        //POTREBNO POPRAVITI UCITAVANJE VOZNJI TAKO DA VREME NARUDZBINE BUDE U PRAVOM FORMATU, A NE TRENUTNO VREME IZVRSENJA (datume = <datum iz fajla>)
        ocistiFajl(PUTANJA_DO_FAJLOVA + VOZNJE_FAJL);
        List<Voznja> voznje = taxiSluzba.getListaVoznji();
        upisiSveVoznje(voznje);
        */
    }

    public void ocistiFajl(String nazivFajla){
        BufferedWriter bw = null;
        try {
            File fajl = new File(nazivFajla);
            if (!fajl.exists()) {
                fajl.createNewFile();
            }

            FileWriter fw = new FileWriter(fajl,false);
            bw = new BufferedWriter(fw);
            bw.write("");
        } catch (IOException e) {
            System.out.println("GRESKA!" + e);
        }
        finally {
            try{
                if(bw!=null)
                    bw.close();
            }catch(Exception ex){
                System.out.println("Error in closing the BufferedWriter"+ex);
            }
        }
    }

    private void upisiSveOsobe(List<Osoba> osobe){
        for(Osoba osoba : osobe){
            if(osoba.getUloga().equals("korisnik")){
                upisiMusteriju((Musterija) osoba);
            }
            else{
                if(osoba.getUloga().equals("dispecer")){
                    upisiDispecera((Dispecer) osoba);
                }
                else{
                    if(osoba.getUloga().equals("vozac")){
                        upisiVozaca((Vozac) osoba);
                    }
                }
            }
        }
    }

    public void upisiSveAutomobile(List<Automobil> automobili){
        for(Automobil automobil : automobili){
            upisiAutomobil(automobil);
        }
    }

    private void upisiSveVoznje(List<Voznja> voznje){
        for(Voznja voznja : voznje){
            upisiVoznju(voznja);
        }
    }

    private void upisiMusteriju(Musterija musterija) {
        BufferedWriter bw = null;
        try {
            File fajl = new File(PUTANJA_DO_FAJLOVA + KORISNICI_FAJL);
            if (!fajl.exists()) {
                fajl.createNewFile();
            }

            FileWriter fw = new FileWriter(fajl,true);
            bw = new BufferedWriter(fw);
            bw.write(musterija.toString());
            System.out.println("Musterija:\n\n" + musterija.toString() + "\n\nuspesno upisana u fajl");
        } catch (IOException e) {
            System.out.println("GRESKA!" + e);
        }
        finally {
            try{
                if(bw!=null)
                    bw.close();
            }catch(Exception ex){
                System.out.println("Error in closing the BufferedWriter"+ex);
            }
        }
    }

    private void upisiDispecera(Dispecer dispecer) {
        BufferedWriter bw = null;
        try {
            File fajl = new File(PUTANJA_DO_FAJLOVA + KORISNICI_FAJL);
            if (!fajl.exists()) {
                fajl.createNewFile();
            }

            FileWriter fw = new FileWriter(fajl,true);
            bw = new BufferedWriter(fw);
            bw.write(dispecer.toString());
            System.out.println("Dispecer:\n\n" + dispecer.toString() + "\n\nuspesno upisan u fajl");
        } catch (IOException e) {
            System.out.println("GRESKA!" + e);
        }
        finally {
            try{
                if(bw!=null)
                    bw.close();
            }catch(Exception ex){
                System.out.println("Error in closing the BufferedWriter"+ex);
            }
        }
    }

    private void upisiVozaca(Vozac vozac) {
        BufferedWriter bw = null;
        try {
            File fajl = new File(PUTANJA_DO_FAJLOVA + KORISNICI_FAJL);
            if (!fajl.exists()) {
                fajl.createNewFile();
            }

            FileWriter fw = new FileWriter(fajl,true);
            bw = new BufferedWriter(fw);
            bw.write(vozac.toString());
            System.out.println("Vozac:\n\n" + vozac.toString() + "\n\nuspesno upisan u fajl");
        } catch (IOException e) {
            System.out.println("GRESKA!" + e);
        }
        finally {
            try{
                if(bw!=null)
                    bw.close();
            }catch(Exception ex){
                System.out.println("Error in closing the BufferedWriter"+ex);
            }
        }
    }

    private void upisiAutomobil(Automobil automobil) {
        BufferedWriter bw = null;
        try {
            File fajl = new File(PUTANJA_DO_FAJLOVA + AUTOMOBILI_FAJL);
            if (!fajl.exists()) {
                fajl.createNewFile();
            }

            FileWriter fw = new FileWriter(fajl,true);
            bw = new BufferedWriter(fw);
            bw.write(automobil.toString());
            System.out.println("Automobil:\n\n" + automobil.toString() + "\n\nuspesno upisan u fajl");
        } catch (IOException e) {
            System.out.println("GRESKA!" + e);
        }
        finally {
            try{
                if(bw!=null)
                    bw.close();
            }catch(Exception ex){
                System.out.println("Error in closing the BufferedWriter"+ex);
            }
        }
    }

    private void upisiVoznju(Voznja voznja) {
        BufferedWriter bw = null;
        try {
            File fajl = new File(PUTANJA_DO_FAJLOVA + VOZNJE_FAJL);
            if (!fajl.exists()) {
                fajl.createNewFile();
            }

            FileWriter fw = new FileWriter(fajl,true);
            bw = new BufferedWriter(fw);
            if(voznja instanceof VoznjaNarucenaAplikacijom){
                bw.write(
                        ((VoznjaNarucenaAplikacijom)voznja).toString());
            }
            else{
                bw.write(
                        ((VoznjaNarucenaTelefonom)voznja).toString()
                );

            }
            System.out.println("Voznja:\n\n" + voznja.toString() + "\n\nuspesno upisan u fajl");
        } catch (IOException e) {
            System.out.println("GRESKA!" + e);
        }
        finally {
            try{
                if(bw!=null)
                    bw.close();
            }catch(Exception ex){
                System.out.println("Error in closing the BufferedWriter"+ex);
            }
        }
    }

}
