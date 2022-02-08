package controllers;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import models.Invoice;
import models.BookInvoice;

import javax.swing.border.EtchedBorder;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Choice;
import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.TextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.awt.Button;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class PanelSale<bookListInvoice> extends JPanel {
	private JTextField txtInvoiceId;
	private JTextField txtSaleBid;
	private JTextField txtSaleTitle;
	private JTextField txtSalePrice;
	private JTextField txtSubTotal;
	private JTextField txtTotal;
	private JTextField txtPay;
	private JTextField txtBalance;
	private JTable jTable_Sale;
	
	String url = "jdbc:sqlserver://DESKTOP-GFP2NDP\\\\SQLEXPRESS:1433;databaseName=BOOK_STORE;user=sa;password=321";
	public Connection connection=null;
	/**
	 * Create the panel.
	 */
	public PanelSale() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		    connection = DriverManager.getConnection(url);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setBackground(new Color(143, 188, 143));
		inticomponents();
		show_bookInvoice();
	}

	public ArrayList<BookInvoice> bookListInvoice(){
		ArrayList<BookInvoice> bookListInvoice = new ArrayList<>();
		try {
			String 	queryl = "SELECT * FROM sale_detail inner join book on book.Bid = sale_detail.Bid  where Invoice_id = '"+ txtInvoiceId.getText()+ "'" ;
			Statement statement = this.connection.createStatement();
			ResultSet rs = statement.executeQuery(queryl);
			BookInvoice ListInvoices;
			while(rs.next()) {
				ListInvoices = new BookInvoice(rs.getString("Bid"), rs.getString("Title"), rs.getInt("Qty_sale"), rs.getFloat("Price"), rs.getFloat("Subtotal")); 
				bookListInvoice.add(ListInvoices);
			}
		
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showConfirmDialog(null, e);
		}
		return bookListInvoice;
	}
	
	
	// Display data from sql server to JTable 
	public void show_bookInvoice() {
		ArrayList<BookInvoice> Invoices = bookListInvoice();
		DefaultTableModel model = (DefaultTableModel) jTable_Sale.getModel();
		Object[] row = new Object[6];
		for(int i = 0; i < Invoices.size(); i++) {
			row[0] = Invoices.get(i).getbID();
			row[1] = Invoices.get(i).getbTitle();
			row[2] = Invoices.get(i).getbQty();
			row[3] = Invoices.get(i).getbPrice();
			row[4] = Invoices.get(i).getSubtotal();
			model.addRow(row);
		}
		
	}
	
	
	
	private void inticomponents() {
		
		setBorder(new LineBorder(Color.BLACK));
		//setBounds(201, 12, 642, 430);
		setBounds(191, 0, 723, 480);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Sale", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBackground(new Color(176, 196, 222));
		panel.setBounds(10, 8, 393, 216);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblInvoiceId = new JLabel("Invoice ID");
		lblInvoiceId.setBounds(235, 11, 126, 20);
		lblInvoiceId.setForeground(Color.WHITE);
		lblInvoiceId.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel.add(lblInvoiceId);
		
		JLabel lblBookId = new JLabel("Book ID");
		lblBookId.setBounds(10, 11, 59, 20);
		lblBookId.setForeground(Color.WHITE);
		lblBookId.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel.add(lblBookId);
		
		txtInvoiceId = new JTextField();
		txtInvoiceId.setBounds(231, 32, 141, 27);
		panel.add(txtInvoiceId);
		txtInvoiceId.setColumns(10);
		
		
		txtSaleBid = new JTextField();
		txtSaleBid.setBounds(10, 32, 200, 27);
		txtSaleBid.setColumns(10);
		panel.add(txtSaleBid);
		
		
		JList list = new JList();
		list.setBounds(31, 92, 1, 1);
		panel.add(list);
		
		JLabel lblNewLabel_1 = new JLabel("Title");
		lblNewLabel_1.setBounds(10, 58, 54, 20);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Quantity");
		lblNewLabel_1_1.setBounds(10, 104, 73, 20);
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Price");
		lblNewLabel_1_2.setBounds(10, 155, 59, 20);
		lblNewLabel_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel.add(lblNewLabel_1_2);
		
		txtSaleTitle = new JTextField();
		txtSaleTitle.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent even) {
					if(even.getKeyCode() == KeyEvent.VK_ENTER){
						String bTitle = txtSaleTitle.getText();
						try {
							String query = "SELECT * FROM book WHERE Title=?";
							PreparedStatement statement = connection.prepareStatement(query);
							statement.setString(1, txtSaleTitle.getText());
							ResultSet rs = statement.executeQuery();
							if(rs.next()) {
								String setSaleBid = rs.getString("Bid");
								txtSaleBid.setText(setSaleBid);
								String setSaleTitle = rs.getString("Title");
								txtSaleTitle.setText(setSaleTitle);
								String setSalePrice = rs.getString("Price");
								txtSalePrice.setText(setSalePrice);
							}
							else {
								JOptionPane.showConfirmDialog(null, "This book empty in list");
							}
						
						} catch (Exception e2) {
							// TODO: handle exceptions
							JOptionPane.showConfirmDialog(null, e2);
						}
					}
			}
		});
		txtSaleTitle.setBounds(10, 80, 200, 25);
		txtSaleTitle.setColumns(10);
		panel.add(txtSaleTitle);
		
		txtSalePrice = new JTextField();
		txtSalePrice.setBounds(10, 175, 200, 25);
		txtSalePrice.setColumns(10);
		panel.add(txtSalePrice);
		
		JSpinner txtSaleQty = new JSpinner();
		txtSaleQty.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				float saleQty = Integer.parseInt(txtSaleQty.getValue().toString());
				// lấy giá trị từ textfill có kiểu float 
				float SalePrice = Float.parseFloat(txtSalePrice.getText());
				float subtotal = saleQty * SalePrice;
				txtSubTotal.setText(String.valueOf(subtotal));
			}
		});
		txtSaleQty.setBounds(10, 128, 200, 25);
		panel.add(txtSaleQty);
		
		JLabel lblNewLabel_1_3 = new JLabel("Sub Total");
		lblNewLabel_1_3.setBounds(231, 55, 73, 20);
		lblNewLabel_1_3.setForeground(Color.WHITE);
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel.add(lblNewLabel_1_3);
		
		txtSubTotal = new JTextField();
		txtSubTotal.setBounds(232, 77, 140, 28);
		txtSubTotal.setColumns(10);
		panel.add(txtSubTotal);
		
		Choice choice = new Choice();
		choice.setBounds(231, 133, 141, 20);
		panel.add(choice);
		
		JLabel lblNewLabel = new JLabel("Staff ID");
		lblNewLabel.setBounds(239, 111, 87, 17);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		
		// Btn Sale book item
		JButton btnSale = new JButton("Sale ");
		btnSale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String queryCheckIdInvoice = "select id from invoice where id=?";
					String query = "INSERT INTO sale_detail(Createddate, Bid, Qty_sale, Subtotal, Invoice_id) values(?,?,?,?,?)";
					
					PreparedStatement stmck_id = connection.prepareStatement(queryCheckIdInvoice);
					stmck_id.setString(1,txtInvoiceId.getText());
					ResultSet resck_id =  stmck_id.executeQuery();
					if(!resck_id.next()) {
						String queryckid = "INSERT INTO invoice(id) values(?)";
						PreparedStatement stck_id = connection.prepareStatement(queryckid);
						stck_id.setString(1,txtInvoiceId.getText());
						stck_id.executeUpdate();
					}
					
					PreparedStatement statement = connection.prepareStatement(query);
					statement.setDate(1, new Date(System.currentTimeMillis()));
					statement.setString(2, txtSaleBid.getText());
					statement.setInt(3, Integer.parseInt(txtSaleQty.getValue().toString()));
					
					
					String query1 = "SELECT * FROM book WHERE Bid=?";
					PreparedStatement stm = connection.prepareStatement(query1);
					 stm.setString(1, txtSaleBid.getText());
					ResultSet rs =  stm.executeQuery();
					
					int setQty = 0;
					if(rs.next()) {
						String setSaleBid = rs.getString("Bid");
						txtSaleBid.setText(setSaleBid);
						setQty = rs.getInt("Qty");
					}
					
					//Checking Qty of book in stock
					if(setQty <= 0) 
					{
						// create a jframe
				        JFrame frame = new JFrame("JOptionPane showMessageDialog example");

				        JOptionPane.showMessageDialog(frame,
				                "No item stock",
				                "Check book quantity",
				                JOptionPane.ERROR_MESSAGE);
					}
					else 
					{
						// lấy giá trị từ textfill có kiểu float 
						float saleQty = Integer.parseInt(txtSaleQty.getValue().toString());
						float SalePrice = Float.parseFloat(txtSalePrice.getText());
						float subtotal = saleQty * SalePrice;
						System.out.print("Error .." + subtotal );
						statement.setFloat(4, subtotal);
						statement.setString(5, txtInvoiceId.getText());
						statement.executeUpdate();
						//Refresh JTable after inserting data in Sql server 
						DefaultTableModel model = (DefaultTableModel) jTable_Sale.getModel();
						model.setRowCount(0);
						show_bookInvoice();
						
						float Sum = 0;
						for(int i = 0; i < jTable_Sale.getRowCount(); i++) {
							Sum = Sum + Float.parseFloat(jTable_Sale.getValueAt(i, 4).toString());
						}
						txtTotal.setText(Float.toString(Sum) + "$");
						
						// Reload update data
						String queryupdate = "SELECT * FROM book WHERE Bid=?";
						PreparedStatement stem = connection.prepareStatement(queryupdate);
						stem.setString(1, txtSaleBid.getText());
						ResultSet res =  stm.executeQuery();
						
						int setQty1 = 0;
						if(res.next()) {
							String setSaleBid = res.getString("Bid");
							txtSaleBid.setText(setSaleBid);
							setQty1 = res.getInt("Qty");
						}
						
						int QtyUpdate = setQty1 - Integer.parseInt(txtSaleQty.getValue().toString());
						
						String queryUpdate = "UPDATE book SET Qty=? WHERE Bid=?";
						PreparedStatement st = connection.prepareStatement(queryUpdate);
						st.setInt(1, QtyUpdate);
						st.setString(2, txtSaleBid.getText());
						st.executeUpdate();
						//clear
						clearfield();
					}
					
				} catch (Exception e2) {
					// TODO: handle exceptions
					JOptionPane.showConfirmDialog(null,e2.getMessage());
					
					System.out.print("Error");
				}
			}
		});
		btnSale.setBackground(new Color(255, 255, 255));
		btnSale.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnSale.setForeground(Color.RED);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnSale.setForeground(new Color(0, 128, 128));
			}
			
		});

		btnSale.setForeground(new Color(0, 139, 139));
		btnSale.setBounds(235, 164, 132, 41);
		panel.add(btnSale);
		btnSale.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 230, 393, 239);
		add(scrollPane);
		
		jTable_Sale = new JTable();
		jTable_Sale = new javax.swing.JTable();
		
		jTable_Sale.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"BID","Title", "Qty", "Price", "SubTotal"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class,String.class, Integer.class, Float.class, Float.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				true, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(jTable_Sale);
		
		JPanel panel_Total = new JPanel();
		panel_Total.setBackground(new Color(60, 179, 113));
		panel_Total.setBounds(410, 8, 310, 461);
		add(panel_Total);
		panel_Total.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("TOTAL");
		lblNewLabel_2.setBounds(10, 7, 77, 21);
		panel_Total.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		
		txtTotal = new JTextField();
		txtTotal.setBounds(10, 28, 238, 26);
		panel_Total.add(txtTotal);
		txtTotal.setColumns(10);
		
		JLabel lblNewLabel_2_1 = new JLabel("Pay");
		lblNewLabel_2_1.setBounds(10, 54, 65, 21);
		panel_Total.add(lblNewLabel_2_1);
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		
		txtPay = new JTextField();
		txtPay.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER){
					
					String total = txtTotal.getText();
					String pay = txtPay.getText();
					float balance =Float.parseFloat(pay) - Float.parseFloat(total.replace("$",""));
					txtBalance.setText(String.valueOf(balance)+ "$");
					txtPay.setText(pay + "$");

				}
				
				
			}
		});
		txtPay.setBounds(10, 77, 238, 26);
		panel_Total.add(txtPay);
		txtPay.setColumns(10);
		
		JLabel lblBalance = new JLabel("Balance");
		lblBalance.setBounds(10, 103, 84, 21);
		panel_Total.add(lblBalance);
		lblBalance.setForeground(Color.WHITE);
		lblBalance.setFont(new Font("Tahoma", Font.BOLD, 17));
		
		txtBalance = new JTextField();
		txtBalance.setBounds(10, 127, 238, 26);
		panel_Total.add(txtBalance);
		txtBalance.setColumns(10);
		
		TextArea txtInvoice = new TextArea("");
		txtInvoice.setBounds(0, 212, 310, 249);
		panel_Total.add(txtInvoice);
		
		Button bntInvoice = new Button("Invoice");
		bntInvoice.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					String query = "UPDATE invoice SET Total=?, Date=?, Pay=?, Balance=? where id=?";
					PreparedStatement statement = connection.prepareStatement(query);
					statement.setFloat(1, Float.parseFloat(txtTotal.getText().replace("$", "")));
					statement.setDate(2, new Date(System.currentTimeMillis()) );
					statement.setFloat(3, Float.parseFloat(txtPay.getText().replace("$", "")));
					statement.setFloat(4, Float.parseFloat(txtBalance.getText().replace("$", "")));
					statement.setString(5, txtInvoiceId.getText());
					statement.executeUpdate();
					
					
					String query_invoice = "SELECT * From invoice Where id = '" + txtInvoiceId.getText() +"'" ;
					Statement stat = connection.createStatement();
					ResultSet res = stat.executeQuery(query_invoice);
					Invoice Invoices = null;
					
					while(res.next()) {
						Invoices = new Invoice(res.getFloat("Total"), res.getFloat("Balance"), res.getFloat("Pay"), res.getDate("Date"), res.getString("id")); 
						System.out.print(res.getFloat("Total"));
					}
				
					
					String 	query2 = "SELECT * FROM sale_detail inner join book on book.Bid = sale_detail.Bid  where Invoice_id = '"+ txtInvoiceId.getText()+ "'" ;
					Statement st = connection.createStatement();
					ResultSet rs = st.executeQuery(query2);
					String detail_item = "";
					
					while(rs.next()) {	
						detail_item += "   "+ rs.getString("Title") +"	   "+rs.getInt("Qty_sale") +"	"+rs.getFloat("Price") +"	  "+rs.getFloat("Subtotal") +"\r\n";					
					}
					
					txtInvoice.setText("		Book Stor\r\n"
							+ "		23 ta quang buu\r\n"
							+ "		quan Hai ba trung\r\n"
							+ "---------------------------------------------------\r\n"
							+ "	  Book Invoice\r\n"
							+ "---------------------------------------------------\r\n"
							+ "   Date:"+ Invoices.getDate() +"\r\n"
							+ "   ID Invoice:"+ Invoices.getInvoice_id() +"\r\n"
							+ "	  \r\n"
							+ "   Items	   Qty	Price	  Subtotal\r\n"
							+ "	  \r\n"
							+ 	  detail_item
							+ "	  \r\n"
							+ "----------------------------------------------------\r\n"
							+ "   Total	: "+ Invoices.getTotal()+"\r\n"
							+ "   Pay	: "+ Invoices.getPay()+"\r\n"
							+ "   Banlance: "+ Invoices.getBalance()+" "
							+ "	  \r\n"
							+ "----------------------------------------------------\r\n"
							+ "----------------------------------------------------\r\n"
							+ "                            Thank you come a gain"
							+ "	  \r\n"
							+ "                            Enjoy and gook luck with you"
							+ "	  \r\n"
							+ "	  \r\n" );
					clearfieldInvoice();
					
				}catch(Exception e1){
					System.out.print(e1.getMessage());
				}
			}
		});
		bntInvoice.setBounds(10, 172, 114, 34);
		panel_Total.add(bntInvoice);
		bntInvoice.setForeground(new Color(0, 128, 128));
		bntInvoice.setFont(new Font("Dialog", Font.BOLD, 16));
		
		Button bntPrint = new Button("Print");
		bntPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearFieldPrint();		
			}
		});
		bntPrint.setForeground(new Color(0, 128, 128));
		bntPrint.setFont(new Font("Dialog", Font.BOLD, 16));
		bntPrint.setBounds(134, 172, 114, 34);
		panel_Total.add(bntPrint);
		
		
	}
	
	public void clearfield() {
		txtSaleBid.setText("");
		txtSaleTitle.setText("");
		txtSalePrice.setText("");
		//txtInvoiceId.setText("");
		txtSubTotal.setText("");
		
	}
	
	public void clearfieldInvoice() {
		DefaultTableModel model = (DefaultTableModel) jTable_Sale.getModel();
		txtInvoiceId.setText("");
		
		model.setRowCount(0);
		clearfield();
	}
	
	public void clearFieldPrint() {
		txtTotal.setText("");
		txtPay.setText("");
		txtBalance.setText("");
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
