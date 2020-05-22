package jframePregled;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import com.toedter.calendar.JDateChooser;

import jframe.JFrameRacun_otpreminica;
import kontroler.Kontroler;
import model.Izvestaj;
import model.Kupac;
import model.RacunOtpremnica;
import table.JTableModelPregledRacunaPoStatusu;
import table.JTableModelPregledRacunaRacuna;
import table.JTableModelProdajaPoFilijali;
import table.JTableModelRacunOtpremnica;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JRadioButton;

public class JFramePregledRacunaPoStatusu extends JFrame {

	private JPanel contentPane;
	private JTable tablePregledRacunaPoStatusu;
	private JDateChooser dateChooserPregledRacunaDO;
	private JDateChooser dateChooserPregledRacunaOD;
	private JTextField textFieldUkupnoNetoPregledRacuna;
	private JTextField textFieldUkupnoPdvPregledRacuna;
	private JTextField textFieldUkupnoBrutoPregledRacuna;
	private JRadioButton rdbtnAktivan;
	private JRadioButton rdbtnKreiran;
	private JRadioButton rdbtnStorniran;
	private JButton btnNazad;	

	public JButton getBtnNazad() {
		return btnNazad;
	}

	public JRadioButton getRdbtnStorniran() {
		return rdbtnStorniran;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFramePregleRacuna frame = new JFramePregleRacuna();
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
	public JFramePregledRacunaPoStatusu() {
		setTitle("PREGLED RA\u010CUNA");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 950, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelPodaciZaPeriodPregedRAcuna = new JPanel();
		panelPodaciZaPeriodPregedRAcuna.setLayout(null);
		panelPodaciZaPeriodPregedRAcuna.setBorder(new TitledBorder(null, "Podaci za period", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelPodaciZaPeriodPregedRAcuna.setBounds(20, 25, 600, 60);
		contentPane.add(panelPodaciZaPeriodPregedRAcuna);
		
		JLabel label = new JLabel("DO :");
		label.setFont(new Font("Arial", Font.BOLD, 14));
		label.setBounds(260, 30, 30, 20);
		panelPodaciZaPeriodPregedRAcuna.add(label);
		
		JLabel label_1 = new JLabel("OD :");
		label_1.setFont(new Font("Arial", Font.BOLD, 14));
		label_1.setBounds(10, 30, 30, 20);
		panelPodaciZaPeriodPregedRAcuna.add(label_1);
		
		dateChooserPregledRacunaDO = new JDateChooser();
		dateChooserPregledRacunaDO.setBounds(310, 30, 150, 20);
		panelPodaciZaPeriodPregedRAcuna.add(dateChooserPregledRacunaDO);
		
		dateChooserPregledRacunaOD = new JDateChooser();
		dateChooserPregledRacunaOD.setBounds(60, 30, 150, 20);
		panelPodaciZaPeriodPregedRAcuna.add(dateChooserPregledRacunaOD);
		
		JButton btnPretraziPregledRAcuna = new JButton("Pretra\u017Ei");
		btnPretraziPregledRAcuna.setFont(new Font("Arial", Font.BOLD, 14));
		btnPretraziPregledRAcuna.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				postaviModelPregledRacunaPoStatusu(new ArrayList<Kupac>(), tablePregledRacunaPoStatusu);
				ArrayList lista;
				try {
					
					if(dateChooserPregledRacunaOD.getDate() == null || dateChooserPregledRacunaDO.getDate() == null)
					{
						JOptionPane.showMessageDialog(btnPretraziPregledRAcuna, "Unesite datume!");
						return;
					}
					
					    SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
					    String sd = sdf.format(dateChooserPregledRacunaOD.getDate());
					    String sd1 = sdf.format(dateChooserPregledRacunaDO.getDate());
						
												
						Date datumOD = dateChooserPregledRacunaOD.getDate();
						Date datumDO = dateChooserPregledRacunaDO.getDate();
						
						
						Date today = Calendar.getInstance().getTime();
						if(datumOD.after(datumDO)) {
							JOptionPane.showMessageDialog(btnPretraziPregledRAcuna, "Uneli ste pogresan datum u polje! \n(datum OD < datum DO)");
							
							return;
							
						}
						dateChooserPregledRacunaOD.setSelectableDateRange(null, null);
						dateChooserPregledRacunaDO.setSelectableDateRange(null, null);
						
						
						
						
						
						lista = Kontroler.getInstance().getRacunPregledRacunaPoStatusu(sd, sd1);
						
						postaviModelPregledRacunaPoStatusu(lista, tablePregledRacunaPoStatusu);
						suma(tablePregledRacunaPoStatusu);
						
						
						
						
						
					} catch (ClassNotFoundException | SQLException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					} catch(NumberFormatException e1){
						JOptionPane.showMessageDialog(btnPretraziPregledRAcuna, "Sva polja moraju biti popunjena!");
						
					}	
			}
		});
		btnPretraziPregledRAcuna.setBounds(480, 30, 90, 25);
		panelPodaciZaPeriodPregedRAcuna.add(btnPretraziPregledRAcuna);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 200, 904, 254);
		contentPane.add(scrollPane);
		
