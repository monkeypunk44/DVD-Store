/*
 *  File: rental.java
 * 
 * Author: AJ Blooi 100143069 
 *
 * Version: 1.0
 * 
 * Purpose: this is to make new rentals for the rental list in customer
 *    can also get and set the dates for both variables
 *
 * Notes:
 *
 */

import java.util.*;

public class Rental
{
 Calendar returnDate;
 String name;

 public Rental(String dvdName, Calendar reDate)
 {
  returnDate = reDate;
  name = dvdName;
 }

 // Is to get the name of the rented DVD by .getName()
 public String getName()
 {
  return name;
 }

 // Is to get the check out date of the rented DVD by .getCheckOutDate()
 // public Date getCheckOutDate()
 // {
 //  return checkOutDate;
 // }

 // Is to get the return date of the rented DVD by .getReturnDate()
 public Calendar getReturnDate()
 {
  return returnDate;
 }

 // Is to set the name of the rented DVD by .setName( name of a DVD )
 public void setName(String newName)
 {
  name = newName;
 }

 // Is to set the check out date of the rented DVD 
 // by .setCheckOutDate( the date that day )
 // public void setCheckOutDate(Date date)
 // {
 //  checkOutDate = date;
 // }

 // Is to set the return date of the rented DVD 
 // by .setReturnDate( the date it should be return )
 public void setReturnDate(Calendar date)
 {
  returnDate = date;
 }
}