package jframePregled;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JFramePregledTrenutnoPrijavljeniNaMrezi extends JFrame {

	private JPanel contentPane;
	private JTable tableTrenutnoNaMrezi;
	private JButton btnIzlazTrenutnoNaMrezi;

	public JButton getBtnIzlazTrenutnoNaMrezi() {
		return btnIzlazTrenutnoNaMrezi;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {				
					JFramePregledTrenutnoPrijavljeniNaMrezi frame = new JFramePregledTrenutnoPrijavljeniNaMrezi();
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
	public JFramePregledTrenutnoPrijavljeniNaMrezi() {
		setTitle("TRENUTNO PRIJAVLJENI NA MREZI");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 623, 336);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPaneTrenutnoNaMrezi = new JScrollPane();
		scrollPaneTrenutnoNaMrezi.setBounds(10, 11, 587, 182);
		contentPane.add(scrollPaneTrenutnoNaMrezi);
		
		tableTrenutnoNaMrezi = new JTable();
		scrollPaneTrenutnoNaMrezi.setViewportView(tableTrenutnoNaMrezi);
		
		btnIzlazTrenutnoNaMrezi = new JButton("Izlaz");
		
		btnIzlazTrenutnoNaMrezi.setBounds(479, 240, 118, 23);
		contentPane.add(btnIzlazTrenutnoNaMrezi);
	}

}
