package table;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import org.codehaus.groovy.classgen.ReturnAdder;

import model.Izvestaj;

public class JTableModelProdajaPoKupacu extends AbstractTableModel{
	
	ArrayList<Izvestaj> lista =  new ArrayList<Izvestaj>();
	
	public JTableModelProdajaPoKupacu(ArrayList<Izvestaj> lista) {
		super();
		this.lista = lista;
	}

	@Override
	public int getColumnCount() {
		
		return 12;
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
			return ro.getNaziv_grupe_artikala();
		case 3:
			return ro.getIdArtikla();
		case 4:
			return ro.getNaziv_artikla();
		case 5:
			return ro.getKolicinaProdaje();
		case 6:
			return ro.getNeto_cena_artikla();
		case 7: 
			return ro.getNeto_cena_artikla()*ro.getKolicinaProdaje();
		case 8:
			return (ro.getNeto_cena_artikla()*ro.getKolicinaProdaje()*ro.getMarza_artikla()/100);
		case 9:
			return (ro.getNeto_cena_artikla()*ro.getKolicinaProdaje()+
					(ro.getNeto_cena_artikla()*ro.getKolicinaProdaje()*ro.getMarza_artikla()/100))/ro.getKolicinaProdaje();
		case 10:
			return ((ro.getNeto_cena_artikla()*ro.getKolicinaProdaje()+
					(ro.getNeto_cena_artikla()*ro.getKolicinaProdaje()*ro.getMarza_artikla()/100))
					/ro.getKolicinaProdaje())*ro.getKolicinaProdaje();
		case 11:
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
			return "KUPAC";
		case 1: 
			return "FILIJALA";
		case 2:
			return "GRUPA";
		case 3:
			return "ID ARTIKLA";
		case 4:
			return "NAZIV";
		case 5:
			return "KOLICINA";
		case 6:
			return "NABAVNA CENA";
		case 7:
			return "NABAVNA VREDNOST";
		case 8:
			return "MARZA";
		case 9:
			return "PROSECNA PRODAJNA CENA "
					+ "BEZ PDV-A";
		case 10:
			return "PRODAJNA VREDNOST";
		case 11:
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

