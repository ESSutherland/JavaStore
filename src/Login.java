import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class Login extends JFrame implements ActionListener
{
	private static final int WIDTH = 800;
	private static final int HEIGHT = 500;
	public static int max, j = 0;		
	public String user, pass, con;	
	public static String cust = "";
	public static double funds;	
	private JButton button, button1, close;	
	public static JTextField name;
	public static JPasswordField code;	
	private JLabel l1, l2, top, wrong;	
	public static JFrame frame, f, admin;
	public static boolean log = false;	
	
	Lists list = new Lists();	
	public Login()
	{
		setSize(WIDTH, HEIGHT);
		createComponents();
	}
	public void createComponents() 
	{
		setLayout(null);
	
		name = new JTextField(20);
		code = new JPasswordField(10);
	
		l1 = new JLabel("Username:");
		l2 = new JLabel("Password:");
		top = new JLabel("Online Shop Login");
	
		button = new JButton("Login");
		button1 = new JButton("Register");
		close = new JButton("Exit");
	
		name.setBounds(300 , 160 , 250 , 30);
		code.setBounds(300 , 200 , 250 , 30);
		l1.setBounds(200 , 160 , 100 , 30);
		l2.setBounds(200 , 200 , 100 , 30);
		top.setBounds(360, 80, 200, 30);
		button.setBounds(320, 240, 100, 30);
		button1.setBounds(430, 240, 100, 30);
		close.setBounds(375, 280, 100, 30);
	
		code.setEchoChar('*');
		
		add(name);
		add(code);
		add(l1);
		add(l2);
		add(top);
		add(button);
		add(button1);
		add(close);
	
		wrong = new JLabel("");
		wrong.setBounds(350, 120, 200, 30);
		wrong.setForeground(Color.RED);
		add(wrong);
		
		this.button.addActionListener(this);
		this.button1.addActionListener(this);
		this.close.addActionListener(this);
	}	
	public void actionPerformed(ActionEvent e)
	{		 	
		user = name.getText().trim();
		pass = code.getText();
		if(e.getSource() == button)
		{	
			if(log == true && con.equalsIgnoreCase(user))
			{
				wrong.setText("You Are Alreay Signed In");
				Timer timer = new Timer(2000, new ActionListener()
				{
					public void actionPerformed(ActionEvent w) 
					{
						wrong.setText("");	
					}
				});
				timer.setRepeats(false);
				timer.start();			
			}
			if(log == true && !con.equalsIgnoreCase(user))
			{
				wrong.setText("Another User Is Signed In");
				Timer timer = new Timer(2000, new ActionListener()
				{
					public void actionPerformed(ActionEvent w) 
					{
						wrong.setText("");	
					}
				});
				timer.setRepeats(false);
				timer.start();			
			}
			if(log == false)
			{				
				for(int i = 0; i < list.getSize("users"); i++)
				{
					if(user.equalsIgnoreCase(list.getUser(i)) && pass.equals(list.getPass(i)))
					{
						con = list.getUser(i);
						cust = list.getName(i);
						funds = list.getFunds(i);
						j = i;					
						log = true;
						if(user.equalsIgnoreCase("ESSutherland"))
						{
							admin = new Admin();
							admin.setTitle("Admin Console");
							admin.setDefaultCloseOperation(EXIT_ON_CLOSE);
							admin.setVisible(true);
						}
						else
						{			
							frame = new CartButton();   
							frame.setTitle("Welcome To The Shop!");
							frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
							frame.setVisible(true); 						
						}								
					}							
				}
				if(cust.equals(""))
				{
					clearInfo();
					wrong.setText("Invalid User/Password");
					Timer timer = new Timer(2000, new ActionListener()
					{
						public void actionPerformed(ActionEvent w) 
						{
							wrong.setText("");	
						}
					});
					timer.setRepeats(false);
					timer.start();
				}
			}			
		}		
		else if(e.getSource() == button1)
		{
			f = new Register();
			f.setTitle("Register An Account");
			f.setDefaultCloseOperation(EXIT_ON_CLOSE);
			f.setVisible(true);		
		}
		else if(e.getSource() == close)
		{
			System.exit(0);
		}
		
	}	
	public String check()
	{
		String c = "";
		for (int k = 0; k < list.getSize("users"); k++)
		{
			if(user.equalsIgnoreCase(list.getUser(k)))
			{
				c = "copy";
			}
		}
		return c;
	}
	public static void clearInfo()
	{
		name.setText("");
		code.setText("");
	}
	public static void clearLog()
	{
		log = false;
		cust = "";
	}
}
