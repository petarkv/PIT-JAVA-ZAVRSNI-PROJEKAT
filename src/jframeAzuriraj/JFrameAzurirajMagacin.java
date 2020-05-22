 package jframeAzuriraj;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import jframe.JFrameMagacin;
import kontroler.Kontroler;
import model.Magacin;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class JFrameAzurirajMagacin extends JFrame {

	private JPanel contentPane;
	private JComboBox<Magacin> comboBoxMagacinaAzuriraj;
	private JTextField textFieldIdMagacinaAzurirajMagacin;
	private JButton btnNazadAzurirajMagacin;
	private Magacin m;
	
	public JButton getBtnNazadAzurirajMagacin() {
		return btnNazadAzurirajMagacin;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameAzurirajMagacin frameObrisiMagacin = new JFrameAzurirajMagacin();
					frameObrisiMagacin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JFrameAzurirajMagacin() {
		setTitle("A\u017DURIRAJ MAGACIN");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblUnesiteIdMagacina = new JLabel("Unesite magacin :");
		lblUnesiteIdMagacina.setFont(new Font("Arial", Font.BOLD, 14));
		lblUnesiteIdMagacina.setBounds(60, 20, 250, 20);
		contentPane.add(lblUnesiteIdMagacina);

		JButton btnOtvoriMagacin = new JButton("Otvorite magacin");
		btnOtvoriMagacin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrameMagacin jfmo = new JFrameMagacin();
				jfmo.getBtnDodajMagacin().setVisible(false);
				jfmo.getBtnObrisiMagacin().setVisible(false);
				jfmo.getTextFieldIdMagacina().setEditable(false);
				
				int idm = Integer.parseInt(textFieldIdMagacinaAzurirajMagacin.getText().trim());
				try {
					m = Kontroler.getInstance().getDetaljiMagacina(idm);

					jfmo.getTextFieldIdMagacina().setText(Integer.toString(m.getIdMagacina()));
					jfmo.getTextFieldNazivMagacina().setText(m.getNazivMagacina());
					jfmo.getTextFieldAdresaMagacina().setText(m.getAdresaMagacina());
					jfmo.getTextFieldGradMagacina().setText(m.getGradOpstinaMagacina());
					jfmo.getTextFieldTelefonMagacina().setText(m.getTelefonMagacina());
					jfmo.getTextFieldEmailMagacina().setText(m.getEmailMagacina());
					
					jfmo.setVisible(true);
				} catch (ClassNotFoundException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}

				jfmo.getBtnAzurirajMagacin().addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						//int rbn = Integer.parseInt(jfmo.getTextFieldIdMagacina().getText().trim());
						try {
							
							m.setNazivMagacina(jfmo.getTextFieldNazivMagacina().getText());
							m.setAdresaMagacina(jfmo.getTextFieldAdresaMagacina().getText());
							m.setGradOpstinaMagacina(jfmo.getTextFieldGradMagacina().getText());
							m.setTelefonMagacina(jfmo.getTextFieldTelefonMagacina().getText());
							m.setEmailMagacina(jfmo.getTextFieldEmailMagacina().getText());				
							
							
							Kontroler.getInstance().updateMagacin(m);
							JOptionPane.showMessageDialog(null, "Uspesno ste ažurirali magacin!");
							jfmo.setVisible(false);
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
				jfmo.getBtnPrekiniackcijuMagacin().addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						jfmo.setVisible(false);

					}
				});
				jfmo.setVisible(true);

			}

		});
		btnOtvoriMagacin.setFont(new Font("Arial", Font.BOLD, 14));
		btnOtvoriMagacin.setBounds(60, 140, 180, 25);
		contentPane.add(btnOtvoriMagacin);

		comboBoxMagacinaAzuriraj = new JComboBox<Magacin>();
		comboBoxMagacinaAzuriraj.setFont(new Font("Arial", Font.PLAIN, 13));
		comboBoxMagacinaAzuriraj.setBounds(60, 60, 300, 20);
		contentPane.add(comboBoxMagacinaAzuriraj);
		popuniComboBoxMagacin(comboBoxMagacinaAzuriraj);
		comboBoxMagacinaAzuriraj.setSelectedItem(null);
		comboBoxMagacinaAzuriraj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Magacin m = (Magacin) comboBoxMagacinaAzuriraj.getSelectedItem();
				textFieldIdMagacinaAzurirajMagacin.setText(Integer.toString(m.getIdMagacina()));
			}
		});

		JLabel lblIdMagacinaAzurirajMagacin = new JLabel("ID magacina :");
		lblIdMagacinaAzurirajMagacin.setFont(new Font("Arial", Font.BOLD, 14));
		lblIdMagacinaAzurirajMagacin.setBounds(60, 100, 120, 20);
		contentPane.add(lblIdMagacinaAzurirajMagacin);

		textFieldIdMagacinaAzurirajMagacin = new JTextField();
		textFieldIdMagacinaAzurirajMagacin.setFont(new Font("Arial", Font.PLAIN, 13));
		textFieldIdMagacinaAzurirajMagacin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			}
		});
		textFieldIdMagacinaAzurirajMagacin.setBounds(220, 100, 70, 20);
		contentPane.add(textFieldIdMagacinaAzurirajMagacin);
		textFieldIdMagacinaAzurirajMagacin.setColumns(10);
		
		btnNazadAzurirajMagacin = new JButton("Nazad");
		btnNazadAzurirajMagacin.setFont(new Font("Arial", Font.BOLD, 14));
		btnNazadAzurirajMagacin.setBounds(260, 140, 100, 25);
		contentPane.add(btnNazadAzurirajMagacin);
	}

	private void popuniComboBoxMagacin(JComboBox<Magacin> comboBox) {
		try {
			ArrayList<Magacin> lista = Kontroler.getInstance().getMagacin();

			for (Magacin m : lista) {
				comboBox.addItem(m);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


}
