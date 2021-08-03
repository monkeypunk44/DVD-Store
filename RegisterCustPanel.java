import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


public class RegisterCustPanel extends JPanel
{
  public RegisterCustPanel()
  { 
    // Everything should fit in this one panel I think
    JPanel panel = new JPanel();
    // This lets you set absolute coords
    setLayout(null);
    setPreferredSize(new Dimension(200, 200));
    
    // pls get this to work :((
    JLabel msg = new JLabel("Please register a customer.");
    msg.setBounds(220,20,200,20);
    
    // Create Buttons
    JLabel lab1 = new JLabel("Address:");
    // setBounds(startX, startY, width, height)
    lab1.setBounds(40,40,200,20);
    
    JLabel lab2 = new JLabel("Phone Number:");
    lab2.setBounds(40,80,200,20);
    
    JLabel lab3 = new JLabel("Name:");
    lab3.setBounds(40,120,200,20);
    
    JButton confirm = new JButton("Confirm");
    confirm.setBounds(250,160,100,20);
    
    // Text Area, text output
    JTextArea output = new JTextArea(2,3);
    output.setBounds(200,200,200,20);
    
    // Text Field, similar to buttons, text input
    JTextField t1 = new JTextField(40);
    t1.setBounds(200,40,200,20);
    t1.selectAll();
    t1.replaceSelection("");
    
    JTextField t2 = new JTextField(80);
    t2.setBounds(200,80,200,20);
    t2.selectAll();
    t2.replaceSelection("");
    
    JTextField t3 = new JTextField(120);
    t3.setBounds(200,120,200,20);
    t3.selectAll();
    t3.replaceSelection("");
    
    // Define behaviour on button press
    confirm.addActionListener(new ActionListener()
                                {
      @Override
      public void actionPerformed(ActionEvent event)
      {
        String address, phone, name;
        // check if fields any fields are empty
        if (t1.getText().isEmpty() || t2.getText().isEmpty() 
              || t3.getText().isEmpty())
        {
          output.selectAll();
          output.replaceSelection("");
          output.append("Error: Some fields are empty.\n");
        }
        
        // if they're all full, take the data into the addCust() function
        // to register the customer into the database
        else
        {
          output.selectAll();
          output.replaceSelection("");
          output.append("Success: Customer added to database.\n");
          address = t1.getText();
          phone = t2.getText();
          name = t3.getText();
          MainSystem.addCust(address, phone, name);
        }
      }
    });
    
    // Add Everything to the panel
    add(msg);
    add(lab1);
    add(lab2);
    add(lab3);
    add(t1);
    add(t2);
    add(t3);
    add(confirm);
    add(output);
  }
}