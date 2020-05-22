package jpanel;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.UIManager;
import java.awt.Color;

public class JPanelObrisiZaposlenog extends JPanel {
	private JTextField textFieldImeZaposlenogBrisi;
	private JTextField textFieldIdZaposlenog;

	/**
	 * Create the panel.
	 */
	public JPanelObrisiZaposlenog() {
		setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Obrisi zaposlenog",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		setLayout(null);

		JLabel lblUnesiIdZaposlenog = new JLabel("Unesite ID zaposlenog :");
		lblUnesiIdZaposlenog.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUnesiIdZaposlenog.setBounds(55, 55, 171, 28);
		add(lblUnesiIdZaposlenog);

		JButton btnOtvoriZaposlenog = new JButton("Otvori zaposlenog");
		btnOtvoriZaposlenog.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnOtvoriZaposlenog.setBounds(51, 188, 161, 28);
		add(btnOtvoriZaposlenog);

		JButton btnURedu = new JButton("U redu");
		btnURedu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnURedu.setBounds(176, 94, 73, 23);
		add(btnURedu);

		textFieldImeZaposlenogBrisi = new JTextField();
		textFieldImeZaposlenogBrisi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldImeZaposlenogBrisi.setBounds(55, 144, 194, 20);
		add(textFieldImeZaposlenogBrisi);
		textFieldImeZaposlenogBrisi.setColumns(10);

		textFieldIdZaposlenog = new JTextField();
		textFieldIdZaposlenog.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldIdZaposlenog.setBounds(55, 94, 58, 20);
		add(textFieldIdZaposlenog);
		textFieldIdZaposlenog.setColumns(10);
		btnOtvoriZaposlenog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});

	}

}
