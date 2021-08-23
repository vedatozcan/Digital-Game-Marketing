import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

public class TransactionUI {

    private JFrame transactionFrame;
    private JPanel contentPane;


    public JFrame getTransactionFrame() {
        return transactionFrame;
    }


    public TransactionUI(JFrame gameFrame, Game game, Management mng) {

    	
        transactionFrame = new JFrame();
        transactionFrame.setTitle("DigitalGameMarketing / Transaction");
        transactionFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        transactionFrame.setBounds(100, 100, 973, 382);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(44,62,80));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        transactionFrame.setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton btnNewButton = new JButton();
        Image img = null;
		try {
			img = new ImageIcon(this.getClass().getResource("/"+ game.getName() +".png")).getImage();
		} catch (NullPointerException e) {
			img = new ImageIcon(this.getClass().getResource("/default.png")).getImage();
		}
		btnNewButton.setIcon(new ImageIcon(img.getScaledInstance(259, 140, Image.SCALE_DEFAULT)));
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnNewButton.setBounds(27, 30, 259, 140);
        btnNewButton.setBackground(new Color(108,122,137));
        contentPane.setLayout(null);
        contentPane.add(btnNewButton);

        JLabel lblgamename = new JLabel(game.getName());
        lblgamename.setForeground(Color.WHITE);
        lblgamename.setFont(new Font("Tahoma", Font.PLAIN, 30));
        lblgamename.setBounds(319, 67, 395, 50);
        contentPane.add(lblgamename);

        JLabel lblpricetag = new JLabel(String.valueOf(game.getPrice())+"TL");
        lblpricetag.setForeground(Color.WHITE);
        lblpricetag.setFont(new Font("Tahoma", Font.PLAIN, 23));
        lblpricetag.setBounds(752, 68, 126, 24);
        contentPane.add(lblpricetag);

        JButton btnPurchase = new JButton("Purchase");
        btnPurchase.setForeground(Color.WHITE);
        btnPurchase.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnPurchase.setBackground(new Color(151,163,166));
        btnPurchase.setBounds(674, 244, 269, 33);
        contentPane.add(btnPurchase);

        JButton btnRent = new JButton("Rent");
        if(((User) mng.getActiveUser()).getLibrary().getGame(game.getName()) != null
				&& ((User) mng.getActiveUser()).getLibrary().getGame(game.getName()).getStatus().equals("rent"))
    	{
        	btnRent.setForeground(Color.GRAY);
    	}
    	else 
    	{
    		btnRent.setForeground(Color.WHITE);
    	}
        
        btnRent.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnRent.setBackground(new Color(151,163,166));
        btnRent.setBounds(389, 244, 259, 33);
        contentPane.add(btnRent);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDateTime now = LocalDateTime.now();

        JLabel lblcurrentdate = new JLabel("Current Date: "+dtf.format(now));
        lblcurrentdate.setForeground(Color.WHITE);
        lblcurrentdate.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblcurrentdate.setBounds(27, 202, 269, 13);
        contentPane.add(lblcurrentdate);

        JTextArea textArea = new JTextArea("Do you wish to purchase or rent? \nPlease select an option to continue transaction.");
        textArea.setFont(new Font("Monospaced", Font.BOLD, 14));
        textArea.setEditable(false);
        textArea.setBounds(389, 184, 554, 50);
        contentPane.add(textArea);

