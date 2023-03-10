package PreviousExam;

import javax.swing.*; import java.awt.*; import java.awt.event.*;

public class GUI extends JFrame implements ActionListener{
	
	JPanel topPanel;
	JPanel bottomPanel;
	JPanel radioPanel;
	
	JTextField topText;
	JTextField bottomText;
	
	JButton addButton;
	JButton subButton;
	JButton divButton;
	JButton multButton;
	JButton equalButton;
	
	JRadioButton buttonButton;
	JRadioButton returnButton;
	
	public GUI() {
		Container container = getContentPane();
		Font font = new Font("SansSerif", Font.PLAIN, 25);
		
		
		topPanel = new JPanel();
		bottomPanel = new JPanel();
		radioPanel = new JPanel();
		
		
		topText = new JTextField();
		topText.addActionListener(this);
		topText.setFont(font);
		
		bottomText= new JTextField();
		bottomText.addActionListener(this);
		bottomText.setEditable(false);
		bottomText.setFont(font);
		
		
		addButton = new JButton("+");
		addButton.addActionListener(this);
		addButton.setFont(font);
		
		subButton = new JButton("-");
		subButton.addActionListener(this);
		subButton.setFont(font);
		
		divButton = new JButton("/");
		divButton.addActionListener(this);
		divButton.setFont(font);
		
		multButton = new JButton("*");
		multButton.addActionListener(this);
		multButton.setFont(font);
		
		equalButton = new JButton("=");
		equalButton.addActionListener(this);
		equalButton.setFont(font);
		
		
		buttonButton = new JRadioButton("Button", true);
		buttonButton.addActionListener(this);
		buttonButton.setFont(font);
		
		returnButton = new JRadioButton("Return");
		returnButton.addActionListener(this);
		returnButton.setFont(font);
		
		container.setLayout(new GridLayout(4,1));
		topPanel.setLayout(new GridLayout(1,3));
		bottomPanel.setLayout(new GridLayout(1,3));
		radioPanel.setLayout(new GridLayout(2,1));
		
		radioPanel.add(buttonButton);
		radioPanel.add(returnButton);
		
		topPanel.add(addButton);
		topPanel.add(subButton);
		topPanel.add(radioPanel);
		
		bottomPanel.add(divButton);
		bottomPanel.add(multButton);
		bottomPanel.add(equalButton);
		
		container.add(topText);
		container.add(bottomText);
		container.add(topPanel);
		container.add(bottomPanel);
		
		
		pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		GUI myGUI = new GUI();
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == buttonButton) {
			if (buttonButton.isSelected()) returnButton.setSelected(false);
			if (buttonButton.isSelected() == false && returnButton.isSelected() == false) buttonButton.setSelected(true);
			addButton.setEnabled(true);
			subButton.setEnabled(true);
			divButton.setEnabled(true);
			multButton.setEnabled(true);
			equalButton.setEnabled(true);
		}
		
		if(e.getSource() == returnButton) {
			if (returnButton.isSelected()) buttonButton.setSelected(false);
			if (returnButton.isSelected() == false && buttonButton.isSelected() == false) returnButton.setSelected(true);
			addButton.setEnabled(false);
			subButton.setEnabled(false);
			divButton.setEnabled(false);
			multButton.setEnabled(false);
			equalButton.setEnabled(false);	
		}
		
		if(e.getSource() == topText) {
			String temp = topText.getText();
			topText.setText("");
			
		}
	}
	
}
