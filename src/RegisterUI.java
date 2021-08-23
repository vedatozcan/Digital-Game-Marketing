import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.SystemColor;

public class RegisterUI {

	private JFrame registerFrame;
	private JTextField j_Lastname;
	private JTextField j_Email;
	private JTextField j_Address;
	private JButton signButton;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JTextField j_Firstname;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JTextField j_Username;
	private JLabel lblNewLabel_7;
	private JButton cancelButton;
	private JPasswordField j_Password;
	private JPasswordField j_ConfirmPassword;
	private JComboBox day;
	private JComboBox month;
	private JComboBox year;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_9;
	private JLabel lblNewLabel_10;

    private String dates[] 
		        = { "1", "2", "3", "4", "5", 
		            "6", "7", "8", "9", "10", 
		            "11", "12", "13", "14", "15", 
		            "16", "17", "18", "19", "20", 
		            "21", "22", "23", "24", "25", 
		            "26", "27", "28", "29", "30", 
		            "31" }; 
    private String months[] 
	 	        = { "1", "2", "3", "4", 
		            "5", "6", "7", "8", 
		            "9", "10", "11", "12" }; 
    private String years[] 
		        = { "1990", "1991", "1992", "1993", 
		            "1994", "1995", "1996", "1997", 
		            "1998", "1999", "2000", "2001", 
		            "2002", "2003", "2004", "2005", 
		            "2006", "2007", "2008", "2009", 
		            "2010"}; 
    private JTextField j_PhoneField;
    private JLabel lblNewLabel_11;
    private JTextField textFieldNickname;
 
	
	
	public JFrame getRegisterFrame() {
		return registerFrame;
	}



	public void setRegisterFrame(JFrame registerFrame) {
		this.registerFrame = registerFrame;
	}



