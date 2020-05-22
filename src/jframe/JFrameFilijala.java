package jframe;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import kontroler.Kontroler;
import model.Filijala;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class JFrameFilijala extends JFrame {

	private JPanel contentPaneFilijala;
	private JTextField textNazivFilijale;
	private JTextField textAdresaFilijale;
	private JTextField textGradOpstinaFilijale;
	private JTextField textE_MailFilijale;
	private JTextField textTelefonFilijale;
	private JPanel panelPoslovniPodaciFilijale;
	private JLabel lblPibFilijale;
	private JTextField textPibFilijale;
	private JLabel lblTekuciRacunFilijale;
	private JTextField textTekuciRacunFilijale;
	private JLabel lblIDFilijale;
	private JTextField textIDFilijale;
	private JButton btnDodajFilijalu;
	private JButton btnPonistiAkcijuFilijala;
	private JButton btnObrisiFilijalu;
	private JButton btnAzurirajFilijalu;
	private JRadioButton rdbtnAktivna;
	private JRadioButton rdbtnNeaktivna;
	private final ButtonGroup buttonGroupFilijala = new ButtonGroup();	

	public JPanel getContentPaneFilijala() {
		return contentPaneFilijala;
	}

	public void setContentPaneFilijala(JPanel contentPaneFilijala) {
		this.contentPaneFilijala = contentPaneFilijala;
	}

	public JTextField getTextNazivFilijale() {
		return textNazivFilijale;
	}

	public void setTextNazivFilijale(JTextField textNazivFilijale) {
		this.textNazivFilijale = textNazivFilijale;
	}

	public JTextField getTextAdresaFilijale() {
		return textAdresaFilijale;
	}

	public void setTextAdresaFilijale(JTextField textAdresaFilijale) {
		this.textAdresaFilijale = textAdresaFilijale;
	}

	public JTextField getTextGradOpstinaFilijale() {
		return textGradOpstinaFilijale;
	}

	public void setTextGradOpstinaFilijale(JTextField textGradOpstinaFilijale) {
		this.textGradOpstinaFilijale = textGradOpstinaFilijale;
	}

	public JTextField getTextE_MailFilijale() {
		return textE_MailFilijale;
	}

	public void setTextE_MailFilijale(JTextField textE_MailFilijale) {
		this.textE_MailFilijale = textE_MailFilijale;
	}

	public JTextField getTextTelefonFilijale() {
		return textTelefonFilijale;
	}

	public void setTextTelefonFilijale(JTextField textTelefonFilijale) {
		this.textTelefonFilijale = textTelefonFilijale;
	}

	public JPanel getPanelPoslovniPodaciFilijale() {
		return panelPoslovniPodaciFilijale;
	}

	public void setPanelPoslovniPodaciFilijale(JPanel panelPoslovniPodaciFilijale) {
		this.panelPoslovniPodaciFilijale = panelPoslovniPodaciFilijale;
	}

	public JLabel getLblPibFilijale() {
		return lblPibFilijale;
	}

	public void setLblPibFilijale(JLabel lblPibFilijale) {
		this.lblPibFilijale = lblPibFilijale;
	}

	public JTextField getTextPibFilijale() {
		return textPibFilijale;
	}

	public void setTextPibFilijale(JTextField textPibFilijale) {
		this.textPibFilijale = textPibFilijale;
	}

	public JLabel getLblTekuciRacunFilijale() {
		return lblTekuciRacunFilijale;
	}

	public void setLblTekuciRacunFilijale(JLabel lblTekuciRacunFilijale) {
		this.lblTekuciRacunFilijale = lblTekuciRacunFilijale;
	}

	public JTextField getTextTekuciRacunFilijale() {
		return textTekuciRacunFilijale;
	}

	public void setTextTekuciRacunFilijale(JTextField textTekuciRacunFilijale) {
		this.textTekuciRacunFilijale = textTekuciRacunFilijale;
	}

	public JLabel getLblIDFilijale() {
		return lblIDFilijale;
	}

	public void setLblIDFilijale(JLabel lblIDFilijale) {
		this.lblIDFilijale = lblIDFilijale;
	}

	public JTextField getTextIDFilijale() {
		return textIDFilijale;
	}

	public void setTextIDFilijale(JTextField textIDFilijale) {
		this.textIDFilijale = textIDFilijale;
	}

	public ButtonGroup getButtonGroupFilijala() {
		return buttonGroupFilijala;
	}	

	public JButton getBtnDodajFilijalu() {
		return btnDodajFilijalu;
	}

	public void setBtnDodajFilijalu(JButton btnDodajFilijalu) {
		this.btnDodajFilijalu = btnDodajFilijalu;
	}	

	public JButton getBtnPonistiAkcijuFilijala() {
		return btnPonistiAkcijuFilijala;
	}

	public void setBtnPonistiAkcijuFilijala(JButton btnPonistiAkcijuFilijala) {
		this.btnPonistiAkcijuFilijala = btnPonistiAkcijuFilijala;
	}

	public JButton getBtnObrisiFilijalu() {
		return btnObrisiFilijalu;
	}

	public void setBtnObrisiFilijalu(JButton btnObrisiFilijalu) {
		this.btnObrisiFilijalu = btnObrisiFilijalu;
	}

	public JButton getBtnAzurirajFilijalu() {
		return btnAzurirajFilijalu;
	}

	public void setBtnAzurirajFilijalu(JButton btnAzurirajFilijalu) {
		this.btnAzurirajFilijalu = btnAzurirajFilijalu;
	}	

	public JRadioButton getRdbtnAktivna() {
		return rdbtnAktivna;
	}

	public void setRdbtnAktivna(JRadioButton rdbtnAktivna) {
		this.rdbtnAktivna = rdbtnAktivna;
	}

	public JRadioButton getRdbtnNeaktivna() {
		return rdbtnNeaktivna;
	}

	public void setRdbtnNeaktivna(JRadioButton rdbtnNeaktivna) {
		this.rdbtnNeaktivna = rdbtnNeaktivna;
	}	
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameFilijala frame = new JFrameFilijala();
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
	public JFrameFilijala() {
		setTitle("FILIJALA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 860, 402);
		contentPaneFilijala = new JPanel();
		contentPaneFilijala.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPaneFilijala);
		contentPaneFilijala.setLayout(null);

		JPanel panelPodaciOFilijali = new JPanel();
		panelPodaciOFilijali.setLayout(null);
		panelPodaciOFilijali.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Podaci o filijali",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelPodaciOFilijali.setBounds(10, 10, 400, 220);
		contentPaneFilijala.add(panelPodaciOFilijali);

		JLabel labelNayivfilijale = new JLabel("Naziv filijale :");
		labelNayivfilijale.setFont(new Font("Arial", Font.BOLD, 14));
		labelNayivfilijale.setBounds(10, 20, 150, 20);
		panelPodaciOFilijali.add(labelNayivfilijale);

		JLabel lblAdresaFilijale = new JLabel("Adresa filijale :");
		lblAdresaFilijale.setFont(new Font("Arial", Font.BOLD, 14));
		lblAdresaFilijale.setBounds(10, 60, 150, 20);
		panelPodaciOFilijali.add(lblAdresaFilijale);

		JLabel lblGradOpstinaFilijale = new JLabel("Grad / Op\u0161tina :");
		lblGradOpstinaFilijale.setFont(new Font("Arial", Font.BOLD, 14));
		lblGradOpstinaFilijale.setBounds(10, 100, 150, 20);
		panelPodaciOFilijali.add(lblGradOpstinaFilijale);

		JLabel lblTelefonFilijale = new JLabel("Telefon :");
		lblTelefonFilijale.setFont(new Font("Arial", Font.BOLD, 14));
		lblTelefonFilijale.setBounds(10, 140, 150, 20);
		panelPodaciOFilijali.add(lblTelefonFilijale);

		JLabel lblE_MailFilijale = new JLabel("E-mail :");
		lblE_MailFilijale.setFont(new Font("Arial", Font.BOLD, 14));
		lblE_MailFilijale.setBounds(10, 180, 150, 20);
		panelPodaciOFilijali.add(lblE_MailFilijale);

		textNazivFilijale = new JTextField();
		textNazivFilijale.setFont(new Font("Arial", Font.PLAIN, 13));
		textNazivFilijale.setColumns(10);
		textNazivFilijale.setBounds(170, 20, 220, 20);
		panelPodaciOFilijali.add(textNazivFilijale);

		textAdresaFilijale = new JTextField();
		textAdresaFilijale.setFont(new Font("Arial", Font.PLAIN, 13));
		textAdresaFilijale.setColumns(10);
		textAdresaFilijale.setBounds(170, 60, 220, 20);
		panelPodaciOFilijali.add(textAdresaFilijale);

		textGradOpstinaFilijale = new JTextField();
		textGradOpstinaFilijale.setFont(new Font("Arial", Font.PLAIN, 13));
		textGradOpstinaFilijale.setColumns(10);
		textGradOpstinaFilijale.setBounds(170, 100, 220, 20);
		panelPodaciOFilijali.add(textGradOpstinaFilijale);

		textE_MailFilijale = new JTextField();
		textE_MailFilijale.setFont(new Font("Arial", Font.PLAIN, 13));
		textE_MailFilijale.setColumns(10);
		textE_MailFilijale.setBounds(170, 180, 220, 20);
		panelPodaciOFilijali.add(textE_MailFilijale);

		textTelefonFilijale = new JTextField();
		textTelefonFilijale.setFont(new Font("Arial", Font.PLAIN, 13));
		textTelefonFilijale.setColumns(10);
		textTelefonFilijale.setBounds(170, 140, 220, 20);
		panelPodaciOFilijali.add(textTelefonFilijale);

		panelPoslovniPodaciFilijale = new JPanel();
		panelPoslovniPodaciFilijale.setLayout(null);
		panelPoslovniPodaciFilijale.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"),
				"Poslovni podaci filijale", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelPoslovniPodaciFilijale.setBounds(430, 10, 400, 220);
		contentPaneFilijala.add(panelPoslovniPodaciFilijale);

		lblPibFilijale = new JLabel("PIB :");
		lblPibFilijale.setFont(new Font("Arial", Font.BOLD, 14));
		lblPibFilijale.setBounds(10, 20, 100, 20);
		panelPoslovniPodaciFilijale.add(lblPibFilijale);

		textPibFilijale = new JTextField();
		textPibFilijale.addKeyListener(new KeyAdapter() {
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
		textPibFilijale.setFont(new Font("Arial", Font.PLAIN, 13));
		textPibFilijale.setColumns(10);
		textPibFilijale.setBounds(140, 20, 250, 20);
		panelPoslovniPodaciFilijale.add(textPibFilijale);

		lblTekuciRacunFilijale = new JLabel("Tekuci ra\u010Dun :");
		lblTekuciRacunFilijale.setFont(new Font("Arial", Font.BOLD, 14));
		lblTekuciRacunFilijale.setBounds(10, 60, 120, 20);
		panelPoslovniPodaciFilijale.add(lblTekuciRacunFilijale);

		textTekuciRacunFilijale = new JTextField();
		textTekuciRacunFilijale.setFont(new Font("Arial", Font.PLAIN, 13));
		textTekuciRacunFilijale.setColumns(10);
		textTekuciRacunFilijale.setBounds(140, 60, 250, 20);
		panelPoslovniPodaciFilijale.add(textTekuciRacunFilijale);

		lblIDFilijale = new JLabel("ID filijale :");
		lblIDFilijale.setFont(new Font("Arial", Font.BOLD, 14));
		lblIDFilijale.setBounds(10, 140, 100, 20);
		panelPoslovniPodaciFilijale.add(lblIDFilijale);

		textIDFilijale = new JTextField();
		textIDFilijale.setFont(new Font("Arial", Font.PLAIN, 13));
		textIDFilijale.setColumns(10);
		textIDFilijale.setBounds(140, 140, 50, 20);
		panelPoslovniPodaciFilijale.add(textIDFilijale);

		 rdbtnAktivna = new JRadioButton("Aktivna");
		 rdbtnAktivna.setFont(new Font("Arial", Font.BOLD, 14));
		buttonGroupFilijala.add(rdbtnAktivna);
		rdbtnAktivna.setBounds(140, 100, 100, 20);
		panelPoslovniPodaciFilijale.add(rdbtnAktivna);

		 rdbtnNeaktivna = new JRadioButton("Neaktivna");
		 rdbtnNeaktivna.setFont(new Font("Arial", Font.BOLD, 14));
		buttonGroupFilijala.add(rdbtnNeaktivna);
		rdbtnNeaktivna.setBounds(290, 100, 100, 20);
		panelPoslovniPodaciFilijale.add(rdbtnNeaktivna);

		ButtonGroup status = new ButtonGroup();
		status.add(rdbtnAktivna);
		status.add(rdbtnNeaktivna);
		
		JLabel lblNewLabel = new JLabel("Status :");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 100, 120, 20);
		panelPoslovniPodaciFilijale.add(lblNewLabel);

		btnDodajFilijalu = new JButton("Dodaj filijalu");
		btnDodajFilijalu.setFont(new Font("Arial", Font.BOLD, 14));
		btnDodajFilijalu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					String naziv = textNazivFilijale.getText();
					String adresa = textAdresaFilijale.getText();
					String grad = textGradOpstinaFilijale.getText();
					String tel = textTelefonFilijale.getText();
					String email = textE_MailFilijale.getText();
					int pib = Integer.parseInt(textPibFilijale.getText());
					String tek_racun = textTekuciRacunFilijale.getText();
					String status = "";
					if (rdbtnAktivna.isSelected()) {
						status = "Aktivna";
					} else if (rdbtnNeaktivna.isSelected()) {
						status = "Neaktivna";
					}					

					Filijala f = new Filijala(naziv, adresa, grad, tel, email, pib, tek_racun, status);
					
					if(textPibFilijale.getText().toString().length() != 8) {
						throw new ArithmeticException();
					}

					Kontroler.getInstance().insertFilijala(f);

					JOptionPane.showMessageDialog(null, "Uspesno ste uneli novu filijalu!");
					
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(btnDodajFilijalu, "Sva polja moraju biti popunjena!");
				}	catch(ArithmeticException e){
					JOptionPane.showMessageDialog(btnDodajFilijalu, "Uneli ste pogresan broj cifara! (PIB = 8 cifara)");
					textPibFilijale.setText("");				
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		btnDodajFilijalu.setBounds(430, 250, 180, 25);
		contentPaneFilijala.add(btnDodajFilijalu);

		btnObrisiFilijalu = new JButton("Obri\u0161i filijalu");
		btnObrisiFilijalu.setFont(new Font("Arial", Font.BOLD, 14));
		btnObrisiFilijalu.setBounds(650, 250, 180, 25);
		contentPaneFilijala.add(btnObrisiFilijalu);

		btnAzurirajFilijalu = new JButton("A\u017Euriraj");
		btnAzurirajFilijalu.setFont(new Font("Arial", Font.BOLD, 14));
		btnAzurirajFilijalu.setBounds(430, 300, 180, 25);
		contentPaneFilijala.add(btnAzurirajFilijalu);

		btnPonistiAkcijuFilijala = new JButton("Poni\u0161ti akciju");
		btnPonistiAkcijuFilijala.setFont(new Font("Arial", Font.BOLD, 14));
		btnPonistiAkcijuFilijala.setBounds(650, 300, 180, 25);
		contentPaneFilijala.add(btnPonistiAkcijuFilijala);
	}
}
