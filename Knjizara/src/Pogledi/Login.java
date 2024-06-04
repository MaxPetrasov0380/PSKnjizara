package Pogledi;


import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class Login extends JFrame {

	static Zajednicko.Helper Helper = new Zajednicko.Helper();
		
	
	private JPanel contentPane;
	private JTextField txtUsername;
	private JPasswordField txtPassword;
	public int ID;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
					Login  CW =  (Login) Helper.CenterWindow(frame);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void initComponents() {

		setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 467, 589);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JLabel welcomeLogo = new JLabel("");
		welcomeLogo.setIcon(new ImageIcon(Login.class.getResource("/Resursi/loginwelcome.png")));
		welcomeLogo.setFont(new Font("Tahoma", Font.BOLD, 20));
		welcomeLogo.setForeground(Color.DARK_GRAY);
		welcomeLogo.setHorizontalAlignment(SwingConstants.CENTER);
		welcomeLogo.setBounds(0, 0, 453, 99);
		contentPane.add(welcomeLogo);
		
		JLabel usernameLbl = new JLabel("Korisničko ime");
		usernameLbl.setBackground(new Color(128, 0, 0));
		usernameLbl.setFont(new Font("Arial", Font.BOLD, 14));
		usernameLbl.setHorizontalAlignment(SwingConstants.CENTER);
		usernameLbl.setBounds(161, 160, 135, 17);
		contentPane.add(usernameLbl);
		
		JLabel passwordLbl = new JLabel("Šifra");
		passwordLbl.setFont(new Font("Arial", Font.BOLD, 14));
		passwordLbl.setHorizontalAlignment(SwingConstants.CENTER);
		passwordLbl.setBounds(161, 208, 135, 17);
		contentPane.add(passwordLbl);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(161, 225, 147, 18);
		contentPane.add(txtPassword);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(161, 179, 147, 18);
		contentPane.add(txtUsername);
		txtUsername.setColumns(10);
		
				
		
		JButton loginBtn = new JButton("PRIJAVI SE");
		loginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					 
				Connection connect = Helper.getConnection();
				
				String username = txtUsername.getText();
			      char[] password = txtPassword.getPassword();
			      String pw = "";
			      for(int i = 0; i < password.length; i++ ) {
			    	  pw+=password[i];
			      }
				
			      String sql = "SELECT * FROM admins WHERE KorisnickoIme = '"+username+"' AND Sifra = '"+pw+"'";
			      
				try{			      				      				      
				      Statement stm = connect.createStatement();

				      ResultSet rs = stm.executeQuery(sql);			     
					     
					  if(rs.next()) {	
					    	 
						  	ID = rs.getInt("ID");
						     
					    	dispose();
					    	Glavni_Meni GM = new Glavni_Meni();
					    	GM.setVisible(true);
					    	
					    	 
				    	  }
				    	  else {
				    		  JOptionPane.showMessageDialog(null,String.valueOf("Pogrešno korisničko ime ili šifra.\nPokušajte ponovo."));					    	 
				    	  }

					     connect.close();
				    }
					catch(Exception eis){ System.out.println(e);}
				 
			}
		});
		loginBtn.setFont(new Font("Arial", Font.BOLD, 14));
		loginBtn.setBounds(161, 431, 147, 25);
		contentPane.add(loginBtn);
		
		JButton gotoRegisterBtn = new JButton("REGISTRACIJA");
		gotoRegisterBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
		    	Register RegPage = new Register();
		    	RegPage.setVisible(true);
		    	
			}
		});
		gotoRegisterBtn.setFont(new Font("Arial", Font.BOLD, 14));
		gotoRegisterBtn.setBounds(161, 467, 147, 23);
		contentPane.add(gotoRegisterBtn);
		
		JLabel sveskaPozadina = new JLabel("");
		sveskaPozadina.setIcon(new ImageIcon(Login.class.getResource("/Resursi/loginpozadina.jpg")));
		sveskaPozadina.setBounds(10, 116, 443, 413);
		contentPane.add(sveskaPozadina);
		
		
	
	}
	
	public Login() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/Resursi/ikonicaKnjizara.png")));
		setForeground(Color.BLACK);
		setTitle("Prijava");
		setResizable(false);
		initComponents();
		
	}
}