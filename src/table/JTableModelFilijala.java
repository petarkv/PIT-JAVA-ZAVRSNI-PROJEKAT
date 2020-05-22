package table;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import model.Filijala;

public class JTableModelFilijala extends AbstractTableModel {
	
	ArrayList<Filijala> lista = new ArrayList<>();
	
	public  JTableModelFilijala(ArrayList<Filijala> lista) {
		super();
		this.lista = lista;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 9;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return lista.size();
	}

	@Override
	public Object getValueAt(int r, int c) {
		
		Filijala f = lista.get(r);
		switch (c) {
		case 0:
			return f.getIdFilijale();
		case 1:
			return f.getNazivFilijale();
		case 2:
			return f.getAdresaFilijale();
		case 3:
			return f.getGradOpstinaFilijale();
		case 4:
			return f.getTelefonFilijale();
		case 5:
			return f.getEmailFilijale();
		case 6:
			return f.getPibFilijale();
		case 7:
			return f.getTekuciRacunFilijale();	
		case 8:
			return f.getStatus();

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
		case 6:
			return "PIB";
		case 7:
			return "TEKUĆI RAČUN";	
		case 8:
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
