package jframeAzuriraj;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import jframe.JFrameArtikal;
import kontroler.Kontroler;
import model.Artikli;
import model.GrupaArtikala;
import model.Magacin;

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

public class JFrameAzurirajArtikal extends JFrame {

	private JPanel contentPane;
	private JComboBox comboBoxGlavnaGrupaObrisi;
	private JComboBox comboBoxArtikalAzuriraj;
	private JButton btnNazadAzurirajArtikal;	
	private Artikli a;
	

	public JButton getBtnNazadAzurirajArtikal() {
		return btnNazadAzurirajArtikal;
	}

	public void setBtnNazadObrisiArtikal(JButton btnNazadAzurirajArtikal) {
		this.btnNazadAzurirajArtikal = btnNazadAzurirajArtikal;
	}

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameAzurirajArtikal frame = new JFrameAzurirajArtikal();
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
	public JFrameAzurirajArtikal() {
		setTitle("A\u017DURIRAJ ARTIKAL");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnOtvoriArtikalAzuriraj = new JButton("Otvorite artikal");
		btnOtvoriArtikalAzuriraj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int ida = ((Artikli)comboBoxArtikalAzuriraj.getSelectedItem()).getIdArtikla();
				JFrameArtikal jfa = new JFrameArtikal(ida);
				jfa.setVisible(true);
				jfa.getBtnDodajArtikal().setVisible(false);				
				jfa.getBtnObrisiArtikal().setVisible(false);
				
				jfa.getTextFieldIDArtikla().setEditable(false);
				
				jfa.getBtnAzuriraj().setBounds(650, 240, 180, 25);
				
				jfa.getBtnPonistiAkciju().addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						jfa.setVisible(false);
						
					}
				});
				jfa.setVisible(true);
				/*try {
					Artikli a = Kontroler.getInstance().getDetaljiArtikli(ida);
					
					jfa.getComboBoxGrupaArtikla().setSelectedItem(a.getIdgrupaArtikla());
					jfa.getTextFieldNazivArtikla().setText(a.getNaziv_artikla());
					jfa.getComboBoxJedinicaMere().setSelectedItem(a.getJedinica_mere());
					jfa.getTextFieldIDArtikla().setText(Integer.toString(a.getIdArtikla()));
					jfa.getTextFieldNetoCenaArtikla().setText(Double.toString(a.getNeto_cena_artikla()));
					jfa.getComboBoxStopaPDV().setSelectedItem(a.getStopa_PDV());
					jfa.getTextFieldMarza().setText(Double.toString(a.getMarza_artikla()));
					
					jfa.setVisible(true);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/	
				
				jfa.getBtnAzuriraj().addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						
						
						try {
							
							a=Kontroler.getInstance().getDetaljiArtikli(ida);
							
							a.setIdgrupaArtikla(((GrupaArtikala)jfa.getComboBoxGrupaArtikla().getSelectedItem()).getIdGrupeArtikala());
							a.setNaziv_grupe_artikala(jfa.getTextFieldNazivGrupeArtikala().getText());
							a.setNaziv_artikla(jfa.getTextFieldNazivArtikla().getText());
							a.setJedinica_mere(jfa.getComboBoxJedinicaMere().getSelectedItem().toString());
							a.setNeto_cena_artikla(Double.parseDouble(jfa.getTextFieldNetoCenaArtikla().getText()));
							a.setStopa_PDV(Integer.parseInt(jfa.getComboBoxStopaPDV().getSelectedItem().toString()));
							a.setMarza_artikla(Double.parseDouble(jfa.getTextFieldMarza().getText()));				
							
							
							
							Kontroler.getInstance().updateArtikli(a);
							
							JOptionPane.showMessageDialog(null, "Uspesno ste ažurirali artikal!");
							jfa.setVisible(false);
						} catch (ClassNotFoundException | SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					}
				});
				
			}
		});
		btnOtvoriArtikalAzuriraj.setFont(new Font("Arial", Font.BOLD, 14));
		btnOtvoriArtikalAzuriraj.setBounds(60, 180, 180, 25);
		contentPane.add(btnOtvoriArtikalAzuriraj);
		
		JLabel lblUnesiteGrupuArtikala = new JLabel("Unesite grupu artikala :");
		lblUnesiteGrupuArtikala.setFont(new Font("Arial", Font.BOLD, 14));
		lblUnesiteGrupuArtikala.setBounds(60, 20, 250, 20);
		contentPane.add(lblUnesiteGrupuArtikala);
		
		JComboBox comboBoxGrupaArtikalaAzuriraj = new JComboBox();
		comboBoxGrupaArtikalaAzuriraj.setFont(new Font("Arial", Font.PLAIN, 13));
		comboBoxGrupaArtikalaAzuriraj.setBounds(60, 60, 300, 20);
		contentPane.add(comboBoxGrupaArtikalaAzuriraj);
		popuniComboBoxGrupaArtikala(comboBoxGrupaArtikalaAzuriraj);
		comboBoxGrupaArtikalaAzuriraj.setSelectedItem(null);
		comboBoxGrupaArtikalaAzuriraj.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//JOptionPane.showMessageDialog(null, "COMBOBOX ACTION");
				if (comboBoxGrupaArtikalaAzuriraj.getSelectedItem() != null) {
					popuniComboBoxArtikli(comboBoxArtikalAzuriraj,
							((GrupaArtikala) comboBoxGrupaArtikalaAzuriraj.getSelectedItem()).getIdGrupeArtikala());
					comboBoxArtikalAzuriraj.setSelectedItem(null);
				}
				else
				{
					comboBoxArtikalAzuriraj.removeAllItems();
					comboBoxArtikalAzuriraj.setSelectedItem(null);
				}
			}
		});
		
		JLabel lblUnesiteArtikalAzuriraj = new JLabel("Unesite artikal :");
		lblUnesiteArtikalAzuriraj.setFont(new Font("Arial", Font.BOLD, 14));
		lblUnesiteArtikalAzuriraj.setBounds(60, 100, 250, 20);
		contentPane.add(lblUnesiteArtikalAzuriraj);
		
		comboBoxArtikalAzuriraj = new JComboBox();
		comboBoxArtikalAzuriraj.setFont(new Font("Arial", Font.PLAIN, 13));
		comboBoxArtikalAzuriraj.setBounds(60, 140, 300, 20);
		contentPane.add(comboBoxArtikalAzuriraj);
		//popuniComboBoxGrupaArtikala(comboBoxArtikalObrisi);
		comboBoxArtikalAzuriraj.setSelectedItem(null);		
		
	    btnNazadAzurirajArtikal = new JButton("Nazad");
		btnNazadAzurirajArtikal.setFont(new Font("Arial", Font.BOLD, 14));
		btnNazadAzurirajArtikal.setBounds(260, 180, 100, 25);
		contentPane.add(btnNazadAzurirajArtikal);

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
	
	private void popuniComboBoxArtikli(JComboBox<Artikli> comboBox, Integer id_grupe_artikala) {
		try {
			comboBox.removeAllItems();
			
			//ArrayList<GlavnaGrupa> lista = Kontroler.getInstance().getGlavnaGrupaArtikala();
			ArrayList<Artikli> lista1 = Kontroler.getInstance().getArtikli(id_grupe_artikala);

			//for (GlavnaGrupa gg : lista) {
				for (Artikli a : lista1) {
					comboBox.addItem(a);
					
				}
				
				
			//}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}	
	
}
	
	    

