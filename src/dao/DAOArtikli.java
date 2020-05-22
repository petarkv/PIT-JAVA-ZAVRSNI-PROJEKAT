package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import model.Artikli;
import model.Zaposleni;

public class DAOArtikli {

	private Connection konekcija = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet rs = null;

	private void connect() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		konekcija = DriverManager.getConnection("jdbc:mysql://localhost/veleprodaja", "root", "");
	}
	
	public ArrayList<Artikli> getArtikli(Integer id_grupe_artikala) throws ClassNotFoundException, SQLException {
		ArrayList<Artikli> lista = new ArrayList<Artikli>();

		connect();		
		//preparedStatement = konekcija.prepareStatement("select * from artikal");
		
		String select = "select * from artikal";
		if(id_grupe_artikala > 0) 
		{
			select+=" where id_grupe_artikala=" + id_grupe_artikala.toString();
		}
		
		preparedStatement = konekcija.prepareStatement(select);
		
		preparedStatement.execute();
		rs = preparedStatement.getResultSet();
		

		while (rs.next()) {
			int idArtikla = rs.getInt("id_artikla");
			int idgrupaArtikla = rs.getInt("id_grupe_artikala");
			String naziv_grupe_artikala = rs.getString("naziv_grupe_artikala");
			String naziv_artikla = rs.getString("naziv_artikla");
			String jedinica_mere = rs.getString("jedinica_mere");
			double neto_cena_artikla = rs.getDouble("neto_cena_artikla");
			int stopa_PDV = rs.getInt("stopa_pdv_a");
			double marza_artikla = rs.getDouble("marza_artikla");

			Artikli a = new Artikli(idArtikla, idgrupaArtikla, naziv_grupe_artikala , naziv_artikla, jedinica_mere, neto_cena_artikla,
					stopa_PDV, marza_artikla);
			lista.add(a);
		}
		konekcija.close();
		return lista;
	}
	
	public ArrayList<Artikli> getArtikli(Integer id_grupe_artikala, Integer id_artikla) throws ClassNotFoundException, SQLException {
		ArrayList<Artikli> lista = new ArrayList<Artikli>();

		connect();		
		//preparedStatement = konekcija.prepareStatement("select * from artikal");
		
		String select = "select grupa_artikala.naziv_grupe_artikala as naziv_grupe, artikal.* from artikal inner join grupa_artikala on artikal.id_grupe_artikala = grupa_artikala.id_grupe_artikala";
		if(id_artikla > 0)
		{
			select+=" where id_artikla=" + id_artikla.toString();
		}
		else if(id_grupe_artikala > 0) 
		{
			select+=" where id_grupe_artikala=" + id_grupe_artikala.toString();
		}
		
		preparedStatement = konekcija.prepareStatement(select);
		
		preparedStatement.execute();
		rs = preparedStatement.getResultSet();
		

		while (rs.next()) {
			int idArtikla = rs.getInt("id_artikla");
			int idgrupaArtikla = rs.getInt("id_grupe_artikala");
//			String naziv_grupe_artikala = rs.getString("naziv_grupe_artikala");
			String naziv_grupe_artikala = rs.getString("naziv_grupe");
			String naziv_artikla = rs.getString("naziv_artikla");
			String jedinica_mere = rs.getString("jedinica_mere");
			double neto_cena_artikla = rs.getDouble("neto_cena_artikla");
			int stopa_PDV = rs.getInt("stopa_pdv_a");
			double marza_artikla = rs.getDouble("marza_artikla");

			Artikli a = new Artikli(idArtikla, idgrupaArtikla, naziv_grupe_artikala , naziv_artikla, jedinica_mere, neto_cena_artikla,
					stopa_PDV, marza_artikla);
			lista.add(a);
		}
		konekcija.close();
		return lista;
	}

	public ArrayList<Artikli> getArtikliSVI() throws ClassNotFoundException, SQLException {
		ArrayList<Artikli> lista = new ArrayList<Artikli>();

		connect();		
		preparedStatement = konekcija.prepareStatement("select * from artikal");
		
		preparedStatement.execute();
		rs = preparedStatement.getResultSet();
		

		while (rs.next()) {
			int idArtikla = rs.getInt("id_artikla");
			int idgrupaArtikla = rs.getInt("id_grupe_artikala");
			String naziv_grupe_artikala = rs.getString("naziv_grupe_artikala");
			String naziv_artikla = rs.getString("naziv_artikla");
			String jedinica_mere = rs.getString("jedinica_mere");
			double neto_cena_artikla = rs.getDouble("neto_cena_artikla");
			int stopa_PDV = rs.getInt("stopa_pdv_a");
			double marza_artikla = rs.getDouble("marza_artikla");

			Artikli a = new Artikli(idArtikla, idgrupaArtikla, naziv_grupe_artikala , naziv_artikla, jedinica_mere, neto_cena_artikla,
					stopa_PDV, marza_artikla);
			lista.add(a);
		}
		konekcija.close();
		return lista;
	}

	public void insertArtikli(Artikli a) throws SQLException, ClassNotFoundException {
		connect();

		preparedStatement = konekcija
				.prepareStatement("INSERT INTO artikal (id_grupe_artikala,naziv_grupe_artikala, naziv_artikla, jedinica_mere, neto_cena_artikla,"
						+ " stopa_pdv_a, marza_artikla) VALUES (?,?, ?, ?, ?, ?, ?)");
		
		preparedStatement.setInt(1, a.getIdgrupaArtikla());
		preparedStatement.setString(2, a.getNaziv_grupe_artikala());
		preparedStatement.setString(3, a.getNaziv_artikla());
		preparedStatement.setString(4, a.getJedinica_mere());
		preparedStatement.setDouble(5, a.getNeto_cena_artikla());
		preparedStatement.setInt(6, a.getStopa_PDV());
		preparedStatement.setDouble(7, a.getMarza_artikla());

		preparedStatement.execute();

		//int generisanId = -1;

		//ResultSet rs = preparedStatement.getGeneratedKeys();
		//if (rs.next()) {
			//generisanId = rs.getInt(1);
		//}

		konekcija.close();

		//return generisanId;
	}
	
	public Artikli getDetaljiArtikli(int ida) throws ClassNotFoundException, SQLException {
		Artikli a = new Artikli();
		connect();
		
		preparedStatement = konekcija.prepareStatement("SELECT * FROM artikal where id_artikla =?  ");
		
		preparedStatement.setInt(1, ida);
		preparedStatement.execute();
		rs = preparedStatement.getResultSet();
		while (rs.next()) {
			int idArtikla = rs.getInt("id_artikla");
			int idGrupeArtikala = rs.getInt("id_grupe_artikala");
			String naziv_grupe_artikala = rs.getString("naziv_grupe_artikala");
			String nazivArtikla = rs.getString("naziv_artikla");
			String jedinicaMere = rs.getString("jedinica_mere");
			double netoCenaArtikla = rs.getDouble("neto_cena_artikla");
			int stopaPdva = rs.getInt("stopa_pdv_a");			
			double marzaArtikla = rs.getDouble("marza_artikla");
			
			Artikli a1 = new Artikli(idArtikla, idGrupeArtikala,naziv_grupe_artikala, nazivArtikla, jedinicaMere, netoCenaArtikla, stopaPdva, marzaArtikla);
			a=a1;
		}
		konekcija.close();
		return a;
	}	
	
	public void deleteArtikal(int ida) throws ClassNotFoundException, SQLException {
		connect();
		preparedStatement = konekcija.prepareStatement("delete from artikal where id_artikla = ?");

		preparedStatement.setInt(1, ida);

		preparedStatement.execute();

		konekcija.close();
	}
	
	public void updateArtikli(Artikli a) throws SQLException, ClassNotFoundException {
		connect();

		preparedStatement = konekcija
				.prepareStatement("UPDATE artikal SET id_grupe_artikala = ?, naziv_grupe_artikala = ?, naziv_artikla = ?, "
						+ "jedinica_mere = ?, neto_cena_artikla = ?,"
						+ " stopa_pdv_a = ?, marza_artikla = ?  WHERE id_artikla = ?");
		
		preparedStatement.setInt(1, a.getIdgrupaArtikla());
		preparedStatement.setString(2, a.getNaziv_grupe_artikala());
		preparedStatement.setString(3, a.getNaziv_artikla());
		preparedStatement.setString(4, a.getJedinica_mere());
		preparedStatement.setDouble(5, a.getNeto_cena_artikla());
		preparedStatement.setInt(6, a.getStopa_PDV());
		preparedStatement.setDouble(7, a.getMarza_artikla());
		preparedStatement.setInt(8, a.getIdArtikla());

		preparedStatement.execute();		

		konekcija.close();
		
	}

}
