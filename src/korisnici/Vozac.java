package korisnici;

import entiteti.Automobil;

public class Vozac extends Osoba {

	private int plata;
	private int brClanskeKarte;
	private Automobil automobil;
	
	
	
	
	public Vozac(String ime, String prezime, String korisnickoIme, String lozinka, long jmbg, String adresa, char pol,
			int brojTelefona, String uloga, int plata, int brClanskeKarte, Automobil automobil) {
		super(ime, prezime, korisnickoIme, lozinka, jmbg, adresa, pol, brojTelefona, uloga);
		this.plata = plata;
		this.brClanskeKarte = brClanskeKarte;
		this.automobil = automobil;
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
