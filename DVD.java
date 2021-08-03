/*
 * 	File: DVD.java
 * 
 *	Author: AJ Blooi 100143069 
 *
 *	Version: 1.0
 *	
 *	Purpose: This is to make new DVD's for the DVD list in system,
 *			 it is also able to get and set any of the vairables
 *
 *	Notes:
 *
 */

public class DVD
{
	boolean inStock; // ture DVD is in stock, false DVD is not in stock
	String name,director,genre; // info about the DVD
	double rentalRate; // the price of the DVD

	// makes the new DVDs for the lists in mainsystem 
	public DVD(String newName, String newDir, String newGenre, double price)
	{
		inStock = true;
		name = newName;
		director = newDir;
		genre = newGenre;
		rentalRate = price;
	}

	// gets the stock  true or false
	public boolean getStock()
	{
		return inStock;
	}

	// gets the DVD name
	public String getName()
	{
		return name;
	}

	// gets the price of the DVD
	public double getRentalRate()
	{
		return rentalRate;
	}

	// gets the director of the DVD
	public String getDirector()
	{
		return director;
	}

	// gets the genre of the DVD
	public String getGenre()
	{
		return genre;
	}

	// sets the director of the DVD
	public void setDirector(String name)
	{
		director = name;
	}

	// sets the genre of the DVD
	public void setGenre(String newGenre)
	{
		genre = newGenre;
	}

	// sets the stock true or false
	public void setStock(Boolean stock)
	{
		inStock = stock;
	}

	// sets the name of the DVD
	public void setName(String newName)
	{
		name = newName;
	}

	// sets the price of the DVD
	public void setRentalRate(double amount)
	{
		rentalRate = amount;	
	}
}