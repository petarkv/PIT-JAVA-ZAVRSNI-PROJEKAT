package report;

import java.sql.SQLException;
import java.util.List;

import org.codehaus.groovy.tools.shell.ParseCode;

import jframe.JFrameRacun_otpreminica;
import kontroler.Kontroler;
import model.Izvestaj;

public class IzvestajAdmin {
	
	public List<Izvestaj> PrikaziSve(){
		
		List<Izvestaj> lista;
		
		try {
			JFrameRacun_otpreminica ro = new JFrameRacun_otpreminica();
			int i =Integer.parseInt(ro.getTextFieldRacunOtpremnicaRacun().getText());
			lista = Kontroler.getInstance().getStavkeRacunaOtpremniceIzvestaj(i);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
