package model;

import java.util.Date;

public class Izvestaj {
	//ARTIKAL
	private int idArtikla;
	private int IdgrupaArtikla;
	private String naziv_grupe_artikala;
	private String naziv_artikla;
	private String jedinica_mere;
	private double neto_cena_artikla;
	private double stopa_PDV;
	private double marza_artikla;
	public int getIdArtikla() {
		return idArtikla;
	}
	public void setIdArtikla(int idArtikla) {
		this.idArtikla = idArtikla;
	}
	public int getIdgrupaArtikla() {
		return IdgrupaArtikla;
	}
	public void setIdgrupaArtikla(int idgrupaArtikla) {
		IdgrupaArtikla = idgrupaArtikla;
	}
	public String getNaziv_grupe_artikala() {
		return naziv_grupe_artikala;
	}
	public void setNaziv_grupe_artikala(String naziv_grupe_artikala) {
		this.naziv_grupe_artikala = naziv_grupe_artikala;
	}
	public String getNaziv_artikla() {
		return naziv_artikla;
	}
	public void setNaziv_artikla(String naziv_artikla) {
		this.naziv_artikla = naziv_artikla;
	}
	public String getJedinica_mere() {
		return jedinica_mere;
	}
	public void setJedinica_mere(String jedinica_mere) {
		this.jedinica_mere = jedinica_mere;
	}
	public double getNeto_cena_artikla() {
		return neto_cena_artikla;
	}
	public void setNeto_cena_artikla(double neto_cena_artikla) {
		this.neto_cena_artikla = neto_cena_artikla;
	}
	public double getStopa_PDV() {
		return stopa_PDV;
	}
	public void setStopa_PDV(int stopa_PDV) {
		this.stopa_PDV = stopa_PDV;
	}
	public double getMarza_artikla() {
		return marza_artikla;
	}
	public void setMarza_artikla(double marza_artikla) {
		this.marza_artikla = marza_artikla;
	}
	//STAVKE RACUNA OTPREMNICE
	private int idracunOtpremnica;
	private Artikli artikal;
	private double kolicinaProdaje;
	private double rabatProdaje;
	private int idStavkeProdaje;	
	
	
	public int getIdStavkeProdaje() {
		return idStavkeProdaje;
	}
	public void setIdStavkeProdaje(int idStavkeProdaje) {
		this.idStavkeProdaje = idStavkeProdaje;
	}
	public int getIdracunOtpremnica() {
		return idracunOtpremnica;
	}
	public void setIdracunOtpremnica(int idracunOtpremnica) {
		this.idracunOtpremnica = idracunOtpremnica;
	}
	public Artikli getArtikal() {
		return artikal;
	}
	public void setArtikal(Artikli artikal) {
		this.artikal = artikal;
	}
	public double getKolicinaProdaje() {
		return kolicinaProdaje;
	}
	public void setKolicinaProdaje(double kolicinaProdaje) {
		this.kolicinaProdaje = kolicinaProdaje;
	}
	public double getRabatProdaje() {
		return rabatProdaje;
	}
	public void setRabatProdaje(double rabatProdaje) {
		this.rabatProdaje = rabatProdaje;
	}
	public Izvestaj(int idArtikla, int idgrupaArtikla, String naziv_grupe_artikala, String naziv_artikla,
			String jedinica_mere, double neto_cena_artikla, int stopa_PDV, double marza_artikla, int idracunOtpremnica,
			Artikli artikal, double kolicinaProdaje, double rabatProdaje) {
		super();
		this.idArtikla = idArtikla;
		this.IdgrupaArtikla = idgrupaArtikla;
		this.naziv_grupe_artikala = naziv_grupe_artikala;
		this.naziv_artikla = naziv_artikla;
		this.jedinica_mere = jedinica_mere;
		this.neto_cena_artikla = neto_cena_artikla;
		this.stopa_PDV = stopa_PDV;
		this.marza_artikla = marza_artikla;
		this.idracunOtpremnica = idracunOtpremnica;
		this.artikal = artikal;
		this.kolicinaProdaje = kolicinaProdaje;
		this.rabatProdaje = rabatProdaje;
	}

