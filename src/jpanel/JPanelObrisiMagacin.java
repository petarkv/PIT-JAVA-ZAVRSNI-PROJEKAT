package jpanel;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class JPanelObrisiMagacin extends JPanel {
	private JTextField textFieldIdMagacina;
	private JTextField textFieldNazivMagacinaBrisi;

	/**
	 * Create the panel.
	 */
	public JPanelObrisiMagacin() {
		setLayout(null);

		JPanel panelObrisiMagacin = new JPanel();
		panelObrisiMagacin.setBorder(
				new TitledBorder(null, "Obrisi magacin", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelObrisiMagacin.setBounds(10, 11, 430, 278);
		add(panelObrisiMagacin);
		panelObrisiMagacin.setLayout(null);

		JLabel lblUnesiIdMagacina = new JLabel("Unesite ID magacina :");
		lblUnesiIdMagacina.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUnesiIdMagacina.setBounds(72, 56, 161, 28);
		panelObrisiMagacin.add(lblUnesiIdMagacina);

		textFieldIdMagacina = new JTextField();
		textFieldIdMagacina.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldIdMagacina.setBounds(72, 106, 55, 20);
		panelObrisiMagacin.add(textFieldIdMagacina);
		textFieldIdMagacina.setColumns(10);

		JButton btnOtvoriMagacin = new JButton("Otvori magacin");
		btnOtvoriMagacin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnOtvoriMagacin.setBounds(72, 196, 143, 23);
		panelObrisiMagacin.add(btnOtvoriMagacin);

		JButton btnURedu = new JButton("U redu");
		btnURedu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnURedu.setBounds(178, 107, 73, 23);
		panelObrisiMagacin.add(btnURedu);

		textFieldNazivMagacinaBrisi = new JTextField();
		textFieldNazivMagacinaBrisi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldNazivMagacinaBrisi.setBounds(72, 155, 179, 20);
		panelObrisiMagacin.add(textFieldNazivMagacinaBrisi);
		textFieldNazivMagacinaBrisi.setColumns(10);

	}

}
