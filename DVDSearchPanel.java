import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class DVDSearchPanel extends JPanel
{
  public DVDSearchPanel()
  {
    // This lets you set absolute coords
    setLayout(null);
    setPreferredSize(new Dimension(200, 200));
    
    // Create Buttons
    JButton b1 = new JButton("Search by Name");
    b1.setBounds(300, 40, 200, 20);
    JButton b2 = new JButton("Search by Genre");
    b2.setBounds(300, 80, 200, 20);
    JButton b3 = new JButton("Search by Director");
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
    text.setBounds(40,80,200,20);;
    
    // Search by name behaviour
    b1.addActionListener(new ActionListener()
                           {
      @Override
      public void actionPerformed(ActionEvent event)
      {
        // Clear output
        output.selectAll();
        output.replaceSelection("");
        
        
        // Search system for customer with address in text field
        DVD[] out = new DVD[10];
        out = MainSystem.findDVD(text.getText(), "name");
        
        // No customers found
        if (out[0] == null)
        {
          output.append("No DVDs found");
        }
        // Customers found, display data on each
        else
        {
          // Display data for each
          for (int i = 0; i < out.length; i++)
          {
            if (out[i] != null)
            {
              output.append("---------------------\n");
              output.append("DVD name: " + out[i].getName() + "\n");
              output.append("DVD director: " + out[i].getDirector() + "\n");
              output.append("DVD genre: " + out[i].getGenre() + "\n");
              output.append("DVD rate: $" + out[i].getRentalRate() + "\n");
              output.append("DVD status: " + out[i].getStock() + "\n");
            }
          }
        }
      }
    });
    // Search by genre button behaviour
    b2.addActionListener(new ActionListener()
                           {
      @Override
      public void actionPerformed(ActionEvent event)
      {
        // Clear output
        output.selectAll();
        output.replaceSelection("");
        
        
        // Search system for customer with address in text field
        DVD[] out = new DVD[10];
        out = MainSystem.findDVD(text.getText(), "genre");
        
        // No customers found
        if (out[0] == null)
        {
          output.append("No DVDs found");
        }
        // Customers found, display data on each
        else
        {
          // Display data for each
          for (int i = 0; i < out.length; i++)
          {
            if (out[i] != null)
            {
              output.append("---------------------\n");
              output.append("DVD name: " + out[i].getName() + "\n");
              output.append("DVD director: " + out[i].getDirector() + "\n");
              output.append("DVD genre: " + out[i].getGenre() + "\n");
              output.append("DVD rate: $" + out[i].getRentalRate() + "\n");
              output.append("DVD status: " + out[i].getStock() + "\n");
            }
          }
        }
      }
    });
    // Search by director button behaviour
    b3.addActionListener(new ActionListener()
                           {
      @Override
      public void actionPerformed(ActionEvent event)
      {
        // Clear output
        output.selectAll();
        output.replaceSelection("");
        
        
        // Search system for customer with address in text field
        DVD[] out;
        Rental[] rented;
        out = MainSystem.findDVD(text.getText(), "director");
        
        // No customers found
        if (out[0] == null)
        {
          output.append("No DVDs found");
        }
        // Customers found, display data on each
        else
        {
          // Display data for each
          for (int i = 0; i < out.length; i++)
          {
            if (out[i] != null)
            {
              output.append("---------------------\n");
              output.append("DVD name: " + out[i].getName() + "\n");
              output.append("DVD director: " + out[i].getDirector() + "\n");
              output.append("DVD genre: " + out[i].getGenre() + "\n");
              output.append("DVD rate: $" + out[i].getRentalRate() + "\n");
              output.append("DVD status: " + out[i].getStock() + "\n");
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