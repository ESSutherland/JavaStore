import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.text.*;
import java.util.*;

public class NewFrame extends JFrame implements ActionListener	
{
	private static final int WIDTH = 400;
	private static final int HEIGHT = 600;
	public ArrayList<String> cart = new ArrayList<String>();
	public static JFrame bill;
	private JLabel lab, totalL, num;	
	private JButton done, back;	
	int user;	
	int y = 20;
	double total,total1 = 0;
	
	Lists list = new Lists();
	NumberFormat money = NumberFormat.getCurrencyInstance();
	Login log = new Login();
	Admin ad = new Admin();
	public NewFrame()
	{
		setSize(WIDTH, HEIGHT);
		createComponents();
	}
	
	public void createComponents()
	{
		setLayout(null);
		printCart();
		for(int i = 0; i < cart.size(); i++)
		{		
			lab = new JLabel(cart.get(i));
			lab.setBounds(150 , y , 200 , 30);
			y = y + 40;
			add(lab);
		}
		for(int i = 0; i < list.getSize("items"); i++)
		{
			total1 = total1 + list.getPrice(i);
		}
		done = new JButton("Confirm Checkout");
		back = new JButton("Continue Shopping");
		totalL = new JLabel("Total: " + money.format(total1));
		num = new JLabel("Items: " + list.getSize("items"));
		
		add(done);
		add(back);
		add(totalL);
		add(num);
			
		done.setBounds(120, 470, 150, 30);
		back.setBounds(120, 510, 150, 30);
		totalL.setBounds(160, 420, 150, 30);
		num.setBounds(170, 440, 150, 30);
		
		this.done.addActionListener(this);
		this.back.addActionListener(this); 
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == done)
		{
			Store.frame.dispose();
			try
			{
				PrintWriter out = new PrintWriter("Bill.txt");
				out.println("Goodman Groceries \n");
				out.println("******** BILL *********");
				for(int i = 0; i < list.getSize("items"); i++)
				{
					double price = list.getPrice(i);
					String item = list.getItems(i);             
					total = total + price;
					out.println(item + " : " + money.format(price) + "\n");           
				}            
				double acc = Login.funds;
				acc = acc - total;
				Lists.account.set(Login.j, acc);
				PrintWriter pr = new PrintWriter("Funds.txt");
				DecimalFormat dec = new DecimalFormat("#.##");
				for(int i = 0; i < list.getSize("users"); i++)
				{
					pr.println(dec.format(list.getFunds(i)));
				}
				Lists.account.set(Login.j, acc);
				out.println("***********************");
				out.println("Items Purchased: " + list.getSize("items"));
				out.println("Total: " + money.format(total));
				out.println("Customer: " + list.getName(Login.j));
           
				bill = new Bill();
           
				bill.setTitle("Thanks For Shopping!");
				bill.setDefaultCloseOperation(EXIT_ON_CLOSE);
				bill.setVisible(true);

				out.close(); 
				pr.close();
				if(list.getUser(Login.j).equalsIgnoreCase("ESSutherland"))
				{      	   
					Admin.exitFrame();
				}
				else
				{
					Login.frame.dispose();
				}
				this.dispose();
           
			}
			catch (IOException exc)
			{
				System.out.println("BROKEN");
			}
		
		}
		else if(e.getSource() == back)
		{
		  cart.clear();
		  dispose();
		}			
	}
	public void recordCust(int user1)
	{
		user = user1;
	}
	public void printCart()
	{
		if(CartButton.n > 0)
		{
			cart.add(list.getNames(0) + "  x" + CartButton.n + "   -   " + money.format(list.getNums(0) * CartButton.n));		
		}
		if(CartButton.n1 > 0)
		{
			cart.add(list.getNames(1) + "  x" + CartButton.n1 + "   -   " + money.format(list.getNums(1) * CartButton.n1));		
		}
		if(CartButton.n2 > 0)
		{
			cart.add(list.getNames(2) + "  x" + CartButton.n2 + "   -   " + money.format(list.getNums(2) * CartButton.n2));		
		}
		if(CartButton.n3 > 0)
		{
			cart.add(list.getNames(3) + "  x" + CartButton.n3 + "   -   " + money.format(list.getNums(3) * CartButton.n3));		
		}
		if(CartButton.n4 > 0)
		{
			cart.add(list.getNames(4) + "  x" + CartButton.n4 + "   -   " + money.format(list.getNums(4) * CartButton.n4));		
		}
		if(CartButton.n5 > 0)
		{
			cart.add(list.getNames(5) + "  x" + CartButton.n5 + "   -   " + money.format(list.getNums(5) * CartButton.n5));		
		}
		if(CartButton.n6 > 0)
		{
			cart.add(list.getNames(6) + "  x" + CartButton.n6 + "   -   " + money.format(list.getNums(6) * CartButton.n6));	
		}
	}	
}
