package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import groovy.swing.binding.JTableProperties;
import jframe.JFrameArtikal;
import jframe.JFrameFilijala;
import jframe.JFrameGrupaArtikala;
import jframe.JFrameKontrolaZaliha;
import jframe.JFrameKupac;
import jframe.JFrameMagacin;
import jframe.JFramePromenaLozinke;
import jframe.JFrameRacun_otpreminica;
import jframe.JFrameZaposleni;
import jframeAzuriraj.JFrameAzurirajArtikal;
import jframeAzuriraj.JFrameAzurirajFilijalu;
import jframeAzuriraj.JFrameAzurirajGrupuArtikala;
import jframeAzuriraj.JFrameAzurirajKupca;
import jframeAzuriraj.JFrameAzurirajMagacin;
import jframeAzuriraj.JFrameAzurirajZaposlenog;
import jframeIzvestaji.JFrameCenaArtikla;
import jframeIzvestaji.JFrameIzvestajProdajeFilijala;
import jframeIzvestaji.JFrameIzvestajProdajeKupac;
import jframeIzvestaji.JFrameIzvestajProdajeRacun;
import jframeIzvestaji.JFrameIzvestajProdajeZaposleni;
import jframeObrisi.JFrameObrisiArtikal;
import jframeObrisi.JFrameObrisiFilijalu;
import jframeObrisi.JFrameObrisiGrupuArtikala;
import jframeObrisi.JFrameObrisiKupca;
import jframeObrisi.JFrameObrisiMagacin;
import jframeObrisi.JFrameObrisiZaposlenog;
import jframePregled.JFrameKontrolaZalihaPregled;
import jframePregled.JFramePregleRacuna;
import jframePregled.JFramePregledArtikala;
import jframePregled.JFramePregledFilijale;
import jframePregled.JFramePregledGrupeArtikala;
import jframePregled.JFramePregledKupca;
import jframePregled.JFramePregledMagacina;
import jframePregled.JFramePregledRacunaPoStatusu;
import jframePregled.JFramePregledZaposlenih;
import jframePregled.JFrameStavkeRacunaPregled;
import kontroler.Kontroler;
import model.Artikli;
import model.GrupaArtikala;
import model.Izvestaj;
import model.Kupac;
import model.RacunOtpremnica;
import model.StavkeRacunaOtpremnice;
import model.Zaposleni;
import table.JTableModelRacunOtpremnica;
import table.JTableModelStavkeRacunaOtpremnice;
import table.JTabelModelZaposleni;
import table.JTableModelArtikal;
import table.JTableModelFilijala;
import table.JTableModelGrupeArtikala;
import table.JTableModelKupac;
import table.JTableModelMagacin;
import table.JTableModelProdajaPoFilijali;
import table.JTableModelProdajaPoKupacu;
import table.JTableModelProdajaPoZaposlenom;
import table.JTableModelProdajnaCenaArtikla;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.UIManager;
import java.awt.Color;

public class GlavniProzorVeleprodaja {

	private JFrame frmVeleprodaja;
	private JTextField textFieldUsername;
	private JPanel panelAdmin;
	private JPanel panelUserKomercijalista;
	private JPanel panelUserMagacioner;
	public Zaposleni logedIn = null;
	private JPasswordField passwordFieldPassword;	
	private int generatedID;
	private JMenu mnMaticniPodaciAdmin;
	private JMenu mnIzvestajAdmin;
	private JMenu mnSistemAdmin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GlavniProzorVeleprodaja window = new GlavniProzorVeleprodaja();
					window.frmVeleprodaja.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GlavniProzorVeleprodaja() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmVeleprodaja = new JFrame();
		frmVeleprodaja.setFont(new Font("Arial", Font.BOLD, 14));
		frmVeleprodaja.setTitle("VELEPRODAJA");
		frmVeleprodaja.setBounds(100, 100, 700, 500);
		frmVeleprodaja.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmVeleprodaja.getContentPane().setLayout(new CardLayout(0, 0));

		JPanel  panelLogin = new JPanel();
		frmVeleprodaja.getContentPane().add(panelLogin, "name_268101549302672");
		panelLogin.setLayout(null);

		JPanel panelLogovanja = new JPanel();
		panelLogovanja.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Login", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelLogovanja.setBounds(150, 100, 400, 200);
		panelLogin.add(panelLogovanja);
		panelLogovanja.setLayout(null);

		JLabel lblUsername = new JLabel("Username :");
		lblUsername.setFont(new Font("Arial", Font.BOLD, 14));
		lblUsername.setBounds(26, 48, 100, 20);
		panelLogovanja.add(lblUsername);

		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setFont(new Font("Arial", Font.BOLD, 14));
		lblPassword.setBounds(26, 87, 100, 20);
		panelLogovanja.add(lblPassword);

		textFieldUsername = new JTextField();
		textFieldUsername.setFont(new Font("Arial", Font.PLAIN, 13));
		textFieldUsername.setBounds(150, 47, 220, 20);
		panelLogovanja.add(textFieldUsername);
		textFieldUsername.setColumns(10);

		JButton btnLogin = new JButton("Login");        
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String username = textFieldUsername.getText();
				char[] pass = passwordFieldPassword.getPassword();
				String password = new String(pass);
				
				try {
					ArrayList<Zaposleni> zaposleni = Kontroler.getInstance().getZaposleni();
					for (Zaposleni z : zaposleni) {						
						
						if (z.getUsernameZaposlenog().equals(username) && z.getPasswordZaposlenog().equals(password)) {
							if (z.getTipZaposlenja().equals("Admin")) {
								logedIn = z;

								panelAdmin.setVisible(true);
								panelLogin.setVisible(false);									

							} else if (z.getTipZaposlenja().equals("Menadžer")) {
								
								logedIn = z;

								panelAdmin.setVisible(true);
								panelLogin.setVisible(false);
								mnMaticniPodaciAdmin.setEnabled(false);
								mnSistemAdmin.setEnabled(false);
								
							} else if (z.getTipZaposlenja().equals("Komercijalista")) {
								System.out.println("Komercijalista");
								logedIn = z;

								panelAdmin.setVisible(true);
								panelLogin.setVisible(false);
								mnMaticniPodaciAdmin.setEnabled(false);
								mnIzvestajAdmin.setEnabled(false);
								mnSistemAdmin.setEnabled(false);
								
							} else {
								JOptionPane.showMessageDialog(panelLogin, "Pogresan tip usera");
							}
							break;
						}
					}
					if (logedIn == null || username == null) {
						JOptionPane.showMessageDialog(panelLogin, "Pogresan username / password");
					}
				} catch (HeadlessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}				
				
