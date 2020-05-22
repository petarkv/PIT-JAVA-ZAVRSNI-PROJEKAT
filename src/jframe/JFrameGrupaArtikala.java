package jframe;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import kontroler.Kontroler;
import model.GrupaArtikala;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class JFrameGrupaArtikala extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldGrupaArtikala;
	private JButton btnDodajGrupuArtikala;
	private JTextField textFieldIdGrupeArtikala;	
	private JButton btnObrisiGrupuArtikala;
	private JButton btnPonistiAkcijuDodajGrupuArtikala;
	private JButton btnAzurirajGrupuArtikala;	
	private JLabel lblIdGrupeArtikala;
	
	public JButton getBtnAzurirajGrupuArtikala() {
		return btnAzurirajGrupuArtikala;
	}

	public JButton getBtnObrisiGrupuArtikala() {
		return btnObrisiGrupuArtikala;
	}

	public void setBtnObrisiGrupuArtikala(JButton btnObrisiGrupuArtikala) {
		this.btnObrisiGrupuArtikala = btnObrisiGrupuArtikala;
	}

	public JButton getBtnPonistiAkcijuDodajGrupuArtikala() {
		return btnPonistiAkcijuDodajGrupuArtikala;
	}

	public void setBtnPonistiAkcijuDodajGrupuArtikala(JButton btnPonistiAkcijuDodajGrupuArtikala) {
		this.btnPonistiAkcijuDodajGrupuArtikala = btnPonistiAkcijuDodajGrupuArtikala;
	}

	public JTextField getTextFieldGrupaArtikala() {
		return textFieldGrupaArtikala;
	}

	public void setTextFieldGrupaArtikala(JTextField textFieldGrupaArtikala) {
		this.textFieldGrupaArtikala = textFieldGrupaArtikala;
	}

	public JTextField getTextFieldIdGrupeArtikala() {
		return textFieldIdGrupeArtikala;
	}

	public void setTextFieldIdGrupeArtikala(JTextField textFieldIdGrupeArtikala) {
		this.textFieldIdGrupeArtikala = textFieldIdGrupeArtikala;
	}

	public JButton getBtnDodajGrupuArtikala() {
		return btnDodajGrupuArtikala;
	}

	public void setBtnDodajGrupuArtikala(JButton btnDodajGrupuArtikala) {
		this.btnDodajGrupuArtikala = btnDodajGrupuArtikala;
	}	

	public JLabel getLblIdGrupeArtikala() {
		return lblIdGrupeArtikala;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameGrupaArtikala frame = new JFrameGrupaArtikala();
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
	public JFrameGrupaArtikala() {
		setTitle("GRUPA ARTIKALA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUnesiteGrupuArtikala = new JLabel("Unesite grupu artikala :");
		lblUnesiteGrupuArtikala.setFont(new Font("Arial", Font.BOLD, 14));
		lblUnesiteGrupuArtikala.setBounds(30, 20, 270, 20);
		contentPane.add(lblUnesiteGrupuArtikala);
		
		textFieldGrupaArtikala = new JTextField();
		textFieldGrupaArtikala.setFont(new Font("Arial", Font.PLAIN, 13));
		textFieldGrupaArtikala.setBounds(30, 50, 260, 20);
		contentPane.add(textFieldGrupaArtikala);
		textFieldGrupaArtikala.setColumns(10);
		
		btnDodajGrupuArtikala = new JButton("Dodaj grupu artikala");
		btnDodajGrupuArtikala.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				try {
				String naziv = textFieldGrupaArtikala.getText();
				
				GrupaArtikala ga = new GrupaArtikala(0, naziv);	
				
				if(textFieldGrupaArtikala.getText().equals("")) {
					throw new NumberFormatException();					
				}
				
					Kontroler.getInstance().insertGrupaArtikala(ga);
					JOptionPane.showMessageDialog(null, "Uspesno ste uneli grupu artikala!");
					textFieldGrupaArtikala.setText("");
				
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(btnDodajGrupuArtikala, "Sva polja moraju biti popunjena!");
				
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnDodajGrupuArtikala.setFont(new Font("Arial", Font.BOLD, 14));
		btnDodajGrupuArtikala.setBounds(30, 180, 186, 25);
		contentPane.add(btnDodajGrupuArtikala);
		
		btnObrisiGrupuArtikala = new JButton("Obri\u0161i grupu artikala");
		btnObrisiGrupuArtikala.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int rbga = Integer.parseInt(textFieldIdGrupeArtikala.getText().trim());
				
				try {
					Kontroler.getInstance().deleteGrupaArtikala(rbga);
					JOptionPane.showMessageDialog(null, "Uspesno ste obrisali grupu artikala!");
					
					textFieldGrupaArtikala.setText("");
					textFieldIdGrupeArtikala.setText("");
					
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnObrisiGrupuArtikala.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnObrisiGrupuArtikala.setBounds(280, 180, 180, 25);
		contentPane.add(btnObrisiGrupuArtikala);
		
		btnAzurirajGrupuArtikala = new JButton("A\u017Euriraj");
		btnAzurirajGrupuArtikala.setFont(new Font("Arial", Font.BOLD, 14));
		btnAzurirajGrupuArtikala.setBounds(30, 227, 180, 25);
		contentPane.add(btnAzurirajGrupuArtikala);
		
		btnPonistiAkcijuDodajGrupuArtikala = new JButton("Poni\u0161ti akciju");
		btnPonistiAkcijuDodajGrupuArtikala.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnPonistiAkcijuDodajGrupuArtikala.setBounds(280, 229, 180, 25);
		contentPane.add(btnPonistiAkcijuDodajGrupuArtikala);
		
		lblIdGrupeArtikala = new JLabel("ID grupe artikala:");
		lblIdGrupeArtikala.setFont(new Font("Arial", Font.BOLD, 14));
		lblIdGrupeArtikala.setBounds(30, 90, 144, 17);
		contentPane.add(lblIdGrupeArtikala);
		
		textFieldIdGrupeArtikala = new JTextField();
		textFieldIdGrupeArtikala.setFont(new Font("Arial", Font.PLAIN, 13));
		textFieldIdGrupeArtikala.setBounds(220, 90, 70, 20);
		contentPane.add(textFieldIdGrupeArtikala);
		textFieldIdGrupeArtikala.setColumns(10);
	}
}
