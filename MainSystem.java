import java.util.*;
import java.io.*;

public class MainSystem
{
  static int dvdListSize = 0;
  static int custListSize = 0;
  
  static Customer[] custList = new Customer[500];
  static DVD[] dvdList = new DVD [500];
  
  
  // Add a new DVD to stock
  public static void addDVD(String name, String gen, String dir, double p)
  {
    dvdList[dvdListSize] = new DVD(name, dir, gen, p);
    dvdListSize++;
  }
  
  // Find an existing DVD within stock
  public static DVD[] findDVD(String content, String type)
  {
    DVD[] returnList = new DVD[10];
    int returnIndex = 0;
    
    // Search through dvd list
    for (int i = 0; i < dvdListSize; i++)
    {
      // Search by name
      if (type.equals("name") && dvdList[i].getName().equals(content))
      {
        returnList[returnIndex] = dvdList[i];
        returnIndex++;
      }
      // Search by genre
      else if (type.equals("genre") && dvdList[i].getGenre().equals(content))
      {
        returnList[returnIndex] = dvdList[i];
        returnIndex++;
      }
      // Search by director
      else if (dvdList[i].getDirector().equals(content))
      {
        returnList[returnIndex] = dvdList[i];
        returnIndex++;
      }
    }
    
    return returnList;
  }
  
  // Add new customer to list
  public static void addCust(String name, String address, String phone)
  {
    custList[custListSize] = new Customer(name, address, phone);
    custListSize++;
  }
  
  // Search through customer list for existing customer
  public static Customer[] findCust(String content, String type)
  {
    Customer[] returnList = new Customer[10];
    int returnIndex = 0;
    
    // Search through customer list
    for (int i = 0; i < custListSize; i++)
    {
      // Search by name
      if (type.equals("name") && custList[i].getName().equals(content))
      {
        returnList[returnIndex] = custList[i];
        returnIndex++;
      }
      // Search by address
      else if (type.equals("address") 
                 && custList[i].getAddress().equals(content))
      {
        returnList[returnIndex] = custList[i];
        returnIndex++;
      }
      // Search by phone
      else if (custList[i].getPhoneNum().equals(content))
      {
        returnList[returnIndex] = custList[i];
        returnIndex++;
      }
    }
    
    return returnList;
  }
  
  // Rent a DVD for a customer
  public static String rentDVD(String custID, String dvdID)
  {
    // Find the DVD and customer in question in the system
    // THIS ISN'T IMPLEMENTED RIGHT
    DVD[] thisDVD = findDVD(dvdID, "name");
    int custRentReturn = 1;
    
    Customer[] thisCustomer = findCust(custID, "phone");
    if (thisDVD[0] == null || thisCustomer[0] == null)
    {
      return "Customer or DVD not found";
    }
    
    if (!thisDVD[0].getStock())
    {
      return "DVD not in stock";
    }
    
    custRentReturn = thisCustomer[0].rentDVD(thisDVD[0].getName());
    
    // Customer at max rented DVDs
    if (custRentReturn == Customer.MAXRENTED)
    {
      return "Max DVDs rented";
    }
    // Rent successsful
    
    thisDVD[0].setStock(false);
    return thisDVD[0].getName();
  }
  
  // Return a DVD for a customer.
  public static String returnDVD(String custID, String dvdID)
  {
    double owed;
    Calendar custReturnReturn;
    
    DVD[] thisDVD = findDVD(dvdID, "name");
    Customer[] thisCust = findCust(custID, "phone");
    
    // Check to see if DVD or Cust wasn't found
    if (thisDVD[0] == null || thisCust[0] == null)
    {
      return "Customer or DVD not found.";
    }
    
    custReturnReturn = thisCust[0].returnDVD(thisDVD[0].getName());
    
    // Check to see if movie actually rented out.
    if (custReturnReturn == null)
    {
      return "DVD not rented by Customer";
    }
    
    owed = thisDVD[0].getRentalRate();
    owed = owed + overDueCheck(custReturnReturn);
    thisDVD[0].setStock(true);
    
    Calendar returnDate = thisCust[0].returnDVD(thisDVD[0].getName());
    
    return "Amount owed: " + owed;
    
  }    
  
  public static double overDueCheck(Calendar checkedDate)
  {
    double extraOwed = 0.0;
    
    Calendar today = Calendar.getInstance();
    if (today.compareTo(checkedDate) > 0)
    {
      extraOwed = 5.0;
    }
    
    return extraOwed;
  }
  
