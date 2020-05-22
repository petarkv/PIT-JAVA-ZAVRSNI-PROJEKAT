package jframePregled;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

import kontroler.Kontroler;
import model.Artikli;
import model.GrupaArtikala;
import table.JTableModelArtikal;
import table.JTableModelCenaArtikla;

import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JLabel;

public class JFramePregledArtikala extends JFrame {

	private JPanel contentPane;
	private JTable tablePregledArtikala;
	private JButton btnIzlazPregledArtikala;
	private JComboBox comboBoxGrupaArtikalaPregledArtikala;
	private JButton btnPonistiSortiranjePregledArtikala;
	private JComboBox comboBoxArtikalPregledArtikala;
	

	public JComboBox getComboBoxGrupaArtikalaPregledArtikala() {
		return comboBoxGrupaArtikalaPregledArtikala;
	}

	public JComboBox getComboBoxArtikalPregledArtikala() {
		return comboBoxArtikalPregledArtikala;
	}

	public JButton getBtnPonistiSortiranjePregledArtikala() {
		return btnPonistiSortiranjePregledArtikala;
	}

	public JTable getTablePregledArtikala() {
		return tablePregledArtikala;
	}

	public void setTablePregledArtikala(JTable tablePregledArtikala) {
		this.tablePregledArtikala = tablePregledArtikala;
	}

	public JButton getBtnIzlazPregledArtikala() {
		return btnIzlazPregledArtikala;
	}

