package table;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import model.Izvestaj;

public class JTableModelPregledRacunaPoStatusu extends AbstractTableModel {
	
ArrayList<Izvestaj> lista = new ArrayList<>();
	
	public JTableModelPregledRacunaPoStatusu(ArrayList<Izvestaj> lista) {
		super();
		this.lista = lista;
	}

	@Override
	public int getColumnCount() {
		
		return 7;
	}

	@Override
	public int getRowCount() {
		
		return lista.size();
	}

	@Override
	public Object getValueAt(int r, int c) {
		Izvestaj ro = lista.get(r);
		switch (c) {
		case 0:
			return ro.getNazivFirmeKupca();
		case 1:
			return ro.getNazivFilijale();
		case 2:
			return ro.getDatumRacuna();
		case 3:
			return ro.getIdRacuna();
		case 4:
			return ro.getPoreskaOsnovicaRacuna();
		case 5:
			return  ro.getUkupanIznosObracunatogPdvaRacuna();
		case 6:
			return ro.getUkupnaVrednostRacuna();
		case 7:
			return ro.getStatusRacuna();

		default:
			return "Greska";
		}
		
	}
	
	@Override
	public String getColumnName(int c) {
		
		switch (c) {
		case 0:
			return "KUPAC";
		case 1:
			return "FILIJALA";	
		case 2:
			return "DATUM RAČUNA";
		case 3:
			return "BROJ RAČUNA";
		case 4:
			return "NETO";
		case 5:
			return "VREDNOST PDV-A";
		case 6:
			return "BRUTO";
		case 7:
			return "STATUS RAČUNA";

		default:
			return "Greska";
		}		
	}
	
	public void clear() {
		lista.clear();;
		fireTableDataChanged();
	}

}

