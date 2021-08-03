/*
 *
 *  File: RentUI.java
 * 
 */

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class RentReturnPanel extends JPanel
{
  // 1 is rent, 2 is return
  static int mode = 0;
  public RentReturnPanel()
  {
    
    setLayout(null);
    setPreferredSize(new Dimension(200, 200));
    
    // Create Buttons
    JButton b1 = new JButton("Rent");
    // setBounds(startX, startY, width, height)
    b1.setBounds(40,40,200,20);
    JButton b2 = new JButton("Return");
    b2.setBounds(40,80,200,20);
    JButton b3 = new JButton("Confirm");
    b3.setBounds(360,120,200,20);
    
    // Text Area, text output
    JTextArea output = new JTextArea(2,3);
    output.setBounds(360,160,200,100);
    output.setEditable(false);
    
    // Text Field, similar to buttons, text input
    JTextField text = new JTextField(40);
    text.setBounds(360,40,200,20);
    JTextField text2 = new JTextField(40);
    text2.setBounds(360,80,200,20);
    
    JLabel input1 = new JLabel("Customer Phone");
    input1.setBounds(250,40,100,20);
    
    JLabel input2 = new JLabel("DVD Name");
    input2.setBounds(250,80,100,20);
    
    // Define behaviour on enter for text field
    b3.addActionListener(new ActionListener()
                           {
      @Override
      public void actionPerformed(ActionEvent event)
      {
        output.selectAll();
        output.replaceSelection("");
        if(mode == 1)
        {
          //Rental[] rent = new Rental[4];
          String rent = MainSystem.rentDVD(text.getText(),text2.getText());
          if (rent == null)
          {
            output.append("No DVD found");
          }
          // Customers found, display data on each
          else
          {
            output.append("Rented: " + rent);
          }
        }
        else if(mode == 2) 
        {
          //Rental[] dvdReturn = new Rental[4];
          //System.out.println("OVER HERE!");
          String dvdReturn = MainSystem.returnDVD(text.getText(),text2.getText());
          if (dvdReturn == null)
          {
            output.append("No DVD found");
          }
          // Customers found, display data on each
          else
          {
            output.append("Returned DVD: " +text2.getText()+ "\n" + dvdReturn);
          }
        }
        text.selectAll();
        text.replaceSelection("");
        text2.selectAll();
        text2.replaceSelection("");
      }
    });
    
    // Define behaviour on button press
    b1.addActionListener(new ActionListener()
                           {
      @Override
      public void actionPerformed(ActionEvent event)
      {
        // Do a thing
        output.selectAll();
        output.replaceSelection("");
        output.append("selected rent\n");
        mode = 1;
      }
    });
    //Define behaviour on button press
    b2.addActionListener(new ActionListener()
                           {
      @Override
      public void actionPerformed(ActionEvent event)
      {
        // Do a thing
        output.selectAll();
        output.replaceSelection("");
        output.append("selected return\n");
        mode = 2;
      }
    });
    
    
    // Add Everything to the panel
    add(b1);
    add(b2);
    add(b3);
    add(input1);
    add(input2);
    add(text);
    add(text2);
    add(output);
  }
}