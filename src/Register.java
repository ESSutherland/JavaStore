import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.text.DecimalFormat;
public class Register extends JFrame implements ActionListener
{
	private static final int WIDTH = 800;
	private static final int HEIGHT = 500;
	int max = 0;	
	private JLabel name, user, pass, title, wrong;	
	private JTextField name1, user1, pass1;	
	private JButton con, close;	
	String userCheck;
	
	Lists list = new Lists();
	
	public Register()
	{
		setSize(WIDTH, HEIGHT);
		createComponents();
	}
	public void createComponents()
	{
		setLayout(null);
		
		name = new JLabel("Full Name: ");
		user = new JLabel("Username: ");
		pass = new JLabel("Password: ");
		title = new JLabel("Register An Account");
		
		name1 = new JTextField(30);
		user1 = new JTextField(15);
		pass1 = new JTextField(15);
		
		con = new JButton("Register");
		close = new JButton("Back");
				
		name.setBounds(200 , 100 , 250 , 30);
		user.setBounds(200 , 140 , 250 , 30);
		pass.setBounds(200 , 180 , 250 , 30);
		name1.setBounds(300 , 100 , 250 , 30);
		user1.setBounds(300 , 140 , 250 , 30);
		pass1.setBounds(300 , 180 , 250 , 30);
		con.setBounds(360, 220, 100, 30);
		close.setBounds(360, 260, 100, 30);
		title.setBounds(360, 30, 250, 30);
		
		add(name);
		add(user);
		add(pass);
		add(name1);
		add(user1);
		add(pass1);
		add(con);
		add(title);
		add(close);
		
		wrong = new JLabel("");
		wrong.setBounds(360, 60, 200, 30);
		wrong.setForeground(Color.RED);
		add(wrong);
		
		this.con.addActionListener(this);	
		this.close.addActionListener(this);
	}			
	public void actionPerformed(ActionEvent e)
	{
		
		if(e.getSource() == con)
		{
			userCheck = user1.getText().trim();
		
			String w = check();
			if(!user1.getText().equals("") && !pass1.getText().equals("") && !name1.getText().equals("") && !w.equals("copy"))
			{
			
				try 
				{
					double fund = Math.random() * 300;
					for(;max < 1; max++)
					{
						PrintWriter userout = new PrintWriter("Users.txt");
						PrintWriter passout = new PrintWriter("Passwords.txt");
						PrintWriter nameout = new PrintWriter("Names.txt");
						PrintWriter fundout = new PrintWriter("Funds.txt");
			
						list.addPass(pass1.getText().trim());
						list.addUser(user1.getText().trim());
						list.addName(name1.getText().trim());
						list.addFunds(fund);
			
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
						this.dispose();
					}
				} 
				catch (FileNotFoundException e1) 
				{
					e1.printStackTrace();
				}
			}
			else if(w.equals("copy"))
			{
				wrong.setText("Username Already Exists");
				Timer timer = new Timer(2000, new ActionListener()
				{
					public void actionPerformed(ActionEvent e) 
					{
						wrong.setText("");	
					}
				});
				timer.setRepeats(false);
				timer.start();
			}
			else
			{
				wrong.setText("Enter All Information");
				Timer timer = new Timer(2000, new ActionListener()
				{
					public void actionPerformed(ActionEvent e) 
					{
						wrong.setText("");	
					}
				});
				timer.setRepeats(false);
				timer.start();
			}
		}
		else if(e.getSource() == close)
		{
			this.dispose();
		}
	}	
	public String check()
	{
		String c = "original";
		for (int k = 0; k < list.getSize("users"); k++)
		{
			if(userCheck.equalsIgnoreCase(list.getUser(k)))
			{
				c = "copy";
			}
		}
		return c;
	}	
}
