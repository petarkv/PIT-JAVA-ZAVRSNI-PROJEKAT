package table;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import model.Izvestaj;
import model.StavkeRacunaOtpremnice;

public class JTableModelStavkeRacunaOtpremnice extends AbstractTableModel {
	
		ArrayList<Izvestaj> lista = new ArrayList<>();
	
	public JTableModelStavkeRacunaOtpremnice(ArrayList<Izvestaj> lista) {
		super();
		this.lista = lista;
	}

	@Override
	public int getColumnCount() {
		
		return 6;
	}

	@Override
	public int getRowCount() {
		
		return lista.size();
	}

	@Override
	public Object getValueAt(int r, int c) {
		
		Izvestaj sro = lista.get(r);
		switch (c) {
		case 0:
			return sro.getNaziv_artikla();
		case 1:
			return sro.getKolicinaProdaje();
		case 2:
			return sro.getJedinica_mere();	
		case 3:
			return sro.getNeto_cena_artikla();
		case 4:
			return sro.getStopa_PDV();	
		case 5:
			return sro.getRabatProdaje();	

		default:
			return "Greska";
		}
		
	}
	
	@Override
	public String getColumnName(int c) {
		
		switch (c) {
		case 0:
			return "Artikal";
		case 1:
			return "Količina";
		case 2:
				return "Jedinica mere";
		case 3:
			return "Neto cena";
		case 4:
			return "PDV";
		case 5:
			return "Rabat";
		
		default:
			return "Greska";
		}		
	}
	
	public void clear() {
		lista.clear();;
		fireTableDataChanged();
	}
	public void updateTable() {
		fireTableDataChanged();
	}

}
