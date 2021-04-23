package korisnici;

import entiteti.Voznja;
import entiteti.VoznjaNarucenaAplikacijom;
import entiteti.VoznjaNarucenaTelefonom;

import java.util.ArrayList;
import java.util.List;

public class Musterija extends Osoba {
	private List<Voznja> voznjeMusterije;

	public Musterija(int idKorisnika,
					 String ime,
					 String prezime,
					 String korisnickoIme,
					 String lozinka,
					 String jmbg,
					 String adresa,
					 char pol,
					 String brojTelefona,
					 String uloga,
					 boolean aktivan,
					 List<Voznja> voznjeMusterije) {
		super(idKorisnika, ime, prezime, korisnickoIme, lozinka, jmbg, adresa, pol, brojTelefona, uloga, aktivan);
		this.voznjeMusterije = voznjeMusterije;
	}

	// Prazan konstruktor

	public Musterija(){
		// Generisati prazna polja Musterije
	}

	public void naruciVoznjuTelefonom(){

	}

	public void naruciVoznjuAplikacijom() {

	}

	// Da li ima potrebe za Overide funkcijama iz klase Osoba??
}
