import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;

public class ProfileUI {
	private JFrame profileFrame;
	private JTextField text_Firstname;
	private JTextField text_Lastname;
	private JTextField text_Phone;
	private JTextField text_Email;
	private JTextField text_Username;
	private JTextField text_Address;
	private JTextField text_Nickname;
	private JPasswordField JPassword;
    private JPasswordField JConfirmPassword;
	
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

	 
	 

	public JFrame getProfileFrame() {
		return profileFrame;
	}




	public void setProfileFrame(JFrame profileFrame) {
		this.profileFrame = profileFrame;
	}




	public ProfileUI(JFrame menuFrame, Management mng) {
		profileFrame = new JFrame();
		profileFrame.setTitle("DigitalGameMarketing / Profile");
		profileFrame.getContentPane().setBackground(new Color(44,62,80));
		profileFrame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 20));
		profileFrame.setBounds(100, 100, 642, 600);
		profileFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		profileFrame.getContentPane().setLayout(null);
	
		
		JComboBox day = new JComboBox(days);
		day.setBackground(new Color(108,122,137));
		day.setForeground(Color.WHITE);
		day.setFont(new Font("Tahoma", Font.BOLD, 14));
		day.setBounds(407, 242, 48, 21);
		profileFrame.getContentPane().add(day);
		
		JComboBox month = new JComboBox(months);
		month.setBackground(new Color(108,122,137));
		month.setFont(new Font("Tahoma", Font.BOLD, 14));
		month.setForeground(Color.WHITE);
		month.setBounds(467, 242, 48, 21);
		profileFrame.getContentPane().add(month);
				
		JComboBox year = new JComboBox(years);
		year.setBackground(new Color(108,122,137));
		year.setForeground(Color.WHITE);
		year.setFont(new Font("Tahoma", Font.BOLD, 14));
		year.setBounds(527, 242, 65, 21);
		profileFrame.getContentPane().add(year);
		
		JComboBox phoneType = new JComboBox();
		phoneType.setForeground(Color.WHITE);
		phoneType.setBackground(new Color(108,122,137));
		phoneType.setFont(new Font("Tahoma", Font.BOLD, 14));
		phoneType.setModel(new DefaultComboBoxModel(new String[] {"Mobile", "Home"}));
		phoneType.setBounds(528, 152, 64, 21);
		profileFrame.getContentPane().add(phoneType);
		
		JLabel lbl_Firstname = new JLabel("Firstname:");
		lbl_Firstname.setForeground(Color.WHITE);
		lbl_Firstname.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbl_Firstname.setBounds(36, 68, 90, 13);
		profileFrame.getContentPane().add(lbl_Firstname);
		
		JLabel lbl_Lastname = new JLabel("Lastname:");
		lbl_Lastname.setForeground(Color.WHITE);
		lbl_Lastname.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbl_Lastname.setBounds(36, 115, 90, 13);
		profileFrame.getContentPane().add(lbl_Lastname);
		
		JLabel lbl_Phone = new JLabel("Phone:");
		lbl_Phone.setForeground(Color.WHITE);
		lbl_Phone.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbl_Phone.setBounds(316, 154, 64, 13);
		profileFrame.getContentPane().add(lbl_Phone);
		
		JLabel lbl_Email = new JLabel("Email:");
		lbl_Email.setForeground(Color.WHITE);
		lbl_Email.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbl_Email.setBounds(36, 246, 46, 13);
		profileFrame.getContentPane().add(lbl_Email);
		
		JLabel lbl_Address = new JLabel("Address:");
		lbl_Address.setForeground(Color.WHITE);
		lbl_Address.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbl_Address.setBounds(36, 302, 64, 13);
		profileFrame.getContentPane().add(lbl_Address);
		
		JLabel lbl_Username = new JLabel("Username:");
		lbl_Username.setForeground(Color.WHITE);
		lbl_Username.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbl_Username.setBounds(316, 68, 90, 13);
		profileFrame.getContentPane().add(lbl_Username);
		
		JLabel lbl_Nickname = new JLabel("Nickname:");
		lbl_Nickname.setForeground(Color.WHITE);
		lbl_Nickname.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbl_Nickname.setBounds(316, 115, 97, 13);
		profileFrame.getContentPane().add(lbl_Nickname);
		
		JLabel lbl_Password = new JLabel("Password:");
		lbl_Password.setForeground(Color.WHITE);
		lbl_Password.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbl_Password.setBounds(36, 154, 84, 13);
		profileFrame.getContentPane().add(lbl_Password);
		
		JLabel lbl_Birthdate = new JLabel("Birthdate:");
		lbl_Birthdate.setForeground(Color.WHITE);
		lbl_Birthdate.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbl_Birthdate.setBounds(316, 246, 90, 13);
		profileFrame.getContentPane().add(lbl_Birthdate);
		
		JLabel lbl_Day = new JLabel("Day");
		lbl_Day.setForeground(Color.WHITE);
		lbl_Day.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 10));
		lbl_Day.setBounds(407, 225, 29, 13);
		profileFrame.getContentPane().add(lbl_Day);
		
		JLabel lbl_Month = new JLabel("Month");
		lbl_Month.setForeground(Color.WHITE);
		lbl_Month.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 10));
		lbl_Month.setBounds(467, 225, 34, 13);
		profileFrame.getContentPane().add(lbl_Month);
		
		JLabel lbl_Year = new JLabel("Year");
		lbl_Year.setForeground(Color.WHITE);
		lbl_Year.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 10));
		lbl_Year.setBounds(527, 225, 34, 13);
		profileFrame.getContentPane().add(lbl_Year);
		
		JLabel lblNewLabel = new JLabel("Edit Profile");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Berlin Sans FB", Font.BOLD, 40));
		lblNewLabel.setBounds(210, 10, 230, 37);
		profileFrame.getContentPane().add(lblNewLabel);
		
		JLabel lbl_ConfirmPassword = new JLabel("Confirm Password:");
		lbl_ConfirmPassword.setForeground(Color.WHITE);
		lbl_ConfirmPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbl_ConfirmPassword.setBounds(36, 200, 143, 13);
		profileFrame.getContentPane().add(lbl_ConfirmPassword);
		
		text_Firstname = new JTextField(mng.getActiveUser().getName());
		text_Firstname.setBackground(new Color(108,122,137));
		text_Firstname.setForeground(Color.WHITE);
		text_Firstname.setFont(new Font("Tahoma", Font.PLAIN, 14));
		text_Firstname.setHorizontalAlignment(SwingConstants.LEFT);
		text_Firstname.setBounds(122, 63, 143, 24);
		profileFrame.getContentPane().add(text_Firstname);
		text_Firstname.setColumns(10);
		
		text_Lastname = new JTextField(mng.getActiveUser().getLastname());
		text_Lastname.setBackground(new Color(108,122,137));
		text_Lastname.setFont(new Font("Tahoma", Font.PLAIN, 14));
		text_Lastname.setForeground(Color.WHITE);
		text_Lastname.setBounds(122, 109, 143, 25);
		profileFrame.getContentPane().add(text_Lastname);
		text_Lastname.setColumns(10);
		
		text_Phone = new JTextField("" + mng.getActiveUser().getPhone().toString());
		text_Phone.setForeground(Color.WHITE);
		text_Phone.setBackground(new Color(108,122,137));
		text_Phone.setBounds(407, 151, 111, 24);
		profileFrame.getContentPane().add(text_Phone);
		text_Phone.setColumns(10);
		
		text_Email = new JTextField(mng.getActiveUser().getEmail());
		text_Email.setForeground(Color.WHITE);
		text_Email.setBackground(new Color(108,122,137));
		text_Email.setBounds(120, 242, 145, 25);
		profileFrame.getContentPane().add(text_Email);
		text_Email.setColumns(10);
		
		text_Username = new JTextField(((User) mng.getActiveUser()).getUser_name());
		text_Username.setForeground(Color.WHITE);
		text_Username.setBackground(new Color(108,122,137));
		text_Username.setBounds(407, 65, 143, 25);
		profileFrame.getContentPane().add(text_Username);
		text_Username.setColumns(10);
		
		
		
		
		text_Address = new JTextField(mng.getActiveUser().getAddress().toString());
		text_Address.setForeground(Color.WHITE);
		text_Address.setBackground(new Color(108,122,137));
		text_Address.setBounds(117, 300, 421, 129);
		profileFrame.getContentPane().add(text_Address);
		text_Address.setColumns(10);
		
		text_Nickname = new JTextField(((User) mng.getActiveUser()).getNickname());
		text_Nickname.setForeground(Color.WHITE);
		text_Nickname.setBackground(new Color(108,122,137));
		text_Nickname.setBounds(407, 109, 143, 25);
		profileFrame.getContentPane().add(text_Nickname);
		text_Nickname.setColumns(10);
		
		JPassword = new JPasswordField(mng.getActiveUser().getPassword());
		JPassword.setBackground(new Color(108,122,137));
		JPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		JPassword.setBounds(122, 153, 143, 24);
		profileFrame.getContentPane().add(JPassword);
		
		JConfirmPassword = new JPasswordField(mng.getActiveUser().getPassword());
		JConfirmPassword.setBackground(new Color(108,122,137));
		JConfirmPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		JConfirmPassword.setBounds(175, 199, 143, 24);
		profileFrame.getContentPane().add(JConfirmPassword);
		
					
		JButton btn_SaveChanges = new JButton("Save Changes");
		btn_SaveChanges.setBackground(new Color(197,57,43));
		btn_SaveChanges.setForeground(Color.WHITE);
		btn_SaveChanges.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(!((User) mng.getActiveUser()).getUser_name().equals(text_Username.getText()) && 
						mng.getSocial().getUserMap().get(text_Username.getText()) != null)
				{
					JOptionPane.showMessageDialog(null,"you can't get " + text_Username.getText()  + " username");
				}
				else
				{
					mng.getActiveUser().setName(text_Firstname.getText());
					mng.getActiveUser().setLastname(text_Lastname.getText());
					((User) mng.getActiveUser()).setUser_name(text_Username.getText());
					((User) mng.getActiveUser()).setNickname(text_Nickname.getText());
					mng.getActiveUser().setEmail(text_Email.getText());
					mng.getActiveUser().setPassword(JPassword.getText());
					mng.getActiveUser().getPhone().setCode(text_Phone.getText().substring(0, 4));
					mng.getActiveUser().getPhone().setNumber(text_Phone.getText().substring(4, 9));
					mng.getActiveUser().getPhone().setType(phoneType.getSelectedItem().toString());
					String[] a = text_Address.getText().split("/");
					mng.getActiveUser().getAddress().setCity(a[0]);
					mng.getActiveUser().getAddress().setCountry(a[1]);
					mng.getActiveUser().getAddress().setTown(a[2]);
					mng.getActiveUser().getAddress().setStreetname(a[3]);
					mng.getActiveUser().getBirthdate().setDay(Integer.valueOf((String)day.getSelectedItem()));
					mng.getActiveUser().getBirthdate().setMonth(Integer.valueOf((String)month.getSelectedItem()));
					mng.getActiveUser().getBirthdate().setYear(Integer.valueOf((String)year.getSelectedItem()));
					try {
						mng.updateUser();
						menuFrame.setVisible(true);
						profileFrame.setVisible(false);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			
				
			}
		});
			
		btn_SaveChanges.setFont(new Font("Tahoma", Font.BOLD, 20));
		btn_SaveChanges.setBounds(343, 442, 195, 53);
		profileFrame.getContentPane().add(btn_SaveChanges);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.setBackground(new Color(151,163,166));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuFrame.setVisible(true);
				profileFrame.setVisible(false);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setBounds(74, 442, 195, 53);
		profileFrame.getContentPane().add(btnNewButton);
	}
}