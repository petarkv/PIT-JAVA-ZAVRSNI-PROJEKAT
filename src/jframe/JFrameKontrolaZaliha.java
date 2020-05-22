package jframe;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.border.TitledBorder;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import java.awt.Font;

public class JFrameKontrolaZaliha extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup RadioButtonGropSortiranjeKontrolaZaliha = new ButtonGroup();
	private JButton btnPrekidKontrolaZaliha;
	private JButton btnOkKontrolaZaliha;

	public JButton getBtnPrekidKontrolaZaliha() {
		return btnPrekidKontrolaZaliha;
	}

	public JButton getBtnOkKontrolaZaliha() {
		return btnOkKontrolaZaliha;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameKontrolaZaliha frame = new JFrameKontrolaZaliha();
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
	public JFrameKontrolaZaliha() {
		setTitle("KONTROLA ZALIHA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panelFilterKontrolaZaliha = new JPanel();
		panelFilterKontrolaZaliha
				.setBorder(new TitledBorder(null, "Filter", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelFilterKontrolaZaliha.setBounds(20, 200, 150, 150);
		contentPane.add(panelFilterKontrolaZaliha);
		panelFilterKontrolaZaliha.setLayout(null);
		panelFilterKontrolaZaliha.setEnabled(false);

		JCheckBox chckbxZaliheVeceOd0KontrolaZaliha = new JCheckBox("Zalihe > 0");
		chckbxZaliheVeceOd0KontrolaZaliha.setFont(new Font("Arial", Font.BOLD, 14));
		chckbxZaliheVeceOd0KontrolaZaliha.setBounds(10, 30, 100, 20);
		panelFilterKontrolaZaliha.add(chckbxZaliheVeceOd0KontrolaZaliha);
		chckbxZaliheVeceOd0KontrolaZaliha.setEnabled(false);

		JCheckBox chckbxZaliheManjeOd0KontrolaZaliha = new JCheckBox("Zalihe < 0");
		chckbxZaliheManjeOd0KontrolaZaliha.setFont(new Font("Arial", Font.BOLD, 14));
		chckbxZaliheManjeOd0KontrolaZaliha.setBounds(10, 70, 100, 20);
		panelFilterKontrolaZaliha.add(chckbxZaliheManjeOd0KontrolaZaliha);
		chckbxZaliheManjeOd0KontrolaZaliha.setEnabled(false);

		JCheckBox chckbxZalihejednakekontrolazaliha = new JCheckBox("Zalihe = 0");
		chckbxZalihejednakekontrolazaliha.setFont(new Font("Arial", Font.BOLD, 14));
		chckbxZalihejednakekontrolazaliha.setBounds(10, 110, 100, 20);
		panelFilterKontrolaZaliha.add(chckbxZalihejednakekontrolazaliha);
		chckbxZalihejednakekontrolazaliha.setEnabled(false);

		JPanel panelSortiranjeKontrolaZaliha = new JPanel();
		panelSortiranjeKontrolaZaliha
				.setBorder(new TitledBorder(null, "Sortiranje", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelSortiranjeKontrolaZaliha.setBounds(250, 200, 170, 120);
		contentPane.add(panelSortiranjeKontrolaZaliha);
		panelSortiranjeKontrolaZaliha.setLayout(null);
		panelSortiranjeKontrolaZaliha.setEnabled(false);

		JRadioButton rdbtnArtikal = new JRadioButton("Artikal");
		rdbtnArtikal.setFont(new Font("Arial", Font.BOLD, 14));
		RadioButtonGropSortiranjeKontrolaZaliha.add(rdbtnArtikal);
		rdbtnArtikal.setBounds(10, 70, 100, 20);
		panelSortiranjeKontrolaZaliha.add(rdbtnArtikal);
		rdbtnArtikal.setEnabled(false);

		JRadioButton rdbtnGrupaArikala = new JRadioButton("Grupa arikala");
		rdbtnGrupaArikala.setFont(new Font("Arial", Font.BOLD, 14));
		RadioButtonGropSortiranjeKontrolaZaliha.add(rdbtnGrupaArikala);
		rdbtnGrupaArikala.setBounds(10, 30, 130, 20);
		panelSortiranjeKontrolaZaliha.add(rdbtnGrupaArikala);
		rdbtnGrupaArikala.setEnabled(false);

		btnOkKontrolaZaliha = new JButton("Pretra\u017Ei");
		btnOkKontrolaZaliha.setFont(new Font("Arial", Font.BOLD, 14));
		btnOkKontrolaZaliha.setBounds(270, 410, 150, 25);
		contentPane.add(btnOkKontrolaZaliha);
		btnOkKontrolaZaliha.setEnabled(false);

		btnPrekidKontrolaZaliha = new JButton("Prekid");
		btnPrekidKontrolaZaliha.setFont(new Font("Arial", Font.BOLD, 14));
		btnPrekidKontrolaZaliha.setBounds(20, 410, 150, 25);
		contentPane.add(btnPrekidKontrolaZaliha);
		

		JPanel panelPretragaKontrolaZaliha = new JPanel();
		panelPretragaKontrolaZaliha
				.setBorder(new TitledBorder(null, "Pretraga", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelPretragaKontrolaZaliha.setBounds(20, 30, 400, 130);
		contentPane.add(panelPretragaKontrolaZaliha);
		panelPretragaKontrolaZaliha.setLayout(null);
		panelPretragaKontrolaZaliha.setEnabled(false);

		JLabel lblSkladisteKontrolaZaliha = new JLabel("Skladi\u0161te :");
		lblSkladisteKontrolaZaliha.setFont(new Font("Arial", Font.BOLD, 14));
		lblSkladisteKontrolaZaliha.setBounds(10, 30, 90, 20);
		panelPretragaKontrolaZaliha.add(lblSkladisteKontrolaZaliha);
		lblSkladisteKontrolaZaliha.setEnabled(false);

		JComboBox comboBoxGrupaArtikalaKontrolaZaliha = new JComboBox();
		comboBoxGrupaArtikalaKontrolaZaliha.setFont(new Font("Arial", Font.PLAIN, 13));
		comboBoxGrupaArtikalaKontrolaZaliha.setBounds(170, 60, 200, 20);
		panelPretragaKontrolaZaliha.add(comboBoxGrupaArtikalaKontrolaZaliha);
		comboBoxGrupaArtikalaKontrolaZaliha.setEnabled(false);

		JLabel lblGrupaArtikalaKontrolaZaliha = new JLabel("Grupa artikala :");
		lblGrupaArtikalaKontrolaZaliha.setFont(new Font("Arial", Font.BOLD, 14));
		lblGrupaArtikalaKontrolaZaliha.setBounds(10, 60, 120, 20);
		panelPretragaKontrolaZaliha.add(lblGrupaArtikalaKontrolaZaliha);
		lblGrupaArtikalaKontrolaZaliha.setEnabled(false);

		JLabel lblArtikalKontrolaZaliha = new JLabel("Artikal :");
		lblArtikalKontrolaZaliha.setFont(new Font("Arial", Font.BOLD, 14));
		lblArtikalKontrolaZaliha.setBounds(10, 90, 90, 20);
		panelPretragaKontrolaZaliha.add(lblArtikalKontrolaZaliha);
		lblArtikalKontrolaZaliha.setEnabled(false);
		
		JComboBox comboBoxSkladisteKontrolaZaliha = new JComboBox();
		comboBoxSkladisteKontrolaZaliha.setFont(new Font("Arial", Font.PLAIN, 13));
		comboBoxSkladisteKontrolaZaliha.setBounds(170, 30, 200, 20);
		panelPretragaKontrolaZaliha.add(comboBoxSkladisteKontrolaZaliha);
		comboBoxSkladisteKontrolaZaliha.setEnabled(false);
		
		JComboBox comboBoxArtikalKontrolaZaliha = new JComboBox();
		comboBoxArtikalKontrolaZaliha.setFont(new Font("Arial", Font.PLAIN, 13));
		comboBoxArtikalKontrolaZaliha.setBounds(170, 90, 200, 20);
		panelPretragaKontrolaZaliha.add(comboBoxArtikalKontrolaZaliha);
		comboBoxArtikalKontrolaZaliha.setEnabled(false);
	}
}
