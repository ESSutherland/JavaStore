import javax.swing.*;

import java.awt.Color;
import java.awt.event.*;
import java.text.*;

public class CartButton extends JFrame implements ActionListener
{
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;
	private JButton button, button1, button2, button3, button4, button5, button6, end, clear, logout;
	private JLabel a, a1, a2, a3, a4, a5, a6, fund, l, totalL, title, title2, warn;       
	public static JFrame f;
	int y = 60;        
	public static int n, n1, n2, n3, n4, n5, n6 = 0;       
	int lim, lim1, lim2, lim3, lim4, lim5, lim6, max;                
	double tot = 0;
         
	Lists list = new Lists();
	NumberFormat money = NumberFormat.getCurrencyInstance();
         
	String custName = Login.cust;
         
	public CartButton()
	{            
		setSize(WIDTH, HEIGHT);
		createComponents();
	}         
	private void createComponents()
	{       
		setLayout(null);          
          
		this.button = new JButton(list.getNames(0));
		this.button1 = new JButton(list.getNames(1));
		this.button2 = new JButton(list.getNames(2));
		this.button3 = new JButton(list.getNames(3));
		this.button4 = new JButton(list.getNames(4));
		this.button5 = new JButton(list.getNames(5));
		this.button6 = new JButton(list.getNames(6));         
		this.logout = new JButton("Log Out");         
		this.clear = new JButton("Clear Cart");
          
		for(int i = 0; i < list.getSize("nums"); i++)
		{
			l = new JLabel(money.format(list.getNums(i)));
			l.setBounds(500 , y , 100 , 30);       	  
			add(l);
			y = y + 40; 				
		}                  
		a = new JLabel("Q: " + n);
        a1 = new JLabel("Q: " + n1);
        a2 = new JLabel("Q: " + n2);
        a3 = new JLabel("Q: " + n3);
        a4 = new JLabel("Q: " + n4);
        a5 = new JLabel("Q: " + n5);
        a6 = new JLabel("Q: " + n6);
          
        totalL = new JLabel("Total: " + money.format(tot));
          
        title = new JLabel("Goodman Groceries");
        title2 = new JLabel("Welcome, " + custName + "!");
          
        fund = new JLabel ("Current Funds: " + money.format(list.getFunds(Login.j)));
        warn = new JLabel ("");
        warn.setForeground(Color.RED);
          
        end = new JButton("To Checkout");
                                  
        add(button);
        add(button1);
        add(button2);
        add(button3);
        add(button4);
        add(button5);
        add(button6);                   
        add(clear);      
        add(logout); 
        add(a);
        add(a1);
        add(a2);
        add(a3);
        add(a4);
        add(a5);
        add(a6);
        add(totalL);
        add(title);
        add(title2);      
        add(warn);       
        add(fund);        
        add(end); 
        
        title.setBounds(340, 30, 200 ,30);
        title2.setBounds(330, 10, 200 ,30);                
        button.setBounds(350 , 60 , 100 , 30);
        button1.setBounds(350 , 100 , 100 , 30);
        button2.setBounds(350 , 140 , 100 , 30);
        button3.setBounds(350 , 180 , 100 , 30);
        button4.setBounds(350 , 220 , 100 , 30);
        button5.setBounds(350 , 260 , 100 , 30);
        button6.setBounds(350 , 300 , 100 , 30);        
        a.setBounds(270 , 60 , 100 , 30);
        a1.setBounds(270 , 100 , 100 , 30);
        a2.setBounds(270 , 140 , 100 , 30);
        a3.setBounds(270 , 180 , 100 , 30);
        a4.setBounds(270 , 220 , 100 , 30);
        a5.setBounds(270 , 260 , 100 , 30);
        a6.setBounds(270 , 300 , 100 , 30);         
        totalL.setBounds(370 , 360 , 100 , 30);       
        fund.setBounds(340 , 380 , 200 , 30);         
        clear.setBounds(325 , 460 , 150 , 30);         
        logout.setBounds(325 , 500 , 150 , 30);          
        end.setBounds(325 , 420 , 150 , 30);
          
          
        this.button.addActionListener(this);
        this.button1.addActionListener(this);
        this.button2.addActionListener(this);
        this.button3.addActionListener(this);
        this.button4.addActionListener(this);
        this.button5.addActionListener(this);
        this.button6.addActionListener(this);         
        this.end.addActionListener(this);  
        this.logout.addActionListener(this);          
        this.clear.addActionListener(this);
	}             
	public void actionPerformed(ActionEvent e)
	{ 
		int code;
        double two;
        String one = "null";
        if(e.getSource() == button)
        {
        	code = 0;
        	if(lim < 3 && max < 10)
        	{
        		one = list.getNames(code);
        		two = list.getNums(code);
        		list.secondList(one, two);
        		n++;
        		a.setText("Q: " + n);
        		tot = tot + two;
        		totalL.setText("Total: " + money.format(tot));
        		lim++;
        	max++;
        	}
        	else if(lim == 3 && max < 10)
        	{
        		printWarn(code);
        	}
        	else if(max == 10)
        	{
        		printWarn2();
        	}
        }        
        else if(e.getSource() == button1)
        {
        	code = 1;
        	if(lim1 < 3 && max < 10)
        	{ 
        		one = list.getNames(code);
        		two = list.getNums(code);
        		list.secondList(one, two);
        		n1++;
        		a1.setText("Q: " + n1);
        		tot = tot + two;
        		totalL.setText("Total: " + money.format(tot));
        		lim1++;
        		max++;
        	}
        	else if(lim1 == 3 && max < 10)
        	{
        		printWarn(code);
        	}
        	else if(max == 10)
        	{
        		printWarn2();
        	}
        }       
        else if(e.getSource() == button2)
        {
        	code = 2;
        	if(lim2 < 3 && max < 10)
        	{
        		one = list.getNames(code);
        		two = list.getNums(code);
        		list.secondList(one, two);
        		n2++;
        		a2.setText("Q: " + n2);
        		tot = tot + two;
        		totalL.setText("Total: " + money.format(tot));
        		lim2++;
        		max++;
        	}
        	else if(lim2 == 3 && max < 10)
        	{
        		printWarn(code);
        	}
        	else if(max == 10)
        	{
        		printWarn2();
        	}
        }        
        else if(e.getSource() == button3)
        {
        	code = 3;
        	if(lim3 < 3 && max < 10)
        	{
        		one = list.getNames(code);
        		two = list.getNums(code);
        		list.secondList(one, two);
        		n3++;
        		a3.setText("Q: " + n3);
        		tot = tot + two;
        		totalL.setText("Total: " + money.format(tot));
        		lim3++;
        		max++;
        	}
        	else if(lim3 == 3 && max < 10)
        	{
        		printWarn(code);
        	}
        	else if(max == 10)
        	{
        		printWarn2();
        	}
        }        
        else if(e.getSource() == button4)
        {
        	code = 4;
        	if(lim4 < 3 && max < 10)
        	{
        		one = list.getNames(code);
        		two = list.getNums(code);
        		list.secondList(one, two);
        		n4++;
        		a4.setText("Q: " + n4);
        		tot = tot + two;
        		totalL.setText("Total: " + money.format(tot));
        		lim4++;
        		max++;
        	}
        	else if(lim4 == 3 && max < 10)
        	{
        		printWarn(code);
        	}
        	else if(max == 10)
        	{
        		printWarn2();
        	}
        }       
        else if(e.getSource() == button5)
        {
        	code = 5;
        	if(lim5 < 3 && max < 10)
        	{
        		one = list.getNames(code);
        		two = list.getNums(code);
        		list.secondList(one, two);
        		n5++;
        		a5.setText("Q: " + n5);
        		tot = tot + two;
        		totalL.setText("Total: " + money.format(tot));
        		lim5++;
        		max++;
        	}
        	else if(lim5 == 3 && max < 10)
        	{
        		printWarn(code);
        	}
        	else if(max == 10)
        	{
        		printWarn2();
        	}
        }
        else if(e.getSource() == button6)
        {
        	code = 6;
        	if(lim6 < 3 && max < 10)
        	{
        		one = list.getNames(code);
        		two = list.getNums(code);
        		list.secondList(one, two);
        		n6++;
        		a6.setText("Q: " + n6);
        		tot = tot + two;
        		totalL.setText("Total: " + money.format(tot));
        		lim6++;
        		max++;
        	}
        	else if(lim6 == 3 && max < 10)
        	{
        		printWarn(code);
        	}
        	else if(max == 10)
        	{
        		printWarn2();
        	}
        }
       	else if(e.getSource() == end)
        {
       		if(max == 0)
       		{
       			warn.setBounds(355, 335, 300, 30);
       			warn.setText("No Items In Cart");
       			Timer timer = new Timer(2000, new ActionListener()
       			{
       				public void actionPerformed(ActionEvent e) 
       				{
       					warn.setText("");	
       				}
       			});
       			timer.setRepeats(false);
       			timer.start();
       			}
       		else if(tot > list.getFunds(Login.j))
         	{
       			warn.setBounds(350, 335, 300, 30);
         		warn.setText("Insuffecient Funds");
         		Timer timer = new Timer(2000, new ActionListener()
         		{
         			public void actionPerformed(ActionEvent e) 
         			{
         				warn.setText("");	
         			}
         		});
         		timer.setRepeats(false);
         		timer.start();
         	}
         	else
         	{
         		f = new NewFrame();
         		f.setTitle("Welcome To The Shop!");
         		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         		f.setVisible(true);
         	}       
        } 
        else if (e.getSource() == clear)
        {
         	tot = 0;
         	totalL.setText("Total: " + money.format(tot));
         	n = 0;
         	n1 = 0;
         	n2 = 0;
         	n3 = 0;
         	n4 = 0;
         	n5 = 0;
         	n6 = 0; 
         	lim = 0;
         	lim1 = 0;
         	lim2 = 0;
         	lim3 = 0;
         	lim4 = 0;
         	lim5 = 0;
         	lim6 = 0;
         	max = 0;
         	a.setText("Q: " + n);
         	a1.setText("Q: " + n1);
         	a2.setText("Q: " + n2);
         	a3.setText("Q: " + n3);
         	a4.setText("Q: " + n4);
         	a5.setText("Q: " + n5);
         	a6.setText("Q: " + n6);  
         		
         	Lists.items.clear();
         	Lists.prices.clear();
         		
         	warn.setBounds(360, 335, 300, 30);
         	warn.setText("Cart Cleared");
         	Timer timer = new Timer(2000, new ActionListener()
         	{
         		public void actionPerformed(ActionEvent e) 
         		{
         			warn.setText("");	
         		}
         	});
         	timer.setRepeats(false);
         	timer.start();
             
         }
         else if(e.getSource() == logout)
         {
         	this.dispose();
         	Login.clearLog();
         	Login.clearInfo();        		        		
         }
	}
	public void printWarn(int i)
	{
		warn.setBounds(320, 335, 300, 30);
		warn.setText("You Cannot Add Any More " + list.getNames(i));
		Timer timer = new Timer(2000, new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				warn.setText("");	
			}
		});
		timer.setRepeats(false);
		timer.start();
	}
	public void printWarn2()
	{
		warn.setBounds(320, 335, 300, 30);
		warn.setText("You Cannot Add Any More Items");
		Timer timer = new Timer(2000, new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				warn.setText("");	
			}
		});
		timer.setRepeats(false);
		timer.start();
   	}
 }   