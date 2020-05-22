package jframe;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import com.toedter.calendar.JDateChooser;

import jframeObrisi.JFrameObrisiArtikal;
import kontroler.Kontroler;
import model.Artikli;
import model.GrupaArtikala;
import model.Magacin;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class JFrameArtikal extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNazivArtikla;
	private JTextField textFieldNetoCenaArtikla;
	private JTextField textFieldMarza;
	private JTextField textFieldIDArtikla;
	private JComboBox comboBoxJedinicaMere;
	private JComboBox comboBoxGrupaArtikla;
	private JComboBox comboBoxStopaPDV;	
	private JButton btnPonistiAkciju;	
	private JTextField textFieldNazivGrupeArtikala;
	private JButton btnObrisiArtikal;
	private JButton btnDodajArtikal;
	private JButton btnAzuriraj;
	private JLabel lblIdArtikla;
	

	public JTextField getTextFieldNazivGrupeArtikala() {
		return textFieldNazivGrupeArtikala;
	}

	public void setTextFieldNazivGrupeArtikala(JTextField textFieldNazivGrupeArtikala) {
		this.textFieldNazivGrupeArtikala = textFieldNazivGrupeArtikala;
	}

	public JButton getBtnDodajArtikal() {
		return btnDodajArtikal;
	}

	public JButton getBtnAzuriraj() {
		return btnAzuriraj;
	}

	public JButton getBtnPonistiAkciju() {
		return btnPonistiAkciju;
	}

	public void setBtnPonistiAkciju(JButton btnPonistiAkciju) {
		this.btnPonistiAkciju = btnPonistiAkciju;
	}

	public JTextField getTextFieldNazivArtikla() {
		return textFieldNazivArtikla;
	}

	public void setTextFieldNazivArtikla(JTextField textFieldNazivArtikla) {
		this.textFieldNazivArtikla = textFieldNazivArtikla;
	}

	public JTextField getTextFieldNetoCenaArtikla() {
		return textFieldNetoCenaArtikla;
	}

	public void setTextFieldNetoCenaArtikla(JTextField textFieldNetoCenaArtikla) {
		this.textFieldNetoCenaArtikla = textFieldNetoCenaArtikla;
	}

	public JTextField getTextFieldMarza() {
		return textFieldMarza;
	}

	public void setTextFieldMarza(JTextField textFieldMarza) {
		this.textFieldMarza = textFieldMarza;
	}

	public JTextField getTextFieldIDArtikla() {
		return textFieldIDArtikla;
	}

	public void setTextFieldIDArtikla(JTextField textFieldIDArtikla) {
		this.textFieldIDArtikla = textFieldIDArtikla;
	}

	public JComboBox getComboBoxJedinicaMere() {
		return comboBoxJedinicaMere;
	}

	public void setComboBoxJedinicaMere(JComboBox comboBoxJedinicaMere) {
		this.comboBoxJedinicaMere = comboBoxJedinicaMere;
	}

	public JComboBox getComboBoxGrupaArtikla() {
		return comboBoxGrupaArtikla;
	}

	public void setComboBoxGrupaArtikla(JComboBox comboBoxGrupaArtikla) {
		this.comboBoxGrupaArtikla = comboBoxGrupaArtikla;
	}

	public JComboBox getComboBoxStopaPDV() {
		return comboBoxStopaPDV;
	}

	public void setComboBoxStopaPDV(JComboBox comboBoxStopaPDV) {
		this.comboBoxStopaPDV = comboBoxStopaPDV;
	}	

	public JButton getBtnObrisiArtikal() {
		return btnObrisiArtikal;
	}	

	public JLabel getLblIdArtikla() {
		return lblIdArtikla;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameArtikal frame = new JFrameArtikal(0);
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
	public JFrameArtikal(int ida) {
		setTitle("ARTIKAL");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 860, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panelArtikal = new JPanel();
		panelArtikal.setBorder(
				new TitledBorder(null, "Podaci o artiklu", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelArtikal.setBounds(10, 10, 400, 220);
		contentPane.add(panelArtikal);
		panelArtikal.setLayout(null);

		JLabel lblNazivArtikla = new JLabel("Naziv artikla :");
		lblNazivArtikla.setFont(new Font("Arial", Font.BOLD, 14));
		lblNazivArtikla.setBounds(10, 100, 150, 20);
		panelArtikal.add(lblNazivArtikla);

		JLabel lblJedinicaMere = new JLabel("Jedinica mere :");
		lblJedinicaMere.setFont(new Font("Arial", Font.BOLD, 14));
		lblJedinicaMere.setBounds(10, 140, 150, 20);
		panelArtikal.add(lblJedinicaMere);

		JLabel lblGrupaArtikla = new JLabel("Grupa artikala :");
		lblGrupaArtikla.setFont(new Font("Arial", Font.BOLD, 14));
		lblGrupaArtikla.setBounds(10, 20, 150, 20);
		panelArtikal.add(lblGrupaArtikla);

		textFieldNazivArtikla = new JTextField();
		textFieldNazivArtikla.setFont(new Font("Arial", Font.PLAIN, 13));
		textFieldNazivArtikla.setBounds(170, 100, 220, 20);
		panelArtikal.add(textFieldNazivArtikla);
		textFieldNazivArtikla.setColumns(10);

		comboBoxJedinicaMere = new JComboBox();
		comboBoxJedinicaMere.setFont(new Font("Arial", Font.PLAIN, 13));
		comboBoxJedinicaMere
				.setModel(new DefaultComboBoxModel(new String[] {"Kilogram", "Gram", "Litar", "Komad"}));
		comboBoxJedinicaMere.setBounds(170, 140, 220, 20);
		panelArtikal.add(comboBoxJedinicaMere);
		comboBoxJedinicaMere.setSelectedItem(null);

		lblIdArtikla = new JLabel("ID artikla :");
		lblIdArtikla.setFont(new Font("Arial", Font.BOLD, 14));
		lblIdArtikla.setBounds(10, 180, 150, 20);
		panelArtikal.add(lblIdArtikla);

		textFieldIDArtikla = new JTextField();
		textFieldIDArtikla.setFont(new Font("Arial", Font.PLAIN, 13));
		textFieldIDArtikla.setBounds(170, 180, 70, 20);
		panelArtikal.add(textFieldIDArtikla);
		textFieldIDArtikla.setColumns(10);

		comboBoxGrupaArtikla = new JComboBox();
		comboBoxGrupaArtikla.setFont(new Font("Arial", Font.PLAIN, 13));
		comboBoxGrupaArtikla.setBounds(170, 20, 220, 20);
		panelArtikal.add(comboBoxGrupaArtikla);
		popuniComboBoxGrupaArtikala(comboBoxGrupaArtikla);
		comboBoxGrupaArtikla.setSelectedItem(null);
		comboBoxGrupaArtikla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (comboBoxGrupaArtikla.getSelectedItem() != null) {
					GrupaArtikala a = (GrupaArtikala) comboBoxGrupaArtikla.getSelectedItem();
					textFieldNazivGrupeArtikala.setText(a.getNazivGrupeArtikala());
				}
			}
		});		
		
		
		JLabel lblNazivGrupeArtikala = new JLabel("Naziv grupe artikala:");
		lblNazivGrupeArtikala.setFont(new Font("Arial", Font.BOLD, 14));
		lblNazivGrupeArtikala.setBounds(10, 60, 150, 20);
		panelArtikal.add(lblNazivGrupeArtikala);
		
		textFieldNazivGrupeArtikala = new JTextField();
		textFieldNazivGrupeArtikala.setFont(new Font("Arial", Font.PLAIN, 13));
		textFieldNazivGrupeArtikala.setBounds(170, 60, 220, 20);
		panelArtikal.add(textFieldNazivGrupeArtikala);
		textFieldNazivGrupeArtikala.setColumns(10);

		btnDodajArtikal = new JButton("Dodaj artikal");
		btnDodajArtikal.setFont(new Font("Arial", Font.BOLD, 14));
		btnDodajArtikal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					
					String naziv = textFieldNazivArtikla.getText().trim();
					String naziv_grupe_artikala = textFieldNazivGrupeArtikala.getText().trim();
					String jm = (String) comboBoxJedinicaMere.getSelectedItem();
					GrupaArtikala ga = (GrupaArtikala) comboBoxGrupaArtikla.getSelectedItem();
					double netocena = Double.parseDouble(textFieldNetoCenaArtikla.getText().trim());
					int stopaPdv = Integer.parseInt((String) comboBoxStopaPDV.getSelectedItem());
					double marza = Double.parseDouble(textFieldMarza.getText().trim());

					Artikli a = new Artikli(0, ga.getIdGrupeArtikala(), naziv_grupe_artikala, naziv, jm, netocena, stopaPdv, marza);

					Kontroler.getInstance().insertArikli(a);
					JOptionPane.showMessageDialog(null, "Uspesno ste uneli artikal");
					
					textFieldNazivArtikla.setText("");
					textFieldNazivGrupeArtikala.setText("");
					textFieldNetoCenaArtikla.setText("");
					textFieldMarza.setText("");
					comboBoxStopaPDV.setSelectedItem(null);
					comboBoxJedinicaMere.setSelectedItem(null);
					comboBoxGrupaArtikla.setSelectedItem(null);	
					
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "Sva polja moraju biti popunjena!");					
					
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
			
		});
		btnDodajArtikal.setBounds(430, 240, 180, 25);
		contentPane.add(btnDodajArtikal);

		btnObrisiArtikal = new JButton("Obri\u0161i artikal");
		btnObrisiArtikal.setFont(new Font("Arial", Font.BOLD, 14));
		btnObrisiArtikal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int rba = Integer.parseInt(textFieldIDArtikla.getText().trim());
				
				try {
					Kontroler.getInstance().deleteArtikal(rba);
					JOptionPane.showMessageDialog(null, "Uspesno ste obrisali artikal!");
					
					textFieldNazivArtikla.setText("");
					textFieldNazivGrupeArtikala.setText("");
					textFieldNetoCenaArtikla.setText("");
					textFieldMarza.setText("");
					comboBoxStopaPDV.setSelectedItem(null);
					comboBoxJedinicaMere.setSelectedItem(null);
					comboBoxGrupaArtikla.setSelectedItem(null);
					
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
		btnObrisiArtikal.setBounds(650, 240, 180, 25);
		contentPane.add(btnObrisiArtikal);

		btnAzuriraj = new JButton("A\u017Euriraj");
		btnAzuriraj.setFont(new Font("Arial", Font.BOLD, 14));
		btnAzuriraj.setBounds(430, 290, 180, 25);
		contentPane.add(btnAzuriraj);

		btnPonistiAkciju = new JButton("Poni\u0161ti akciju");
		btnPonistiAkciju.setFont(new Font("Arial", Font.BOLD, 14));
		btnPonistiAkciju.setBounds(650, 290, 180, 25);
		contentPane.add(btnPonistiAkciju);
		
				JPanel panelEkonomskiPodaciOArtiklu = new JPanel();
				panelEkonomskiPodaciOArtiklu.setBounds(430, 10, 400, 220);
				contentPane.add(panelEkonomskiPodaciOArtiklu);
				panelEkonomskiPodaciOArtiklu.setBorder(new TitledBorder(null, "Ekonomski podaci o artiklu",
						TitledBorder.LEADING, TitledBorder.TOP, null, null));
				panelEkonomskiPodaciOArtiklu.setLayout(null);
				
						JLabel lblMarza = new JLabel("Mar\u017Ea :");
						lblMarza.setFont(new Font("Arial", Font.BOLD, 14));
						lblMarza.setBounds(10, 100, 120, 20);
						panelEkonomskiPodaciOArtiklu.add(lblMarza);
						
								JLabel lblStopaPdva = new JLabel("Stopa PDV-a :");
								lblStopaPdva.setFont(new Font("Arial", Font.BOLD, 14));
								lblStopaPdva.setBounds(10, 60, 120, 20);
								panelEkonomskiPodaciOArtiklu.add(lblStopaPdva);
								
										JLabel lblNetoCenaArtikla = new JLabel("Neto cena artikla :");
										lblNetoCenaArtikla.setFont(new Font("Arial", Font.BOLD, 14));
										lblNetoCenaArtikla.setBounds(10, 20, 140, 20);
										panelEkonomskiPodaciOArtiklu.add(lblNetoCenaArtikla);
										
												textFieldNetoCenaArtikla = new JTextField();
												textFieldNetoCenaArtikla.setFont(new Font("Arial", Font.PLAIN, 13));
												textFieldNetoCenaArtikla.setBounds(160, 20, 230, 20);
												panelEkonomskiPodaciOArtiklu.add(textFieldNetoCenaArtikla);
												textFieldNetoCenaArtikla.setColumns(10);
												
														comboBoxStopaPDV = new JComboBox();
														comboBoxStopaPDV.setFont(new Font("Arial", Font.PLAIN, 13));
														comboBoxStopaPDV.setModel(new DefaultComboBoxModel(new String[] {"10", "20"}));
														comboBoxStopaPDV.setBounds(160, 60, 230, 20);
														panelEkonomskiPodaciOArtiklu.add(comboBoxStopaPDV);
														comboBoxStopaPDV.setSelectedItem(null);
														
																textFieldMarza = new JTextField();
																textFieldMarza.setFont(new Font("Arial", Font.PLAIN, 13));
																textFieldMarza.setBounds(160, 100, 230, 20);
																panelEkonomskiPodaciOArtiklu.add(textFieldMarza);
																textFieldMarza.setColumns(10);
		
		if(ida > 0)
		{
			//daj iz baze
			//popuni polja
			
			try {
				Artikli a = Kontroler.getInstance().getDetaljiArtikli(ida);
				
				//comboBoxGrupaArtikla.setSelectedItem(a.getIdgrupaArtikla());
				comboBoxGrupaArtikla.setSelectedIndex(0);
				comboBoxGrupaArtikla.getModel().setSelectedItem(Kontroler.getInstance().getGrupaArtikala(a.getIdgrupaArtikla()).get(0));
				//textFieldNazivGrupeArtikala.setText(comboBoxGrupaArtikla.getSelectedItem());
				GrupaArtikala ga = (GrupaArtikala) comboBoxGrupaArtikla.getSelectedItem();
				textFieldNazivGrupeArtikala.setText(ga.getNazivGrupeArtikala());
				textFieldNazivArtikla.setText(a.getNaziv_artikla());
				comboBoxJedinicaMere.setSelectedItem(a.getJedinica_mere());
				textFieldIDArtikla.setText(Integer.toString(a.getIdArtikla()));
				textFieldNetoCenaArtikla.setText(Double.toString(a.getNeto_cena_artikla()));
				comboBoxStopaPDV.getModel().setSelectedItem(a.getStopa_PDV());
				textFieldMarza.setText(Double.toString(a.getMarza_artikla()));
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
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
