import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


public class StockDVDPanel extends JPanel
{
  public StockDVDPanel()
  { 
    // Everything should fit in this one panel I think
    JPanel panel = new JPanel();
    // This lets you set absolute coords
    setLayout(null);
    setPreferredSize(new Dimension(200, 200));
    
    // message that tells user what to do
    JLabel msg = new JLabel("Please stock a DVD.");
    msg.setBounds(220,20,200,20);
    
    // Create Buttons
    JLabel lab1 = new JLabel("Name:");
    // setBounds(startX, startY, width, height)
    lab1.setBounds(40,40,200,20);
    
    JLabel lab2 = new JLabel("Director:");
    lab2.setBounds(40,80,200,20);
    
    JLabel lab3 = new JLabel("Genre:");
    lab3.setBounds(40,120,200,20);
    
    JLabel lab4 = new JLabel("Price:");
    lab4.setBounds(40,160,200,20);
    
    JButton confirm = new JButton("Confirm");
    confirm.setBounds(250,240,100,20);
    
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
    
    JTextField t4 = new JTextField(120);
    t4.setBounds(200,160,200,20);
    t4.selectAll();
    t4.replaceSelection("");
    
    // Define behaviour on button press
    confirm.addActionListener(new ActionListener()
                                {
      @Override
      public void actionPerformed(ActionEvent event)
      {
        String name, director, genre, price;
        // check if fields any fields are empty
        if (t1.getText().isEmpty() || t2.getText().isEmpty() 
              || t3.getText().isEmpty() || t4.getText().isEmpty())
        {
          output.selectAll();
          output.replaceSelection("");
          output.append("Error: Some fields are empty.\n");
        }
        
        // if they're all full, take the data into the addDVD() function
        // to stock the DVD into the database
        else
        {
          output.selectAll();
          output.replaceSelection("");
          output.append("Success: DVD added to database.\n");
          name = t1.getText();
          director = t2.getText();
          genre = t3.getText();
          price = t4.getText();
          MainSystem.addDVD(name, director, genre, new Double(price));
        }
      }
    });
    
    // Add Everything to the panel
    add(msg);
    add(lab1);
    add(lab2);
    add(lab3);
    add(lab4);
    add(t1);
    add(t2);
    add(t3);
    add(t4);
    add(confirm);
    add(output);
  }
}