        JButton btnNewButton_1 = new JButton("Back");
        btnNewButton_1.setForeground(Color.WHITE);
        btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                gameFrame.setVisible(true);
                transactionFrame.setVisible(false);
            }
        });
        btnNewButton_1.setBackground(new Color(151,163,166));
        btnNewButton_1.setBounds(27, 250, 100, 27);
        contentPane.add(btnNewButton_1);

        JComboBox comboBox = new JComboBox();
        comboBox.setFont(new Font("Tahoma", Font.BOLD, 14));
        comboBox.setForeground(Color.WHITE);
		comboBox.setBackground(new Color(108,122,137));
        comboBox.setModel(new DefaultComboBoxModel(new String[] {"Buy Digital Collector Edition " + (game.getPrice() + mng.getShipping().rateCalculation(game)) + "TL",
        		"Buy Standard Edition"}));
        comboBox.setBounds(674, 287, 269, 21);
        contentPane.add(comboBox);

        JComboBox comboBox_rent = new JComboBox();
        comboBox_rent.setModel(new DefaultComboBoxModel(new String[] {"30 Days " + (int)(game.getPrice()/10) + "TL" ,
                "60 Days " + (int)(((game.getPrice()*8)/100)*2) + "TL", "200 Days " + (int)(((game.getPrice()*6)/100)*6) + "TL"}));
        comboBox_rent.setForeground(Color.WHITE);
		comboBox_rent.setBackground(new Color(108,122,137));
        comboBox_rent.setFont(new Font("Tahoma", Font.BOLD, 14));
        comboBox_rent.setBounds(389, 287, 259, 21);
        contentPane.add(comboBox_rent);

        btnPurchase.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(comboBox.getSelectedItem().equals("Buy Standard Edition")) {
                    if(game.getStock() > 0)
                    {
                    	try {
                            JOptionPane.showMessageDialog(null,"The game has been added to your library successfully!");
                            mng.purchase(game);
                            game.setPurchase_count();
                        } catch (CloneNotSupportedException | IOException e1) {
                            e1.printStackTrace();
                        }
                    	game.setStock();
                    }
                    else 
                    {
                    	 JOptionPane.showMessageDialog(null,"physical game copy out of stock!");
					}
                }
                else if(comboBox.getSelectedItem().equals("Buy Digital Collector Edition")) {
                    if((((User) mng.getActiveUser()).getLibrary().getGame(game.getName()) != null
						&& !((User) mng.getActiveUser()).getLibrary().getGame(game.getName()).getStatus().equals("purchased"))
            			|| ((User) mng.getActiveUser()).getLibrary().getGame(game.getName()) == null)
                    {
                    	try {
                            JOptionPane.showMessageDialog(null,"The game has been added to your library successfully!");
                           
                            if(((User) mng.getActiveUser()).getLibrary().getGame(game.getName()) != null
            						&& ((User) mng.getActiveUser()).getLibrary().getGame(game.getName()).getStatus().equals("rent"))
                            {
                            	((User) mng.getActiveUser()).getLibrary().getGame(game.getName()).setStatus("purchased");
                            	((User) mng.getActiveUser()).getLibrary().getGame(game.getName()).setRental_period(0);
                            	 mng.updatelibrary();
                            }
                            else {
                            	mng.purchase(game);
							}
                            
                            
                            game.setPurchase_count();
                        } catch (CloneNotSupportedException | IOException e1) {
                            e1.printStackTrace();
                        }
                    }
                    else 
                    {
                    	JOptionPane.showMessageDialog(null,"The digital copy of the game is available in your library");
					}
                }
            }
        });
        
  

        btnRent.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	btnRent.setForeground(Color.GRAY);
            	if((((User) mng.getActiveUser()).getLibrary().getGame(game.getName()) != null
						&& !((User) mng.getActiveUser()).getLibrary().getGame(game.getName()).getStatus().equals("rent")
						&& !((User) mng.getActiveUser()).getLibrary().getGame(game.getName()).getStatus().equals("purchased"))
            			
            			|| ((User) mng.getActiveUser()).getLibrary().getGame(game.getName()) == null)
            	{
            		if(comboBox_rent.getSelectedIndex() == 0) {
                        try {
                            JOptionPane.showMessageDialog(null,"The game has been rent to your library for a month successfully!");
                            mng.rent(game, 1);
                        } catch (CloneNotSupportedException | IOException e1) {
                            e1.printStackTrace();
                        }
                    }
                    else if(comboBox_rent.getSelectedIndex() == 1) {
                        try {
                            JOptionPane.showMessageDialog(null,"The game has been rent to your library for 2 months successfully!");
                            mng.rent(game, 2);
                        } catch (CloneNotSupportedException | IOException e1) {
                            e1.printStackTrace();
                        }
                    }
                    else if(comboBox_rent.getSelectedIndex() == 2) {
                        try {
                            JOptionPane.showMessageDialog(null,"The game has been rent to your library for 6 months successfully!");
                            mng.rent(game, 6);
                        } catch (CloneNotSupportedException | IOException e1) {
                            e1.printStackTrace();
                        }
                    }
            	}
            	else 
            	{
            		JOptionPane.showMessageDialog(null,"You have already rented the game");
				}
            	
            	
            }
        });

    }
}