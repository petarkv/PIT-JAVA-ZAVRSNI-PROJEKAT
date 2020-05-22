package model;

public class StavkeRacunaOtpremnice {
	
	private int idracunOtpremnica;
	private Artikli artikal;
	private double kolicinaProdaje;
	private double rabatProdaje;
	private int idStavkeProdaje;
	
	public StavkeRacunaOtpremnice(int idracunOtpremnica, Artikli artikal, double kolicinaProdaje, double rabatProdaje) {
		super();
		this.idracunOtpremnica= idracunOtpremnica;
		this.artikal = artikal;
		this.kolicinaProdaje = kolicinaProdaje;
		this.rabatProdaje = rabatProdaje;
	}
	

	public StavkeRacunaOtpremnice(int idracunOtpremnica, Artikli artikal, double kolicinaProdaje, double rabatProdaje,
			int idStavkeProdaje) {
		super();
		this.idracunOtpremnica = idracunOtpremnica;
		this.artikal = artikal;
		this.kolicinaProdaje = kolicinaProdaje;
		this.rabatProdaje = rabatProdaje;
		this.idStavkeProdaje = idStavkeProdaje;
	}

	public StavkeRacunaOtpremnice() {
		super();
		// TODO Auto-generated constructor stub
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


	public int getIdStavkeProdaje() {
		return idStavkeProdaje;
	}


	public void setIdStavkeProdaje(int idStavkeProdaje) {
		this.idStavkeProdaje = idStavkeProdaje;
	}
	

}
