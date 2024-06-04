package Pogledi;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Zajednicko.Helper;
import Zajednicko.HelperPrikaz;

import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.JPasswordField;
import java.awt.Color;
import javax.swing.ImageIcon;

public class Register extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsername;
	private JTextField txtEmail;
	private JPasswordField txtPassword;
	
	static Helper Helper = new Helper();
	HelperPrikaz HelperP = new HelperPrikaz();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register frame = new Register();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public Register() {
		initComponents();
	}
	
	
	public void initComponents() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Register.class.getResource("/Resursi/ikonicaKnjizara.png")));
		setResizable(false);
		setFont(new Font("Times New Roman", Font.BOLD, 15));
		setTitle("Registracija");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 50, 467, 589);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton gotoLoginBtn = new JButton("PRIJAVA");
		gotoLoginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				Login li = new Login();
				li.setBounds(400, 50, 467, 589);
				li.setVisible(true);
				
			}
		});
		gotoLoginBtn.setFont(new Font("Arial", Font.BOLD, 15));
		gotoLoginBtn.setBounds(172, 430, 100, 23);
		contentPane.add(gotoLoginBtn);
		
		JButton registerBtn = new JButton("REGISTRUJ SE");
		registerBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if( txtUsername.getText().equals("") || txtEmail.getText().equals("") ||txtPassword.getText().equals("")) 
				{
					JOptionPane.showMessageDialog(null, "Molimo vas da unesete sve neophodne\nkredencijale za registraciju!");
				}
				else {
					
					
					String Email = txtEmail.getText();
					String KorisnickoIme = txtUsername.getText();
					String Sifra = txtPassword.getText();
					
					Connection conn = Helper.getConnection();
					String query = "INSERT INTO admins( KorisnickoIme, Email, Sifra) VALUES ('"+KorisnickoIme+"', '"+Email+"', '"+Sifra+"')";
					
					try {
						java.sql.Statement stm = conn.createStatement();
						stm.execute(query);
					}
					catch(Exception be){
							be.printStackTrace();
					}
					
					JOptionPane.showMessageDialog(null, "Registracija uspešna!");
				}
			
				txtUsername.setText("");
				txtEmail.setText("");
				txtPassword.setText("");
				
				
				dispose();
				Login li = new Login();
				li.setBounds(400, 50, 467, 589);
				li.setVisible(true);
				
			}
		});
		registerBtn.setFont(new Font("Arial", Font.BOLD, 15));
		registerBtn.setBounds(123, 380, 193, 23);
		contentPane.add(registerBtn);
		
		JLabel registerLbl = new JLabel("R E G I S T R A C I J A");
		registerLbl.setFont(new Font("Consolas", Font.BOLD, 15));
		registerLbl.setBounds(125, 16, 237, 14);
		contentPane.add(registerLbl);
		
		JLabel credTxt = new JLabel("Molimo vas da unesete sve neophodne");
		credTxt.setFont(new Font("Arial", Font.PLAIN, 11));
		credTxt.setBounds(120, 66, 378, 23);
		contentPane.add(credTxt);
		
		JLabel credTxt_1 = new JLabel("kredencijale za registraciju!");
		credTxt_1.setFont(new Font("Arial", Font.PLAIN, 11));
		credTxt_1.setBounds(120, 77, 268, 29);
		contentPane.add(credTxt_1);
		
		JLabel usernameLbl = new JLabel("Korisničko ime");
		usernameLbl.setBounds(136, 128, 133, 14);
		contentPane.add(usernameLbl);
		
		txtUsername = new JTextField();
		txtUsername.setColumns(10);
		txtUsername.setBounds(136, 144, 161, 20);
		contentPane.add(txtUsername);
		
		JLabel passLbl = new JLabel("Šifra");
		passLbl.setBounds(136, 221, 143, 14);
		contentPane.add(passLbl);
		
		JLabel mailLbl = new JLabel("Email adresa");
		mailLbl.setBounds(136, 175, 133, 14);
		contentPane.add(mailLbl);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(136, 190, 161, 20);
		contentPane.add(txtEmail);
		
		JButton regExitBtn = new JButton("IZLAZ");
		regExitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
			}
		});
		regExitBtn.setFont(new Font("Arial", Font.BOLD, 15));
		regExitBtn.setBounds(172, 464, 100, 23);
		contentPane.add(regExitBtn);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(136, 236, 161, 20);
		contentPane.add(txtPassword);
		
		JLabel sveskaPozadina = new JLabel("");
		sveskaPozadina.setIcon(new ImageIcon(Register.class.getResource("/Resursi/loginpozadina.jpg")));
		sveskaPozadina.setBounds(0, 0, 453, 551);
		contentPane.add(sveskaPozadina);
	}

}
