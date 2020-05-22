package jframePregled;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import kontroler.Kontroler;
import model.Artikli;
import model.GrupaArtikala;
import model.Kupac;
import model.StavkeRacunaOtpremnice;
import table.JTableModelProdajnaCenaArtikla;
import table.JTableModelRacunOtpremnica;
import table.JTableModelStavkeRacunaOtpremnice;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Font;

public class JFrameStavkeRacunaPregled extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldJedinicaMere;
	private JTextField textFieldDostupnaKolicina;
	private JTextField textFieldKolicina;
	private JTextField textFieldRabat;
	private JTable tableRacunOtpremnica;
	private JButton btnPrekidStavkeRacuna;
	private JButton btnSacuvajStavkeRacuna;
	private JComboBox comboBoxGrupaArtikalaRacunStavke;
	private JComboBox comboBoxArtikalRacunStavke;
	private JTextField textFieldIdRacunStavkeRacuna;
	private int generatedID;
	
	
	
	
	public JComboBox getComboBoxGrupaArtikalaRacunStavke() {
		return comboBoxGrupaArtikalaRacunStavke;
	}
	public JTextField getTextFieldIdRacunStavkeRacuna() {
		return textFieldIdRacunStavkeRacuna;
	}
	public JComboBox<Artikli> getComboBoxArtikalRacunStavke() {
		return comboBoxArtikalRacunStavke;
	}
	public JButton getBtnSacuvajStavkeRacuna() {
		return btnSacuvajStavkeRacuna;
	}

	public JButton getBtnPrekidStavkeRacuna() {
		return btnPrekidStavkeRacuna;
	}
	
	public JTable getTableRacunOtpremnica() {
		return tableRacunOtpremnica;
	}

	public void setTableRacunOtpremnica(JTable tableRacunOtpremnica) {
		this.tableRacunOtpremnica = tableRacunOtpremnica;
	}

	public JPanel getContentPane() {
		return contentPane;
	}

	public JTextField getTextFieldJedinicaMere() {
		return textFieldJedinicaMere;
	}

	public JTextField getTextFieldDostupnaKolicina() {
		return textFieldDostupnaKolicina;
	}

	public JTextField getTextFieldKolicina() {
		return textFieldKolicina;
	}

	public JTextField getTextFieldRabat() {
		return textFieldRabat;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameStavkeRacunaPregled frame = new JFrameStavkeRacunaPregled();
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
	public JFrameStavkeRacunaPregled() {
		setTitle("STAVKE PRODAJE RA\u010CUNA / OTPREMNICE");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblGrupaArtikala = new JLabel("Grupa artikala :");
		lblGrupaArtikala.setFont(new Font("Arial", Font.BOLD, 14));
		lblGrupaArtikala.setBounds(10, 30, 150, 20);
		contentPane.add(lblGrupaArtikala);
		
		JLabel lblArtikal = new JLabel("Artikal :");
		lblArtikal.setFont(new Font("Arial", Font.BOLD, 14));
		lblArtikal.setBounds(10, 60, 150, 20);
		contentPane.add(lblArtikal);
		
		JLabel lblJedinicaMere = new JLabel("Jedinica mere :");
		lblJedinicaMere.setFont(new Font("Arial", Font.BOLD, 14));
		lblJedinicaMere.setBounds(10, 90, 150, 20);
		contentPane.add(lblJedinicaMere);
		
		JLabel lblDostupnaKolicina = new JLabel("Dostupna koli\u010Dina :");
		lblDostupnaKolicina.setFont(new Font("Arial", Font.BOLD, 14));
		lblDostupnaKolicina.setBounds(10, 120, 150, 20);
		contentPane.add(lblDostupnaKolicina);
		
		JLabel lblKolicina = new JLabel("Koli\u010Dina :");
		lblKolicina.setFont(new Font("Arial", Font.BOLD, 14));
		lblKolicina.setBounds(10, 150, 150, 20);
		contentPane.add(lblKolicina);
		
		JLabel lblRabat = new JLabel("Rabat :");
		lblRabat.setFont(new Font("Arial", Font.BOLD, 14));
		lblRabat.setBounds(10, 180, 150, 20);
		contentPane.add(lblRabat);
		
		textFieldJedinicaMere = new JTextField();
		textFieldJedinicaMere.setFont(new Font("Arial", Font.PLAIN, 13));
		textFieldJedinicaMere.setBounds(180, 90, 160, 20);
		contentPane.add(textFieldJedinicaMere);
		textFieldJedinicaMere.setColumns(10);
		
		textFieldDostupnaKolicina = new JTextField();
		textFieldDostupnaKolicina.setFont(new Font("Arial", Font.PLAIN, 13));
		textFieldDostupnaKolicina.setBounds(180, 120, 160, 20);
		contentPane.add(textFieldDostupnaKolicina);
		textFieldDostupnaKolicina.setColumns(10);
		textFieldDostupnaKolicina.setText("*****");
		textFieldDostupnaKolicina.setEditable(false);
		
		textFieldKolicina = new JTextField();
		textFieldKolicina.setFont(new Font("Arial", Font.PLAIN, 13));
		textFieldKolicina.setBounds(180, 150, 160, 20);
		contentPane.add(textFieldKolicina);
		textFieldKolicina.setColumns(10);
		
		textFieldRabat = new JTextField();
		textFieldRabat.setFont(new Font("Arial", Font.PLAIN, 13));
		textFieldRabat.setBounds(180, 180, 160, 20);
		contentPane.add(textFieldRabat);
		textFieldRabat.setColumns(10);
		
		JScrollPane scrollPaneRacunOtpremnica = new JScrollPane();
		scrollPaneRacunOtpremnica.setBounds(10, 230, 664, 170);
		contentPane.add(scrollPaneRacunOtpremnica);
		
		tableRacunOtpremnica = new JTable();
		scrollPaneRacunOtpremnica.setViewportView(tableRacunOtpremnica);	
		
		
				
		btnSacuvajStavkeRacuna = new JButton("Sa\u010Duvaj");
		btnSacuvajStavkeRacuna.setFont(new Font("Arial", Font.BOLD, 14));
		btnSacuvajStavkeRacuna.setBounds(10, 430, 150, 25);
		contentPane.add(btnSacuvajStavkeRacuna);
		
		btnPrekidStavkeRacuna = new JButton("Prekid");
		btnPrekidStavkeRacuna.setFont(new Font("Arial", Font.BOLD, 14));
		btnPrekidStavkeRacuna.setBounds(220, 430, 150, 25);
		contentPane.add(btnPrekidStavkeRacuna);
		
		comboBoxGrupaArtikalaRacunStavke = new JComboBox();
		comboBoxGrupaArtikalaRacunStavke.setFont(new Font("Arial", Font.PLAIN, 13));
		comboBoxGrupaArtikalaRacunStavke.setBounds(180, 30, 160, 20);
		contentPane.add(comboBoxGrupaArtikalaRacunStavke);		
		popuniComboBoxGrupaArtikala(comboBoxGrupaArtikalaRacunStavke);
		comboBoxGrupaArtikalaRacunStavke.setSelectedItem(null);	
		
		comboBoxGrupaArtikalaRacunStavke.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if (comboBoxGrupaArtikalaRacunStavke.getSelectedItem() != null) {

					// pamcenje i skidanje actionlistener-a
					// ActionListener al = comboBoxArtikalRacunStavke.getActionListeners()[0];
					// comboBoxArtikalRacunStavke.removeActionListener(al);

					popuniComboBoxArtikli(comboBoxArtikalRacunStavke,
							((GrupaArtikala) comboBoxGrupaArtikalaRacunStavke.getSelectedItem()).getIdGrupeArtikala());
					comboBoxArtikalRacunStavke.setSelectedItem(null);

					// vracanje zapamcenog actionlistener-a
					// comboBoxArtikalRacunStavke.addActionListener(al);
				} else {
					// comboBoxArtikalRacunStavke.removeAllItems();
					popuniComboBoxArtikliTSVI(comboBoxArtikalRacunStavke);
					comboBoxArtikalRacunStavke.setSelectedItem(null);
				}

			}
		});
	
		
		comboBoxArtikalRacunStavke = new JComboBox();
		comboBoxArtikalRacunStavke.setFont(new Font("Arial", Font.PLAIN, 13));
		comboBoxArtikalRacunStavke.setEditable(true);
		comboBoxArtikalRacunStavke.setBounds(180, 60, 160, 20);
		popuniComboBoxArtikliTSVI(comboBoxArtikalRacunStavke);		
		org.jdesktop.swingx.autocomplete.AutoCompleteDecorator.decorate(comboBoxArtikalRacunStavke);
		contentPane.add(comboBoxArtikalRacunStavke);
		comboBoxArtikalRacunStavke.setSelectedItem(null);
		
		comboBoxArtikalRacunStavke.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {				
				
				try {
					if(comboBoxArtikalRacunStavke.getSelectedItem() != null) {
						
						//ActionListener al = comboBoxArtikalRacunStavke.getActionListeners()[0];
					    //comboBoxArtikalRacunStavke.removeActionListener(al);
						
						//String jm = (String) comboBoxArtikalRacunStavke.getSelectedItem().getClass();
						
						
						textFieldJedinicaMere.setText(((Artikli) comboBoxArtikalRacunStavke.getSelectedItem()).getJedinica_mere());
						
						//comboBoxArtikalRacunStavke.addActionListener(al);
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					//e1.printStackTrace();
					textFieldJedinicaMere.setText("");
				}
				
			}
		});
		
		
		
			
		
		textFieldIdRacunStavkeRacuna = new JTextField();
		textFieldIdRacunStavkeRacuna.setBounds(423, 23, 86, 20);
		contentPane.add(textFieldIdRacunStavkeRacuna);
		textFieldIdRacunStavkeRacuna.setColumns(10);
		textFieldIdRacunStavkeRacuna.setVisible(false);

	}
	
	
	
	private void postaviModel(ArrayList lista, JTable t){
		JTableModelRacunOtpremnica model = new JTableModelRacunOtpremnica(lista);
		t.setModel(model);
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
	
	private void popuniComboBoxArtikliTSVI(JComboBox<Artikli> comboBox) {
		
		try {
			comboBox.removeAllItems();
			ArrayList<Artikli> lista1 = Kontroler.getInstance().getArtikliSVI();

			// for (GlavnaGrupa gg : lista) {
			for (Artikli a : lista1) {
				comboBox.addItem(a);		

			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}	
	

    private  void popuniComboBoxArtikli(JComboBox<Artikli> comboBox, Integer id_grupe_artikala) {
		

		try {
			comboBox.removeAllItems();
			ArrayList<Artikli> lista1 = Kontroler.getInstance().getArtikli(id_grupe_artikala);

			// for (GlavnaGrupa gg : lista) {
			for (Artikli a : lista1) {
				comboBox.addItem(a);		

			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}	
}
