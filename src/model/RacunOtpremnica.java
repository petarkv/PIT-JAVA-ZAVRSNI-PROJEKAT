package model;

import java.util.Date;

public class RacunOtpremnica {
	
	private int idRacuna;
	private int idZaposlenog;
	private int idKupca;
	private Zaposleni zaposleni;
	private Kupac kupac;
	private Artikli artikal;
	private Date datumRacuna;
	private Date datumNaplateRacuna;
	private double poreskaOsnovicaRacuna;
	private double ukupanIznosObracunatogPdvaRacuna;
	private double ukupnaVrednostRacuna;
	private String statusRacuna;
	
	
	public RacunOtpremnica() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RacunOtpremnica(int idRacuna, int idZaposlenog, int idKupca, Date datumRacuna, Date datumNaplateRacuna,
			double poreskaOsnovicaRacuna, double ukupanIznosObracunatogPdvaRacuna, double ukupnaVrednostRacuna) {
		super();
		this.idRacuna = idRacuna;
		this.idZaposlenog = idZaposlenog;
		this.idKupca = idKupca;
		this.datumRacuna = datumRacuna;
		this.datumNaplateRacuna = datumNaplateRacuna;
		this.poreskaOsnovicaRacuna = poreskaOsnovicaRacuna;
		this.ukupanIznosObracunatogPdvaRacuna = ukupanIznosObracunatogPdvaRacuna;
		this.ukupnaVrednostRacuna = ukupnaVrednostRacuna;
	}

	public RacunOtpremnica(int idRacuna, int idZaposlenog, int idKupca, Zaposleni zaposleni, Kupac kupac,
			Artikli artikal, Date datumRacuna, Date datumNaplateRacuna, double poreskaOsnovicaRacuna,
			double ukupanIznosObracunatogPdvaRacuna, double ukupnaVrednostRacuna) {
		super();
		this.idRacuna = idRacuna;
		this.idZaposlenog = idZaposlenog;
		this.idKupca = idKupca;
		this.zaposleni = zaposleni;
		this.kupac = kupac;
		this.artikal = artikal;
		this.datumRacuna = datumRacuna;
		this.datumNaplateRacuna = datumNaplateRacuna;
		this.poreskaOsnovicaRacuna = poreskaOsnovicaRacuna;
		this.ukupanIznosObracunatogPdvaRacuna = ukupanIznosObracunatogPdvaRacuna;
		this.ukupnaVrednostRacuna = ukupnaVrednostRacuna;
	}	
	

	public RacunOtpremnica(int idRacuna, int idZaposlenog, int idKupca, Zaposleni zaposleni, Kupac kupac,
			Artikli artikal, Date datumRacuna, Date datumNaplateRacuna, double poreskaOsnovicaRacuna,
			double ukupanIznosObracunatogPdvaRacuna, double ukupnaVrednostRacuna, String statusRacuna) {
		super();
		this.idRacuna = idRacuna;
		this.idZaposlenog = idZaposlenog;
		this.idKupca = idKupca;
		this.zaposleni = zaposleni;
		this.kupac = kupac;
		this.artikal = artikal;
		this.datumRacuna = datumRacuna;
		this.datumNaplateRacuna = datumNaplateRacuna;
		this.poreskaOsnovicaRacuna = poreskaOsnovicaRacuna;
		this.ukupanIznosObracunatogPdvaRacuna = ukupanIznosObracunatogPdvaRacuna;
		this.ukupnaVrednostRacuna = ukupnaVrednostRacuna;
		this.statusRacuna = statusRacuna;
	}

	public RacunOtpremnica(int id, Date d, Date datumNaplateRacuna) {
		
	}

	public RacunOtpremnica(int idzaposlenog, int idkupca, Date datumRacuna, Date datumNaplateRacuna) {
		this.idZaposlenog = idzaposlenog;
		this.idKupca = idkupca;
		this.datumRacuna = datumRacuna;
		this.datumNaplateRacuna = datumNaplateRacuna;
	}

	public RacunOtpremnica(Date datumNaplateRacuna2) {
		
		this.datumNaplateRacuna = datumNaplateRacuna2;
	}

	public int getIdRacuna() {
		return idRacuna;
	}

	public void setIdRacuna(int idRacuna) {
		this.idRacuna = idRacuna;
	}

	public int getIdZaposlenog() {
		return idZaposlenog;
	}

	public void setIdZaposlenog(int idZaposlenog) {
		this.idZaposlenog = idZaposlenog;
	}

	public int getIdKupca() {
		return idKupca;
	}

	public void setIdKupca(int idKupca) {
		this.idKupca = idKupca;
	}

	public Zaposleni getZaposleni() {
		return zaposleni;
	}

	public void setZaposleni(Zaposleni zaposleni) {
		this.zaposleni = zaposleni;
	}

	public Kupac getKupac() {
		return kupac;
	}

	public void setKupac(Kupac kupac) {
		this.kupac = kupac;
	}

	public Artikli getArtikal() {
		return artikal;
	}

	public void setArtikal(Artikli artikal) {
		this.artikal = artikal;
	}

	public Date getDatumRacuna() {
		return datumRacuna;
	}

	public void setDatumRacuna(Date datumRacuna) {
		this.datumRacuna = datumRacuna;
	}

	public Date getDatumNaplateRacuna() {
		return datumNaplateRacuna;
	}

	public void setDatumNaplateRacuna(Date datumNaplateRacuna) {
		this.datumNaplateRacuna = datumNaplateRacuna;
	}

	public double getPoreskaOsnovicaRacuna() {
		return poreskaOsnovicaRacuna;
	}

	public void setPoreskaOsnovicaRacuna(double poreskaOsnovicaRacuna) {
		this.poreskaOsnovicaRacuna = poreskaOsnovicaRacuna;
	}

	public double getUkupanIznosObracunatogPdvaRacuna() {
		return ukupanIznosObracunatogPdvaRacuna;
	}

	public void setUkupanIznosObracunatogPdvaRacuna(double ukupanIznosObracunatogPdvaRacuna) {
		this.ukupanIznosObracunatogPdvaRacuna = ukupanIznosObracunatogPdvaRacuna;
	}

	public double getUkupnaVrednostRacuna() {
		return ukupnaVrednostRacuna;
	}

	public void setUkupnaVrednostRacuna(double ukupnaVrednostRacuna) {
		this.ukupnaVrednostRacuna = ukupnaVrednostRacuna;
	}

	public String getStatusRacuna() {
		return statusRacuna;
	}

	public void setStatusRacuna(String statusRacuna) {
		this.statusRacuna = statusRacuna;
	}	
	

}
