package jframeAzuriraj;

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

public class JFrameAzurirajKupca extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldIdKupcaAzurirajKupca;
	private JButton btnNazadAzurirajKupca;	
	private Kupac k;

	public JButton getBtnNazadAzurirajKupca() {
		return btnNazadAzurirajKupca;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameAzurirajKupca frame = new JFrameAzurirajKupca();
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
	public JFrameAzurirajKupca() {
		setTitle("A\u017DURIRAJ KUPCA");
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
		
		textFieldIdKupcaAzurirajKupca = new JTextField();
		textFieldIdKupcaAzurirajKupca.setFont(new Font("Arial", Font.PLAIN, 13));
		textFieldIdKupcaAzurirajKupca.setBounds(170, 100, 70, 20);
		contentPane.add(textFieldIdKupcaAzurirajKupca);
		textFieldIdKupcaAzurirajKupca.setColumns(10);
		
		btnNazadAzurirajKupca = new JButton("Nazad");
		btnNazadAzurirajKupca.setFont(new Font("Arial", Font.BOLD, 14));
		btnNazadAzurirajKupca.setBounds(260, 140, 100, 25);
		contentPane.add(btnNazadAzurirajKupca);
		
		JButton btnOtvoriKupcaAzurirajKupca = new JButton("Otvorite kupca");
		btnOtvoriKupcaAzurirajKupca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrameKupac jfk = new JFrameKupac();
				jfk.getBtnDodajKupca().setVisible(false);
				jfk.getBtnObrisiKupca().setVisible(false);
				jfk.getTextFieldIdKupca().setEditable(false);
				jfk.getTextPibKupca().setEditable(false);
				
				int idk = Integer.parseInt(textFieldIdKupcaAzurirajKupca.getText().trim());
				
				try {
					k = Kontroler.getInstance().getDetaljiKupca(idk);

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
					
					
										
					jfk.setVisible(true);
					
				} catch (ClassNotFoundException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				jfk.getBtnAzurirajKupca().addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						//int rbk = Integer.parseInt(jfk.getTextFieldIdKupca().getText().trim());
						
						try {
						k.setNazivFirmeKupca(jfk.getTextNazivFirme().getText());
						k.setAdresaKupca(jfk.getTextAdresaFirme().getText());
						k.setGradOpstinaKupca(jfk.getTextGradOpstinaFirme().getText());
						k.setTelefonKupca(jfk.getTextTelefonFirme().getText());
						k.setEmailKupca(jfk.getTextEMailKipca().getText());
						k.setKontaktOsobaKupca(jfk.getTextFieldKontakOsobaKupca().getText());
						k.setPibKupca(Integer.parseInt(jfk.getTextPibKupca().getText()));
						k.setTekuciRacunKupca(jfk.getTextTekuciRacunKupca().getText());
						k.setValutaPlacanjaKupca(Integer.parseInt(jfk.getComboBoxValutaPlacanja().getSelectedItem().toString()));
						
						if(jfk.getRdbtnAktivan().isSelected()) {
							k.setStatusKupca("Aktivan");							
						}else if(jfk.getRdbtnNeaktivan().isSelected()) {
							k.setStatusKupca("Neaktivan");
						}					
						
						
						
							Kontroler.getInstance().updateKupac(k);
							JOptionPane.showMessageDialog(null, "Uspesno ste ažurirali kupca!");
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
		btnOtvoriKupcaAzurirajKupca.setFont(new Font("Arial", Font.BOLD, 14));
		btnOtvoriKupcaAzurirajKupca.setBounds(60, 140, 180, 25);
		contentPane.add(btnOtvoriKupcaAzurirajKupca);
		
		JComboBox comboBoxAzurirajKupca = new JComboBox();
		comboBoxAzurirajKupca.setFont(new Font("Arial", Font.PLAIN, 13));
		comboBoxAzurirajKupca.setBounds(60, 60, 300, 20);
		contentPane.add(comboBoxAzurirajKupca);
		popuniComboBoxKupca(comboBoxAzurirajKupca);
		comboBoxAzurirajKupca.setSelectedItem(null);
		comboBoxAzurirajKupca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Kupac k = (Kupac) comboBoxAzurirajKupca.getSelectedItem();
				textFieldIdKupcaAzurirajKupca.setText(Integer.toString(k.getIdKupca()));
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
