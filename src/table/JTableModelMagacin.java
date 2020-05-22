package table;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import model.Filijala;
import model.Magacin;

public class JTableModelMagacin extends AbstractTableModel {
	
	ArrayList<Magacin> lista = new ArrayList<>();
	
	public  JTableModelMagacin(ArrayList<Magacin> lista) {
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
		Magacin m = lista.get(r);
		
		switch (c) {
		case 0:
			return m.getIdMagacina();
		case 1:
			return m.getNazivMagacina();
		case 2:
			return m.getAdresaMagacina();
		case 3:
			return m.getGradOpstinaMagacina();
		case 4:
			return m.getTelefonMagacina();
		case 5:
			return m.getEmailMagacina();
		
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
			return "POSLOVNO IME";
		case 2:
			return "ADRESA";
		case 3:
			return "GRAD/OPŠTINA";
		case 4:
			return "TELEFON";
		case 5:
			return "E-MAIL";

		default:
			return "Greska";
		}
	}
	
	public void clear() {
		lista.clear();;
		fireTableDataChanged();
	}
}
