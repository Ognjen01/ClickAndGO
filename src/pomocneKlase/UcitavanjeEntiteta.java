package pomocneKlase;

import entiteti.Automobil;
import enumeracije.TipVozila;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UcitavanjeEntiteta {

    // UČITAVANJE AUTOMOBILA
    // Isti algoritam se može koristiti i za učitavanje obrisanih automobila

    // TODO: U string automobila mora da bude id vozaca kako bi na osnovu tof id prosao kroz listu vozaca i tom vozacu dodijelio automobil
    //      SIstem odluke za tip vozila
    //      Nula prilikom ucitavanja na mjestu id vozaca znaci da auto nije dodjeljen
    //      Ovaj sistem ce vjerovatno biti u mainu izvrsen nakon svih ucitavanja jer bi u supronom funkcije ispod morale da prime lsitu vozaca kao parametar

    public List<Automobil> ucitajListuAutomobila(List<String[]> nizAutomobila) {

        List<Automobil> listaAutomobila = new ArrayList<Automobil>();

        for (String[] automobil : nizAutomobila) {

            Automobil automobil1 = transformisiAutomobil(automobil);
            listaAutomobila.add(automobil1);
        }

        return listaAutomobila;

    }

    private Automobil transformisiAutomobil(String[] automobil) {

        TipVozila tipVozila = TipVozila.valueOf(automobil[6]);


        Date datumRegistracije = null;
        try {
            datumRegistracije = new SimpleDateFormat("yyyy-MM-dd").parse(automobil[4]);
        } catch (ParseException e) {
            System.out.println("Došlo je do greške prilikom konverzije datuma");
        }
        int idAutomobila = Integer.parseInt(automobil[0]);
        int brojVozila = Integer.parseInt(automobil[1]);
        int idVozaca = Integer.parseInt(automobil[7]);

        Automobil auto = new Automobil(
                idAutomobila,
                brojVozila,
                automobil[2],
                automobil[3],
                datumRegistracije,
                automobil[5],
                tipVozila,
                idVozaca
        );

        return auto;
    }

}
