import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class RegisterGameUI {

	private JFrame RegisterGameUIFrame;
	private JTextField text_Name;
	private JTextField text_Genre;
	private JTextField text_Price;
	private JTextField text_Stock;
	private JTextField text_AgeLimit;
	private JTextField text_Rating;
	private JTextField text_PurchaseCount;
	private JTextField text_Description;
		
	private String days[] = { "1", "2", "3", "4", "5", 
	            			  "6", "7", "8", "9", "10", 
	            			  "11", "12", "13", "14", "15", 
	            			  "16", "17", "18", "19", "20", 
	            			  "21", "22", "23", "24", "25", 
	            			  "26", "27", "28", "29", "30", 
	            									"31" }; 
	private String months[] = { "1", "2", "3", "4", 
	            				"5", "6", "7", "8", 
	            				"9", "10", "11", "12" }; 
	private String years[] = { "1990", "1991", "1992", "1993", 
	            				"1994", "1995", "1996", "1997", 
	            				"1998", "1999", "2000", "2001", 
	            				"2002", "2003", "2004", "2005", 
	            				"2006", "2007", "2008", "2009", 
	            										"2010"}; 
	

	public JFrame getRegisterGameUIFrame() {
		return RegisterGameUIFrame;
	}


	public void setRegisterGameUIFrame(JFrame registerGameUIFrame) {
		RegisterGameUIFrame = registerGameUIFrame;
	}


	public RegisterGameUI(JFrame menuFrame, Management mng) {
		RegisterGameUIFrame = new JFrame();
		RegisterGameUIFrame.getContentPane().setBackground(new Color(44,62,80));
		RegisterGameUIFrame.setBounds(100, 100, 672, 596);
		RegisterGameUIFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		RegisterGameUIFrame.getContentPane().setLayout(null);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setForeground(Color.WHITE);
		lblName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblName.setBounds(389, 44, 70, 13);
		RegisterGameUIFrame.getContentPane().add(lblName);
		
		JLabel lblDescription = new JLabel("Description:");
		lblDescription.setForeground(Color.WHITE);
		lblDescription.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDescription.setBounds(42, 442, 108, 13);
		RegisterGameUIFrame.getContentPane().add(lblDescription);
		
		JLabel lblGenre = new JLabel("Genre:");
		lblGenre.setForeground(Color.WHITE);
		lblGenre.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblGenre.setBounds(389, 86, 70, 13);
		RegisterGameUIFrame.getContentPane().add(lblGenre);
		
		JLabel lblPurchase = new JLabel("Purchase Count:");
		lblPurchase.setForeground(Color.WHITE);
		lblPurchase.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPurchase.setBounds(42, 352, 139, 13);
		RegisterGameUIFrame.getContentPane().add(lblPurchase);
		
		JLabel lblStock = new JLabel("Stock:");
		lblStock.setForeground(Color.WHITE);
		lblStock.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblStock.setBounds(42, 228, 70, 13);
		RegisterGameUIFrame.getContentPane().add(lblStock);
		
		JLabel lblAgeLimit = new JLabel("Age Limit:");
		lblAgeLimit.setForeground(Color.WHITE);
		lblAgeLimit.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAgeLimit.setBounds(42, 271, 94, 13);
		RegisterGameUIFrame.getContentPane().add(lblAgeLimit);
		
		JLabel lblPrice = new JLabel("Price:");
		lblPrice.setForeground(Color.WHITE);
		lblPrice.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPrice.setBounds(42, 192, 70, 13);
		RegisterGameUIFrame.getContentPane().add(lblPrice);
		
		JLabel lblReleaseDate = new JLabel("Release Date:");
		lblReleaseDate.setForeground(Color.WHITE);
		lblReleaseDate.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblReleaseDate.setBounds(42, 402, 114, 13);
		RegisterGameUIFrame.getContentPane().add(lblReleaseDate);
		
		JLabel lblRating = new JLabel("Rating:");
		lblRating.setForeground(Color.WHITE);
		lblRating.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblRating.setBounds(42, 310, 70, 19);
		RegisterGameUIFrame.getContentPane().add(lblRating);
		
		JLabel lblDay = new JLabel("Day");
		lblDay.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 10));
		lblDay.setForeground(Color.WHITE);
		lblDay.setBounds(171, 387, 29, 13);
		RegisterGameUIFrame.getContentPane().add(lblDay);
		
		JLabel lblMonth = new JLabel("Month");
		lblMonth.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 10));
		lblMonth.setForeground(Color.WHITE);
		lblMonth.setBounds(240, 387, 39, 13);
		RegisterGameUIFrame.getContentPane().add(lblMonth);
		
		JLabel lblYear = new JLabel("Year");
		lblYear.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 10));
		lblYear.setForeground(Color.WHITE);
		lblYear.setBounds(313, 387, 29, 13);
		RegisterGameUIFrame.getContentPane().add(lblYear);
		
		text_Name = new JTextField();
		text_Name.setBackground(new Color(108,122,137));
		text_Name.setBounds(446, 43, 187, 19);
		RegisterGameUIFrame.getContentPane().add(text_Name);
		text_Name.setColumns(10);
		
		text_Genre = new JTextField();
		text_Genre.setBackground(new Color(108,122,137));
		text_Genre.setColumns(10);
		text_Genre.setBounds(446, 85, 187, 19);
		RegisterGameUIFrame.getContentPane().add(text_Genre);
		
		text_Price = new JTextField();
		text_Price.setBackground(new Color(108,122,137));
		text_Price.setColumns(10);
		text_Price.setBounds(171, 191, 187, 19);
		RegisterGameUIFrame.getContentPane().add(text_Price);
		
		text_Stock = new JTextField();
		text_Stock.setBackground(new Color(108,122,137));
		text_Stock.setColumns(10);
		text_Stock.setBounds(171, 227, 187, 19);
		RegisterGameUIFrame.getContentPane().add(text_Stock);
		
		text_AgeLimit = new JTextField();
		text_AgeLimit.setBackground(new Color(108,122,137));
		text_AgeLimit.setColumns(10);
		text_AgeLimit.setBounds(171, 270, 187, 19);
		RegisterGameUIFrame.getContentPane().add(text_AgeLimit);
		
		text_Rating = new JTextField();
		text_Rating.setBackground(new Color(108,122,137));
		text_Rating.setColumns(10);
		text_Rating.setBounds(171, 312, 187, 19);
		RegisterGameUIFrame.getContentPane().add(text_Rating);
		
		text_PurchaseCount = new JTextField();
		text_PurchaseCount.setBackground(new Color(108,122,137));
		text_PurchaseCount.setColumns(10);
		text_PurchaseCount.setBounds(171, 351, 187, 19);
		RegisterGameUIFrame.getContentPane().add(text_PurchaseCount);
		
		text_Description = new JTextField();
		text_Description.setBackground(new Color(108,122,137));
		text_Description.setColumns(10);
		text_Description.setBounds(171, 440, 426, 42);
		RegisterGameUIFrame.getContentPane().add(text_Description);
		
		
		JComboBox day = new JComboBox(days);
		day.setForeground(Color.WHITE);
		day.setBackground(new Color(108,122,137));
		day.setBounds(166, 400, 39, 21);
		RegisterGameUIFrame.getContentPane().add(day);
		
		JComboBox month = new JComboBox(months);
		month.setForeground(Color.WHITE);
		month.setBackground(new Color(108,122,137));
		month.setBounds(237, 400, 42, 21);
		RegisterGameUIFrame.getContentPane().add(month);
		
		JComboBox year = new JComboBox(years);
		year.setForeground(Color.WHITE);
		year.setBackground(new Color(108,122,137));
		year.setBounds(304, 400, 54, 21);
		RegisterGameUIFrame.getContentPane().add(year);
		
		JButton btn_Image = new JButton();
		btn_Image.setBackground(new Color(44,62,80));
		btn_Image.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}		});
		Image img = new ImageIcon(this.getClass().getResource("/default.png")).getImage();
		btn_Image.setIcon(new ImageIcon(img.getScaledInstance(187, 162, Image.SCALE_DEFAULT)));
		btn_Image.setFont(new Font("Tahoma", Font.BOLD, 30));
		btn_Image.setBounds(42, 10, 187, 162);
		RegisterGameUIFrame.getContentPane().add(btn_Image);
		
		JButton btn_SaveGame = new JButton("SAVE THE GAME");
		btn_SaveGame.setForeground(Color.WHITE);
		btn_SaveGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = text_Name.getText();
				String description = text_Description.getText();
				String genre = text_Genre.getText();
				
				int purchaseCount = Integer.valueOf(text_PurchaseCount.getText()); 
				int stock = Integer.valueOf(text_Stock.getText()); 
				int ageLimit = Integer.valueOf(text_AgeLimit.getText()); 
				double price = Double.parseDouble(text_Price.getText()); 
				double rating = Double.parseDouble(text_Rating.getText());  
				
				int d = Integer.valueOf((String)day.getSelectedItem());
				int m = Integer.valueOf((String)month.getSelectedItem());
				int y = Integer.valueOf((String)year.getSelectedItem());
				Date releaseDate = new Date(d,m,y);
							
				Game g = new Game(name, description, genre, purchaseCount, stock, ageLimit, price, rating, releaseDate);
				mng.getMarket().addGame(g);	
				JOptionPane.showMessageDialog(RegisterGameUIFrame.getContentPane(), "The game has been successfully added!");
				try {
					mng.updateMarket();
					menuFrame.setVisible(true);
					RegisterGameUIFrame.setVisible(false);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btn_SaveGame.setFont(new Font("Tahoma", Font.BOLD, 18));
		btn_SaveGame.setBackground(new Color(197,57,43));
		btn_SaveGame.setBounds(339, 495, 258, 42);
		RegisterGameUIFrame.getContentPane().add(btn_SaveGame);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.setBackground(new Color(151,163,166));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuFrame.setVisible(true);
				RegisterGameUIFrame.setVisible(false);
			}
		});
		btnNewButton.setBounds(29, 505, 114, 31);
		RegisterGameUIFrame.getContentPane().add(btnNewButton);
	}
}