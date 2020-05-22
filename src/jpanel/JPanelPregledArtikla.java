package jpanel;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;

public class JPanelPregledArtikla extends JPanel {
	private JTable tablePregledArtikla;

	/**
	 * Create the panel.
	 */
	public JPanelPregledArtikla() {
		setBorder(new TitledBorder(null, "Pregled Artikla", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(null);

		JPanel panelSortiranjePregledArtikla = new JPanel();
		panelSortiranjePregledArtikla
				.setBorder(new TitledBorder(null, "Sortiranje", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelSortiranjePregledArtikla.setBounds(64, 29, 417, 49);
		add(panelSortiranjePregledArtikla);
		panelSortiranjePregledArtikla.setLayout(null);

		JRadioButton rdbtnGlavnaGrupaPregledArtikla = new JRadioButton("Glavna grupa");
		rdbtnGlavnaGrupaPregledArtikla.setBounds(6, 20, 109, 23);
		panelSortiranjePregledArtikla.add(rdbtnGlavnaGrupaPregledArtikla);

		JRadioButton rdbtnGrupaArtikalaPregledArtikla = new JRadioButton("Grupa artikala");
		rdbtnGrupaArtikalaPregledArtikla.setBounds(117, 20, 109, 23);
		panelSortiranjePregledArtikla.add(rdbtnGrupaArtikalaPregledArtikla);

		JRadioButton rdbtnArtikalPregledArtikla = new JRadioButton("Artikal");
		rdbtnArtikalPregledArtikla.setBounds(242, 20, 109, 23);
		panelSortiranjePregledArtikla.add(rdbtnArtikalPregledArtikla);

		JScrollPane scrollPanePregledArtikla = new JScrollPane();
		scrollPanePregledArtikla.setBounds(27, 89, 477, 216);
		add(scrollPanePregledArtikla);

		tablePregledArtikla = new JTable();
		scrollPanePregledArtikla.setViewportView(tablePregledArtikla);

		JButton btnIzlazPregledArtikla = new JButton("Izlaz");
		btnIzlazPregledArtikla.setBounds(392, 321, 89, 23);
		add(btnIzlazPregledArtikla);

	}

}
