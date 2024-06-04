package Pogledi;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.Toolkit;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class IzlogujSe extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			IzlogujSe dialog = new IzlogujSe();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public IzlogujSe() {
		setForeground(Color.BLACK);
		setBounds(450, 200, 450, 300);
		setTitle("Izloguj se");
		setIconImage(Toolkit.getDefaultToolkit().getImage(IzlogujSe.class.getResource("/Resursi/ikonicaKnjizara.png")));
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(92, 92, 92));
		panel.setBounds(0, 0, 436, 230);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel logoutText = new JLabel("Da li ste sigurni");
		logoutText.setForeground(Color.WHITE);
		logoutText.setFont(new Font("Tahoma", Font.PLAIN, 24));
		logoutText.setBounds(10, 11, 416, 43);
		panel.add(logoutText);
		
		JLabel logoutText_1 = new JLabel("da želite da se izlogujete?");
		logoutText_1.setForeground(Color.WHITE);
		logoutText_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		logoutText_1.setBounds(10, 28, 416, 65);
		panel.add(logoutText_1);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(92, 92, 92));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton yesButton = new JButton("Da");
				yesButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
						Login LI = new Login();
						LI.setBounds(423, 50, 467, 589);
						LI.setVisible(true);
					}
				});
				yesButton.setBackground(Color.DARK_GRAY);
				yesButton.setForeground(Color.WHITE);
				yesButton.setActionCommand("OK");
				buttonPane.add(yesButton);
				getRootPane().setDefaultButton(yesButton);
			}
			{
				JButton noButton = new JButton("Ne");
				noButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
						Glavni_Meni GM = new Glavni_Meni();
						GM.setBounds(500, 100, 300, 450);
						GM.setVisible(true);
						GM.setResizable(false);
					}
				});
				noButton.setBackground(Color.DARK_GRAY);
				noButton.setForeground(Color.WHITE);
				noButton.setActionCommand("Cancel");
				buttonPane.add(noButton);
			}
		}
	}
}
