package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import model.Magacin;
import model.Zaposleni;;

public class DAOZaposleni {
	
	private Connection konekcija = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet rs = null;

	private void connect() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		konekcija = DriverManager.getConnection("jdbc:mysql://localhost/veleprodaja", "root", "");
	}

	public ArrayList<Zaposleni> getZaposleni() throws ClassNotFoundException, SQLException {
		ArrayList<Zaposleni> lista = new ArrayList<Zaposleni>();

		connect();
		preparedStatement = konekcija.prepareStatement("select * from zaposleni");

		preparedStatement.execute();
		rs = preparedStatement.getResultSet();

		while (rs.next()) {
			int idZaposlenog = rs.getInt("id_zaposlenog");
			int idFilijale = rs.getInt("id_filijale");
			String imeZaposlenog = rs.getString("ime_zaposlenog");
			String prezimeZaposlenog = rs.getString("prezime_zaposlenog");
			String jmbgZaposlenog = rs.getString("jmbg_zaposlenog");
			String adresaZaposlenog = rs.getString("adresa_zaposlenog");
			String gradOpstinaZaposlenog = rs.getString("grad_opstina_zaposlenog");			
			String telefonZaposlenog = rs.getString("telefon_zaposlenog");
			String emailZaposlenog = rs.getString("e_mail_zaposlenog");
			String strucnaSpremaZaposlenog = rs.getString("strucna_sprema_zaposlenog");			
			Date datumPocetkaZaposlenja = rs.getDate("datum_pocetka_zaposlenja");
			Date datumZavrsetkaZaposlenja = rs.getDate("datum_zavrsetka_zaposlenja");
			double plataZaposlenog = rs.getDouble("plata_zaposlenog");
			String tipZaposlenja = rs.getString("tip_zaposlenja");
			String usernameZaposlenog = rs.getString("username_zaposlenog");
			String passwordZaposlenog = rs.getString("password_zaposlenog");
						

			Zaposleni z = new Zaposleni(idZaposlenog, idFilijale, imeZaposlenog, prezimeZaposlenog, jmbgZaposlenog, adresaZaposlenog, gradOpstinaZaposlenog, telefonZaposlenog, emailZaposlenog, strucnaSpremaZaposlenog, datumPocetkaZaposlenja, datumZavrsetkaZaposlenja, plataZaposlenog, tipZaposlenja, usernameZaposlenog, passwordZaposlenog);

			lista.add(z);
		}
		konekcija.close();
		return lista;
	}

	public void insertZaposleni(Zaposleni z) throws SQLException, ClassNotFoundException {
		connect();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");

		String datum_poc = sdf.format(z.getDatumPocetkaZaposlenja());
		String datum_zav = sdf.format(z.getDatumZavrsetkaZaposlenja());

		preparedStatement = konekcija
				.prepareStatement("INSERT INTO zaposleni (id_filijale, ime_zaposlenog, prezime_zaposlenog, jmbg_zaposlenog, adresa_zaposlenog, "
		                           +" grad_opstina_zaposlenog, telefon_zaposlenog, e_mail_zaposlenog,"
						           +" strucna_sprema_zaposlenog, datum_pocetka_zaposlenja, datum_zavrsetka_zaposlenja, "
		                           +" plata_zaposlenog, tip_zaposlenja, username_zaposlenog, password_zaposlenog)"
						           +" VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
		
        preparedStatement.setInt(1, z.getIdFilijale());
		preparedStatement.setString(2, z.getImeZaposlenog());
		preparedStatement.setString(3, z.getPrezimeZaposlenog());
		preparedStatement.setString(4, z.getJmbgZaposlenog());
		preparedStatement.setString(5, z.getAdresaZaposlenog());
		preparedStatement.setString(6, z.getGradOpstinaZaposlenog());		
		preparedStatement.setString(7, z.getTelefonZaposlenog());
		preparedStatement.setString(8, z.getEmailZaposlenog());		
		preparedStatement.setString(9, z.getStrucnaSpremaZaposlenog());
		preparedStatement.setString(10, datum_poc);
		preparedStatement.setString(11, datum_zav);
		preparedStatement.setDouble(12, z.getPlataZaposlenog());
		preparedStatement.setString(13, z.getTipZaposlenja());
		preparedStatement.setString(14, z.getUsernameZaposlenog());
		preparedStatement.setString(15, z.getPasswordZaposlenog());

		preparedStatement.execute();

		konekcija.close();
		
	}
	
	public Zaposleni getDetaljiZaposleni(int idz) throws ClassNotFoundException, SQLException {
		Zaposleni z = new Zaposleni();
		connect();
		
		preparedStatement = konekcija.prepareStatement("SELECT * FROM zaposleni where id_zaposlenog =?  ");
		
		preparedStatement.setInt(1, idz);
		preparedStatement.execute();
		rs = preparedStatement.getResultSet();
		while (rs.next()) {
			int idZaposlenog = rs.getInt("id_zaposlenog");
			int idFilijale = rs.getInt("id_filijale");
			String imeZaposlenog = rs.getString("ime_zaposlenog");
			String prezimeZaposlenog = rs.getString("prezime_zaposlenog");
			String jmbgZaposlenog = rs.getString("jmbg_zaposlenog");
			String adresaZaposlenog = rs.getString("adresa_zaposlenog");
			String gradOpstinaZaposlenog = rs.getString("grad_opstina_zaposlenog");			
			String telefonZaposlenog = rs.getString("telefon_zaposlenog");
			String emailZaposlenog = rs.getString("e_mail_zaposlenog");
			String strucnaSpremaZaposlenog = rs.getString("strucna_sprema_zaposlenog");			
			Date datumPocetkaZaposlenja = rs.getDate("datum_pocetka_zaposlenja");
			Date datumZavrsetkaZaposlenja = rs.getDate("datum_zavrsetka_zaposlenja");
			double plataZaposlenog = rs.getDouble("plata_zaposlenog");
			String tipZaposlenja = rs.getString("tip_zaposlenja");
			String usernameZaposlenog = rs.getString("username_zaposlenog");
			String passwordZaposlenog = rs.getString("password_zaposlenog");
			Zaposleni z1 = new Zaposleni(idZaposlenog, idFilijale, imeZaposlenog, prezimeZaposlenog, jmbgZaposlenog, adresaZaposlenog, gradOpstinaZaposlenog, telefonZaposlenog, emailZaposlenog, strucnaSpremaZaposlenog, datumPocetkaZaposlenja, datumZavrsetkaZaposlenja, plataZaposlenog, tipZaposlenja, usernameZaposlenog, passwordZaposlenog);
			z = z1;
		}
		konekcija.close();
		return z;
	}


	public void deleteZaposleni(int idz) throws SQLException, ClassNotFoundException {
		connect();
		preparedStatement = konekcija.prepareStatement("delete from zaposleni where id_zaposlenog = ?");

		preparedStatement.setInt(1, idz);
		
		preparedStatement.execute();
		
		konekcija.close();
		
	}
	
	public void updateZaposleni(Zaposleni z) throws SQLException, ClassNotFoundException {
		connect();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");

		String datum_poc = sdf.format(z.getDatumPocetkaZaposlenja());
		String datum_zav = sdf.format(z.getDatumZavrsetkaZaposlenja());
		
		preparedStatement = konekcija.prepareStatement("UPDATE zaposleni SET id_filijale = ?, ime_zaposlenog = ?, prezime_zaposlenog = ?, "
			                                        	+ "jmbg_zaposlenog = ?, adresa_zaposlenog = ?, "
                                                       +" grad_opstina_zaposlenog = ?, telefon_zaposlenog = ?, e_mail_zaposlenog = ?,"
		                                               +" strucna_sprema_zaposlenog = ?, datum_pocetka_zaposlenja = ?, datum_zavrsetka_zaposlenja = ?, "
                                                       +" plata_zaposlenog = ?, tip_zaposlenja = ?, username_zaposlenog = ?, password_zaposlenog = ?"
		                                               +" WHERE id_zaposlenog = ?");

		
		preparedStatement.setInt(1, z.getIdFilijale());
		preparedStatement.setString(2, z.getImeZaposlenog());
		preparedStatement.setString(3, z.getPrezimeZaposlenog());
		preparedStatement.setString(4, z.getJmbgZaposlenog());
		preparedStatement.setString(5, z.getAdresaZaposlenog());
		preparedStatement.setString(6, z.getGradOpstinaZaposlenog());		
		preparedStatement.setString(7, z.getTelefonZaposlenog());
		preparedStatement.setString(8, z.getEmailZaposlenog());		
		preparedStatement.setString(9, z.getStrucnaSpremaZaposlenog());
		preparedStatement.setString(10, datum_poc);
		preparedStatement.setString(11, datum_zav);
		preparedStatement.setDouble(12, z.getPlataZaposlenog());
		preparedStatement.setString(13, z.getTipZaposlenja());
		preparedStatement.setString(14, z.getUsernameZaposlenog());
		preparedStatement.setString(15, z.getPasswordZaposlenog());
		preparedStatement.setInt(16, z.getIdZaposlenog());
		
				
		preparedStatement.execute();
		
		konekcija.close();
		
	}

}
