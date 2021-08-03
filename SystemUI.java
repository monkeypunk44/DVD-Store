import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

public class SystemUI 
{
  public static void main(String[] args) 
  {
    MainSystem.addCust("Billy", "123 Neverland", "123-456-7890");
    MainSystem.addCust("Billy", "124 Neverland", "123-456-7894");
    MainSystem.addCust("Jimmy", "123 Neverland", "123-456-7891");
    MainSystem.addCust("Marvin", "123 Neverland", "123-456-7892");
    
    MainSystem.addDVD("Garfield.", "Horror", "Jon", 1.0);
    MainSystem.addDVD("Garfield and the Philosopher's stone", "Horror", "Jon", 1.0);
    MainSystem.addDVD("Garfield in space", "Sci-fi", "Jon", 1.0);
    
    MainSystem.rentDVD("123-456-7890", "Garfield.");
    MainSystem.rentDVD("123-456-7890", "Garfield in space");
    //MainSystem.returnDVD("123-456-7890", "Garfield.");
    
    // These functions currently don't work properly
    // Load cust does to an extent, but loadDVDs does not
    // MainSystem.loadCust();
    //MainSystem.loadDVDs();
    
    
    JFrame window = new JFrame("DVD Store");
    window.setSize(650, 500);
    
    JTabbedPane jt = new JTabbedPane();
    
    jt.add("Customer Search", new CustSearchPanel());
    jt.add("DVD Search", new DVDSearchPanel());
    jt.add("Rent/Return", new RentReturnPanel());
    jt.add("Register Customer", new RegisterCustPanel());
    jt.add("Stock DVD", new StockDVDPanel());
    jt.add("QUIT", new quitPanel());
    
    window.getContentPane().add(jt);
    window.setVisible(true);
  }
  
}

class quitPanel extends JPanel
{
  public quitPanel()
  {
    setLayout(null);
    JButton quit = new JButton("QUIT");
    quit.setBounds(40, 40, 200, 20);
    
    add(quit);
    
    quit.addActionListener(new ActionListener()
                             {
      @Override
      public void actionPerformed(ActionEvent event)
      { 
        
        MainSystem.saveCustomers();
        MainSystem.saveDVDs();
        System.exit(0);
      }
    });
  }
}