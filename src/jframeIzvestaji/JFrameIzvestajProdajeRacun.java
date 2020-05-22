package jframeIzvestaji;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JComboBox;
import javax.swing.border.TitledBorder;
import com.toedter.calendar.JDateChooser;

import jframe.JFrameRacun_otpreminica;
import kontroler.Kontroler;
import model.Artikli;
import model.Filijala;
import model.GrupaArtikala;
import model.Izvestaj;
import model.Kupac;
import model.Zaposleni;
import table.JTableModelPregledRacunaRacuna;
import table.JTableModelProdajPoRacunu;
import table.JTableModelProdajaPoFilijali;
import table.JTableModelProdajaPoKupacu;
import table.JTableModelRacunOtpremnica;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;

public class JFrameIzvestajProdajeRacun extends JFrame {

	private JPanel contentPane;
	private JTable tablePregledRAcuna;
	private JComboBox comboBoxKupacPregledRacuna;
	private JDateChooser dateChooserpregledRacunaDO;
	private JDateChooser dateChooserPregledRacunaOD;
	private JComboBox comboBoxGrupaArtiklaPregledRacuna;
	private JComboBox comboBoxArtikalPregledRAcuna;
	private JTextField textFieldNbavnaVrednostRacun;
	private JTextField textFieldOsnovicaRAcun;
	private JTextField textFieldProdajnaVrednostRacun;
	private JTextField textFieldRucRacun;	
	private JButton btnPonisti;
	private JButton btnURedu;
	

	public JComboBox getComboBoxKupacPregledRacuna() {
		return comboBoxKupacPregledRacuna;
	}

	public JComboBox getComboBoxGrupaArtiklaPregledRacuna() {
		return comboBoxGrupaArtiklaPregledRacuna;
	}

