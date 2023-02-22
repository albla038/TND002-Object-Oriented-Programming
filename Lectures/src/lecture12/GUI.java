package lecture12;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUI extends JFrame implements ActionListener {
	
	private JButton button1;
	private JButton button2;
	
	private JRadioButton radioButton;
	
	public GUI() {
		setTitle("Button test");
		Font theFont = new Font("SansSerif", Font.PLAIN, 25);
		
		Container c = getContentPane();
		c.setLayout(new GridLayout(2,2));
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		button1 = new JButton("Button 1");
		button1.setFont(theFont);
		button1.addActionListener(this);
		button2 = new JButton("Button 2");
		button2.setFont(theFont);
		button2.addActionListener(this);
		
		radioButton = new JRadioButton("Select me");
		radioButton.setFont(theFont);
		radioButton.addActionListener(this);
		
		c.add(button1); c.add(button2);
		c.add(radioButton);
		
		pack();
		setVisible(true);
	}

	public static void main(String[] args) {
		GUI myGUI = new GUI();
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == button1) {
			System.out.println("Clicked button1 --- " + e.getSource());
		}
		
		if (e.getSource() == button2) {
			System.out.println("Clicked button2 --- " + e.getSource());
		}
		
		if (e.getSource() == radioButton) {
			System.out.print("Radio button");
			if (radioButton.isSelected()) {
				System.out.println(" - selected");
			} else {
				System.out.println(" - unselected");
			}
			
		}
	}

}
