package jframeIzvestaji;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.border.TitledBorder;
import com.toedter.calendar.JDateChooser;

import kontroler.Kontroler;
import model.Artikli;
import model.GrupaArtikala;
import model.Izvestaj;
import model.Kupac;
import model.Zaposleni;
import table.JTableModelProdajaPoKupacu;
import table.JTableModelProdajaPoZaposlenom;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JButton;

public class JFrameIzvestajProdajeZaposleni extends JFrame {

	private JPanel contentPane;
	private JTable tableIzvestajProdajeZaposlenog;
	private JTextField textFieldNabavnaVrenostIzvestajZaposleni;
	private JTextField textFieldOsnovicaIzvestajZaposleni;
	private JTextField textProdajnavrednostIzvestajProdajeZaposleni;
	private JTextField textFieldRucIzvestajProdajeZaposleni;
	private JComboBox comboBoxIzvestakZaposlenihArikal;
	private JComboBox comboBoxZaposleniIzvestaj;
	private JComboBox comboBoxIzvestajZaposleniGrupaArtikla;
	private JDateChooser dateChooserDoIzvestajZaposlenog;
	private JDateChooser dateChooserOdIzvestajZaposlenog;
	private JButton btnURedu;
	private JButton btnPonisti;

	public JComboBox getComboBoxIzvestakZaposlenihArikal() {
		return comboBoxIzvestakZaposlenihArikal;
	}

	public void setComboBoxIzvestakZaposlenihArikal(JComboBox comboBoxIzvestakZaposlenihArikal) {
		this.comboBoxIzvestakZaposlenihArikal = comboBoxIzvestakZaposlenihArikal;
	}

	public JComboBox getComboBoxZaposleniIzvestaj() {
		return comboBoxZaposleniIzvestaj;
	}

	public void setComboBoxZaposleniIzvestaj(JComboBox comboBoxZaposleniIzvestaj) {
		this.comboBoxZaposleniIzvestaj = comboBoxZaposleniIzvestaj;
	}

	public JComboBox getComboBoxIzvestajZaposleniGrupaArtikla() {
		return comboBoxIzvestajZaposleniGrupaArtikla;
	}

	public void setComboBoxIzvestajZaposleniGrupaArtikla(JComboBox comboBoxIzvestajZaposleniGrupaArtikla) {
		this.comboBoxIzvestajZaposleniGrupaArtikla = comboBoxIzvestajZaposleniGrupaArtikla;
	}

	public JDateChooser getDateChooserDoIzvestajZaposlenog() {
		return dateChooserDoIzvestajZaposlenog;
	}

	public void setDateChooserDoIzvestajZaposlenog(JDateChooser dateChooserDoIzvestajZaposlenog) {
		this.dateChooserDoIzvestajZaposlenog = dateChooserDoIzvestajZaposlenog;
	}

	public JDateChooser getDateChooserOdIzvestajZaposlenog() {
		return dateChooserOdIzvestajZaposlenog;
	}

	public void setDateChooserOdIzvestajZaposlenog(JDateChooser dateChooserOdIzvestajZaposlenog) {
		this.dateChooserOdIzvestajZaposlenog = dateChooserOdIzvestajZaposlenog;
	}

	public JTable getTableIzvestajProdajeZaposlenog() {
		return tableIzvestajProdajeZaposlenog;
	}

	public void setTableIzvestajProdajeZaposlenog(JTable tableIzvestajProdajeZaposlenog) {
		this.tableIzvestajProdajeZaposlenog = tableIzvestajProdajeZaposlenog;
	}

	public JTextField getTextFieldNabavnaVrenostIzvestajZaposleni() {
		return textFieldNabavnaVrenostIzvestajZaposleni;
	}

	public void setTextFieldNabavnaVrenostIzvestajZaposleni(JTextField textFieldNabavnaVrenostIzvestajZaposleni) {
		this.textFieldNabavnaVrenostIzvestajZaposleni = textFieldNabavnaVrenostIzvestajZaposleni;
	}

