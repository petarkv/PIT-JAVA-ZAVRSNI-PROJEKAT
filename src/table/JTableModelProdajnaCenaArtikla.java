package table;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import model.Artikli;

public class JTableModelProdajnaCenaArtikla extends AbstractTableModel {
	
	ArrayList<Artikli> lista = new ArrayList<Artikli>();

	public JTableModelProdajnaCenaArtikla(ArrayList<Artikli> lista) {
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
		
		Artikli a = lista.get(r);
		
		switch (c) {
		case 0:
			return a.getNaziv_grupe_artikala();
		case 1:
			return a.getIdArtikla();
		case 2:
			return a.getNaziv_artikla();
		case 3:
			return a.getMarza_artikla();
		case 4:
			return a.getStopa_PDV();
		case 5:
			return a.getNeto_cena_artikla()+(a.getNeto_cena_artikla()*a.getMarza_artikla()/100)+(a.getNeto_cena_artikla()*
					a.getStopa_PDV()/100);
		
		default:
			return "Greska!";
		}
	}
		@Override
		public String getColumnName(int c) {
			switch (c) {
			case 0:
				return "NAZIV GRUPE ARTIKLA";
			case 1:
				return "ID ARTIKLA";
			case 2:
				return "NAZIV ARTIKLA";
			case 3:
					return "MARZA";
			case 4:
				return "PDV";
			case 5:
				return "BRUTO CENA";
			
			default:
				return "Greska!";
	}
		}

}
