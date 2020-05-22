package jframePregled;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Font;

public class JFramePregledGrupeArtikala extends JFrame {

	private JPanel contentPane;
	private JTable tablePregledGrupeArtikala;
	private JButton btnIzlazPregledGrupeArtikala;
	

	public JTable getTablePregledGrupeArtikala() {
		return tablePregledGrupeArtikala;
	}

	public JButton getBtnIzlazPregledGrupeArtikala() {
		return btnIzlazPregledGrupeArtikala;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFramePregledGrupeArtikala frame = new JFramePregledGrupeArtikala();
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
	public JFramePregledGrupeArtikala() {
		setTitle("PREGLED GRUPE ARTIKALA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 642, 342);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPanePregledGrupeArtikala = new JScrollPane();
		scrollPanePregledGrupeArtikala.setBounds(10, 30, 600, 200);
		contentPane.add(scrollPanePregledGrupeArtikala);
		
		tablePregledGrupeArtikala = new JTable();
		scrollPanePregledGrupeArtikala.setViewportView(tablePregledGrupeArtikala);
		
		btnIzlazPregledGrupeArtikala = new JButton("Izlaz");
		btnIzlazPregledGrupeArtikala.setFont(new Font("Arial", Font.BOLD, 14));
		btnIzlazPregledGrupeArtikala.setBounds(460, 260, 150, 25);
		contentPane.add(btnIzlazPregledGrupeArtikala);
	}
}
