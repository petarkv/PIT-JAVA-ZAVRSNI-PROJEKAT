package table;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import model.RacunOtpremnica;
import model.Zaposleni;

public class JTabelModelZaposleni extends AbstractTableModel{

	ArrayList<Zaposleni> lista = new ArrayList<>();
	
	public JTabelModelZaposleni(ArrayList<Zaposleni> lista) {
		super();
		this.lista = lista;
	}

	@Override
	public int getColumnCount() {
		
		return 14;
	}

	@Override
	public int getRowCount() {

		return lista.size();
	}

	@Override
	public Object getValueAt(int r, int c) {
		Zaposleni z = lista.get(r);
		switch (c) {
		case 0:
			return z.getIdZaposlenog();
		case 1:
			return z.getIdFilijale();
		case 2:
			return z.getImeZaposlenog();
		case 3:
			return z.getPrezimeZaposlenog();
		case 4:
			return z.getAdresaZaposlenog();
		case 5:
			return z.getGradOpstinaZaposlenog();
		case 6:
			return z.getTelefonZaposlenog();
		case 7:
			return z.getEmailZaposlenog();	
		case 8:
			return z.getStrucnaSpremaZaposlenog();
		case 9:
			return z.getDatumPocetkaZaposlenja();
		case 10:
			return z.getDatumZavrsetkaZaposlenja();
		case 11:
			return  z.getPlataZaposlenog();
		case 12:
			return  z.getTipZaposlenja();
		case 13:
			return z.getUsernameZaposlenog();
			

		default:
			return "Greska";
		}
	}
	@Override
	public String getColumnName(int c) {
		
		switch (c) {
		case 0:
			return "ID";
		case 1:
			return "ID FILIJALE";
		case 2:
			return "IME";
		case 3:
			return "PREZIME";
		case 4:
			return "ADRESA";
		case 5:
			return "GRAD/OPŠTINA";
		case 6:
			return "TELEFON";
		case 7:
			return "E-MAIL";	
		case 8:
			return "STRUČNA SPREMA";
		case 9:
			return "DATUM POČETKA UGOVORA";
		case 10:
			return "DATUM ZAVRŠETKA UGOVORA";
		case 11:
			return  "PLATA";
		case 12:
			return  "POZICIJA";
		case 13:
			return "USERNAME";

		default:
			return "Greska";
		}		
	}
	
	public void clear() {
		lista.clear();;
		fireTableDataChanged();
	}

}
