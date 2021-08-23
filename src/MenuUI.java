import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class MenuUI {

    private JFrame menuFrame;
    private JPanel contentPane;

    public JFrame getMenuFrame() {
        return menuFrame;
    }

    public void setMenuFrame(JFrame menuFrame) {
        this.menuFrame = menuFrame;
    }

    public MenuUI(Management mng, JFrame loginFrame) {

        menuFrame = new JFrame();
        menuFrame.setTitle("DigitalGameMarketing / Menu");
        menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menuFrame.setBounds(100, 100, 525, 351);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setBackground(new Color(44,62,80));
        contentPane.setForeground(Color.BLACK);
        menuFrame.setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton btnNewButton = new JButton("Market");
        btnNewButton.setForeground(Color.WHITE);
        btnNewButton.setBackground(new Color(151,163,166));
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MarketUI marketUI = new MarketUI(menuFrame, mng);
                marketUI.getMarketFrame().setLocationRelativeTo(null);
                marketUI.getMarketFrame().setVisible(true);
                menuFrame.setVisible(false);
            }
        });
        btnNewButton.setBounds(108, 71, 310, 25);
        contentPane.add(btnNewButton);

        JButton btnNewButton_1 = new JButton("Social");
        btnNewButton_1.setForeground(Color.WHITE);
        btnNewButton_1.setBackground(new Color(151,163,166));
        btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
            	SocialUI socialUI = null;
				try {
					socialUI = new SocialUI(menuFrame, mng);
				} catch (QueueEmpty e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            	socialUI.getSocialFrame().setLocationRelativeTo(null);
            	socialUI.getSocialFrame().setVisible(true);
            	menuFrame.setVisible(false);
            	
            }
        });
        btnNewButton_1.setBounds(108, 109, 310, 25);
        contentPane.add(btnNewButton_1);
      

        if(!mng.getActiveUser().equals(mng.getAdmin()))
        {
        	JButton btnNewButton_2 = new JButton("Library");
        	btnNewButton_2.setForeground(Color.WHITE);
            btnNewButton_2.setBackground(new Color(151,163,166));
        	btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 14));
            btnNewButton_2.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                	LibraryUI libraryUI = null;
    				try {
    					libraryUI = new LibraryUI(menuFrame, mng);
    				} catch (IOException e1) {
    					// TODO Auto-generated catch block
    					e1.printStackTrace();
    				}
                	libraryUI.getLibraryFrame().setLocationRelativeTo(null);
                	libraryUI.getLibraryFrame().setVisible(true);
                	menuFrame.setVisible(false);
                	
                }
            });
            btnNewButton_2.setBounds(108, 185, 310, 25);
            contentPane.add(btnNewButton_2);
            
            
            JButton btnNewButton_3 = new JButton("Profile");
            btnNewButton_3.setForeground(Color.WHITE);
            btnNewButton_3.setBackground(new Color(151,163,166));
            btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 14));
            btnNewButton_3.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                	ProfileUI profileUI = new ProfileUI(menuFrame, mng);
                	profileUI.getProfileFrame().setLocationRelativeTo(null);
                	profileUI.getProfileFrame().setVisible(true);
                	menuFrame.setVisible(false);
                }
            });
            btnNewButton_3.setBounds(108, 147, 310, 25);
            contentPane.add(btnNewButton_3);
            
            
        } 

        JButton exit_button = new JButton("Logout");
        exit_button.setForeground(Color.WHITE);
        exit_button.setBackground(new Color(151,163,166));
        exit_button.setFont(new Font("Tahoma", Font.BOLD, 14));
        exit_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                loginFrame.setVisible(true);
                menuFrame.setVisible(false);
            }
        });
        exit_button.setBounds(12, 266, 97, 25);
        contentPane.add(exit_button);
    }
}