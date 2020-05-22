package jframeObrisi;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import jframe.JFrameZaposleni;
import kontroler.Kontroler;
import model.Magacin;
import model.Zaposleni;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class JFrameObrisiZaposlenog extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldIdZaposlenog;
	private JButton btnNazadObrisiZaposlenog;
	
	public JButton getBtnNazadObrisiZaposlenog() {
		return btnNazadObrisiZaposlenog;
	}
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameObrisiZaposlenog frame = new JFrameObrisiZaposlenog();
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
	public JFrameObrisiZaposlenog() {
		setTitle("OBRI\u0160I ZAPOSLENOG");
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
				jfzo.getBtnAzurirajZaposlenog().setVisible(false);
				//jfzo.getBtnDodajZaposlenog().setVisible(false);
				int idz = Integer.parseInt(textFieldIdZaposlenog.getText().trim());
				
			    try {
					Zaposleni z = Kontroler.getInstance().getDetaljiZaposleni(idz);
					
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
			    
			    jfzo.getBtnObrisiZaposlenog().addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						int idz = Integer.parseInt(jfzo.getTextIDZaposlenog().getText().trim());
						
						try {
							
							Kontroler.getInstance().deleteZaposleni(idz);
							JOptionPane.showMessageDialog(null, "Uspesno ste obrisali zaposlenog!");
							jfzo.setVisible(false);
								
						} catch (HeadlessException e3) {
							// TODO Auto-generated catch block
							e3.printStackTrace();
						} catch (ClassNotFoundException e3) {
							// TODO Auto-generated catch block
							e3.printStackTrace();
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
		
		btnNazadObrisiZaposlenog = new JButton("Nazad");
		btnNazadObrisiZaposlenog.setFont(new Font("Arial", Font.BOLD, 14));
		btnNazadObrisiZaposlenog.setBounds(260, 140, 100, 25);
		contentPane.add(btnNazadObrisiZaposlenog);
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
