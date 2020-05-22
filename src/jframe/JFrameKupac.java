package jframe;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import kontroler.Kontroler;
import model.Kupac;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import java.awt.Font;

public class JFrameKupac extends JFrame {

	private JPanel contentPane;
	private JTextField textNazivFirme;
	private JTextField textAdresaFirme;
	private JTextField textGradOpstinaFirme;
	private JTextField textTelefonFirme;
	private JPanel panelPoslovniPodaciKupca;
	private JLabel lblPib;
	private JTextField textPibKupca;
	private JLabel lblTekucracunKupca;
	private JLabel lblValutaPlacanja;
	private JLabel lblStatusKupca;
	private JTextField textTekuciRacunKupca;
	private JComboBox comboBoxValutaPlacanja;
	private JLabel lblIdKupca;
	private JTextField textFieldIdKupca;
	private JButton btnDodajKupca;
	private JButton btnObrisiKupca;
	private JButton btnAzurirajKupca;
	private JButton btnPonistiAkcijuKupac;
	private JTextField textEMailKipca;
	private JLabel lblDana;
	private JTextField textFieldKontakOsobaKupca;
	private JRadioButton rdbtnAktivan;
	private JRadioButton rdbtnNeaktivan;
	

	public JRadioButton getRdbtnAktivan() {
		return rdbtnAktivan;
	}

	public JRadioButton getRdbtnNeaktivan() {
		return rdbtnNeaktivan;
	}

	public JPanel getContentPane() {
		return contentPane;
	}

	public JTextField getTextNazivFirme() {
		return textNazivFirme;
	}

	public JTextField getTextAdresaFirme() {
		return textAdresaFirme;
	}

	public JTextField getTextGradOpstinaFirme() {
		return textGradOpstinaFirme;
	}

	public JTextField getTextTelefonFirme() {
		return textTelefonFirme;
	}

	public JPanel getPanelPoslovniPodaciKupca() {
		return panelPoslovniPodaciKupca;
	}

	public JLabel getLblPib() {
		return lblPib;
	}

	public JTextField getTextPibKupca() {
		return textPibKupca;
	}

	public JLabel getLblTekucracunKupca() {
		return lblTekucracunKupca;
	}

	public JLabel getLblValutaPlacanja() {
		return lblValutaPlacanja;
	}

	public JLabel getLblStatusKupca() {
		return lblStatusKupca;
	}

	public JTextField getTextTekuciRacunKupca() {
		return textTekuciRacunKupca;
	}

	public JComboBox getComboBoxValutaPlacanja() {
		return comboBoxValutaPlacanja;
	}

	public JLabel getLblIdKupca() {
		return lblIdKupca;
	}

	public JTextField getTextFieldIdKupca() {
		return textFieldIdKupca;
	}

	public JButton getBtnDodajKupca() {
		return btnDodajKupca;
	}

	public JButton getBtnObrisiKupca() {
		return btnObrisiKupca;
	}

	public JButton getBtnAzurirajKupca() {
		return btnAzurirajKupca;
	}

	public JButton getBtnPonistiAkcijuKupac() {
		return btnPonistiAkcijuKupac;
	}

	public JTextField getTextEMailKipca() {
		return textEMailKipca;
	}

	public JLabel getLblDana() {
		return lblDana;
	}

