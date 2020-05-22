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

public class JFramePregledMagacina extends JFrame {

	private JPanel contentPane;
	private JTable tablePregledMagacina;
	private JButton btnIzlazPregledMagacina;
	

	public JTable getTablePregledMagacina() {
		return tablePregledMagacina;
	}

	public JButton getBtnIzlazPregledMagacina() {
		return btnIzlazPregledMagacina;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFramePregledMagacina frame = new JFramePregledMagacina();
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
	public JFramePregledMagacina() {
		setTitle("PREGLED MAGACINA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 30, 960, 250);
		contentPane.add(scrollPane);
		
		tablePregledMagacina = new JTable();
		scrollPane.setViewportView(tablePregledMagacina);
		
		btnIzlazPregledMagacina = new JButton("Izlaz");
		btnIzlazPregledMagacina.setFont(new Font("Arial", Font.BOLD, 14));
		btnIzlazPregledMagacina.setBounds(820, 320, 150, 25);
		contentPane.add(btnIzlazPregledMagacina);
	}

}
