package jpanel;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;

public class JPanelObrisiKupca extends JPanel {
	private JTextField textIDBrisiKupca;
	private JTextField textFieldNazivKupcaBrisi;

	/**
	 * Create the panel.
	 */
	public JPanelObrisiKupca() {
		setBorder(new TitledBorder(null, "Obrisi Kupca", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(null);

		JLabel lblUnesiIdBrisiKupca = new JLabel("Unesite ID kupca :");
		lblUnesiIdBrisiKupca.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUnesiIdBrisiKupca.setBounds(87, 50, 139, 26);
		add(lblUnesiIdBrisiKupca);

		textIDBrisiKupca = new JTextField();
		textIDBrisiKupca.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textIDBrisiKupca.setBounds(87, 87, 57, 20);
		add(textIDBrisiKupca);
		textIDBrisiKupca.setColumns(10);

		JButton btnOtvoriBrisiKupca = new JButton("Otvori Kupca");
		btnOtvoriBrisiKupca.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnOtvoriBrisiKupca.setBounds(87, 186, 124, 23);
		add(btnOtvoriBrisiKupca);

		JButton btnURedu = new JButton("U redu");
		btnURedu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnURedu.setBounds(180, 87, 73, 23);
		add(btnURedu);

		textFieldNazivKupcaBrisi = new JTextField();
		textFieldNazivKupcaBrisi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldNazivKupcaBrisi.setBounds(87, 138, 166, 20);
		add(textFieldNazivKupcaBrisi);
		textFieldNazivKupcaBrisi.setColumns(10);

	}
}
