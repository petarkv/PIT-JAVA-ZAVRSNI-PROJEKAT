package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.GrupaArtikala;
import model.Magacin;

public class DAOGrupaArtikala {
	
	private Connection konekcija = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet rs = null;

	private void connect() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		konekcija = DriverManager.getConnection("jdbc:mysql://localhost/veleprodaja", "root", "");
	}
    
	
	public ArrayList<GrupaArtikala> getGrupaArtikala() throws ClassNotFoundException, SQLException
	{
		return getGrupaArtikala(0);
	}
	
	public ArrayList<GrupaArtikala> getGrupaArtikala(int id_grupe_artikla) throws ClassNotFoundException, SQLException {
		ArrayList<GrupaArtikala> lista = new ArrayList<GrupaArtikala>();

		connect();
		
		String select = "select * from grupa_artikala";
		if(id_grupe_artikla > 0)
		{
			select += " where id_grupe_artikala = " + id_grupe_artikla;
		}
		preparedStatement = konekcija.prepareStatement(select);
		
		preparedStatement.execute();
		rs = preparedStatement.getResultSet();

		while (rs.next()) {
			
			int idGrupeArtikala = rs.getInt("id_grupe_artikala");			
			String nazivGrupeArtikala = rs.getString("naziv_grupe_artikala");	
			
			GrupaArtikala ga = new GrupaArtikala(idGrupeArtikala, nazivGrupeArtikala);

			lista.add(ga);
		}
		konekcija.close();
		return lista;
	}

	public void insertGrupaArtikala(GrupaArtikala ga) throws SQLException, ClassNotFoundException {
		connect();
		
		preparedStatement = konekcija
				.prepareStatement("INSERT INTO grupa_artikala (naziv_grupe_artikala) VALUES (?)");
		
		preparedStatement.setString(1, ga.getNazivGrupeArtikala());	
		
		preparedStatement.execute();

		konekcija.close();		
	}
	
	public void deleteGrupaArtikala(int idga) throws SQLException, ClassNotFoundException {
		connect();
		preparedStatement = konekcija.prepareStatement("delete from grupa_artikala where id_grupe_artikala = ?");

		preparedStatement.setInt(1, idga);
		
		preparedStatement.execute();
		
		konekcija.close();
		
	}
	
	public GrupaArtikala getDetaljiGrupeArtikala(int idga) throws ClassNotFoundException, SQLException {
		GrupaArtikala ga = new GrupaArtikala();
		connect();
		
		preparedStatement = konekcija.prepareStatement("SELECT * FROM grupa_artikala where id_grupe_artikala =?  ");
		
		preparedStatement.setInt(1, idga);
		preparedStatement.execute();
		rs = preparedStatement.getResultSet();
		while (rs.next()) {
			int idGrupeArtikala = rs.getInt("id_grupe_artikala");
			String nazivGrupeArtikala = rs.getString("naziv_grupe_artikala");
			
			GrupaArtikala ga1 = new GrupaArtikala(idGrupeArtikala, nazivGrupeArtikala);
			ga = ga1;
		}
		konekcija.close();
		return ga;
	}
	
	public void updateGrupaArtikala(GrupaArtikala ga) throws SQLException, ClassNotFoundException {
		connect();
		
		preparedStatement = konekcija
				.prepareStatement("UPDATE grupa_artikala SET naziv_grupe_artikala = ? WHERE id_grupe_artikala = ?");
		
		preparedStatement.setString(1, ga.getNazivGrupeArtikala());	
		preparedStatement.setInt(2, ga.getIdGrupeArtikala());
		
		preparedStatement.execute();

		konekcija.close();		
	}


}
