package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import model.Izvestaj;
import model.RacunOtpremnica;

public class DAORacunOtpremnica {
	
	private Connection konekcija = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet rs = null;

	private void connect() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		konekcija = DriverManager.getConnection("jdbc:mysql://localhost/veleprodaja", "root", "");
	}

	public ArrayList<RacunOtpremnica> getRacun() throws ClassNotFoundException, SQLException {
		ArrayList<RacunOtpremnica> lista = new ArrayList<RacunOtpremnica>();

		connect();
		preparedStatement = konekcija.prepareStatement("select * from racun_otpremnica");
		preparedStatement.execute();

		rs = preparedStatement.getResultSet();

		while (rs.next()) {
			int idRacuna = rs.getInt("id_racuna");
			int idZaposlenog = rs.getInt("id_zaposlenog");
			int idKupca = rs.getInt("id_kupca");
			Date datumRacuna = rs.getDate("datum_racuna");
			Date datumNaplateRacuna = rs.getDate("datum_naplate_racuna");
			double poreskaOsnovica = rs.getFloat("poreska_osnovica_racuna");
			double ukupnoPdv = rs.getFloat("ukupan_iznos_obracunatog_pdv_a_racuna");
			double ukupnaVrednostRacuna = rs.getFloat("ukupna_vrednost_racuna");
			RacunOtpremnica ro = new RacunOtpremnica(idRacuna, idZaposlenog, idKupca, datumRacuna, datumNaplateRacuna, poreskaOsnovica, ukupnoPdv, ukupnaVrednostRacuna);

			lista.add(ro);
		}
		konekcija.close();
		return lista;

	}
	public int insertRacunOtpremnicu(RacunOtpremnica ro) throws ClassNotFoundException, SQLException {
		connect();
			
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy.MM.dd");
		String datumRacuna = sdf.format(ro.getDatumRacuna());
		String datumNaplateRacuna = sdf1.format(ro.getDatumNaplateRacuna());
		
		
		preparedStatement = konekcija.prepareStatement(
				"insert into racun_otpremnica(\r\n" + 
				"id_zaposlenog, id_kupca, datum_racuna ,\r\n" + 
				"datum_naplate_racuna,  poreska_osnovica_racuna , ukupan_iznos_obracunatog_pdv_a_racuna, \r\n" + 
				"ukupna_vrednost_racuna , \r\n" + 
				"status_racuna  ) values (?,?,?,?,0,0,0,'Kreiran')", Statement.RETURN_GENERATED_KEYS);
		
		preparedStatement.setInt(1, ro.getIdZaposlenog());
		preparedStatement.setInt(2, ro.getIdKupca());
		preparedStatement.setString(3, datumRacuna);
		preparedStatement.setString(4, datumNaplateRacuna);

		preparedStatement.execute();

		int generisanId = -1;

		ResultSet rs = preparedStatement.getGeneratedKeys();
		if (rs.next()) {
			generisanId = rs.getInt(1);
		}

		konekcija.close();

		return generisanId;
	}
	public void updateRacun(int idr, double poreska_osnovica_racuna, double ukupan_iznos_obracunatog_pdv_a_racuna, 
			double ukupna_vrednost_racuna ) throws SQLException, ClassNotFoundException {
		connect();

		preparedStatement = konekcija
				.prepareStatement("UPDATE racun_otpremnica set "
						+ "poreska_osnovica_racuna  = ?, ukupan_iznos_obracunatog_pdv_a_racuna   = ?,"
						+ "ukupna_vrednost_racuna =?, status_racuna = 'Aktivan'  WHERE \r\n" + 
						"id_racuna = ?");

		preparedStatement.setDouble(1, poreska_osnovica_racuna);
		preparedStatement.setDouble(2, ukupan_iznos_obracunatog_pdv_a_racuna);
		preparedStatement.setDouble(3, ukupna_vrednost_racuna);
		preparedStatement.setInt(4, idr);

		preparedStatement.execute();

		konekcija.close();
	}
	
	

}
