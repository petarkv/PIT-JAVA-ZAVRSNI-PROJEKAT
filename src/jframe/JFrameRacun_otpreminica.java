package jframe;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

import kontroler.Kontroler;
import model.Artikli;
import model.Kupac;
import model.RacunOtpremnica;
import table.JTableModelGrupeArtikala;
import table.JTableModelRacunOtpremnica;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class JFrameRacun_otpreminica extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldRacunOtpremnicaRacun;
	private JLabel lblDatumRacun;
	private JTextField textFieldNetoRacun;
	private JTextField textFieldPDVRacun;
	private JTextField textFieldBrutoRacun;
	private JTable tableStavkeRacuna;
	private JButton btnNovaPoyicijaRacun;
	private JButton btnPonistiAkcijuRacunOtpremnica;
	private JComboBox<Kupac> comboBoxKupacRacun;
	private int generatedID;
	private JDateChooser dateChooserNaplateracuna;
	private JButton btnKreirajRacun;
	private JDateChooser dateChooserRacunOtpremnica;
	private JButton btnZapocniProdajuStavkeRacuna;
	private JButton btnObrisiRacun;
	private JButton btnIzmeniRacun;	
	
	public JButton getBtnIzmeniRacun() {
		return btnIzmeniRacun;
	}
	public JButton getBtnObrisiRacun() {
		return btnObrisiRacun;
	}
	public void setDateChooserNaplateracuna(JDateChooser dateChooserNaplateracuna) {
		this.dateChooserNaplateracuna = dateChooserNaplateracuna;
	}
	public JTextField getTextFieldNetoRacun() {
		// TODO Auto-generated method stub
		return textFieldNetoRacun;
	}
	public JTextField getTextFieldPDVRacun() {
		return textFieldPDVRacun;
	}
	public JTextField getTextFieldBrutoRacun() {
		return textFieldBrutoRacun;
	}
	public JTable getTableStavkeRacuna() {
		return tableStavkeRacuna;
	}
	public JButton getBtnZapocniProdajuStavkeRacuna() {
		return btnZapocniProdajuStavkeRacuna;
	}
	public JTextField getTextFieldRacunOtpremnicaRacun() {
		return textFieldRacunOtpremnicaRacun;
	}

	public JDateChooser getDateChooserNaplateracuna() {
		return dateChooserNaplateracuna;
	}

	
	public int getGeneratedID() {
		return generatedID;
	}

	public JComboBox<Kupac> getComboBoxKupacRacun() {
		return comboBoxKupacRacun;
	}

	public JDateChooser getDateChooserRacunOtpremnica() {
		return dateChooserRacunOtpremnica;
	}

	public JButton getBtnKreirajRacun() {
		return btnKreirajRacun;
	}

	public JButton getBtnPonistiAkcijuRacunOtpremnica() {
		return btnPonistiAkcijuRacunOtpremnica;
	}

	public JButton getBtnNovaPoyicijaRacun() {
		return btnNovaPoyicijaRacun;
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameRacun_otpreminica frame = new JFrameRacun_otpreminica();
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
	public JFrameRacun_otpreminica() {
		setTitle("RA\u010CUN / OTPREMNICA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblKupacRacun = new JLabel("Kupac :");
		lblKupacRacun.setFont(new Font("Arial", Font.BOLD, 14));
		lblKupacRacun.setBounds(10, 30, 150, 20);
		contentPane.add(lblKupacRacun);

		JLabel lblRacunotpreminica = new JLabel("Ra\u010Dun / Otpreminica :");
		lblRacunotpreminica.setFont(new Font("Arial", Font.BOLD, 14));
		lblRacunotpreminica.setBounds(10, 70, 160, 20);
		contentPane.add(lblRacunotpreminica);

		textFieldRacunOtpremnicaRacun = new JTextField();
		textFieldRacunOtpremnicaRacun.setFont(new Font("Arial", Font.PLAIN, 13));
		textFieldRacunOtpremnicaRacun.setBounds(200, 70, 180, 20);
		contentPane.add(textFieldRacunOtpremnicaRacun);
		textFieldRacunOtpremnicaRacun.setColumns(10);

		lblDatumRacun = new JLabel("Datum :");
		lblDatumRacun.setFont(new Font("Arial", Font.BOLD, 14));
		lblDatumRacun.setBounds(500, 30, 130, 20);
		contentPane.add(lblDatumRacun);

		dateChooserRacunOtpremnica = new JDateChooser();
		dateChooserRacunOtpremnica.setBounds(650, 30, 280, 20);
		contentPane.add(dateChooserRacunOtpremnica);
		Date date = new Date();
		Calendar calendar = Calendar.getInstance();
		int subtractYearValue = 0;

		int currentYear = Calendar.getInstance().get(Calendar.YEAR);
		int currentMonth = Calendar.getInstance().get(Calendar.MONTH);
		int currentDate= Calendar.getInstance().get(Calendar.DATE);

		calendar.set(currentYear - subtractYearValue , currentMonth , currentDate);
		date.setTime(calendar.getTimeInMillis());

		dateChooserRacunOtpremnica.setDate(date);

		JLabel lblNetopdvbruto = new JLabel("Neto/PDV/Bruto :");
		lblNetopdvbruto.setFont(new Font("Arial", Font.BOLD, 14));
		lblNetopdvbruto.setBounds(500, 110, 130, 20);
		contentPane.add(lblNetopdvbruto);

		textFieldNetoRacun = new JTextField();
		textFieldNetoRacun.setFont(new Font("Arial", Font.PLAIN, 13));
		textFieldNetoRacun.setBounds(650, 110, 90, 20);
		contentPane.add(textFieldNetoRacun);
		textFieldNetoRacun.setColumns(10);

		textFieldPDVRacun = new JTextField();
		textFieldPDVRacun.setFont(new Font("Arial", Font.PLAIN, 13));
		textFieldPDVRacun.setBounds(745, 110, 90, 20);
		contentPane.add(textFieldPDVRacun);
		textFieldPDVRacun.setColumns(10);

		textFieldBrutoRacun = new JTextField();
		textFieldBrutoRacun.setFont(new Font("Arial", Font.PLAIN, 13));
		textFieldBrutoRacun.setBounds(840, 110, 90, 20);
		contentPane.add(textFieldBrutoRacun);
		textFieldBrutoRacun.setColumns(10);

		JScrollPane scrollPaneRacun = new JScrollPane();
		scrollPaneRacun.setBounds(10, 141, 1164, 320);
		contentPane.add(scrollPaneRacun);

		tableStavkeRacuna = new JTable();
		postaviModelRAcunaOtpremnice(new ArrayList<>(), tableStavkeRacuna);
		ArrayList lista;
		suma(tableStavkeRacuna);
		
		scrollPaneRacun.setViewportView(tableStavkeRacuna);

		btnNovaPoyicijaRacun = new JButton("Nova pozicija");
		btnNovaPoyicijaRacun.setFont(new Font("Arial", Font.BOLD, 14));
		btnNovaPoyicijaRacun.setBounds(10, 500, 150, 25);
		contentPane.add(btnNovaPoyicijaRacun);

		btnIzmeniRacun = new JButton("Izmeni");
		btnIzmeniRacun.setFont(new Font("Arial", Font.BOLD, 14));
		btnIzmeniRacun.setBounds(200, 500, 150, 25);
		contentPane.add(btnIzmeniRacun);
		btnIzmeniRacun.setVisible(false);

		btnObrisiRacun = new JButton("Obri\u0161i");
		btnObrisiRacun.setFont(new Font("Arial", Font.BOLD, 14));
		btnObrisiRacun.setBounds(200, 500, 150, 25);
		contentPane.add(btnObrisiRacun);

		btnKreirajRacun = new JButton("Kreiraj");
		btnKreirajRacun.setFont(new Font("Arial", Font.BOLD, 14));
		btnKreirajRacun.setBounds(1024, 500, 150, 25);
		contentPane.add(btnKreirajRacun);
		
		btnPonistiAkcijuRacunOtpremnica = new JButton("Poni\u0161ti akciju");
		btnPonistiAkcijuRacunOtpremnica.setFont(new Font("Arial", Font.BOLD, 14));
		btnPonistiAkcijuRacunOtpremnica.setBounds(390, 500, 150, 25);
		contentPane.add(btnPonistiAkcijuRacunOtpremnica);
		
		comboBoxKupacRacun = new JComboBox<Kupac>();
		comboBoxKupacRacun.setFont(new Font("Arial", Font.PLAIN, 13));
		comboBoxKupacRacun.setBounds(200, 30, 180, 20);
		contentPane.add(comboBoxKupacRacun);
		popuniComboBoxKupacRacun(comboBoxKupacRacun);
		comboBoxKupacRacun.setSelectedItem(null);
		
		dateChooserNaplateracuna = new JDateChooser();
		dateChooserNaplateracuna.setBounds(650, 70, 280, 20);
		contentPane.add(dateChooserNaplateracuna);
		
		btnZapocniProdajuStavkeRacuna = new JButton("Zapo\u010Dni prodaju");
		btnZapocniProdajuStavkeRacuna.setFont(new Font("Arial", Font.BOLD, 14));
		btnZapocniProdajuStavkeRacuna.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			}
		});
		btnZapocniProdajuStavkeRacuna.setBounds(200, 110, 150, 25);
		contentPane.add(btnZapocniProdajuStavkeRacuna);
		
		JLabel lblValutaRacunOtpremnica = new JLabel("Valuta :");
		lblValutaRacunOtpremnica.setFont(new Font("Arial", Font.BOLD, 14));
		lblValutaRacunOtpremnica.setBounds(500, 70, 130, 20);
		contentPane.add(lblValutaRacunOtpremnica);
		
	}
	

	private void postaviModelRAcunaOtpremnice(ArrayList lista, JTable t){
		JTableModelRacunOtpremnica model = new JTableModelRacunOtpremnica(lista);
		t.setModel(model);
	}
	private void popuniComboBoxKupacRacun(JComboBox<Kupac> comboBox) {
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
		double sum = 0;
		double sum1 = 0;
		double sum2 = 0;
		
		double sumN =0;
		for (int i = 0; i < tableStavkeRacuna.getRowCount(); i++) {
			double iznos = (double) tableStavkeRacuna.getValueAt(i, 8);
					sumN+=iznos;
					textFieldNetoRacun.setText(Double.toString(sumN));
					
		}
		double sumPDV =0;
		for (int i = 0; i < tableStavkeRacuna.getRowCount(); i++) {
			double iznos = (double) tableStavkeRacuna.getValueAt(i, 9);
					sumPDV+=iznos;
					textFieldPDVRacun.setText(Double.toString(sumPDV));
	}
		double sumB =0;
		for (int i = 0; i < tableStavkeRacuna.getRowCount(); i++) {
			double iznos = (double) tableStavkeRacuna.getValueAt(i, 10);
					sumB+=iznos;
					textFieldBrutoRacun.setText(Double.toString(sumB));
		}
	}
}
