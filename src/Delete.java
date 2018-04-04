import javax.swing.*;
import javax.swing.Timer;

import java.awt.Color;
import java.awt.event.*;
import java.io.*;
import java.text.*;
import java.util.*;
public class Delete extends JFrame implements ActionListener
{
	private static final int WIDTH = 800;
	private static final int HEIGHT = 500;		
	private JLabel top, message, acc;
	private JButton delete, back;
	private JTextField text;	
	String user;
	int y = 210;
	
	Lists list = new Lists();
	public Delete()
	{
		setSize(WIDTH, HEIGHT);
		createComponents();
	}
	public void createComponents()
	{
		setLayout(null);
		
		top = new JLabel("Enter Account You Want To Delete");
		delete = new JButton("Delete");
		back = new JButton("Back");
		text = new JTextField(20);
		message = new JLabel("");
		
		top.setBounds(310, 40, 200, 30);
		text.setBounds(250, 100, 300, 30);
		delete.setBounds(340, 140, 120, 30);
		back.setBounds(340, 180, 120, 30);
		
		for(int i = 1; i < list.getSize("users"); i++)
		{		
			acc = new JLabel(list.getUser(i));
			acc.setBounds(350 , y , 200 , 30);
			y = y + 20;
			add(acc);
		}		
		
		add(top);
		add(text);
		add(delete);
		add(message);
		add(back);
		
		this.delete.addActionListener(this);
		this.back.addActionListener(this);		
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == delete)
		{
			user = text.getText().trim();
			for(int i = 0; i < list.getSize("users"); i++)
			{			
				if(user.equalsIgnoreCase(list.getUser(i)) && !user.equalsIgnoreCase("ESSutherland"))
				{				
					message.setForeground(Color.GREEN);
					message.setBounds(330, 70, 200, 30);
					message.setText("Account Deleted");
					Timer timer = new Timer(2000, new ActionListener()
					{
						public void actionPerformed(ActionEvent e) 
						{
							message.setText("");	
						}
					});
					timer.setRepeats(false);
					timer.start();
					list.removeCust(i);
    			
					try 
					{
						for(int k = 0; k < 1; k++)
						{
							PrintWriter userout = new PrintWriter("Users.txt");
							PrintWriter passout = new PrintWriter("Passwords.txt");
							PrintWriter nameout = new PrintWriter("Names.txt");
							PrintWriter fundout = new PrintWriter("Funds.txt"); 					
    					
							DecimalFormat dec = new DecimalFormat("#.##");
							for(int j = 0; j < list.getSize("users"); j++)
							{
								userout.println(list.getUser(j));
								passout.println(list.getPass(j));
								nameout.println(list.getName(j));
								fundout.println(dec.format(list.getFunds(j)));
							}							
							userout.close();
							passout.close();
							nameout.close();
							fundout.close();
						}   				
					}    						
					catch (FileNotFoundException e1) 
					{		
						e1.printStackTrace();
					}   			   			
				}			
				else if(user.equalsIgnoreCase("ESSutherland"))
				{
					message.setBounds(300, 70, 200, 30);
					message.setForeground(Color.RED);
					message.setText("Cannot Delete Admin Accounts");
					Timer timer = new Timer(2000, new ActionListener()
					{
						public void actionPerformed(ActionEvent e) 
						{
							message.setText("");	
						}
					});
					timer.setRepeats(false);
					timer.start();
					text.setText("");
				}
				else if(!user.equalsIgnoreCase(list.getUser(i)))
				{
					message.setBounds(330, 70, 200, 30);
					message.setForeground(Color.RED);
					message.setText("Non-existant Account");
					Timer timer = new Timer(2000, new ActionListener()
    				{
						public void actionPerformed(ActionEvent e) 
						{
							message.setText("");	
						}
    				});
					timer.setRepeats(false);
					timer.start();
					text.setText("");
				}	
			}			
		}
		else if(e.getSource() == back)
		{
			Admin.check = false;
			this.dispose();
		}			
	}	
}
