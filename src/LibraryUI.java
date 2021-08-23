import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDate;
import java.time.chrono.ChronoLocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

public class LibraryUI {

	private JFrame libraryFrame;
	private JPanel contentPane;
	

	public JFrame getLibraryFrame() {
		return libraryFrame;
	}
	public void setLibraryFrame(JFrame libraryFrame) {
		this.libraryFrame = libraryFrame;
	}
	
	public LibraryUI(JFrame menuFrame, Management mng) throws IOException {
		
		
		this.libraryFrame = new JFrame();
		libraryFrame.setTitle("DigitalGameMarketing / Library");
		libraryFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		libraryFrame.setBounds(100, 100, 931, 642);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(44,62,80));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		libraryFrame.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.setBackground(new Color(151,163,166));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				menuFrame.setVisible(true);
				libraryFrame.setVisible(false);
			}
		});
		btnNewButton.setBounds(12, 557, 118, 25);
		contentPane.add(btnNewButton);
		
		
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(276, 61, 46, 13);
		contentPane.add(lblNewLabel_1);

		JLabel lblGenre = new JLabel("Genre");
		lblGenre.setForeground(Color.WHITE);
		lblGenre.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblGenre.setHorizontalAlignment(SwingConstants.CENTER);
		lblGenre.setBounds(520, 61, 46, 13);
		contentPane.add(lblGenre);

		JLabel lblPrice = new JLabel("Rent Date");
		lblPrice.setForeground(Color.WHITE);
		lblPrice.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPrice.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrice.setBounds(700, 61, 90, 13);
		contentPane.add(lblPrice);
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(27, 83, 788, 445);
		contentPane.add(scrollPane);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(new Color(108,122,137));
		comboBox.setForeground(Color.WHITE);
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 14));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"All Games", "Rent Games", "Purchased Games"}));
		comboBox.setBounds(731, 13, 170, 22);
		contentPane.add(comboBox);
		displayGames(scrollPane, mng, comboBox);
		
		JLabel lblNewLabel = new JLabel("Display:");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(663, 17, 56, 16);
		contentPane.add(lblNewLabel);
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				displayGames(scrollPane, mng, comboBox);
			}
		});
		String tempString = controlRentDate(((User) mng.getActiveUser()).getLibrary().getgames());
		if(tempString != "")
		{
			JOptionPane.showMessageDialog(null,tempString + "The games have expired, you can rent or buy them again.");
			 mng.updatelibrary();
			 libraryFrame.setVisible(false);
			libraryFrame.setVisible(true);
		}
		
	}
	private void displayGames(JScrollPane scrollPane, Management mng, JComboBox comboBox) {
		
		List<Game> games = new ArrayList<Game>();
			
			if (comboBox.getSelectedItem().equals("All Games") || comboBox ==  null)
			{
			 	games = ((User) mng.getActiveUser()).getLibrary().getgames();
			} 
			else if (comboBox.getSelectedItem().equals("Rent Games")) 
			{
				games = ((User) mng.getActiveUser()).getLibrary().rentGame();

			} 
			else if (comboBox.getSelectedItem().equals("Purchased Games")) 
			{
				games = ((User) mng.getActiveUser()).getLibrary().purchasedGame();
			}
		
		
		JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);
		scrollPane.setEnabled(true);
		panel.setAutoscrolls(true);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		
		for (Game game : games) {
			JPanel mrgpanel = new JPanel();
			mrgpanel.setBackground(new Color(108,122,137));
			mrgpanel.setLayout(new BoxLayout(mrgpanel, BoxLayout.X_AXIS));
			mrgpanel.setPreferredSize(new Dimension(788, 100));

			JPanel npanel = new JPanel();
			npanel.setBackground(new Color(108,122,137));
			npanel.setPreferredSize(new Dimension(100, 90));

			JPanel txt1panel = new JPanel();
			txt1panel.setBackground(new Color(108,122,137));
			txt1panel.setPreferredSize(new Dimension(200, 90));
			txt1panel.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					GameUI gameui = new GameUI(libraryFrame, game, mng);
					gameui.getGameFrame().setLocationRelativeTo(null);
					gameui.getGameFrame().setVisible(true);
				}
			});

			JPanel txt2panel = new JPanel();
			txt2panel.setBackground(new Color(108,122,137));
			txt2panel.setPreferredSize(new Dimension(200, 90));

			JPanel txt3panel = new JPanel();
			txt3panel.setBackground(new Color(108,122,137));
			txt3panel.setPreferredSize(new Dimension(100, 90));

			JButton game_button = new JButton();
			game_button.setBackground(new Color(108,122,137));
			Image img = null;
			try {
				img = new ImageIcon(this.getClass().getResource("/" + game.getName() + ".png")).getImage();
			} catch (NullPointerException e) {
				img = new ImageIcon(this.getClass().getResource("/default.png")).getImage();
			}
			game_button.setIcon(new ImageIcon(img.getScaledInstance(150, 90, Image.SCALE_DEFAULT)));
			JLabel txt1 = new JLabel(game.getName());
			txt1.setForeground(Color.WHITE);
			txt1.setFont(new Font("Tahoma", Font.BOLD, 14));
			JLabel txt2 = new JLabel(game.getGenre());
			txt2.setForeground(Color.WHITE);
			txt2.setFont(new Font("Tahoma", Font.BOLD, 14));
			JLabel txt3 = new JLabel(game.getRent_date().toString());
			txt3.setForeground(Color.WHITE);
			txt3.setFont(new Font("Tahoma", Font.BOLD, 14));
			txt1panel.add(txt1);
			txt2panel.add(txt2);
			txt3panel.add(txt3);
			npanel.add(game_button);
			mrgpanel.add(npanel);
			mrgpanel.add(txt1panel);
			mrgpanel.add(txt2panel);
			mrgpanel.add(txt3panel);
			panel.add(mrgpanel);
		}

	}
	
	
	
	
	private String controlRentDate(List<Game> games) {
		 
		String temp = "";
		int size = games.size();
		for(int i = 0 ;  i < games.size(); i++)
		{   
			
			Calendar rentDate = Calendar.getInstance();
			Calendar today = Calendar.getInstance();
						SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			try {
				rentDate.setTime(sdf.parse(games.get(i).getRent_date().toString()));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			rentDate.add(Calendar.MONTH, games.get(i).getRental_period());
			
			if(games.get(i).getStatus().equals("rent") && today.compareTo(rentDate) == 1)
			{
				temp += games.get(i).getName() + "\n";
				games.remove(i);
				i--;
			}
		}
      return temp;
    
	}
}
