import java.util.*;
import java.io.*;
import javax.swing.*;


public class Store extends JFrame
   {
      public static Lists list = new Lists();
      public static JFrame frame;
                    
      public static void main(String[] args) throws FileNotFoundException
      {                    
         File inputFile = new File("List.txt");
         Scanner filein = new Scanner(inputFile);
         
         File userFile = new File("Users.txt");
         Scanner userin = new Scanner(userFile);
         
         File passFile = new File("Passwords.txt");
         Scanner passin = new Scanner(passFile);
         
         File nameFile = new File("Names.txt");
         Scanner namein = new Scanner(nameFile);
         
         File fundFile = new File("Funds.txt");
         Scanner fundin = new Scanner(fundFile);
                
         while (filein.hasNextLine())
         {
        	 String line = filein.nextLine();
        	 int i = 0;        
        	 while(!Character.isDigit(line.charAt(i)))
        	 {
        		 i++;
        	 }
        	 String name = line.substring(0, i);
        	 String num = line.substring(i);     
        	 double num1 = Double.parseDouble(num.trim());          
        	 list.firstList(name.trim(), num1);         
         }               
         while (userin.hasNextLine())
         {
        	 String user = userin.nextLine();                
        	 list.addUser(user.trim());
         }        
         while (passin.hasNextLine())
         {
        	 String pass = passin.nextLine();   	
        	 list.addPass(pass.trim());
         }         
         while (namein.hasNextLine())
         {
        	 String name = namein.nextLine();        	 
        	 list.addName(name.trim());
         }         
         while (fundin.hasNextLine())
         {        
        	 String funds = fundin.nextLine();
        	 if(!funds.equals(""))
        	 {
        		 double fund = Double.parseDouble(funds);
        		 list.addFunds(fund);
        	 }
         }      
         frame = new Login(); 
         frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
 	     frame.setTitle("Please Sign In");
 	     frame.setVisible(true);
 	     
         filein.close();
	     userin.close();
	     passin.close();
	     namein.close();
	     fundin.close();
      }    
   } 