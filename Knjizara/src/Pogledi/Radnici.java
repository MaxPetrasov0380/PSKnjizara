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

public class Radnici extends JFrame {

	private JPanel contentPane;
	private JTextField txtIme;
	private JTextField txtPrezime;
	private JTextField txtSSB;
	private JTextField txtTelefon;
	private JTextField txtEmail;
	private JTextField txtAdresa;
	private JTable table;
	
	static Helper Helper = new Helper();
	HelperPrikaz HelperP = new HelperPrikaz();
	private CRUD_Ops CRUD = new CRUD_Ops();
	private JTextField txtPTT;
	private JTextField invisibleTxtID;
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Radnici frame = new Radnici();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public Radnici() {
		initComponents();
		CRUD_Ops.PrikazRadnika(table);
	}
	
	private void initComponents() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Radnici.class.getResource("/Resursi/ikonicaKnjizara.png")));
		setTitle("Radnici");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1300, 690);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBounds(0, 0, 1440, 900);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel imeLbl = new JLabel("Ime");
		imeLbl.setForeground(Color.WHITE);
		imeLbl.setFont(new Font("Times New Roman", Font.BOLD, 15));
		imeLbl.setBounds(41, 159, 168, 13);
		panel.add(imeLbl);
		
		JLabel prezimeLbl = new JLabel("Prezime");
		prezimeLbl.setForeground(Color.WHITE);
		prezimeLbl.setFont(new Font("Times New Roman", Font.BOLD, 15));
		prezimeLbl.setBounds(41, 186, 168, 13);
		panel.add(prezimeLbl);
		
		JLabel ssbLbl = new JLabel("Socijalni Sigurnosni Broj");
		ssbLbl.setForeground(Color.WHITE);
		ssbLbl.setBackground(Color.BLACK);
		ssbLbl.setFont(new Font("Times New Roman", Font.BOLD, 15));
		ssbLbl.setBounds(41, 210, 168, 20);
		panel.add(ssbLbl);
		
		JLabel telefonLbl = new JLabel("Broj telefona");
		telefonLbl.setForeground(Color.WHITE);
		telefonLbl.setFont(new Font("Times New Roman", Font.BOLD, 15));
		telefonLbl.setBounds(41, 235, 168, 20);
		panel.add(telefonLbl);
		
		JLabel emailLbl = new JLabel("Email adresa");
		emailLbl.setForeground(Color.WHITE);
		emailLbl.setFont(new Font("Times New Roman", Font.BOLD, 15));
		emailLbl.setBounds(41, 263, 168, 13);
		panel.add(emailLbl);
		
		JLabel adresaLbl = new JLabel("Adresa");
		adresaLbl.setForeground(Color.WHITE);
		adresaLbl.setFont(new Font("Times New Roman", Font.BOLD, 15));
		adresaLbl.setBounds(41, 288, 168, 13);
		panel.add(adresaLbl);
		
		
		txtIme = new JTextField();
		txtIme.setBounds(234, 157, 168, 19);
		panel.add(txtIme);
		txtIme.setColumns(10);
		
		txtPrezime = new JTextField();
		txtPrezime.setBounds(234, 184, 168, 19);
		panel.add(txtPrezime);
		txtPrezime.setColumns(10);
		
		txtSSB = new JTextField();
		txtSSB.setBounds(234, 211, 168, 19);
		panel.add(txtSSB);
		txtSSB.setColumns(10);
		
		txtTelefon = new JTextField();
		txtTelefon.setBounds(234, 236, 168, 19);
		panel.add(txtTelefon);
		txtTelefon.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(234, 261, 168, 19);
		panel.add(txtEmail);
		txtEmail.setColumns(10);
		
		txtAdresa = new JTextField();
		txtAdresa.setBounds(234, 286, 168, 19);
		panel.add(txtAdresa);
		txtAdresa.setColumns(10);
		
		JButton dodajBtn = new JButton("D O D A J");
		dodajBtn.setForeground(Color.WHITE);
		dodajBtn.setBackground(new Color(92, 92, 92));
		dodajBtn.setToolTipText("Dodaj radnika u bazu podataka.");
		dodajBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					try
					{
						CRUD_Ops.DodajRadnika(txtIme.getText(), txtPrezime.getText(), txtTelefon.getText(), txtAdresa.getText(), txtEmail.getText(), txtPTT.getText(), txtSSB.getText());
					}
					catch(Exception ex) {
						JOptionPane.showMessageDialog(null, ex.getMessage());
					}
					CRUD_Ops.PrikazRadnika(table);
					
					txtIme.setText("");
					txtPrezime.setText("");
					txtSSB.setText("");
					txtTelefon.setText("");
					txtEmail.setText("");
					txtAdresa.setText("");
					txtPTT.setText("");
					
		}
});
		dodajBtn.setFont(new Font("Arial", Font.BOLD, 15));
		dodajBtn.setBounds(26, 390, 168, 21);
		panel.add(dodajBtn);
		
		JButton izmeniBtn = new JButton("I Z M E N I");
		izmeniBtn.setForeground(Color.WHITE);
		izmeniBtn.setBackground(new Color(92, 92, 92));
		izmeniBtn.setToolTipText("Izmeni podatke o radniku.");
		izmeniBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try
				{
					CRUD_Ops.IzmeniRadnika(txtIme.getText(), txtPrezime.getText(), txtTelefon.getText(), txtAdresa.getText(), txtEmail.getText(), txtPTT.getText(), txtSSB.getText(), invisibleTxtID.getText());
				}
				catch(Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage());
				}
				CRUD_Ops.PrikazRadnika(table);
				
				txtIme.setText("");
                txtPrezime.setText("");
                txtTelefon.setText("");
                txtAdresa.setText("");
                txtEmail.setText("");
                txtPTT.setText("");
                txtSSB.setText("");
				
			}
		});
		izmeniBtn.setFont(new Font("Arial", Font.BOLD, 15));
		izmeniBtn.setBounds(234, 390, 168, 21);
		panel.add(izmeniBtn);
		
		JButton obrisiBtn = new JButton("O B R I Š I");
		obrisiBtn.setForeground(Color.WHITE);
		obrisiBtn.setBackground(new Color(92, 92, 92));
		obrisiBtn.setToolTipText("Obriši radnika iz baze podataka.");
		obrisiBtn.setFont(new Font("Arial", Font.BOLD, 15));
		
		obrisiBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					CRUD_Ops.ObrisiRadnika(txtIme.getText(), txtPrezime.getText(), txtTelefon.getText(), txtEmail.getText(), txtAdresa.getText(), txtSSB.getText(), txtPTT.getText(), invisibleTxtID.getText());
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
				
				CRUD_Ops.PrikazRadnika(table);
					
				txtIme.setText("");
				txtPrezime.setText("");
				txtSSB.setText("");
				txtTelefon.setText("");
				txtEmail.setText("");
				txtAdresa.setText("");
				txtPTT.setText("");
				
			}
		});
		obrisiBtn.setBounds(26, 426, 168, 21);
		panel.add(obrisiBtn);
		
		JButton ocistiBtn = new JButton("O Č I S T I");
		ocistiBtn.setForeground(Color.WHITE);
		ocistiBtn.setBackground(new Color(92, 92, 92));
		ocistiBtn.setToolTipText("Očisti polja za unos podataka.");
		ocistiBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtIme.setText("");
				txtPrezime.setText("");
				txtSSB.setText("");
				txtTelefon.setText("");
				txtEmail.setText("");
				txtAdresa.setText("");
				txtPTT.setText("");
				
			}
		});
		ocistiBtn.setFont(new Font("Arial", Font.BOLD, 15));
		ocistiBtn.setBounds(234, 426, 168, 21);
		panel.add(ocistiBtn);
		
		JButton nazadBtn = new JButton("N A Z A D");
		nazadBtn.setBackground(new Color(92, 92, 92));
		nazadBtn.setToolTipText("Povratak na glavni meni.");
		nazadBtn.setForeground(Color.WHITE);
		nazadBtn.setFont(new Font("Arial", Font.BOLD, 15));
		nazadBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Glavni_Meni GM = new Glavni_Meni();
				GM.setVisible(true);
			}
		});
		nazadBtn.setBounds(26, 570, 123, 21);
		panel.add(nazadBtn);
		
		JLabel radniciLbl = new JLabel("R A D N I C I");
		radniciLbl.setForeground(Color.ORANGE);
		radniciLbl.setIcon(null);
		radniciLbl.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 40));
		radniciLbl.setBounds(62, 53, 312, 41);
		panel.add(radniciLbl);
		
		JLabel radniciLblBack = new JLabel("R A D N I C I");
		radniciLblBack.setForeground(Color.BLACK);
		radniciLblBack.setIcon(null);
		radniciLblBack.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 40));
		radniciLblBack.setBounds(59, 50, 312, 41);
		panel.add(radniciLblBack);
		
		txtPTT = new JTextField();
		txtPTT.setBounds(234, 312, 168, 20);
		panel.add(txtPTT);
		txtPTT.setColumns(10);
		
		JLabel pttLbl = new JLabel("PTT");
		pttLbl.setForeground(Color.WHITE);
		pttLbl.setFont(new Font("Times New Roman", Font.BOLD, 15));
		pttLbl.setBounds(41, 315, 168, 14);
		panel.add(pttLbl);
		
		JScrollPane prikazRadnika = new JScrollPane();
		prikazRadnika.setViewportBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		prikazRadnika.setToolTipText("Prikaz podataka iz baze.");
		prikazRadnika.setBounds(422, 13, 830, 590);
		panel.add(prikazRadnika);
		
		table = new JTable();
		prikazRadnika.setViewportView(table);
		
		invisibleTxtID = new JTextField();
		invisibleTxtID.setBounds(234, 343, 86, 20);
		panel.add(invisibleTxtID);
		invisibleTxtID.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 374, 400, 2);
		panel.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 143, 400, 2);
		panel.add(separator_1);
		
		JPanel unosPodatakaPanel = new JPanel();
		unosPodatakaPanel.setBackground(new Color(92, 92, 92));
		unosPodatakaPanel.setBounds(10, 143, 400, 230);
		panel.add(unosPodatakaPanel);
		
		JLabel napomenaLbl = new JLabel("Napomena: Sva polja moraju biti popunjena!");
		napomenaLbl.setFont(new Font("Tahoma", Font.PLAIN, 16));
		napomenaLbl.setForeground(Color.WHITE);
		napomenaLbl.setBounds(41, 118, 350, 20);
		panel.add(napomenaLbl);
		invisibleTxtID.setVisible(false);
		
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
                    String Ime = table.getModel().getValueAt(selRow, 1).toString();
                    String Prezime = table.getModel().getValueAt(selRow, 2).toString();
                    String Brojtel = table.getModel().getValueAt(selRow, 3).toString();
                    String Adresa = table.getModel().getValueAt(selRow, 4).toString();
                    String Email = table.getModel().getValueAt(selRow, 5).toString();
                    String PTT = table.getModel().getValueAt(selRow, 6).toString();
                    String SSB = table.getModel().getValueAt(selRow, 7).toString();
                  
                    txtIme.setText(Ime);
                    txtPrezime.setText(Prezime);
                    txtTelefon.setText(Brojtel);
                    txtEmail.setText(Email);
                    txtAdresa.setText(Adresa);
                    txtPTT.setText(PTT);
                    txtSSB.setText(SSB);
                    invisibleTxtID.setText(idForEdit);
		        	JOptionPane.showMessageDialog(null,String.valueOf(idForEdit));
		        }
		      }

		    });
	}
}
