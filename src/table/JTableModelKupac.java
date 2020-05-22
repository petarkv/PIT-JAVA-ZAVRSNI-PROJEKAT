package table;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import model.Kupac;
import model.Zaposleni;

public class JTableModelKupac extends AbstractTableModel {
	
	ArrayList<Kupac> lista = new ArrayList<>();
	
	public JTableModelKupac(ArrayList<Kupac> lista) {
		super();
		this.lista = lista;
	}

	@Override
	public int getColumnCount() {
		
		return 11;
	}

	@Override
	public int getRowCount() {

		return lista.size();
	}

	@Override
	public Object getValueAt(int r, int c) {
		
		Kupac k = lista.get(r);
		switch (c) {
		case 0:
			return k.getIdKupca();
		case 1:
			return k.getNazivFirmeKupca();
		case 2:
			return k.getAdresaKupca();
		case 3:
			return k.getGradOpstinaKupca();
		case 4:
			return k.getTelefonKupca();
		case 5:
			return k.getEmailKupca();
		case 6:
			return k.getKontaktOsobaKupca();
		case 7:
			return k.getPibKupca();	
		case 8:
			return k.getTekuciRacunKupca();
		case 9:
			return k.getValutaPlacanjaKupca();
		case 10:
			return k.getStatusKupca();
		
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
			return "NAZIV";
		case 2:
			return "ADRESA";
		case 3:
			return "GRAD/OPŠTINA";
		case 4:
			return "TELEFON";
		case 5:
			return "E-MAIL";
		case 6:
			return "KONTAK OSOBA";
		case 7:
			return "PIB";	
		case 8:
			return "TEKUĆI RAČUN";
		case 9:
			return "VALUTA";
		case 10:
			return "STATUS";
		
		default:
			return "Greska";
		}		
	}
	
	public void clear() {
		lista.clear();;
		fireTableDataChanged();
	}

}