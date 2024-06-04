package Pogledi;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Zajednicko.CRUD_Ops;
import Zajednicko.Helper;
import Zajednicko.HelperPrikaz;
import javax.swing.JSeparator;
import javax.swing.border.LineBorder;

public class Inventar extends JFrame {

	private JPanel contentPane;
	private JTextField txtNaziv;
	private JTextField txtKolicina;
	private JTextField txtProizvodjac;
	private JTextField txtCena;
	
	static Helper Helper = new Helper();
	HelperPrikaz HelperP = new HelperPrikaz();
	private CRUD_Ops CRUD = new CRUD_Ops();
	private JTable table;
	private JTextField invisibleTxtID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inventar frame = new Inventar();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public Inventar() {
		initComponents();
		CRUD_Ops.prikaz(table);
	}
	
	
		private void initComponents() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Inventar.class.getResource("/Resursi/ikonicaKnjizara.png")));
		setTitle("Inventar");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1280, 690);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBounds(0, 0, 1440, 900);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel kolicinaLbl = new JLabel("Količina");
		kolicinaLbl.setForeground(Color.WHITE);
		kolicinaLbl.setFont(new Font("Times New Roman", Font.BOLD, 15));
		kolicinaLbl.setBounds(32, 147, 75, 13);
		panel.add(kolicinaLbl);
		
		JLabel proizLbl = new JLabel("Proizvođač");
		proizLbl.setForeground(Color.WHITE);
		proizLbl.setFont(new Font("Times New Roman", Font.BOLD, 15));
		proizLbl.setBounds(32, 172, 100, 13);
		panel.add(proizLbl);
		
		JLabel cenaLbl = new JLabel("Cena");
		cenaLbl.setForeground(Color.WHITE);
		cenaLbl.setFont(new Font("Times New Roman", Font.BOLD, 15));
		cenaLbl.setBounds(32, 197, 75, 13);
		panel.add(cenaLbl);
		
		JLabel nazivLbl = new JLabel("Naziv");
		nazivLbl.setForeground(Color.WHITE);
		nazivLbl.setFont(new Font("Times New Roman", Font.BOLD, 15));
		nazivLbl.setBounds(32, 121, 75, 13);
		panel.add(nazivLbl);
		
		JLabel napomenaLbl = new JLabel("Napomena: Sva polja moraju biti popunjena!");
		napomenaLbl.setFont(new Font("Tahoma", Font.PLAIN, 16));
		napomenaLbl.setForeground(Color.WHITE);
		napomenaLbl.setBounds(20, 85, 350, 20);
		panel.add(napomenaLbl);
		
		txtNaziv = new JTextField();
		txtNaziv.setBounds(142, 121, 186, 19);
		panel.add(txtNaziv);
		txtNaziv.setColumns(10);
		
		txtKolicina = new JTextField();
		txtKolicina.setBounds(142, 147, 186, 19);
		panel.add(txtKolicina);
		txtKolicina.setColumns(10);
		
		txtProizvodjac = new JTextField();
		txtProizvodjac.setBounds(142, 172, 186, 19);
		panel.add(txtProizvodjac);
		txtProizvodjac.setColumns(10);
		
		txtCena = new JTextField();
		txtCena.setBounds(142, 197, 186, 19);
		panel.add(txtCena);
		txtCena.setColumns(10);

		
		JButton nazadBtn = new JButton("N A Z A D");
		nazadBtn.setToolTipText("Povratak na glavni meni.");
		nazadBtn.setBackground(new Color(92, 92, 92));
		nazadBtn.setForeground(Color.WHITE);
		nazadBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Glavni_Meni GM = new Glavni_Meni();
				GM.setVisible(true);
			}
		});
		nazadBtn.setFont(new Font("Arial", Font.BOLD, 15));
		nazadBtn.setBounds(10, 550, 146, 21);
		panel.add(nazadBtn);
		
		JButton dodajBtn = new JButton("D O D A J");
		dodajBtn.setToolTipText("Dodaj robu u bazu podataka.");
		dodajBtn.setBackground(new Color(92, 92, 92));
		dodajBtn.setForeground(Color.WHITE);
		dodajBtn.setFont(new Font("Arial", Font.BOLD, 15));
		dodajBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					try
					{
						CRUD_Ops.Dodaj(txtNaziv.getText(), txtKolicina.getText(), txtProizvodjac.getText(), txtCena.getText());
					}
					catch(Exception ex) {
						JOptionPane.showMessageDialog(null, ex.getMessage());
					}
					CRUD_Ops.prikaz(table);
					
					txtNaziv.setText("");
					txtProizvodjac.setText("");
					txtKolicina.setText("");
					txtCena.setText("");
			}
		});
		dodajBtn.setBounds(10, 280, 145, 21);
		panel.add(dodajBtn);
		
		JButton izmeniBtn = new JButton("I Z M E N I ");
		izmeniBtn.setToolTipText("Izmeni podatke o robi.");
		izmeniBtn.setBackground(new Color(92, 92, 92));
		izmeniBtn.setForeground(Color.WHITE);
		izmeniBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try 
				{
					CRUD_Ops.Izmeni(txtNaziv.getText(), txtKolicina.getText(), txtProizvodjac.getText(), txtCena.getText(), invisibleTxtID.getText());
							
				} catch (Exception e1) {
					
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
				
				CRUD_Ops.prikaz(table);
				
				txtNaziv.setText("");
				txtProizvodjac.setText("");
				txtKolicina.setText("");
				txtCena.setText("");
			}
		});
		izmeniBtn.setFont(new Font("Arial", Font.BOLD, 15));
		izmeniBtn.setBounds(186, 280, 145, 21);
		panel.add(izmeniBtn);
		
		JButton obrisiBtn = new JButton("O B R I Š I");
		obrisiBtn.setToolTipText("Obriši robu iz baze podataka.");
		obrisiBtn.setBackground(new Color(92, 92, 92));
		obrisiBtn.setForeground(Color.WHITE);
		obrisiBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
                    CRUD_Ops.Obrisi(txtNaziv.getText(), txtProizvodjac.getText(), txtKolicina.getText(), txtCena.getText(), invisibleTxtID.getText());
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(null, e1.getMessage());
                }
                
                CRUD_Ops.prikaz(table);
                    
                txtNaziv.setText("");
                txtProizvodjac.setText("");
                txtKolicina.setText("");
                txtCena.setText("");
            
            }
		});
		obrisiBtn.setFont(new Font("Arial", Font.BOLD, 15));
		obrisiBtn.setBounds(10, 324, 145, 21);
		panel.add(obrisiBtn);
		
		JButton ocistiBtn = new JButton("O Č I S T I");
		ocistiBtn.setToolTipText("Očisti polja za unos podataka.");
		ocistiBtn.setBackground(new Color(92, 92, 92));
		ocistiBtn.setForeground(Color.WHITE);
		ocistiBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtNaziv.setText("");
				txtKolicina.setText("");
				txtProizvodjac.setText("");
				txtCena.setText("");
			}
		});
		ocistiBtn.setFont(new Font("Arial", Font.BOLD, 15));
		ocistiBtn.setBounds(187, 324, 145, 21);
		panel.add(ocistiBtn);
		
		JLabel inventarLbl = new JLabel("I N V E N T A R");
		inventarLbl.setForeground(Color.ORANGE);
		inventarLbl.setIcon(null);
		inventarLbl.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 32));
		inventarLbl.setBounds(42, 33, 312, 41);
		panel.add(inventarLbl);
		
		JLabel inventarLblBack = new JLabel("I N V E N T A R");
		inventarLblBack.setForeground(Color.BLACK);
		inventarLblBack.setIcon(null);
		inventarLblBack.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 32));
		inventarLblBack.setBounds(39, 30, 312, 41);
		panel.add(inventarLblBack);
		
		JScrollPane prikazInventara = new JScrollPane();
		prikazInventara.setToolTipText("Prikaz podataka iz baze.");
		prikazInventara.setViewportBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		prikazInventara.setBounds(354, 24, 900, 590);
		panel.add(prikazInventara);
		
		table = new JTable();
		prikazInventara.setViewportView(table);
		
		invisibleTxtID = new JTextField();
		invisibleTxtID.setBounds(142, 223, 86, 20);
		panel.add(invisibleTxtID);
		invisibleTxtID.setVisible(false);
		invisibleTxtID.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 105, 334, 2);
		panel.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 254, 334, 2);
		panel.add(separator_1);
		
		JPanel unosPodatakaPanel = new JPanel();
		unosPodatakaPanel.setBackground(new Color(92, 92, 92));
		unosPodatakaPanel.setBounds(10, 105, 334, 151);
		panel.add(unosPodatakaPanel);
		
		ListSelectionModel rowSelectionModel = table.getSelectionModel();

		rowSelectionModel.addListSelectionListener(new ListSelectionListener() {
		      public void valueChanged(ListSelectionEvent e) {
		        			        
		        ListSelectionModel lsm = (ListSelectionModel)e.getSource();
		        		        
		        if(lsm.isSelectionEmpty()) {
		        	//JOptionPane.showMessageDialog(null, "No Selection");
		        }
		        else {
		        	int selRow = table.getSelectedRow();
		        	String idForEdit = table.getModel().getValueAt(selRow, 0).toString();
		        	String Naziv = table.getModel().getValueAt(selRow, 1).toString();
		        	String Kolicina = table.getModel().getValueAt(selRow, 2).toString();
		        	String Proizvodjac = table.getModel().getValueAt(selRow, 3).toString();
		        	String Cena = table.getModel().getValueAt(selRow, 4).toString();
		        	
		        	txtNaziv.setText(Naziv);
		        	txtProizvodjac.setText(Proizvodjac);
		        	txtKolicina.setText(Kolicina);
					txtCena.setText(Cena);
					invisibleTxtID.setText(idForEdit);
					
		        	JOptionPane.showMessageDialog(null,String.valueOf(idForEdit));
		        }
		      }

		    });
	}
}
