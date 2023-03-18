package simpleGUI;

import java.awt.*;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.UIDefaults;
import javax.swing.UIManager;

public class GUI extends JFrame implements ActionListener {
	
	private JTextField textField;
	private JButton printButton;
	private JButton clearButton;

	public GUI() {
		
		// GUI
		setTitle("Simple GUI");
		Container container = getContentPane();
		setSize(400,300);
		
		// FONT
		Font myFont = new Font("SansSerif", Font.PLAIN, 25);
		UIDefaults uiDefaults = UIManager.getDefaults();
		uiDefaults.put("Button.font", myFont);	
		uiDefaults.put("TextField.font", myFont);	
		
		// Set layout
		container.setLayout(new GridLayout(3,1));
		
		textField = new JTextField();
		container.add(textField);
		
		printButton = new JButton("Print");
		printButton.addActionListener(this);
		container.add(printButton);
		
		clearButton = new JButton("Clear");
		clearButton.addActionListener(this);
		container.add(clearButton);
		
		// Final GUI calls
		//pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == printButton) {
			System.out.println(textField.getText());
		}
		
		if (e.getSource() == clearButton) {
			textField.setText("");
		}
		
	}

}
