import javax.swing.*;
import javax.swing.Timer;
import java.awt.Color;
import java.awt.event.*;
public class Admin extends JFrame implements ActionListener
{
	private static final int WIDTH = 800;
	private static final int HEIGHT = 500;
	public static boolean check = false;
	
	private JButton delete, shop, logout;
	private JLabel top, title, message;
	public static JFrame del, log, frame;
	
	public Admin()
	{
		setSize(WIDTH, HEIGHT);
		createComponents();
	}	
	public void createComponents()
	{
		setLayout(null);
		
		delete = new JButton("Delete An Account");
		shop = new JButton("Go To Shop");
		logout = new JButton("Log Out");
		
		top = new JLabel("Welcome, " + Login.cust);
		title = new JLabel("What Would You Like To Do?");
		message = new JLabel("");
		
		top.setBounds(320, 40, 200, 30);
		title.setBounds(320, 100, 300, 30);
		delete.setBounds(305, 150, 200, 30);
		shop.setBounds(305, 190, 200, 30);
		logout.setBounds(305, 300, 200, 30);
		message.setBounds(330, 70, 150, 30);
		
		add(top);
		add(delete);
		add(title);
		add(shop);
		add(logout);
		add(message);
		
		message.setForeground(Color.RED);
		
		this.delete.addActionListener(this);
		this.shop.addActionListener(this);
		this.logout.addActionListener(this);		
	}	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == delete)
		{
			if(check == true)
			{
				message.setText("Window is Already Open");
				Timer timer = new Timer(2000, new ActionListener()
				{
					public void actionPerformed(ActionEvent e) 
					{
						message.setText("");	
					}
				});
				timer.setRepeats(false);
				timer.start();
			}
			else if(check ==false)
			{
				del = new Delete();
				del.setTitle("Admin Console");
				del.setDefaultCloseOperation(EXIT_ON_CLOSE);
				del.setVisible(true);
				check = true;
			}			
		}
		else if(e.getSource() == shop)
		{
			if(check == true)
			{
				message.setText("Close Open Window First");
				Timer timer = new Timer(2000, new ActionListener()
				{
					public void actionPerformed(ActionEvent e) 
					{
						message.setText("");	
					}
				});
				timer.setRepeats(false);
				timer.start();
			}
			else if(check == false)
			{
				frame = new CartButton();   
				frame.setTitle("Welcome To The Shop!");
				frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
				frame.setVisible(true); 		        
				this.dispose();	
			}
		}
		else if(e.getSource() == logout)
		{
			if(check == true)
			{
				message.setText("Close Open Window First");
				Timer timer = new Timer(2000, new ActionListener()
				{
					public void actionPerformed(ActionEvent e) 
					{
						message.setText("");	
					}
				});
				timer.setRepeats(false);
				timer.start();
			}
			else if(check == false)
			{
				this.dispose();
				Login.clearLog();
				Login.clearInfo();
			}
		}
	}
	public static void exitFrame()
	{
		frame.dispose();
	}
}
