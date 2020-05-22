package jpanel;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;

public class JPanelPregledTrenutnoZaposlenih extends JPanel {
	private JTable tableTrenutnoZaposleni;

	/**
	 * Create the panel.
	 */
	public JPanelPregledTrenutnoZaposlenih() {
		setBorder(new TitledBorder(null, "Trenutno Zaposleni", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(null);

		JScrollPane scrollPaneTrenutnoZaposleni = new JScrollPane();
		scrollPaneTrenutnoZaposleni.setBounds(10, 33, 454, 265);
		add(scrollPaneTrenutnoZaposleni);

		tableTrenutnoZaposleni = new JTable();
		scrollPaneTrenutnoZaposleni.setViewportView(tableTrenutnoZaposleni);

		JButton btnIzlazTrenutnoZaposleni = new JButton("Izlaz");
		btnIzlazTrenutnoZaposleni.setBounds(375, 322, 89, 23);
		add(btnIzlazTrenutnoZaposleni);

	}

}
