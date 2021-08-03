import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class CustSearchPanel extends JPanel
{
  public CustSearchPanel()
  {
    // This lets you set absolute coords
    setLayout(null);
    setPreferredSize(new Dimension(200, 200));
    
    // Create Buttons
    JButton b1 = new JButton("Search by Address");
    b1.setBounds(300, 40, 200, 20);
    JButton b2 = new JButton("Search by Name");
    b2.setBounds(300, 80, 200, 20);
    JButton b3 = new JButton("Search by Phone #");
    b3.setBounds(300, 120, 200, 20);
    
    // Text Area, text output
    JTextArea output = new JTextArea(2,3);
    //output.setBounds(40,170,450,150);
    output.setEditable(false);
    
    JScrollPane scroll = new JScrollPane(output, 
                                         JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                                         JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
    scroll.setBounds(40,170,500,200);
    
    // Text Field, similar to buttons, text input
    JTextField text = new JTextField(40);
    text.setBounds(40,80,200,20);
    
    // Search by address behaviour
    b1.addActionListener(new ActionListener()
                           {
      @Override
      public void actionPerformed(ActionEvent event)
      {
        // Clear output
        output.selectAll();
        output.replaceSelection("");
        
        // Search system for customer with address in text field
        Customer[] out = new Customer[10];
        Rental[] rent = new Rental[10];
        
        out = MainSystem.findCust(text.getText(), "address");
        
        
        // No customers found
        if (out[0] == null)
        {
          output.append("No customers found");
        }
        // Customers found, display data on each
        else
        {
          
          // Display data for each
          for (int i = 0; i < out.length; i++)
          {
            if (out[i] != null)
            {
              System.out.println("HERE!");
              rent = out[i].getDVDsrented();
              output.append("---------------------\n");
              output.append("Customer name: " + out[i].getName() + "\n");
              output.append("Customer address: " + out[i].getAddress() + "\n");
              output.append("Customer phone: " + out[i].getPhoneNum() + "\n");
              output.append("Rented DVDs: ");
              for (int j = 0; j < rent.length; j++)
              {
                if (rent[j] != null)
                {
                  output.append(rent[j].getName() + ", ");
                }
              }
              output.append("\n");
            }
          }
        }
      }
    });
    // Search by name button behaviour
    b2.addActionListener(new ActionListener()
                           {
      @Override
      public void actionPerformed(ActionEvent event)
      {
        // Clear output
        output.selectAll();
        output.replaceSelection("");
        
        // Search system for customer with address in text field
        Customer[] out = new Customer[10];
        Rental[] rent = new Rental[10];
        
        out = MainSystem.findCust(text.getText(), "name");
        // No customers found
        if (out[0] == null)
        {
          output.append("No customers found");
        }
        // Customers found, display data on each
        else
        {
          // Display data for each
          for (int i = 0; i < out.length; i++)
          {
            if (out[i] != null)
            {
              rent = out[i].getDVDsrented();
              output.append("---------------------\n");
              output.append("Customer name: " + out[i].getName() + "\n");
              output.append("Customer address: " + out[i].getAddress() + "\n");
              output.append("Customer phone: " + out[i].getPhoneNum() + "\n");
              output.append("Rented DVDs: ");
              for (int j = 0; j < rent.length; j++)
              {
                if (rent[j] != null)
                {
                  output.append(rent[j].getName() + ", ");
                }
              }
              output.append("\n");
            }
          }
        }
      }
    });
    // Search by phone button behaviour
    b3.addActionListener(new ActionListener()
                           {
      @Override
      public void actionPerformed(ActionEvent event)
      {
        // Clear output
        output.selectAll();
        output.replaceSelection("");
        
        
        // Search system for customer with address in text field
        Customer[] out = new Customer[10];
        Rental[] rent = new Rental[10];
        out = MainSystem.findCust(text.getText(), "phone");
        
        // No customers found
        if (out[0] == null)
        {
          output.append("No customers found");
        }
        // Customers found, display data on each
        else
        {
          // Display data for each
          for (int i = 0; i < out.length; i++)
          {
            if (out[i] != null)
            {
              rent = out[i].getDVDsrented();
              output.append("---------------------\n");
              output.append("Customer name: " + out[i].getName() + "\n");
              output.append("Customer address: " + out[i].getAddress() + "\n");
              output.append("Customer phone: " + out[i].getPhoneNum() + "\n");
              output.append("Rented DVDs: ");
              for (int j = 0; j < rent.length; j++)
              {
                if (rent[j] != null)
                {
                  output.append(rent[j].getName() + ", ");
                }
              }
              output.append("\n");
            }
          }
        }
      }
    });
    
    // Add Everything to the panel
    add(b1);
    add(b2);
    add(b3);
    add(text);
    add(scroll);
  }
}