	public JComboBox getComboBoxArtikalPregledRAcuna() {
		return comboBoxArtikalPregledRAcuna;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameIzvestajProdajeRacun frame = new JFrameIzvestajProdajeRacun();
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
	public JFrameIzvestajProdajeRacun() {
		setTitle("IZVE\u0160TAJ PRODAJE PO RA\u010CUNIMA");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1300, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Kupac : ");
		label.setFont(new Font("Arial", Font.BOLD, 14));
		label.setBounds(30, 20, 170, 20);
		contentPane.add(label);
		
		comboBoxKupacPregledRacuna = new JComboBox();
		comboBoxKupacPregledRacuna.setFont(new Font("Arial", Font.PLAIN, 13));
		comboBoxKupacPregledRacuna.setBounds(30, 60, 200, 20);
		contentPane.add(comboBoxKupacPregledRacuna);
		popuniComboBoxIzvestajKupac(comboBoxKupacPregledRacuna);
		comboBoxKupacPregledRacuna.setSelectedItem(null);
		
		comboBoxKupacPregledRacuna.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				postaviModelProdajaPoRacunu(new ArrayList<Kupac>(), tablePregledRAcuna);
				ArrayList lista;
				try { 			
						if(comboBoxKupacPregledRacuna.getSelectedItem() != null) {
							comboBoxArtikalPregledRAcuna.setEnabled(true);
							comboBoxGrupaArtiklaPregledRacuna.setEnabled(true);
							
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
						String sd = sdf.format(dateChooserPregledRacunaOD.getDate());
						String sd1 = sdf.format(dateChooserpregledRacunaDO.getDate());

						lista = Kontroler.getInstance().getIzvestajProdajePoKupcu(((Kupac) 
								comboBoxKupacPregledRacuna.getSelectedItem()).getIdKupca(),sd,sd1);
						
						postaviModelProdajaPoRacunu(lista, tablePregledRAcuna);
						suma(tablePregledRAcuna);
						}
						
					} catch (ClassNotFoundException | SQLException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}	
			}
		});
		
		JPanel panelPodaciZaPeriodRacun = new JPanel();
		panelPodaciZaPeriodRacun.setLayout(null);
		panelPodaciZaPeriodRacun.setBorder(new TitledBorder(null, "Podaci za period", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelPodaciZaPeriodRacun.setBounds(350, 20, 650, 60);
		contentPane.add(panelPodaciZaPeriodRacun);
		
		JLabel label_1 = new JLabel("DO :");
		label_1.setFont(new Font("Arial", Font.BOLD, 14));
		label_1.setBounds(260, 30, 30, 20);
		panelPodaciZaPeriodRacun.add(label_1);
		
		JLabel label_2 = new JLabel("OD :");
		label_2.setFont(new Font("Arial", Font.BOLD, 14));
		label_2.setBounds(10, 30, 30, 20);
		panelPodaciZaPeriodRacun.add(label_2);
		
		dateChooserpregledRacunaDO = new JDateChooser();
		dateChooserpregledRacunaDO.setBounds(310, 30, 150, 20);
		panelPodaciZaPeriodRacun.add(dateChooserpregledRacunaDO);
		
		dateChooserPregledRacunaOD = new JDateChooser();
		dateChooserPregledRacunaOD.setBounds(60, 30, 150, 20);
		panelPodaciZaPeriodRacun.add(dateChooserPregledRacunaOD);
		
		btnURedu = new JButton("U redu");
		btnURedu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
            try {
					
					if(dateChooserPregledRacunaOD.getDate() == null || dateChooserpregledRacunaDO.getDate() == null)
					{
						JOptionPane.showMessageDialog(btnURedu, "Unesite datume!");
						return;
					}					
					
					Date datumOD = dateChooserPregledRacunaOD.getDate();
					Date datumDO = dateChooserpregledRacunaDO.getDate();
					
					Date today = Calendar.getInstance().getTime();
					if(datumOD.after(datumDO)) {
						JOptionPane.showMessageDialog(btnURedu, "Uneli ste pogresan datum u polje! \n(datum OD < datum DO)");
						
						return;
						
					}
					//dateChooserOdIzvestajProdaje.setDate(null);
					//dateChooserrDoIzvestajProdaje.setDate(null);
					
					
					if(dateChooserPregledRacunaOD.getDate() != null && dateChooserpregledRacunaDO.getDate() != null) {
						comboBoxKupacPregledRacuna.setEnabled(true);
						comboBoxGrupaArtiklaPregledRacuna.setEnabled(false);
						comboBoxArtikalPregledRAcuna.setEnabled(false);
						dateChooserpregledRacunaDO.setEnabled(false);
						dateChooserPregledRacunaOD.setEnabled(false);
						
					}
					
				} catch (HeadlessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}				
			}
		});
		btnURedu.setFont(new Font("Arial", Font.BOLD, 14));
		btnURedu.setBounds(500, 30, 100, 25);
		panelPodaciZaPeriodRacun.add(btnURedu);
		
		JPanel panelFilterPregledRacuna = new JPanel();
		panelFilterPregledRacuna.setLayout(null);
		panelFilterPregledRacuna.setBorder(new TitledBorder(null, "Filter", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelFilterPregledRacuna.setBounds(30, 120, 710, 50);
		contentPane.add(panelFilterPregledRacuna);
		
		JLabel label_3 = new JLabel("Grupa artikla :");
		label_3.setFont(new Font("Arial", Font.BOLD, 14));
		label_3.setBounds(10, 20, 110, 20);
		panelFilterPregledRacuna.add(label_3);
		
		comboBoxGrupaArtiklaPregledRacuna = new JComboBox();
		comboBoxGrupaArtiklaPregledRacuna.setFont(new Font("Arial", Font.PLAIN, 13));
		comboBoxGrupaArtiklaPregledRacuna.setBounds(150, 20, 200, 20);
		panelFilterPregledRacuna.add(comboBoxGrupaArtiklaPregledRacuna);
		popuniComboBoxGrupaArtikala(comboBoxGrupaArtiklaPregledRacuna);
		comboBoxGrupaArtiklaPregledRacuna.setSelectedItem(null);
		
		comboBoxGrupaArtiklaPregledRacuna.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				postaviModelProdajaPoRacunu(new ArrayList<GrupaArtikala>(), tablePregledRAcuna);
				ArrayList lista;
				try { 
					
						if(comboBoxGrupaArtiklaPregledRacuna.getSelectedItem() != null) {
					    SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
					    String sd = sdf.format(dateChooserPregledRacunaOD.getDate());
					    String sd1 = sdf.format(dateChooserpregledRacunaDO.getDate());
					
						lista = Kontroler.getInstance().getIzvestajProdajePoKupcuPoGrupi(((Kupac) 
								comboBoxKupacPregledRacuna.getSelectedItem()).getIdKupca(),((GrupaArtikala) 
										comboBoxGrupaArtiklaPregledRacuna.getSelectedItem()).getIdGrupeArtikala(), sd, sd1);
						postaviModelProdajaPoRacunu(lista, tablePregledRAcuna);
						suma(tablePregledRAcuna);
						}
					
					} catch (ClassNotFoundException | SQLException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
				
			}
		});		
		
		comboBoxGrupaArtiklaPregledRacuna.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				if (comboBoxGrupaArtiklaPregledRacuna.getSelectedItem() != null) {
					
					//pamcenje i skidanje actionlistener-a
					ActionListener al = comboBoxArtikalPregledRAcuna.getActionListeners()[0];
					comboBoxArtikalPregledRAcuna.removeActionListener(al);
					
					popuniComboBoxArtikli(comboBoxArtikalPregledRAcuna,
							((GrupaArtikala) comboBoxGrupaArtiklaPregledRacuna.getSelectedItem()).getIdGrupeArtikala());
					comboBoxArtikalPregledRAcuna.setSelectedItem(null);
					
					//vracanje zapamcenog actionlistener-a
					comboBoxArtikalPregledRAcuna.addActionListener(al);
				}
				else
				{
					comboBoxArtikalPregledRAcuna.removeAllItems();
					comboBoxArtikalPregledRAcuna.setSelectedItem(null);
				}
				
			}
		});
		
		
		JLabel label_4 = new JLabel("Artikal :");
		label_4.setFont(new Font("Arial", Font.BOLD, 14));
		label_4.setBounds(400, 20, 70, 20);
		panelFilterPregledRacuna.add(label_4);
		
		comboBoxArtikalPregledRAcuna = new JComboBox();
		comboBoxArtikalPregledRAcuna.setFont(new Font("Arial", Font.PLAIN, 13));
		comboBoxArtikalPregledRAcuna.setBounds(490, 20, 200, 20);
		panelFilterPregledRacuna.add(comboBoxArtikalPregledRAcuna);
		
		comboBoxArtikalPregledRAcuna.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				postaviModelProdajaPoRacunu(new ArrayList<Artikli>(), tablePregledRAcuna);
				ArrayList lista;
				try {
						if(comboBoxArtikalPregledRAcuna.getSelectedItem() != null) {
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
						String sd = sdf.format(dateChooserPregledRacunaOD.getDate());
						String sd1 = sdf.format(dateChooserpregledRacunaDO.getDate());
						lista = Kontroler.getInstance().getIzvestajProdajePoKupcuPoGrupiPoArtikluPoRacunu(((Kupac) 
								comboBoxKupacPregledRacuna.getSelectedItem()).getIdKupca(),((GrupaArtikala) 
								comboBoxGrupaArtiklaPregledRacuna.getSelectedItem()).getIdGrupeArtikala(),
								((Artikli)comboBoxArtikalPregledRAcuna.getSelectedItem()).getIdArtikla(),sd,sd1);
						postaviModelProdajaPoRacunu(lista, tablePregledRAcuna);
						suma(tablePregledRAcuna);
						}
						
					} catch (ClassNotFoundException | SQLException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
				
			}
		});
		
		JScrollPane scrollPanePregledRAcuna = new JScrollPane();
		scrollPanePregledRAcuna.setBounds(30, 200, 1220, 230);
		contentPane.add(scrollPanePregledRAcuna);
		
		tablePregledRAcuna = new JTable();
		scrollPanePregledRAcuna.setViewportView(tablePregledRAcuna);
		postaviModelProdajaPoRacunu(new ArrayList<Izvestaj>(), tablePregledRAcuna);
		
		tablePregledRAcuna.addMouseListener(new MouseListener() {		
			
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount()%2 == 0) {
					String s = tablePregledRAcuna.getModel().getValueAt(tablePregledRAcuna.getSelectedRow(), 3).toString();
					
					JFrameRacun_otpreminica ro = new JFrameRacun_otpreminica();
					
					ro.getBtnPonistiAkcijuRacunOtpremnica().addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							ro.setVisible(false);
							
						}
					});
					ro.getBtnKreirajRacun().setVisible(false);
					ro.getBtnNovaPoyicijaRacun().setVisible(false);
					ro.getBtnZapocniProdajuStavkeRacuna().setVisible(false);
					ro.getBtnIzmeniRacun().setVisible(false);
					ro.getBtnObrisiRacun().setVisible(false);
					ro.getBtnPonistiAkcijuRacunOtpremnica().setBounds(1024, 500, 150, 25);
					ro.getBtnPonistiAkcijuRacunOtpremnica().setText("Nazad");
					ro.setVisible(true);
					
					ArrayList lista;
					
					try {
					
						int id_racuna = Integer.parseInt(s);
						ro.getTextFieldRacunOtpremnicaRacun().setText(s);
						Date d =Kontroler.getInstance().datumValuteRacuna(id_racuna);
						ro.getDateChooserNaplateracuna().setDate(d);
						ro.getDateChooserRacunOtpremnica().setDate(Kontroler.getInstance().datumRacuna(id_racuna));
						ro.getComboBoxKupacRacun().getModel().setSelectedItem(comboBoxKupacPregledRacuna.getSelectedItem());
												
						lista = Kontroler.getInstance().getStavkeRacunaOtpremniceIzvestaj(id_racuna);
						postaviModelRAcunaOtpremnice(lista, ro.getTableStavkeRacuna());
						double sumN =0;
						for (int i = 0; i < ro.getTableStavkeRacuna().getRowCount(); i++) {
							double iznos = (double) ro.getTableStavkeRacuna().getValueAt(i, 8);
									sumN+=iznos;
									ro.getTextFieldNetoRacun().setText(Double.toString(sumN));
									
						}
						double sumPDV =0;
						for (int i = 0; i < ro.getTableStavkeRacuna().getRowCount(); i++) {
							double iznos = (double) ro.getTableStavkeRacuna().getValueAt(i, 9);
									sumPDV+=iznos;
									ro.getTextFieldPDVRacun().setText(Double.toString(sumPDV));
					}
						double sumB =0;
						for (int i = 0; i < ro.getTableStavkeRacuna().getRowCount(); i++) {
							double iznos = (double) ro.getTableStavkeRacuna().getValueAt(i, 10);
									sumB+=iznos;
									ro.getTextFieldBrutoRacun().setText(Double.toString(sumB));
						}
						
						
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
				
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});		
		
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(30, 500, 1100, 50);
		contentPane.add(panel);
		
		JLabel label_5 = new JLabel("Nabavna vrenost :");
		label_5.setFont(new Font("Arial", Font.BOLD, 14));
		label_5.setBounds(10, 20, 130, 20);
		panel.add(label_5);
		
		textFieldNbavnaVrednostRacun = new JTextField();
		textFieldNbavnaVrednostRacun.setFont(new Font("Arial", Font.PLAIN, 13));
		textFieldNbavnaVrednostRacun.setColumns(10);
		textFieldNbavnaVrednostRacun.setBounds(160, 20, 120, 20);
		panel.add(textFieldNbavnaVrednostRacun);
		
		JLabel label_6 = new JLabel("Osnovica :");
		label_6.setFont(new Font("Arial", Font.BOLD, 14));
		label_6.setBounds(320, 20, 80, 20);
		panel.add(label_6);
		
		textFieldOsnovicaRAcun = new JTextField();
		textFieldOsnovicaRAcun.setFont(new Font("Arial", Font.PLAIN, 13));
		textFieldOsnovicaRAcun.setColumns(10);
		textFieldOsnovicaRAcun.setBounds(420, 20, 120, 20);
		panel.add(textFieldOsnovicaRAcun);
		
		JLabel label_7 = new JLabel("Prodajna vrednost :");
		label_7.setFont(new Font("Arial", Font.BOLD, 14));
		label_7.setBounds(580, 20, 140, 20);
		panel.add(label_7);
		
		textFieldProdajnaVrednostRacun = new JTextField();
		textFieldProdajnaVrednostRacun.setFont(new Font("Arial", Font.PLAIN, 13));
		textFieldProdajnaVrednostRacun.setColumns(10);
		textFieldProdajnaVrednostRacun.setBounds(740, 20, 120, 20);
		panel.add(textFieldProdajnaVrednostRacun);
		
		JLabel label_8 = new JLabel("RUC :");
		label_8.setFont(new Font("Arial", Font.BOLD, 14));
		label_8.setBounds(900, 20, 50, 20);
		panel.add(label_8);
		
		textFieldRucRacun = new JTextField();
		textFieldRucRacun.setFont(new Font("Arial", Font.PLAIN, 13));
		textFieldRucRacun.setColumns(10);
		textFieldRucRacun.setBounds(970, 20, 120, 20);
		panel.add(textFieldRucRacun);
		
		btnPonisti = new JButton("Poni\u0161ti");
		btnPonisti.setFont(new Font("Arial", Font.BOLD, 14));
		btnPonisti.setBounds(850, 140, 90, 25);
		contentPane.add(btnPonisti);
		
		btnPonisti.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					postaviModelProdajaPoRacunu(new ArrayList<>(), tablePregledRAcuna);
					suma(tablePregledRAcuna);
					
					//comboBoxGrupaArtikalaIzvestajProdaje.setSelectedItem(null);
					//comboBoxArtikalIzvestajProdaje.setSelectedItem(null);
					//comboBoxFilijalaIzvestajProdaje.setSelectedItem(null);
					
					dateChooserPregledRacunaOD.setDate(null);
					dateChooserpregledRacunaDO.setDate(null);
					
					textFieldNbavnaVrednostRacun.setText("");
					textFieldOsnovicaRAcun.setText("");
					textFieldRucRacun.setText("");
					textFieldProdajnaVrednostRacun.setText("");
					
					comboBoxKupacPregledRacuna.setEnabled(false);
					comboBoxKupacPregledRacuna.setSelectedItem(null);
					comboBoxGrupaArtiklaPregledRacuna.setEnabled(false);
					comboBoxGrupaArtiklaPregledRacuna.setSelectedItem(null);
					comboBoxArtikalPregledRAcuna.setEnabled(false);
					comboBoxGrupaArtiklaPregledRacuna.setSelectedItem(null);
					dateChooserpregledRacunaDO.cleanup();
					dateChooserPregledRacunaOD.cleanup();
					dateChooserpregledRacunaDO.setEnabled(true);
					dateChooserPregledRacunaOD.setEnabled(true);
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
			textFieldNbavnaVrednostRacun.setEditable(false);
			textFieldOsnovicaRAcun.setEditable(false);
			textFieldProdajnaVrednostRacun.setEditable(false);
			textFieldRucRacun.setEditable(false);
		
		
	}
	private void postaviModelProdajaPoRacunu(ArrayList lista, JTable t){
		JTableModelProdajPoRacunu model = new  JTableModelProdajPoRacunu(lista);
		t.setModel(model);
	}
	
	private void postaviModelRAcunaOtpremnice(ArrayList lista, JTable t){
		JTableModelRacunOtpremnica model = new JTableModelRacunOtpremnica(lista);
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
	
	private void popuniComboBoxIzvestajKupac(JComboBox<Kupac> comboBox) {
		try {
			ArrayList<Kupac> lista = Kontroler.getInstance().getKupac();

			for (Kupac k : lista) {
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
		
		for (int i = 0; i < tablePregledRAcuna.getRowCount(); i++) { 
			sum = sum + Double.parseDouble(tablePregledRAcuna.getValueAt(i,7).toString());
				
		}
		for (int i1 = 0; i1 < tablePregledRAcuna.getRowCount(); i1++) {
			sum1 = sum1 + Double.parseDouble(tablePregledRAcuna.getValueAt(i1,11).toString());
		 		
		 		}
		for (int i2 = 0; i2 < tablePregledRAcuna.getRowCount(); i2++) {
			sum2 = sum2 + Double.parseDouble(tablePregledRAcuna.getValueAt(i2,10).toString());
			
			}
				textFieldNbavnaVrednostRacun.setText(Double.toString(sum));
				textFieldRucRacun.setText(Double.toString(sum2-sum));
				textFieldOsnovicaRAcun.setText(Double.toString(sum1));
				textFieldProdajnaVrednostRacun.setText(Double.toString(sum2)); 
		  }
}
