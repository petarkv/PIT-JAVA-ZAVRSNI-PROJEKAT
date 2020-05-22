package jframeObrisi;

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

public class JFrameObrisiArtikal extends JFrame {

	private JPanel contentPane;
	private JComboBox comboBoxGlavnaGrupaObrisi;
	private JComboBox comboBoxArtikalObrisi;
	private JButton btnNazadObrisiArtikal;	
	

	public JButton getBtnNazadObrisiArtikal() {
		return btnNazadObrisiArtikal;
	}

	public void setBtnNazadObrisiArtikal(JButton btnNazadObrisiArtikal) {
		this.btnNazadObrisiArtikal = btnNazadObrisiArtikal;
	}

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameObrisiArtikal frame = new JFrameObrisiArtikal();
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
	public JFrameObrisiArtikal() {
		setTitle("OBRI\u0160I ARTIKAL");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnOtvoriArtikalObrisi = new JButton("Otvorite artikal");
		btnOtvoriArtikalObrisi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int ida = ((Artikli)comboBoxArtikalObrisi.getSelectedItem()).getIdArtikla();
				JFrameArtikal jfa = new JFrameArtikal(ida);
				jfa.setVisible(true);
				jfa.getBtnDodajArtikal().setVisible(false);
				jfa.getBtnAzuriraj().setVisible(false);
				
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
				
				
			}
		});
		btnOtvoriArtikalObrisi.setFont(new Font("Arial", Font.BOLD, 14));
		btnOtvoriArtikalObrisi.setBounds(60, 180, 180, 25);
		contentPane.add(btnOtvoriArtikalObrisi);
		
		JLabel lblUnesiteGrupuArtikala = new JLabel("Unesite grupu artikala :");
		lblUnesiteGrupuArtikala.setFont(new Font("Arial", Font.BOLD, 14));
		lblUnesiteGrupuArtikala.setBounds(60, 20, 250, 20);
		contentPane.add(lblUnesiteGrupuArtikala);
		
		JComboBox comboBoxGrupaArtikalaObrisi = new JComboBox();
		comboBoxGrupaArtikalaObrisi.setFont(new Font("Arial", Font.PLAIN, 13));
		comboBoxGrupaArtikalaObrisi.setBounds(60, 60, 300, 20);
		contentPane.add(comboBoxGrupaArtikalaObrisi);
		popuniComboBoxGrupaArtikala(comboBoxGrupaArtikalaObrisi);
		comboBoxGrupaArtikalaObrisi.setSelectedItem(null);
		comboBoxGrupaArtikalaObrisi.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//JOptionPane.showMessageDialog(null, "COMBOBOX ACTION");
				if (comboBoxGrupaArtikalaObrisi.getSelectedItem() != null) {
					popuniComboBoxArtikli(comboBoxArtikalObrisi,
							((GrupaArtikala) comboBoxGrupaArtikalaObrisi.getSelectedItem()).getIdGrupeArtikala());
					comboBoxArtikalObrisi.setSelectedItem(null);
				}
				else
				{
					comboBoxArtikalObrisi.removeAllItems();
					comboBoxArtikalObrisi.setSelectedItem(null);
				}
			}
		});
		
		JLabel lblUnesiteArtikalObrisi = new JLabel("Unesite artikal :");
		lblUnesiteArtikalObrisi.setFont(new Font("Arial", Font.BOLD, 14));
		lblUnesiteArtikalObrisi.setBounds(60, 100, 250, 20);
		contentPane.add(lblUnesiteArtikalObrisi);
		
		comboBoxArtikalObrisi = new JComboBox();
		comboBoxArtikalObrisi.setFont(new Font("Arial", Font.PLAIN, 13));
		comboBoxArtikalObrisi.setBounds(60, 140, 300, 20);
		contentPane.add(comboBoxArtikalObrisi);
		//popuniComboBoxGrupaArtikala(comboBoxArtikalObrisi);
		comboBoxArtikalObrisi.setSelectedItem(null);		
		
	    btnNazadObrisiArtikal = new JButton("Nazad");
		btnNazadObrisiArtikal.setFont(new Font("Arial", Font.BOLD, 14));
		btnNazadObrisiArtikal.setBounds(260, 180, 100, 25);
		contentPane.add(btnNazadObrisiArtikal);

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
	
	    

