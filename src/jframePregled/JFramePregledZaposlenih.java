package jframePregled;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import table.JTableModelRacunOtpremnica;
import table.JTabelModelZaposleni;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class JFramePregledZaposlenih extends JFrame {

	private JPanel contentPane;
	private JTable tablePregledTrenutnoZaposlenih;
	private JButton btnIzlazTrenutnoZaposleni;
	

	public JTable getTablePregledTrenutnoZaposlenih() {
		return tablePregledTrenutnoZaposlenih;
	}

	public JButton getBtnIzlazTrenutnoZaposleni() {
		return btnIzlazTrenutnoZaposleni;
	}

	public void setBtnIzlazTrenutnoZaposleni(JButton btnIzlazTrenutnoZaposleni) {
		this.btnIzlazTrenutnoZaposleni = btnIzlazTrenutnoZaposleni;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFramePregledZaposlenih frame = new JFramePregledZaposlenih();
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
	public JFramePregledZaposlenih() {
		setTitle("PREGLED TRENUTNO ZAPOSLENIH");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1300, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPanePregledTrenutnoZaposlenih = new JScrollPane();
		scrollPanePregledTrenutnoZaposlenih.setBounds(10, 30, 1260, 230);
		contentPane.add(scrollPanePregledTrenutnoZaposlenih);
		
		tablePregledTrenutnoZaposlenih = new JTable();
		scrollPanePregledTrenutnoZaposlenih.setViewportView(tablePregledTrenutnoZaposlenih);
		
		btnIzlazTrenutnoZaposleni = new JButton("Izlaz");
		btnIzlazTrenutnoZaposleni.setFont(new Font("Arial", Font.BOLD, 14));
		btnIzlazTrenutnoZaposleni.setBounds(1120, 310, 150, 25);
		contentPane.add(btnIzlazTrenutnoZaposleni);
	}
}
