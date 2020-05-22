package jframeObrisi;

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
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JFrameObrisiFilijalu extends JFrame {

	private JPanel contentPane;
	private JComboBox comboBoxFilijalaObrisi;
	private JTextField textFieldIdFilijaleObrisiFilijalu;
	private JButton btnNazadObrisiFilijali;

	public JButton getBtnNazadObrisiFilijali() {
		return btnNazadObrisiFilijali;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameObrisiFilijalu frame = new JFrameObrisiFilijalu();
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
	public JFrameObrisiFilijalu() {
		setTitle("OBRI\u0160I FILIJALU");
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
		
		comboBoxFilijalaObrisi = new JComboBox();
		comboBoxFilijalaObrisi.setFont(new Font("Arial", Font.PLAIN, 13));
		comboBoxFilijalaObrisi.setBounds(60, 60, 300, 20);
		contentPane.add(comboBoxFilijalaObrisi);
		popuniComboBoxFilijala(comboBoxFilijalaObrisi);
		comboBoxFilijalaObrisi.setSelectedItem(null);
		comboBoxFilijalaObrisi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Filijala f = (Filijala) comboBoxFilijalaObrisi.getSelectedItem();
				textFieldIdFilijaleObrisiFilijalu.setText(Integer.toString(f.getIdFilijale()));
			}
		});
		
		JButton btnOtvoriFilijalu = new JButton("Otvorite filijalu");
		btnOtvoriFilijalu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrameFilijala jffo = new JFrameFilijala();
				jffo.getBtnDodajFilijalu().setVisible(false);
				jffo.getBtnAzurirajFilijalu().setVisible(false);
				int idf = Integer.parseInt(textFieldIdFilijaleObrisiFilijalu.getText().trim());
				try {
					Filijala f = Kontroler.getInstance().getDetaljiFilijale(idf);

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
					
					
					jffo.getTextIDFilijale().setEditable(false);
					jffo.getTextNazivFilijale().setEditable(false);
					jffo.getTextAdresaFilijale().setEditable(false);
					jffo.getTextGradOpstinaFilijale().setEditable(false);
					jffo.getTextTelefonFilijale().setEditable(false);
					jffo.getTextE_MailFilijale().setEditable(false);
					jffo.getTextPibFilijale().setEditable(false);
					jffo.getTextTekuciRacunFilijale().setEditable(false);
					
										
					jffo.setVisible(true);
				} catch (ClassNotFoundException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}

				jffo.getBtnObrisiFilijalu().addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						int rbn = Integer.parseInt(jffo.getTextIDFilijale().getText().trim());
						try {
							Kontroler.getInstance().obrisiFilijalu(rbn); 
							JOptionPane.showMessageDialog(null, "Uspesno ste obrisali filijalu!");
							jffo.setVisible(false);
							

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
		
		JLabel lblIdFilijaleObrisiFilijalu = new JLabel("ID filijale :");
		lblIdFilijaleObrisiFilijalu.setFont(new Font("Arial", Font.BOLD, 14));
		lblIdFilijaleObrisiFilijalu.setBounds(60, 100, 100, 20);
		contentPane.add(lblIdFilijaleObrisiFilijalu);
		
		textFieldIdFilijaleObrisiFilijalu = new JTextField();
		textFieldIdFilijaleObrisiFilijalu.setFont(new Font("Arial", Font.PLAIN, 13));
		textFieldIdFilijaleObrisiFilijalu.setBounds(170, 100, 70, 20);
		contentPane.add(textFieldIdFilijaleObrisiFilijalu);
		textFieldIdFilijaleObrisiFilijalu.setColumns(10);
		
		btnNazadObrisiFilijali = new JButton("Nazad");
		btnNazadObrisiFilijali.setFont(new Font("Arial", Font.BOLD, 14));
		btnNazadObrisiFilijali.setBounds(260, 140, 100, 25);
		contentPane.add(btnNazadObrisiFilijali);
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
