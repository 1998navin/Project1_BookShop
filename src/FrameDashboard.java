

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;

import controllers.PanelBook;
import controllers.PanelHistory;
import controllers.PanelHome;
import controllers.PanelManager;
import controllers.PanelSale;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Frame;

public class FrameDashboard extends JFrame {
	
	private JPanel contentPane;
	private Image img_Logo = new ImageIcon(FrameLogin.class.getResource("res/book-icon.png")).getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH); 
    private Image img_home = new ImageIcon(FrameLogin.class.getResource("res/home.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
    private Image img_book = new ImageIcon(FrameLogin.class.getResource("res/book.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
    private Image img_bill = new ImageIcon(FrameLogin.class.getResource("res/bill.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
    private Image img_manger = new ImageIcon(FrameLogin.class.getResource("res/manager.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
    private Image img_history = new ImageIcon(FrameLogin.class.getResource("res/history.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
    private Image img_signout = new ImageIcon(FrameLogin.class.getResource("res/logout.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
   
    private PanelHome panelHome;
    private PanelBook panelBook ;
    private PanelSale panelSale;
    private PanelManager panelManager;
    private PanelHistory panelHistory;
    
    
    
 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameDashboard frame = new FrameDashboard();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrameDashboard() {
		
;
        setExtendedState(Frame.NORMAL);
		setBackground(new Color(47, 79, 79));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(242, 11, 861, 452);
		setBounds(191, 0, 915, 474);
		setUndecorated(true);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setSize(700,500);
		contentPane.setBackground(new Color(0, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBounds(200, 100, 150, 200);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		////////////////////////////
		panelHome = new PanelHome();
		panelHome.setSize(724, 474);
		panelHome.setLocation(0, 0);

		
		panelBook = new PanelBook();
		panelBook.setSize(724, 474);
		panelBook.setLocation(0, 0);
		
		panelSale = new PanelSale();
		panelSale.setSize(724, 474);
		panelSale.setLocation(0, 0);
		
		panelManager = new PanelManager();
		panelManager.setSize(724, 474);
		panelManager.setLocation(0, 0);
		
		panelHistory = new PanelHistory();
		panelHistory.setSize(724, 474);
		panelHistory.setLocation(0, 0);
		
		
		
		
		JPanel paneMenu = new JPanel();
		paneMenu.setBounds(0, 0, 191, 474);
		paneMenu.setBackground(new Color(47, 79, 79));
		contentPane.add(paneMenu);
		paneMenu.setLayout(null);
		
		JLabel lblIconLogoBook = new JLabel("");
		lblIconLogoBook.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconLogoBook.setBounds(26, 4, 135, 126);
		lblIconLogoBook.setIcon(new ImageIcon(img_Logo));
		paneMenu.add(lblIconLogoBook);
		
		JPanel paneHome = new JPanel();
		paneHome.addMouseListener(new PanelButtonMouseAdapter(paneHome) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(panelHome);
//				FrameLogin frameLogin = new FrameLogin();
//				frameLogin.setVisible(true);
//			    FrameDashboard.this.dispose();
			}
		});
		paneHome.setBackground(new Color(47, 79, 79));
		paneHome.setForeground(new Color(0, 139, 139));
		paneHome.setBounds(0, 149, 191, 48);
		paneMenu.add(paneHome);
		paneHome.setLayout(null);
		
		JLabel lblHome = new JLabel("HOME");
		lblHome.setHorizontalAlignment(SwingConstants.LEFT);
		lblHome.setForeground(new Color(255, 255, 255));
		lblHome.setFont(new Font("Dialog", Font.BOLD, 14));
		lblHome.setBounds(68, 11, 123, 26);
		paneHome.add(lblHome);
		
		JLabel lblIconHome = new JLabel("");
		lblIconHome.setBounds(10, 0, 46, 48);
		lblIconHome.setIcon(new ImageIcon(img_home));
		paneHome.add(lblIconHome);
		
		JPanel paneBook = new JPanel();
		paneBook.addMouseListener(new PanelButtonMouseAdapter(paneBook) {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelBook.show_books();
				menuClicked(panelBook);
			}
		});
		paneBook.setBackground(new Color(47, 79, 79));
		paneBook.setForeground(new Color(0, 139, 139));
		paneBook.setBounds(-1, 195, 192, 48);
		paneMenu.add(paneBook);
		paneBook.setLayout(null);
		
		JLabel lblBook = new JLabel("BOOK ");
		lblBook.setHorizontalAlignment(SwingConstants.LEFT);
		lblBook.setForeground(Color.WHITE);
		lblBook.setFont(new Font("Dialog", Font.BOLD, 14));
		lblBook.setBounds(68, 11, 123, 26);
		paneBook.add(lblBook);
		
		JLabel lblIconBook = new JLabel("");
		lblIconBook.setBounds(10, 0, 46, 48);
		lblIconBook.setIcon(new ImageIcon(img_book));
		paneBook.add(lblIconBook);
		
		JPanel paneSale = new JPanel();
		paneSale.addMouseListener(new PanelButtonMouseAdapter(paneSale) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(panelSale);
			}
		}
		
		);
		paneSale.setBackground(new Color(47, 79, 79));
		paneSale.setForeground(new Color(0, 139, 139));
		paneSale.setBounds(-1, 243, 192, 48);
		paneMenu.add(paneSale);
		paneSale.setLayout(null);
		
		JLabel lblSale = new JLabel("SALE");
		lblSale.setHorizontalAlignment(SwingConstants.LEFT);
		lblSale.setForeground(Color.WHITE);
		lblSale.setFont(new Font("Dialog", Font.BOLD, 15));
		lblSale.setBounds(68, 11, 123, 26);
		paneSale.add(lblSale);
		
		JLabel lblIconSale = new JLabel("");
		lblIconSale.setBounds(10, 0, 46, 48);
		lblIconSale.setIcon(new ImageIcon(img_bill));
		paneSale.add(lblIconSale);
		
		JPanel paneManager = new JPanel();
		paneManager.addMouseListener(new PanelButtonMouseAdapter(paneManager) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(panelManager);
			}
		}
		
		);
		paneManager.setBackground(new Color(47, 79, 79));
		paneManager.setForeground(new Color(0, 139, 139));
		paneManager.setBounds(0, 291, 191, 48);
		paneMenu.add(paneManager);
		paneManager.setLayout(null);
		
		JLabel lblManager = new JLabel("MANAGER");
		lblManager.setHorizontalAlignment(SwingConstants.LEFT);
		lblManager.setForeground(Color.WHITE);
		lblManager.setFont(new Font("Dialog", Font.BOLD, 14));
		lblManager.setBounds(66, 9, 125, 26);
		paneManager.add(lblManager);
		
		JLabel lblIconManager = new JLabel("");
		lblIconManager.setBounds(10, 0, 46, 48);
		lblIconManager.setIcon(new ImageIcon(img_manger));
		paneManager.add(lblIconManager);
		
		JPanel paneHistory = new JPanel();
		paneHistory.addMouseListener(new PanelButtonMouseAdapter(paneHistory) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(panelHistory);
				
			}
		});
		paneHistory.setBackground(new Color(47, 79, 79));
		paneHistory.setForeground(new Color(0, 139, 139));
		paneHistory.setBounds(0, 338, 191, 48);
		paneMenu.add(paneHistory);
		paneHistory.setLayout(null);
		
		JLabel lblHistory = new JLabel("HISTORY");
		lblHistory.setHorizontalAlignment(SwingConstants.LEFT);
		lblHistory.setForeground(Color.WHITE);
		lblHistory.setFont(new Font("Dialog", Font.BOLD, 14));
		lblHistory.setBounds(68, 11, 123, 26);
		paneHistory.add(lblHistory);
		
		JLabel lblIconHistory = new JLabel("");
		lblIconHistory.setBounds(10, 0, 46, 48);
		lblIconHistory.setIcon(new ImageIcon(img_history));
		paneHistory.add(lblIconHistory);
		
		JPanel paneSignOut = new JPanel();
		paneSignOut.addMouseListener(new PanelButtonMouseAdapter(paneSignOut) {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null,"Are you sure to sign out") == 0) {
					FrameLogin frameLogin = new FrameLogin();
					frameLogin.setVisible(true);
				    FrameDashboard.this.dispose();
				}
				
			}
		});
		paneSignOut.setBackground(new Color(47, 79, 79));
		paneSignOut.setForeground(new Color(0, 139, 139));
		paneSignOut.setBounds(-1, 386, 192, 50);
		paneMenu.add(paneSignOut);
		paneSignOut.setLayout(null);
		//paneSignOut.setLayout(null);
		
		JLabel lblSignOut = new JLabel("SIGN OUT");
		lblSignOut.setHorizontalAlignment(SwingConstants.LEFT);
		lblSignOut.setForeground(Color.WHITE);
		lblSignOut.setFont(new Font("Dialog", Font.BOLD, 14));
		lblSignOut.setBounds(68, 10, 123, 19);
		paneSignOut.add(lblSignOut);
		
		JLabel lblIconSignout = new JLabel("");
		lblIconSignout.setBounds(10, 10, 30, 30);
		lblIconSignout.setIcon(new ImageIcon(img_signout));
		paneSignOut.add(lblIconSignout);
		
		//////////////////////////////////////
		JPanel panelMainContent = new JPanel();
		//panelMainContent.setBounds(191, 0, 782, 452); //////////////////////////
		panelMainContent.setBounds(191, 0, 724, 474);
		contentPane.add(panelMainContent);
		panelMainContent.setLayout(null);
		
		
		panelMainContent.add(panelHome);
		//panelHome.setLayout(null);
		panelMainContent.add(panelBook);
		//panelBook.setLayout(null);
		panelMainContent.add(panelSale);
		//panelBill.setLayout(null);
		panelMainContent.add(panelManager);
		//panelManager.setLayout(null);
		panelMainContent.add(panelHistory);
		//panelHistory.setLayout(null);
		
		menuClicked(panelHome);
		
		JLabel lblExit = new JLabel("X");
		lblExit.setBounds(704, 0, 20, 20);
		panelHome.add(lblExit);
		lblExit.setHorizontalAlignment(SwingConstants.CENTER);
		lblExit.setForeground(Color.WHITE);
		lblExit.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		lblExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Are you sure want to close this application", "Comfimation", JOptionPane.YES_NO_OPTION) == 0) {
					FrameDashboard.this.dispose();
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblExit.setForeground(Color.RED);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblExit.setForeground(Color.WHITE);
			}
			
		});
		
	}
	
	public void menuClicked(JPanel selecJPanel) {
		panelHome.setVisible(false);
		panelBook.setVisible(false);
		panelSale.setVisible(false);
		panelManager.setVisible(false);
		panelHistory.setVisible(false);
		
		selecJPanel.setVisible(true);
	}
	
	//Menu muose listener
		private class PanelButtonMouseAdapter extends MouseAdapter{	
			JPanel panel;
			public PanelButtonMouseAdapter(JPanel panel) {
				this.panel = panel;
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				panel.setBackground(new Color(112, 128, 144));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel.setBackground(new Color(47, 79, 79));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				panel.setBackground(new Color(60, 179, 113));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				panel.setBackground(new Color(112, 128, 144));		}
		}
}
