package jpanel;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import java.awt.Font;

public class JPanelObrisiFilijalu extends JPanel {
	private JTextField textUnesiIdBrisiFilijale;
	private JTextField textFieldNazivFilijaleObrisi;

	/**
	 * Create the panel.
	 */
	public JPanelObrisiFilijalu() {
		setBorder(new TitledBorder(null, "Obrisi Filijalu", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(null);

		JLabel lblUnesiIdBrisiFilijale = new JLabel("Unesite ID filijale :");
		lblUnesiIdBrisiFilijale.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUnesiIdBrisiFilijale.setBounds(55, 40, 135, 26);
		add(lblUnesiIdBrisiFilijale);

		textUnesiIdBrisiFilijale = new JTextField();
		textUnesiIdBrisiFilijale.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textUnesiIdBrisiFilijale.setColumns(10);
		textUnesiIdBrisiFilijale.setBounds(55, 77, 54, 20);
		add(textUnesiIdBrisiFilijale);

		JButton btnOtvoriBrisiFilijalu = new JButton("Otvori filijalu");
		btnOtvoriBrisiFilijalu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnOtvoriBrisiFilijalu.setBounds(55, 172, 124, 23);
		add(btnOtvoriBrisiFilijalu);

		JButton btnURedu = new JButton("U redu");
		btnURedu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnURedu.setBounds(137, 78, 89, 23);
		add(btnURedu);

		textFieldNazivFilijaleObrisi = new JTextField();
		textFieldNazivFilijaleObrisi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldNazivFilijaleObrisi.setBounds(55, 121, 171, 20);
		add(textFieldNazivFilijaleObrisi);
		textFieldNazivFilijaleObrisi.setColumns(10);

	}
}
