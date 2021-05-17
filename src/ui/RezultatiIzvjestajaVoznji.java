package ui;

import entiteti.TaxiSluzba;
import entiteti.Voznja;

import javax.swing.*;
import java.util.List;

public class RezultatiIzvjestajaVoznji extends JFrame {

    public RezultatiIzvjestajaVoznji(List<Voznja> listaVoznji){
        setSize(600, 300);
        setTitle("Click&GO - Rezultati izvještaja");
        setLocationRelativeTo(null);
    }
}
