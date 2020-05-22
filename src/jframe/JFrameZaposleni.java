package jframe;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.color.CMMException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import com.toedter.calendar.JDateChooser;

import kontroler.Kontroler;
import model.Filijala;
import model.Magacin;
import model.Zaposleni;
import verifier.SrpskaSlovaVerifier;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.InputVerifier;

import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class JFrameZaposleni extends JFrame {

	private JPanel contentPaneDodajZaposlenog;
	private JTextField textIme;
	private JLabel lblPrezime;
	private JTextField textPrezime;
	private JLabel lblAdresa;
	private JTextField textAdresa;
	private JLabel lblGradostina;
	private JTextField textGrad_Ostina;
	private JPanel panelPodacioZaposlenju;
	private JLabel lblStrucnaSprema;
	private JComboBox comboBoxStrucnaSprema;
	private JLabel lblDatumPocetkaZaposlenja;
	private JLabel lblDatumPrestankaZaposlenja;
	private JLabel lblFilijalaPosla;
	private JComboBox comboBoxFilijalaPosla;
	private JLabel lblPlata;
	private JTextField textPlata;
	private JLabel lblTipZaposlenja;
	private JComboBox comboBoxTipZaposlenja;
	private JPanel panel;
	private JLabel lblUsername;
	private JTextField textUsername;
	private JLabel lblPassword;
	private JTextField textPassword;
	private JButton btnPonistiAkciju;
	private JLabel lblIdZaposlenog;
	private JTextField textIDZaposlenog;
	private JPanel panelPodaciOPosluZaposleni;
	private JTextField textTelefon;
	private JTextField textEMail;
	private JButton btnAzurirajZaposlenog;	

	private JDateChooser dateChooserDatumZaposlenja;
	private JDateChooser dateChooserPrestankaZaposlenja;
	
	private JButton btnDodajZaposlenog;
	private JButton btnObrisiZaposlenog;
	private JTextField textJMBG;	
		
	
	public JLabel getLblPassword() {
		return lblPassword;
	}


	public JButton getBtnAzurirajZaposlenog() {
		return btnAzurirajZaposlenog;
	}	
	

	public JButton getBtnDodajZaposlenog() {
		return btnDodajZaposlenog;
	}

	public void setBtnDodajZaposlenog(JButton btnDodajZaposlenog) {
		this.btnDodajZaposlenog = btnDodajZaposlenog;
	}	
	

	public JTextField getTextIme() {
		return textIme;
	}

	public void setTextIme(JTextField textIme) {
		this.textIme = textIme;
	}

	public JTextField getTextPrezime() {
		return textPrezime;
	}

	public void setTextPrezime(JTextField textPrezime) {
		this.textPrezime = textPrezime;
	}

	public JTextField getTextAdresa() {
		return textAdresa;
	}

	public void setTextAdresa(JTextField textAdresa) {
		this.textAdresa = textAdresa;
	}

	public JTextField getTextGrad_Ostina() {
		return textGrad_Ostina;
	}

	public void setTextGrad_Ostina(JTextField textGrad_Ostina) {
		this.textGrad_Ostina = textGrad_Ostina;
	}

	public JComboBox getComboBoxStrucnaSprema() {
		return comboBoxStrucnaSprema;
	}

	public void setComboBoxStrucnaSprema(JComboBox comboBoxStrucnaSprema) {
		this.comboBoxStrucnaSprema = comboBoxStrucnaSprema;
	}

	public JComboBox getComboBoxFilijalaPosla() {
		return comboBoxFilijalaPosla;
	}

	public void setComboBoxFilijalaPosla(JComboBox comboBoxFilijalaPosla) {
		this.comboBoxFilijalaPosla = comboBoxFilijalaPosla;
	}

	public JTextField getTextPlata() {
		return textPlata;
	}

	public void setTextPlata(JTextField textPlata) {
		this.textPlata = textPlata;
	}

	public JComboBox getComboBoxTipZaposlenja() {
		return comboBoxTipZaposlenja;
	}

	public void setComboBoxTipZaposlenja(JComboBox comboBoxTipZaposlenja) {
		this.comboBoxTipZaposlenja = comboBoxTipZaposlenja;
	}

	public JTextField getTextUsername() {
		return textUsername;
	}

	public void setTextUsername(JTextField textUsername) {
		this.textUsername = textUsername;
	}

	public JTextField getTextPassword() {
		return textPassword;
	}

	public void setTextPassword(JTextField textPassword) {
		this.textPassword = textPassword;
	}

	public JTextField getTextIDZaposlenog() {
		return textIDZaposlenog;
	}

	public void setTextIDZaposlenog(JTextField textIDZaposlenog) {
		this.textIDZaposlenog = textIDZaposlenog;
	}

	public JTextField getTextTelefon() {
		return textTelefon;
	}

	public void setTextTelefon(JTextField textTelefon) {
		this.textTelefon = textTelefon;
	}

	public JTextField getTextEMail() {
		return textEMail;
	}

	public void setTextEMail(JTextField textEMail) {
		this.textEMail = textEMail;
	}	
	

	public JDateChooser getDateChooserDatumZaposlenja() {
		return dateChooserDatumZaposlenja;
	}

	public void setDateChooserDatumZaposlenja(JDateChooser dateChooserDatumZaposlenja) {
		this.dateChooserDatumZaposlenja = dateChooserDatumZaposlenja;
	}

	public JDateChooser getDateChooserPrestankaZaposlenja() {
		return dateChooserPrestankaZaposlenja;
	}

	public void setDateChooserPrestankaZaposlenja(JDateChooser dateChooserPrestankaZaposlenja) {
		this.dateChooserPrestankaZaposlenja = dateChooserPrestankaZaposlenja;
	}	

	public JButton getBtnPonistiAkciju() {
		return btnPonistiAkciju;
	}

	public void setBtnPonistiAkciju(JButton btnPonistiAkciju) {
		this.btnPonistiAkciju = btnPonistiAkciju;
	}	

	public JButton getBtnObrisiZaposlenog() {
		return btnObrisiZaposlenog;
	}

	public void setBtnObrisiZaposlenog(JButton btnObrisiZaposlenog) {
		this.btnObrisiZaposlenog = btnObrisiZaposlenog;
	}	

	public JTextField getTextJMBG() {
		return textJMBG;
	}	

	public JLabel getLblIdZaposlenog() {
		return lblIdZaposlenog;
	}


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameZaposleni frame = new JFrameZaposleni();
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
	public JFrameZaposleni() {
		setTitle("ZAPOSLENI");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 860, 550);
		contentPaneDodajZaposlenog = new JPanel();
		contentPaneDodajZaposlenog.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPaneDodajZaposlenog);
		contentPaneDodajZaposlenog.setLayout(null);

		JPanel panelLicnipodaci = new JPanel();
		panelLicnipodaci
				.setBorder(new TitledBorder(null, "Licni podaci", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelLicnipodaci.setBounds(10, 10, 400, 300);
		contentPaneDodajZaposlenog.add(panelLicnipodaci);
		panelLicnipodaci.setLayout(null);

		JLabel lblIme = new JLabel("Ime :");
		lblIme.setFont(new Font("Arial", Font.BOLD, 14));
		lblIme.setBounds(10, 20, 100, 20);
		panelLicnipodaci.add(lblIme);		
		
		textIme = new JTextField();
//		textIme.addKeyListener(new KeyAdapter() {
//			@Override
//			public void keyPressed(KeyEvent e) {
//				
//                Character c = e.getKeyChar();				
//				
//				if(Character.isLetter(c) || Character.isWhitespace(c) || Character.isISOControl(c)) {					
//							
//				}
//				else
//				{
//					JOptionPane.showMessageDialog(null, "U polje morate uneti slovo!");
//					textIme.setText("");
//				}		
//				
//			}
//		});
		textIme.setFont(new Font("Arial", Font.PLAIN, 13));
		textIme.setBounds(150, 20, 220, 20);
		panelLicnipodaci.add(textIme);
		textIme.setColumns(10);
		textIme.setInputVerifier(new SrpskaSlovaVerifier());

		lblPrezime = new JLabel("Prezime :");
		lblPrezime.setFont(new Font("Arial", Font.BOLD, 14));
		lblPrezime.setBounds(10, 60, 100, 20);
		panelLicnipodaci.add(lblPrezime);

		textPrezime = new JTextField();
		/*
		 * textPrezime.addKeyListener(new KeyAdapter() {
		 * 
		 * @Override public void keyPressed(KeyEvent e) {
		 * 
		 * Character c = e.getKeyChar();
		 * 
		 * if(Character.isLetter(c) || Character.isWhitespace(c) ||
		 * Character.isISOControl(c)) {
		 * 
		 * } else { JOptionPane.showMessageDialog(null, "U polje morate uneti slovo!");
		 * textPrezime.setText(""); } } });
		 */
		textPrezime.setFont(new Font("Arial", Font.PLAIN, 13));
		textPrezime.setBounds(150, 60, 220, 20);
		panelLicnipodaci.add(textPrezime);
		textPrezime.setColumns(10);
		textPrezime.setInputVerifier(new SrpskaSlovaVerifier());

		lblAdresa = new JLabel("Adresa :");
		lblAdresa.setFont(new Font("Arial", Font.BOLD, 14));
		lblAdresa.setBounds(10, 140, 100, 20);
		panelLicnipodaci.add(lblAdresa);

		textAdresa = new JTextField();
		textAdresa.setFont(new Font("Arial", Font.PLAIN, 13));
		textAdresa.setBounds(150, 140, 220, 20);
		panelLicnipodaci.add(textAdresa);
		textAdresa.setColumns(10);

		lblGradostina = new JLabel("Grad / Op\u0161tina :");
		lblGradostina.setFont(new Font("Arial", Font.BOLD, 14));
		lblGradostina.setBounds(10, 180, 120, 20);
		panelLicnipodaci.add(lblGradostina);

		textGrad_Ostina = new JTextField();
		textGrad_Ostina.setFont(new Font("Arial", Font.PLAIN, 13));
		textGrad_Ostina.setBounds(150, 180, 220, 20);
		panelLicnipodaci.add(textGrad_Ostina);
		textGrad_Ostina.setColumns(10);
		
		JLabel lblTelefon = new JLabel("Telefon :");
		lblTelefon.setFont(new Font("Arial", Font.BOLD, 14));
		lblTelefon.setBounds(10, 220, 100, 20);
		panelLicnipodaci.add(lblTelefon);
		
		JLabel lblEMail = new JLabel("E mail :");
		lblEMail.setFont(new Font("Arial", Font.BOLD, 14));
		lblEMail.setBounds(10, 260, 100, 20);
		panelLicnipodaci.add(lblEMail);
		
		textTelefon = new JTextField();
		textTelefon.setFont(new Font("Arial", Font.PLAIN, 13));
		textTelefon.setBounds(150, 220, 220, 20);
		panelLicnipodaci.add(textTelefon);
		textTelefon.setColumns(10);
		
		textEMail = new JTextField();
		textEMail.setFont(new Font("Arial", Font.PLAIN, 13));
		textEMail.setBounds(150, 260, 220, 20);
		panelLicnipodaci.add(textEMail);
		textEMail.setColumns(10);
		
		JLabel lblJmbg = new JLabel("JMBG :");
		lblJmbg.setFont(new Font("Arial", Font.BOLD, 14));
		lblJmbg.setBounds(10, 100, 100, 20);
		panelLicnipodaci.add(lblJmbg);
		
		textJMBG = new JTextField();
		textJMBG.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				
                Character c = e.getKeyChar();   
                
				
				if(!(Character.isDigit(c) || Character.isISOControl(c)))
				{
					JOptionPane.showMessageDialog(null, "U polje morate uneti broj!");
					
					e.consume();				
				}
			}
		});
		textJMBG.setFont(new Font("Arial", Font.PLAIN, 13));
		textJMBG.setBounds(150, 100, 220, 20);
		panelLicnipodaci.add(textJMBG);
		textJMBG.setColumns(10);

		panelPodacioZaposlenju = new JPanel();
		panelPodacioZaposlenju.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"),
				"Podaci o zaposlenju", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelPodacioZaposlenju.setBounds(430, 10, 400, 140);
		contentPaneDodajZaposlenog.add(panelPodacioZaposlenju);
		panelPodacioZaposlenju.setLayout(null);

		lblStrucnaSprema = new JLabel("Stru\u010Dna sprema :");
		lblStrucnaSprema.setFont(new Font("Arial", Font.BOLD, 14));
		lblStrucnaSprema.setBounds(10, 20, 220, 20);
		panelPodacioZaposlenju.add(lblStrucnaSprema);

		comboBoxStrucnaSprema = new JComboBox();
		comboBoxStrucnaSprema.setFont(new Font("Arial", Font.PLAIN, 13));
		comboBoxStrucnaSprema.setModel(
				new DefaultComboBoxModel(new String[] { "IV stepen", "V stepen", "VI stepen", "VII stepen" }));
		comboBoxStrucnaSprema.setBounds(250, 20, 130, 20);
		panelPodacioZaposlenju.add(comboBoxStrucnaSprema);
		comboBoxStrucnaSprema.setSelectedItem(null);

		lblDatumPocetkaZaposlenja = new JLabel("Datum pocetka zaposlenja :");
		lblDatumPocetkaZaposlenja.setFont(new Font("Arial", Font.BOLD, 14));
		lblDatumPocetkaZaposlenja.setBounds(10, 60, 220, 20);
		panelPodacioZaposlenju.add(lblDatumPocetkaZaposlenja);

		lblDatumPrestankaZaposlenja = new JLabel("Datum prestanka zaposlenja :");
		lblDatumPrestankaZaposlenja.setFont(new Font("Arial", Font.BOLD, 14));
		lblDatumPrestankaZaposlenja.setBounds(10, 100, 220, 20);
		panelPodacioZaposlenju.add(lblDatumPrestankaZaposlenja);

		/*JCheckBox chckbxDatumPrestankaPoslaNeodredjeno = new JCheckBox("Datum prestanka posla neodredjeno");
		chckbxDatumPrestankaPoslaNeodredjeno.setBounds(10, 141, 258, 23);
		panelPodacioZaposlenju.add(chckbxDatumPrestankaPoslaNeodredjeno);*/

		dateChooserDatumZaposlenja = new JDateChooser();
		dateChooserDatumZaposlenja.setForeground(Color.BLACK);
		dateChooserDatumZaposlenja.setBounds(250, 60, 130, 20);
		panelPodacioZaposlenju.add(dateChooserDatumZaposlenja);

		dateChooserPrestankaZaposlenja = new JDateChooser();
		dateChooserPrestankaZaposlenja.setBounds(250, 100, 130, 20);
		panelPodacioZaposlenju.add(dateChooserPrestankaZaposlenja);		

		panel = new JPanel();
		panel.setBorder(
				new TitledBorder(null, "Korisnicki podaci", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 340, 400, 140);
		contentPaneDodajZaposlenog.add(panel);
		panel.setLayout(null);

		lblUsername = new JLabel("Username :");
		lblUsername.setFont(new Font("Arial", Font.BOLD, 14));
		lblUsername.setBounds(10, 20, 100, 20);
		panel.add(lblUsername);

		textUsername = new JTextField();
		textUsername.setBounds(150, 20, 220, 20);
		panel.add(textUsername);
		textUsername.setColumns(10);

		lblPassword = new JLabel("Password :");
		lblPassword.setFont(new Font("Arial", Font.BOLD, 14));
		lblPassword.setBounds(10, 60, 100, 20);
		panel.add(lblPassword);

		textPassword = new JTextField();
		textPassword.setBounds(150, 60, 220, 20);
		panel.add(textPassword);
		textPassword.setColumns(10);

		textIDZaposlenog = new JTextField();
		textIDZaposlenog.setBounds(150, 100, 50, 20);
		panel.add(textIDZaposlenog);
		textIDZaposlenog.setColumns(10);

		lblIdZaposlenog = new JLabel("ID zaposlenog :");
		lblIdZaposlenog.setFont(new Font("Arial", Font.BOLD, 14));
		lblIdZaposlenog.setBounds(10, 100, 130, 20);
		panel.add(lblIdZaposlenog);

		btnDodajZaposlenog = new JButton("Dodaj zaposlenog");
		btnDodajZaposlenog.setFont(new Font("Arial", Font.BOLD, 14));
		btnDodajZaposlenog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {					

					String ime = textIme.getText();
					String prezime = textPrezime.getText();
					String jmbg = textJMBG.getText(); 
					String adresa = textAdresa.getText();
					String grad = textGrad_Ostina.getText();
					String tel = textTelefon.getText();
					String email = textEMail.getText();

					String username = textUsername.getText();
					String password = textPassword.getText();

					String struc_sprema = (String) comboBoxStrucnaSprema.getSelectedItem();

					Date datum_poc = dateChooserDatumZaposlenja.getDate();
					Date datum_zav = dateChooserPrestankaZaposlenja.getDate();

					// boolean datum_prest = chckbxDatumPrestankaPoslaNeodredjeno.isSelected();

				    int idfilijale = ((Filijala)comboBoxFilijalaPosla.getSelectedItem()).getIdFilijale();
					Double plata = Double.parseDouble(textPlata.getText().trim());
					String tip_zaposlenja = (String) comboBoxTipZaposlenja.getSelectedItem();

					Zaposleni z = new Zaposleni(idfilijale, ime, prezime, jmbg, adresa, grad, tel, email, struc_sprema, datum_poc, datum_zav, plata, tip_zaposlenja, username, password);
					
					if (textJMBG.getText().toString().length() != 13) {
					      throw new ArithmeticException(); 					
					} 	
					
					Date today = Calendar.getInstance().getTime();
					if(datum_poc.before(today) || datum_poc.after(datum_zav)) {
						JOptionPane.showMessageDialog(null, "Uneli ste pogresan datum u polje! \n(datum pocetka < datum zavrsetka)\n(datum pocetka > danasnji datum)");
						return;
					}	
					
					Kontroler.getInstance().insertZaposleni(z);

					JOptionPane.showMessageDialog(null, "Uspesno ste uneli novog zaposlenog!");
					
					textIme.setText("");
					textPrezime.setText("");
					textJMBG.setText("");
					textAdresa.setText("");
					textGrad_Ostina.setText("");
					textTelefon.setText("");
					textEMail.setText("");
					textUsername.setText("");
					textPassword.setText("");
					comboBoxStrucnaSprema.setSelectedItem(null);
					textPlata.setText("");
					comboBoxFilijalaPosla.setSelectedItem(null);
					comboBoxTipZaposlenja.setSelectedItem(null);
					dateChooserDatumZaposlenja.setSelectableDateRange(null, null);

				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch(SQLIntegrityConstraintViolationException e1){
					JOptionPane.showMessageDialog(btnDodajZaposlenog, "Username vec postoji!");
					textUsername.setText("");
				} catch(NumberFormatException e1){
					JOptionPane.showMessageDialog(btnDodajZaposlenog, "Sva polja moraju biti popunjena!");
					textUsername.setText("");
				}   catch(ArithmeticException e1){
					JOptionPane.showMessageDialog(btnDodajZaposlenog, "Uneli ste pogresan broj cifara! (JMBG = 13 cifara)");
					textJMBG.setText("");
				}				
				
				catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}				
			}
		});
		btnDodajZaposlenog.setBounds(450, 410, 180, 25);
		contentPaneDodajZaposlenog.add(btnDodajZaposlenog);

		btnObrisiZaposlenog = new JButton("Obri\u0161i zaposlenog");
		btnObrisiZaposlenog.setFont(new Font("Arial", Font.BOLD, 14));
		btnObrisiZaposlenog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int rbz = Integer.parseInt(textIDZaposlenog.getText().trim());
				
				try {
					Kontroler.getInstance().deleteZaposleni(rbz);
					JOptionPane.showMessageDialog(null, "Uspesno ste obrisali zaposlenog!");
					
					textIme.setText("");
					textPrezime.setText("");
					textJMBG.setText("");
					textAdresa.setText("");
					textGrad_Ostina.setText("");
					textTelefon.setText("");
					textEMail.setText("");
					textUsername.setText("");
					textPassword.setText("");
					comboBoxStrucnaSprema.setSelectedItem(null);
					textPlata.setText("");
					comboBoxFilijalaPosla.setSelectedItem(null);
					comboBoxTipZaposlenja.setSelectedItem(null);
					
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnObrisiZaposlenog.setBounds(650, 410, 180, 25);
		contentPaneDodajZaposlenog.add(btnObrisiZaposlenog);

		btnAzurirajZaposlenog = new JButton("A\u017Euriraj zaposlenog");
		btnAzurirajZaposlenog.setFont(new Font("Arial", Font.BOLD, 14));
		btnAzurirajZaposlenog.setBounds(450, 455, 180, 25);
		contentPaneDodajZaposlenog.add(btnAzurirajZaposlenog);

		btnPonistiAkciju = new JButton("Poni\u0161ti akciju");
		btnPonistiAkciju.setFont(new Font("Arial", Font.BOLD, 14));
		btnPonistiAkciju.setBounds(650, 455, 180, 25);
		contentPaneDodajZaposlenog.add(btnPonistiAkciju);

		panelPodaciOPosluZaposleni = new JPanel();
		panelPodaciOPosluZaposleni.setBorder(
				new TitledBorder(null, "Podaci o poslu", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelPodaciOPosluZaposleni.setBounds(430, 173, 400, 137);
		contentPaneDodajZaposlenog.add(panelPodaciOPosluZaposleni);
		panelPodaciOPosluZaposleni.setLayout(null);

		lblFilijalaPosla = new JLabel("Filijala posla :");
		lblFilijalaPosla.setFont(new Font("Arial", Font.BOLD, 14));
		lblFilijalaPosla.setBounds(10, 20, 220, 20);
		panelPodaciOPosluZaposleni.add(lblFilijalaPosla);
        
		comboBoxFilijalaPosla = new JComboBox();
		comboBoxFilijalaPosla.setFont(new Font("Arial", Font.PLAIN, 13));
		comboBoxFilijalaPosla.setBounds(250, 20, 130, 20);
		panelPodaciOPosluZaposleni.add(comboBoxFilijalaPosla);
		comboBoxFilijalaPosla.setSelectedItem(null);
		popuniComboBoxFilijala(comboBoxFilijalaPosla);		

		lblPlata = new JLabel("Plata :");
		lblPlata.setFont(new Font("Arial", Font.BOLD, 14));
		lblPlata.setBounds(10, 60, 220, 20);
		panelPodaciOPosluZaposleni.add(lblPlata);

		textPlata = new JTextField();
		textPlata.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				
                Character c = e.getKeyChar();   
                
				
				if(!(Character.isDigit(c) || Character.isISOControl(c)))
				{
					JOptionPane.showMessageDialog(null, "U polje morate uneti broj!");
					
					e.consume();				
				}
				
			}
		});
		textPlata.setFont(new Font("Arial", Font.PLAIN, 13));
		textPlata.setBounds(250, 60, 130, 20);
		panelPodaciOPosluZaposleni.add(textPlata);
		textPlata.setColumns(10);

		comboBoxTipZaposlenja = new JComboBox();
		comboBoxTipZaposlenja.setFont(new Font("Arial", Font.PLAIN, 13));
		comboBoxTipZaposlenja.setBounds(250, 100, 130, 20);
		panelPodaciOPosluZaposleni.add(comboBoxTipZaposlenja);
		comboBoxTipZaposlenja.setSelectedItem(null);
		comboBoxTipZaposlenja
				.setModel(new DefaultComboBoxModel(new String[] {"Admin", "Menadžer", "Komercijalista"}));
		

		lblTipZaposlenja = new JLabel("Tip zaposlenja :");
		lblTipZaposlenja.setFont(new Font("Arial", Font.BOLD, 14));
		lblTipZaposlenja.setBounds(10, 100, 220, 20);
		panelPodaciOPosluZaposleni.add(lblTipZaposlenja);
		
	}
	
	private void popuniComboBoxFilijala(JComboBox<Filijala> comboBox) {
		try {
			ArrayList<Filijala> lista = Kontroler.getInstance().getFilijala();
            
			for (Filijala f : lista) {
				
				comboBox.addItem(f);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		
	}
}


