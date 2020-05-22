package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ComboBoxModel;

import jframe.JFrameMagacin;
import model.Magacin;

public class DAOMagacin {

	private Connection konekcija = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet rs = null;

	private void connect() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		konekcija = DriverManager.getConnection("jdbc:mysql://localhost/veleprodaja", "root", "");
	}

	public ArrayList<Magacin> getMagacin() throws ClassNotFoundException, SQLException {
		ArrayList<Magacin> lista = new ArrayList<Magacin>();

		connect();
		preparedStatement = konekcija.prepareStatement("select * from magacin");

		preparedStatement.execute();
		rs = preparedStatement.getResultSet();

		while (rs.next()) {
			int idMagacina = rs.getInt("id_magacina");
			String nazivMagacina = rs.getString("naziv_magacina");
			String adresaMagacina = rs.getString("adresa_magacina");
			String gradOpstinaMagacina = rs.getString("grad_opstina_magacina");
			String telefonMagacina = rs.getString("telefon_magacina");
			String emailMagacina = rs.getString("e_mail_magacina");

			Magacin m = new Magacin(idMagacina, nazivMagacina, adresaMagacina, gradOpstinaMagacina, telefonMagacina, emailMagacina);

			lista.add(m);
		}

		konekcija.close();

		return lista;
	}

	public void insertMagacin(Magacin m) throws SQLException, ClassNotFoundException {
		connect();

		preparedStatement = konekcija.prepareStatement(
				"INSERT INTO magacin (naziv_magacina, adresa_magacina, grad_opstina_magacina, telefon_magacina,e_mail_magacina) VALUES (?, ?, ?, ?, ?)");

		preparedStatement.setString(1, m.getNazivMagacina());
		preparedStatement.setString(2, m.getAdresaMagacina());
		preparedStatement.setString(3, m.getGradOpstinaMagacina());
		preparedStatement.setString(4, m.getTelefonMagacina());
		preparedStatement.setString(5, m.getEmailMagacina());

		preparedStatement.execute();

	}

	public void obrisiMagacin(int idm) throws ClassNotFoundException, SQLException {
		connect();
		preparedStatement = konekcija.prepareStatement("delete from magacin where id_magacina = ?");

		preparedStatement.setInt(1, idm);

		preparedStatement.execute();

		konekcija.close();
	}
	public Magacin getDetaljiMagacina(int idm) throws ClassNotFoundException, SQLException {
		Magacin m = new Magacin();
		connect();
		
		preparedStatement = konekcija.prepareStatement("SELECT * FROM magacin where id_magacina =?  ");
		
		preparedStatement.setInt(1, idm);
		preparedStatement.execute();
		rs = preparedStatement.getResultSet();
		while (rs.next()) {
			int idMagacina = rs.getInt("id_magacina");
			String nazivMagacina = rs.getString("naziv_magacina");
			String adresaMagacina = rs.getString("adresa_magacina");
			String gradOpstinaMagacina = rs.getString("grad_opstina_magacina");
			String telefonMagacina = rs.getString("telefon_magacina");
			String emailMagacina = rs.getString("e_mail_magacina");
			Magacin m1 = new Magacin(idMagacina, nazivMagacina, adresaMagacina, gradOpstinaMagacina, telefonMagacina, emailMagacina);
			m = m1;
		}
		konekcija.close();
		return m;
	}
	
	public void updateMagacin(Magacin m) throws SQLException, ClassNotFoundException {
		connect();

		preparedStatement = konekcija.prepareStatement(
				"UPDATE magacin SET naziv_magacina = ?, adresa_magacina = ?, grad_opstina_magacina = ?, "
				+ "telefon_magacina = ?, e_mail_magacina = ?  WHERE id_magacina = ?");

		preparedStatement.setString(1, m.getNazivMagacina());
		preparedStatement.setString(2, m.getAdresaMagacina());
		preparedStatement.setString(3, m.getGradOpstinaMagacina());
		preparedStatement.setString(4, m.getTelefonMagacina());
		preparedStatement.setString(5, m.getEmailMagacina());
		preparedStatement.setInt(6, m.getIdMagacina());

		preparedStatement.execute();

	}

}
