package jpanel;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;

public class JPanelKontrolaZalihaPregled extends JPanel {
	private JTable tablePregledZaliha;

	/**
	 * Create the panel.
	 */
	public JPanelKontrolaZalihaPregled() {
		setBorder(new TitledBorder(null, "Pregled Zaliha", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(null);

		JScrollPane scrollPanePregledZaliha = new JScrollPane();
		scrollPanePregledZaliha.setBounds(10, 63, 566, 229);
		add(scrollPanePregledZaliha);

		tablePregledZaliha = new JTable();
		scrollPanePregledZaliha.setViewportView(tablePregledZaliha);

		JButton btnNoviPregledPregledZaliha = new JButton("Novi pregled");
		btnNoviPregledPregledZaliha.setBounds(51, 314, 118, 23);
		add(btnNoviPregledPregledZaliha);

		JButton btnIzlazPregledZaliha = new JButton("Izlaz");
		btnIzlazPregledZaliha.setBounds(443, 314, 103, 23);
		add(btnIzlazPregledZaliha);

	}
}