	public RegisterUI(Management mng, JFrame loginFrame) {
		
		registerFrame = new JFrame();
		registerFrame.setTitle("DigitalGameMarketing / Register");
		registerFrame.getContentPane().setBackground(new Color(44,62,80));
		registerFrame.setBounds(100, 100, 662, 634);
		registerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		registerFrame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Firstname:");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(67, 31, 89, 24);
		registerFrame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Lastname:");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(67, 66, 89, 24);
		registerFrame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Email:");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(97, 302, 89, 24);
		registerFrame.getContentPane().add(lblNewLabel_2);
		
		j_Firstname = new JTextField();
		j_Firstname.setFont(new Font("Tahoma", Font.BOLD, 14));
		j_Firstname.setBackground(new Color(108,122,137));
		j_Firstname.setBounds(147, 32, 167, 24);
		registerFrame.getContentPane().add(j_Firstname);
		j_Firstname.setColumns(10);
		
		j_Lastname = new JTextField();
		j_Lastname.setFont(new Font("Tahoma", Font.BOLD, 14));
		j_Lastname.setBounds(147, 67, 167, 24);
		j_Lastname.setBackground(new Color(108,122,137));
		registerFrame.getContentPane().add(j_Lastname);
		j_Lastname.setColumns(10);
		
		j_Email = new JTextField();
		j_Email.setFont(new Font("Tahoma", Font.BOLD, 14));
		j_Email.setBounds(147, 303, 225, 24);
		j_Email.setBackground(new Color(108,122,137));
		registerFrame.getContentPane().add(j_Email);
		j_Email.setColumns(10);
		
		j_Address = new JTextField();
		j_Address.setFont(new Font("Tahoma", Font.BOLD, 14));
		j_Address.setBounds(147, 399, 321, 114);
		j_Address.setBackground(new Color(108,122,137));
		registerFrame.getContentPane().add(j_Address);
		j_Address.setColumns(10);
			
		lblNewLabel_3 = new JLabel("Birthdate:");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(67, 362, 89, 24);
		registerFrame.getContentPane().add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Address:");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_4.setBounds(78, 399, 78, 24);
		registerFrame.getContentPane().add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("Create Password:");
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_5.setBounds(18, 182, 137, 24);
		registerFrame.getContentPane().add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("Confirm Password:");
		lblNewLabel_6.setForeground(Color.WHITE);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_6.setBounds(12, 227, 143, 24);
		registerFrame.getContentPane().add(lblNewLabel_6);
		
		j_Username = new JTextField();
		j_Username.setFont(new Font("Tahoma", Font.BOLD, 14));
		j_Username.setBounds(147, 104, 167, 26);
		j_Username.setBackground(new Color(108,122,137));
		registerFrame.getContentPane().add(j_Username);
		j_Username.setColumns(10);
		
		lblNewLabel_7 = new JLabel("Username:");
		lblNewLabel_7.setForeground(Color.WHITE);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_7.setBounds(66, 104, 89, 24);
		registerFrame.getContentPane().add(lblNewLabel_7);
			
		j_Password = new JPasswordField();
		j_Password.setFont(new Font("Tahoma", Font.BOLD, 14));
		j_Password.setBounds(146, 183, 226, 25);
		j_Password.setBackground(new Color(108,122,137));
		registerFrame.getContentPane().add(j_Password);
		
		j_ConfirmPassword = new JPasswordField();
		j_ConfirmPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		j_ConfirmPassword.setBackground(new Color(108,122,137));
		j_ConfirmPassword.setBounds(147, 228, 225, 24);
		registerFrame.getContentPane().add(j_ConfirmPassword);
		
		day = new JComboBox(dates);
		day.setFont(new Font("Tahoma", Font.BOLD, 14));
		day.setBackground(new Color(108,122,137));
		day.setBounds(147, 365, 53, 21);
		registerFrame.getContentPane().add(day);
		
		month = new JComboBox(months);
		month.setBackground(new Color(108,122,137));
		month.setFont(new Font("Tahoma", Font.BOLD, 14));
		month.setBounds(227, 365, 54, 21);
		registerFrame.getContentPane().add(month);
		
		year = new JComboBox(years);
		year.setBackground(new Color(108,122,137));
		year.setFont(new Font("Tahoma", Font.BOLD, 14));
		year.setBounds(305, 365, 68, 21);
		registerFrame.getContentPane().add(year);
		
		lblNewLabel_8 = new JLabel("Day");
		lblNewLabel_8.setForeground(Color.WHITE);
		lblNewLabel_8.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblNewLabel_8.setBounds(147, 348, 39, 13);
		registerFrame.getContentPane().add(lblNewLabel_8);
		
		lblNewLabel_9 = new JLabel("Month");
		lblNewLabel_9.setForeground(Color.WHITE);
		lblNewLabel_9.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblNewLabel_9.setBounds(227, 348, 46, 13);
		registerFrame.getContentPane().add(lblNewLabel_9);
		
		lblNewLabel_10 = new JLabel("Year");
		lblNewLabel_10.setForeground(Color.WHITE);
		lblNewLabel_10.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblNewLabel_10.setBounds(305, 348, 31, 13);
		registerFrame.getContentPane().add(lblNewLabel_10);
		
		j_PhoneField = new JTextField();
		j_PhoneField.setFont(new Font("Tahoma", Font.BOLD, 14));
		j_PhoneField.setBounds(147, 265, 224, 24);
		j_PhoneField.setBackground(new Color(108,122,137));
		registerFrame.getContentPane().add(j_PhoneField);
		j_PhoneField.setColumns(10);
		
		lblNewLabel_11 = new JLabel(" Phone:");
		lblNewLabel_11.setForeground(Color.WHITE);
		lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_11.setBounds(86, 265, 89, 24);
		registerFrame.getContentPane().add(lblNewLabel_11);
		
		signButton = new JButton("SIGN UP");
		signButton.setForeground(Color.WHITE);
		signButton.setFont(new Font("Source Sans Pro Black", Font.BOLD, 18));
		signButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
		            if(mng.getSocial().getUserMap().get(j_Username.getText()) == null)
		            {
		            	String name = j_Firstname.getText();  
			            String lastName = j_Lastname.getText(); 
			            String phone = j_PhoneField.getText();
			            String code="";
			            String number = ""; 
			            String type = "Mobile";
			            for (int i = 0; i < phone.length(); i++) {
							if(i==0||i==1||i==2) {
								code += phone.charAt(i);
							}
							else if (i==3||i==4||i==5||i==6||i==7||i==8||i==9) 
							{
								number += phone.charAt(i);
							}		
						}
			            Phone phoneNumber = new Phone(code,number,type);
			            String email  = j_Email.getText();  
			            String[] a = j_Address.getText().split("/"); 
			            Address address= new Address(a[0],a[1],a[2],a[3]);
			            String username = j_Username.getText();
			            int d = Integer.valueOf((String) day.getSelectedItem());
			            int m = Integer.valueOf((String) month.getSelectedItem());
			            int y = Integer.valueOf((String) year.getSelectedItem());
			            Date birthdate = new Date(d,m,y); 
			            if (j_ConfirmPassword.getText().equals(j_Password.getText()) ) {	            	
							
			            	User user= new User(username,name,lastName,textFieldNickname.getText(),j_Password.getText(),email,address,phoneNumber,birthdate);
							try {
								mng.register(user.getUser_name(), user);
								JOptionPane.showMessageDialog(null, "Registration completed successfully!");
								loginFrame.setVisible(true);
								registerFrame.setVisible(false);
								
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
			            else 
			            {
			            	JOptionPane.showMessageDialog(registerFrame.getContentPane(), "Passwords do not match ");
						}
			            
		            }
		            else 
		            {
		            	JOptionPane.showMessageDialog(null,"you can't get " + j_Username.getText()  + " username");
					}
				}
			}
		);
		signButton.setBackground(new Color(197,57,43));
		signButton.setBounds(333, 526, 137, 37);
		registerFrame.getContentPane().add(signButton);
			
		cancelButton = new JButton("LOGIN");
		cancelButton.setBackground(new Color(34,167,240));
		cancelButton.setForeground(Color.WHITE);
		cancelButton.setFont(new Font("Source Sans Pro Black", Font.BOLD, 18));
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				loginFrame.setVisible(true);
				registerFrame.setVisible(false);
				
			}});
		cancelButton.setBounds(147, 526, 137, 37);
		registerFrame.getContentPane().add(cancelButton);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 14));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Mobile", "Home"}));
		comboBox.setBackground(new Color(108,122,137));
		comboBox.setBounds(427, 266, 78, 22);
		registerFrame.getContentPane().add(comboBox);
		
		JLabel lblNewLabel_12 = new JLabel("Type :");
		lblNewLabel_12.setForeground(Color.WHITE);
		lblNewLabel_12.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_12.setBounds(382, 268, 56, 16);
		registerFrame.getContentPane().add(lblNewLabel_12);
		
		textFieldNickname = new JTextField();
		textFieldNickname.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldNickname.setBackground(new Color(108,122,137));
		textFieldNickname.setBounds(147, 143, 225, 26);
		registerFrame.getContentPane().add(textFieldNickname);
		textFieldNickname.setColumns(10);
		
		JLabel lblNewLabel_13 = new JLabel("Nick Name:");
		lblNewLabel_13.setForeground(Color.WHITE);
		lblNewLabel_13.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_13.setBounds(60, 143, 96, 26);
		registerFrame.getContentPane().add(lblNewLabel_13);
	}
}