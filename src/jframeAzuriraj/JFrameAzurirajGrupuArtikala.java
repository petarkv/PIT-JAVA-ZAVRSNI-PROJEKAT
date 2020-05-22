package jframeAzuriraj;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import jframe.JFrameGrupaArtikala;
import kontroler.Kontroler;
import model.GrupaArtikala;
import model.Magacin;
import model.Zaposleni;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class JFrameAzurirajGrupuArtikala extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldIdGrupeArtikalaAzurirajGA;
	private JComboBox comboBoxAzurirajGrupuArtikala;
	private JButton btnNazadAzurirajGA;	
	private GrupaArtikala ga;
	
	public JButton getBtnNazadAzurirajGA() {
		return btnNazadAzurirajGA;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameAzurirajGrupuArtikala frame = new JFrameAzurirajGrupuArtikala();
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
	public JFrameAzurirajGrupuArtikala() {
		setTitle("A\u017DURIRAJ GRUPU ARTIKALA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUnesiteGrupuArtikala = new JLabel("Unesite grupu artikala:");
		lblUnesiteGrupuArtikala.setFont(new Font("Arial", Font.BOLD, 14));
		lblUnesiteGrupuArtikala.setBounds(60, 20, 250, 20);
		contentPane.add(lblUnesiteGrupuArtikala);
		
		comboBoxAzurirajGrupuArtikala = new JComboBox();
		comboBoxAzurirajGrupuArtikala.setFont(new Font("Arial", Font.PLAIN, 13));
		comboBoxAzurirajGrupuArtikala.setBounds(60, 60, 300, 20);
		contentPane.add(comboBoxAzurirajGrupuArtikala);
		popuniComboBoxGrupaArtikala(comboBoxAzurirajGrupuArtikala);
		comboBoxAzurirajGrupuArtikala.setSelectedItem(null);
		comboBoxAzurirajGrupuArtikala.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			GrupaArtikala ga = (GrupaArtikala) comboBoxAzurirajGrupuArtikala.getSelectedItem();
			textFieldIdGrupeArtikalaAzurirajGA.setText(Integer.toString(ga.getIdGrupeArtikala()));		
		}
	});
		
		JLabel lblIdGrupeArtikalaAzurirajGA = new JLabel("ID grupe artikala :");
		lblIdGrupeArtikalaAzurirajGA.setFont(new Font("Arial", Font.BOLD, 14));
		lblIdGrupeArtikalaAzurirajGA.setBounds(60, 100, 150, 20);
		contentPane.add(lblIdGrupeArtikalaAzurirajGA);
		
		textFieldIdGrupeArtikalaAzurirajGA = new JTextField();
		textFieldIdGrupeArtikalaAzurirajGA.setFont(new Font("Arial", Font.PLAIN, 13));
		textFieldIdGrupeArtikalaAzurirajGA.setBounds(220, 100, 70, 20);
		contentPane.add(textFieldIdGrupeArtikalaAzurirajGA);
		textFieldIdGrupeArtikalaAzurirajGA.setColumns(10);
		
		JButton btnOtvoriteGrupuArtikalaAzurirajGA = new JButton("Otvorite grupu artikala ");
		btnOtvoriteGrupuArtikalaAzurirajGA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFrameGrupaArtikala jfoga = new JFrameGrupaArtikala();
				jfoga.getBtnObrisiGrupuArtikala().setVisible(false);
				jfoga.getBtnDodajGrupuArtikala().setVisible(false);			
				
				jfoga.getTextFieldIdGrupeArtikala().setEditable(false);
				
				
				int idga = Integer.parseInt(textFieldIdGrupeArtikalaAzurirajGA.getText().trim());
				
				try {
					ga = Kontroler.getInstance().getDetaljiGrupaArtikala(idga);
					
					jfoga.getTextFieldGrupaArtikala().setText(ga.getNazivGrupeArtikala());
					jfoga.getTextFieldIdGrupeArtikala().setText(Integer.toString(ga.getIdGrupeArtikala()));
					
					jfoga.setVisible(true);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				jfoga.getBtnAzurirajGrupuArtikala().addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						//int idga = Integer.parseInt(jfoga.getTextFieldIdGrupeArtikala().getText().trim());
						
						try {
							
							ga.setNazivGrupeArtikala(jfoga.getTextFieldGrupaArtikala().getText());							
							
							Kontroler.getInstance().updateGrupaArtikala(ga);
							JOptionPane.showMessageDialog(null, "Uspesno ste ažurirali grupu artikala!");
							//textFieldIdGrupeArtikalaObrisiGA.setText("");
							
							jfoga.setVisible(false);
						} catch (HeadlessException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					}
				});
				
				jfoga.getBtnPonistiAkcijuDodajGrupuArtikala().addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						jfoga.setVisible(false);
						
					}
				});
				jfoga.setVisible(true);
				
			}
		});
		btnOtvoriteGrupuArtikalaAzurirajGA.setFont(new Font("Arial", Font.BOLD, 14));
		btnOtvoriteGrupuArtikalaAzurirajGA.setBounds(60, 140, 200, 25);
		contentPane.add(btnOtvoriteGrupuArtikalaAzurirajGA);
		
		btnNazadAzurirajGA = new JButton("Nazad");
		btnNazadAzurirajGA.setFont(new Font("Arial", Font.BOLD, 14));
		btnNazadAzurirajGA.setBounds(270, 140, 90, 25);
		contentPane.add(btnNazadAzurirajGA);
	}
	
	private void popuniComboBoxGrupaArtikala(JComboBox<GrupaArtikala> comboBox) {
		try {
			ArrayList<GrupaArtikala> lista = Kontroler.getInstance().getGrupaArtikala();

			for (GrupaArtikala ga : lista) {
				comboBox.addItem(ga);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
