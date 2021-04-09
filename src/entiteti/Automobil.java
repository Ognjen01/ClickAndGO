package entiteti;

import java.sql.Date;

public class Automobil {

	private int automobilID;
	private String model;
	private String proizvodjac;
	private Date datumRegistracije;
	private int brojVozila;	
	private String brojRegistracije;
	private String vrstaVozila;
	
	
	//konstruktori
	public Automobil() {}

	public Automobil(String model, 
			String proizvodjac, 
			Date datumRegistracije, 
			int brojVozila, 
			String brojRegistracije,
			String vrstaVozila) {
		this.model = model;
		this.proizvodjac = proizvodjac;
		this.datumRegistracije = datumRegistracije;
		this.brojVozila = brojVozila;
		this.brojRegistracije = brojRegistracije;
		this.vrstaVozila = vrstaVozila;
	}

	//geteri i seteri

	public int getAutomobilID() {
		return automobilID;
	}
	
	public String getModel() {
		return model;
	}



	public void setModel(String model) {
		this.model = model;
	}



	public String getProizvodjac() {
		return proizvodjac;
	}



	public void setProizvodjac(String proizvodjac) {
		this.proizvodjac = proizvodjac;
	}



	public Date getDatumRegistracije() {
		return datumRegistracije;
	}



	public void setDatumRegistracije(Date datumRegistracije) {
		this.datumRegistracije = datumRegistracije;
	}



	public int getBrojVozila() {
		return brojVozila;
	}



	public void setBrojVozila(int brojVozila) {
		this.brojVozila = brojVozila;
	}



	public String getBrojRegistracije() {
		return brojRegistracije;
	}



	public void setBrojRegistracije(String brojRegistracije) {
		this.brojRegistracije = brojRegistracije;
	}



	public String getVrstaVozila() {
		return vrstaVozila;
	}



	public void setVrstaVozila(String vrstaVozila) {
		this.vrstaVozila = vrstaVozila;
	}



	

}