				textFieldUsername.grabFocus();
				textFieldUsername.selectAll();
				passwordFieldPassword.setText("");				
			
			}
			});
		btnLogin.setFont(new Font("Arial", Font.BOLD, 14));
		btnLogin.setBounds(150, 150, 100, 25);
		panelLogovanja.add(btnLogin);		
		
		frmVeleprodaja.getRootPane().setDefaultButton(btnLogin);//default dugme
		
		passwordFieldPassword = new JPasswordField();
		passwordFieldPassword.setFont(new Font("Arial", Font.PLAIN, 13));
		passwordFieldPassword.setBounds(150, 86, 220, 20);
		panelLogovanja.add(passwordFieldPassword);

		panelAdmin = new JPanel();
		frmVeleprodaja.getContentPane().add(panelAdmin, "name_268160544207166");
		panelAdmin.setLayout(null);

		JMenuBar menuBarAdmin = new JMenuBar();
		menuBarAdmin.setBounds(0, 0, 684, 27);
		panelAdmin.add(menuBarAdmin);

		JMenu mnPrijavaAdmin = new JMenu("Prijava");
		mnPrijavaAdmin.setFont(new Font("Arial", Font.BOLD, 14));
		menuBarAdmin.add(mnPrijavaAdmin);

		JMenuItem mntmOdjavaAdmin = new JMenuItem("Odjava");
		mntmOdjavaAdmin.setFont(new Font("Arial", Font.PLAIN, 13));
		mntmOdjavaAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelAdmin.setVisible(false);
				panelLogin.setVisible(true);
				textFieldUsername.setText("");
				textFieldUsername.grabFocus();
			}
		});
		
		mnPrijavaAdmin.add(mntmOdjavaAdmin);
		
		mntmOdjavaAdmin.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, InputEvent.CTRL_DOWN_MASK));
		
		JMenuItem mnTrenutnoPrijavljeniAdmin = new JMenuItem("Trenutno prijavljeni");
		mnTrenutnoPrijavljeniAdmin.setFont(new Font("Arial", Font.PLAIN, 13));
		mnPrijavaAdmin.add(mnTrenutnoPrijavljeniAdmin);
		mnTrenutnoPrijavljeniAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {	
				int idzap = logedIn.getIdZaposlenog();
				JFrameZaposleni jfzo = new JFrameZaposleni();
				jfzo.getBtnObrisiZaposlenog().setVisible(false);
				jfzo.getBtnDodajZaposlenog().setVisible(false);				
				jfzo.getBtnAzurirajZaposlenog().setVisible(false);
				jfzo.getBtnPonistiAkciju().setVisible(true);
				
				jfzo.setVisible(true);				
				
			    try {
					Zaposleni z = Kontroler.getInstance().getDetaljiZaposleni(idzap);
					
					jfzo.getTextIDZaposlenog().setText(Integer.toString(z.getIdZaposlenog()));
					jfzo.getTextIme().setText(z.getImeZaposlenog());
					jfzo.getTextPrezime().setText(z.getPrezimeZaposlenog());
					jfzo.getTextAdresa().setText(z.getAdresaZaposlenog());
					jfzo.getTextJMBG().setText(z.getJmbgZaposlenog());
					jfzo.getTextGrad_Ostina().setText(z.getGradOpstinaZaposlenog());
					jfzo.getTextTelefon().setText(z.getTelefonZaposlenog());
					jfzo.getTextEMail().setText(z.getEmailZaposlenog());					
					
					jfzo.getTextPlata().setText("************");
					jfzo.getComboBoxTipZaposlenja().setSelectedItem(z.getTipZaposlenja());
					
					jfzo.getComboBoxStrucnaSprema().setSelectedItem(z.getStrucnaSpremaZaposlenog());
					jfzo.getDateChooserDatumZaposlenja().setDate(z.getDatumPocetkaZaposlenja());
					jfzo.getDateChooserPrestankaZaposlenja().setDate(z.getDatumZavrsetkaZaposlenja());
					
					jfzo.getTextUsername().setText(z.getUsernameZaposlenog());
					jfzo.getTextPassword().setText("**************");	
					
					
					jfzo.getTextIDZaposlenog().setEditable(false);
					jfzo.getTextIme().setEditable(false);					
					jfzo.getTextPrezime().setEditable(false);					
					jfzo.getTextAdresa().setEditable(false);
					jfzo.getTextJMBG().setEditable(false);
					jfzo.getTextGrad_Ostina().setEditable(false);
					jfzo.getTextTelefon().setEditable(false);
					jfzo.getTextEMail().setEditable(false);					
					jfzo.getTextPlata().setEditable(false);
					jfzo.getComboBoxTipZaposlenja().setEnabled(false);					
					jfzo.getComboBoxStrucnaSprema().setEnabled(false);					
					jfzo.getTextUsername().setEditable(false);
					jfzo.getTextPassword().setEditable(false);
					jfzo.getDateChooserDatumZaposlenja().setEnabled(false);
					jfzo.getDateChooserPrestankaZaposlenja().setEnabled(false);
					jfzo.getComboBoxFilijalaPosla().setEnabled(false);
					
					
				} catch (ClassNotFoundException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
			  
			    jfzo.getBtnPonistiAkciju().addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						jfzo.setVisible(false);
						
					}
				});
			   
				panelAdmin.setVisible(true);
			}
		});


		JMenuItem mntmIzlazAdmin = new JMenuItem("Izlaz");
		mntmIzlazAdmin.setFont(new Font("Arial", Font.PLAIN, 13));
		mntmIzlazAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int r = JOptionPane.showConfirmDialog(null, 
						   "Da li zelite da ugasite program ?",null, JOptionPane.YES_NO_OPTION);
						if(r == JOptionPane.YES_OPTION) {
						    System.exit(0);
						}
			}
		});
		mnPrijavaAdmin.add(mntmIzlazAdmin);

		mntmIzlazAdmin.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, InputEvent.CTRL_DOWN_MASK));

		JMenu mnProdajaAdmin = new JMenu("    Prodaja");
		mnProdajaAdmin.setFont(new Font("Arial", Font.BOLD, 14));
		menuBarAdmin.add(mnProdajaAdmin);

		JMenuItem mntmKreirajRacunOtpremnicuAdmin = new JMenuItem("Kreiraj ra\u010Dun/otpremnicu");
		mntmKreirajRacunOtpremnicuAdmin.setFont(new Font("Arial", Font.PLAIN, 13));
		mntmKreirajRacunOtpremnicuAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrameRacun_otpreminica ro = new JFrameRacun_otpreminica();
				ro.getTextFieldRacunOtpremnicaRacun().setEditable(false);
				ro.getDateChooserNaplateracuna().setEnabled(false);
				ro.getTextFieldNetoRacun().setEditable(false);
				ro.getTextFieldBrutoRacun().setEditable(false);
				ro.getTextFieldPDVRacun().setEditable(false);
				ro.getBtnKreirajRacun().setVisible(false);
				
				
				
				ro.getBtnObrisiRacun().addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						JTableModelRacunOtpremnica model = (JTableModelRacunOtpremnica)
								ro.getTableStavkeRacuna().getModel();
						int selektovanRed = ro.getTableStavkeRacuna().getSelectedRow();
						if (selektovanRed >=0) {
							model.removeRow(selektovanRed);
							JOptionPane.showMessageDialog(null, "Uspešno ste obrisali red!");
						}else{
							JOptionPane.showMessageDialog(null, "Morate selektovati red u tabeli!");
						}
					}
				});
				
				ro.getBtnZapocniProdajuStavkeRacuna().setBounds(1024, 500, 150, 25);
				ro.getBtnZapocniProdajuStavkeRacuna().setEnabled(false);
				ro.getComboBoxKupacRacun().addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						if(ro.getComboBoxKupacRacun().getSelectedItem() != null) {
							ro.getBtnZapocniProdajuStavkeRacuna().setEnabled(true);
						}
						
					}
				});
				ro.getBtnPonistiAkcijuRacunOtpremnica().addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						ro.setVisible(false);	
					}
				});
				
				ro.setVisible(true);
				ro.getBtnZapocniProdajuStavkeRacuna().addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						ro.getBtnPonistiAkcijuRacunOtpremnica().setVisible(false);
						ro.getBtnZapocniProdajuStavkeRacuna().setVisible(false);
						ro.getBtnKreirajRacun().setVisible(true);
						ro.getBtnKreirajRacun().setBounds(1024, 500, 150, 25);
						Kupac k1 =(Kupac) ro.getComboBoxKupacRacun().getSelectedItem();
						int ValutaKupca = k1.getValutaPlacanjaKupca();
						Date d = ro.getDateChooserRacunOtpremnica().getDate();
						Calendar cal = Calendar.getInstance();
						cal.add(Calendar.DAY_OF_MONTH, ValutaKupca);
						Date d1 = cal.getTime();
						ro.getDateChooserNaplateracuna().setDate(d1);
						
						
						try {
							Date datumRacuna = ro.getDateChooserRacunOtpremnica().getDate();
							Date datumNaplateRacuna = ro.getDateChooserNaplateracuna().getDate();
							Kupac k =(Kupac) ro.getComboBoxKupacRacun().getSelectedItem();
							int idkupca = k.getIdKupca();
							int idzaposlenog = logedIn.getIdZaposlenog();
							RacunOtpremnica ro = new RacunOtpremnica(idzaposlenog,idkupca,datumRacuna,datumNaplateRacuna);
							generatedID = Kontroler.getInstance().insertRacunOtpremnicu(ro);
							
							JOptionPane.showMessageDialog(null, "Kreirali ste račun!");
							
						} catch (ClassNotFoundException | SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						JFrameStavkeRacunaPregled fsrp = new JFrameStavkeRacunaPregled();
						fsrp.setVisible(true);
						fsrp.getTextFieldIdRacunStavkeRacuna().setText(Integer.toString(generatedID));
						
						
						fsrp.getBtnSacuvajStavkeRacuna().addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
								int idracuna = Integer.parseInt(fsrp.getTextFieldIdRacunStavkeRacuna().getText());
							try {
								
								Artikli artikal = (Artikli) fsrp.getComboBoxArtikalRacunStavke().getSelectedItem();

								int kolicinaProdaje = Integer.parseInt(fsrp.getTextFieldKolicina().getText().trim());
								
								double rabatProdaje = Double.parseDouble(fsrp.getTextFieldRabat().getText().trim());

								StavkeRacunaOtpremnice sro = new StavkeRacunaOtpremnice(idracuna, artikal,
										kolicinaProdaje, rabatProdaje);
								
								Kontroler.getInstance().insertStavkaRacuna(sro);
								
								postaviModelStavkeProdaje(new ArrayList<>(), fsrp.getTableRacunOtpremnica());
								ArrayList lista;
								try {
									lista = Kontroler.getInstance().getStavkeRacunaOtpremniceIzvestaj(idracuna);
									postaviModelStavkeProdaje(lista, fsrp.getTableRacunOtpremnica());
								} catch (ClassNotFoundException | SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								
								fsrp.getComboBoxGrupaArtikalaRacunStavke().setSelectedItem(null);
								fsrp.getComboBoxArtikalRacunStavke().setSelectedItem(null);
								fsrp.getTextFieldDostupnaKolicina().setText("");
								fsrp.getTextFieldJedinicaMere().setText("");
								fsrp.getTextFieldKolicina().setText("");
								fsrp.getTextFieldRabat().setText("");

							} catch (Exception e) {
								JOptionPane.showMessageDialog(null, "Greska!!! kolicina mora biti broj i artikal u jedno nabavci se ne sme duplirati");
							}
							
					}
							
				});
						fsrp.getBtnPrekidStavkeRacuna().addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent e) {
								int idracuna = Integer.parseInt(fsrp.getTextFieldIdRacunStavkeRacuna().getText());
								fsrp.setVisible(false);
								String s = fsrp.getTextFieldIdRacunStavkeRacuna().getText().trim();
								ro.getTextFieldRacunOtpremnicaRacun().setText(s);
								postaviModelRacunOtpremnica(new ArrayList<>(), ro.getTableStavkeRacuna());
								ArrayList lista;
								try {
									lista = Kontroler.getInstance().getStavkeRacunaOtpremniceIzvestaj(idracuna);
									postaviModelRacunOtpremnica(lista, ro.getTableStavkeRacuna());
								} catch (ClassNotFoundException | SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								double sumN =0;
								for (int i = 0; i < ro.getTableStavkeRacuna().getRowCount(); i++) {
									double iznos = (double) ro.getTableStavkeRacuna().getValueAt(i, 8);
											sumN+=iznos;
											ro.getTextFieldNetoRacun().setText(Double.toString(sumN));
											
								}
								double sumPDV =0;
								for (int i = 0; i < ro.getTableStavkeRacuna().getRowCount(); i++) {
									double iznos = (double) ro.getTableStavkeRacuna().getValueAt(i, 9);
											sumPDV+=iznos;
											ro.getTextFieldPDVRacun().setText(Double.toString(sumPDV));
							}
								double sumB =0;
								for (int i = 0; i < ro.getTableStavkeRacuna().getRowCount(); i++) {
									double iznos = (double) ro.getTableStavkeRacuna().getValueAt(i, 10);
											sumB+=iznos;
											ro.getTextFieldBrutoRacun().setText(Double.toString(sumB));
								}
							}
						});
							ro.getBtnKreirajRacun().addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
								
								try {
									int idracuna = Integer.parseInt(fsrp.getTextFieldIdRacunStavkeRacuna().getText());
									double poreska_osnovica_racuna = Double.parseDouble(ro.getTextFieldNetoRacun().getText());
									double ukupan_iznos_obracunatog_pdv_a_racuna = Double.parseDouble(ro.getTextFieldPDVRacun().getText());
									double ukupna_vrednost_racuna = Double.parseDouble(ro.getTextFieldBrutoRacun().getText());
									Kontroler.getInstance().updateRacun(idracuna, poreska_osnovica_racuna, ukupan_iznos_obracunatog_pdv_a_racuna, ukupna_vrednost_racuna);
									
									
									JOptionPane.showMessageDialog(null, "Račun je uspešno završen");
									
									ro.setVisible(false);									
									
								} catch (Exception e) {
									e.printStackTrace();
									JOptionPane.showMessageDialog(null, "Greska sa bazom");
								} 
							}
						});
						ro.getBtnNovaPoyicijaRacun().addActionListener(new ActionListener() {
								
								@Override
								public void actionPerformed(ActionEvent arg0) {
									fsrp.setVisible(true);
									String s =ro.getTextFieldRacunOtpremnicaRacun().getText().trim();
									fsrp.getTextFieldIdRacunStavkeRacuna().setText(s);
								}
								
						});
									ro.getBtnPonistiAkcijuRacunOtpremnica().addActionListener(new ActionListener() {
										
										@Override
										public void actionPerformed(ActionEvent e) {
											ro.setVisible(false);					
											
										
								}
							});
									panelAdmin.setVisible(true);			
						}
					});
						
						
				}
			});
		mnProdajaAdmin.add(mntmKreirajRacunOtpremnicuAdmin);

		JMenuItem mntmCeneArtiklaAdmin = new JMenuItem("Cene artikla");
		mntmCeneArtiklaAdmin.setFont(new Font("Arial", Font.PLAIN, 13));
		mntmCeneArtiklaAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrameCenaArtikla ca = new JFrameCenaArtikla();
				panelAdmin.setVisible(false);
				ca.setVisible(true);
				ca.getBtnNazadCenaArtikla().addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						ca.setVisible(false);
						
					}
				});
				panelAdmin.setVisible(true);
			}
		});
		mnProdajaAdmin.add(mntmCeneArtiklaAdmin);
		
		JMenuItem mntmPregledRaunaPo = new JMenuItem("Pregled računa");
		mntmPregledRaunaPo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFramePregledRacunaPoStatusu rps = new JFramePregledRacunaPoStatusu();
				rps.getRdbtnStorniran().setEnabled(false);
				//panelAdmin.setVisible(false);
				rps.setVisible(true);
				
				
			}
		});
		mntmPregledRaunaPo.setFont(new Font("Arial", Font.PLAIN, 13));
		mnProdajaAdmin.add(mntmPregledRaunaPo);

		JMenu mnSkladisteAdmin = new JMenu("    Skladi\u0161te");
		mnSkladisteAdmin.setFont(new Font("Arial", Font.BOLD, 14));
		menuBarAdmin.add(mnSkladisteAdmin);

		JMenuItem mntmKontrolaZalihaAdmin = new JMenuItem("Kontrola zaliha");
		mntmKontrolaZalihaAdmin.setFont(new Font("Arial", Font.PLAIN, 13));
		mntmKontrolaZalihaAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrameKontrolaZaliha kz = new JFrameKontrolaZaliha();
				kz.setVisible(true);
				kz.getBtnPrekidKontrolaZaliha().addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						kz.setVisible(false);
						
					}
				});
				kz.getBtnOkKontrolaZaliha().addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						JFrameKontrolaZalihaPregled kzp = new JFrameKontrolaZalihaPregled();
						kz.setVisible(false);
						kzp.setVisible(true);
						kzp.getBtnIzlazKontrolaZalihaPregled().addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent e) {
							kzp.setVisible(false);
								
							}
						});
						kzp.getBtnNoviPregledKontroleZaliha().addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								kz.setVisible(true);
								kzp.setVisible(false);
								
							}
						});
					}
				});
			}
		});
	
		mnSkladisteAdmin.add(mntmKontrolaZalihaAdmin);

		JMenu mnZaposleniAdmin = new JMenu("    Zaposleni");
		mnZaposleniAdmin.setFont(new Font("Arial", Font.BOLD, 14));
		menuBarAdmin.add(mnZaposleniAdmin);

		JMenuItem mntmTrenutnoZaposleniAdmin = new JMenuItem("Trenutno zaposleni");

		JMenuItem mntmPregledZaposlenihAdmin = new JMenuItem("Pregled zaposlenih");
		mntmPregledZaposlenihAdmin.setFont(new Font("Arial", Font.PLAIN, 13));
		mntmPregledZaposlenihAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFramePregledZaposlenih tz = new JFramePregledZaposlenih();
				panelAdmin.setVisible(false);
				tz.setVisible(true);
				postaviModelZaposleni(new ArrayList<>(), tz.getTablePregledTrenutnoZaposlenih());
				ArrayList lista;
				
				try {
					lista = Kontroler.getInstance().getZaposleni();
					postaviModelZaposleni(lista, tz.getTablePregledTrenutnoZaposlenih());
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				tz.getBtnIzlazTrenutnoZaposleni().addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						tz.setVisible(false);				
						
					}
					
				});
				panelAdmin.setVisible(true);
			}
		});
		mnZaposleniAdmin.add(mntmPregledZaposlenihAdmin);

		mnMaticniPodaciAdmin = new JMenu("    Mati\u010Dni podaci");
		mnMaticniPodaciAdmin.setFont(new Font("Arial", Font.BOLD, 14));
		menuBarAdmin.add(mnMaticniPodaciAdmin);

		JMenu mnFilijalaAdmin = new JMenu("Filijala");
		mnFilijalaAdmin.setFont(new Font("Arial", Font.PLAIN, 13));
		mnMaticniPodaciAdmin.add(mnFilijalaAdmin);

		JMenuItem mntmPregledFilijalaAdmin = new JMenuItem("Pregled filijala");
		mntmPregledFilijalaAdmin.setFont(new Font("Arial", Font.PLAIN, 13));
		mntmPregledFilijalaAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFramePregledFilijale pf = new JFramePregledFilijale();
				panelAdmin.setVisible(false);
				pf.setVisible(true);
				postaviModelFilijala(new ArrayList<>(), pf.getTablePregleFilijale());
				ArrayList lista;
				
				try {
					lista = Kontroler.getInstance().getFilijala();
					postaviModelFilijala(lista, pf.getTablePregleFilijale());
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				pf.getBtnIzlazPregledFilijale().addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						pf.setVisible(false);
						
					}
				});
				panelAdmin.setVisible(true);
			}
		});
		mnFilijalaAdmin.add(mntmPregledFilijalaAdmin);

		JMenuItem mntmDodavanjeFilijaleAdmin = new JMenuItem("Dodaj filijalu");
		mntmDodavanjeFilijaleAdmin.setFont(new Font("Arial", Font.PLAIN, 13));
		mntmDodavanjeFilijaleAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrameFilijala jf = new JFrameFilijala();
				
			    jf.getBtnAzurirajFilijalu().setVisible(false);
			    jf.getBtnObrisiFilijalu().setVisible(false);
			    jf.getBtnDodajFilijalu().setBounds(650, 250, 180, 25);
			    
			    jf.getLblIDFilijale().setVisible(false);
			    jf.getTextIDFilijale().setVisible(false);				
				
				
				panelAdmin.setVisible(false);
				jf.setVisible(true);
				
				jf.getBtnPonistiAkcijuFilijala().addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						jf.setVisible(false);
						
					}
				});
				panelAdmin.setVisible(true);
			}
		});
		mnFilijalaAdmin.add(mntmDodavanjeFilijaleAdmin);

		JMenuItem mntmBrisanjeFilijaleAdmin = new JMenuItem("Obri\u0161i filijalu");
		mntmBrisanjeFilijaleAdmin.setFont(new Font("Arial", Font.PLAIN, 13));
		mntmBrisanjeFilijaleAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrameObrisiFilijalu of = new JFrameObrisiFilijalu();
				panelAdmin.setVisible(false);
				of.setVisible(true);
			}
		});
		mnFilijalaAdmin.add(mntmBrisanjeFilijaleAdmin);
		mntmBrisanjeFilijaleAdmin.setEnabled(false);

		JMenuItem mntmAzuriranjeFilijaleAdmin = new JMenuItem("A\u017Euriranje");
		mntmAzuriranjeFilijaleAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFrameAzurirajFilijalu jfaf = new JFrameAzurirajFilijalu();
				
				panelAdmin.setVisible(false);
				jfaf.setVisible(true);
				
				jfaf.getBtnNazadAzurirajFilijali().addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
					
						jfaf.setVisible(false);
					}
				});
				panelAdmin.setVisible(true);
			}
		});
		mntmAzuriranjeFilijaleAdmin.setFont(new Font("Arial", Font.PLAIN, 13));
		mnFilijalaAdmin.add(mntmAzuriranjeFilijaleAdmin);

		JMenu mnZaposleniMatPodaciAdmin = new JMenu("Zaposleni");
		mnZaposleniMatPodaciAdmin.setFont(new Font("Arial", Font.PLAIN, 13));
		mnMaticniPodaciAdmin.add(mnZaposleniMatPodaciAdmin);

		JMenuItem mntmPregledZaposlenihMPAdmin = new JMenuItem("Pregled zaposlenih");
		mntmPregledZaposlenihMPAdmin.setFont(new Font("Arial", Font.PLAIN, 13));
		mntmPregledZaposlenihMPAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFramePregledZaposlenih tz = new JFramePregledZaposlenih();
				panelAdmin.setVisible(false);
				tz.setVisible(true);
				postaviModelZaposleni(new ArrayList<>(), tz.getTablePregledTrenutnoZaposlenih());
				ArrayList lista;
				
				try {
					lista = Kontroler.getInstance().getZaposleni();
					postaviModelZaposleni(lista, tz.getTablePregledTrenutnoZaposlenih());
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				tz.getBtnIzlazTrenutnoZaposleni().addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						tz.setVisible(false);				
						
					}
					
				});
				panelAdmin.setVisible(true);
			}
		});
		mnZaposleniMatPodaciAdmin.add(mntmPregledZaposlenihMPAdmin);

		JMenuItem mntmDodajZaposlenogAdmin = new JMenuItem("Dodaj zaposlenog");
		mntmDodajZaposlenogAdmin.setFont(new Font("Arial", Font.PLAIN, 13));
		mntmDodajZaposlenogAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrameZaposleni fz = new JFrameZaposleni();
				
				fz.getBtnAzurirajZaposlenog().setVisible(false);
				fz.getBtnObrisiZaposlenog().setVisible(false);
				fz.getBtnDodajZaposlenog().setBounds(650, 410, 180, 25);
				
				fz.getLblIdZaposlenog().setVisible(false);
				fz.getTextIDZaposlenog().setVisible(false);				
				
				panelAdmin.setVisible(false);
				fz.setVisible(true);
				
				fz.getBtnPonistiAkciju().addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						fz.setVisible(false);
						
					}
				});
				panelAdmin.setVisible(true);
			}
		});
		mnZaposleniMatPodaciAdmin.add(mntmDodajZaposlenogAdmin);

		JMenuItem mntmObrisiZaposlenogAdmin = new JMenuItem("Obri\u0161i zaposlenog");
		mntmObrisiZaposlenogAdmin.setFont(new Font("Arial", Font.PLAIN, 13));
		mntmObrisiZaposlenogAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrameObrisiZaposlenog oz = new JFrameObrisiZaposlenog();
				panelAdmin.setVisible(false);
				oz.setVisible(true);
			}
		});
		mnZaposleniMatPodaciAdmin.add(mntmObrisiZaposlenogAdmin);

		JMenuItem mntmAzurirajZaposlenogAdmin = new JMenuItem("A\u017Euriraj");
		mntmAzurirajZaposlenogAdmin.setFont(new Font("Arial", Font.PLAIN, 13));
		mntmAzurirajZaposlenogAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				JFrameAzurirajZaposlenog jfaz = new JFrameAzurirajZaposlenog();
				
				panelAdmin.setVisible(false);
				jfaz.setVisible(true);
				
				jfaz.getBtnNazadAzurirajZaposlenog().addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						jfaz.setVisible(false);
						
					}
				});
				panelAdmin.setVisible(true);
			}
		});
		mnZaposleniMatPodaciAdmin.add(mntmAzurirajZaposlenogAdmin);

		JMenu mnSkladistaAdmin = new JMenu("Magacin");
		mnSkladistaAdmin.setFont(new Font("Arial", Font.PLAIN, 13));
		mnMaticniPodaciAdmin.add(mnSkladistaAdmin);
		mnSkladistaAdmin.setEnabled(false);

		JMenuItem mntmAktivnaSkladistaAdmin = new JMenuItem("Pregled magacina");
		mntmAktivnaSkladistaAdmin.setFont(new Font("Arial", Font.PLAIN, 13));
		mntmAktivnaSkladistaAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFramePregledMagacina pm = new JFramePregledMagacina();
				panelAdmin.setVisible(false);
				pm.setVisible(true);
				postaviModelMagacina(new ArrayList<>(), pm.getTablePregledMagacina());
				ArrayList lista;
				
				try {
					lista = Kontroler.getInstance().getMagacin();
					postaviModelMagacina(lista, pm.getTablePregledMagacina());
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				pm.getBtnIzlazPregledMagacina().addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						pm.setVisible(false);				
						
					}
					
				});
				panelAdmin.setVisible(true);
				
			}
		});
		mnSkladistaAdmin.add(mntmAktivnaSkladistaAdmin);

		JMenuItem mntmDodajSkladisteAdmin = new JMenuItem("Dodaj magacin");
		mntmDodajSkladisteAdmin.setFont(new Font("Arial", Font.PLAIN, 13));
		mntmDodajSkladisteAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrameMagacin jfm = new JFrameMagacin();
				
				jfm.getBtnObrisiMagacin().setVisible(false);
				jfm.getBtnAzurirajMagacin().setVisible(false);
				jfm.getBtnDodajMagacin().setBounds(380, 300, 180, 25);				
				
				jfm.getLblIdMagacina().setVisible(false);
				jfm.getTextFieldIdMagacina().setVisible(false);
				
				jfm.getBtnPrekiniackcijuMagacin().addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						jfm.setVisible(false);
					}
				});
				
				jfm.setVisible(true);

			}
		});
		mnSkladistaAdmin.add(mntmDodajSkladisteAdmin);

		JMenuItem mntmObrisiSkladisteAdmin = new JMenuItem("Obri\u0161i magacin");
		mntmObrisiSkladisteAdmin.setFont(new Font("Arial", Font.PLAIN, 13));
		mntmObrisiSkladisteAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrameObrisiMagacin om = new JFrameObrisiMagacin();
				panelAdmin.setVisible(false);
				om.setVisible(true);
				om.getBtnNazadObrisiMagacin().addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						om.setVisible(false);				
						
					}
					
				});
				panelAdmin.setVisible(true);
				
			}
		});
		mnSkladistaAdmin.add(mntmObrisiSkladisteAdmin);

		JMenuItem mntmAzurirajSkladistaAdmin = new JMenuItem("A\u017Euriraj");
		mntmAzurirajSkladistaAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFrameAzurirajMagacin jfam = new JFrameAzurirajMagacin();
				
				panelAdmin.setVisible(false);
				jfam.setVisible(true);
				
				jfam.getBtnNazadAzurirajMagacin().addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						jfam.setVisible(false);
						
					}
				});
				panelAdmin.setVisible(true);
			}
		});
		mntmAzurirajSkladistaAdmin.setFont(new Font("Arial", Font.PLAIN, 13));
		mnSkladistaAdmin.add(mntmAzurirajSkladistaAdmin);

		JMenu mnKupciAdmin = new JMenu("Kupci");
		mnKupciAdmin.setFont(new Font("Arial", Font.PLAIN, 13));
		mnMaticniPodaciAdmin.add(mnKupciAdmin);

		JMenuItem mntmAktivniKupciAdmin = new JMenuItem("Pregled kupaca");
		mntmAktivniKupciAdmin.setFont(new Font("Arial", Font.PLAIN, 13));
		mntmAktivniKupciAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFramePregledKupca pk = new JFramePregledKupca();
				panelAdmin.setVisible(false);
				pk.setVisible(true);
				postaviModelKupac(new ArrayList<>(), pk.getTablePregleKupaca());
				ArrayList lista;
				
				try {
					lista = Kontroler.getInstance().getKupac();
					postaviModelKupac(lista, pk.getTablePregleKupaca());
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				pk.getBtnIzlazPregledKupaca().addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						pk.setVisible(false);				
						
					}
					
				});
				panelAdmin.setVisible(true);
				
			}
		});
		mnKupciAdmin.add(mntmAktivniKupciAdmin);

		JMenuItem mntmDodajKupcaAdmin = new JMenuItem("Dodaj kupca");
		mntmDodajKupcaAdmin.setFont(new Font("Arial", Font.PLAIN, 13));
		mntmDodajKupcaAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrameKupac jfk = new JFrameKupac();
				
				jfk.getBtnAzurirajKupca().setVisible(false);
				jfk.getBtnObrisiKupca().setVisible(false);
				jfk.getBtnDodajKupca().setBounds(650, 290, 180, 25);
				
				jfk.getTextFieldIdKupca().setVisible(false);
				jfk.getLblIdKupca().setVisible(false);				
				
				jfk.getBtnPonistiAkcijuKupac().addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						jfk.setVisible(false);
					}
				});
				jfk.getTextFieldIdKupca().setVisible(false);
				jfk.setVisible(true);

			}
		});
				
		mnKupciAdmin.add(mntmDodajKupcaAdmin);

		JMenuItem mntmObrisiKupcaAdmin = new JMenuItem("Obri\u0161i kupca");
		mntmObrisiKupcaAdmin.setFont(new Font("Arial", Font.PLAIN, 13));
		mntmObrisiKupcaAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrameObrisiKupca ok = new JFrameObrisiKupca();
				panelAdmin.setVisible(false);
				ok.setVisible(true);
				ok.getBtnNazadObrisiKupca().addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						ok.setVisible(false);				
						
					}
					
				});
				panelAdmin.setVisible(true);
				
			}
		});
		mnKupciAdmin.add(mntmObrisiKupcaAdmin);
		mntmObrisiKupcaAdmin.setEnabled(false);

		JMenuItem mntmAzurirajKupcaAdmin = new JMenuItem("A\u017Euriraj");
		mntmAzurirajKupcaAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				JFrameAzurirajKupca jfak = new JFrameAzurirajKupca();
				
				panelAdmin.setVisible(false);
				jfak.setVisible(true);
				
				jfak.getBtnNazadAzurirajKupca().addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						jfak.setVisible(false);
						
					}
				});
				panelAdmin.setVisible(true);
			}
		});
		mntmAzurirajKupcaAdmin.setFont(new Font("Arial", Font.PLAIN, 13));
		mnKupciAdmin.add(mntmAzurirajKupcaAdmin);

		JMenu mnArtikliAdmin = new JMenu("Artikli");
		mnArtikliAdmin.setFont(new Font("Arial", Font.PLAIN, 13));
		mnMaticniPodaciAdmin.add(mnArtikliAdmin);

		JMenuItem mntmPregledArtikalaAdmin = new JMenuItem("Pregled artikala");
		mntmPregledArtikalaAdmin.setFont(new Font("Arial", Font.PLAIN, 13));
		mntmPregledArtikalaAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFramePregledArtikala artikal = new JFramePregledArtikala();
				panelAdmin.setVisible(false);
				artikal.setVisible(true);
				
				postaviModelArtikli(new ArrayList<>(), artikal.getTablePregledArtikala());
				ArrayList lista;
				try {
					lista = Kontroler.getInstance().getArtikli(0);
					postaviModelArtikli(lista, artikal.getTablePregledArtikala());
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				artikal.getBtnIzlazPregledArtikala().addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						artikal.setVisible(false);
						
					}
				});
				panelAdmin.setVisible(true);				
				
			}
		});
		mnArtikliAdmin.add(mntmPregledArtikalaAdmin);

		JMenuItem mntmDodajArtikalAdmin = new JMenuItem("Dodaj artikal");
		mntmDodajArtikalAdmin.setFont(new Font("Arial", Font.PLAIN, 13));
		mntmDodajArtikalAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFrameArtikal jfa = new JFrameArtikal(0);
				
				jfa.getBtnAzuriraj().setVisible(false);
				jfa.getBtnObrisiArtikal().setVisible(false);
				jfa.getBtnDodajArtikal().setBounds(650, 240, 180, 25);
				
				jfa.getLblIdArtikla().setVisible(false);
				jfa.getTextFieldIDArtikla().setVisible(false);
				
				panelAdmin.setVisible(false);
				jfa.setVisible(true);
				
				jfa.getBtnPonistiAkciju().addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						jfa.setVisible(false);						
					}
				});
				panelAdmin.setVisible(true);
			}
		});
		mnArtikliAdmin.add(mntmDodajArtikalAdmin);

		JMenuItem mntmObrisiArtikalAdmin = new JMenuItem("Obri\u0161i artikal");
		mntmObrisiArtikalAdmin.setFont(new Font("Arial", Font.PLAIN, 13));
		mntmObrisiArtikalAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrameObrisiArtikal oa = new JFrameObrisiArtikal();
				
				panelAdmin.setVisible(false);
				oa.setVisible(true);				
				
				oa.getBtnNazadObrisiArtikal().addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						oa.setVisible(false);
						
					}
				});
				panelAdmin.setVisible(true);
			}
		});
		mnArtikliAdmin.add(mntmObrisiArtikalAdmin);

		JMenuItem mntmAzurirajArtikleAdmin = new JMenuItem("A\u017Euriraj");
		mntmAzurirajArtikleAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				JFrameAzurirajArtikal jfaa = new JFrameAzurirajArtikal();
				
				panelAdmin.setVisible(false);
				jfaa.setVisible(true);
				
				jfaa.getBtnNazadAzurirajArtikal().addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						jfaa.setVisible(false);
						
					}
				});
				panelAdmin.setVisible(true);
			}
		});
		mntmAzurirajArtikleAdmin.setFont(new Font("Arial", Font.PLAIN, 13));
		mnArtikliAdmin.add(mntmAzurirajArtikleAdmin);

		JMenu mnGrupeArtikalaAdmin = new JMenu("Grupe artikala");
		mnGrupeArtikalaAdmin.setFont(new Font("Arial", Font.PLAIN, 13));
		mnMaticniPodaciAdmin.add(mnGrupeArtikalaAdmin);

		JMenuItem mntmPregledGrupeArtikalaAdmin = new JMenuItem("Pregled grupe artikala");
		mntmPregledGrupeArtikalaAdmin.setFont(new Font("Arial", Font.PLAIN, 13));
		mntmPregledGrupeArtikalaAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFramePregledGrupeArtikala pga = new JFramePregledGrupeArtikala();
				panelAdmin.setVisible(false);
				pga.setVisible(true);
				
				postaviModelGrupaArtikala(new ArrayList<>(), pga.getTablePregledGrupeArtikala());
				ArrayList lista;
				
				int id_grupe_artikala;
				
				try {
					lista = Kontroler.getInstance().getGrupaArtikala(0);
					postaviModelGrupaArtikala(lista, pga.getTablePregledGrupeArtikala());
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				pga.getBtnIzlazPregledGrupeArtikala().addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						pga.setVisible(false);
						
					}
				});
				panelAdmin.setVisible(true);
			}
		});
		mnGrupeArtikalaAdmin.add(mntmPregledGrupeArtikalaAdmin);

		JMenuItem mntmDodajGrupuArtikalaAdmin = new JMenuItem("Dodaj grupu artikala");
		mntmDodajGrupuArtikalaAdmin.setFont(new Font("Arial", Font.PLAIN, 13));
		mntmDodajGrupuArtikalaAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				JFrameGrupaArtikala jfga = new JFrameGrupaArtikala();
				
				jfga.getBtnAzurirajGrupuArtikala().setVisible(false);
				jfga.getBtnObrisiGrupuArtikala().setVisible(false);
				jfga.getBtnDodajGrupuArtikala().setBounds(280, 180, 180, 25);
				
				jfga.getLblIdGrupeArtikala().setVisible(false);
				jfga.getTextFieldIdGrupeArtikala().setVisible(false);
				
				
				panelAdmin.setVisible(false);
				jfga.setVisible(true);
				
				jfga.getBtnPonistiAkcijuDodajGrupuArtikala().addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						jfga.setVisible(false);
						
					}
				});
				panelAdmin.setVisible(true);
			}
		});
		mnGrupeArtikalaAdmin.add(mntmDodajGrupuArtikalaAdmin);

		JMenuItem mntmObrisiGrupuArtikalaAdmin = new JMenuItem("Obri\u0161i grupu artikala");
		mntmObrisiGrupuArtikalaAdmin.setFont(new Font("Arial", Font.PLAIN, 13));
		mntmObrisiGrupuArtikalaAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFrameObrisiGrupuArtikala obga = new JFrameObrisiGrupuArtikala();
				
				panelAdmin.setVisible(false);
				obga.setVisible(true);
				
				obga.getBtnNazadObrisiGA().addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						obga.setVisible(false);
						
					}
				});
				panelAdmin.setVisible(true);
			}
		});
		mnGrupeArtikalaAdmin.add(mntmObrisiGrupuArtikalaAdmin);
		mntmObrisiGrupuArtikalaAdmin.setEnabled(false);

		JMenuItem mntmAzurirajGrupuArtikalaAdmin = new JMenuItem("A\u017Euriraj");
		mntmAzurirajGrupuArtikalaAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFrameAzurirajGrupuArtikala jfaga = new JFrameAzurirajGrupuArtikala();
				
				panelAdmin.setVisible(false);
				jfaga.setVisible(true);
				
				jfaga.getBtnNazadAzurirajGA().addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						jfaga.setVisible(false);
						
					}
				});
				panelAdmin.setVisible(true);
			}
		});
		mntmAzurirajGrupuArtikalaAdmin.setFont(new Font("Arial", Font.PLAIN, 13));
		mnGrupeArtikalaAdmin.add(mntmAzurirajGrupuArtikalaAdmin);

		mnIzvestajAdmin = new JMenu("    Izve\u0161taj");
		mnIzvestajAdmin.setFont(new Font("Arial", Font.BOLD, 14));
		menuBarAdmin.add(mnIzvestajAdmin);
		
				JMenu mnAnalizaProdajeAdmin = new JMenu("Analiza prodaje");
				mnIzvestajAdmin.add(mnAnalizaProdajeAdmin);
				mnAnalizaProdajeAdmin.setFont(new Font("Arial", Font.PLAIN, 13));
				
						JMenuItem mntmProdajnaCenaArtiklaAdmin = new JMenuItem("Prodajna cena artikla");
						mntmProdajnaCenaArtiklaAdmin.setFont(new Font("Arial", Font.PLAIN, 13));
						mntmProdajnaCenaArtiklaAdmin.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
								JFrameCenaArtikla pca = new JFrameCenaArtikla();
								pca.setVisible(true);
								panelAdmin.setVisible(true);
								pca.setTitle("Prodajna cena artikla");
								pca.getBtnNazadCenaArtikla().addActionListener(new ActionListener() {
									
									@Override
									public void actionPerformed(ActionEvent e) {
										pca.setVisible(false);
										
									}
								});
								panelAdmin.setVisible(true);
								postaviModelProdajneCeneArtikla(new ArrayList<>(), pca.getTableCenaArtikla());
								ArrayList lista;
								
								try {
									lista = Kontroler.getInstance().getArtikli(0);
									postaviModelProdajneCeneArtikla(lista,pca.getTableCenaArtikla());
								} catch (ClassNotFoundException | SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
							}
						});
						mnAnalizaProdajeAdmin.add(mntmProdajnaCenaArtiklaAdmin);
						
								JMenuItem mntmProdajaPoArtikluAdmin = new JMenuItem("Prodaja po filijalama");
								mntmProdajaPoArtikluAdmin.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent arg0) {
										JFrameIzvestajProdajeFilijala ip = new JFrameIzvestajProdajeFilijala();
										ip.setVisible(true);
										
										ip.getComboBoxFilijalaIzvestajProdaje().setEnabled(false);
										ip.getComboBoxGrupaArtikalaIzvestajProdaje().setEnabled(false);
										ip.getComboBoxArtikalIzvestajProdaje().setEnabled(false);
										//ip.getDateChooserrDoIzvestajProdaje().setEnabled(false);				
										
									}			
									
								});
								mntmProdajaPoArtikluAdmin.setFont(new Font("Arial", Font.PLAIN, 13));
								mnAnalizaProdajeAdmin.add(mntmProdajaPoArtikluAdmin);
								
										JMenuItem mntmProdajaPoKupcimaAdmin = new JMenuItem("Prodaja po kupcima");
										mntmProdajaPoKupcimaAdmin.addActionListener(new ActionListener() {
											public void actionPerformed(ActionEvent arg0) {
												
												JFrameIzvestajProdajeKupac pk = new JFrameIzvestajProdajeKupac();
												pk.setVisible(true);
												
												pk.getComboBoxIzvestajKupac().setEnabled(false);
												pk.getComboBoxGrupaArtikalaIzvestajKupac().setEnabled(false);
												pk.getComboBoxArtikalIzvestajKupac().setEnabled(false);
											
											}
										});
										mntmProdajaPoKupcimaAdmin.setFont(new Font("Arial", Font.PLAIN, 13));
										mnAnalizaProdajeAdmin.add(mntmProdajaPoKupcimaAdmin);
										
												JMenuItem mntmSumarniPregledDokumenataAdmin = new JMenuItem("Prodaja po zaposlenima");
												mntmSumarniPregledDokumenataAdmin.addActionListener(new ActionListener() {
													public void actionPerformed(ActionEvent arg0) {
														
														JFrameIzvestajProdajeZaposleni pz = new JFrameIzvestajProdajeZaposleni();
														pz.setVisible(true);
														
														pz.getComboBoxZaposleniIzvestaj().setEnabled(false);
														pz.getComboBoxIzvestajZaposleniGrupaArtikla().setEnabled(false);
														pz.getComboBoxIzvestakZaposlenihArikal().setEnabled(false);
														
														
														postaviModelProdajaPoZaposlenom(new ArrayList<>(), pz.getTableIzvestajProdajeZaposlenog());
														ArrayList lista;
														try {
															
															SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
													        String sd = sdf.format(pz.getDateChooserOdIzvestajZaposlenog().getDate());
													        String sd1 = sdf.format(pz.getDateChooserDoIzvestajZaposlenog().getDate()); 
															
															
															lista = Kontroler.getInstance().getIzvestajProdajePoZposlenom(0, sd, sd1);
															postaviModelProdajaPoZaposlenom(lista, pz.getTableIzvestajProdajeZaposlenog());
														double sum = 0;
														double sum1 = 0;
														double sum2 = 0;
														
														 for (int i = 0; i < pz.getTableIzvestajProdajeZaposlenog().getRowCount(); i++) {
													            sum = sum + Double.parseDouble(pz.getTableIzvestajProdajeZaposlenog().getValueAt(i, 11).toString());
													            pz.getTextFieldNabavnaVrenostIzvestajZaposleni().setText(Double.toString(sum));
													        }
														 for (int i1 = 0; i1 <  pz.getTableIzvestajProdajeZaposlenog().getRowCount(); i1++) {
													            sum1 = sum1 + Double.parseDouble( pz.getTableIzvestajProdajeZaposlenog().getValueAt(i1, 15).toString());
													            	pz.getTextFieldOsnovicaIzvestajZaposleni().setText(Double.toString(sum1));
														 	}
														 for (int i2 = 0; i2 < pz.getTableIzvestajProdajeZaposlenog().getRowCount(); i2++) {
													            sum2 = sum2 + Double.parseDouble(pz.getTableIzvestajProdajeZaposlenog().getValueAt(i2, 14).toString());
													            	pz.getTextProdajnavrednostIzvestajProdajeZaposleni().setText(Double.toString(sum2));
         	 }
         	pz.getTextFieldRucIzvestajProdajeZaposleni().setText(Double.toString(sum2-sum));
														
														} catch (Exception e) {
															// TODO: handle exception
														}
													}
												});
												
												mntmSumarniPregledDokumenataAdmin.setFont(new Font("Arial", Font.PLAIN, 13));
												mnAnalizaProdajeAdmin.add(mntmSumarniPregledDokumenataAdmin);
												
												JMenuItem mntmProdajaPoRaunima = new JMenuItem("Prodaja po ra\u010Dunima");
												mntmProdajaPoRaunima.addActionListener(new ActionListener() {
													public void actionPerformed(ActionEvent e) {
														
														JFrameIzvestajProdajeRacun izpr = new JFrameIzvestajProdajeRacun();				
														
														izpr.setVisible(true);
														
														izpr.getComboBoxArtikalPregledRAcuna().setEnabled(false);
														izpr.getComboBoxGrupaArtiklaPregledRacuna().setEnabled(false);
														izpr.getComboBoxKupacPregledRacuna().setEnabled(false);
													}
												});
												mntmProdajaPoRaunima.setFont(new Font("Arial", Font.PLAIN, 13));
												mnAnalizaProdajeAdmin.add(mntmProdajaPoRaunima);

		JMenu mnRezultatiAdmin = new JMenu("Rezultati");
		mnRezultatiAdmin.setFont(new Font("Arial", Font.PLAIN, 13));
		mnIzvestajAdmin.add(mnRezultatiAdmin);		

		JMenuItem mntmDnevniIzvestajAdmin = new JMenuItem("Dnevni izvestaj");
		mntmDnevniIzvestajAdmin.setFont(new Font("Arial", Font.PLAIN, 13));
		mnRezultatiAdmin.add(mntmDnevniIzvestajAdmin);
		mntmDnevniIzvestajAdmin.setEnabled(false);

		JMenuItem mntmNedeljniIzvestajAdmin = new JMenuItem("Nedeljni izvestaj");
		mntmNedeljniIzvestajAdmin.setFont(new Font("Arial", Font.PLAIN, 13));
		mnRezultatiAdmin.add(mntmNedeljniIzvestajAdmin);
		mntmNedeljniIzvestajAdmin.setEnabled(false);

		JMenuItem mntmMesecniIzvestajAdmin = new JMenuItem("Mesecni izvestaj");
		mntmMesecniIzvestajAdmin.setFont(new Font("Arial", Font.PLAIN, 13));
		mnRezultatiAdmin.add(mntmMesecniIzvestajAdmin);
		mntmMesecniIzvestajAdmin.setEnabled(false);

		JMenuItem mntmGodisnjiIzvestajAdmin = new JMenuItem("Godisnji izvestaj");
		mntmGodisnjiIzvestajAdmin.setFont(new Font("Arial", Font.PLAIN, 13));
		mnRezultatiAdmin.add(mntmGodisnjiIzvestajAdmin);
		mntmGodisnjiIzvestajAdmin.setEnabled(false);

		mnSistemAdmin = new JMenu("    Sistem");
		mnSistemAdmin.setFont(new Font("Arial", Font.BOLD, 14));
		menuBarAdmin.add(mnSistemAdmin);

		JMenuItem mntmPromeniLozinkuAdmin = new JMenuItem("Promeni lozinku");
		mntmPromeniLozinkuAdmin.setFont(new Font("Arial", Font.PLAIN, 13));
		mntmPromeniLozinkuAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFramePromenaLozinke proloz = new JFramePromenaLozinke();
			
				proloz.setVisible(true);
				proloz.getTextFieldNewPassword().setEditable(false);
				proloz.getTextFieldConfirmPassword().setEditable(false);
				
				proloz.getBtnUReduPromenaLozinke().addActionListener(new ActionListener() {					
					
					@Override
					public void actionPerformed(ActionEvent e) {
						
						if((proloz.getTextFieldUsername().getText().toString()).equals(logedIn.getUsernameZaposlenog()) 
							&& (proloz.getTextFieldPassword().getText().toString()).equals(logedIn.getPasswordZaposlenog())) {
							JOptionPane.showMessageDialog(null, "Unesite novu lozinku!");
							proloz.getTextFieldNewPassword().setEditable(true);
							proloz.getTextFieldConfirmPassword().setEditable(true);
							proloz.getTextFieldUsername().setEditable(false);
							proloz.getTextFieldPassword().setEditable(false);
							proloz.getTextFieldNewPassword().requestFocus();
						}else{
							JOptionPane.showMessageDialog(null, "Uneli ste pogresne podatke!");
						}
								
						proloz.getBtnChangePassword().addActionListener(new ActionListener() {
								
								@Override
								public void actionPerformed(ActionEvent e) {
									try {
										if((proloz.getTextFieldNewPassword().getText().toString()).equals(
											proloz.getTextFieldConfirmPassword().getText().toString())) {
										logedIn.setPasswordZaposlenog(proloz.getTextFieldNewPassword().getText());	
										Kontroler.getInstance().updateZaposleni(logedIn);
										JOptionPane.showMessageDialog(null, "Uspesno ste promenili lozinku!");
										proloz.setVisible(false);
										}else {
											JOptionPane.showMessageDialog(null, "Šifre se ne podudaraju!");
											proloz.getTextFieldConfirmPassword().setText("");
											proloz.getTextFieldConfirmPassword().grabFocus();
										}
										
									} catch (ClassNotFoundException e1) {
										
										e1.printStackTrace();
									} catch (SQLException e1) {
										
										e1.printStackTrace();
									}
									
								}
							});
		
						} 
						
					}
				
				);
				panelAdmin.setVisible(true);
			}
		});
		mnSistemAdmin.add(mntmPromeniLozinkuAdmin);
		
		panelUserKomercijalista = new JPanel();
		frmVeleprodaja.getContentPane().add(panelUserKomercijalista, "name_773056089739863");
		panelUserKomercijalista.setLayout(null);
		
		JMenuBar menuBarUserKom = new JMenuBar();
		menuBarUserKom.setBounds(0, 0, 630, 21);
		panelUserKomercijalista.add(menuBarUserKom);
		
		JMenu mnPrijavaUserKom = new JMenu("Prijava");
		mnPrijavaUserKom.setFont(new Font("Segoe UI", Font.BOLD, 14));
		menuBarUserKom.add(mnPrijavaUserKom);
		
		JMenuItem mntmOdjavaUserKom = new JMenuItem("Odjava");
		mntmOdjavaUserKom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelUserKomercijalista.setVisible(false);
				panelLogin.setVisible(true);
			}
		});
		mnPrijavaUserKom.add(mntmOdjavaUserKom);
		
		JMenu mnZaposleniUserKom = new JMenu("Zaposleni");
		mnPrijavaUserKom.add(mnZaposleniUserKom);
		
		JMenuItem mntmTrenutnoPrijavljeniUserKom = new JMenuItem("Trenutno prijavljeni");
		mnZaposleniUserKom.add(mntmTrenutnoPrijavljeniUserKom);
		
		JMenuItem mntmOsveziUserKom = new JMenuItem("Osvezi (Update)");
		mnPrijavaUserKom.add(mntmOsveziUserKom);
		
		JMenuItem mntmIzlazUserKom = new JMenuItem("Izlaz");
		mnPrijavaUserKom.add(mntmIzlazUserKom);
		
		panelUserMagacioner = new JPanel();
		frmVeleprodaja.getContentPane().add(panelUserMagacioner, "name_847361888603433");
		panelUserMagacioner.setLayout(null);
		
		JMenuBar menuBarUserMag = new JMenuBar();
		menuBarUserMag.setBounds(0, 0, 630, 21);
		panelUserMagacioner.add(menuBarUserMag);
		
		JMenu mnPrijavaUserMag = new JMenu("Prijava");
		menuBarUserMag.add(mnPrijavaUserMag);
		mnPrijavaUserMag.setFont(new Font("Segoe UI", Font.BOLD, 14));
		
		JMenuItem mntmOdjavaUserMag = new JMenuItem("Odjava");
		mntmOdjavaUserMag.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelUserMagacioner.setVisible(false);
				panelLogin.setVisible(true);
			}
		});
		mnPrijavaUserMag.add(mntmOdjavaUserMag);
		
		JMenu mnZaposleniUserMag = new JMenu("Zaposleni");
		mnPrijavaUserMag.add(mnZaposleniUserMag);
		
		JMenuItem mntmTrenutnoPrijavljeniUserMag = new JMenuItem("Trenutno prijavljeni");
		mnZaposleniUserMag.add(mntmTrenutnoPrijavljeniUserMag);
		
		JMenuItem mntmOsveziUserMag = new JMenuItem("Osvezi (Update)");
		mnPrijavaUserMag.add(mntmOsveziUserMag);
		
		JMenuItem mntmIzlazUserMag = new JMenuItem("Izlaz");
		mnPrijavaUserMag.add(mntmIzlazUserMag);

	}
	
	private void postaviModelZaposleni(ArrayList lista, JTable t){
		JTabelModelZaposleni model = new JTabelModelZaposleni(lista);
		t.setModel(model);
	}	
	private void postaviModelFilijala(ArrayList lista, JTable t){
		JTableModelFilijala model = new JTableModelFilijala(lista);
		t.setModel(model);
	}	
	private void postaviModelMagacina(ArrayList lista, JTable t){
		JTableModelMagacin model = new JTableModelMagacin(lista);
		t.setModel(model);
	}
	
	private void postaviModelKupac(ArrayList lista, JTable t){
		JTableModelKupac model = new JTableModelKupac(lista);
		t.setModel(model);
	}
	
	private void postaviModelRacunOtpremnica(ArrayList lista, JTable t){
		JTableModelRacunOtpremnica model = new JTableModelRacunOtpremnica(lista);
		t.setModel(model);
	}
	
	private void postaviModelArtikli(ArrayList lista, JTable t){
		JTableModelArtikal model = new JTableModelArtikal(lista);
		t.setModel(model);
	}	
	
	
	private void postaviModelGrupaArtikala(ArrayList lista, JTable t){
		JTableModelGrupeArtikala model = new JTableModelGrupeArtikala(lista);
		t.setModel(model);
	}
	private void postaviModelProdajneCeneArtikla(ArrayList lista, JTable t){
		JTableModelProdajnaCenaArtikla model = new JTableModelProdajnaCenaArtikla(lista);
		t.setModel(model);
	}
	private void postaviModelStavkeProdaje(ArrayList lista, JTable t){
		JTableModelStavkeRacunaOtpremnice model = new JTableModelStavkeRacunaOtpremnice(lista);
		t.setModel(model);
	}
	private void postaviModelIzvestajProdajePoArtiklu (ArrayList lista, JTable t){
		JTableModelProdajaPoFilijali model = new JTableModelProdajaPoFilijali(lista);
		t.setModel(model);
	}
	private void postaviModelIzvestajProdajePoKupcu (ArrayList lista, JTable t){
		JTableModelProdajaPoKupacu model = new JTableModelProdajaPoKupacu(lista);
		t.setModel(model);
	}
	private void postaviModelProdajaPoZaposlenom(ArrayList<Izvestaj> lista, JTable t){
		 JTableModelProdajaPoZaposlenom model = new  JTableModelProdajaPoZaposlenom(lista);
		t.setModel(model);
	}
	private  void removeSelectedFromTable(JTable from){
        int[] rows = from.getSelectedRows();
        TableModel tm = (DefaultTableModel) from.getModel();


        for (int row : rows) {
            ((DefaultTableModel) tm).removeRow(from.convertRowIndexToModel(row));
        }

        from.clearSelection();
	}
}