	public void setBtnIzlazPregledArtikala(JButton btnIzlazPregledArtikala) {
		this.btnIzlazPregledArtikala = btnIzlazPregledArtikala;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFramePregledArtikala frame = new JFramePregledArtikala();
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
	public JFramePregledArtikala() {
		setTitle("PREGLED ARTIKALA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelSortiranjeArtikala = new JPanel();
		panelSortiranjeArtikala.setBorder(new TitledBorder(null, "Sortiranje", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelSortiranjeArtikala.setBounds(10, 30, 410, 110);
		contentPane.add(panelSortiranjeArtikala);
		panelSortiranjeArtikala.setLayout(null);
		
		comboBoxGrupaArtikalaPregledArtikala = new JComboBox();
		comboBoxGrupaArtikalaPregledArtikala.setFont(new Font("Arial", Font.PLAIN, 13));
		comboBoxGrupaArtikalaPregledArtikala.setBounds(150, 30, 200, 20);
		panelSortiranjeArtikala.add(comboBoxGrupaArtikalaPregledArtikala);
		popuniComboBoxGrupaArtikala(comboBoxGrupaArtikalaPregledArtikala);
		comboBoxGrupaArtikalaPregledArtikala.setSelectedItem(null);
		
		comboBoxGrupaArtikalaPregledArtikala.addActionListener(new ActionListener() {		
				
					@Override
					public void actionPerformed(ActionEvent e1) {
						//JOptionPane.showMessageDialog(null, "COMBOBOX ACTION");
						if (comboBoxGrupaArtikalaPregledArtikala.getSelectedItem() != null) {
							
							//pamcenje i skidanje actionlistener-a
							ActionListener al = comboBoxArtikalPregledArtikala.getActionListeners()[0];
							comboBoxArtikalPregledArtikala.removeActionListener(al);
							
							popuniComboBoxArtikli(comboBoxArtikalPregledArtikala,
									((GrupaArtikala) comboBoxGrupaArtikalaPregledArtikala.getSelectedItem()).getIdGrupeArtikala());
							comboBoxArtikalPregledArtikala.setSelectedItem(null);
							
							//vracanje zapamcenog actionlistener-a
							comboBoxArtikalPregledArtikala.addActionListener(al);
						}
						else
						{
							comboBoxArtikalPregledArtikala.removeAllItems();
							comboBoxArtikalPregledArtikala.setSelectedItem(null);
						}
					}
			
		});
		
            comboBoxGrupaArtikalaPregledArtikala.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				postaviModelArtikli(new ArrayList<GrupaArtikala>(), tablePregledArtikala);
				ArrayList<Artikli>lista;
				try {
					    if(comboBoxGrupaArtikalaPregledArtikala.getSelectedItem()!=null) { 
						lista = Kontroler.getInstance().getArtikli(((GrupaArtikala) 
								comboBoxGrupaArtikalaPregledArtikala.getSelectedItem()).getIdGrupeArtikala());
						postaviModelArtikli(lista, tablePregledArtikala);
					    }
					} catch (ClassNotFoundException | SQLException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
				
			}
		});
		
		JLabel lblGrupaArtikala = new JLabel("Grupa artikala :");
		lblGrupaArtikala.setFont(new Font("Arial", Font.BOLD, 14));
		lblGrupaArtikala.setBounds(10, 30, 120, 20);
		panelSortiranjeArtikala.add(lblGrupaArtikala);
		
		JLabel lblArtikal = new JLabel("Artikal :");
		lblArtikal.setFont(new Font("Arial", Font.BOLD, 14));
		lblArtikal.setBounds(10, 70, 120, 20);
		panelSortiranjeArtikala.add(lblArtikal);
		
		comboBoxArtikalPregledArtikala = new JComboBox();
		comboBoxArtikalPregledArtikala.setFont(new Font("Arial", Font.PLAIN, 13));
		comboBoxArtikalPregledArtikala.setBounds(150, 70, 200, 20);
		org.jdesktop.swingx.autocomplete.AutoCompleteDecorator.decorate(comboBoxArtikalPregledArtikala);
		panelSortiranjeArtikala.add(comboBoxArtikalPregledArtikala);
		popuniComboBoxArtikliTSVI(comboBoxArtikalPregledArtikala);
		comboBoxArtikalPregledArtikala.setSelectedItem(null);
		
		
		comboBoxArtikalPregledArtikala.addActionListener(new ActionListener() {
			
			//@Override
			public void actionPerformed(ActionEvent e) {
				//postaviModelCeneArtikla(new ArrayList<Artikli>(), tableCenaArtikla);
				ArrayList<Artikli>lista;
				try {
					//if(comboBoxArtikalCenaArtikala.getSelectedItem() != null && comboBoxArtikalCenaArtikala.getSelectedItem().getClass() != "")
						if(comboBoxArtikalPregledArtikala.getSelectedItem() != null)
						{
						lista = Kontroler.getInstance().getArtikli(0, ((Artikli) 
								comboBoxArtikalPregledArtikala.getSelectedItem()).getIdArtikla());
						postaviModelArtikli(lista, tablePregledArtikala);
						}
					
					} catch (ClassNotFoundException | SQLException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
			}
		});
		
		
		
		JScrollPane scrollPanePregledArtikala = new JScrollPane();
		scrollPanePregledArtikala.setBounds(10, 180, 960, 350);
		contentPane.add(scrollPanePregledArtikala);
		
		tablePregledArtikala = new JTable();
		scrollPanePregledArtikala.setViewportView(tablePregledArtikala);
		
		btnIzlazPregledArtikala = new JButton("Nazad");
		btnIzlazPregledArtikala.setFont(new Font("Arial", Font.BOLD, 14));
		btnIzlazPregledArtikala.setBounds(820, 560, 150, 25);
		contentPane.add(btnIzlazPregledArtikala);
		
		btnPonistiSortiranjePregledArtikala = new JButton("Poni\u0161ti sortiranje");
		btnPonistiSortiranjePregledArtikala.setFont(new Font("Arial", Font.BOLD, 14));
		btnPonistiSortiranjePregledArtikala.setBounds(10, 560, 170, 25);
		contentPane.add(btnPonistiSortiranjePregledArtikala);
		
		btnPonistiSortiranjePregledArtikala.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				comboBoxArtikalPregledArtikala.setSelectedItem(null);
				comboBoxGrupaArtikalaPregledArtikala.setSelectedItem(null);
				//comboBoxArtikalPregledArtikala.removeAllItems();
				//comboBoxArtikalPregledArtikala.setSelectedItem(null);
				//comboBoxGrupaArtikalaPregledArtikala.removeAllItems();
				//comboBoxGrupaArtikalaPregledArtikala.setSelectedItem(null);			
				
				//postaviModelArtikli(new ArrayList<GrupaArtikala>(), tablePregledArtikala);
				ArrayList<Artikli>lista;
				try {
					    if(comboBoxGrupaArtikalaPregledArtikala.getSelectedItem()==null && comboBoxArtikalPregledArtikala.getSelectedItem()==null) {
					
						lista = Kontroler.getInstance().getArtikli(0); 
								
						postaviModelArtikli(lista, tablePregledArtikala);						
						
					    }
					    
					
					} catch (ClassNotFoundException | SQLException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
				
				
			}
			
			
		});
	}
		
	    private void postaviModelArtikli(ArrayList lista, JTable t){
		JTableModelArtikal model = new JTableModelArtikal(lista);
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
			
		