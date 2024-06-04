package Pogledi;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JSeparator;

public class Glavni_Meni extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Glavni_Meni frame = new Glavni_Meni();
					frame.setResizable(false);
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
	public Glavni_Meni() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Glavni_Meni.class.getResource("/Resursi/ikonicaKnjizara.png")));
		setResizable(false);
		setFont(new Font("Times New Roman", Font.BOLD, 14));
		setTitle("Knjižara");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 100, 300, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBounds(0, 0, 286, 413);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton radniciBtn = new JButton("R A D N I C I");
		radniciBtn.setToolTipText("Prikaz radnika u knjižari.");
		radniciBtn.setBackground(new Color(92, 92, 92));
		radniciBtn.setForeground(Color.WHITE);
		radniciBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Radnici RD = new Radnici();
				RD.setVisible(true);
			}
		});
		radniciBtn.setFont(new Font("Arial", Font.BOLD, 15));
		radniciBtn.setBounds(88, 74, 124, 21);
		panel.add(radniciBtn);
		
		JButton inventarBtn = new JButton("INVENTAR");
		inventarBtn.setToolTipText("Prikaz inventara knjižare.");
		inventarBtn.setBackground(new Color(92, 92, 92));
		inventarBtn.setForeground(Color.WHITE);
		inventarBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Inventar IN = new Inventar();
				IN.setVisible(true);
			}
		});
		inventarBtn.setFont(new Font("Arial", Font.BOLD, 15));
		inventarBtn.setBounds(88, 109, 124, 21);
		panel.add(inventarBtn);
		
		JButton logoutBtn = new JButton("I Z L O G U J   S E");
		logoutBtn.setBackground(new Color(92, 92, 92));
		logoutBtn.setForeground(Color.WHITE);
		logoutBtn.setFont(new Font("Arial", Font.BOLD, 15));
		logoutBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				IzlogujSe logout = new IzlogujSe();
				logout.setVisible(true);
				logout.setResizable(false);
			}
		});
		logoutBtn.setBounds(43, 352, 198, 21);
		panel.add(logoutBtn);
		
		JLabel radniciIcon = new JLabel("");
		radniciIcon.setIcon(new ImageIcon(Glavni_Meni.class.getResource("/Resursi/radniciicon.png")));
		radniciIcon.setBounds(53, 74, 25, 25);
		panel.add(radniciIcon);
		
		JLabel inventarIcon = new JLabel("");
		inventarIcon.setIcon(new ImageIcon(Glavni_Meni.class.getResource("/Resursi/inventarIcon.png")));
		inventarIcon.setBounds(53, 109, 25, 25);
		panel.add(inventarIcon);
		
		JLabel menuLogo = new JLabel("GLAVNI MENI");
		menuLogo.setForeground(Color.ORANGE);
		menuLogo.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 40));
		menuLogo.setBounds(23, 11, 256, 52);
		panel.add(menuLogo);
		
		JLabel menuLogoBack = new JLabel("GLAVNI MENI");
		menuLogoBack.setForeground(Color.BLACK);
		menuLogoBack.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 40));
		menuLogoBack.setBounds(21, 10, 256, 52);
		panel.add(menuLogoBack);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(Color.BLACK);
		separator.setBounds(23, 61, 238, 2);
		panel.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(Color.BLACK);
		separator_1.setBounds(23, 334, 238, 2);
		panel.add(separator_1);
		
		JLabel appLogo = new JLabel("");
		appLogo.setIcon(new ImageIcon(Glavni_Meni.class.getResource("/Resursi/logoKnjizara.png")));
		appLogo.setBounds(52, 138, 185, 185);
		panel.add(appLogo);
	}
}
