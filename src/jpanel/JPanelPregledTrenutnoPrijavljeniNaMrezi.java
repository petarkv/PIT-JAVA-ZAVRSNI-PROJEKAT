package jpanel;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;

public class JPanelPregledTrenutnoPrijavljeniNaMrezi extends JPanel {
	private JTable tableTrenutnoPrijavljeninaMrezi;

	/**
	 * Create the panel.
	 */
	public JPanelPregledTrenutnoPrijavljeniNaMrezi() {
		setBorder(new TitledBorder(null, "Trenutno prijavljeni na mrezi", TitledBorder.LEADING, TitledBorder.TOP, null,
				null));
		setLayout(null);

		JScrollPane scrollPaneTrenutnoPrijavljeniNaMrezi = new JScrollPane();
		scrollPaneTrenutnoPrijavljeniNaMrezi.setBounds(10, 33, 483, 215);
		add(scrollPaneTrenutnoPrijavljeniNaMrezi);

		tableTrenutnoPrijavljeninaMrezi = new JTable();
		scrollPaneTrenutnoPrijavljeniNaMrezi.setViewportView(tableTrenutnoPrijavljeninaMrezi);

		JButton btnIzlazTrenutnoPrijavljeniNaMrezi = new JButton("Izlaz");
		btnIzlazTrenutnoPrijavljeniNaMrezi.setBounds(391, 276, 101, 23);
		add(btnIzlazTrenutnoPrijavljeniNaMrezi);

	}
}
