package controllers;


import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class PanelManager extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelManager() {
		setBorder(new LineBorder(Color.BLACK));
		// setBounds(201, 12, 642, 430);
		//show_books();
		setBounds(191, 0, 721, 476);
		setLayout(null);
		
		
		JLabel lblThisManager = new JLabel("THIS IS MANAGER");
		lblThisManager.setForeground(new Color(0, 0, 0));
		lblThisManager.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblThisManager.setBounds(319, 158, 233, 90);
		add(lblThisManager);

	}

}
