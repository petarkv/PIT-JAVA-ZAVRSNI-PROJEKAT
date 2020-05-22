package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.GrupaArtikala;
import model.Izvestaj;
import model.StavkeRacunaOtpremnice;



public class DAOStavkeRacunaOtpremnice {
	
	private Connection konekcija = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet rs = null;

	private void connect() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		konekcija = DriverManager.getConnection("jdbc:mysql://localhost/veleprodaja", "root", "");
	}
	
	public void insertStavkaRacuna(StavkeRacunaOtpremnice sro) throws SQLException, ClassNotFoundException {
		connect();

		preparedStatement = konekcija
				.prepareStatement("insert into stavke_prodaje(\r\n" + 
						"id_racuna, id_artikla, kolicina_prodaje , rabat_prodaje ) values (?,?,?,?)");

		preparedStatement.setInt(1, sro.getIdracunOtpremnica());
		preparedStatement.setInt(2,sro.getArtikal().getIdArtikla());
		preparedStatement.setDouble(3, sro.getKolicinaProdaje());
		preparedStatement.setDouble(4, sro.getRabatProdaje());

		preparedStatement.execute();

		konekcija.close();
	}
	
	public void deleteStavkeRacuna (int idArtikla) throws SQLException, ClassNotFoundException {
		connect();
		preparedStatement = konekcija.prepareStatement("delete from stavke_prodaje where stavke_prodaje.id_artikla = ? ");

		//preparedStatement.setInt(1, idRacuna);
		preparedStatement.setInt(1, idArtikla);
		
		preparedStatement.execute();
		
		konekcija.close();
		
	}
	
	public void updateStavkeRacun(Izvestaj i) throws SQLException, ClassNotFoundException {
		connect();

		preparedStatement = konekcija
				.prepareStatement("UPDATE stavke_prodaje SET kolicina_prodaje = ?, rabat_prodaje = ? "
						+ "WHERE id_stavke_prodaje = ? ");

		preparedStatement.setDouble(1, i.getKolicinaProdaje());
		preparedStatement.setDouble(2, i.getRabatProdaje());		
		preparedStatement.setInt(3, i.getIdStavkeProdaje());

		preparedStatement.execute();

		konekcija.close();
	}
}
