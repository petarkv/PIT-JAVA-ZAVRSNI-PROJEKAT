package jframePregled;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;

public class JFramePregledFilijale extends JFrame {

	private JPanel contentPane;
	private JTable tablePregleFilijale;
	private JButton btnIzlazPregledFilijale;
	

	public JTable getTablePregleFilijale() {
		// TODO Auto-generated method stub
		return tablePregleFilijale;
	}
	
	public JButton getBtnIzlazPregledFilijale() {
		return btnIzlazPregledFilijale;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFramePregledFilijale frame = new JFramePregledFilijale();
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
	public JFramePregledFilijale() {
		setTitle("PREGLED FILIJALA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 30, 960, 250);
		contentPane.add(scrollPane);
		
		tablePregleFilijale = new JTable();
		scrollPane.setViewportView(tablePregleFilijale);
		
		btnIzlazPregledFilijale = new JButton("Izlaz");
		btnIzlazPregledFilijale.setFont(new Font("Arial", Font.BOLD, 14));
		btnIzlazPregledFilijale.setBounds(820, 320, 150, 25);
		contentPane.add(btnIzlazPregledFilijale);
	}

}
