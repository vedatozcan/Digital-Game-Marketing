import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class UserUI  {

	private JFrame userFrame;
	private JPanel contentPane;

	
	public JFrame getUserFrame() {
		return userFrame;
	}


	public void setUserFrame(JFrame userFrame) {
		this.userFrame = userFrame;
	}


	public UserUI(JFrame socialFrame, User user, Management mng) {
		this.userFrame = new JFrame();
		userFrame.setTitle("DigitalGameMarketing / UserPage");
		userFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		userFrame.setBounds(100, 100, 945, 640);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(44,62,80));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		userFrame.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton();
		btnNewButton.setBackground(new Color(44,62,80));
		btnNewButton.setBounds(12, 13, 153, 158);
		Image img =new ImageIcon(this.getClass().getResource("/profile.png")).getImage();
		btnNewButton.setIcon(new ImageIcon(img.getScaledInstance( 153, 158, Image.SCALE_DEFAULT)));
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel(user.getNickname());
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(188, 13, 96, 16);
		contentPane.add(lblNewLabel);
		
		
		
		if(!mng.getActiveUser().equals(mng.getAdmin()))
		{
			JButton btnNewButton_1 = new JButton(controlFriend(mng, user));
			btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
			btnNewButton_1.setBackground(new Color(108,122,137));
			btnNewButton_1.setForeground(Color.WHITE);
			btnNewButton_1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					
					if(btnNewButton_1.getText().equals("Unfriend"))
					{
						mng.getSocial().removeFriend((User) mng.getActiveUser(), user);
						JOptionPane.showMessageDialog(contentPane, "you are no longer friends with" + user.getNickname());
						btnNewButton_1.setText("Add friend");
						try {
							mng.updateSocial();
						} catch (IOException | QueueEmpty e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					}
					else if(btnNewButton_1.getText().equals("Add friend"))
					{
						mng.getSocial().sendRequest((User) mng.getActiveUser(), user);
						JOptionPane.showMessageDialog(contentPane, "Friend request sent to " + user.getNickname());
						btnNewButton_1.setText("Friend request sent");
						btnNewButton_1.setForeground(Color.BLACK);
						try {
							mng.updateSocial();
						} catch (IOException | QueueEmpty e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					else if(btnNewButton_1.getText().equals("Accept request"))
					{
						try {
							mng.getSocial().addFriend((User) mng.getActiveUser(), user);
						} catch (QueueEmpty e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
						JOptionPane.showMessageDialog(contentPane, "Friend request accepted ");
						try {
							mng.updateSocial();
						} catch (IOException | QueueEmpty e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						btnNewButton_1.setText("Unfriend");
					}
					else if(btnNewButton_1.getText().equals("Friend request sent"))
					{
						
					}
				}
			});
			btnNewButton_1.setBounds(177, 140, 200, 25);
			contentPane.add(btnNewButton_1);
		}
		
		
		
		
		
		
		
		
		
		JLabel lblNewLabel_1 = new JLabel("Total Game ");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(12, 207, 120, 16);
		contentPane.add(lblNewLabel_1);
		JLabel lbltotalgame = new JLabel("" + user.getLibrary().getgames().size());
		lbltotalgame.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbltotalgame.setForeground(Color.WHITE);
		lbltotalgame.setBounds(144, 207, 130, 16);
		contentPane.add(lbltotalgame);
		
		
		
		JLabel lblNewLabel_2 = new JLabel("Rent Game ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(12, 270, 120, 16);
		contentPane.add(lblNewLabel_2);
		JLabel lblrentGame = new JLabel("" + user.getLibrary().rentGame().size());
		lblrentGame.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblrentGame.setForeground(Color.WHITE);
		lblrentGame.setBounds(144, 270, 109, 16);
		contentPane.add(lblrentGame);
		
		
		
		JLabel lblNewLabel_3 = new JLabel("Purchase ");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBounds(12, 338, 120, 16);
		contentPane.add(lblNewLabel_3);
		JLabel lblpurchaseGame = new JLabel("" + user.getLibrary().purchasedGame().size());
		lblpurchaseGame.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblpurchaseGame.setForeground(Color.WHITE);
		lblpurchaseGame.setBounds(144, 338, 56, 16);
		contentPane.add(lblpurchaseGame);
		
		
		
		JLabel lblFriends = new JLabel("Friends ");
		lblFriends.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblFriends.setForeground(Color.WHITE);
		lblFriends.setBounds(10, 406, 122, 16);
		contentPane.add(lblFriends);
		JLabel labelFriends = new JLabel("" + user.getFriendlist().size());
		labelFriends.setFont(new Font("Tahoma", Font.BOLD, 14));
		labelFriends.setForeground(Color.WHITE);
		labelFriends.setBounds(144, 406, 56, 16);
		contentPane.add(labelFriends);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(564, 113, 269, 465);
		contentPane.add(scrollPane);
		
		JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		JLabel lblNewLabel_5 = new JLabel("User Games");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setBounds(564, 84, 173, 16);
		contentPane.add(lblNewLabel_5);
		
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnBack.setBackground(new Color(108,122,137));
		btnBack.setForeground(Color.WHITE);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				socialFrame.setVisible(true);
				userFrame.setVisible(false);
			}
		});
		btnBack.setBounds(24, 553, 130, 25);
		contentPane.add(btnBack);
		
		
		for(Game game : user.getLibrary().getgames())
		{
			JPanel mrgpanel = new JPanel();
			mrgpanel.setLayout(new BoxLayout(mrgpanel, BoxLayout.X_AXIS));
			mrgpanel.setPreferredSize(new Dimension(260,90));
			
			JPanel txt1panel = new JPanel();
			txt1panel.setBackground(new Color(108,122,137));
			txt1panel.setPreferredSize(new Dimension(200,90));
			txt1panel.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					 JOptionPane.showMessageDialog(contentPane, game.getName());
				}
			});
			
			JLabel txtJLabel = new JLabel(game.getName());
			txtJLabel.setForeground(Color.WHITE);
			txtJLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
			txt1panel.add(txtJLabel);
			mrgpanel.add(txt1panel);
			
			panel.add(mrgpanel);
			
			
		}
		
		
	}
	public String controlFriend(Management mng, User user)
	{
		if(((User) mng.getActiveUser()).getFriendlist().contains(user))
		{
			return "Unfriend";
		}
		else if(user.getPendingRequest().contains(user))
		{
			return "Friend request sent";
		}
		else if(((User) mng.getActiveUser()).getPendingRequest().contains(user))
		{
			return "Accept request";
		}
		else
		{
			return "Add friend";
		}
		
	}
}
