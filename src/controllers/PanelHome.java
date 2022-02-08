package controllers;


import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.border.LineBorder;
import java.awt.Component;

public class PanelHome extends JPanel  {

	private Image pic;

	private Image img_Store = new ImageIcon(PanelHome.class.getResource("/res/LogoPerson.png")).getImage().getScaledInstance(300, 200, Image.SCALE_SMOOTH); 
	
	public PanelHome() {
		setBackground(new Color(0, 128, 128));
		//setBounds(201, 12, 591, 430);
		//setBounds(191, 0, 748, 452);
		setBounds(300, 0, 789, 452);
	
		setLayout(null);
		JLabel lblIconBookStore = new JLabel("");
		lblIconBookStore.setForeground(new Color(0, 128, 128));
		lblIconBookStore.setBounds(300, 80, 285, 255);
		lblIconBookStore.setAlignmentX(Component.RIGHT_ALIGNMENT);
		lblIconBookStore.setAlignmentY(Component.TOP_ALIGNMENT);
		lblIconBookStore.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconBookStore.setBackground(new Color(0, 128, 128));
		lblIconBookStore.setIcon(new ImageIcon(img_Store));
		add(lblIconBookStore);
		
		JLabel lblNewLabel = new JLabel("WELCOME ");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("NSimSun", Font.BOLD | Font.ITALIC, 43));
		lblNewLabel.setBounds(78, 31, 184, 70);
		add(lblNewLabel);
		
		JLabel lblMyBookStore = new JLabel("TO ");
		lblMyBookStore.setForeground(new Color(0, 191, 255));
		lblMyBookStore.setFont(new Font("NSimSun", Font.BOLD | Font.ITALIC, 70));
		lblMyBookStore.setBounds(111, 98, 111, 70);
		add(lblMyBookStore);
		
		JLabel lblStore = new JLabel("STORE");
		lblStore.setForeground(Color.WHITE);
		lblStore.setFont(new Font("NSimSun", Font.BOLD | Font.ITALIC, 60));
		lblStore.setBounds(78, 262, 184, 98);
		add(lblStore);
		
		JLabel lblMyBook = new JLabel("MY BOOK");
		lblMyBook.setForeground(Color.WHITE);
		lblMyBook.setFont(new Font("NSimSun", Font.BOLD | Font.ITALIC, 42));
		lblMyBook.setBounds(78, 179, 184, 70);
		add(lblMyBook);
		setVisible(true);
	}
	
	
	
	public static void main(String[] args)
    {
     
//		JFrame frame = new JFrame();
//		PanelHome pic = new PanelHome();
//		frame.setSize(365,395);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.getContentPane().add(pic);
//		frame.setLocationRelativeTo(null);
//		frame.setVisible(true);
    }
}
