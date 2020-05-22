package table;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import model.Izvestaj;

public class JTableModelProdajaPoFilijali extends AbstractTableModel {

	
	ArrayList<Izvestaj> lista = new ArrayList<>();
	
	public JTableModelProdajaPoFilijali(ArrayList<Izvestaj> lista) {
		super();
		this.lista = lista;
	}

	@Override
	public int getColumnCount() {
		
		return 13;
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
			return ro.getIdFilijale();
		case 1:
			return ro.getNazivFilijale();
		case 2:
			return ro.getNazivFirmeKupca();
		case 3:
			return ro.getNaziv_grupe_artikala();
		case 4:
			return ro.getIdArtikla();
		case 5:
			return ro.getNaziv_artikla();
		case 6:
			return ro.getKolicinaProdaje();
		case 7:
			return ro.getNeto_cena_artikla();
		case 8: 
			return ro.getNeto_cena_artikla()*ro.getKolicinaProdaje();
		case 9:
			return (ro.getNeto_cena_artikla()*ro.getKolicinaProdaje()*ro.getMarza_artikla()/100);
		case 10:
			return (ro.getNeto_cena_artikla()*ro.getKolicinaProdaje()+
					(ro.getNeto_cena_artikla()*ro.getKolicinaProdaje()*ro.getMarza_artikla()/100))/ro.getKolicinaProdaje();
		case 11:
			return ((ro.getNeto_cena_artikla()*ro.getKolicinaProdaje()+
					(ro.getNeto_cena_artikla()*ro.getKolicinaProdaje()*ro.getMarza_artikla()/100))
					/ro.getKolicinaProdaje())*ro.getKolicinaProdaje();
		case 12:
			return (((ro.getNeto_cena_artikla()*ro.getKolicinaProdaje()+
					(ro.getNeto_cena_artikla()*ro.getKolicinaProdaje()*ro.getMarza_artikla()/100))
					/ro.getKolicinaProdaje())*ro.getKolicinaProdaje())*(ro.getStopa_PDV()/100);

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
			return "FILIJALA";
		case 2: 
			return "KUPAC";
		case 3:
			return "GRUPA";
		case 4:
			return "ID ARTIKLA";
		case 5:
			return "NAZIV";
		case 6:
			return "KOLICINA";
		case 7:
			return "NABAVNA CENA";
		case 8:
			return "NABAVNA VREDNOST";
		case 9:
			return "MARZA";
		case 10:
			return "PROSECNA PRODAJNA CENA "
					+ "BEZ PDV-A";
		case 11:
			return "PRODAJNA VREDNOST";
		case 12:
			return "OSNOVICA";

		default:
			return "GRESKA";
		}		
	}
	
	public void clear() {
		lista.clear();;
		fireTableDataChanged();
	}

}
