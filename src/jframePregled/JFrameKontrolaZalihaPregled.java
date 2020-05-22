package jframePregled;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;

public class JFrameKontrolaZalihaPregled extends JFrame {

	private JPanel contentPane;
	private JTable tablePregledZaliha;
	private JButton btnNoviPregledKontroleZaliha;
	private JButton btnIzlazKontrolaZalihaPregled;

	public JButton getBtnNoviPregledKontroleZaliha() {
		return btnNoviPregledKontroleZaliha;
	}



	public JButton getBtnIzlazKontrolaZalihaPregled() {
		return btnIzlazKontrolaZalihaPregled;
	}



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameKontrolaZalihaPregled frame = new JFrameKontrolaZalihaPregled();
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
	public JFrameKontrolaZalihaPregled() {
		setTitle("KONTROLA ZALIHA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 595, 369);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPanePregledZaliha = new JScrollPane();
		scrollPanePregledZaliha.setBounds(10, 11, 559, 243);
		contentPane.add(scrollPanePregledZaliha);
		
		tablePregledZaliha = new JTable();
		scrollPanePregledZaliha.setViewportView(tablePregledZaliha);
		
		btnNoviPregledKontroleZaliha = new JButton("Novi pregled");
		btnNoviPregledKontroleZaliha.setBounds(10, 285, 126, 23);
		contentPane.add(btnNoviPregledKontroleZaliha);
		
		btnIzlazKontrolaZalihaPregled = new JButton("Izlaz");
		btnIzlazKontrolaZalihaPregled.setBounds(460, 285, 109, 23);
		contentPane.add(btnIzlazKontrolaZalihaPregled);
	}
}
