package table;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import model.Izvestaj;

public class JTableModelProdajaPoZaposlenom extends AbstractTableModel{

ArrayList<Izvestaj> lista =  new ArrayList<Izvestaj>();
	
	public JTableModelProdajaPoZaposlenom(ArrayList<Izvestaj> lista) {
		super();
		this.lista = lista;
	}

	@Override
	public int getColumnCount() {
		
		return 16;
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
			return ro.getIdZaposlenog();
		case 1: 
			return ro.getImeZaposlenog();
		case 2:
			return ro.getPrezimeZaposlenog();
		case 3: 
			return ro.getUsernameZaposlenog();
		case 4:
			return ro.getNazivFirmeKupca();
		case 5:
			return ro.getNazivFilijale();
		case 6:
			return ro.getNaziv_grupe_artikala();
		case 7:
			return ro.getIdArtikla();
		case 8:
			return ro.getNaziv_artikla();
		case 9:
			return ro.getKolicinaProdaje();
		case 10:
			return ro.getNeto_cena_artikla();
		case 11: 
			return ro.getNeto_cena_artikla()*ro.getKolicinaProdaje();
		case 12:
			return (ro.getNeto_cena_artikla()*ro.getKolicinaProdaje()*ro.getMarza_artikla()/100);
		case 13:
			return (ro.getNeto_cena_artikla()*ro.getKolicinaProdaje()+
					(ro.getNeto_cena_artikla()*ro.getKolicinaProdaje()*ro.getMarza_artikla()/100))/ro.getKolicinaProdaje();
		case 14:
			return ((ro.getNeto_cena_artikla()*ro.getKolicinaProdaje()+
					(ro.getNeto_cena_artikla()*ro.getKolicinaProdaje()*ro.getMarza_artikla()/100))
					/ro.getKolicinaProdaje())*ro.getKolicinaProdaje();
		case 15:
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
			return "IME";
		case 2: 
			return "PREZIME";
		case 3:
			return "USERNAME";
		case 4:
			return "KUPAC";
		case 5: 
			return "FILIJALA";
		case 6:
			return "GRUPA";
		case 7:
			return "ID ARTIKLA";
		case 8:
			return "NAZIV";
		case 9:
			return "KOLICINA";
		case 10:
			return "NABAVNA CENA";
		case 11:
			return "NABAVNA VREDNOST";
		case 12:
			return "MARZA";
		case 13:
			return "PROSECNA PRODAJNA CENA "
					+ "BEZ PDV-A";
		case 14:
			return "PRODAJNA VREDNOST";
		
		case 15:
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

