package jframe;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;

public class JFramePromenaLozinke extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldUsername;
	private JTextField textFieldPassword;
	private JTextField textFieldNewPassword;
	private JTextField textFieldConfirmPassword;
	private JButton btnUReduPromenaLozinke;	
	private JButton btnChangePassword;	
	

	public JButton getBtnChangePassword() {
		return btnChangePassword;
	}

	public JButton getBtnUReduPromenaLozinke() {
		return btnUReduPromenaLozinke;
	}

	public void setBtnUReduPromenaLozinke(JButton btnUReduPromenaLozinke) {
		this.btnUReduPromenaLozinke = btnUReduPromenaLozinke;
	}

	public JTextField getTextFieldUsername() {
		return textFieldUsername;
	}

	public void setTextFieldUsername(JTextField textFieldUsername) {
		this.textFieldUsername = textFieldUsername;
	}

	public JTextField getTextFieldPassword() {
		return textFieldPassword;
	}

	public void setTextFieldPassword(JTextField textFieldPassword) {
		this.textFieldPassword = textFieldPassword;
	}

	public JTextField getTextFieldNewPassword() {
		return textFieldNewPassword;
	}

	public void setTextFieldNewPassword(JTextField textFieldNewPassword) {
		this.textFieldNewPassword = textFieldNewPassword;
	}

	public JTextField getTextFieldConfirmPassword() {
		return textFieldConfirmPassword;
	}

	public void setTextFieldConfirmPassword(JTextField textFieldConfirmPassword) {
		this.textFieldConfirmPassword = textFieldConfirmPassword;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFramePromenaLozinke frame = new JFramePromenaLozinke();
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
	public JFramePromenaLozinke() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 622, 453);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPromenaLozinke = new JLabel("PROMENA LOZINKE");
		lblPromenaLozinke.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblPromenaLozinke.setBounds(208, 36, 226, 22);
		contentPane.add(lblPromenaLozinke);
		
		JPanel panelKorisnik = new JPanel();
		panelKorisnik.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Korisnik", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelKorisnik.setBounds(40, 70, 542, 100);
		contentPane.add(panelKorisnik);
		panelKorisnik.setLayout(null);
		
		JLabel lblUsername = new JLabel("Korisnicko ime :");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUsername.setBounds(10, 30, 170, 20);
		panelKorisnik.add(lblUsername);
		
		textFieldUsername = new JTextField();
		textFieldUsername.setBounds(200, 30, 250, 20);
		panelKorisnik.add(textFieldUsername);
		textFieldUsername.setColumns(10);
		
		JLabel lblPassword = new JLabel("Lozinka :");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPassword.setBounds(10, 70, 170, 20);
		panelKorisnik.add(lblPassword);
		
		textFieldPassword = new JTextField();
		textFieldPassword.setBounds(200, 70, 250, 20);
		panelKorisnik.add(textFieldPassword);
		textFieldPassword.setColumns(10);
		
		JPanel panelChangePassword = new JPanel();
		panelChangePassword.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Promena lozinke", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelChangePassword.setBounds(40, 245, 542, 100);
		contentPane.add(panelChangePassword);
		panelChangePassword.setLayout(null);
		
		JLabel lblNewPassword = new JLabel("Nova lozinka :");
		lblNewPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewPassword.setBounds(10, 30, 170, 20);
		panelChangePassword.add(lblNewPassword);
		
		JLabel lblConfirmPassword = new JLabel("Potvrdi novu lozinku :");
		lblConfirmPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblConfirmPassword.setBounds(10, 70, 170, 20);
		panelChangePassword.add(lblConfirmPassword);
		
		textFieldNewPassword = new JTextField();
		textFieldNewPassword.setBounds(200, 30, 250, 20);
		panelChangePassword.add(textFieldNewPassword);
		textFieldNewPassword.setColumns(10);
		
		textFieldConfirmPassword = new JTextField();
		textFieldConfirmPassword.setBounds(200, 70, 250, 20);
		panelChangePassword.add(textFieldConfirmPassword);
		textFieldConfirmPassword.setColumns(10);
		
		btnChangePassword = new JButton("Sacuvaj novu lozinku");
		btnChangePassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnChangePassword.setBounds(239, 368, 207, 23);
		contentPane.add(btnChangePassword);
		
		btnUReduPromenaLozinke = new JButton("U redu");
		btnUReduPromenaLozinke.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnUReduPromenaLozinke.setBounds(239, 198, 89, 23);
		contentPane.add(btnUReduPromenaLozinke);
	}
}