	public Izvestaj(String naziv, double kolicina_prodaje, String jedinica_mere2, double neto_cena_artikla2,
			int stopa_PDV2, double rabat_prodaje,int idStavkeProdaje) {
		
		this.naziv_artikla = naziv;
		this.kolicinaProdaje = kolicina_prodaje;
		this.jedinica_mere = jedinica_mere2;
		this.neto_cena_artikla = neto_cena_artikla2;
		this.stopa_PDV = stopa_PDV2;
		this.rabatProdaje = rabat_prodaje;
		this.idStavkeProdaje=idStavkeProdaje;
	}
	//RACUN OTPREMNICA
	private int idRacuna;
	private int idZaposlenog;
	private int idKupca;
	private Zaposleni zaposleni;
	private Kupac kupac;
	private Artikli artikalRacun;
	private Date datumRacuna;
	private Date datumNaplateRacuna;
	private double poreskaOsnovicaRacuna;
	private double ukupanIznosObracunatogPdvaRacuna;
	private double ukupnaVrednostRacuna;
	private String statusRacuna;
	
	
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
	public Artikli getArtikalRacun() {
		return artikalRacun;
	}
	public void setArtikalRacun(Artikli artikalRacun) {
		this.artikalRacun = artikalRacun;
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
	
	
	public Izvestaj(int idArtikla, int idgrupaArtikla, String naziv_grupe_artikala, String naziv_artikla,
			String jedinica_mere, double neto_cena_artikla, int stopa_PDV, double marza_artikla, int idracunOtpremnica,
			Artikli artikal, double kolicinaProdaje, double rabatProdaje, int idRacuna, int idZaposlenog, int idKupca,
			Zaposleni zaposleni, Kupac kupac, Artikli artikalRacun, Date datumRacuna, Date datumNaplateRacuna,
			double poreskaOsnovicaRacuna, double ukupanIznosObracunatogPdvaRacuna, double ukupnaVrednostRacuna) {
		super();
		this.idArtikla = idArtikla;
		this.IdgrupaArtikla = idgrupaArtikla;
		this.naziv_grupe_artikala = naziv_grupe_artikala;
		this.naziv_artikla = naziv_artikla;
		this.jedinica_mere = jedinica_mere;
		this.neto_cena_artikla = neto_cena_artikla;
		this.stopa_PDV = stopa_PDV;
		this.marza_artikla = marza_artikla;
		this.idracunOtpremnica = idracunOtpremnica;
		this.artikal = artikal;
		this.kolicinaProdaje = kolicinaProdaje;
		this.rabatProdaje = rabatProdaje;
		this.idRacuna = idRacuna;
		this.idZaposlenog = idZaposlenog;
		this.idKupca = idKupca;
		this.zaposleni = zaposleni;
		this.kupac = kupac;
		this.artikalRacun = artikalRacun;
		this.datumRacuna = datumRacuna;
		this.datumNaplateRacuna = datumNaplateRacuna;
		this.poreskaOsnovicaRacuna = poreskaOsnovicaRacuna;
		this.ukupanIznosObracunatogPdvaRacuna = ukupanIznosObracunatogPdvaRacuna;
		this.ukupnaVrednostRacuna = ukupnaVrednostRacuna;
	}
	
	public Izvestaj(int idArtikla, int idgrupaArtikla, String naziv_grupe_artikala, String naziv_artikla,
			String jedinica_mere, double neto_cena_artikla, int stopa_PDV, double marza_artikla, int idracunOtpremnica,
			Artikli artikal, double kolicinaProdaje, double rabatProdaje, int idRacuna, int idZaposlenog, int idKupca,
			Zaposleni zaposleni, Kupac kupac, Artikli artikalRacun, Date datumRacuna, Date datumNaplateRacuna,
			double poreskaOsnovicaRacuna, double ukupanIznosObracunatogPdvaRacuna, double ukupnaVrednostRacuna, String statusRacuna) {
		super();
		this.idArtikla = idArtikla;
		IdgrupaArtikla = idgrupaArtikla;
		this.naziv_grupe_artikala = naziv_grupe_artikala;
		this.naziv_artikla = naziv_artikla;
		this.jedinica_mere = jedinica_mere;
		this.neto_cena_artikla = neto_cena_artikla;
		this.stopa_PDV = stopa_PDV;
		this.marza_artikla = marza_artikla;
		this.idracunOtpremnica = idracunOtpremnica;
		this.artikal = artikal;
		this.kolicinaProdaje = kolicinaProdaje;
		this.rabatProdaje = rabatProdaje;
		this.idRacuna = idRacuna;
		this.idZaposlenog = idZaposlenog;
		this.idKupca = idKupca;
		this.zaposleni = zaposleni;
		this.kupac = kupac;
		this.artikalRacun = artikalRacun;
		this.datumRacuna = datumRacuna;
		this.datumNaplateRacuna = datumNaplateRacuna;
		this.poreskaOsnovicaRacuna = poreskaOsnovicaRacuna;
		this.ukupanIznosObracunatogPdvaRacuna = ukupanIznosObracunatogPdvaRacuna;
		this.ukupnaVrednostRacuna = ukupnaVrednostRacuna;
		this.statusRacuna = statusRacuna;
	}
	
	
	
	
	//FILIJALA
	private int idFilijale;
	private String nazivFilijale;
	private String adresaFilijale;
	private String gradOpstinaFilijale;
	private String telefonFilijale;
	private String emailFilijale;
	private int pibFilijale;
	private String tekuciRacunFilijale;
	private String status;
	public int getIdFilijale() {
		return idFilijale;
	}
	public void setIdFilijale(int idFilijale) {
		this.idFilijale = idFilijale;
	}
	public String getNazivFilijale() {
		return nazivFilijale;
	}
	public void setNazivFilijale(String nazivFilijale) {
		this.nazivFilijale = nazivFilijale;
	}
	public String getAdresaFilijale() {
		return adresaFilijale;
	}
	public void setAdresaFilijale(String adresaFilijale) {
		this.adresaFilijale = adresaFilijale;
	}
	public String getGradOpstinaFilijale() {
		return gradOpstinaFilijale;
	}
	public void setGradOpstinaFilijale(String gradOpstinaFilijale) {
		this.gradOpstinaFilijale = gradOpstinaFilijale;
	}
	public String getTelefonFilijale() {
		return telefonFilijale;
	}
	public void setTelefonFilijale(String telefonFilijale) {
		this.telefonFilijale = telefonFilijale;
	}
	public String getEmailFilijale() {
		return emailFilijale;
	}
	public void setEmailFilijale(String emailFilijale) {
		this.emailFilijale = emailFilijale;
	}
	public int getPibFilijale() {
		return pibFilijale;
	}
	public void setPibFilijale(int pibFilijale) {
		this.pibFilijale = pibFilijale;
	}
	public String getTekuciRacunFilijale() {
		return tekuciRacunFilijale;
	}
	public void setTekuciRacunFilijale(String tekuciRacunFilijale) {
		this.tekuciRacunFilijale = tekuciRacunFilijale;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Izvestaj(int idArtikla, int idgrupaArtikla, String naziv_grupe_artikala, String naziv_artikla,
			String jedinica_mere, double neto_cena_artikla, int stopa_PDV, double marza_artikla, int idracunOtpremnica,
			Artikli artikal, double kolicinaProdaje, double rabatProdaje, int idRacuna, int idZaposlenog, int idKupca,
			Zaposleni zaposleni, Kupac kupac, Artikli artikalRacun, Date datumRacuna, Date datumNaplateRacuna,
			double poreskaOsnovicaRacuna, double ukupanIznosObracunatogPdvaRacuna, double ukupnaVrednostRacuna,
			int idFilijale, String nazivFilijale, String adresaFilijale, String gradOpstinaFilijale,
			String telefonFilijale, String emailFilijale, int pibFilijale, String tekuciRacunFilijale, String status) {
		super();
		this.idArtikla = idArtikla;
		IdgrupaArtikla = idgrupaArtikla;
		this.naziv_grupe_artikala = naziv_grupe_artikala;
		this.naziv_artikla = naziv_artikla;
		this.jedinica_mere = jedinica_mere;
		this.neto_cena_artikla = neto_cena_artikla;
		this.stopa_PDV = stopa_PDV;
		this.marza_artikla = marza_artikla;
		this.idracunOtpremnica = idracunOtpremnica;
		this.artikal = artikal;
		this.kolicinaProdaje = kolicinaProdaje;
		this.rabatProdaje = rabatProdaje;
		this.idRacuna = idRacuna;
		this.idZaposlenog = idZaposlenog;
		this.idKupca = idKupca;
		this.zaposleni = zaposleni;
		this.kupac = kupac;
		this.artikalRacun = artikalRacun;
		this.datumRacuna = datumRacuna;
		this.datumNaplateRacuna = datumNaplateRacuna;
		this.poreskaOsnovicaRacuna = poreskaOsnovicaRacuna;
		this.ukupanIznosObracunatogPdvaRacuna = ukupanIznosObracunatogPdvaRacuna;
		this.ukupnaVrednostRacuna = ukupnaVrednostRacuna;
		this.idFilijale = idFilijale;
		this.nazivFilijale = nazivFilijale;
		this.adresaFilijale = adresaFilijale;
		this.gradOpstinaFilijale = gradOpstinaFilijale;
		this.telefonFilijale = telefonFilijale;
		this.emailFilijale = emailFilijale;
		this.pibFilijale = pibFilijale;
		this.tekuciRacunFilijale = tekuciRacunFilijale;
		this.status = status;
	}

	private String nazivFirmeKupca;
	private String adresaKupca;
	private String gradOpstinaKupca;
	private String telefonKupca;
	private String emailKupca;
	private String kontaktOsobaKupca;
	private int pibKupca;
	private String tekuciRacunKupca;
	private int valutaPlacanjaKupca;
	private String statusKupca;
	
	
	
	
	public String getNazivFirmeKupca() {
		return nazivFirmeKupca;
	}
	public void setNazivFirmeKupca(String nazivFirmeKupca) {
		this.nazivFirmeKupca = nazivFirmeKupca;
	}
	public String getAdresaKupca() {
		return adresaKupca;
	}
	public void setAdresaKupca(String adresaKupca) {
		this.adresaKupca = adresaKupca;
	}
	public String getGradOpstinaKupca() {
		return gradOpstinaKupca;
	}
	public void setGradOpstinaKupca(String gradOpstinaKupca) {
		this.gradOpstinaKupca = gradOpstinaKupca;
	}
	public String getTelefonKupca() {
		return telefonKupca;
	}
	public void setTelefonKupca(String telefonKupca) {
		this.telefonKupca = telefonKupca;
	}
	public String getEmailKupca() {
		return emailKupca;
	}
	public void setEmailKupca(String emailKupca) {
		this.emailKupca = emailKupca;
	}
	public String getKontaktOsobaKupca() {
		return kontaktOsobaKupca;
	}
	public void setKontaktOsobaKupca(String kontaktOsobaKupca) {
		this.kontaktOsobaKupca = kontaktOsobaKupca;
	}
	public int getPibKupca() {
		return pibKupca;
	}
	public void setPibKupca(int pibKupca) {
		this.pibKupca = pibKupca;
	}
	public String getTekuciRacunKupca() {
		return tekuciRacunKupca;
	}
	public void setTekuciRacunKupca(String tekuciRacunKupca) {
		this.tekuciRacunKupca = tekuciRacunKupca;
	}
	public int getValutaPlacanjaKupca() {
		return valutaPlacanjaKupca;
	}
	public void setValutaPlacanjaKupca(int valutaPlacanjaKupca) {
		this.valutaPlacanjaKupca = valutaPlacanjaKupca;
	}
	public String getStatusKupca() {
		return statusKupca;
	}
	public void setStatusKupca(String statusKupca) {
		this.statusKupca = statusKupca;
	}
	
	private String imeZaposlenog;
	private String prezimeZaposlenog;
	private String jmbgZaposlenog;
	private String adresaZaposlenog;
	private String gradOpstinaZaposlenog;	
	private String telefonZaposlenog;
	private String emailZaposlenog;
	private String strucnaSpremaZaposlenog;
	private Date datumPocetkaZaposlenja;
	private Date datumZavrsetkaZaposlenja;
	private double plataZaposlenog;	
	private String tipZaposlenja;
	private String usernameZaposlenog;
	private String passwordZaposlenog;
	
	
	
	public String getImeZaposlenog() {
		return imeZaposlenog;
	}
	public void setImeZaposlenog(String imeZaposlenog) {
		this.imeZaposlenog = imeZaposlenog;
	}
	public String getPrezimeZaposlenog() {
		return prezimeZaposlenog;
	}
	public void setPrezimeZaposlenog(String prezimeZaposlenog) {
		this.prezimeZaposlenog = prezimeZaposlenog;
	}
	public String getJmbgZaposlenog() {
		return jmbgZaposlenog;
	}
	public void setJmbgZaposlenog(String jmbgZaposlenog) {
		this.jmbgZaposlenog = jmbgZaposlenog;
	}
	public String getAdresaZaposlenog() {
		return adresaZaposlenog;
	}
	public void setAdresaZaposlenog(String adresaZaposlenog) {
		this.adresaZaposlenog = adresaZaposlenog;
	}
	public String getGradOpstinaZaposlenog() {
		return gradOpstinaZaposlenog;
	}
	public void setGradOpstinaZaposlenog(String gradOpstinaZaposlenog) {
		this.gradOpstinaZaposlenog = gradOpstinaZaposlenog;
	}
	public String getTelefonZaposlenog() {
		return telefonZaposlenog;
	}
	public void setTelefonZaposlenog(String telefonZaposlenog) {
		this.telefonZaposlenog = telefonZaposlenog;
	}
	public String getEmailZaposlenog() {
		return emailZaposlenog;
	}
	public void setEmailZaposlenog(String emailZaposlenog) {
		this.emailZaposlenog = emailZaposlenog;
	}
	public String getStrucnaSpremaZaposlenog() {
		return strucnaSpremaZaposlenog;
	}
	public void setStrucnaSpremaZaposlenog(String strucnaSpremaZaposlenog) {
		this.strucnaSpremaZaposlenog = strucnaSpremaZaposlenog;
	}
	public Date getDatumPocetkaZaposlenja() {
		return datumPocetkaZaposlenja;
	}
	public void setDatumPocetkaZaposlenja(Date datumPocetkaZaposlenja) {
		this.datumPocetkaZaposlenja = datumPocetkaZaposlenja;
	}
	public Date getDatumZavrsetkaZaposlenja() {
		return datumZavrsetkaZaposlenja;
	}
	public void setDatumZavrsetkaZaposlenja(Date datumZavrsetkaZaposlenja) {
		this.datumZavrsetkaZaposlenja = datumZavrsetkaZaposlenja;
	}
	public double getPlataZaposlenog() {
		return plataZaposlenog;
	}
	public void setPlataZaposlenog(double plataZaposlenog) {
		this.plataZaposlenog = plataZaposlenog;
	}
	public String getTipZaposlenja() {
		return tipZaposlenja;
	}
	public void setTipZaposlenja(String tipZaposlenja) {
		this.tipZaposlenja = tipZaposlenja;
	}
	public String getUsernameZaposlenog() {
		return usernameZaposlenog;
	}
	public void setUsernameZaposlenog(String usernameZaposlenog) {
		this.usernameZaposlenog = usernameZaposlenog;
	}
	public String getPasswordZaposlenog() {
		return passwordZaposlenog;
	}
	public void setPasswordZaposlenog(String passwordZaposlenog) {
		this.passwordZaposlenog = passwordZaposlenog;
	}
	
	public Izvestaj(int idFilijale,int idRAcuna2, Date datum_racuna,int IdFirme, String naziv_firme_kupca, String username_zaposlenog,
			String naziv_filijale, String grupa_artikala, int idArtikla2, String naziv_artikla2,
			int koicina_prodaje, double neto_cena_artikla, double marza_artikla, double stopa_pdv_a) {
		
			this.idFilijale = idFilijale;
			this.idRacuna = idRAcuna2;
			this.datumRacuna = datum_racuna;
			this.idKupca = IdFirme;
			this.nazivFirmeKupca = naziv_firme_kupca;
			this.usernameZaposlenog = username_zaposlenog;
			this.nazivFilijale = naziv_filijale;
			this.naziv_grupe_artikala = grupa_artikala;
			this.idArtikla = idArtikla2;
			this.naziv_artikla = naziv_artikla2;
			this.kolicinaProdaje = koicina_prodaje;
			this.neto_cena_artikla = neto_cena_artikla;
			this.marza_artikla = marza_artikla;
			this.stopa_PDV = stopa_pdv_a;
	}
	public Izvestaj(int idZaposlenog,String imeZaposlenog,String prezimeZaposlenog, int idRAcuna2, Date datum_racuna,int IdFirme, String naziv_firme_kupca, String username_zaposlenog,
			String naziv_filijale, String grupa_artikala, int idArtikla2, String naziv_artikla2,
			int koicina_prodaje, double neto_cena_artikla, double marza_artikla, double stopa_pdv_a) {
			
			this.idZaposlenog = idZaposlenog;
			this.imeZaposlenog = imeZaposlenog;
			this.prezimeZaposlenog = prezimeZaposlenog;
		    this.idRacuna = idRAcuna2;
			this.datumRacuna = datum_racuna;
			this.idKupca = IdFirme;
			this.nazivFirmeKupca = naziv_firme_kupca;
			this.usernameZaposlenog = username_zaposlenog;
			this.nazivFilijale = naziv_filijale;
			this.naziv_grupe_artikala = grupa_artikala;
			this.idArtikla = idArtikla2;
			this.naziv_artikla = naziv_artikla2;
			this.kolicinaProdaje = koicina_prodaje;
			this.neto_cena_artikla = neto_cena_artikla;
			this.marza_artikla = marza_artikla;
			this.stopa_PDV = stopa_pdv_a;
	}
	
	public Izvestaj(int idRacunaK,Date  datum_racuna, int IdFirme, String naziv_firme_kupca, String username_zaposlenog,
			String naziv_filijale, String grupa_artikala, int idArtikla, String naziv_artikla, int koicina_prodaje, double neto_cena_artikla,
			double marza_artikla, double stopa_pdv_a) {
		
		this.idRacuna = idRacunaK;
		this.datumRacuna = datum_racuna;
		this.idKupca = IdFirme;
		this.nazivFirmeKupca = naziv_firme_kupca;
		this.usernameZaposlenog = username_zaposlenog;
		this.nazivFilijale = naziv_filijale;
		this.naziv_grupe_artikala = grupa_artikala;
		this.idArtikla = idArtikla;
		this.naziv_artikla = naziv_artikla;
		this.kolicinaProdaje = koicina_prodaje;
		this.neto_cena_artikla = neto_cena_artikla;
		this.marza_artikla = marza_artikla;
		this.stopa_PDV = stopa_pdv_a;
		
	}
	public Izvestaj(String naziv_firme_kupca, String naziv_filijale, Date datumRacuna, int idRacuna,
			double poreska_osnovica_racuna, double ukupan_iznos_obracunatog_pdv_a_racuna, double ukupna_vrednost_racuna) {
		/*naziv, kolicina_prodaje, jedinica_mere, neto_cena_artikla, stopa_PDV, rabatProdaje*/
		this.idRacuna = idRacuna;
		this.datumRacuna = datumRacuna;
		this.nazivFirmeKupca = naziv_firme_kupca;
		this.nazivFilijale = naziv_filijale;
		this.poreskaOsnovicaRacuna = poreska_osnovica_racuna;
		this.ukupanIznosObracunatogPdvaRacuna = ukupan_iznos_obracunatog_pdv_a_racuna;
		this.ukupnaVrednostRacuna = ukupna_vrednost_racuna;
	}
	
	public Izvestaj(String naziv_firme_kupca, String naziv_filijale, Date datumRacuna, int idRacuna,
			double poreska_osnovica_racuna, double ukupan_iznos_obracunatog_pdv_a_racuna, double ukupna_vrednost_racuna, String statusRacuna) {
		/*naziv, kolicina_prodaje, jedinica_mere, neto_cena_artikla, stopa_PDV, rabatProdaje*/
		this.idRacuna = idRacuna;
		this.datumRacuna = datumRacuna;
		this.nazivFirmeKupca = naziv_firme_kupca;
		this.nazivFilijale = naziv_filijale;
		this.poreskaOsnovicaRacuna = poreska_osnovica_racuna;
		this.ukupanIznosObracunatogPdvaRacuna = ukupan_iznos_obracunatog_pdv_a_racuna;
		this.ukupnaVrednostRacuna = ukupna_vrednost_racuna;
		this.statusRacuna = statusRacuna;
	}
	public Izvestaj() {
		super();
		// TODO Auto-generated constructor stub
	}	
	
}
