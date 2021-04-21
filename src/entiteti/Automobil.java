package entiteti;

import enumeracije.TipVozila;

import java.sql.Date;

public class Automobil {

	private int automobilID;
	private String model;
	private String proizvodjac;
	private java.util.Date datumRegistracije;
	private int brojVozila;	
	private String brojRegistracije;
	private TipVozila tipVozila;
	private int idVozaca;
	
	
	//konstruktori
	public Automobil() {}

	public Automobil(
			int automobilID,
			int brojVozila,
			String proizvodjac,
			String model,
			java.util.Date datumRegistracije,
			String brojRegistracije,
			TipVozila tipVozila,
			int idVozaca) {
		this.model = model;
		this.proizvodjac = proizvodjac;
		this.datumRegistracije = datumRegistracije;
		this.brojVozila = brojVozila;
		this.brojRegistracije = brojRegistracije;
		this.tipVozila = tipVozila;
		this.automobilID = automobilID;
		this.idVozaca = idVozaca;
	}

	// TODO: Generisati prazan konstruktor

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


	public java.util.Date getDatumRegistracije() {
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


	

}
