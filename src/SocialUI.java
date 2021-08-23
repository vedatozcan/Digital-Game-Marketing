import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javafx.scene.control.ComboBox;

import javax.swing.JScrollPane;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.ScrollPaneConstants;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SocialUI {
    
	private JFrame socialFrame;
	private JPanel contentPane;
	private JPanel panel;
	private JTextField textFieldSearch;
	
	public JFrame getSocialFrame() {
		return socialFrame;
	}

	public void setSocialFrame(JFrame socialFrame) {
		this.socialFrame = socialFrame;
	}

	public SocialUI(JFrame menuFrame, Management mng) throws QueueEmpty 
	{
		
		socialFrame = new JFrame();
		socialFrame.setTitle("DigitalGameMarketing / Social");
		if(mng.getActiveUser().equals(mng.getAdmin()))
		{
			admin(menuFrame, mng);
		}
		else 
		{
			user(menuFrame, mng);
		}
		
	}
	
	
	private void admin(JFrame menuFrame, Management mng)
	{
		socialFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		socialFrame.setBounds(100, 100, 933, 646);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(44,62,80));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		socialFrame.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		textFieldSearch = new JTextField();
		textFieldSearch.setForeground(Color.WHITE);
		textFieldSearch.setBackground(new Color(108,122,137));
		textFieldSearch.setBounds(278, 12, 205, 33);
		contentPane.add(textFieldSearch);
		textFieldSearch.setColumns(10);
		
		
		
		JButton btnNewButton = new JButton("Search User");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBackground(new Color(108,122,137));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				User user = mng.getSocial().searchUser(textFieldSearch.getText());
				if(user != null)
				{
					UserUI userUI = new UserUI(socialFrame, user, mng);
					userUI.getUserFrame().setVisible(true);
					userUI.getUserFrame().setLocationRelativeTo(null);
					socialFrame.setVisible(false);
					
				}
				else 
				{
					JOptionPane.showMessageDialog(contentPane, "No user with nick " + textFieldSearch.getText() + "!");
				}
				
			}
		});
		btnNewButton.setBounds(495, 16, 153, 25);
		contentPane.add(btnNewButton);
		
		
		
		JButton btnNewButton_1 = new JButton("New button");
		Image img =new ImageIcon(this.getClass().getResource("/profile.png")).getImage();
		btnNewButton_1.setIcon(new ImageIcon(img.getScaledInstance(147, 152, Image.SCALE_DEFAULT)));
		btnNewButton_1.setBounds(12, 16, 127, 152);
		contentPane.add(btnNewButton_1);
		
		JLabel UserName = new JLabel(((Admin) mng.getActiveUser()).getUser_name());
		UserName.setFont(new Font("Tahoma", Font.BOLD, 14));
		UserName.setForeground(Color.WHITE);
		UserName.setBounds(170, 20, 89, 16);
		contentPane.add(UserName);
		
		
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_1.setBounds(12, 181, 700, 363);
		scrollPane_1.setBackground(new Color(108,122,137));
		contentPane.add(scrollPane_1);
		JPanel panel_1 = new JPanel();
		scrollPane_1.setViewportView(panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));
		
		for(User user : mng.getSocial().displayAllUsers())
		{
			JPanel mrgpanel = new JPanel();
			mrgpanel.setLayout(new BoxLayout(mrgpanel, BoxLayout.X_AXIS));
			mrgpanel.setPreferredSize(new Dimension(200,90));
			
			JPanel npanel = new JPanel();
			npanel.setBackground(new Color(108,122,137));
			npanel.setPreferredSize(new Dimension(200,90));
			
			
			JPanel nPanel2 = new JPanel();
			nPanel2.setBackground(new Color(108,122,137));
			nPanel2.setPreferredSize(new Dimension(200,90));
			nPanel2.addMouseListener(new MouseAdapter(){
				
				@Override
				public void mouseReleased(MouseEvent e) {
				
					UserUI userUI = new UserUI(socialFrame, user, mng);
					userUI.getUserFrame().setVisible(true);
					userUI.getUserFrame().setLocationRelativeTo(null);
					socialFrame.setVisible(false);
					
				}
				
			});
			
			
			JButton button = new JButton();
			button.setBackground(new Color(108,122,137));
			button.setBounds(20, 16, 147, 152);
			Image img1 =new ImageIcon(this.getClass().getResource("/profile.png")).getImage();
			button.setIcon(new ImageIcon(img1.getScaledInstance(200, 90, Image.SCALE_DEFAULT)));
			npanel.add(button);
			
			JLabel txtJLabel = new JLabel(user.getNickname());
			txtJLabel.setForeground(Color.WHITE);
			txtJLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
			nPanel2.add(txtJLabel);
			
			mrgpanel.add(npanel);
			mrgpanel.add(nPanel2);
			panel_1.add(mrgpanel);
	
		
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnBack.setBackground(new Color(108,122,137));
		btnBack.setForeground(Color.WHITE);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuFrame.setVisible(true);
				socialFrame.setVisible(false);
			}
		});
		btnBack.setBounds(12, 561, 127, 25);
		contentPane.add(btnBack);
		
		}
	}
	
	
	
	
	
	private void user(JFrame menuFrame, Management mng) throws QueueEmpty
	{
		
		socialFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		socialFrame.setBounds(100, 100, 933, 646);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(44,62,80));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		socialFrame.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(679, 242, 221, 260);
		scrollPane.setBackground(new Color(108,122,137));
		contentPane.add(scrollPane);
		
		
		panel = new JPanel();
		scrollPane.setViewportView(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		textFieldSearch = new JTextField();
		textFieldSearch.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldSearch.setBackground(new Color(108,122,137));
		textFieldSearch.setForeground(Color.BLACK);
		textFieldSearch.setBounds(278, 12, 205, 33);
		contentPane.add(textFieldSearch);
		textFieldSearch.setColumns(10);
		
		
		
		JButton btnNewButton = new JButton("Search User");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBackground(new Color(108,122,137));
		btnNewButton.setForeground(Color.WHITE);
		
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				User user = mng.getSocial().searchUser(textFieldSearch.getText());
				if(user != null)
				{
					UserUI userUI = new UserUI(socialFrame, user, mng);
					userUI.getUserFrame().setVisible(true);
					userUI.getUserFrame().setLocationRelativeTo(null);
					socialFrame.setVisible(false);
					
				}
				else 
				{
					JOptionPane.showMessageDialog(contentPane, "No user with nick " + textFieldSearch.getText() + "!");
				}
				
			}
		});
		btnNewButton.setBounds(495, 16, 153, 25);
		contentPane.add(btnNewButton);
		
		
		
		JButton btnNewButton_1 = new JButton();
		Image img =new ImageIcon(this.getClass().getResource("/profile.png")).getImage();
		btnNewButton_1.setIcon(new ImageIcon(img.getScaledInstance(147, 152, Image.SCALE_DEFAULT)));
		btnNewButton_1.setBackground(new Color(44,62,80));
		btnNewButton_1.setBounds(20, 16, 147, 152);
		contentPane.add(btnNewButton_1);
		
		JLabel UserName = new JLabel(((User) mng.getActiveUser()).getNickname());
		UserName.setFont(new Font("Tahoma", Font.BOLD, 14));
		UserName.setForeground(Color.WHITE);
		UserName.setBounds(170, 20, 89, 16);
		contentPane.add(UserName);
		
		JLabel birthDate = new JLabel(mng.getActiveUser().getBirthdate().toString());
		birthDate.setFont(new Font("Tahoma", Font.BOLD, 14));
		birthDate.setForeground(Color.WHITE);
		birthDate.setBounds(170, 49, 115, 16);
		contentPane.add(birthDate);
		for (Game game : ((User) mng.getActiveUser()).getLibrary().getgames()) 
		{	
			JPanel mrgpanel = new JPanel();
			mrgpanel.setLayout(new BoxLayout(mrgpanel, BoxLayout.X_AXIS));
			mrgpanel.setPreferredSize(new Dimension(200,50));
			
			JPanel npanel = new JPanel();
			npanel .setBackground(new Color(108,122,137));
			npanel.setPreferredSize(new Dimension(100,50));
			
			JLabel btnGame = new JLabel();
			btnGame.setBackground(new Color(108,122,137));
			btnGame.setText(game.getName());
			npanel.add(btnGame);
			
			
			mrgpanel.add(npanel);
			panel.add(mrgpanel);
		}
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_1.setBounds(12, 181, 542, 363);
		scrollPane_1.setBackground(new Color(108,122,137));
		contentPane.add(scrollPane_1);
		
		
		
		
		JComboBox comboBox = new JComboBox();
		display(mng, scrollPane_1, comboBox);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					try {
						
						//scrollPane_1.removeAll();
						display(mng, scrollPane_1, comboBox);
						
						
						
					} catch (QueueEmpty e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Pending Request", "Friend List"}));
		comboBox.setForeground(Color.WHITE);
		comboBox.setBackground(new Color(108,122,137));
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 14));
		comboBox.setBounds(660, 17, 240, 22);
		contentPane.add(comboBox);
		
		
		
		
		
		
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnBack.setBackground(new Color(108,122,137));
		btnBack.setForeground(Color.WHITE);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuFrame.setVisible(true);
				socialFrame.setVisible(false);
			}
		});
		btnBack.setBounds(12, 561, 127, 25);
		contentPane.add(btnBack);
		
	}
	
	
	private void display(Management mng, JScrollPane scrollPane_1, JComboBox comboBox) throws QueueEmpty 
	{
		
		ArrayList<User> tempList = new ArrayList<User>();
	
	  if(comboBox.getSelectedItem() ==  null) 
		{
			tempList = (ArrayList<User>) ((User) mng.getActiveUser()).getFriendlist();
		}
		else if(comboBox.getSelectedItem().toString().equals("Pending Request"))
		{
			for(int i = 0; i < ((User) mng.getActiveUser()).getPendingRequest().size(); i++)
			{
				User item = ((User) mng.getActiveUser()).getPendingRequest().peek();
				tempList.add(item);
				((User) mng.getActiveUser()).getPendingRequest().enqueue(((User) mng.getActiveUser()).getPendingRequest().dequeue());
			}
		}
		else if(comboBox.getSelectedItem() !=  null)
		{
			tempList = (ArrayList<User>) ((User) mng.getActiveUser()).getFriendlist();
			
		}
		
		JPanel panel_1 = new JPanel();
		scrollPane_1.setViewportView(panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));
		
		for(User user : tempList)
		{
			JPanel mrgpanel = new JPanel();
			mrgpanel.setLayout(new BoxLayout(mrgpanel, BoxLayout.X_AXIS));
			mrgpanel .setBackground(new Color(108,122,137));
			mrgpanel.setPreferredSize(new Dimension(200,90));
			
			JPanel npanel = new JPanel();
			npanel.setBackground(new Color(108,122,137));
			npanel.setBackground(new Color(108,122,137));
			npanel.setPreferredSize(new Dimension(200,90));
			
			
			JPanel nPanel2 = new JPanel();
			npanel.setBackground(new Color(108,122,137));
			nPanel2.setBackground(new Color(108,122,137));
			nPanel2.setPreferredSize(new Dimension(200,90));
			nPanel2.addMouseListener(new MouseAdapter(){
				
				@Override
				public void mouseReleased(MouseEvent e) {
				
					UserUI userUI = new UserUI(socialFrame, user, mng);
					userUI.getUserFrame().setVisible(true);
					userUI.getUserFrame().setLocationRelativeTo(null);
					socialFrame.setVisible(false);
					
				}
				
			});
			
			
			JButton button = new JButton();
			button.setBounds(495, 16, 200,150);
			button.setBackground(new Color(108,122,137));
			button.addMouseListener(new MouseAdapter(){
				
				@Override
				public void mouseReleased(MouseEvent e) {
				
					UserUI userUI = new UserUI(socialFrame, user, mng);
					userUI.getUserFrame().setVisible(true);
					userUI.getUserFrame().setLocationRelativeTo(null);
					socialFrame.setVisible(false);
					
				}
				
			});
			Image img =new ImageIcon(this.getClass().getResource("/profile.png")).getImage();
			button.setIcon(new ImageIcon(img.getScaledInstance(200,120, Image.SCALE_DEFAULT)));
			npanel.add(button);
			
			JLabel txtJLabel = new JLabel(user.getNickname());
			txtJLabel.setForeground(Color.WHITE);
			txtJLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
			nPanel2.add(txtJLabel);
			
			mrgpanel.add(npanel);
			mrgpanel.add(nPanel2);
			panel_1.add(mrgpanel);
			
			
		}
	}
}
