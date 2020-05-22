package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Filijala;
import model.Kupac;

public class DAOKupac {
	
	private Connection konekcija = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet rs = null;

	private void connect() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		konekcija = DriverManager.getConnection("jdbc:mysql://localhost/veleprodaja", "root", "");
	}

	public ArrayList<Kupac> getKupac() throws ClassNotFoundException, SQLException {
		ArrayList<Kupac> lista = new ArrayList<Kupac>();

		connect();
		preparedStatement = konekcija.prepareStatement("select * from kupac");

		preparedStatement.execute();
		rs = preparedStatement.getResultSet();

		while (rs.next()) {
			int idKupca = rs.getInt("id_kupca");			
			String nazivFirmeKupca = rs.getString("naziv_firme_kupca");			
			String adresaKupca = rs.getString("adresa_kupca");
			String gradOpstinaKupca = rs.getString("grad_opstina_kupca");			
			String telefonKupca = rs.getString("telefon_kupca");
			String emailKupca = rs.getString("e_mail_kupca");
			String kontaktOsobaKupca = rs.getString("kontakt_osoba_kupca");			
			int pibKupca = rs.getInt("pib_kupca");
			String tekuciRacunKupca = rs.getString("tekuci_racun_kupca");
			int valutaPlacanjaKupca = rs.getInt("valuta_placanja_kupca");
			String statusKupca = rs.getString("status_kupca");
						

			Kupac k = new Kupac(idKupca, nazivFirmeKupca, adresaKupca, gradOpstinaKupca, telefonKupca, emailKupca, kontaktOsobaKupca, pibKupca, tekuciRacunKupca, valutaPlacanjaKupca, statusKupca);

			lista.add(k);
		}
		konekcija.close();
		return lista;
	}

	public void insertKupac(Kupac k) throws SQLException, ClassNotFoundException {
		connect();		

		preparedStatement = konekcija
				.prepareStatement("INSERT INTO kupac (naziv_firme_kupca, adresa_kupca, grad_opstina_kupca, "
		                           +" telefon_kupca, e_mail_kupca, "
						           +" kontakt_osoba_kupca, pib_kupca, tekuci_racun_kupca, "
		                           +" valuta_placanja_kupca, status_kupca)"
						           +" VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

		preparedStatement.setString(1, k.getNazivFirmeKupca());
		preparedStatement.setString(2, k.getAdresaKupca());
		preparedStatement.setString(3, k.getGradOpstinaKupca());
		preparedStatement.setString(4, k.getTelefonKupca());
		preparedStatement.setString(5, k.getEmailKupca());
		preparedStatement.setString(6, k.getKontaktOsobaKupca());
		preparedStatement.setInt(7, k.getPibKupca());
		preparedStatement.setString(8, k.getTekuciRacunKupca());
		preparedStatement.setInt(9, k.getValutaPlacanjaKupca());
		preparedStatement.setString(10, k.getStatusKupca());
		

		preparedStatement.execute();

		konekcija.close();
		
	}
	public void obrisiKupca(int idk) throws ClassNotFoundException, SQLException {
		connect();
		preparedStatement = konekcija.prepareStatement("delete from kupac where id_kupca = ?");

		preparedStatement.setInt(1, idk);

		preparedStatement.execute();

		konekcija.close();
	}
	
	public Kupac getDetaljiKupca(int idk) throws ClassNotFoundException, SQLException {
		
		Kupac k = new Kupac();
		connect();
		
		preparedStatement = konekcija.prepareStatement("SELECT * FROM kupac where id_kupca =?  ");
		
		preparedStatement.setInt(1, idk);
		preparedStatement.execute();
		rs = preparedStatement.getResultSet();
		while (rs.next()) {
			int idKupca = rs.getInt("id_kupca");
			String nazivFirmeKupca = rs.getString("naziv_firme_kupca");
			String adresaKupca = rs.getString("adresa_kupca");
			String gradOpstinaKupca = rs.getString("grad_opstina_kupca");
			String telefonKupca = rs.getString("telefon_kupca");
			String emailKupca = rs.getString("e_mail_kupca");
			String kontaktOsobaKupca = rs.getString("kontakt_osoba_kupca");
			int pibKupca = rs.getInt("pib_kupca");
			String tekuciRacunKupca = rs.getString("tekuci_racun_kupca");
			int valutaPlacanjaKupca = rs.getInt("valuta_placanja_kupca");
			String statusKupca =rs.getString("status_kupca");
			
			Kupac k1 = new Kupac(idKupca, nazivFirmeKupca, adresaKupca, gradOpstinaKupca, telefonKupca, emailKupca, 
					kontaktOsobaKupca, pibKupca, tekuciRacunKupca, valutaPlacanjaKupca, statusKupca);
			k = k1;
		}
		konekcija.close();
		return k;
	}
	
	public void updateKupac(Kupac k) throws SQLException, ClassNotFoundException {
		connect();		

		preparedStatement = konekcija
				.prepareStatement("UPDATE kupac SET naziv_firme_kupca = ?, adresa_kupca = ?, grad_opstina_kupca = ?, "
		                           +" telefon_kupca = ?, e_mail_kupca = ?, "
						           +" kontakt_osoba_kupca = ?, pib_kupca = ?, tekuci_racun_kupca = ?, "
		                           +" valuta_placanja_kupca = ?, status_kupca = ?"
						           +" WHERE id_Kupca = ?");

		preparedStatement.setString(1, k.getNazivFirmeKupca());
		preparedStatement.setString(2, k.getAdresaKupca());
		preparedStatement.setString(3, k.getGradOpstinaKupca());
		preparedStatement.setString(4, k.getTelefonKupca());
		preparedStatement.setString(5, k.getEmailKupca());
		preparedStatement.setString(6, k.getKontaktOsobaKupca());
		preparedStatement.setInt(7, k.getPibKupca());
		preparedStatement.setString(8, k.getTekuciRacunKupca());
		preparedStatement.setInt(9, k.getValutaPlacanjaKupca());
		preparedStatement.setString(10, k.getStatusKupca());
		preparedStatement.setInt(11, k.getIdKupca());

		preparedStatement.execute();

		konekcija.close();
		
	}

}
