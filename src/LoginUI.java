import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

public class LoginUI {
   
	private JFrame login_frame;
    private JPanel contentPane;
    private JTextField in_username;
    private JPasswordField in_password;
    Management mng = new Management();
   
    public JFrame getLoginFrame() {
		return login_frame;
	}

	public void setLoginFrame(JFrame login_frame) {
		this.login_frame = login_frame;
	}

	public LoginUI() throws CloneNotSupportedException, IOException{
		
		login_frame = new JFrame();
    	login_frame.setTitle("DigitalGameMarketing");
    	login_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	login_frame.setBounds(100, 100, 593, 350);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(44,62,80));
        contentPane.setForeground(Color.BLACK);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        login_frame.setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("User Name:");
        lblNewLabel.setForeground(new Color(236,240,241));
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel.setBounds(118, 109, 103, 28);
        contentPane.add(lblNewLabel);

        in_username = new JTextField();
        in_username.setFont(new Font("Tahoma", Font.PLAIN, 14));
        in_username.setBackground(new Color(108,122,137));
        in_username.setForeground(Color.BLACK);
        in_username.setBounds(213, 107, 201, 34);
        contentPane.add(in_username);
        in_username.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("Password:");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_1.setForeground(new Color(236,240,241));
        lblNewLabel_1.setBounds(128, 162, 73, 16);
        contentPane.add(lblNewLabel_1);

        in_password = new JPasswordField();
        in_password.setFont(new Font("Tahoma", Font.PLAIN, 14));
        in_password.setBackground(new Color(108,122,137));
        in_password.setForeground(Color.BLACK);
        in_password.setBounds(213, 154, 201, 34);
        contentPane.add(in_password);

        JButton btnNewButton = new JButton("Login");
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {


            	User user = mng.getSocial().getUserMap().get(in_username.getText());
                if(user != null)
            	{
            		if(user.getPassword().equals(String.copyValueOf(in_password.getPassword())))
            		{   
            			mng.setActiveUser(user);
            			MenuUI menu = new MenuUI(mng, login_frame);
            			menu.getMenuFrame().setLocationRelativeTo(null);
            			menu.getMenuFrame().setVisible(true);
            			login_frame.setVisible(false);
            			in_username.setText("");
            			in_password.setText("");
            			
            		}
            		else
            		{
            			JOptionPane.showMessageDialog(contentPane, "Your password is incorrect!");

            		}
            	}
                else if(in_username.getText().equals(mng.getAdmin().getUser_name()))
                {
                	if(mng.getAdmin().getPassword().equals(String.copyValueOf(in_password.getPassword())))
            		{   
                		mng.setActiveUser(mng.getAdmin());
            			MenuUI menu = new MenuUI(mng, login_frame);
            			menu.getMenuFrame().setLocationRelativeTo(null);
            			menu.getMenuFrame().setVisible(true);
            			login_frame.setVisible(false);
            			in_username.setText("");
            			in_password.setText("");
            			
            		}
            		else
            		{
            			JOptionPane.showMessageDialog(contentPane, "Your password is incorrect!");

            		}
                }
                else {
                	
                	JOptionPane.showMessageDialog(contentPane, in_username.getText() + " does not exist!");

                }

            }
        });
        btnNewButton.setBackground(new Color(34,167,240));
        btnNewButton.setForeground(Color.WHITE);
        btnNewButton.setBounds(309, 201, 146, 46);
        contentPane.add(btnNewButton);

        JButton btnNewButton_1 = new JButton("Register");
        btnNewButton_1.setForeground(Color.WHITE);
        btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnNewButton_1.setBackground(new Color(197,57,43));
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	RegisterUI registerUI = new RegisterUI(mng, login_frame);
            	registerUI.getRegisterFrame().setVisible(true);
            	registerUI.getRegisterFrame().setLocationRelativeTo(null);
            	login_frame.setVisible(false);
            }
        });
        btnNewButton_1.setBounds(138, 201, 146, 46);
        contentPane.add(btnNewButton_1);
        
        JLabel lblNewLabel_2 = new JLabel("DEU GAMES");
        lblNewLabel_2.setForeground(Color.WHITE);
        lblNewLabel_2.setFont(new Font("Calibri", Font.PLAIN, 31));
        lblNewLabel_2.setBounds(213, 13, 448, 67);
        contentPane.add(lblNewLabel_2);
    }
}
