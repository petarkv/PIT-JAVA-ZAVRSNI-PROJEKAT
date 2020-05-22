package jframeIzvestaji;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import kontroler.Kontroler;
import model.Artikli;
import model.GrupaArtikala;
import table.JTableModelCenaArtikla;
import table.JTableModelGrupeArtikala;

import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.Font;

public class JFrameCenaArtikla extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTable tableCenaArtikla;
	private JButton btnNazadCenaArtikla;
	private JComboBox comboBoxArtikalCenaArtikala;
	private JComboBox comboBoxGrupaArtikalaCenaArtikala;
	private JButton btnPonistiSortiranje;

	public JButton getBtnNazadCenaArtikla() {
		return btnNazadCenaArtikla;
	}
	public JTable getTableCenaArtikla() {
		return tableCenaArtikla;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameCenaArtikla frame = new JFrameCenaArtikla();
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
	public JFrameCenaArtikla() {
		setTitle("PREGLED CENA ARTIKALA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblGrupaArtiklaCenaArtikla = new JLabel("Grupa artikala :");
		lblGrupaArtiklaCenaArtikla.setFont(new Font("Arial", Font.BOLD, 14));
		lblGrupaArtiklaCenaArtikla.setBounds(10, 30, 120, 20);
		contentPane.add(lblGrupaArtiklaCenaArtikla);
		
		JLabel lblArtikal = new JLabel("Artikal :");
		lblArtikal.setFont(new Font("Arial", Font.BOLD, 14));
		lblArtikal.setBounds(10, 70, 100, 20);
		contentPane.add(lblArtikal);
		
		JScrollPane scrollPaneCenaArtikla = new JScrollPane();
		scrollPaneCenaArtikla.setBounds(10, 130, 810, 350);
		contentPane.add(scrollPaneCenaArtikla);
		
		btnNazadCenaArtikla = new JButton("Nazad");
		btnNazadCenaArtikla.setFont(new Font("Arial", Font.BOLD, 14));
		btnNazadCenaArtikla.setBounds(670, 520, 150, 25);
		contentPane.add(btnNazadCenaArtikla);
		
		comboBoxGrupaArtikalaCenaArtikala  = new JComboBox<GrupaArtikala>();
		comboBoxGrupaArtikalaCenaArtikala.setFont(new Font("Arial", Font.PLAIN, 13));
		comboBoxGrupaArtikalaCenaArtikala.setBounds(200, 30, 200, 20);
		contentPane.add(comboBoxGrupaArtikalaCenaArtikala);
		popuniComboBoxGrupaArtikala(comboBoxGrupaArtikalaCenaArtikala);
		comboBoxGrupaArtikalaCenaArtikala.setSelectedItem(null);
		
		
		
		comboBoxGrupaArtikalaCenaArtikala.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e1) {
				//JOptionPane.showMessageDialog(null, "COMBOBOX ACTION");
				if (comboBoxGrupaArtikalaCenaArtikala.getSelectedItem() != null) {
					
					//pamcenje i skidanje actionlistener-a
					ActionListener al = comboBoxArtikalCenaArtikala.getActionListeners()[0];
					comboBoxArtikalCenaArtikala.removeActionListener(al);
					
					popuniComboBoxArtikli(comboBoxArtikalCenaArtikala,
							((GrupaArtikala) comboBoxGrupaArtikalaCenaArtikala.getSelectedItem()).getIdGrupeArtikala());
					comboBoxArtikalCenaArtikala.setSelectedItem(null);
					
					//vracanje zapamcenog actionlistener-a
					comboBoxArtikalCenaArtikala.addActionListener(al);
				}
			else
				{
					comboBoxArtikalCenaArtikala.removeAllItems();
					popuniComboBoxArtikliTSVI(comboBoxArtikalCenaArtikala);
					comboBoxArtikalCenaArtikala.setSelectedItem(null);
				}
			}
			
		});
		
		comboBoxGrupaArtikalaCenaArtikala.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				postaviModelCeneArtikla(new ArrayList<GrupaArtikala>(), tableCenaArtikla);
				ArrayList<Artikli>lista;
				try {
					    if(comboBoxGrupaArtikalaCenaArtikala.getSelectedItem() != null) {
						lista = Kontroler.getInstance().getArtikli(((GrupaArtikala) 
									comboBoxGrupaArtikalaCenaArtikala.getSelectedItem()).getIdGrupeArtikala());
						postaviModelCeneArtikla(lista, tableCenaArtikla);
					    }else {
					    	popuniComboBoxArtikliTSVI(comboBoxArtikalCenaArtikala);
					    }
					} catch (ClassNotFoundException | SQLException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
				
			}
		});
	
		comboBoxArtikalCenaArtikala = new JComboBox<Artikli>();
		comboBoxArtikalCenaArtikala.setFont(new Font("Arial", Font.PLAIN, 13));
		comboBoxArtikalCenaArtikala.setEditable(true);
		comboBoxArtikalCenaArtikala.setBounds(200, 70, 200, 20);
		org.jdesktop.swingx.autocomplete.AutoCompleteDecorator.decorate(comboBoxArtikalCenaArtikala);
		contentPane.add(comboBoxArtikalCenaArtikala);
		popuniComboBoxArtikliTSVI(comboBoxArtikalCenaArtikala);
		comboBoxArtikalCenaArtikala.setSelectedItem(null);
		
		comboBoxArtikalCenaArtikala.addActionListener(new ActionListener() {
			
			//@Override
			public void actionPerformed(ActionEvent e) {
				//postaviModelCeneArtikla(new ArrayList<Artikli>(), tableCenaArtikla);
				ArrayList<Artikli>lista;
				try {
					//if(comboBoxArtikalCenaArtikala.getSelectedItem() != null && comboBoxArtikalCenaArtikala.getSelectedItem().getClass() != "")
						if(comboBoxArtikalCenaArtikala.getSelectedItem() != null && comboBoxArtikalCenaArtikala.getSelectedItem().getClass() == Artikli.class)
						{
						lista = Kontroler.getInstance().getArtikli(0, ((Artikli) 
								comboBoxArtikalCenaArtikala.getSelectedItem()).getIdArtikla());
						postaviModelCeneArtikla(lista, tableCenaArtikla);
						}
					
					} catch (ClassNotFoundException | SQLException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
			}
		});
		
		
		
	
		tableCenaArtikla = new JTable();
		scrollPaneCenaArtikla.setViewportView(tableCenaArtikla);
		ArrayList lista;
		try {
			lista = Kontroler.getInstance().getArtikli(0);
			postaviModelCeneArtikla(lista,tableCenaArtikla);
		} catch (ClassNotFoundException | SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		btnPonistiSortiranje = new JButton("Poni\u0161ti sortiranje");
		btnPonistiSortiranje.setFont(new Font("Arial", Font.BOLD, 14));
		btnPonistiSortiranje.setBounds(10, 520, 170, 25);
		contentPane.add(btnPonistiSortiranje);
		
		btnPonistiSortiranje.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
					
				comboBoxGrupaArtikalaCenaArtikala.setSelectedItem(null);
				comboBoxArtikalCenaArtikala.setSelectedItem(null);
				
				ArrayList lista;
				try {
					if(comboBoxArtikalCenaArtikala.getSelectedItem()==null && comboBoxGrupaArtikalaCenaArtikala.getSelectedItem()==null) {
						lista = Kontroler.getInstance().getArtikli(0);
						
						postaviModelCeneArtikla(lista,tableCenaArtikla);
						
						}
					
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
			}
		});
		
		
		
		
		
		
	}
	
	private void postaviModelCeneArtikla(ArrayList lista, JTable t){
		JTableModelCenaArtikla model = new JTableModelCenaArtikla(lista);
		t.setModel(model);
	}
	
	private  void popuniComboBoxGrupaArtikala(JComboBox<GrupaArtikala> comboBox) {
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
}
