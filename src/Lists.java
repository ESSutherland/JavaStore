import java.util.*;
import java.text.*;
public class Lists
{
      public static ArrayList<String> names = new ArrayList<String>();
      public static ArrayList<Double> prices = new ArrayList<Double>();
      public static ArrayList<String> items = new ArrayList<String>();
      public static ArrayList<Double> nums = new ArrayList<Double>();
     
      public static ArrayList<Double> account = new ArrayList<Double>();
      
      public static ArrayList<String> users = new ArrayList<String>();
      public static ArrayList<String> pass = new ArrayList<String>();
      public static ArrayList<String> name = new ArrayList<String>();
      
      NumberFormat money = NumberFormat.getCurrencyInstance();
      
      
      public Lists()
      {        
      }     
      public void firstList(String i, double n)
      {
         names.add(i);
         nums.add(n);
      }      
      public void secondList(String i, double p)
      {
         items.add(i);
         prices.add(p);
      }     
      public void removeCust(int i)
      {
    	  account.remove(i);
    	  users.remove(i);
    	  pass.remove(i);
    	  name.remove(i);
      }
      public void addUser(String i)
      {
    	  users.add(i);
      }
      public void addPass(String i)
      {
    	  pass.add(i);
      }
      public void addName(String i)
      {
    	  name.add(i);
      }
      public void addFunds(double i)
      {
    	  account.add(i);
      }
      public double getPrice(int i)
      {
         return prices.get(i);
      }      
      public String getItems(int i)
      {
         return items.get(i);
      }     
      public double getNums(int i)
      {      
         return nums.get(i);
      }      
      public String getNames(int i)
      {      
         return names.get(i);
      }
      public String getUser(int i)
      {
    	  return users.get(i);
      }
      public String getPass(int i)
      {
    	  return pass.get(i);
      }
      public String getName(int i)
      {
    	  return name.get(i);
      }
      public double getFunds(int i)
      {
    	  return account.get(i);
      }
      public int getSize(String i)
      {
    	  if(i.equals("names"))
    	  {
    		  return names.size();
    	  }
    	  else if(i.equals("nums"))
    	  {
    		  return nums.size();
    	  }
    	  else if(i.equals("items"))
    	  {
    		  return items.size();
    	  }
    	  else if(i.equals("prices"))
    	  {
    		  return prices.size();
    	  }
    	  else if(i.equals("users"))
    	  {
    		  return users.size();
    	  }
    	  else if(i.equals("pass"))
    	  {
    		  return pass.size();
    	  }
    	  else if(i.equals("name"))
    	  {
    		  return name.size();
    	  }
    	  else
    	  {
    		  return 0;
    	  }
      }  
      public ArrayList<String> getList1(String list)
      {
    	  if(list.equals("names"))
    	  {
    		  return names;
    	  }
    	  else if(list.equals("items"))
    	  {
    		  return items;
    	  }
    	  else
    	  {
    		  return null;
    	  }
      }
      public ArrayList<Double> getList2(String list)
      {
    	  if(list.equals("nums"))
    	  {
    		  return nums;
    	  }
    	  else if(list.equals("prices"))
    	  {
    		  return prices;
    	  }
    	  else
    	  {
    		  return null;
    	  }
      }
 }
