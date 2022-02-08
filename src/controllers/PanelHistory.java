package controllers;


import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class PanelHistory extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelHistory() {
		setBorder(new LineBorder(Color.BLACK));
		// setBounds(201, 12, 642, 430);
		//show_books();
		setBounds(191, 0, 721, 476);
		setLayout(null);
		
		JLabel lblThisHistory = new JLabel("THIS IS HISTORY");
		lblThisHistory.setForeground(new Color(0, 139, 139));
		lblThisHistory.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblThisHistory.setBounds(311, 150, 227, 96);
		add(lblThisHistory);
	}

}
