package jframeObrisi;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import jframe.JFrameFilijala;
import jframe.JFrameKupac;
import kontroler.Kontroler;
import model.Filijala;
import model.Kupac;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class JFrameObrisiKupca extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldIdKupcaObrisiKupca;
	private JButton btnNazadObrisiKupca;

	public JButton getBtnNazadObrisiKupca() {
		return btnNazadObrisiKupca;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameObrisiKupca frame = new JFrameObrisiKupca();
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
	public JFrameObrisiKupca() {
		setTitle("OBRI\u0160I KUPCA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIzaberiteKupca = new JLabel("Unesite kupca :");
		lblIzaberiteKupca.setFont(new Font("Arial", Font.BOLD, 14));
		lblIzaberiteKupca.setBounds(60, 20, 250, 20);
		contentPane.add(lblIzaberiteKupca);
		
		textFieldIdKupcaObrisiKupca = new JTextField();
		textFieldIdKupcaObrisiKupca.setFont(new Font("Arial", Font.PLAIN, 13));
		textFieldIdKupcaObrisiKupca.setBounds(170, 100, 70, 20);
		contentPane.add(textFieldIdKupcaObrisiKupca);
		textFieldIdKupcaObrisiKupca.setColumns(10);
		
		btnNazadObrisiKupca = new JButton("Nazad");
		btnNazadObrisiKupca.setFont(new Font("Arial", Font.BOLD, 14));
		btnNazadObrisiKupca.setBounds(260, 140, 100, 25);
		contentPane.add(btnNazadObrisiKupca);
		
		JButton btnOtvoriKupcaObrisiKupca = new JButton("Otvorite kupca");
		btnOtvoriKupcaObrisiKupca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrameKupac jfk = new JFrameKupac();
				jfk.getBtnDodajKupca().setVisible(false);
				jfk.getBtnAzurirajKupca().setVisible(false);
				int idk = Integer.parseInt(textFieldIdKupcaObrisiKupca.getText().trim());
				
				try {
					Kupac k = Kontroler.getInstance().getDetaljiKupca(idk);

					jfk.getTextFieldIdKupca().setText(Integer.toString(k.getIdKupca()));
					jfk.getTextNazivFirme().setText(k.getNazivFirmeKupca());
					jfk.getTextAdresaFirme().setText(k.getAdresaKupca());
					jfk.getTextGradOpstinaFirme().setText(k.getGradOpstinaKupca());
					jfk.getTextTelefonFirme().setText(k.getTelefonKupca());
					jfk.getTextEMailKipca().setText(k.getEmailKupca());
					jfk.getTextFieldKontakOsobaKupca().setText(k.getKontaktOsobaKupca());
					jfk.getTextPibKupca().setText(Integer.toString(k.getPibKupca()));
					jfk.getTextTekuciRacunKupca().setText(k.getTekuciRacunKupca());
					jfk.getComboBoxValutaPlacanja().setSelectedItem(Integer.toString(k.getValutaPlacanjaKupca()));
					
					if(k.getStatusKupca().equals("Aktivan")) {
						jfk.getRdbtnAktivan().setSelected(true);
					}else
						jfk.getRdbtnNeaktivan().setSelected(true);
					
					
					
					
					
					jfk.getTextFieldIdKupca().setEditable(false);
					jfk.getTextNazivFirme().setEditable(false);
					jfk.getTextAdresaFirme().setEditable(false);
					jfk.getTextGradOpstinaFirme().setEditable(false);
					jfk.getTextTelefonFirme().setEditable(false);
					jfk.getTextEMailKipca().setEditable(false);
					jfk.getTextFieldKontakOsobaKupca().setEditable(false);
					jfk.getTextPibKupca().setEditable(false);
					jfk.getTextTekuciRacunKupca().setEditable(false);
					jfk.getComboBoxValutaPlacanja().setEditable(false);
					jfk.getRdbtnAktivan().setFocusable(false);
					jfk.getRdbtnNeaktivan().setFocusable(false);
					
										
					jfk.setVisible(true);
					
				} catch (ClassNotFoundException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				jfk.getBtnObrisiKupca().addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						int rbk = Integer.parseInt(jfk.getTextFieldIdKupca().getText().trim());
						try {
							Kontroler.getInstance().obrisiKupca(rbk);;
							JOptionPane.showMessageDialog(null, "Uspesno ste obrisali kupca!");
							jfk.setVisible(false);
							

						} catch (ClassNotFoundException | SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

					}
				});
					jfk.getBtnPonistiAkcijuKupac().addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							jfk.setVisible(false);

						}
					});
				
			}
		});
		btnOtvoriKupcaObrisiKupca.setFont(new Font("Arial", Font.BOLD, 14));
		btnOtvoriKupcaObrisiKupca.setBounds(60, 140, 180, 25);
		contentPane.add(btnOtvoriKupcaObrisiKupca);
		
		JComboBox comboBoxObrisiKupca = new JComboBox();
		comboBoxObrisiKupca.setFont(new Font("Arial", Font.PLAIN, 13));
		comboBoxObrisiKupca.setBounds(60, 60, 300, 20);
		contentPane.add(comboBoxObrisiKupca);
		popuniComboBoxKupca(comboBoxObrisiKupca);
		comboBoxObrisiKupca.setSelectedItem(null);
		comboBoxObrisiKupca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Kupac k = (Kupac) comboBoxObrisiKupca.getSelectedItem();
				textFieldIdKupcaObrisiKupca.setText(Integer.toString(k.getIdKupca()));
			}
		});
		
		JLabel lblIdKupca = new JLabel("ID kupca :");
		lblIdKupca.setFont(new Font("Arial", Font.BOLD, 14));
		lblIdKupca.setBounds(60, 100, 100, 20);
		contentPane.add(lblIdKupca);
	}
	private void popuniComboBoxKupca(JComboBox<Kupac> comboBox) {
		try {
			ArrayList<Kupac> lista = Kontroler.getInstance().getKupac();

			for (Kupac k : lista) {
				comboBox.addItem(k);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
