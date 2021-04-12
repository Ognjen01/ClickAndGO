package entiteti;

import java.util.Date;

import korisnici.Musterija;
import korisnici.Vozac;

public abstract class Voznja {

	private int idVoznje;
	private String adresaPolaska;
	private String adresaDestinacije;
	private String status;
	private int duzina;
	private int trajanje;
	private int cenaPoKilometru = 60;
	private int cenaStarta = 100;
	private Date vremeNarudzbine;
	private Musterija musterija;
	private Vozac vozac;
	private int cijena;
	
	
	
	
	/*
	public Voznja(String adresaPolaska, String adresaDestinacije, String status, int duzina, int trajanje,
			int cenaPoKilometru, int cenaStarta, Date vremeNarudzbine, Musterija musterija, Vozac vozac) {
		this.adresaPolaska = adresaPolaska;
		this.adresaDestinacije = adresaDestinacije;
		this.status = status;
		this.duzina = duzina;
		this.trajanje = trajanje;
		this.cenaPoKilometru = cenaPoKilometru;
		this.cenaStarta = cenaStarta;
		this.vremeNarudzbine = vremeNarudzbine;
		this.musterija = musterija;
		this.vozac = vozac;


	}

	 */





	public String getAdresaPolaska() {
		return adresaPolaska;
	}





	public void setAdresaPolaska(String adresaPolaska) {
		this.adresaPolaska = adresaPolaska;
	}





	public String getAdresaDestinacije() {
		return adresaDestinacije;
	}





	public void setAdresaDestinacije(String adresaDestinacije) {
		this.adresaDestinacije = adresaDestinacije;
	}





	public String getStatus() {
		return status;
	}





	public void setStatus(String status) {
		this.status = status;
	}





	public int getDuzina() {
		return duzina;
	}





	public void setDuzina(int duzina) {
		this.duzina = duzina;
	}





	public int getTrajanje() {
		return trajanje;
	}





	public void setTrajanje(int trajanje) {
		this.trajanje = trajanje;
	}





	public int getCenaPoKilometru() {
		return cenaPoKilometru;
	}





	public void setCenaPoKilometru(int cenaPoKilometru) {
		this.cenaPoKilometru = cenaPoKilometru;
	}





	public int getCenaStarta() {
		return cenaStarta;
	}





	public void setCenaStarta(int cenaStarta) {
		this.cenaStarta = cenaStarta;
	}





	public Date getVremeNarudzbine() {
		return vremeNarudzbine;
	}





	public void setVremeNarudzbine(Date vremeNarudzbine) {
		this.vremeNarudzbine = vremeNarudzbine;
	}





	public Musterija getMusterija() {
		return musterija;
	}





	public void setMusterija(Musterija musterija) {
		this.musterija = musterija;
	}





	public Vozac getVozac() {
		return vozac;
	}





	public void setVozac(Vozac vozac) {
		this.vozac = vozac;
	}





	public Voznja() {
		// TODO Auto-generated constructor stub
	}

}