		tablePregledRacunaPoStatusu = new JTable();
		scrollPane.setViewportView(tablePregledRacunaPoStatusu);
		postaviModelPregledRacunaPoStatusu(new ArrayList<>(), tablePregledRacunaPoStatusu);
		
		tablePregledRacunaPoStatusu.addMouseListener(new MouseListener() {		
			
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount()%2 == 0) {
					String s = tablePregledRacunaPoStatusu.getModel().getValueAt(tablePregledRacunaPoStatusu.getSelectedRow(), 3).toString();
					
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
					ro.setVisible(true);
					
					ArrayList lista;
					
					try {
					
						int id_racuna = Integer.parseInt(s);
						ro.getTextFieldRacunOtpremnicaRacun().setText(s);
						Date d =Kontroler.getInstance().datumValuteRacuna(id_racuna);
						ro.getDateChooserNaplateracuna().setDate(d);
						ro.getDateChooserRacunOtpremnica().setDate(Kontroler.getInstance().datumRacuna(id_racuna));
						
						
						lista = Kontroler.getInstance().getStavkeRacunaOtpremniceIzvestaj(id_racuna);
						postaviModelRAcunaOtpremnice(lista, ro.getTableStavkeRacuna());
						suma(tablePregledRacunaPoStatusu);
						
						
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
		
		JLabel lblUkupnoNeto = new JLabel("Ukupno neto :");
		lblUkupnoNeto.setFont(new Font("Arial", Font.BOLD, 14));
		lblUkupnoNeto.setBounds(20, 550, 100, 20);
		contentPane.add(lblUkupnoNeto);
		
		textFieldUkupnoNetoPregledRacuna = new JTextField();
		textFieldUkupnoNetoPregledRacuna.setFont(new Font("Arial", Font.PLAIN, 13));
		textFieldUkupnoNetoPregledRacuna.setBounds(140, 550, 100, 20);
		contentPane.add(textFieldUkupnoNetoPregledRacuna);
		textFieldUkupnoNetoPregledRacuna.setColumns(10);
		
		JLabel lblUkupnoPdv = new JLabel("Ukupno PDV :");
		lblUkupnoPdv.setFont(new Font("Arial", Font.BOLD, 14));
		lblUkupnoPdv.setBounds(280, 550, 100, 20);
		contentPane.add(lblUkupnoPdv);
		
		textFieldUkupnoPdvPregledRacuna = new JTextField();
		textFieldUkupnoPdvPregledRacuna.setFont(new Font("Arial", Font.PLAIN, 14));
		textFieldUkupnoPdvPregledRacuna.setBounds(400, 550, 100, 20);
		contentPane.add(textFieldUkupnoPdvPregledRacuna);
		textFieldUkupnoPdvPregledRacuna.setColumns(10);
		
		JLabel lblUkupnoButo = new JLabel("Ukupno buto :");
		lblUkupnoButo.setFont(new Font("Arial", Font.BOLD, 14));
		lblUkupnoButo.setBounds(540, 550, 100, 20);
		contentPane.add(lblUkupnoButo);
		
		textFieldUkupnoBrutoPregledRacuna = new JTextField();
		textFieldUkupnoBrutoPregledRacuna.setFont(new Font("Arial", Font.PLAIN, 13));
		textFieldUkupnoBrutoPregledRacuna.setBounds(660, 550, 100, 20);
		contentPane.add(textFieldUkupnoBrutoPregledRacuna);
		textFieldUkupnoBrutoPregledRacuna.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Pretraga po statusu ra\u010Duna", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(20, 105, 600, 60);
		contentPane.add(panel);
		panel.setLayout(null);
		
		rdbtnAktivan = new JRadioButton("Aktivan");
		rdbtnAktivan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Izvestaj i = new Izvestaj();
				//RacunOtpremnica ro = new RacunOtpremnica();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
				String sd = sdf.format(dateChooserPregledRacunaOD.getDate());
				String sd1 = sdf.format(dateChooserPregledRacunaDO.getDate());
				ArrayList lista;
				try {
					//ArrayList<Izvestaj> lista = new ArrayList<>();
					
					if(rdbtnAktivan.isSelected()) {
					
					lista = Kontroler.getInstance().getRacunPregledRacunaPoStatusuAktivan(sd, sd1);
					//if((i.getStatusRacuna().toString()).equals("Aktivan")) {
						
						postaviModelPregledRacunaPoStatusu(lista, tablePregledRacunaPoStatusu);
						suma(tablePregledRacunaPoStatusu);
					}
					}
				 catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		rdbtnAktivan.setFont(new Font("Arial", Font.BOLD, 14));
		rdbtnAktivan.setBounds(10, 30, 100, 25);
		panel.add(rdbtnAktivan);
		
		rdbtnKreiran = new JRadioButton("Kreiran");
		rdbtnKreiran.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Izvestaj i = new Izvestaj();
				//RacunOtpremnica ro = new RacunOtpremnica();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
				String sd = sdf.format(dateChooserPregledRacunaOD.getDate());
				String sd1 = sdf.format(dateChooserPregledRacunaDO.getDate());
				ArrayList lista;
				try {
					//ArrayList<Izvestaj> lista = new ArrayList<>();
					
					if(rdbtnKreiran.isSelected()) {
					
					lista = Kontroler.getInstance().getRacunPregledRacunaPoStatusuKreiran(sd, sd1);
					//if((i.getStatusRacuna().toString()).equals("Aktivan")) {
						
						postaviModelPregledRacunaPoStatusu(lista, tablePregledRacunaPoStatusu);
						suma(tablePregledRacunaPoStatusu);
					}
					}
				 catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		rdbtnKreiran.setFont(new Font("Arial", Font.BOLD, 14));
		rdbtnKreiran.setBounds(130, 30, 100, 25);
		panel.add(rdbtnKreiran);
		
		rdbtnStorniran = new JRadioButton("Storniran");
		rdbtnStorniran.setFont(new Font("Arial", Font.BOLD, 14));
		rdbtnStorniran.setBounds(250, 30, 100, 25);
		panel.add(rdbtnStorniran);
		
		ButtonGroup status = new ButtonGroup();
		status.add(rdbtnAktivan);
		status.add(rdbtnKreiran);
		status.add(rdbtnStorniran);
		
		JButton btnObrisiTabelu = new JButton("Obri\u0161i tabelu");
		btnObrisiTabelu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
				
					
					postaviModelPregledRacunaPoStatusu(new ArrayList<>(), tablePregledRacunaPoStatusu);
					suma(tablePregledRacunaPoStatusu);
				    //status.setSelected(null, (Boolean)null);
				    
				    dateChooserPregledRacunaOD.setDate(null);
				    dateChooserPregledRacunaDO.setDate(null);
				
					rdbtnAktivan.setSelected(false);
					rdbtnKreiran.setSelected(false);
			}
		});
		btnObrisiTabelu.setFont(new Font("Arial", Font.BOLD, 14));
		btnObrisiTabelu.setBounds(20, 480, 150, 25);
		contentPane.add(btnObrisiTabelu);
		
