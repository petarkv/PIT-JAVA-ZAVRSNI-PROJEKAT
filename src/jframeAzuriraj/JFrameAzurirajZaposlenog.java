package jframeAzuriraj;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import jframe.JFrameZaposleni;
import kontroler.Kontroler;
import model.Filijala;
import model.Magacin;
import model.Zaposleni;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.util.Calendar;
import java.util.Date;

import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class JFrameAzurirajZaposlenog extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldIdZaposlenog;
	private JButton btnNazadAzurirajZaposlenog;	
	private Zaposleni z;

	public JButton getBtnNazadAzurirajZaposlenog() {
		return btnNazadAzurirajZaposlenog;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameAzurirajZaposlenog frame = new JFrameAzurirajZaposlenog();
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
	public JFrameAzurirajZaposlenog() {
		setTitle("A\u017DURIRAJ ZAPOSLENOG");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIzaberiteZaposlenog = new JLabel("Unesite zaposlenog :");
		lblIzaberiteZaposlenog.setFont(new Font("Arial", Font.BOLD, 14));
		lblIzaberiteZaposlenog.setBounds(60, 20, 250, 20);
		contentPane.add(lblIzaberiteZaposlenog);
		
		JButton btnOtvoriZaposlenog = new JButton("Otvorite zaposlenog");
		btnOtvoriZaposlenog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFrameZaposleni jfzo = new JFrameZaposleni();
				
				jfzo.getBtnDodajZaposlenog().setVisible(false);
				jfzo.getBtnObrisiZaposlenog().setVisible(false);
				jfzo.getTextIDZaposlenog().setEditable(false);
				jfzo.getTextJMBG().setEditable(false);
				jfzo.getTextPassword().setEditable(false);
				//jfzo.getBtnDodajZaposlenog().setVisible(false);
				int idz = Integer.parseInt(textFieldIdZaposlenog.getText().trim());
				
			    try {
					z = Kontroler.getInstance().getDetaljiZaposleni(idz);
					
					jfzo.getTextIDZaposlenog().setText(Integer.toString(z.getIdZaposlenog()));
					jfzo.getTextIme().setText(z.getImeZaposlenog());
					jfzo.getTextPrezime().setText(z.getPrezimeZaposlenog());
					jfzo.getTextJMBG().setText(z.getJmbgZaposlenog());
					jfzo.getTextAdresa().setText(z.getAdresaZaposlenog());
					jfzo.getTextGrad_Ostina().setText(z.getGradOpstinaZaposlenog());
					jfzo.getTextTelefon().setText(z.getTelefonZaposlenog());
					jfzo.getTextEMail().setText(z.getEmailZaposlenog());					
					
					jfzo.getComboBoxFilijalaPosla().getModel().setSelectedItem(Kontroler.getInstance().getDetaljiFilijale(z.getIdFilijale()));
					jfzo.getTextPlata().setText(Double.toString(z.getPlataZaposlenog()));
					jfzo.getComboBoxTipZaposlenja().setSelectedItem(z.getTipZaposlenja());
					
					jfzo.getComboBoxStrucnaSprema().setSelectedItem(z.getStrucnaSpremaZaposlenog());
					jfzo.getDateChooserDatumZaposlenja().setDate(z.getDatumPocetkaZaposlenja());
					jfzo.getDateChooserPrestankaZaposlenja().setDate(z.getDatumZavrsetkaZaposlenja());
					
					jfzo.getTextUsername().setText(z.getUsernameZaposlenog());
					jfzo.getTextPassword().setText(z.getPasswordZaposlenog());						
					
				} catch (ClassNotFoundException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
			    
			    jfzo.getBtnAzurirajZaposlenog().addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						//int idz = Integer.parseInt(jfzo.getTextIDZaposlenog().getText().trim());
						
						
						try {
							z.setImeZaposlenog(jfzo.getTextIme().getText());
							z.setPrezimeZaposlenog(jfzo.getTextPrezime().getText());
							z.setJmbgZaposlenog(jfzo.getTextJMBG().getText());
							z.setAdresaZaposlenog(jfzo.getTextAdresa().getText());
							z.setGradOpstinaZaposlenog(jfzo.getTextGrad_Ostina().getText());
							z.setTelefonZaposlenog(jfzo.getTextTelefon().getText());
							z.setEmailZaposlenog(jfzo.getTextEMail().getText());
							z.setUsernameZaposlenog(jfzo.getTextUsername().getText());
							z.setPasswordZaposlenog(jfzo.getTextPassword().getText());
							z.setStrucnaSpremaZaposlenog(jfzo.getComboBoxStrucnaSprema().getSelectedItem().toString());							
							z.setDatumPocetkaZaposlenja(jfzo.getDateChooserDatumZaposlenja().getDate());
							z.setDatumZavrsetkaZaposlenja(jfzo.getDateChooserPrestankaZaposlenja().getDate());
							z.setIdFilijale(((Filijala)jfzo.getComboBoxFilijalaPosla().getSelectedItem()).getIdFilijale());
							z.setPlataZaposlenog(Double.parseDouble(jfzo.getTextPlata().getText()));
							z.setTipZaposlenja(jfzo.getComboBoxTipZaposlenja().getSelectedItem().toString());			

						

							
							

							// boolean datum_prest = chckbxDatumPrestankaPoslaNeodredjeno.isSelected();

						    

							//Zaposleni z = new Zaposleni(idfilijale, ime, prezime, jmbg, adresa, grad, tel, email, struc_sprema, datum_poc, datum_zav, plata, tip_zaposlenja, username, password);
							
							
							
							
							
							
							Kontroler.getInstance().updateZaposleni(z);
							JOptionPane.showMessageDialog(null, "Uspesno ste ažurirali zaposlenog!");
							jfzo.setVisible(false);
							
							
						} catch (HeadlessException e3) {
							// TODO Auto-generated catch block
							e3.printStackTrace();
						} catch (ClassNotFoundException e3) {
							// TODO Auto-generated catch block
							e3.printStackTrace();
						} catch(SQLIntegrityConstraintViolationException e1){
							JOptionPane.showMessageDialog(jfzo.getBtnAzurirajZaposlenog(), "Username vec postoji!");
							jfzo.getTextUsername().setText("");	
						} catch (SQLException e3) {
							// TODO Auto-generated catch block
							e3.printStackTrace();
						}					
						
					}
				});
			    
			    jfzo.getBtnPonistiAkciju().addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						jfzo.setVisible(false);
						
						
					}
				});
			    
			    jfzo.setVisible(true);		    
			    
			    
			}
		});
		btnOtvoriZaposlenog.setFont(new Font("Arial", Font.BOLD, 14));
		btnOtvoriZaposlenog.setBounds(60, 140, 180, 25);
		contentPane.add(btnOtvoriZaposlenog);
		
		JLabel lblIdZaposlenog = new JLabel("ID zaposlenog :");
		lblIdZaposlenog.setFont(new Font("Arial", Font.BOLD, 14));
		lblIdZaposlenog.setBounds(60, 100, 120, 20);
		contentPane.add(lblIdZaposlenog);
		
		textFieldIdZaposlenog = new JTextField();
		textFieldIdZaposlenog.setFont(new Font("Arial", Font.PLAIN, 13));
		textFieldIdZaposlenog.setBounds(220, 100, 70, 20);
		contentPane.add(textFieldIdZaposlenog);
		textFieldIdZaposlenog.setColumns(10);
		
		JComboBox<Zaposleni> comboBoxIzaberiteZaposlenog = new JComboBox();
		comboBoxIzaberiteZaposlenog.setFont(new Font("Arial", Font.PLAIN, 13));
		comboBoxIzaberiteZaposlenog.setBounds(60, 60, 300, 20);
		contentPane.add(comboBoxIzaberiteZaposlenog);
		popuniComboBoxZaposleni(comboBoxIzaberiteZaposlenog);
		comboBoxIzaberiteZaposlenog.setSelectedItem(null);
		
		btnNazadAzurirajZaposlenog = new JButton("Nazad");
		btnNazadAzurirajZaposlenog.setFont(new Font("Arial", Font.BOLD, 14));
		btnNazadAzurirajZaposlenog.setBounds(260, 140, 100, 25);
		contentPane.add(btnNazadAzurirajZaposlenog);
		comboBoxIzaberiteZaposlenog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Zaposleni z = (Zaposleni) comboBoxIzaberiteZaposlenog.getSelectedItem();
				textFieldIdZaposlenog.setText(Integer.toString(z.getIdZaposlenog()));
			}
		});
	}
	
	    private void popuniComboBoxZaposleni(JComboBox<Zaposleni> comboBox) {
		try {
			ArrayList<Zaposleni> lista = Kontroler.getInstance().getZaposleni();

			for (Zaposleni z : lista) {
				comboBox.addItem(z);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
