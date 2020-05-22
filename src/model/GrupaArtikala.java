package model;

public class GrupaArtikala {	
	
	private int idGrupeArtikala;	
	private String nazivGrupeArtikala;
	
	public GrupaArtikala(int idGrupeArtikala, String nazivGrupeArtikala) {
		super();
		this.idGrupeArtikala = idGrupeArtikala;
		this.nazivGrupeArtikala = nazivGrupeArtikala;
	}		

	public GrupaArtikala(String nazivGrupeArtikala) {
		super();
		this.nazivGrupeArtikala = nazivGrupeArtikala;
	}



	public GrupaArtikala() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdGrupeArtikala() {
		return idGrupeArtikala;
	}

	public void setIdGrupeArtikala(int idGrupeArtikala) {
		this.idGrupeArtikala = idGrupeArtikala;
	}

	public String getNazivGrupeArtikala() {
		return nazivGrupeArtikala;
	}

	public void setNazivGrupeArtikala(String nazivGrupeArtikala) {
		this.nazivGrupeArtikala = nazivGrupeArtikala;
	}

	@Override
	public String toString() {
		return nazivGrupeArtikala + "  idGrupeArtikala: " + idGrupeArtikala;
	}
	
}
