import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Frame;

import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class FrameLogin extends JFrame {

	private Image img_Logo = new ImageIcon(FrameLogin.class.getResource("res/book-icon.png")).getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
	private Image img_Username = new ImageIcon(FrameLogin.class.getResource("res/businessman.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	private Image img_Password = new ImageIcon(FrameLogin.class.getResource("res/padlock.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	private Image img_Login = new ImageIcon(FrameLogin.class.getResource("res/key.jpg")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	private JPanel contentPane;
	private JTextField txtUsername;
	private JPasswordField txtPassword;
	private JLabel lblLoginMessage = new JLabel("");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameLogin frame = new FrameLogin();
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
	public FrameLogin() {
		setBackground(new Color(0, 139, 139));
		getContentPane().setBackground(new Color(0, 128, 128));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 128));
		contentPane.setBorder(new LineBorder(new Color(60, 179, 113), 3));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(299, 8, 1, 1);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(180, 169, 250, 40);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		txtUsername = new JTextField();
		txtUsername.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
			if(txtUsername.getText().equals("Username")) {
				txtUsername.setText("");
			}
			else {
				txtUsername.selectAll();
			}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtUsername.getText().equals("")) {
					txtUsername.setText("Username");
					txtUsername.setText("");
				}
			}
		});
		txtUsername.setBorder(null);
		txtUsername.setFont(new Font("Arial", Font.PLAIN, 12));
		txtUsername.setText("Username");
		txtUsername.setBounds(21, 11, 165, 20);
		panel_1.add(txtUsername);
		txtUsername.setColumns(10);
		
		JLabel lblIconUsername = new JLabel("");
		lblIconUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconUsername.setBounds(213, 0, 37, 40);
		lblIconUsername.setIcon(new ImageIcon(img_Username));
		panel_1.add(lblIconUsername);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(Color.WHITE);
		panel_1_1.setBounds(180, 220, 250, 40);
		contentPane.add(panel_1_1);
		panel_1_1.setLayout(null);
		
		txtPassword = new JPasswordField();
		txtPassword.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtPassword.getText().equals("Password")) {
					txtPassword.setEchoChar('●');
					txtPassword.setText("");
				}
				else {
					txtPassword.selectAll();
				}
				
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtPassword.getText().equals("")) {
					txtPassword.setText("Password");
					txtPassword.setEchoChar((char)0);
				}
			}
		});
		txtPassword.setBorder(null);
		txtPassword.setEchoChar((char)0);
		txtPassword.setText("Password");
		txtPassword.setBounds(20, 11, 166, 18);
		panel_1_1.add(txtPassword);
		
		JLabel lblIconPassword = new JLabel("");
		lblIconPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconPassword.setBounds(213, 0, 37, 40);
		lblIconPassword.setIcon(new ImageIcon(img_Password));
		panel_1_1.add(lblIconPassword);
		
		JPanel pnlBtnLogin = new JPanel();
		pnlBtnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				 if(txtUsername.getText().equals("admin") && txtPassword.getText().equals("admin")) {
					//if input correct username and password
					lblLoginMessage.setText("");
					txtUsername.setText("");
					txtPassword.setText(""); 
					FrameDashboard menu = new FrameDashboard();
					menu.setVisible(true);
					dispose();	
				}
				if(txtUsername.getText().equals("")) {
					if(txtPassword.getText().equals("") ) {
						lblLoginMessage.setText("Please Fill Your Password or Username!!");	
					}
					else {
						lblLoginMessage.setText("Please Fill Your Username ");
					}
				}
			
				else if (txtPassword.getText().equals("") || txtUsername.getText().equals("Username")) {
						lblLoginMessage.setText("Please Fill Your Password ");
				}
				else {
					lblLoginMessage.setText("Username and Password didn't match!");
				}
				

			}
			@Override
			public void mouseEntered(MouseEvent e) {
				pnlBtnLogin.setBackground(new Color(30, 60, 60));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				pnlBtnLogin.setBackground(new Color(47, 79, 79));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				pnlBtnLogin.setBackground(new Color(47, 79, 79));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				pnlBtnLogin.setBackground(new Color(30, 60, 60));
			}
		});
		
		pnlBtnLogin.setBackground(new Color(47, 79, 79));
		pnlBtnLogin.setBounds(180, 316, 250, 50);
		contentPane.add(pnlBtnLogin);
		pnlBtnLogin.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LOG IN");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel.setBounds(104, 15, 86, 18);
		pnlBtnLogin.add(lblNewLabel);
		
		JLabel lblIconLogin = new JLabel("");
		lblIconLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconLogin.setIcon(new ImageIcon(img_Login));
		lblIconLogin.setBounds(48, 11, 46, 29);
		pnlBtnLogin.add(lblIconLogin);
		
		JLabel lblX = new JLabel("X");
		lblX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Are you sure want to close this application", "Comfimation", JOptionPane.YES_NO_OPTION) == 0) {
					FrameLogin.this.dispose();
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblX.setForeground(Color.RED);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblX.setForeground(Color.WHITE);
			}
			
		});
		lblX.setForeground(Color.WHITE);
		lblX.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		lblX.setHorizontalAlignment(SwingConstants.CENTER);
		lblX.setBounds(580, 0, 20, 20);
		contentPane.add(lblX);
		
		JLabel lblIconLogo = new JLabel("");
		lblIconLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconLogo.setBounds(180, 42, 250, 122);
		contentPane.add(lblIconLogo);
		lblIconLogo.setIcon(new ImageIcon(img_Logo));
		
		lblLoginMessage.setFont(new Font("Arial", Font.PLAIN, 12));
		lblLoginMessage.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoginMessage.setForeground(new Color(139, 0, 0));
		lblLoginMessage.setBounds(180, 280, 250, 14);
		contentPane.add(lblLoginMessage);
		setUndecorated(true);
		setLocationRelativeTo(null);
		
	}
}
