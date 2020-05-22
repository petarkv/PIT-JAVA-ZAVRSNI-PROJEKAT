package model;

import java.util.Date;

public class Zaposleni {	
	

	private int idZaposlenog;
	private int idFilijale;
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
	
	
	public Zaposleni(int idZaposlenog, int idFilijale, String imeZaposlenog, String prezimeZaposlenog, String jmbgZaposlenog,
			String adresaZaposlenog, String gradOpstinaZaposlenog, String telefonZaposlenog, String emailZaposlenog,
			String strucnaSpremaZaposlenog, Date datumPocetkaZaposlenja, Date datumZavrsetkaZaposlenja,
			double plataZaposlenog, String tipZaposlenja, String usernameZaposlenog,
			String passwordZaposlenog) {
		super();
		this.idZaposlenog = idZaposlenog;
		this.idFilijale = idFilijale;
		this.imeZaposlenog = imeZaposlenog;
		this.prezimeZaposlenog = prezimeZaposlenog;
		this.jmbgZaposlenog = jmbgZaposlenog;
		this.adresaZaposlenog = adresaZaposlenog;
		this.gradOpstinaZaposlenog = gradOpstinaZaposlenog;
		this.telefonZaposlenog = telefonZaposlenog;
		this.emailZaposlenog = emailZaposlenog;
		this.strucnaSpremaZaposlenog = strucnaSpremaZaposlenog;
		this.datumPocetkaZaposlenja = datumPocetkaZaposlenja;
		this.datumZavrsetkaZaposlenja = datumZavrsetkaZaposlenja;
		this.plataZaposlenog = plataZaposlenog;		
		this.tipZaposlenja = tipZaposlenja;
		this.usernameZaposlenog = usernameZaposlenog;
		this.passwordZaposlenog = passwordZaposlenog;
	}


	public Zaposleni(String imeZaposlenog, String prezimeZaposlenog, String jmbgZaposlenog, String adresaZaposlenog,
			String gradOpstinaZaposlenog, String telefonZaposlenog, String emailZaposlenog,
			String strucnaSpremaZaposlenog, Date datumPocetkaZaposlenja, Date datumZavrsetkaZaposlenja,
			double plataZaposlenog, String tipZaposlenja, String usernameZaposlenog,
			String passwordZaposlenog) {
		super();
		this.imeZaposlenog = imeZaposlenog;
		this.prezimeZaposlenog = prezimeZaposlenog;
		this.jmbgZaposlenog = jmbgZaposlenog;
		this.adresaZaposlenog = adresaZaposlenog;
		this.gradOpstinaZaposlenog = gradOpstinaZaposlenog;
		this.telefonZaposlenog = telefonZaposlenog;
		this.emailZaposlenog = emailZaposlenog;
		this.strucnaSpremaZaposlenog = strucnaSpremaZaposlenog;
		this.datumPocetkaZaposlenja = datumPocetkaZaposlenja;
		this.datumZavrsetkaZaposlenja = datumZavrsetkaZaposlenja;
		this.plataZaposlenog = plataZaposlenog;		
		this.tipZaposlenja = tipZaposlenja;
		this.usernameZaposlenog = usernameZaposlenog;
		this.passwordZaposlenog = passwordZaposlenog;
	}


	public Zaposleni(int idFilijale, String imeZaposlenog, String prezimeZaposlenog, String jmbgZaposlenog, String adresaZaposlenog,
			String gradOpstinaZaposlenog, String telefonZaposlenog, String emailZaposlenog,
			String strucnaSpremaZaposlenog, Date datumPocetkaZaposlenja, Date datumZavrsetkaZaposlenja,
			double plataZaposlenog, String tipZaposlenja, String usernameZaposlenog,
			String passwordZaposlenog) {
		super();
		this.idFilijale = idFilijale;
		this.imeZaposlenog = imeZaposlenog;
		this.prezimeZaposlenog = prezimeZaposlenog;
		this.jmbgZaposlenog = jmbgZaposlenog;
		this.adresaZaposlenog = adresaZaposlenog;
		this.gradOpstinaZaposlenog = gradOpstinaZaposlenog;
		this.telefonZaposlenog = telefonZaposlenog;
		this.emailZaposlenog = emailZaposlenog;
		this.strucnaSpremaZaposlenog = strucnaSpremaZaposlenog;
		this.datumPocetkaZaposlenja = datumPocetkaZaposlenja;
		this.datumZavrsetkaZaposlenja = datumZavrsetkaZaposlenja;
		this.plataZaposlenog = plataZaposlenog;		
		this.tipZaposlenja = tipZaposlenja;
		this.usernameZaposlenog = usernameZaposlenog;
		this.passwordZaposlenog = passwordZaposlenog;
	}	

	public Zaposleni() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getIdZaposlenog() {
		return idZaposlenog;
	}


	public void setIdZaposlenog(int idZaposlenog) {
		this.idZaposlenog = idZaposlenog;
	}


	public int getIdFilijale() {
		return idFilijale;
	}


	public void setIdFilijale(int idFilijale) {
		this.idFilijale = idFilijale;
	}


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


	
	public String getJmbgZaposlenog() {
		return jmbgZaposlenog;
	}


	public void setJmbgZaposlenog(String jmbgZaposlenog) {
		this.jmbgZaposlenog = jmbgZaposlenog;
	}


	@Override
	public String toString() {
		return imeZaposlenog + " " + prezimeZaposlenog + " " + "ID: " + idZaposlenog;
	}	
		
}
