package controllers;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.text.Bidi;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.xml.crypto.Data;

import com.sun.jdi.connect.Connector.SelectedArgument;

import models.Book;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class PanelBook extends JPanel {
	private JTextField txtBid;
	private JTextField txtTitle;
	private JTextField txtQty;
	private JTextField txtPrice;
	private JTextField txtAuthor;
	private JTextField txtPubliser;
	private JTextField txtBidSearch;
	private JTable jTable_Display_book;
	DefaultTableModel model;

	/*Connecting SQL server*/
	String url = "jdbc:sqlserver://DESKTOP-GFP2NDP\\\\SQLEXPRESS:1433;databaseName=BOOK_STORE;user=sa;password=321";
	public 	Connection connection= null;
	/**
	 * Create the panel.
	 */
	public PanelBook() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			connection = DriverManager.getConnection(url);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setBackground(new Color(143, 188, 143));
		intiComponents();
		show_books();
		
	}
	
	
	public ArrayList<Book> bookList() {
		ArrayList<Book> bookList = new ArrayList<>();
		try {
			String queryl = "SELECT * FROM book";
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(queryl);
			Book books;
			while (rs.next()) {
				books = new Book(rs.getString("Bid"), rs.getString("Title"), rs.getInt("Qty"),rs.getFloat("Price"), rs.getString("Author"), rs.getString("Publisher"));
				bookList.add(books);
			}

		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showConfirmDialog(null, e);
		}
		return bookList;
	}

	
	
	// Display data from sql server to JTable
	public void show_books() {
		// Refresh JTable after inserting data in Sql server
		ArrayList<Book> list = bookList();
		DefaultTableModel model = (DefaultTableModel) jTable_Display_book.getModel();
		model.setRowCount(0);
		Object[] row = new Object[6];
		for (int i = 0; i < list.size(); i++) {
			row[0] = list.get(i).getbID();
			row[1] = list.get(i).getbTitle();
			row[2] = list.get(i).getbQty();
			row[3] = list.get(i).getbPrice();
			row[4] = list.get(i).getbAuthor();
			row[5] = list.get(i).getbPublisher();
			model.addRow(row);
		}

	}

	private void intiComponents() {
		setBorder(new LineBorder(Color.BLACK));
		setBounds(191, 0, 721, 476);
		setLayout(null);

		JLabel lblNewLabel = new JLabel("Book Id");
		lblNewLabel.setBounds(7, 43, 65, 24);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		add(lblNewLabel);

		JLabel lblNewLabel_2 = new JLabel("Quantity");
		lblNewLabel_2.setBounds(7, 78, 65, 24);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Price");
		lblNewLabel_3.setBounds(254, 75, 66, 24);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		add(lblNewLabel_3);

		JLabel lblNewLabel_5 = new JLabel("Publisher");
		lblNewLabel_5.setBounds(254, 110, 66, 24);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		add(lblNewLabel_5);

		txtBid = new JTextField();
		txtBid.setBounds(82, 51, 162, 20);
		add(txtBid);
		txtBid.setColumns(10);

		txtTitle = new JTextField();
		txtTitle.setBounds(347, 48, 184, 20);
		txtTitle.setColumns(10);
		add(txtTitle);

		txtQty = new JTextField();
		txtQty.setBounds(84, 82, 160, 20);
		txtQty.setColumns(10);
		add(txtQty);

		txtPrice = new JTextField();
		txtPrice.setBounds(347, 79, 184, 20);
		txtPrice.setColumns(10);
		add(txtPrice);

		txtAuthor = new JTextField();
		txtAuthor.setBounds(82, 117, 162, 20);
		txtAuthor.setColumns(10);
		add(txtAuthor);

		txtPubliser = new JTextField();
		txtPubliser.setBounds(347, 114, 184, 20);
		txtPubliser.setColumns(10);
		add(txtPubliser);

		JLabel lblNewLabel_1 = new JLabel("Enter book title of search");
		lblNewLabel_1.setBounds(7, 175, 189, 24);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		add(lblNewLabel_1);

		JLabel lblNewLabel_3_1 = new JLabel("Title");
		lblNewLabel_3_1.setBounds(254, 43, 66, 24);
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		add(lblNewLabel_3_1);

		JLabel lblNewLabel_2_1 = new JLabel("Author");
		lblNewLabel_2_1.setBounds(7, 113, 65, 24);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		add(lblNewLabel_2_1);

		txtBidSearch = new JTextField();
		txtBidSearch.setBounds(206, 179, 237, 20);
		txtBidSearch.setColumns(10);
		add(txtBidSearch);

		JButton btnSearch = new JButton("SEARCH");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "SELECT * FROM book WHERE Title =?";
					PreparedStatement statement = connection.prepareStatement(query);
					statement.setString(1, txtBidSearch.getText());
					ResultSet rs = statement.executeQuery();
					if (rs.next()) {
						String setBid = rs.getString("Bid");
						txtBid.setText(setBid);
						String setTitle = rs.getString("Title");
						txtTitle.setText(setTitle);
						String setQty = rs.getString("Qty");
						txtQty.setText(setQty);
						String setPrice = rs.getString("Price");
						txtPrice.setText(setPrice);
						String setAuthor = rs.getString("Author");
						txtAuthor.setText(setAuthor);
						String setPublisher = rs.getString("Publisher");
						txtPubliser.setText(setPublisher);
					} else {
						JOptionPane.showConfirmDialog(null, "This book id empty in list");
					}

				} catch (Exception e2) {
					// TODO: handle exceptions
					JOptionPane.showConfirmDialog(null, e2);
				}
			}
		});
		btnSearch.setBackground(new Color(192, 192, 192));
		btnSearch.setBounds(453, 178, 117, 23);
		add(btnSearch);

		// Save Button
		JButton btnSave = new JButton("SAVE");
		btnSave.addActionListener(new ActionListener() {
			// private JLabel Bid;

			public void actionPerformed(ActionEvent e) {
				if (txtBid.getText().equals("") || txtTitle.getText().equals("") || txtQty.getText().equals("")
						|| txtPrice.getText().equals("") || txtAuthor.getText().equals("")
						|| txtPubliser.getText().equals("")) {
					JOptionPane.showConfirmDialog(null, "Please Fill Complete Information");

				}

				else {
					try {
						String query = "INSERT INTO book(Bid, Title, Qty, Price, Author, Publisher) values(?,?,?,?,?,?)";
						PreparedStatement statement = connection.prepareStatement(query);

						statement.setString(1, txtBid.getText());
						statement.setString(2, txtTitle.getText());
						statement.setString(3, txtQty.getText());
						statement.setString(4, txtPrice.getText());
						statement.setString(5, txtAuthor.getText());
						statement.setString(6, txtPubliser.getText());
						statement.executeUpdate();
						show_books();
						clearTextFild();
						JOptionPane.showInternalMessageDialog(null, "Insert data Successfully!");

					} catch (Exception e2) {
						// TODO: handle exceptions
						JOptionPane.showConfirmDialog(null, e2);
					}

				}
			}
		});
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSave.setBounds(570, 43, 84, 34);
		add(btnSave);

		// Edit Button
		JButton btnEdit = new JButton("EDIT");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (txtBid.getText().equals("") || txtTitle.getText().equals("") || txtQty.getText().equals("")
						|| txtPrice.getText().equals("") || txtAuthor.getText().equals("")
						|| txtPubliser.getText().equals("")) {
					JOptionPane.showConfirmDialog(null, "Please Fill Complete Information");

				}

				else {
					try {
						int row = jTable_Display_book.getSelectedRow();
						String value = (jTable_Display_book.getModel().getValueAt(row, 0).toString());
						String query = "UPDATE book SET Title=?, Qty=?, Price=?, Author=?, Publisher=? WHERE Bid=?";
						PreparedStatement statement = connection.prepareStatement(query);
						statement.setString(1, txtTitle.getText());
						statement.setString(2, txtQty.getText());
						statement.setString(3, txtPrice.getText());
						statement.setString(4, txtAuthor.getText());
						statement.setString(5, txtPubliser.getText());
						statement.setString(6, txtBid.getText());
						statement.executeUpdate();

						// Refresh JTable after inserting data in Sql server
						DefaultTableModel model = (DefaultTableModel) jTable_Display_book.getModel();
						model.setRowCount(0);
						show_books();
						clearTextFild();
						connection.close();
						JOptionPane.showInternalMessageDialog(null, "Update Successfully!");

					} catch (Exception e2) {
						// TODO: handle exception
						JOptionPane.showConfirmDialog(null, "Update Unsuccessfull!!!!!!!");
					}
				}

			}
		});
		btnEdit.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnEdit.setBounds(570, 88, 84, 34);
		add(btnEdit);

		// Delete Button
		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int row = jTable_Display_book.getSelectedRow();
					String value = (jTable_Display_book.getModel().getValueAt(row, 0).toString());

					PreparedStatement statement = connection.prepareStatement("DELETE FROM book where Bid = ?");
					statement.setString(1, value);
					boolean result = statement.execute();

					DefaultTableModel model = (DefaultTableModel) jTable_Display_book.getModel();
					model.setRowCount(0);
					show_books();
					clearTextFild();
					JOptionPane.showConfirmDialog(null, "Deleted");

				} catch (Exception e1) {
					// TODO: handle exception
					JOptionPane.showConfirmDialog(null, "Delete Unsuccessfull!!!!!!!");
				}

			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnDelete.setBounds(570, 129, 84, 34);
		add(btnDelete);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(7, 205, 704, 260);
		add(scrollPane);
		jTable_Display_book = new javax.swing.JTable();
		jTable_Display_book.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = jTable_Display_book.getSelectedRow();
				TableModel model = jTable_Display_book.getModel();
				txtBid.setText(model.getValueAt(i, 0).toString());
				txtTitle.setText(model.getValueAt(i, 1).toString());
				txtQty.setText(model.getValueAt(i, 2).toString());
				txtPrice.setText(model.getValueAt(i, 3).toString());
				txtAuthor.setText(model.getValueAt(i, 4).toString());
				txtPubliser.setText(model.getValueAt(i, 5).toString());
			}
		});
		jTable_Display_book.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "BID", "Title", "Qty", "Price", "Author", "Publisher" }) {
			Class[] columnTypes = new Class[] { String.class, String.class, Integer.class, Float.class, String.class,String.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}

			boolean[] columnEditables = new boolean[] { true, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(jTable_Display_book);

		JLabel lblNewLabel_4 = new JLabel("Book Information");
		lblNewLabel_4.setForeground(new Color(0, 128, 128));
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_4.setBounds(0, 0, 224, 32);
		add(lblNewLabel_4);

	}

	protected void clearTextFild() {
		txtBid.setText("");
		txtTitle.setText("");
		txtQty.setText("");
		txtPrice.setText("");
		txtAuthor.setText("");
		txtPubliser.setText("");
	}
}
