import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JProgressBar;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class GameUI {

	private JFrame gameFrame;
	private JPanel contentPane;


	public JFrame getGameFrame() {
		return gameFrame;
	}

	public GameUI(JFrame marketFrame, Game game, Management mng) {
		gameFrame = new JFrame();
		gameFrame.setTitle("DigitalGameMarketing / Game");
		
		if(mng.getActiveUser().equals(mng.getAdmin()))
		{
			updateGame(mng,marketFrame,game);
		}
		else 
		{
			game( game, mng);
		}
		

	}
	public void game(Game game, Management mng)
	{
		gameFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		gameFrame.setBounds(100, 100, 830, 579);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(44,62,80));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		gameFrame.setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTitle = new JLabel(game.getName());
		lblTitle.setFont(new Font("Century Gothic", Font.PLAIN, 36)); 		
		lblTitle.setBounds(42, 40, 742, 41);
		lblTitle.setForeground(Color.WHITE);
		
		contentPane.add(lblTitle);
		
		JButton btnGameimg = new JButton(); 		
		btnGameimg.setBounds(42, 91, 259, 129); 		
		contentPane.add(btnGameimg);
		Image img = null;
		try {
			img = new ImageIcon(this.getClass().getResource("/"+ game.getName() +".png")).getImage();
		} catch (NullPointerException e) {
			img = new ImageIcon(this.getClass().getResource("/default.png")).getImage();
		}
		btnGameimg.setIcon(new ImageIcon(img.getScaledInstance(259, 129, Image.SCALE_DEFAULT)));
		btnGameimg.setBackground(new Color(108,122,137));

		String date = String.valueOf(game.getRelease_date().getDay()) + "." + String.valueOf(game.getRelease_date().getMonth())
				+ "." + String.valueOf(game.getRelease_date().getYear());

		JProgressBar progressBar = new JProgressBar();
		progressBar.setStringPainted(true);
		progressBar.setForeground(Color.ORANGE);
		progressBar.setBounds(439, 91, 345, 29);
		progressBar.setFont(new Font("Century Gothic", Font.PLAIN, 10));
		progressBar.setMaximum(500);
		progressBar.setMinimum(0);
		int prgrssbarvalue = (int)(game.getRating()*100);
		progressBar.setString("" + game.getRating());
		progressBar.setValue(prgrssbarvalue);
		contentPane.add(progressBar);

		JTextArea textDetail = new JTextArea(game.getDescription());
		textDetail.setLineWrap(true);
		textDetail.setEditable(false);
		textDetail.setFont(new Font("Monospaced", Font.PLAIN, 12));
		textDetail.setForeground(Color.WHITE);
		textDetail.setBackground(Color.DARK_GRAY);
		textDetail.setBounds(42, 230, 742, 109);
		contentPane.add(textDetail);

		JTextArea textDate = new JTextArea("Release Date: " + date);
		textDate.setEditable(false);
		textDate.setForeground(Color.WHITE);
		textDate.setBackground(Color.DARK_GRAY);
		textDate.setBounds(426, 374, 358, 41);
		contentPane.add(textDate);

		JTextArea textGenre = new JTextArea("Genre: " + game.getGenre());
		textGenre.setEditable(false);
		textGenre.setBounds(426, 443, 358, 41);
		contentPane.add(textGenre);

		JButton btnNewButton = new JButton("Add to Cart");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					TransactionUI transact = new TransactionUI(gameFrame, game, mng);
					transact.getTransactionFrame().setLocationRelativeTo(null);
					transact.getTransactionFrame().setVisible(true);
					gameFrame.setVisible(false);
			}
		});
		btnNewButton.setBackground(new Color(151,163,166));
		btnNewButton.setBounds(42, 430, 110, 41);
		contentPane.add(btnNewButton);

		JTextArea textprice = new JTextArea(String.valueOf(game.getPrice()) + "TL");
		textprice.setEditable(false);
		textprice.setFont(new Font("Calibri Light", Font.PLAIN, 20));
		textprice.setBounds(151, 430, 110, 41);
		contentPane.add(textprice);
	}
	
	
	public void updateGame(Management mng, JFrame marketFrame, Game game) {
		
		JTextField text_Name;
		JTextField text_Genre;
		JTextField text_Price;
		JTextField text_Stock;
		JTextField text_AgeLimit;
		JTextField text_PurchaseCount;
		JTextField text_Description;
			
		String days[] = { "1", "2", "3", "4", "5", 
		            			  "6", "7", "8", "9", "10", 
		            			  "11", "12", "13", "14", "15", 
		            			  "16", "17", "18", "19", "20", 
		            			  "21", "22", "23", "24", "25", 
		            			  "26", "27", "28", "29", "30", 
		            									"31" }; 
		String months[] = { "1", "2", "3", "4", 
		            				"5", "6", "7", "8", 
		            				"9", "10", "11", "12" }; 
		 String years[] = { "1990", "1991", "1992", "1993", 
		            				"1994", "1995", "1996", "1997", 
		            				"1998", "1999", "2000", "2001", 
		            				"2002", "2003", "2004", "2005", 
		            				"2006", "2007", "2008", "2009", 
		            										"2010"}; 
		
		
		gameFrame = new JFrame();
		gameFrame.getContentPane().setBackground(new Color(44,62,80));
		gameFrame.setBounds(100, 100, 672, 596);
		gameFrame.getContentPane().setBackground(new Color(44,62,80));
		gameFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		gameFrame.getContentPane().setLayout(null);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setForeground(Color.WHITE);
		lblName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblName.setBounds(389, 44, 70, 13);
		gameFrame.getContentPane().add(lblName);
		
		JLabel lblDescription = new JLabel("Description:");
		lblDescription.setForeground(Color.WHITE);
		lblDescription.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDescription.setBounds(42, 442, 108, 13);
		gameFrame.getContentPane().add(lblDescription);
		
		JLabel lblGenre = new JLabel("Genre:");
		lblGenre.setForeground(Color.WHITE);
		lblGenre.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblGenre.setBounds(389, 86, 70, 13);
		gameFrame.getContentPane().add(lblGenre);
		
		
		JLabel lblStock = new JLabel("Stock:");
		lblStock.setForeground(Color.WHITE);
		lblStock.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblStock.setBounds(42, 228, 70, 13);
		gameFrame.getContentPane().add(lblStock);
		
		JLabel lblAgeLimit = new JLabel("Age Limit:");
		lblAgeLimit.setForeground(Color.WHITE);
		lblAgeLimit.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAgeLimit.setBounds(42, 271, 94, 13);
		gameFrame.getContentPane().add(lblAgeLimit);
		
		JLabel lblPrice = new JLabel("Price:");
		lblPrice.setForeground(Color.WHITE);
		lblPrice.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPrice.setBounds(42, 192, 70, 13);
		gameFrame.getContentPane().add(lblPrice);
		
		JLabel lblReleaseDate = new JLabel("Release Date:");
		lblReleaseDate.setForeground(Color.WHITE);
		lblReleaseDate.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblReleaseDate.setBounds(42, 402, 114, 13);
		gameFrame.getContentPane().add(lblReleaseDate);
		
		
		JLabel lblDay = new JLabel("Day");
		lblDay.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 10));
		lblDay.setForeground(Color.WHITE);
		lblDay.setBounds(171, 387, 29, 13);
		gameFrame.getContentPane().add(lblDay);
		
		JLabel lblMonth = new JLabel("Month");
		lblMonth.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 10));
		lblMonth.setForeground(Color.WHITE);
		lblMonth.setBounds(240, 387, 39, 13);
		gameFrame.getContentPane().add(lblMonth);
		
		JLabel lblYear = new JLabel("Year");
		lblYear.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 10));
		lblYear.setForeground(Color.WHITE);
		lblYear.setBounds(313, 387, 29, 13);
		gameFrame.getContentPane().add(lblYear);
		
		text_Name = new JTextField(game.getName());
		text_Name.setForeground(Color.WHITE);
		text_Name.setBackground(new Color(108,122,137));
		text_Name.setBounds(446, 43, 187, 19);
		gameFrame.getContentPane().add(text_Name);
		text_Name.setColumns(10);
		
		text_Genre = new JTextField(game.getGenre());
		text_Genre.setForeground(Color.WHITE);
		text_Genre.setBackground(new Color(108,122,137));
		text_Genre.setColumns(10);
		text_Genre.setBounds(446, 85, 187, 19);
		gameFrame.getContentPane().add(text_Genre);
		
		text_Price = new JTextField("" + game.getPrice());
		text_Price.setForeground(Color.WHITE);
		text_Price.setBackground(new Color(108,122,137));
		text_Price.setColumns(10);
		text_Price.setBounds(171, 191, 187, 19);
		gameFrame.getContentPane().add(text_Price);
		
		text_Stock = new JTextField("" +game.getStock());
		text_Stock.setForeground(Color.WHITE);
		text_Stock.setBackground(new Color(108,122,137));
		text_Stock.setColumns(10);
		text_Stock.setBounds(171, 227, 187, 19);
		gameFrame.getContentPane().add(text_Stock);
		
		text_AgeLimit = new JTextField("" + game.getAge_limit());
		text_AgeLimit.setForeground(Color.WHITE);
		text_AgeLimit.setBackground(new Color(108,122,137));
		text_AgeLimit.setColumns(10);
		text_AgeLimit.setBounds(171, 270, 187, 19);
		gameFrame.getContentPane().add(text_AgeLimit);
		
		
		text_Description = new JTextField(game.getDescription());
		text_Description.setForeground(Color.WHITE);
		text_Description.setBackground(new Color(108,122,137));
		text_Description.setColumns(10);
		text_Description.setBounds(171, 440, 426, 42);
		gameFrame.getContentPane().add(text_Description);
		
		
		JComboBox day = new JComboBox(days);
		day.setForeground(Color.WHITE);
		day.setBackground(new Color(108,122,137));
		day.setBounds(166, 400, 39, 21);;
		gameFrame.getContentPane().add(day);
		
		JComboBox month = new JComboBox(months);
		month.setForeground(Color.WHITE);
		month.setBackground(new Color(108,122,137));
		month.setBounds(237, 400, 42, 21);
		gameFrame.getContentPane().add(month);
		
		JComboBox year = new JComboBox(years);
		year.setForeground(Color.WHITE);
		year.setBackground(new Color(108,122,137));
		year.setBounds(304, 400, 54, 21);
		gameFrame.getContentPane().add(year);
		
		JButton btn_Image = new JButton();
		btn_Image.setBackground(new Color(44,62,80));
		btn_Image.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		Image img = null;
		try {
			img = new ImageIcon(this.getClass().getResource("/"+ game.getName() +".png")).getImage();
		} catch (NullPointerException e) {
			img = new ImageIcon(this.getClass().getResource("/default.png")).getImage();
		}
		btn_Image.setIcon(new ImageIcon(img.getScaledInstance(187, 162, Image.SCALE_DEFAULT)));
		btn_Image.setFont(new Font("Tahoma", Font.BOLD, 30));
		btn_Image.setBounds(42, 10, 187, 162);
		gameFrame.getContentPane().add(btn_Image);
		
		JButton btn_SaveGame = new JButton("SAVE THE GAME");
		btn_SaveGame.setBackground(new Color(151,163,166));
		btn_SaveGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = text_Name.getText();
				game.setName(name);
				String description = text_Description.getText();
				game.setDescription(description);
				String genre = text_Genre.getText();
				game.setGenre(genre);

				int stock = Integer.valueOf(text_Stock.getText()); 
				game.setStock(stock);
				int ageLimit = Integer.valueOf(text_AgeLimit.getText()); 
				game.setAge_limit(ageLimit);
				double price = Double.parseDouble(text_Price.getText()); 
				game.setPrice(price);  
				
				int d = Integer.valueOf((String)day.getSelectedItem());
				int m = Integer.valueOf((String)month.getSelectedItem());
				int y = Integer.valueOf((String)year.getSelectedItem());
				Date releaseDate = new Date(d,m,y);
				game.setRelease_date(releaseDate);
							
				JOptionPane.showMessageDialog(gameFrame.getContentPane(), "The game has been successfully added!");
				try {
					mng.updateMarket();
					marketFrame.setVisible(true);
					gameFrame.setVisible(false);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btn_SaveGame.setForeground(Color.WHITE);
		btn_SaveGame.setFont(new Font("Tahoma", Font.BOLD, 18));
		btn_SaveGame.setBackground(new Color(197,57,43));
		btn_SaveGame.setBounds(339, 495, 258, 42);
		gameFrame.getContentPane().add(btn_SaveGame);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.setBackground(new Color(151,163,166));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				marketFrame.setVisible(true);
				gameFrame.setVisible(false);
			}
		});
		btnNewButton.setBounds(29, 505, 114, 31);
		gameFrame.getContentPane().add(btnNewButton);
	}
}