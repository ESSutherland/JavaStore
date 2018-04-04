import javax.swing.*;
import java.text.*;

public class Bill extends JFrame
{
	private JLabel nam, top, bottom1, bottom2, bottom3, bottom4, bottom5;
	
	private int y = 60;
	private double total1;
	
	Lists list = new Lists();
	NumberFormat money = NumberFormat.getCurrencyInstance();
	
	private static final int WIDTH = 400;
	private static final int HEIGHT = 650;
	
	public Bill()
	{
		setSize(WIDTH, HEIGHT);
		createComponents();		
	}
	public void createComponents()
	{
		
		setLayout(null);
		
		top = new JLabel("******************[ SHOPPING BILL ]*******************");
		
		
		for(int i = 0; i < list.getSize("items"); i++)
		{
		total1 = total1 + list.getPrice(i);
		nam = new JLabel(list.getItems(i) + " - " + money.format(list.getPrice(i)));
		nam.setBounds(150 , y , 200 , 30);
		y = y + 40;
		add(nam);
		}
		
		
		
		bottom1 = new JLabel("*******************************************************");
		bottom2 = new JLabel("Items Purchased: " + list.getSize("items"));
		bottom3 = new JLabel("Total: " + money.format(total1));
		bottom4 = new JLabel("Customer: " + Login.cust);
		bottom5 = new JLabel("New Funds: " + money.format(list.getFunds(Login.j)));
		
		top.setBounds(50, 40, 400, 30);
		bottom1.setBounds(50, 470, 400, 30);
		bottom2.setBounds(130, 490, 400, 30);
		bottom3.setBounds(150, 510, 400, 30); 
		bottom4.setBounds(120, 10, 400, 30);
		bottom5.setBounds(130, 530, 400, 30);
		
		add(top);
		add(bottom1);
		add(bottom2);
		add(bottom3);
		add(bottom4);
		add(bottom5);
		
	}
}

