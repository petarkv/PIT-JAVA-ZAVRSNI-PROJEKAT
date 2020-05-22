package model;

import java.awt.Component;

public class Magacin {
	
	private int idMagacina;
	private String nazivMagacina;
	private String adresaMagacina;
	private String gradOpstinaMagacina;
	private String telefonMagacina;
	private String emailMagacina;
	
	
	public Magacin(int idMagacina, String nazivMagacina, String adresaMagacina, String gradOpstinaMagacina,
			String telefonMagacina, String emailMagacina) {
		super();
		this.idMagacina = idMagacina;
		this.nazivMagacina = nazivMagacina;
		this.adresaMagacina = adresaMagacina;
		this.gradOpstinaMagacina = gradOpstinaMagacina;
		this.telefonMagacina = telefonMagacina;
		this.emailMagacina = emailMagacina;
	}


	public Magacin(String nazivMagacina, String adresaMagacina, String gradOpstinaMagacina, String telefonMagacina,
			String emailMagacina) {
		super();
		this.nazivMagacina = nazivMagacina;
		this.adresaMagacina = adresaMagacina;
		this.gradOpstinaMagacina = gradOpstinaMagacina;
		this.telefonMagacina = telefonMagacina;
		this.emailMagacina = emailMagacina;
	}


	public Magacin() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getIdMagacina() {
		return idMagacina;
	}

	public void setIdMagacina(int idMagacina) {
		this.idMagacina = idMagacina;
	}


	public String getNazivMagacina() {
		return nazivMagacina;
	}


	public void setNazivMagacina(String nazivMagacina) {
		this.nazivMagacina = nazivMagacina;
	}


	public String getAdresaMagacina() {
		return adresaMagacina;
	}


	public void setAdresaMagacina(String adresaMagacina) {
		this.adresaMagacina = adresaMagacina;
	}


	public String getGradOpstinaMagacina() {
		return gradOpstinaMagacina;
	}


	public void setGradOpstinaMagacina(String gradOpstinaMagacina) {
		this.gradOpstinaMagacina = gradOpstinaMagacina;
	}


	public String getTelefonMagacina() {
		return telefonMagacina;
	}


	public void setTelefonMagacina(String telefonMagacina) {
		this.telefonMagacina = telefonMagacina;
	}


	public String getEmailMagacina() {
		return emailMagacina;
	}


	public void setEmailMagacina(String emailMagacina) {
		this.emailMagacina = emailMagacina;
	}


	@Override
	public String toString() {
		return " "+nazivMagacina + " ID : " + idMagacina + " GRAD/OPSTINA : " + gradOpstinaMagacina;
	}	
	
}