  public static void saveCustomers()
  {
    try
    {
      PrintWriter writer = new PrintWriter("Customers.txt");
      
      
      for (int i = 0; i < custList.length; i++)
      {
        if (custList[i] != null)
        {
          Rental[] rent;
          
          writer.println(custList[i].getName());
          writer.println(custList[i].getAddress());
          writer.println(custList[i].getPhoneNum());
          rent = custList[i].getDVDsrented();
          for (int k = 0; k < rent.length; k++)
          {
            if (rent[k] != null)
            {
              writer.print(rent[k].getName());
              writer.print(",");
              writer.print(rent[k].getReturnDate().get(Calendar.YEAR));
              writer.print(",");
              writer.print(rent[k].getReturnDate().get(Calendar.MONTH));
              writer.print(",");
              writer.print(rent[k].getReturnDate().get(Calendar.DATE));
              writer.print(",");
            }
          }
          writer.println();
        }
      }
      writer.close();
    }
    catch (IOException ex)
    {
      System.exit(0);
    }
  }
  
  public static void loadCust()
  {
    try
    {
      File file = new File("Customers.txt");
      Scanner scan = new Scanner(file);
      String currentLine, name, address, phone, rentName;
      String[] splitLine;
      name = "ERROR";
      address = "ERROR";
      phone = "ERROR";
      rentName = "ERROR";
      int lineCount = 0;
      int argCount = 0;
      String year = "0";
      String month = "0";
      String date = "0";
      while(scan.hasNext())
      {
        currentLine = scan.nextLine();
        // Name field
        if (lineCount%4 == 0)
        {
          if (lineCount > 0)
          {
            addCust(name, address, phone);
          }
          name = currentLine;
        }
        // Address field
        if (lineCount%4 == 1)
        {
          address = currentLine;
        }
        // Phone field
        if (lineCount%4 == 2)
        {
          phone = currentLine;
        }
        // Rentals
        if (lineCount%4 == 3)
        {
          splitLine = currentLine.split(".");
          for (int i = 0; i < splitLine.length; i++)
          {
            // Name field
            if (argCount%4 == 0)
            {
              if (argCount > 0)
              {
                
              }
              rentName = currentLine;
            }
            // Year
            if (argCount%4 == 1)
            {
              year = "0";
            }
            // Month
            if (argCount%4 == 2)
            {
              month = "0";
            }
            // Date
            if (argCount%4 == 3)
            {
              date = "0";
            }
            argCount++;
          }
          
        }
        lineCount++;
      }
    }
    catch (IOException ex)
    {
      System.exit(0);
    }
    
  }
  
  public static void saveDVDs()
  {
    //dvdList
    try
    {
      PrintWriter writerDVD = new PrintWriter("DVDs.txt");

      for (int i = 0; i < dvdList.length ; i++) 
      {
        if(dvdList[i]!=null)
        {
          writerDVD.println(dvdList[i].getStock());
          writerDVD.println(dvdList[i].getName());
          writerDVD.println(dvdList[i].getDirector());
          writerDVD.println(dvdList[i].getGenre());
          writerDVD.println(dvdList[i].getRentalRate());
        }
      }

      writerDVD.close();

    }
    catch(IOException ex)
    {
      System.exit(0);
    }
  }
  public static void loadDVDs()
  {
    try
    {
      File file = new File("DVDs.txt");
      Scanner dvds = new Scanner(file);
      String name = "ERROR";
      String gen = "ERROR";
      String dir = "ERROR";
      Double p = 0.0;

      int count = 0,i = 0;

      while(dvds.hasNext())
      {
        //System.out.println(dvds.nextLine());
        if(dvdList[i] != null)
        {
          if(count%5 == 0)// sets the DVD stock
          {
            if (count > 0)
            {
              addDVD(name, gen, dir, p);
              Boolean bool = Boolean.parseBoolean(dvds.nextLine());
              dvdList[i].setStock(bool);
            }
            //String btext = dvds.nextLine();
            count++;
          }
          else if(count%5 == 1)// sets the DVD name
          {
            name = dvds.nextLine();
            count++;
          }
          else if(count%5 == 2)// sets the director 
          {
            dir = dvds.nextLine();
            //dvdList[i].setDirector(dvds.nextLine());
            count++;
          }
          else if(count%5 == 3)// sets the genre
          {
            gen = dvds.nextLine();
            //dvdList[i].setGenre(dvds.nextLine());
            count++;
          }
          else if(count%5 == 4)// sets the rental rate
          {
            String ptext = dvds.nextLine();
            double price = Double.parseDouble(ptext);
            dvdList[i].setRentalRate(price);
            count++;
            i++;
          }
        }
      }
    }
    catch(IOException ex)
    {
      System.exit(0);
    }
  }
  
}