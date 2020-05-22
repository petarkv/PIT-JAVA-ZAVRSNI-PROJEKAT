package jframeAzuriraj;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import jframe.JFrameFilijala;
import jframe.JFrameMagacin;
import kontroler.Kontroler;
import model.Filijala;
import model.Magacin;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JFrameAzurirajFilijalu extends JFrame {

	private JPanel contentPane;
	private JComboBox comboBoxFilijalaAzuriraj;
	private JTextField textFieldIdFilijaleAzurirajFilijalu;
	private JButton btnNazadAzurirajFilijali;	
	private Filijala f;

	public JButton getBtnNazadAzurirajFilijali() {
		return btnNazadAzurirajFilijali;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameAzurirajFilijalu frame = new JFrameAzurirajFilijalu();
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
	public JFrameAzurirajFilijalu() {
		setTitle("A\u017DURIRAJ FILIJALU");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIzaberiFilijalu = new JLabel("Unesite filijalu :");
		lblIzaberiFilijalu.setFont(new Font("Arial", Font.BOLD, 14));
		lblIzaberiFilijalu.setBounds(60, 20, 250, 20);
		contentPane.add(lblIzaberiFilijalu);
		
		comboBoxFilijalaAzuriraj = new JComboBox();
		comboBoxFilijalaAzuriraj.setFont(new Font("Arial", Font.PLAIN, 13));
		comboBoxFilijalaAzuriraj.setBounds(60, 60, 300, 20);
		contentPane.add(comboBoxFilijalaAzuriraj);
		popuniComboBoxFilijala(comboBoxFilijalaAzuriraj);
		comboBoxFilijalaAzuriraj.setSelectedItem(null);
		comboBoxFilijalaAzuriraj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Filijala f = (Filijala) comboBoxFilijalaAzuriraj.getSelectedItem();
				textFieldIdFilijaleAzurirajFilijalu.setText(Integer.toString(f.getIdFilijale()));
			}
		});
		
		JButton btnOtvoriFilijalu = new JButton("Otvorite filijalu");
		btnOtvoriFilijalu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrameFilijala jffo = new JFrameFilijala();
				jffo.getBtnDodajFilijalu().setVisible(false);
				jffo.getBtnObrisiFilijalu().setVisible(false);
				jffo.getTextPibFilijale().setEditable(false);
				
				jffo.getTextIDFilijale().setEditable(false);
				int idf = Integer.parseInt(textFieldIdFilijaleAzurirajFilijalu.getText().trim());
				try {
					f = Kontroler.getInstance().getDetaljiFilijale(idf);

					jffo.getTextIDFilijale().setText(Integer.toString(f.getIdFilijale()));
					jffo.getTextNazivFilijale().setText(f.getNazivFilijale());
					jffo.getTextAdresaFilijale().setText(f.getAdresaFilijale());
					jffo.getTextGradOpstinaFilijale().setText(f.getGradOpstinaFilijale());
					jffo.getTextTelefonFilijale().setText(f.getTelefonFilijale());
					jffo.getTextE_MailFilijale().setText(f.getEmailFilijale());
					jffo.getTextPibFilijale().setText(Integer.toString(f.getPibFilijale()));
					jffo.getTextTekuciRacunFilijale().setText(f.getTekuciRacunFilijale());
					
					
					
					if(f.getStatus().equals("Aktivna")) {
						jffo.getRdbtnAktivna().setSelected(true);//.isSelected();
					}else
						jffo.getRdbtnNeaktivna().setSelected(true);//.isSelected();					
					
										
					jffo.setVisible(true);
				} catch (ClassNotFoundException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}			
				

				jffo.getBtnAzurirajFilijalu().addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						//int rbn = Integer.parseInt(jffo.getTextIDFilijale().getText().trim());
						try {
							
							f.setNazivFilijale(jffo.getTextNazivFilijale().getText());
							f.setAdresaFilijale(jffo.getTextAdresaFilijale().getText());
							f.setGradOpstinaFilijale(jffo.getTextGradOpstinaFilijale().getText());
							f.setTelefonFilijale(jffo.getTextTelefonFilijale().getText());
							f.setEmailFilijale(jffo.getTextE_MailFilijale().getText());
							f.setPibFilijale(Integer.parseInt(jffo.getTextPibFilijale().getText()));
							f.setTekuciRacunFilijale(jffo.getTextTekuciRacunFilijale().getText());
							
							if(jffo.getRdbtnAktivna().isSelected()) {
								f.setStatus("Aktivna");
							}else if(jffo.getRdbtnNeaktivna().isSelected()) {
								f.setStatus("Neaktivna");
							}									
												
							
							Kontroler.getInstance().updateFilijala(f);
							JOptionPane.showMessageDialog(null, "Uspesno ste ažurirali filijalu!");
							jffo.setVisible(false);
							/*
							 * textFieldAdresaMagacina.setText(""); textFieldEmailMagacina.setText("");
							 * textFieldGradMagacina.setText(""); textFieldNazivMagacina.setText("");
							 * textFieldTelefonMagacina.setText(""); textFieldIdMagacina.setText("");
							 */							

						} catch (ClassNotFoundException | SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

					}
				});
				jffo.getBtnPonistiAkcijuFilijala().addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						jffo.setVisible(false);

					}
				});
				jffo.setVisible(true);

			}

		});
		                 
		btnOtvoriFilijalu.setFont(new Font("Arial", Font.BOLD, 14));
		btnOtvoriFilijalu.setBounds(60, 140, 180, 25);
		contentPane.add(btnOtvoriFilijalu);
		
		JLabel lblIdFilijaleAzurirajFilijalu = new JLabel("ID filijale :");
		lblIdFilijaleAzurirajFilijalu.setFont(new Font("Arial", Font.BOLD, 14));
		lblIdFilijaleAzurirajFilijalu.setBounds(60, 100, 100, 20);
		contentPane.add(lblIdFilijaleAzurirajFilijalu);
		
		textFieldIdFilijaleAzurirajFilijalu = new JTextField();
		textFieldIdFilijaleAzurirajFilijalu.setFont(new Font("Arial", Font.PLAIN, 13));
		textFieldIdFilijaleAzurirajFilijalu.setBounds(170, 100, 70, 20);
		contentPane.add(textFieldIdFilijaleAzurirajFilijalu);
		textFieldIdFilijaleAzurirajFilijalu.setColumns(10);
		
		btnNazadAzurirajFilijali = new JButton("Nazad");
		btnNazadAzurirajFilijali.setFont(new Font("Arial", Font.BOLD, 14));
		btnNazadAzurirajFilijali.setBounds(260, 140, 100, 25);
		contentPane.add(btnNazadAzurirajFilijali);
	}
	
	private void popuniComboBoxFilijala(JComboBox<Filijala> comboBox) {
		try {
			ArrayList<Filijala> lista = Kontroler.getInstance().getFilijala();

			for (Filijala f : lista) {
				comboBox.addItem(f);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
