/*
 *  File: Customer.java
 * 
 * Author: AJ Blooi 100143069 
 *
 * Version: 1.0
 * 
 * Purpose: This is to make a customer for system also handleds rentals 
 *           and returns, also it can set and get any variable info
 * 
 * Notes:
 *
 */
import java.util.*;

public class Customer
{
  double accBal; // Amount owed, in dollars $$.
  String name, address, phoneNum; // Customer info.
  Rental[]  rentedDVDs; // list of rented DVD's (names) that go to a customer.
  final static int MAXRENTED = 4; // max number of rented DVD's per customer.
  
  
  public Customer(String newName, String newAddress, String newPhoneNum)
  {
    address = newAddress;
    phoneNum = newPhoneNum;
    name = newName;
    accBal = 0;
    rentedDVDs = new Rental[MAXRENTED];
  }
  
  // gets the name of the DVD in the list and sets the spot in the list to 0 
  public Calendar returnDVD(String dvdName)
  {
    int arraylen = rentedDVDs.length;
    
    for (int i = 0; i < arraylen; i++) 
    {
      //System.out.println("In the loop");
      if (rentedDVDs[i] != null)
      {
        System.out.println(rentedDVDs[i].getName());
        if (rentedDVDs[i].getName().equals(dvdName)) 
        {
          Calendar date = rentedDVDs[i].getReturnDate();
          rentedDVDs[i] = null;
          return date;
        } 
      }
    }
    return null;
  }
  
  // makes a new item in the DVDsrented list if the list does not a
  // already contain the max number of DVDs rented
  // dates entered should be in the form of dd-MMM-YYYY
  // example 20-Mar-2018
  public int rentDVD(String dvdName)
  {
    
    int count = 0,arraylen = rentedDVDs.length;
    
    for (int i = 0; i < arraylen; i++) {
      
      if(rentedDVDs[i] != null)
      {
        count++;
      }
      
    }
    
    if(count <= MAXRENTED)
    {
      for (int k = 0; k < arraylen; k++) 
      {
        if (rentedDVDs[k] == null)
        {
          Calendar reDate = Calendar.getInstance();
          reDate.add(Calendar.DATE,7);
          rentedDVDs[k] = new Rental(dvdName, reDate);
          break;
        } 
      }
      return 0;
    }
    else 
    {
      return MAXRENTED;
    }
  }
  
  // is to set the account balance of the Customer 
  // by .setAccBal( amount owed )
  public void setAccBal(double newAccBal)
  {
    accBal = newAccBal;
  }
  
  // sets the name of the customer
  public void setName(String newName)
  {
    name = newName;
  }
  
  // sets the address of the customer
  public void setAddress(String newAddress)
  {
    address = newAddress;
  }
  
  // sets the phone number of the customer
  public void setPhoneNum(String newPhoneNum)
  {
    phoneNum = newPhoneNum;
  }
  
  // gets the account balance of the customer
  public double getAccBal()
  {
    return accBal;
  }
  
  // gets the name of the customer
  public String getName()
  {
    return name;
  }
  
  // gets the address of the customer
  public String getAddress()
  {
    return address;
  }
  
  // gets the phone number of the customer
  public String getPhoneNum()
  {
    return phoneNum;
  }
  
  // gets the list of DVDs rented that the customer have taken out
  public Rental[] getDVDsrented()
  {
    return rentedDVDs;
  }
} 