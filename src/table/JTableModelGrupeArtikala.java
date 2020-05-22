package table;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import model.Artikli;
import model.GrupaArtikala;

public class JTableModelGrupeArtikala extends AbstractTableModel{
	
	ArrayList<GrupaArtikala> lista = new ArrayList<GrupaArtikala>();

	public JTableModelGrupeArtikala(ArrayList<GrupaArtikala> lista) {
		super();
		this.lista=lista;
		
	}

	@Override
	public int getColumnCount() {
		
		return 2;
	}

	@Override
	public int getRowCount() {
		
		return lista.size();
	}

	@Override
	public Object getValueAt(int r, int c) {
		
		GrupaArtikala ga = lista.get(r);
		
		switch (c) {
		case 0:
			return ga.getIdGrupeArtikala();
		case 1:
			return ga.getNazivGrupeArtikala();
		default:
			return "Greska!";
		}		
	}
	
	@Override
	public String getColumnName(int c) {
		switch (c) {
		case 0:
			return "ID GRUPE ARTIKALA";
		case 1:
			return "NAZIV GRUPE ARTIKALA";
		default:
			return "Greska!";
		}
	}
	
	public void clear() {
		lista.clear();;
		fireTableDataChanged();
	}
}