	public JTextField getTextFieldOsnovicaIzvestajZaposleni() {
		return textFieldOsnovicaIzvestajZaposleni;
	}

	public void setTextFieldOsnovicaIzvestajZaposleni(JTextField textFieldOsnovicaIzvestajZaposleni) {
		this.textFieldOsnovicaIzvestajZaposleni = textFieldOsnovicaIzvestajZaposleni;
	}

	public JTextField getTextProdajnavrednostIzvestajProdajeZaposleni() {
		return textProdajnavrednostIzvestajProdajeZaposleni;
	}

	public void setTextProdajnavrednostIzvestajProdajeZaposleni(JTextField textProdajnavrednostIzvestajProdajeZaposleni) {
		this.textProdajnavrednostIzvestajProdajeZaposleni = textProdajnavrednostIzvestajProdajeZaposleni;
	}

	public JTextField getTextFieldRucIzvestajProdajeZaposleni() {
		return textFieldRucIzvestajProdajeZaposleni;
	}

	public void setTextFieldRucIzvestajProdajeZaposleni(JTextField textFieldRucIzvestajProdajeZaposleni) {
		this.textFieldRucIzvestajProdajeZaposleni = textFieldRucIzvestajProdajeZaposleni;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameIzvestajProdajeZaposleni frame = new JFrameIzvestajProdajeZaposleni();
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
	public JFrameIzvestajProdajeZaposleni() {
		setTitle("IZVE\u0160TAJ PRODAJE PO ZAPOSLENIMA");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1300, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblZaposleni = new JLabel("Zaposleni : ");
		lblZaposleni.setFont(new Font("Arial", Font.BOLD, 14));
		lblZaposleni.setBounds(30, 20, 170, 20);
		contentPane.add(lblZaposleni);
		
		comboBoxZaposleniIzvestaj = new JComboBox();
		comboBoxZaposleniIzvestaj.setFont(new Font("Arial", Font.PLAIN, 13));
		comboBoxZaposleniIzvestaj.setBounds(30, 60, 200, 20);
		contentPane.add(comboBoxZaposleniIzvestaj);
		popuniComboBoxIzvestajZaposleni(comboBoxZaposleniIzvestaj);
		comboBoxZaposleniIzvestaj.setSelectedItem(null);
		
		comboBoxZaposleniIzvestaj.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				
				postaviModelProdajaPoZaposlenom(new ArrayList<Zaposleni>(), tableIzvestajProdajeZaposlenog);
				ArrayList lista;
				try {
					if(comboBoxZaposleniIzvestaj.getSelectedItem() != null) {
						
						comboBoxIzvestajZaposleniGrupaArtikla.setEnabled(true);
						comboBoxIzvestakZaposlenihArikal.setEnabled(true);
						
				    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
				        String sd = sdf.format(dateChooserOdIzvestajZaposlenog.getDate());
				        String sd1 = sdf.format(dateChooserDoIzvestajZaposlenog.getDate());
					
						lista = Kontroler.getInstance().getIzvestajProdajePoZposlenom(((Zaposleni) 
									comboBoxZaposleniIzvestaj.getSelectedItem()).getIdZaposlenog(), sd, sd1);
						
						postaviModelProdajaPoZaposlenom(lista, tableIzvestajProdajeZaposlenog);
						suma(tableIzvestajProdajeZaposlenog);
						}
					} catch (ClassNotFoundException | SQLException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}	
				
			}
		});
		
		JPanel panelPodaciZaPeriodIzvestajZaposleni = new JPanel();
		panelPodaciZaPeriodIzvestajZaposleni.setBounds(350, 20, 620, 60);
		panelPodaciZaPeriodIzvestajZaposleni.setLayout(null);
		panelPodaciZaPeriodIzvestajZaposleni.setBorder(new TitledBorder(null, "Podaci za period", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(panelPodaciZaPeriodIzvestajZaposleni);
		
		JLabel label = new JLabel("DO :");
		label.setFont(new Font("Arial", Font.BOLD, 14));
		label.setBounds(260, 30, 30, 20);
		panelPodaciZaPeriodIzvestajZaposleni.add(label);
		
		JLabel label_1 = new JLabel("OD :");
		label_1.setFont(new Font("Arial", Font.BOLD, 14));
		label_1.setBounds(10, 30, 30, 20);
		panelPodaciZaPeriodIzvestajZaposleni.add(label_1);
		
		dateChooserDoIzvestajZaposlenog = new JDateChooser();
		dateChooserDoIzvestajZaposlenog.setBounds(310, 30, 150, 20);
		panelPodaciZaPeriodIzvestajZaposleni.add(dateChooserDoIzvestajZaposlenog);
		
		dateChooserOdIzvestajZaposlenog = new JDateChooser();
		dateChooserOdIzvestajZaposlenog.setBounds(60, 30, 150, 20);
		panelPodaciZaPeriodIzvestajZaposleni.add(dateChooserOdIzvestajZaposlenog);
		
		btnURedu = new JButton("U redu");
		btnURedu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
try {
					
					if(dateChooserOdIzvestajZaposlenog.getDate() == null || dateChooserDoIzvestajZaposlenog.getDate() == null)
					{
						JOptionPane.showMessageDialog(btnURedu, "Unesite datume!");
						return;
					}					
					
					Date datumOD = dateChooserOdIzvestajZaposlenog.getDate();
					Date datumDO = dateChooserDoIzvestajZaposlenog.getDate();
					
					Date today = Calendar.getInstance().getTime();
					if(datumOD.after(datumDO)) {
						JOptionPane.showMessageDialog(btnURedu, "Uneli ste pogresan datum u polje! \n(datum OD < datum DO)");
						
						return;
						
					}
					//dateChooserOdIzvestajProdaje.setDate(null);
					//dateChooserrDoIzvestajProdaje.setDate(null);
					
					
					if(dateChooserOdIzvestajZaposlenog.getDate() != null && dateChooserDoIzvestajZaposlenog.getDate() != null) {
						comboBoxZaposleniIzvestaj.setEnabled(true);
						comboBoxIzvestajZaposleniGrupaArtikla.setEnabled(false);
						comboBoxIzvestakZaposlenihArikal.setEnabled(false);
						dateChooserDoIzvestajZaposlenog.setEnabled(false);
						dateChooserOdIzvestajZaposlenog.setEnabled(false);
						
					}
					
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}	
			}
		});
		btnURedu.setFont(new Font("Arial", Font.BOLD, 14));
		btnURedu.setBounds(500, 30, 100, 25);
		panelPodaciZaPeriodIzvestajZaposleni.add(btnURedu);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 200, 1220, 230);
		contentPane.add(scrollPane);
		
		tableIzvestajProdajeZaposlenog = new JTable();
		scrollPane.setViewportView(tableIzvestajProdajeZaposlenog);
		postaviModelProdajaPoZaposlenom(new ArrayList<>(), tableIzvestajProdajeZaposlenog);
		
		
		JPanel panelFilterIzvestaZaposleni = new JPanel();
		panelFilterIzvestaZaposleni.setBorder(new TitledBorder(null, "Filter", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelFilterIzvestaZaposleni.setLayout(null);
		panelFilterIzvestaZaposleni.setBounds(30, 120, 710, 50);
		contentPane.add(panelFilterIzvestaZaposleni);
		
		JLabel label_2 = new JLabel("Grupa artikla :");
		label_2.setFont(new Font("Arial", Font.BOLD, 14));
		label_2.setBounds(10, 20, 110, 20);
		panelFilterIzvestaZaposleni.add(label_2);
		
		comboBoxIzvestajZaposleniGrupaArtikla = new JComboBox();
		comboBoxIzvestajZaposleniGrupaArtikla.setFont(new Font("Arial", Font.PLAIN, 13));
		comboBoxIzvestajZaposleniGrupaArtikla.setBounds(150, 20, 210, 20);
		panelFilterIzvestaZaposleni.add(comboBoxIzvestajZaposleniGrupaArtikla);
		popuniComboBoxGrupaArtikala(comboBoxIzvestajZaposleniGrupaArtikla);
		comboBoxIzvestajZaposleniGrupaArtikla.setSelectedItem(null);
		
		comboBoxIzvestajZaposleniGrupaArtikla.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				postaviModelProdajaPoZaposlenom(new ArrayList<GrupaArtikala>(), tableIzvestajProdajeZaposlenog);
				ArrayList lista;
				try {
						if(comboBoxIzvestajZaposleniGrupaArtikla.getSelectedItem() != null) {
					    SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
					    String sd = sdf.format(dateChooserOdIzvestajZaposlenog.getDate());
					    String sd1 = sdf.format(dateChooserDoIzvestajZaposlenog.getDate()); 					
					
					
						lista = Kontroler.getInstance().getIzvestajProdajePoZposlenomPoGrupi(((Zaposleni) 
								comboBoxZaposleniIzvestaj.getSelectedItem()).getIdZaposlenog(),((GrupaArtikala) 
										comboBoxIzvestajZaposleniGrupaArtikla.getSelectedItem()).getIdGrupeArtikala(), sd, sd1);
						postaviModelProdajaPoZaposlenom(lista, tableIzvestajProdajeZaposlenog);
						suma(tableIzvestajProdajeZaposlenog);
						}
					} catch (ClassNotFoundException | SQLException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
				
			}
		});
		
		
		
		
		JLabel label_3 = new JLabel("Artikal :");
		label_3.setFont(new Font("Arial", Font.BOLD, 14));
		label_3.setBounds(400, 20, 70, 20);
		panelFilterIzvestaZaposleni.add(label_3);
		
		comboBoxIzvestakZaposlenihArikal = new JComboBox();
		comboBoxIzvestakZaposlenihArikal.setFont(new Font("Arial", Font.PLAIN, 13));
		comboBoxIzvestakZaposlenihArikal.setBounds(490, 20, 200, 20);
		panelFilterIzvestaZaposleni.add(comboBoxIzvestakZaposlenihArikal);
		
        comboBoxIzvestajZaposleniGrupaArtikla.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				if (comboBoxIzvestajZaposleniGrupaArtikla.getSelectedItem() != null) {
					
					//pamcenje i skidanje actionlistener-a
					ActionListener al = comboBoxIzvestakZaposlenihArikal.getActionListeners()[0];
					comboBoxIzvestakZaposlenihArikal.removeActionListener(al);
					
					popuniComboBoxArtikli(comboBoxIzvestakZaposlenihArikal,
							((GrupaArtikala) comboBoxIzvestajZaposleniGrupaArtikla.getSelectedItem()).getIdGrupeArtikala());
					comboBoxIzvestakZaposlenihArikal.setSelectedItem(null);
					
					//vracanje zapamcenog actionlistener-a
					comboBoxIzvestakZaposlenihArikal.addActionListener(al);
				}
				else
				{
					comboBoxIzvestakZaposlenihArikal.removeAllItems();
					comboBoxIzvestakZaposlenihArikal.setSelectedItem(null);
				}
				
			}
		});
		
		
		comboBoxIzvestakZaposlenihArikal.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				postaviModelProdajaPoZaposlenom(new ArrayList<Zaposleni>(), tableIzvestajProdajeZaposlenog);
				ArrayList lista;
				try {
						if( comboBoxIzvestakZaposlenihArikal.getSelectedItem() != null ) {
					    SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
				        String sd = sdf.format(dateChooserOdIzvestajZaposlenog.getDate());
				        String sd1 = sdf.format(dateChooserDoIzvestajZaposlenog.getDate()); 	
					
						lista = Kontroler.getInstance().getIzvestajProdajePoZposlenomPoGrupiPoArtiklu(((Zaposleni) 
								comboBoxZaposleniIzvestaj.getSelectedItem()).getIdZaposlenog(),((GrupaArtikala) 
								comboBoxIzvestajZaposleniGrupaArtikla.getSelectedItem()).getIdGrupeArtikala(),
								((Artikli)comboBoxIzvestakZaposlenihArikal.getSelectedItem()).getIdArtikla(), sd, sd1);
						postaviModelProdajaPoZaposlenom(lista, tableIzvestajProdajeZaposlenog);
						suma(tableIzvestajProdajeZaposlenog);
						}
					} catch (ClassNotFoundException | SQLException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
				
			}
		});
		
		JPanel panelIzvestajZaposleni = new JPanel();
		panelIzvestajZaposleni.setLayout(null);
		panelIzvestajZaposleni.setBounds(30, 500, 1100, 50);
		contentPane.add(panelIzvestajZaposleni);
		
		JLabel label_4 = new JLabel("Nabavna vrenost :");
		label_4.setFont(new Font("Arial", Font.BOLD, 14));
		label_4.setBounds(10, 20, 130, 20);
		panelIzvestajZaposleni.add(label_4);
		
		textFieldNabavnaVrenostIzvestajZaposleni = new JTextField();
		textFieldNabavnaVrenostIzvestajZaposleni.setFont(new Font("Arial", Font.PLAIN, 13));
		textFieldNabavnaVrenostIzvestajZaposleni.setColumns(10);
		textFieldNabavnaVrenostIzvestajZaposleni.setBounds(160, 20, 120, 20);
		panelIzvestajZaposleni.add(textFieldNabavnaVrenostIzvestajZaposleni);
		
		JLabel label_5 = new JLabel("Osnovica :");
		label_5.setFont(new Font("Arial", Font.BOLD, 14));
		label_5.setBounds(320, 20, 80, 20);
		panelIzvestajZaposleni.add(label_5);
		
		textFieldOsnovicaIzvestajZaposleni = new JTextField();
		textFieldOsnovicaIzvestajZaposleni.setFont(new Font("Arial", Font.PLAIN, 13));
		textFieldOsnovicaIzvestajZaposleni.setColumns(10);
		textFieldOsnovicaIzvestajZaposleni.setBounds(420, 20, 120, 20);
		panelIzvestajZaposleni.add(textFieldOsnovicaIzvestajZaposleni);
		
		JLabel label_6 = new JLabel("Prodajna vrednost :");
		label_6.setFont(new Font("Arial", Font.BOLD, 14));
		label_6.setBounds(580, 20, 140, 20);
		panelIzvestajZaposleni.add(label_6);
		
		textProdajnavrednostIzvestajProdajeZaposleni = new JTextField();
		textProdajnavrednostIzvestajProdajeZaposleni.setFont(new Font("Arial", Font.PLAIN, 13));
		textProdajnavrednostIzvestajProdajeZaposleni.setColumns(10);
		textProdajnavrednostIzvestajProdajeZaposleni.setBounds(740, 20, 120, 20);
		panelIzvestajZaposleni.add(textProdajnavrednostIzvestajProdajeZaposleni);
		
		JLabel label_7 = new JLabel("RUC :");
		label_7.setFont(new Font("Arial", Font.BOLD, 14));
		label_7.setBounds(900, 20, 50, 20);
		panelIzvestajZaposleni.add(label_7);
		
		textFieldRucIzvestajProdajeZaposleni = new JTextField();
		textFieldRucIzvestajProdajeZaposleni.setFont(new Font("Arial", Font.PLAIN, 13));
		textFieldRucIzvestajProdajeZaposleni.setColumns(10);
		textFieldRucIzvestajProdajeZaposleni.setBounds(970, 20, 120, 20);
		panelIzvestajZaposleni.add(textFieldRucIzvestajProdajeZaposleni);
		
		btnPonisti = new JButton("Poni\u0161ti");
		btnPonisti.setFont(new Font("Arial", Font.BOLD, 14));
		btnPonisti.setBounds(850, 140, 90, 25);
		contentPane.add(btnPonisti);
		
		btnPonisti.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					postaviModelProdajaPoZaposlenom(new ArrayList<>(), tableIzvestajProdajeZaposlenog);
					suma(tableIzvestajProdajeZaposlenog);
					
					dateChooserOdIzvestajZaposlenog.setDate(null);
					dateChooserDoIzvestajZaposlenog.setDate(null);
					
					textFieldNabavnaVrenostIzvestajZaposleni.setText("");
					textFieldOsnovicaIzvestajZaposleni.setText("");
					textFieldRucIzvestajProdajeZaposleni.setText("");
					textProdajnavrednostIzvestajProdajeZaposleni.setText("");
					
					comboBoxZaposleniIzvestaj.setSelectedItem(null);
					comboBoxZaposleniIzvestaj.setEnabled(false);
					comboBoxIzvestajZaposleniGrupaArtikla.setSelectedItem(null);
					comboBoxIzvestajZaposleniGrupaArtikla.setEnabled(false);
					comboBoxIzvestakZaposlenihArikal.setSelectedItem(null);
					comboBoxIzvestakZaposlenihArikal.setEnabled(false);
					dateChooserDoIzvestajZaposlenog.cleanup();
					dateChooserOdIzvestajZaposlenog.cleanup();
					dateChooserDoIzvestajZaposlenog.setEnabled(true);
					dateChooserOdIzvestajZaposlenog.setEnabled(true);
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
			textFieldNabavnaVrenostIzvestajZaposleni.setEditable(false);
			textFieldOsnovicaIzvestajZaposleni.setEditable(false);
			textFieldRucIzvestajProdajeZaposleni.setEditable(false);
			textProdajnavrednostIzvestajProdajeZaposleni.setEditable(false);
		
	}
	
	private void postaviModelProdajaPoZaposlenom(ArrayList lista, JTable t){
		 JTableModelProdajaPoZaposlenom model = new  JTableModelProdajaPoZaposlenom(lista);
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
		
	private void popuniComboBoxIzvestajZaposleni(JComboBox<Zaposleni> comboBox) {
		try {
			ArrayList<Zaposleni> lista = Kontroler.getInstance().getZaposleni();

			for (Zaposleni k : lista) {
				comboBox.addItem(k);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	private void suma (JTable t) {
		double sum = 0; double sum1 = 0; double sum2 = 0;
		
		for (int i = 0; i < tableIzvestajProdajeZaposlenog.getRowCount(); i++) { 
			sum = sum + Double.parseDouble(tableIzvestajProdajeZaposlenog.getValueAt(i,11).toString());
				
		}
		for (int i1 = 0; i1 < tableIzvestajProdajeZaposlenog.getRowCount(); i1++) {
			sum1 = sum1 + Double.parseDouble(tableIzvestajProdajeZaposlenog.getValueAt(i1,15).toString());
		 		
		 		}
		for (int i2 = 0; i2 < tableIzvestajProdajeZaposlenog.getRowCount(); i2++) {
			sum2 = sum2 + Double.parseDouble(tableIzvestajProdajeZaposlenog.getValueAt(i2,14).toString());
			
			}
				textFieldNabavnaVrenostIzvestajZaposleni.setText(Double.toString(sum));
				textFieldRucIzvestajProdajeZaposleni.setText(Double.toString(sum2-sum));
				textFieldOsnovicaIzvestajZaposleni.setText(Double.toString(sum1));
				textProdajnavrednostIzvestajProdajeZaposleni.setText(Double.toString(sum2)); 
		  }
}
