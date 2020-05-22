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

public class JFramePregledKupca extends JFrame {

	private JPanel contentPane;
	private JTable tablePregleKupaca;
	private JButton btnIzlazPregledKupaca;
	
	
	public JButton getBtnIzlazPregledKupaca() {
		return btnIzlazPregledKupaca;
	}

	public JTable getTablePregleKupaca() {
		return tablePregleKupaca;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFramePregledKupca frame = new JFramePregledKupca();
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
	public JFramePregledKupca() {
		setTitle("PREGLED KUPACA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 30, 1160, 250);
		contentPane.add(scrollPane);
		
		tablePregleKupaca = new JTable();
		scrollPane.setViewportView(tablePregleKupaca);
		
		btnIzlazPregledKupaca = new JButton("Izlaz");
		btnIzlazPregledKupaca.setFont(new Font("Arial", Font.BOLD, 14));
		btnIzlazPregledKupaca.setBounds(1020, 320, 150, 25);
		contentPane.add(btnIzlazPregledKupaca);
	}
}
