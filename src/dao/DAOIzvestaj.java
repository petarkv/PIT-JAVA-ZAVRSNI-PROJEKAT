package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import model.Artikli;
import model.Izvestaj;
import model.RacunOtpremnica;

public class DAOIzvestaj {
	
	private Connection konekcija = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet rs = null;

	private void connect() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		konekcija = DriverManager.getConnection("jdbc:mysql://localhost/veleprodaja", "root", "");
	}
	
	public ArrayList<Izvestaj> getStavkeRacunaOtpremniceIzvestaj(int id_racuna) throws ClassNotFoundException, SQLException {
		ArrayList<Izvestaj> lista = new ArrayList<Izvestaj>();
		
		connect();
		preparedStatement = konekcija.prepareStatement("SELECT naziv_artikla,kolicina_prodaje,jedinica_mere,neto_cena_artikla, "
				+ "rabat_prodaje, stopa_pdv_a,stavke_prodaje.id_artikla FROM stavke_prodaje "
				+ "join artikal on stavke_prodaje.id_artikla = artikal.id_artikla WHERE id_racuna = ?");
		
		preparedStatement.setInt(1, id_racuna);
		preparedStatement.execute();

		rs = preparedStatement.getResultSet();

		while (rs.next()) {
			
			String naziv = rs.getString ("naziv_artikla");			
			double kolicina_prodaje = rs.getDouble("kolicina_prodaje");	
			String jedinica_mere = rs.getString("jedinica_mere");
			double neto_cena_artikla = rs.getDouble("neto_cena_artikla");
			int stopa_PDV = rs.getInt("stopa_pdv_a");
			double rabatProdaje = rs.getDouble("rabat_prodaje");
			int Idartikla = rs.getInt("id_artikla");
			
			Izvestaj ga = new Izvestaj(naziv, kolicina_prodaje, jedinica_mere, neto_cena_artikla, stopa_PDV, rabatProdaje, Idartikla);
			
			

			lista.add(ga);
		}
		konekcija.close();
		return lista;
	}
	public ArrayList<Izvestaj> getIzvestajProdajePoFilijali(Integer id_filijale, String d, String d1) throws ClassNotFoundException, SQLException {
		ArrayList<Izvestaj> lista = new ArrayList<Izvestaj>();
		
		connect();
		preparedStatement = konekcija.prepareStatement("SELECT filijala.id_filijale, racun_otpremnica.id_racuna,datum_racuna,"
				+ "kupac.id_kupca,naziv_firme_kupca,username_zaposlenog, naziv_filijale,grupa_artikala.id_grupe_artikala,"
				+ "grupa_artikala.naziv_grupe_artikala,artikal.id_artikla,naziv_artikla, artikal.neto_cena_artikla, "
				+ "artikal.marza_artikla, artikal.stopa_pdv_a, SUM(kolicina_prodaje) "
				+ "FROM racun_otpremnica join stavke_prodaje on racun_otpremnica.id_racuna = stavke_prodaje.id_racuna "
				+ "join kupac on racun_otpremnica.id_kupca = kupac.id_kupca "
				+ "join zaposleni on racun_otpremnica.id_zaposlenog = zaposleni.id_zaposlenog "
				+ "join filijala on zaposleni.id_filijale = filijala.id_filijale "
				+ "join artikal on stavke_prodaje.id_artikla = artikal.id_artikla "
				+ "join grupa_artikala on artikal.id_grupe_artikala = grupa_artikala.id_grupe_artikala"
				+ " WHERE datum_racuna BETWEEN ? and ? and filijala.id_filijale = ? "
				+ "group by stavke_prodaje.id_artikla");
				
		
		preparedStatement.setString(1, d);
		preparedStatement.setString(2, d1);
		preparedStatement.setInt(3,id_filijale);
		
		
		preparedStatement.execute();

		rs = preparedStatement.getResultSet();

		while (rs.next()) {
			
			int idFilijale = rs.getInt("filijala.id_filijale");
			int idRacuna = rs.getInt ("racun_otpremnica.id_racuna");
			Date datum_racuna = rs.getDate("datum_racuna");	
			int IdFirme = rs.getInt("kupac.id_kupca");
			String naziv_firme_kupca = rs.getString("naziv_firme_kupca");
			String username_zaposlenog = rs.getString("username_zaposlenog");
			String naziv_filijale = rs.getString("naziv_filijale");
			String grupa_artikala = rs.getString("grupa_artikala.naziv_grupe_artikala");
			int idArtikla = rs.getInt("artikal.id_artikla");
			String naziv_artikla = rs.getString("naziv_artikla");
			int koicina_prodaje = rs.getInt("SUM(kolicina_prodaje)");
			double neto_cena_artikla = rs.getDouble("artikal.neto_cena_artikla");
			double marza_artikla = rs.getDouble("marza_artikla");
			double stopa_pdv_a = rs.getDouble("artikal.stopa_pdv_a");
			
			Izvestaj ga = new Izvestaj(idFilijale, idRacuna, datum_racuna, IdFirme,
					naziv_firme_kupca, username_zaposlenog, naziv_filijale, grupa_artikala, 
					idArtikla, naziv_artikla, koicina_prodaje, neto_cena_artikla, marza_artikla, stopa_pdv_a);
			

			lista.add(ga);
		}
		konekcija.close();
		return lista;
	}
	
	public ArrayList<Izvestaj> getIzvestajProdajePoFilijaliPoGrupi(Integer id_filijale, Integer id_grupe_artikala, String d, String d1) throws ClassNotFoundException, SQLException {
		ArrayList<Izvestaj> lista = new ArrayList<Izvestaj>();
		
		connect();
		preparedStatement = konekcija.prepareStatement("SELECT filijala.id_filijale, racun_otpremnica.id_racuna,datum_racuna,"
				+ "kupac.id_kupca,naziv_firme_kupca,username_zaposlenog, naziv_filijale,"
				+ "grupa_artikala.id_grupe_artikala,grupa_artikala.naziv_grupe_artikala,artikal.id_artikla,naziv_artikla, "
				+ "artikal.neto_cena_artikla, artikal.marza_artikla, artikal.stopa_pdv_a, SUM(kolicina_prodaje) "
				+ "FROM racun_otpremnica join stavke_prodaje on racun_otpremnica.id_racuna = stavke_prodaje.id_racuna "
				+ "join kupac on racun_otpremnica.id_kupca = kupac.id_kupca "
				+ "join zaposleni on racun_otpremnica.id_zaposlenog = zaposleni.id_zaposlenog "
				+ "join filijala on zaposleni.id_filijale = filijala.id_filijale "
				+ "join artikal on stavke_prodaje.id_artikla = artikal.id_artikla "
				+ "join grupa_artikala on artikal.id_grupe_artikala = grupa_artikala.id_grupe_artikala "
				+ "WHERE datum_racuna BETWEEN ? and ? and filijala.id_filijale = ? and grupa_artikala.id_grupe_artikala =? "
				+ "group by stavke_prodaje.id_artikla");
				
		
		
	
		preparedStatement.setString(1, d);
		preparedStatement.setString(2, d1);
		preparedStatement.setInt(3,id_filijale);
		preparedStatement.setInt(4,id_grupe_artikala);
		preparedStatement.execute();

		rs = preparedStatement.getResultSet();

		while (rs.next()) {
			
			int idFilijale = rs.getInt("filijala.id_filijale");
			int idRacuna = rs.getInt ("racun_otpremnica.id_racuna");
			Date datum_racuna = rs.getDate("datum_racuna");	
			int IdFirme = rs.getInt("kupac.id_kupca");
			String naziv_firme_kupca = rs.getString("naziv_firme_kupca");
			String username_zaposlenog = rs.getString("username_zaposlenog");
			String naziv_filijale = rs.getString("naziv_filijale");
			String grupa_artikala = rs.getString("grupa_artikala.naziv_grupe_artikala");
			int idArtikla = rs.getInt("artikal.id_artikla");
			String naziv_artikla = rs.getString("naziv_artikla");
			int koicina_prodaje = rs.getInt("SUM(kolicina_prodaje)");
			double neto_cena_artikla = rs.getDouble("artikal.neto_cena_artikla");
			double marza_artikla = rs.getDouble("marza_artikla");
			double stopa_pdv_a = rs.getDouble("artikal.stopa_pdv_a");
			
			Izvestaj ga = new Izvestaj(idFilijale, idRacuna, datum_racuna, IdFirme,
					naziv_firme_kupca, username_zaposlenog, naziv_filijale, grupa_artikala, 
					idArtikla, naziv_artikla, koicina_prodaje, neto_cena_artikla, marza_artikla, stopa_pdv_a);
			

			lista.add(ga);
		}
		konekcija.close();
		return lista;
	}
	
	public ArrayList<Izvestaj> getIzvestajProdajePoFilijaliPoGrupiPoArtiklu(Integer id_filijale, Integer id_grupe_artikala, Integer id_artikla, String d, String d1) throws ClassNotFoundException, SQLException {
		ArrayList<Izvestaj> lista = new ArrayList<Izvestaj>();
		
		connect();
		preparedStatement = konekcija.prepareStatement("SELECT filijala.id_filijale, racun_otpremnica.id_racuna,datum_racuna,"
				+ "kupac.id_kupca,naziv_firme_kupca,username_zaposlenog, "
				+ "naziv_filijale,grupa_artikala.id_grupe_artikala,grupa_artikala.naziv_grupe_artikala,artikal.id_artikla,"
				+ "naziv_artikla,artikal.neto_cena_artikla, artikal.marza_artikla, artikal.stopa_pdv_a, "
				+ "SUM(kolicina_prodaje) FROM racun_otpremnica join stavke_prodaje on racun_otpremnica.id_racuna = stavke_prodaje.id_racuna"
				+ " join kupac on racun_otpremnica.id_kupca = kupac.id_kupca join"
				+ " zaposleni on racun_otpremnica.id_zaposlenog = zaposleni.id_zaposlenog join filijala on zaposleni.id_filijale = filijala.id_filijale join"
				+ " artikal on stavke_prodaje.id_artikla = artikal.id_artikla join grupa_artikala on artikal.id_grupe_artikala = grupa_artikala.id_grupe_artikala "
				+ "WHERE datum_racuna BETWEEN ? and ? and filijala.id_filijale = ? and grupa_artikala.id_grupe_artikala = ? and artikal.id_artikla = ? "
				+ "group by stavke_prodaje.id_artikla=artikal.id_artikla");
				
		
		
	
		preparedStatement.setString(1, d);
		preparedStatement.setString(2, d1);
		preparedStatement.setInt(3,id_filijale);
	    preparedStatement.setInt(4,id_grupe_artikala);
	    preparedStatement.setInt(5,id_artikla);
	    
		preparedStatement.execute();

		rs = preparedStatement.getResultSet();

		while (rs.next()) {
			
			int idFilijale = rs.getInt("filijala.id_filijale");
			int idRacuna = rs.getInt ("racun_otpremnica.id_racuna");
			Date datum_racuna = rs.getDate("datum_racuna");	
			int IdFirme = rs.getInt("kupac.id_kupca");
			String naziv_firme_kupca = rs.getString("naziv_firme_kupca");
			String username_zaposlenog = rs.getString("username_zaposlenog");
			String naziv_filijale = rs.getString("naziv_filijale");
			String grupa_artikala = rs.getString("grupa_artikala.naziv_grupe_artikala");
			int idArtikla = rs.getInt("artikal.id_artikla");
			String naziv_artikla = rs.getString("naziv_artikla");
			int koicina_prodaje = rs.getInt("SUM(kolicina_prodaje)");
			double neto_cena_artikla = rs.getDouble("artikal.neto_cena_artikla");
			double marza_artikla = rs.getDouble("marza_artikla");
			double stopa_pdv_a = rs.getDouble("artikal.stopa_pdv_a");
			
			Izvestaj ga = new Izvestaj(idFilijale, idRacuna, datum_racuna, IdFirme,
					naziv_firme_kupca, username_zaposlenog, naziv_filijale, grupa_artikala, 
					idArtikla, naziv_artikla, koicina_prodaje, neto_cena_artikla, marza_artikla, stopa_pdv_a);
			

			lista.add(ga);
		}
		konekcija.close();
		return lista;
	}
	
	
	public ArrayList<Izvestaj> getIzvestajProdajePoKupcu(Integer id_kupca, String d, String d1) throws ClassNotFoundException, SQLException {
		ArrayList<Izvestaj> lista = new ArrayList<Izvestaj>();
		
		connect();
		preparedStatement = konekcija.prepareStatement("SELECT racun_otpremnica.id_racuna, datum_racuna,kupac.id_kupca, naziv_firme_kupca,"
				+ "username_zaposlenog , naziv_filijale, grupa_artikala.naziv_grupe_artikala,artikal.id_artikla, naziv_artikla,"
				+ " artikal.neto_cena_artikla, artikal.marza_artikla, artikal.stopa_pdv_a, SUM(kolicina_prodaje)"
				+ "FROM racun_otpremnica join stavke_prodaje on racun_otpremnica.id_racuna = stavke_prodaje.id_racuna "
				+ "join kupac on racun_otpremnica.id_kupca = kupac.id_kupca join zaposleni on "
				+ "racun_otpremnica.id_zaposlenog = zaposleni.id_zaposlenog join filijala on "
				+ "zaposleni.id_filijale = filijala.id_filijale join artikal on "
				+ "stavke_prodaje.id_artikla = artikal.id_artikla join "
				+ "grupa_artikala on artikal.id_grupe_artikala = "
				+ "grupa_artikala.id_grupe_artikala "
				+ "WHERE datum_racuna BETWEEN ? and ? and kupac.id_kupca = ? "
				+ "group by stavke_prodaje.id_stavke_prodaje");
		
		
		preparedStatement.setString(1, d);
		preparedStatement.setString(2, d1);
		preparedStatement.setInt(3,id_kupca);
		preparedStatement.execute();

		rs = preparedStatement.getResultSet();

		while (rs.next()) {
			
			int idRacuna = rs.getInt ("racun_otpremnica.id_racuna");
			Date datum_racuna = rs.getDate("datum_racuna");	
			int IdFirme = rs.getInt("kupac.id_kupca");
			String naziv_firme_kupca = rs.getString("naziv_firme_kupca");
			String username_zaposlenog = rs.getString("username_zaposlenog");
			String naziv_filijale = rs.getString("naziv_filijale");
			String grupa_artikala = rs.getString("grupa_artikala.naziv_grupe_artikala");
			int idArtikla = rs.getInt("artikal.id_artikla");
			String naziv_artikla = rs.getString("naziv_artikla");
			int koicina_prodaje = rs.getInt("SUM(kolicina_prodaje)");
			double neto_cena_artikla = rs.getDouble("artikal.neto_cena_artikla");
			double marza_artikla = rs.getDouble("marza_artikla");
			double stopa_pdv_a = rs.getDouble("artikal.stopa_pdv_a");
			
			Izvestaj ga = new Izvestaj(idRacuna, datum_racuna, IdFirme, naziv_firme_kupca, username_zaposlenog, naziv_filijale, grupa_artikala, idArtikla, naziv_artikla, koicina_prodaje, neto_cena_artikla, marza_artikla, stopa_pdv_a);
			

			lista.add(ga);
		}
		konekcija.close();
		return lista;
	}
		
		public ArrayList<Izvestaj> getIzvestajProdajePoKupcuPoGrupi(Integer id_kupca, Integer id_grupe_artikala, String d, String d1) throws ClassNotFoundException, SQLException {
			ArrayList<Izvestaj> lista = new ArrayList<Izvestaj>();
			
			connect();
			preparedStatement = konekcija.prepareStatement("SELECT racun_otpremnica.id_racuna, datum_racuna,kupac.id_kupca, naziv_firme_kupca,"
					+ "username_zaposlenog , naziv_filijale, grupa_artikala.naziv_grupe_artikala,artikal.id_artikla, naziv_artikla,"
					+ " artikal.neto_cena_artikla, artikal.marza_artikla, artikal.stopa_pdv_a, SUM(kolicina_prodaje)"
					+ "FROM racun_otpremnica join stavke_prodaje on racun_otpremnica.id_racuna = stavke_prodaje.id_racuna "
					+ "join kupac on racun_otpremnica.id_kupca = kupac.id_kupca join zaposleni on "
					+ "racun_otpremnica.id_zaposlenog = zaposleni.id_zaposlenog join filijala on "
					+ "zaposleni.id_filijale = filijala.id_filijale join artikal on "
					+ "stavke_prodaje.id_artikla = artikal.id_artikla join "
					+ "grupa_artikala on artikal.id_grupe_artikala = "
					+ "grupa_artikala.id_grupe_artikala "
					+ "WHERE datum_racuna BETWEEN ? and ? and kupac.id_kupca = ? and grupa_artikala.id_grupe_artikala = ? "
					+ "group by stavke_prodaje.id_stavke_prodaje");
			
			
			preparedStatement.setString(1, d);
			preparedStatement.setString(2, d1);
			preparedStatement.setInt(3,id_kupca);
			preparedStatement.setInt(4, id_grupe_artikala);
			
			preparedStatement.execute();

			rs = preparedStatement.getResultSet();

			while (rs.next()) {
				
				int idRacuna = rs.getInt ("racun_otpremnica.id_racuna");
				Date datum_racuna = rs.getDate("datum_racuna");	
				int IdFirme = rs.getInt("kupac.id_kupca");
				String naziv_firme_kupca = rs.getString("naziv_firme_kupca");
				String username_zaposlenog = rs.getString("username_zaposlenog");
				String naziv_filijale = rs.getString("naziv_filijale");
				String grupa_artikala = rs.getString("grupa_artikala.naziv_grupe_artikala");
				int idArtikla = rs.getInt("artikal.id_artikla");
				String naziv_artikla = rs.getString("naziv_artikla");
				int koicina_prodaje = rs.getInt("SUM(kolicina_prodaje)");
				double neto_cena_artikla = rs.getDouble("artikal.neto_cena_artikla");
				double marza_artikla = rs.getDouble("marza_artikla");
				double stopa_pdv_a = rs.getDouble("artikal.stopa_pdv_a");
				
				Izvestaj ga = new Izvestaj(idRacuna, datum_racuna, IdFirme, naziv_firme_kupca, username_zaposlenog, naziv_filijale, grupa_artikala, idArtikla, naziv_artikla, koicina_prodaje, neto_cena_artikla, marza_artikla, stopa_pdv_a);
				

				lista.add(ga);
			}
			konekcija.close();
			return lista;		
	}
		
		
		public ArrayList<Izvestaj> getIzvestajProdajePoKupcuPoGrupiPoArtiklu(Integer id_kupca, Integer id_grupe_artikala, Integer id_artikla,String d, String d1) throws ClassNotFoundException, SQLException {
			ArrayList<Izvestaj> lista = new ArrayList<Izvestaj>();
			
			connect();
			preparedStatement = konekcija.prepareStatement("SELECT filijala.id_filijale,"
					+ " racun_otpremnica.id_racuna,datum_racuna,kupac.id_kupca,naziv_firme_kupca,"
					+ "username_zaposlenog, naziv_filijale,grupa_artikala.id_grupe_artikala,"
					+ "grupa_artikala.naziv_grupe_artikala,artikal.id_artikla,naziv_artikla, "
					+ "artikal.neto_cena_artikla, artikal.marza_artikla, artikal.stopa_pdv_a, "
					+ "SUM(kolicina_prodaje) FROM racun_otpremnica "
					+ "join stavke_prodaje on racun_otpremnica.id_racuna = stavke_prodaje.id_racuna "
					+ "join kupac on racun_otpremnica.id_kupca = kupac.id_kupca "
					+ "join zaposleni on racun_otpremnica.id_zaposlenog = zaposleni.id_zaposlenog "
					+ "join filijala on zaposleni.id_filijale = filijala.id_filijale "
					+ "join artikal on stavke_prodaje.id_artikla = artikal.id_artikla "
					+ "join grupa_artikala on artikal.id_grupe_artikala = grupa_artikala.id_grupe_artikala "
					+ "WHERE datum_racuna BETWEEN ? and ? and kupac.id_kupca = ? and grupa_artikala.id_grupe_artikala = ? and artikal.id_artikla = ? "
					+ "group by stavke_prodaje.id_artikla=artikal.id_artikla");
			
			
			preparedStatement.setString(1, d);
			preparedStatement.setString(2, d1);
			preparedStatement.setInt(3,id_kupca);
			preparedStatement.setInt(4, id_grupe_artikala);
			preparedStatement.setInt(5, id_artikla);
			
			preparedStatement.execute();

			rs = preparedStatement.getResultSet();

			while (rs.next()) {
				
				int idRacuna = rs.getInt ("racun_otpremnica.id_racuna");
				Date datum_racuna = rs.getDate("datum_racuna");	
				int IdFirme = rs.getInt("kupac.id_kupca");
				String naziv_firme_kupca = rs.getString("naziv_firme_kupca");
				String username_zaposlenog = rs.getString("username_zaposlenog");
				String naziv_filijale = rs.getString("naziv_filijale");
				String grupa_artikala = rs.getString("grupa_artikala.naziv_grupe_artikala");
				int idArtikla = rs.getInt("artikal.id_artikla");
				String naziv_artikla = rs.getString("naziv_artikla");
				int koicina_prodaje = rs.getInt("SUM(kolicina_prodaje)");
				double neto_cena_artikla = rs.getDouble("artikal.neto_cena_artikla");
				double marza_artikla = rs.getDouble("marza_artikla");
				double stopa_pdv_a = rs.getDouble("artikal.stopa_pdv_a");
				
				Izvestaj ga = new Izvestaj(idRacuna, datum_racuna, IdFirme, naziv_firme_kupca, username_zaposlenog, naziv_filijale, grupa_artikala, idArtikla, naziv_artikla, koicina_prodaje, neto_cena_artikla, marza_artikla, stopa_pdv_a);
				

				lista.add(ga);
			}
			konekcija.close();
			return lista;		
	}
		
		
		
	public ArrayList<Izvestaj> getIzvestajProdajePoZposlenom(Integer id_zaposlenog, String d, String d1) throws ClassNotFoundException, SQLException {
		ArrayList<Izvestaj> lista = new ArrayList<Izvestaj>();
		
		connect();
		preparedStatement = konekcija.prepareStatement("SELECT zaposleni.id_zaposlenog, zaposleni.ime_zaposlenog, "
				+ "zaposleni.prezime_zaposlenog,zaposleni.username_zaposlenog,"
				+ " racun_otpremnica.id_racuna, datum_racuna,kupac.id_kupca, naziv_firme_kupca, "
				+ "naziv_filijale,grupa_artikala.id_grupe_artikala, grupa_artikala.naziv_grupe_artikala,artikal.id_artikla, "
				+ "naziv_artikla, artikal.neto_cena_artikla, artikal.marza_artikla, artikal.stopa_pdv_a, SUM(kolicina_prodaje)"
				+ "FROM racun_otpremnica join stavke_prodaje on racun_otpremnica.id_racuna = stavke_prodaje.id_racuna "
				+ "join kupac on racun_otpremnica.id_kupca = kupac.id_kupca "
				+ "join zaposleni on racun_otpremnica.id_zaposlenog = zaposleni.id_zaposlenog "
				+ "join filijala on zaposleni.id_filijale = filijala.id_filijale "
				+ "join artikal on stavke_prodaje.id_artikla = artikal.id_artikla "
				+ "join grupa_artikala on artikal.id_grupe_artikala = grupa_artikala.id_grupe_artikala"
				+ " WHERE datum_racuna BETWEEN ? and ? and zaposleni.id_zaposlenog = ? "
				+ "group by stavke_prodaje.id_artikla");
		
		
		preparedStatement.setString(1, d);
		preparedStatement.setString(2, d1);
		preparedStatement.setInt(3, id_zaposlenog);
		
		preparedStatement.execute();

		rs = preparedStatement.getResultSet();

		while (rs.next()) {
			
			int idZaposlenog = rs.getInt("zaposleni.id_zaposlenog");
			String imeZaposlenog = rs.getString("zaposleni.ime_zaposlenog");
			String prezimeZaposlenog = rs.getString("zaposleni.prezime_zaposlenog");
			String username_zaposlenog = rs.getString("username_zaposlenog");
			int idRacuna = rs.getInt ("racun_otpremnica.id_racuna");
			Date datum_racuna = rs.getDate("datum_racuna");	
			int IdFirme = rs.getInt("kupac.id_kupca");
			String naziv_firme_kupca = rs.getString("naziv_firme_kupca");
			String naziv_filijale = rs.getString("naziv_filijale");
			String grupa_artikala = rs.getString("grupa_artikala.naziv_grupe_artikala");
			int idArtikla = rs.getInt("artikal.id_artikla");
			String naziv_artikla = rs.getString("naziv_artikla");
			int koicina_prodaje = rs.getInt("SUM(kolicina_prodaje)");
			double neto_cena_artikla = rs.getDouble("artikal.neto_cena_artikla");
			double marza_artikla = rs.getDouble("marza_artikla");
			double stopa_pdv_a = rs.getDouble("artikal.stopa_pdv_a");
			
			Izvestaj ga = new Izvestaj(idZaposlenog, imeZaposlenog, prezimeZaposlenog, 
					idRacuna, datum_racuna, IdFirme, naziv_firme_kupca, username_zaposlenog, 
					naziv_filijale, grupa_artikala, idArtikla, naziv_artikla, koicina_prodaje, 
					neto_cena_artikla, marza_artikla, stopa_pdv_a);
			

			lista.add(ga);
		}
		konekcija.close();
		return lista;
	}
	
	public ArrayList<Izvestaj> getIzvestajProdajePoZposlenomPoGrupi(Integer id_zaposlenog, Integer id_grupe_artikala, String d, String d1) throws ClassNotFoundException, SQLException {
		ArrayList<Izvestaj> lista = new ArrayList<Izvestaj>();
		
		connect();
		preparedStatement = konekcija.prepareStatement("SELECT zaposleni.id_zaposlenog, zaposleni.ime_zaposlenog,"
				+ " zaposleni.prezime_zaposlenog,zaposleni.username_zaposlenog,"
				+ " racun_otpremnica.id_racuna, datum_racuna,kupac.id_kupca, naziv_firme_kupca,"
				+ " naziv_filijale,grupa_artikala.id_grupe_artikala, grupa_artikala.naziv_grupe_artikala,artikal.id_artikla,"
				+ " naziv_artikla, artikal.neto_cena_artikla, artikal.marza_artikla,"
				+ " artikal.stopa_pdv_a, SUM(kolicina_prodaje) "
				+ "FROM racun_otpremnica join stavke_prodaje on racun_otpremnica.id_racuna = stavke_prodaje.id_racuna "
				+ "join kupac on racun_otpremnica.id_kupca = kupac.id_kupca "
				+ "join zaposleni on racun_otpremnica.id_zaposlenog = zaposleni.id_zaposlenog "
				+ "join filijala on zaposleni.id_filijale = filijala.id_filijale "
				+ "join artikal on stavke_prodaje.id_artikla = artikal.id_artikla "
				+ "join grupa_artikala on artikal.id_grupe_artikala = grupa_artikala.id_grupe_artikala "
				+ "WHERE datum_racuna BETWEEN ? and ? and zaposleni.id_zaposlenog = ? and grupa_artikala.id_grupe_artikala = ? "
				+ "group by stavke_prodaje.id_artikla");
		
		preparedStatement.setString(1, d);
		preparedStatement.setString(2, d1);
		preparedStatement.setInt(3,id_zaposlenog);
		preparedStatement.setInt(4,id_grupe_artikala);
		
		preparedStatement.execute();

		rs = preparedStatement.getResultSet();

		while (rs.next()) {
			
			int idZaposlenog = rs.getInt("zaposleni.id_zaposlenog");
			String imeZaposlenog = rs.getString("zaposleni.ime_zaposlenog");
			String prezimeZaposlenog = rs.getString("zaposleni.prezime_zaposlenog");
			int idRacuna = rs.getInt ("racun_otpremnica.id_racuna");
			Date datum_racuna = rs.getDate("datum_racuna");	
			int IdFirme = rs.getInt("kupac.id_kupca");
			String naziv_firme_kupca = rs.getString("naziv_firme_kupca");
			String username_zaposlenog = rs.getString("username_zaposlenog");
			String naziv_filijale = rs.getString("naziv_filijale");
			String grupa_artikala = rs.getString("grupa_artikala.naziv_grupe_artikala");
			int idArtikla = rs.getInt("artikal.id_artikla");
			String naziv_artikla = rs.getString("naziv_artikla");
			int koicina_prodaje = rs.getInt("SUM(kolicina_prodaje)");
			double neto_cena_artikla = rs.getDouble("artikal.neto_cena_artikla");
			double marza_artikla = rs.getDouble("marza_artikla");
			double stopa_pdv_a = rs.getDouble("artikal.stopa_pdv_a");
			
			/*Izvestaj ga = new Izvestaj(idZaposlenog, imeZaposlenog, prezimeZaposlenog, 
					idRacuna, datum_racuna, IdFirme, naziv_firme_kupca, username_zaposlenog, 
					naziv_filijale, grupa_artikala, idArtikla, naziv_artikla, koicina_prodaje, 
					neto_cena_artikla, marza_artikla, stopa_pdv_a);*/
			
			Izvestaj ga = new Izvestaj(idZaposlenog, imeZaposlenog, prezimeZaposlenog, idRacuna, 
					datum_racuna, IdFirme, naziv_firme_kupca, username_zaposlenog, naziv_filijale, grupa_artikala, 
					idArtikla, naziv_artikla, koicina_prodaje, neto_cena_artikla, marza_artikla, stopa_pdv_a);
			

			lista.add(ga);
		}
		konekcija.close();
		return lista;
	}
	
	public ArrayList<Izvestaj> getIzvestajProdajePoZposlenomPoGrupiPoArtiklu(Integer id_zaposlenog, Integer id_grupe_artikala, Integer id_artikla, String d, String d1) throws ClassNotFoundException, SQLException {
		ArrayList<Izvestaj> lista = new ArrayList<Izvestaj>();
		
		connect();
		preparedStatement = konekcija.prepareStatement("SELECT zaposleni.id_zaposlenog, zaposleni.ime_zaposlenog,"
				+ " zaposleni.prezime_zaposlenog,zaposleni.username_zaposlenog,"
				+ " racun_otpremnica.id_racuna, datum_racuna,kupac.id_kupca,"
				+ " naziv_firme_kupca, naziv_filijale,grupa_artikala.id_grupe_artikala,"
				+ " grupa_artikala.naziv_grupe_artikala,artikal.id_artikla,"
				+ " naziv_artikla, artikal.neto_cena_artikla,"
				+ " artikal.marza_artikla, artikal.stopa_pdv_a, SUM(kolicina_prodaje) "
				+ "FROM racun_otpremnica join stavke_prodaje on racun_otpremnica.id_racuna = stavke_prodaje.id_racuna "
				+ "join kupac on racun_otpremnica.id_kupca = kupac.id_kupca "
				+ "join zaposleni on racun_otpremnica.id_zaposlenog = zaposleni.id_zaposlenog "
				+ "join filijala on zaposleni.id_filijale = filijala.id_filijale "
				+ "join artikal on stavke_prodaje.id_artikla = artikal.id_artikla "
				+ "join grupa_artikala on artikal.id_grupe_artikala = grupa_artikala.id_grupe_artikala "
				+ "WHERE datum_racuna BETWEEN ? and ? and zaposleni.id_zaposlenog = ? "
				+ "and grupa_artikala.id_grupe_artikala = ? and artikal.id_artikla= ? "
				+ "group by stavke_prodaje.id_artikla");
		
		preparedStatement.setString(1, d);
		preparedStatement.setString(2, d1);
		preparedStatement.setInt(3,id_zaposlenog);
	    preparedStatement.setInt(4,id_grupe_artikala);
	    preparedStatement.setInt(5,id_artikla);
		
		preparedStatement.execute();

		rs = preparedStatement.getResultSet();

		while (rs.next()) {
			
			int idZaposlenog = rs.getInt("zaposleni.id_zaposlenog");
			String imeZaposlenog = rs.getString("zaposleni.ime_zaposlenog");
			String prezimeZaposlenog = rs.getString("zaposleni.prezime_zaposlenog");
			int idRacuna = rs.getInt ("racun_otpremnica.id_racuna");
			Date datum_racuna = rs.getDate("datum_racuna");	
			int IdFirme = rs.getInt("kupac.id_kupca");
			String naziv_firme_kupca = rs.getString("naziv_firme_kupca");
			String username_zaposlenog = rs.getString("username_zaposlenog");
			String naziv_filijale = rs.getString("naziv_filijale");
			String grupa_artikala = rs.getString("grupa_artikala.naziv_grupe_artikala");
			int idArtikla = rs.getInt("artikal.id_artikla");
			String naziv_artikla = rs.getString("naziv_artikla");
			int koicina_prodaje = rs.getInt("SUM(kolicina_prodaje)");
			double neto_cena_artikla = rs.getDouble("artikal.neto_cena_artikla");
			double marza_artikla = rs.getDouble("marza_artikla");
			double stopa_pdv_a = rs.getDouble("artikal.stopa_pdv_a");
			
			Izvestaj ga = new Izvestaj(idZaposlenog, imeZaposlenog, prezimeZaposlenog, 
					idRacuna, datum_racuna, IdFirme, naziv_firme_kupca, username_zaposlenog, 
					naziv_filijale, grupa_artikala, idArtikla, naziv_artikla, koicina_prodaje, 
					neto_cena_artikla, marza_artikla, stopa_pdv_a);
			

			lista.add(ga);
		}
		konekcija.close();
		return lista;
	}
	public ArrayList<Izvestaj> getIzvestajProdajePoKupcuRacun(Integer id_kupca, String d, String d1) throws ClassNotFoundException, SQLException {
		ArrayList<Izvestaj> lista = new ArrayList<Izvestaj>();
		
		connect();
		preparedStatement = konekcija.prepareStatement("SELECT racun_otpremnica.id_racuna, datum_racuna,kupac.id_kupca, naziv_firme_kupca,"
				+ "username_zaposlenog , naziv_filijale, grupa_artikala.naziv_grupe_artikala,artikal.id_artikla, naziv_artikla,"
				+ " artikal.neto_cena_artikla, artikal.marza_artikla, artikal.stopa_pdv_a, SUM(kolicina_prodaje)"
				+ "FROM racun_otpremnica join stavke_prodaje on racun_otpremnica.id_racuna = stavke_prodaje.id_racuna "
				+ "join kupac on racun_otpremnica.id_kupca = kupac.id_kupca join zaposleni on "
				+ "racun_otpremnica.id_zaposlenog = zaposleni.id_zaposlenog join filijala on "
				+ "zaposleni.id_filijale = filijala.id_filijale join artikal on "
				+ "stavke_prodaje.id_artikla = artikal.id_artikla join "
				+ "grupa_artikala on artikal.id_grupe_artikala = "
				+ "grupa_artikala.id_grupe_artikala "
				+ "WHERE datum_racuna BETWEEN ? and ? and kupac.id_kupca = ? "
				+ "group by stavke_prodaje.id_stavke_prodaje, datum_racuna");
		
		
		preparedStatement.setString(1, d);
		preparedStatement.setString(2, d1);
		preparedStatement.setInt(3,id_kupca);
		preparedStatement.execute();

		rs = preparedStatement.getResultSet();

		while (rs.next()) {
			
			int idRacuna = rs.getInt ("racun_otpremnica.id_racuna");
			Date datum_racuna = rs.getDate("datum_racuna");	
			int IdFirme = rs.getInt("kupac.id_kupca");
			String naziv_firme_kupca = rs.getString("naziv_firme_kupca");
			String username_zaposlenog = rs.getString("username_zaposlenog");
			String naziv_filijale = rs.getString("naziv_filijale");
			String grupa_artikala = rs.getString("grupa_artikala.naziv_grupe_artikala");
			int idArtikla = rs.getInt("artikal.id_artikla");
			String naziv_artikla = rs.getString("naziv_artikla");
			int koicina_prodaje = rs.getInt("SUM(kolicina_prodaje)");
			double neto_cena_artikla = rs.getDouble("artikal.neto_cena_artikla");
			double marza_artikla = rs.getDouble("marza_artikla");
			double stopa_pdv_a = rs.getDouble("artikal.stopa_pdv_a");
			
			Izvestaj ga = new Izvestaj(idRacuna, datum_racuna, IdFirme, naziv_firme_kupca, username_zaposlenog, naziv_filijale, grupa_artikala, idArtikla, naziv_artikla, koicina_prodaje, neto_cena_artikla, marza_artikla, stopa_pdv_a);
			

			lista.add(ga);
		}
		konekcija.close();
		return lista;
	}
		
		public ArrayList<Izvestaj> getIzvestajProdajePoKupcuPoGrupiPoRacunu(Integer id_kupca, Integer id_grupe_artikala, String d, String d1) throws ClassNotFoundException, SQLException {
			ArrayList<Izvestaj> lista = new ArrayList<Izvestaj>();
			
			connect();
			preparedStatement = konekcija.prepareStatement("SELECT racun_otpremnica.id_racuna, datum_racuna,kupac.id_kupca, naziv_firme_kupca,"
					+ "username_zaposlenog , naziv_filijale, grupa_artikala.naziv_grupe_artikala,artikal.id_artikla, naziv_artikla,"
					+ " artikal.neto_cena_artikla, artikal.marza_artikla, artikal.stopa_pdv_a, SUM(kolicina_prodaje)"
					+ "FROM racun_otpremnica join stavke_prodaje on racun_otpremnica.id_racuna = stavke_prodaje.id_racuna "
					+ "join kupac on racun_otpremnica.id_kupca = kupac.id_kupca join zaposleni on "
					+ "racun_otpremnica.id_zaposlenog = zaposleni.id_zaposlenog join filijala on "
					+ "zaposleni.id_filijale = filijala.id_filijale join artikal on "
					+ "stavke_prodaje.id_artikla = artikal.id_artikla join "
					+ "grupa_artikala on artikal.id_grupe_artikala = "
					+ "grupa_artikala.id_grupe_artikala "
					+ "WHERE datum_racuna BETWEEN ? and ? and kupac.id_kupca = ? and grupa_artikala.id_grupe_artikala = ? "
					+ "group by stavke_prodaje.id_stavke_prodaje, datum_racuna");
			
			
			preparedStatement.setString(1, d);
			preparedStatement.setString(2, d1);
			preparedStatement.setInt(3,id_kupca);
			preparedStatement.setInt(4, id_grupe_artikala);
			
			preparedStatement.execute();

			rs = preparedStatement.getResultSet();

			while (rs.next()) {
				
				int idRacuna = rs.getInt ("racun_otpremnica.id_racuna");
				Date datum_racuna = rs.getDate("datum_racuna");	
				int IdFirme = rs.getInt("kupac.id_kupca");
				String naziv_firme_kupca = rs.getString("naziv_firme_kupca");
				String username_zaposlenog = rs.getString("username_zaposlenog");
				String naziv_filijale = rs.getString("naziv_filijale");
				String grupa_artikala = rs.getString("grupa_artikala.naziv_grupe_artikala");
				int idArtikla = rs.getInt("artikal.id_artikla");
				String naziv_artikla = rs.getString("naziv_artikla");
				int koicina_prodaje = rs.getInt("SUM(kolicina_prodaje)");
				double neto_cena_artikla = rs.getDouble("artikal.neto_cena_artikla");
				double marza_artikla = rs.getDouble("marza_artikla");
				double stopa_pdv_a = rs.getDouble("artikal.stopa_pdv_a");
				
				Izvestaj ga = new Izvestaj(idRacuna, datum_racuna, IdFirme, naziv_firme_kupca, username_zaposlenog, naziv_filijale, grupa_artikala, idArtikla, naziv_artikla, koicina_prodaje, neto_cena_artikla, marza_artikla, stopa_pdv_a);
				

				lista.add(ga);
			}
			konekcija.close();
			return lista;		
	}
		
		
		public ArrayList<Izvestaj> getIzvestajProdajePoKupcuPoGrupiPoArtikluPoRacunu(Integer id_kupca, Integer id_grupe_artikala, Integer id_artikla,String d, String d1) throws ClassNotFoundException, SQLException {
			ArrayList<Izvestaj> lista = new ArrayList<Izvestaj>();
			
			connect();
			preparedStatement = konekcija.prepareStatement("SELECT filijala.id_filijale,"
					+ " racun_otpremnica.id_racuna,datum_racuna,kupac.id_kupca,naziv_firme_kupca,"
					+ "username_zaposlenog, naziv_filijale,grupa_artikala.id_grupe_artikala,"
					+ "grupa_artikala.naziv_grupe_artikala,artikal.id_artikla,naziv_artikla, "
					+ "artikal.neto_cena_artikla, artikal.marza_artikla, artikal.stopa_pdv_a, "
					+ "SUM(kolicina_prodaje) FROM racun_otpremnica "
					+ "join stavke_prodaje on racun_otpremnica.id_racuna = stavke_prodaje.id_racuna "
					+ "join kupac on racun_otpremnica.id_kupca = kupac.id_kupca "
					+ "join zaposleni on racun_otpremnica.id_zaposlenog = zaposleni.id_zaposlenog "
					+ "join filijala on zaposleni.id_filijale = filijala.id_filijale "
					+ "join artikal on stavke_prodaje.id_artikla = artikal.id_artikla "
					+ "join grupa_artikala on artikal.id_grupe_artikala = grupa_artikala.id_grupe_artikala "
					+ "WHERE datum_racuna BETWEEN ? and ? and kupac.id_kupca = ? and grupa_artikala.id_grupe_artikala = ? and artikal.id_artikla = ? "
					+ "group by stavke_prodaje.id_stavke_prodaje, datum_racuna");
			
			
			preparedStatement.setString(1, d);
			preparedStatement.setString(2, d1);
			preparedStatement.setInt(3,id_kupca);
			preparedStatement.setInt(4, id_grupe_artikala);
			preparedStatement.setInt(5, id_artikla);
			
			preparedStatement.execute();

			rs = preparedStatement.getResultSet();

			while (rs.next()) {
				
				int idRacuna = rs.getInt ("racun_otpremnica.id_racuna");
				Date datum_racuna = rs.getDate("datum_racuna");	
				int IdFirme = rs.getInt("kupac.id_kupca");
				String naziv_firme_kupca = rs.getString("naziv_firme_kupca");
				String username_zaposlenog = rs.getString("username_zaposlenog");
				String naziv_filijale = rs.getString("naziv_filijale");
				String grupa_artikala = rs.getString("grupa_artikala.naziv_grupe_artikala");
				int idArtikla = rs.getInt("artikal.id_artikla");
				String naziv_artikla = rs.getString("naziv_artikla");
				int koicina_prodaje = rs.getInt("SUM(kolicina_prodaje)");
				double neto_cena_artikla = rs.getDouble("artikal.neto_cena_artikla");
				double marza_artikla = rs.getDouble("marza_artikla");
				double stopa_pdv_a = rs.getDouble("artikal.stopa_pdv_a");
				
				Izvestaj ga = new Izvestaj(idRacuna, datum_racuna, IdFirme, naziv_firme_kupca, username_zaposlenog, naziv_filijale, grupa_artikala, idArtikla, naziv_artikla, koicina_prodaje, neto_cena_artikla, marza_artikla, stopa_pdv_a);
				

				lista.add(ga);
			}
			konekcija.close();
			return lista;		
	}
		public ArrayList<Izvestaj> getRacunPregledRacuna(String d, String d1) throws ClassNotFoundException, SQLException {
			ArrayList<Izvestaj> lista = new ArrayList<Izvestaj>();

			connect();
			preparedStatement = konekcija.prepareStatement("SELECT kupac.naziv_firme_kupca,filijala.naziv_filijale,"
					+ " racun_otpremnica.id_racuna,datum_racuna,"
					+ " racun_otpremnica.poreska_osnovica_racuna,racun_otpremnica.ukupan_iznos_obracunatog_pdv_a_racuna,"
					+ " racun_otpremnica.ukupna_vrednost_racuna FROM racun_otpremnica"
					+ " join kupac on racun_otpremnica.id_kupca = kupac.id_kupca "
					+ "join zaposleni on racun_otpremnica.id_zaposlenog = zaposleni.id_zaposlenog "
					+ "join filijala on zaposleni.id_filijale = filijala.id_filijale "
					+ "WHERE racun_otpremnica.datum_racuna BETWEEN ? and ? and racun_otpremnica.status_racuna = \"Aktivan\"");
			
			preparedStatement.setString(1, d);
			preparedStatement.setString(2, d1);
			preparedStatement.execute();

			rs = preparedStatement.getResultSet();

			while (rs.next()) {
				int idRacuna = rs.getInt("id_racuna");
				String naziv_firme_kupca = rs.getString("kupac.naziv_firme_kupca");
				String naziv_filijale = rs.getString("filijala.naziv_filijale");
				Date datumRacuna = rs.getDate("datum_racuna");
				double poreska_osnovica_racuna = rs.getFloat("racun_otpremnica.poreska_osnovica_racuna");
				double ukupan_iznos_obracunatog_pdv_a_racuna = rs.getDouble("racun_otpremnica.ukupan_iznos_obracunatog_pdv_a_racuna");
				double ukupna_vrednost_racuna = rs.getFloat("racun_otpremnica.ukupna_vrednost_racuna");
				Izvestaj ro = new Izvestaj(naziv_firme_kupca, naziv_filijale, datumRacuna, idRacuna, poreska_osnovica_racuna, ukupan_iznos_obracunatog_pdv_a_racuna, ukupna_vrednost_racuna);
				lista.add(ro);
			}
			konekcija.close();
			return lista;

		}
		
		public ArrayList<Izvestaj> getRacunPregledRacunaPoStatusu(String d, String d1) throws ClassNotFoundException, SQLException {
			ArrayList<Izvestaj> lista = new ArrayList<Izvestaj>();

			connect();
			preparedStatement = konekcija.prepareStatement("SELECT kupac.naziv_firme_kupca,filijala.naziv_filijale,"
					+ " racun_otpremnica.id_racuna,datum_racuna,"
					+ " racun_otpremnica.poreska_osnovica_racuna,racun_otpremnica.ukupan_iznos_obracunatog_pdv_a_racuna,"
					+ " racun_otpremnica.ukupna_vrednost_racuna, racun_otpremnica.status_racuna FROM racun_otpremnica"
					+ " join kupac on racun_otpremnica.id_kupca = kupac.id_kupca "
					+ "join zaposleni on racun_otpremnica.id_zaposlenog = zaposleni.id_zaposlenog "
					+ "join filijala on zaposleni.id_filijale = filijala.id_filijale "
					+ "WHERE racun_otpremnica.datum_racuna BETWEEN ? and ?");
			
			preparedStatement.setString(1, d);
			preparedStatement.setString(2, d1);
			//preparedStatement.setString(3, statusRacuna);
			preparedStatement.execute();

			rs = preparedStatement.getResultSet();

			while (rs.next()) {
				int idRacuna = rs.getInt("id_racuna");
				String naziv_firme_kupca = rs.getString("kupac.naziv_firme_kupca");
				String naziv_filijale = rs.getString("filijala.naziv_filijale");
				Date datumRacuna = rs.getDate("datum_racuna");
				double poreska_osnovica_racuna = rs.getFloat("racun_otpremnica.poreska_osnovica_racuna");
				double ukupan_iznos_obracunatog_pdv_a_racuna = rs.getDouble("racun_otpremnica.ukupan_iznos_obracunatog_pdv_a_racuna");
				double ukupna_vrednost_racuna = rs.getFloat("racun_otpremnica.ukupna_vrednost_racuna");
				String status_racuna = rs.getString("racun_otpremnica.status_racuna");
				Izvestaj ro = new Izvestaj(naziv_firme_kupca, naziv_filijale, datumRacuna, idRacuna, poreska_osnovica_racuna, ukupan_iznos_obracunatog_pdv_a_racuna, ukupna_vrednost_racuna, status_racuna);
				lista.add(ro);
			}
			konekcija.close();
			return lista;

		}
		
		public ArrayList<Izvestaj> getRacunPregledRacunaPoStatusuAktivan(String d, String d1) throws ClassNotFoundException, SQLException {
			ArrayList<Izvestaj> lista = new ArrayList<Izvestaj>();

			connect();
			preparedStatement = konekcija.prepareStatement("SELECT kupac.naziv_firme_kupca,filijala.naziv_filijale,"
					+ " racun_otpremnica.id_racuna,datum_racuna,"
					+ " racun_otpremnica.poreska_osnovica_racuna,racun_otpremnica.ukupan_iznos_obracunatog_pdv_a_racuna,"
					+ " racun_otpremnica.ukupna_vrednost_racuna, racun_otpremnica.status_racuna FROM racun_otpremnica"
					+ " join kupac on racun_otpremnica.id_kupca = kupac.id_kupca "
					+ "join zaposleni on racun_otpremnica.id_zaposlenog = zaposleni.id_zaposlenog "
					+ "join filijala on zaposleni.id_filijale = filijala.id_filijale "
					+ "WHERE racun_otpremnica.datum_racuna BETWEEN ? and ? and racun_otpremnica.status_racuna = \"Aktivan\"");
			
			preparedStatement.setString(1, d);
			preparedStatement.setString(2, d1);
			//preparedStatement.setString(3, statusRacuna);
			preparedStatement.execute();

			rs = preparedStatement.getResultSet();

			while (rs.next()) {
				int idRacuna = rs.getInt("id_racuna");
				String naziv_firme_kupca = rs.getString("kupac.naziv_firme_kupca");
				String naziv_filijale = rs.getString("filijala.naziv_filijale");
				Date datumRacuna = rs.getDate("datum_racuna");
				double poreska_osnovica_racuna = rs.getFloat("racun_otpremnica.poreska_osnovica_racuna");
				double ukupan_iznos_obracunatog_pdv_a_racuna = rs.getDouble("racun_otpremnica.ukupan_iznos_obracunatog_pdv_a_racuna");
				double ukupna_vrednost_racuna = rs.getFloat("racun_otpremnica.ukupna_vrednost_racuna");
				String status_racuna = rs.getString("racun_otpremnica.status_racuna");
				Izvestaj ro = new Izvestaj(naziv_firme_kupca, naziv_filijale, datumRacuna, idRacuna, poreska_osnovica_racuna, ukupan_iznos_obracunatog_pdv_a_racuna, ukupna_vrednost_racuna, status_racuna);
				lista.add(ro);
			}
			konekcija.close();
			return lista;

		}
		
		public ArrayList<Izvestaj> getRacunPregledRacunaPoStatusuKreiran(String d, String d1) throws ClassNotFoundException, SQLException {
			ArrayList<Izvestaj> lista = new ArrayList<Izvestaj>();

			connect();
			preparedStatement = konekcija.prepareStatement("SELECT kupac.naziv_firme_kupca,filijala.naziv_filijale,"
					+ " racun_otpremnica.id_racuna,datum_racuna,"
					+ " racun_otpremnica.poreska_osnovica_racuna,racun_otpremnica.ukupan_iznos_obracunatog_pdv_a_racuna,"
					+ " racun_otpremnica.ukupna_vrednost_racuna, racun_otpremnica.status_racuna FROM racun_otpremnica"
					+ " join kupac on racun_otpremnica.id_kupca = kupac.id_kupca "
					+ "join zaposleni on racun_otpremnica.id_zaposlenog = zaposleni.id_zaposlenog "
					+ "join filijala on zaposleni.id_filijale = filijala.id_filijale "
					+ "WHERE racun_otpremnica.datum_racuna BETWEEN ? and ? and racun_otpremnica.status_racuna = \"Kreiran\"");
			
			preparedStatement.setString(1, d);
			preparedStatement.setString(2, d1);
			//preparedStatement.setString(3, statusRacuna);
			preparedStatement.execute();

			rs = preparedStatement.getResultSet();

			while (rs.next()) {
				int idRacuna = rs.getInt("id_racuna");
				String naziv_firme_kupca = rs.getString("kupac.naziv_firme_kupca");
				String naziv_filijale = rs.getString("filijala.naziv_filijale");
				Date datumRacuna = rs.getDate("datum_racuna");
				double poreska_osnovica_racuna = rs.getFloat("racun_otpremnica.poreska_osnovica_racuna");
				double ukupan_iznos_obracunatog_pdv_a_racuna = rs.getDouble("racun_otpremnica.ukupan_iznos_obracunatog_pdv_a_racuna");
				double ukupna_vrednost_racuna = rs.getFloat("racun_otpremnica.ukupna_vrednost_racuna");
				String status_racuna = rs.getString("racun_otpremnica.status_racuna");
				Izvestaj ro = new Izvestaj(naziv_firme_kupca, naziv_filijale, datumRacuna, idRacuna, poreska_osnovica_racuna, ukupan_iznos_obracunatog_pdv_a_racuna, ukupna_vrednost_racuna, status_racuna);
				lista.add(ro);
			}
			konekcija.close();
			return lista;

		}
		
		
		public Date datumValuteRacuna(int id_racuna) throws ClassNotFoundException, SQLException {
			Date d = new Date();

			connect();
			preparedStatement = konekcija.prepareStatement("select * from racun_otpremnica where id_racuna =?");
			preparedStatement.setInt(1, id_racuna);
			preparedStatement.execute();

			rs = preparedStatement.getResultSet();

			while (rs.next()) {
				
				Date datumNaplateRacuna = rs.getDate("datum_naplate_racuna");
				
				d= datumNaplateRacuna;
			}
			konekcija.close();
			return d;
		}
		public Date datumRacuna(int id_racuna) throws ClassNotFoundException, SQLException {
			Date d1 = new Date();

			connect();
			preparedStatement = konekcija.prepareStatement("select * from racun_otpremnica where id_racuna =?");
			preparedStatement.setInt(1, id_racuna);
			preparedStatement.execute();

			rs = preparedStatement.getResultSet();

			while (rs.next()) {
				
				Date datumRacuna = rs.getDate("datum_racuna");
				
				d1= datumRacuna;
			}
			konekcija.close();
			return d1;
		}
}