		btnNazad = new JButton("Nazad");
		btnNazad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				dispose();
			}
		});
		btnNazad.setFont(new Font("Arial", Font.BOLD, 14));
		btnNazad.setBounds(774, 480, 150, 25);
		contentPane.add(btnNazad);
		textFieldUkupnoBrutoPregledRacuna.setEditable(false);
		textFieldUkupnoNetoPregledRacuna.setEditable(false);
		textFieldUkupnoPdvPregledRacuna.setEditable(false);
		
	}
	private void postaviModelPregledRacunaPoStatusu(ArrayList lista, JTable t){
		 JTableModelPregledRacunaPoStatusu model = new  JTableModelPregledRacunaPoStatusu(lista);
		t.setModel(model);		
	}
	
	private void postaviModelRAcunaOtpremnice(ArrayList lista, JTable t){
		JTableModelRacunOtpremnica model = new JTableModelRacunOtpremnica(lista);
		t.setModel(model);
	}
	
	
	private void suma (JTable t) {
		double sum = 0; double sum1 = 0; double sum2 = 0;
		
		for (int i = 0; i < tablePregledRacunaPoStatusu.getRowCount(); i++) { 
			sum = sum + Double.parseDouble(tablePregledRacunaPoStatusu.getValueAt(i,4).toString());
				
		}
		for (int i1 = 0; i1 < tablePregledRacunaPoStatusu.getRowCount(); i1++) {
			sum1 = sum1 + Double.parseDouble(tablePregledRacunaPoStatusu.getValueAt(i1,6).toString());
		 		
		 		}
		for (int i2 = 0; i2 < tablePregledRacunaPoStatusu.getRowCount(); i2++) {
			sum2 = sum2 + Double.parseDouble(tablePregledRacunaPoStatusu.getValueAt(i2,5).toString());
			
			}
				textFieldUkupnoNetoPregledRacuna.setText(Double.toString(sum));
				textFieldUkupnoBrutoPregledRacuna.setText(Double.toString(sum1));
				textFieldUkupnoPdvPregledRacuna.setText(Double.toString(sum2));
			
		  }
}
