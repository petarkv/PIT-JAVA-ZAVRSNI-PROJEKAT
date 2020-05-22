package jpanel;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class JPanelObrisiArtikal extends JPanel {
	private JTextField textFieldIdArtikla;
	private JTextField textFieldNazivArtiklaBrisi;

	/**
	 * Create the panel.
	 */
	public JPanelObrisiArtikal() {
		setLayout(null);

		JPanel panelObrisiArtikal = new JPanel();
		panelObrisiArtikal.setBorder(
				new TitledBorder(null, "Obrisi artikal", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelObrisiArtikal.setBounds(10, 11, 430, 278);
		add(panelObrisiArtikal);
		panelObrisiArtikal.setLayout(null);

		JLabel lblUnesiteIdArtikla = new JLabel("Unesite ID artikla :");
		lblUnesiteIdArtikla.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUnesiteIdArtikla.setBounds(47, 51, 120, 22);
		panelObrisiArtikal.add(lblUnesiteIdArtikla);

		textFieldIdArtikla = new JTextField();
		textFieldIdArtikla.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldIdArtikla.setBounds(47, 94, 58, 20);
		panelObrisiArtikal.add(textFieldIdArtikla);
		textFieldIdArtikla.setColumns(10);

		JButton btnOtvoriArtikal = new JButton("Otvori artikal");
		btnOtvoriArtikal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnOtvoriArtikal.setBounds(47, 195, 129, 23);
		panelObrisiArtikal.add(btnOtvoriArtikal);

		JButton btnURedu = new JButton("U redu");
		btnURedu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnURedu.setBounds(146, 93, 73, 23);
		panelObrisiArtikal.add(btnURedu);

		textFieldNazivArtiklaBrisi = new JTextField();
		textFieldNazivArtiklaBrisi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldNazivArtiklaBrisi.setBounds(47, 146, 172, 20);
		panelObrisiArtikal.add(textFieldNazivArtiklaBrisi);
		textFieldNazivArtiklaBrisi.setColumns(10);

	}
}
