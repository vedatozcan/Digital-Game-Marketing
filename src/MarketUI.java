import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTree;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.UIManager;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.BoxLayout;
import javax.swing.JSplitPane;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.SwingConstants;

public class MarketUI {

	private JFrame marketFrame;
	private JPanel contentPane;
	private JTextField textSearch;

	public JFrame getMarketFrame() {
		return marketFrame;
	}

	public void setMarketFrame(JFrame marketFrame) {
		this.marketFrame = marketFrame;
	}

	public MarketUI(JFrame menuFrame, Management mng) {

		marketFrame = new JFrame();
		marketFrame.setTitle("DigitalGameMarketing / Market");
		marketFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		marketFrame.setBounds(100, 100, 869, 717);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(44,62,80));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		marketFrame.setContentPane(contentPane);
		contentPane.setLayout(null);

		JComboBox comboBox = new JComboBox();
		comboBox.setForeground(Color.WHITE);
		comboBox.setBackground(new Color(108,122,137));

		comboBox.setFont(new Font("Tahoma", Font.BOLD, 14));
		comboBox.setBounds(661, 15, 164, 31);
		comboBox.setModel(new DefaultComboBoxModel(new String[] { ".." ,"User Reviews", "Lowest Price", "Top Selling" }));
		contentPane.add(comboBox);

		JLabel lblNewLabel = new JLabel("Sort By");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));

		lblNewLabel.setBounds(605, 23, 81, 16);
		lblNewLabel.setBackground(Color.LIGHT_GRAY);
		contentPane.add(lblNewLabel);

		textSearch = new JTextField();
		textSearch.setBackground(new Color(108,122,137));
		textSearch.setBounds(27, 17, 345, 27);
		contentPane.add(textSearch);
		textSearch.setColumns(10);


		JButton btnSearch = new JButton("Search");
		btnSearch.setForeground(Color.WHITE);
		btnSearch.setBackground(new Color(151,163,166));
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSearch.setBounds(382, 18, 97, 25);
		contentPane.add(btnSearch);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_1.setBounds(27, 84, 798, 477);
		scrollPane_1.setBackground(new Color(108,122,137));
		contentPane.add(scrollPane_1);
		scrollPane_1.getVerticalScrollBar().setUnitIncrement(10);

		JPanel panel = new JPanel();
		scrollPane_1.setViewportView(panel);
		scrollPane_1.setEnabled(true);
		panel.setAutoscrolls(true);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		JButton btnNewButton = new JButton("Back");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				marketFrame.setVisible(false);
				menuFrame.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(27, 601, 104, 31);
		btnNewButton.setBackground(new Color(151,163,166));
		contentPane.add(btnNewButton);

		displayGames(mng.getMarket().getGames(), panel, mng);

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

		JLabel lblPrice = new JLabel("Price");
		lblPrice.setForeground(Color.WHITE);
		lblPrice.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPrice.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrice.setBounds(717, 61, 46, 13);
		contentPane.add(lblPrice);
		
		
		if(mng.getActiveUser().equals(mng.getAdmin()))
		{
			JButton btnNewButton_1 = new JButton("Add Game");
			btnNewButton_1.setForeground(Color.WHITE);
			btnNewButton_1.setBackground(new Color(151,163,166));
			btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
			btnNewButton_1.setBounds(700, 601, 120, 30);
			contentPane.add(btnNewButton_1);
			marketFrame.setVisible(false);
			marketFrame.setVisible(true);
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					RegisterGameUI registerGameUI = new RegisterGameUI(menuFrame, mng);
					registerGameUI.getRegisterGameUIFrame().setLocationRelativeTo(null);
					registerGameUI.getRegisterGameUIFrame().setVisible(true);
					
				}
			});
		}

		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String search = e.getActionCommand();
				if(search.equals("Search")) {
					panel.removeAll();
					displayGames(mng.getMarket().searchGame(textSearch.getText()), panel, mng);
					marketFrame.setVisible(false);
					marketFrame.setVisible(true);
				}
			}
		});

		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getSource() == comboBox) {
					if (comboBox.getSelectedItem().equals("User Reviews")) {
						mng.getMarket().sortMarketRating();
						panel.removeAll();
						displayGames(mng.getMarket().getGames(), panel, mng);
						marketFrame.setVisible(false);
						marketFrame.setVisible(true);

					} else if (comboBox.getSelectedItem().equals("Lowest Price")) {
						mng.getMarket().sortMarketPrice();
						panel.removeAll();
						displayGames(mng.getMarket().getGames(), panel, mng);
						marketFrame.setVisible(false);
						marketFrame.setVisible(true);

					} else if (comboBox.getSelectedItem().equals("Top Selling")) {
						mng.getMarket().sortMarketPurchaseCount();
						panel.removeAll();
						displayGames(mng.getMarket().getGames(), panel, mng);
						marketFrame.setVisible(false);
						marketFrame.setVisible(true);

					}
				}
			}
		});
	}

	private void displayGames(List<Game> games, JPanel panel, Management mng) {
		int count = 0;
		for (Game game : games) {
			JPanel mrgpanel = new JPanel();
			mrgpanel.setLayout(new BoxLayout(mrgpanel, BoxLayout.X_AXIS));
			mrgpanel.setBackground(new Color(108,122,137));
			
			mrgpanel.setPreferredSize(new Dimension(788, 100));

			JPanel npanel = new JPanel();
			npanel.setPreferredSize(new Dimension(100, 90));
			npanel.setBackground(new Color(108,122,137));

			JPanel txt1panel = new JPanel();
			txt1panel.setBackground(new Color(108,122,137));
			txt1panel.setPreferredSize(new Dimension(200, 90));
			txt1panel.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					GameUI gameui = new GameUI(marketFrame, game, mng);
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
			game_button.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					GameUI gameui = new GameUI(marketFrame, game, mng);
					gameui.getGameFrame().setLocationRelativeTo(null);
					gameui.getGameFrame().setVisible(true);
				}
			});
			game_button .setBackground(new Color(108,122,137));
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
			JLabel txt3 = new JLabel(String.valueOf(game.getPrice()) + "TL");
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
			count++;
			panel.add(mrgpanel);
		}

	}
}