	public JTextField getTextFieldKontakOsobaKupca() {
		return textFieldKontakOsobaKupca;
	}
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameKupac frame = new JFrameKupac();
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
	public JFrameKupac() {
		setTitle("KUPAC");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 860, 430);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panelPodacioKupcu = new JPanel();
		panelPodacioKupcu.setBorder(
				new TitledBorder(null, "Podaci o kupcu", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelPodacioKupcu.setBounds(10, 10, 400, 260);
		contentPane.add(panelPodacioKupcu);
		panelPodacioKupcu.setLayout(null);

		JLabel lblNazivFirme = new JLabel("Naziv firme :");
		lblNazivFirme.setFont(new Font("Arial", Font.BOLD, 14));
		lblNazivFirme.setBounds(10, 20, 150, 20);
		panelPodacioKupcu.add(lblNazivFirme);

		JLabel lblAdresaFirme = new JLabel("Adresa firme :");
		lblAdresaFirme.setFont(new Font("Arial", Font.BOLD, 14));
		lblAdresaFirme.setBounds(10, 60, 150, 20);
		panelPodacioKupcu.add(lblAdresaFirme);

		JLabel lblGradOpstina = new JLabel("Grad / Op\u0161tina :");
		lblGradOpstina.setFont(new Font("Arial", Font.BOLD, 14));
		lblGradOpstina.setBounds(10, 100, 150, 20);
		panelPodacioKupcu.add(lblGradOpstina);

		JLabel lblTelefonFirme = new JLabel("Telefon :");
		lblTelefonFirme.setFont(new Font("Arial", Font.BOLD, 14));
		lblTelefonFirme.setBounds(10, 140, 150, 20);
		panelPodacioKupcu.add(lblTelefonFirme);

		JLabel lblKontakOsobaFirme = new JLabel("Kontakt osoba :");
		lblKontakOsobaFirme.setFont(new Font("Arial", Font.BOLD, 14));
		lblKontakOsobaFirme.setBounds(10, 220, 150, 20);
		panelPodacioKupcu.add(lblKontakOsobaFirme);

		textNazivFirme = new JTextField();
		textNazivFirme.setFont(new Font("Arial", Font.PLAIN, 13));
		textNazivFirme.setBounds(170, 20, 220, 20);
		panelPodacioKupcu.add(textNazivFirme);
		textNazivFirme.setColumns(10);

		textAdresaFirme = new JTextField();
		textAdresaFirme.setFont(new Font("Arial", Font.PLAIN, 13));
		textAdresaFirme.setBounds(170, 60, 220, 20);
		panelPodacioKupcu.add(textAdresaFirme);
		textAdresaFirme.setColumns(10);

		textGradOpstinaFirme = new JTextField();
		textGradOpstinaFirme.setFont(new Font("Arial", Font.PLAIN, 13));
		textGradOpstinaFirme.setBounds(170, 100, 220, 20);
		panelPodacioKupcu.add(textGradOpstinaFirme);
		textGradOpstinaFirme.setColumns(10);

		textTelefonFirme = new JTextField();
		textTelefonFirme.setFont(new Font("Arial", Font.PLAIN, 13));
		textTelefonFirme.setBounds(170, 140, 220, 20);
		panelPodacioKupcu.add(textTelefonFirme);
		textTelefonFirme.setColumns(10);

		JLabel lblEMail = new JLabel("E-mail :");
		lblEMail.setFont(new Font("Arial", Font.BOLD, 14));
		lblEMail.setBounds(10, 180, 150, 20);
		panelPodacioKupcu.add(lblEMail);

		textEMailKipca = new JTextField();
		textEMailKipca.setFont(new Font("Arial", Font.PLAIN, 13));
		textEMailKipca.setBounds(170, 180, 220, 20);
		panelPodacioKupcu.add(textEMailKipca);
		textEMailKipca.setColumns(10);
		
		textFieldKontakOsobaKupca = new JTextField();
		textFieldKontakOsobaKupca.setFont(new Font("Arial", Font.PLAIN, 13));
		textFieldKontakOsobaKupca.setBounds(170, 220, 220, 20);
		panelPodacioKupcu.add(textFieldKontakOsobaKupca);
		textFieldKontakOsobaKupca.setColumns(10);

		panelPoslovniPodaciKupca = new JPanel();
		panelPoslovniPodaciKupca.setBorder(
				new TitledBorder(null, "Poslovni podaci kupca", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelPoslovniPodaciKupca.setBounds(430, 10, 400, 260);
		contentPane.add(panelPoslovniPodaciKupca);
		panelPoslovniPodaciKupca.setLayout(null);

		lblPib = new JLabel("PIB :");
		lblPib.setFont(new Font("Arial", Font.BOLD, 14));
		lblPib.setBounds(10, 20, 120, 20);
		panelPoslovniPodaciKupca.add(lblPib);

		textPibKupca = new JTextField();
		textPibKupca.setFont(new Font("Arial", Font.PLAIN, 13));
		textPibKupca.setBounds(140, 20, 250, 20);
		panelPoslovniPodaciKupca.add(textPibKupca);
		textPibKupca.setColumns(10);

		lblTekucracunKupca = new JLabel("Tekuci Racun :");
		lblTekucracunKupca.setFont(new Font("Arial", Font.BOLD, 14));
		lblTekucracunKupca.setBounds(10, 60, 120, 20);
		panelPoslovniPodaciKupca.add(lblTekucracunKupca);

		lblValutaPlacanja = new JLabel("Valuta pla\u0107anja :");
		lblValutaPlacanja.setFont(new Font("Arial", Font.BOLD, 14));
		lblValutaPlacanja.setBounds(10, 100, 120, 20);
		panelPoslovniPodaciKupca.add(lblValutaPlacanja);

		lblStatusKupca = new JLabel("Status :");
		lblStatusKupca.setFont(new Font("Arial", Font.BOLD, 14));
		lblStatusKupca.setBounds(10, 140, 120, 20);
		panelPoslovniPodaciKupca.add(lblStatusKupca);

		textTekuciRacunKupca = new JTextField();
		textTekuciRacunKupca.setFont(new Font("Arial", Font.PLAIN, 13));
		textTekuciRacunKupca.setBounds(140, 60, 250, 20);
		panelPoslovniPodaciKupca.add(textTekuciRacunKupca);
		textTekuciRacunKupca.setColumns(10);

		comboBoxValutaPlacanja = new JComboBox();
		comboBoxValutaPlacanja.setFont(new Font("Arial", Font.BOLD, 14));
		comboBoxValutaPlacanja.setModel(new DefaultComboBoxModel(new String[] { "30", "60", "90", "120" }));
		comboBoxValutaPlacanja.setBounds(140, 100, 70, 20);
		panelPoslovniPodaciKupca.add(comboBoxValutaPlacanja);

		lblIdKupca = new JLabel("ID Kupca :");
		lblIdKupca.setFont(new Font("Arial", Font.BOLD, 14));
		lblIdKupca.setBounds(10, 180, 120, 20);
		panelPoslovniPodaciKupca.add(lblIdKupca);

		textFieldIdKupca = new JTextField();
		textFieldIdKupca.setFont(new Font("Arial", Font.PLAIN, 13));
		textFieldIdKupca.setBounds(140, 180, 70, 20);
		panelPoslovniPodaciKupca.add(textFieldIdKupca);
		textFieldIdKupca.setColumns(10);

		rdbtnAktivan = new JRadioButton("Aktivan");
		rdbtnAktivan.setFont(new Font("Arial", Font.BOLD, 14));
		rdbtnAktivan.setBounds(149, 140, 100, 20);
		panelPoslovniPodaciKupca.add(rdbtnAktivan);

		rdbtnNeaktivan = new JRadioButton("Neaktivan");
		rdbtnNeaktivan.setFont(new Font("Arial", Font.BOLD, 14));
		rdbtnNeaktivan.setBounds(290, 140, 100, 20);
		panelPoslovniPodaciKupca.add(rdbtnNeaktivan);

		ButtonGroup status = new ButtonGroup();
		status.add(rdbtnAktivan);
		status.add(rdbtnNeaktivan);

		lblDana = new JLabel("dana");
		lblDana.setFont(new Font("Arial", Font.PLAIN, 13));
		lblDana.setBounds(220, 100, 100, 20);
		panelPoslovniPodaciKupca.add(lblDana);

		btnDodajKupca = new JButton("Dodaj kupca");
		btnDodajKupca.setFont(new Font("Arial", Font.BOLD, 14));
		btnDodajKupca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					String naziv = textNazivFirme.getText();
					String adresa = textAdresaFirme.getText();
					String grad = textGradOpstinaFirme.getText();
					String tel = textTelefonFirme.getText();
					String email = textEMailKipca.getText();
					String kont_osoba = textFieldKontakOsobaKupca.getText();
					int pib = Integer.parseInt(textPibKupca.getText());
					String tek_racun = textTekuciRacunKupca.getText();
					int valuta = Integer.parseInt(comboBoxValutaPlacanja.getSelectedItem().toString());
					String status = "";
					if (rdbtnAktivan.isSelected()) {
						status = "Aktivan";
					} else if (rdbtnNeaktivan.isSelected()) {
						status = "Neaktivan";
					}

					Kupac k = new Kupac(naziv, adresa, grad, tel, email, kont_osoba, pib, tek_racun, valuta, status);
					
					if (textPibKupca.getText().toString().length() != 8) {
					      throw new ArithmeticException(); 					
					} 	

					Kontroler.getInstance().insertKupac(k);

					JOptionPane.showMessageDialog(null, "Uspesno ste uneli novog kupca!");
					
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch(NumberFormatException e1){
					JOptionPane.showMessageDialog(btnDodajKupca, "Sva polja moraju biti popunjena!");
					
				}   catch(ArithmeticException e1){
					JOptionPane.showMessageDialog(btnDodajKupca, "Uneli ste pogresan broj cifara! (PIB = 8 cifara)");
					
				}
				
				catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnDodajKupca.setBounds(430, 290, 180, 25);
		contentPane.add(btnDodajKupca);

		btnObrisiKupca = new JButton("Obri\u0161i kupca");
		btnObrisiKupca.setFont(new Font("Arial", Font.BOLD, 14));
		btnObrisiKupca.setBounds(650, 290, 180, 25);
		contentPane.add(btnObrisiKupca);

		btnAzurirajKupca = new JButton("A\u017Euriraj");
		btnAzurirajKupca.setFont(new Font("Arial", Font.BOLD, 14));
		btnAzurirajKupca.setBounds(430, 340, 180, 25);
		contentPane.add(btnAzurirajKupca);

		btnPonistiAkcijuKupac = new JButton("Poni\u0161ti akciju");
		btnPonistiAkcijuKupac.setFont(new Font("Arial", Font.BOLD, 14));
		btnPonistiAkcijuKupac.setBounds(650, 340, 180, 25);
		contentPane.add(btnPonistiAkcijuKupac);
	}
}
