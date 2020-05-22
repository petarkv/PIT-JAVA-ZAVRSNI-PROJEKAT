package model;

public class Kupac {
	
	private int idKupca;
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
	
	
	public Kupac(int idKupca, String nazivFirmeKupca, String adresaKupca, String gradOpstinaKupca, String telefonKupca,
			String emailKupca, String kontaktOsobaKupca, int pibKupca, String tekuciRacunKupca, int valutaPlacanjaKupca,
			String statusKupca) {
		super();
		this.idKupca = idKupca;
		this.nazivFirmeKupca = nazivFirmeKupca;
		this.adresaKupca = adresaKupca;
		this.gradOpstinaKupca = gradOpstinaKupca;
		this.telefonKupca = telefonKupca;
		this.emailKupca = emailKupca;
		this.kontaktOsobaKupca = kontaktOsobaKupca;
		this.pibKupca = pibKupca;
		this.tekuciRacunKupca = tekuciRacunKupca;
		this.valutaPlacanjaKupca = valutaPlacanjaKupca;
		this.statusKupca = statusKupca;
	}


	public Kupac(String nazivFirmeKupca, String adresaKupca, String gradOpstinaKupca, String telefonKupca,
			String emailKupca, String kontaktOsobaKupca, int pibKupca, String tekuciRacunKupca, int valutaPlacanjaKupca,
			String statusKupca) {
		super();
		this.nazivFirmeKupca = nazivFirmeKupca;
		this.adresaKupca = adresaKupca;
		this.gradOpstinaKupca = gradOpstinaKupca;
		this.telefonKupca = telefonKupca;
		this.emailKupca = emailKupca;
		this.kontaktOsobaKupca = kontaktOsobaKupca;
		this.pibKupca = pibKupca;
		this.tekuciRacunKupca = tekuciRacunKupca;
		this.valutaPlacanjaKupca = valutaPlacanjaKupca;
		this.statusKupca = statusKupca;
	}


	public Kupac() {
		super();
		
	}


	public int getIdKupca() {
		return idKupca;
	}


	public void setIdKupca(int idKupca) {
		this.idKupca = idKupca;
	}


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


	@Override
	public String toString() {
		return nazivFirmeKupca + "   ID kupca :" + idKupca;
	}	

}
