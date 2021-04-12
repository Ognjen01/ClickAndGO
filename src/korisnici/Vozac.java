package korisnici;

import entiteti.Automobil;
import entiteti.Voznja;
import entiteti.VoznjaNarucenaAplikacijom;
import entiteti.VoznjaNarucenaTelefonom;

import java.util.List;

public class Vozac extends Osoba {

	public List<Voznja> voznjeVozaca; // da li je ovo moguće jer je ovo apstraktna klasa, a u listi moraju biti i one narucene telefonom i aplikacijom
	private int plata;
	private int brClanskeKarte;
	private Automobil automobil;

	
	public Vozac(String ime,
				 String prezime,
				 String korisnickoIme,
				 String lozinka,
				 long jmbg,
				 String adresa,
				 char pol,
				 int brojTelefona,
				 String uloga,
				 int plata,
				 int brClanskeKarte,
				 Automobil automobil,
				 List<Voznja> voznjeVozaca
	) {
		super();
		this.plata = plata;
		this.brClanskeKarte = brClanskeKarte;
		this.automobil = automobil;
		this.ime = ime;
		this.voznjeVozaca = voznjeVozaca;
	}




	public int getPlata() {
		return plata;
	}




	public void setPlata(int plata) {
		this.plata = plata;
	}




	public int getBrClanskeKarte() {
		return brClanskeKarte;
	}




	public void setBrClanskeKarte(int brClanskeKarte) {
		this.brClanskeKarte = brClanskeKarte;
	}




	public Automobil getAutomobil() {
		return automobil;
	}




	public void setAutomobil(Automobil automobil) {
		this.automobil = automobil;
	}


}
