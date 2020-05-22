package report;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Izvestaj;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.swing.JRViewer;

public class JFrameReportAdmin extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameReportAdmin frame = new JFrameReportAdmin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JFrameReportAdmin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		prikaziReport();
	}
	
	private void prikaziReport() {
		IzvestajAdmin model = new IzvestajAdmin();
		List<Map<String, ?>> dataSource = new ArrayList<Map<String,?>>();
		
		for (Izvestaj izvestaj: model.PrikaziSve()) {
			
			Map<String, Object> i = new HashMap<String, Object>();
			i.put("NAZIV", izvestaj.getNaziv_artikla());
			i.put("KOLICINA", izvestaj.getKolicinaProdaje());
			i.put("JM", izvestaj.getJedinica_mere());
			i.put("NETO", izvestaj.getNeto_cena_artikla());
			i.put("PDV", izvestaj.getStopa_PDV());
			i.put("RABAT", izvestaj.getRabatProdaje());
			i.put("ID", izvestaj.getIdArtikla());
			
			dataSource.add(i);
		}
		
		try {
			JRDataSource jrDataSource = new JRBeanCollectionDataSource(dataSource);
			
			String sourceName = "src/report/Racun.jrxml";
			
			JasperReport report = JasperCompileManager.compileReport(sourceName);
			JasperPrint fieldReport = JasperFillManager.fillReport(report, null, jrDataSource);
			this.getContentPane().add(new JRViewer(fieldReport));
			this.pack();
			
		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
	}	

}
