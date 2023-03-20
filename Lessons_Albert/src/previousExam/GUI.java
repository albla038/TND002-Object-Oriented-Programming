package previousExam;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import javax.swing.*;

public class GUI extends JFrame implements ActionListener {
	
	private JTextField textField;
	private JLabel label;
	
	private JButton plusButton;
	private JButton minusButton;
	private JRadioButton buttonRadioButton;
	private JRadioButton returnRadioButton;
	private JButton divButton;
	private JButton multiButton;
	private JButton equalsButton;


	public GUI() {
		Container container = getContentPane();
		Font myFont = new Font("SansSerif", Font.PLAIN, 25);
		
		// I'm using UIDefaults and UIManager to set all buttons and components to myFont once.
		UIDefaults defaultUI = UIManager.getDefaults();
		defaultUI.put("Button.font", myFont);
		defaultUI.put("RadioButton.font", myFont);
		defaultUI.put("TextField.font", myFont);
		defaultUI.put("Label.font", myFont);
		
		// PANELS & LAYOUTS
		container.setLayout(new GridLayout(4,1));
		
		JPanel firstRowGrid = new JPanel(new GridLayout(1,3)); // To hold plus/minus and radio buttons
		JPanel radioButtonGrid = new JPanel(new GridLayout(2,1));
		JPanel secondRowGrid = new JPanel(new GridLayout(1,3));
		
		textField = new JTextField();
		textField.addActionListener(this);
		container.add(textField);
		
		label = new JLabel();
		label.setEnabled(false);
		container.add(label);
		
		// ADD PANELS TO CONTAINER
		container.add(firstRowGrid);
		container.add(secondRowGrid);
		
		// BUTTONS - FIRST ROW
		plusButton = new JButton("+");
		plusButton.addActionListener(this);
		firstRowGrid.add(plusButton);
		
		minusButton = new JButton("-");
		minusButton.addActionListener(this);
		firstRowGrid.add(minusButton);
		
		// RADIO BUTTONS
		firstRowGrid.add(radioButtonGrid);
		
		buttonRadioButton = new JRadioButton("Button");
		buttonRadioButton.setSelected(true);
		buttonRadioButton.addActionListener(this);
		radioButtonGrid.add(buttonRadioButton);
		
		returnRadioButton = new JRadioButton("Return");
		returnRadioButton.addActionListener(this);
		radioButtonGrid.add(returnRadioButton);
		
		// BUTTONS - SECOND ROW
		divButton = new JButton("/");
		divButton.addActionListener(this);
		secondRowGrid.add(divButton);
		
		multiButton = new JButton("*");
		multiButton.addActionListener(this);
		secondRowGrid.add(multiButton);

		equalsButton = new JButton("=");
		equalsButton.addActionListener(this);
		secondRowGrid.add(equalsButton);
		
		// Final GUI code
		textField.requestFocus();
		pack();
		setTitle("Pocket calculator");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		new GUI(); //Create anonymous object to run constructor
	}

	public void actionPerformed(ActionEvent e) {

		// RADIO BUTTONS
		if (e.getSource() == returnRadioButton && returnRadioButton.isSelected()) {
			enableButtons(false);
			buttonRadioButton.setSelected(false);
		}
		
		if (e.getSource() == buttonRadioButton && buttonRadioButton.isSelected()) {
			enableButtons(true);
			returnRadioButton.setSelected(false);
		}
		
		// RETURN MODE
		if (returnRadioButton.isSelected() && e.getSource() == textField) {
			calculate();
		}		
		
		// BUTTON MODE
		if (e.getSource() == plusButton) {
			addOperationSign("+");
		}
		
		if (e.getSource() == minusButton) {
			addOperationSign("-");
		}
		
		if (e.getSource() == divButton) {
			addOperationSign("/");
		}
		
		if (e.getSource() == multiButton) {
			addOperationSign("*");
		}

		if (e.getSource() == equalsButton) {
			addOperationSign("=");
			calculate();
		}
	}
	
	public void addOperationSign(String operation) {
		String input = textField.getText().trim();
		textField.setText(input + " " + operation + " ");
		textField.requestFocus();
	}
	
	public void calculate() {
		String input = textField.getText().trim(); // Get text input from textField and trim leading and trailing whitespace.
		String[] inputElements = input.split(" +");
		
		if (validateInput(inputElements)) { 						// Run only if valid input
			ArrayList<String> elements = new ArrayList<String>(); 	// ArrayList for more flexibility
			Collections.addAll(elements, inputElements);			// Add all elements from validated input to ArrayList
			
			// Loop over each operator separately to follow order of operations
			
			for (int i = 1; i < elements.size()-1; i += 2) { // Iterate over operators (odd indices)
				if (elements.get(i).equals("*")) {
					double previousNumber = Double.parseDouble(elements.get(i-1));			// Get element (number) before operator
					double nextNumber = Double.parseDouble(elements.get(i+1));				// and after
					String calculation = String.valueOf((previousNumber * nextNumber));		// Do calculation
					elements.set(i-1, calculation);											// Set calculation result to index of first number
					elements.remove(i); elements.remove(i);									// Remove index with used operation and "nextNumber"
					i -= 2;																	// Decrement by 2 as size has been decreased by 2
				}
			}
			
			for (int i = 1; i < elements.size()-1; i += 2) { // Iterate over operators (odd indices)
				if (elements.get(i).equals("/")) {
					double previousNumber = Double.parseDouble(elements.get(i-1));
					double nextNumber = Double.parseDouble(elements.get(i+1));
					String calculation = String.valueOf((previousNumber / nextNumber));
					elements.set(i-1, calculation);
					elements.remove(i); elements.remove(i);
					i -= 2;
				}
			}
			
			for (int i = 1; i < elements.size()-1; i += 2) { // Iterate over operators (odd indices)
				if (elements.get(i).equals("-")) {
					double previousNumber = Double.parseDouble(elements.get(i-1));
					double nextNumber = Double.parseDouble(elements.get(i+1));
					String calculation = String.valueOf((previousNumber - nextNumber));
					elements.set(i-1, calculation);
					elements.remove(i); elements.remove(i);
					i -= 2;
				}
			}
			
			for (int i = 1; i < elements.size()-1; i += 2) { // Iterate over operators (odd indices)
				if (elements.get(i).equals("+")) {
					double previousNumber = Double.parseDouble(elements.get(i-1));
					double nextNumber = Double.parseDouble(elements.get(i+1));
					String calculation = String.valueOf((previousNumber + nextNumber));
					elements.set(i-1, calculation);
					elements.remove(i); elements.remove(i);
					i -= 2;
				}
			}
			
			label.setText(input + " " + elements.get(0));
			textField.setText("");
			
		} else {
			label.setText("Error");
		}
	}
	
	public void enableButtons(boolean arg) {
		plusButton.setEnabled(arg);
		minusButton.setEnabled(arg);
		divButton.setEnabled(arg);
		multiButton.setEnabled(arg);
		equalsButton.setEnabled(arg);
	}
	
	// Validate input by checking if length of array is an even number and if last index is '='
	public boolean validateInput(String[] arg) {
		int length = arg.length;
		
		if ((length % 2 == 0) && (arg[length - 1].equals("="))) {
			
			// Validate that even indices are numbers and odd are operators 
			for (int i = 0; i < arg.length; i++) {
				if (i % 2 == 0) { // If on even index, should be an number
					if (!isNumeric(arg[i])) {
						System.out.println("Debug: Operator on even index[" + i + "]");
						return false;
					}
				} else {		  // If on odd number, should be an operator
					if (isNumeric(arg[i])) {
						System.out.println("Debug: Number on odd index[" + i + "]");
						return false;
					}
				}
			}
			
			return true;
			
		} else {
			return false;
		}
	}
	
	public boolean isNumeric(String arg) {
		if (arg == null) {
			return false;
		}
		
		try {
			Double.parseDouble(arg);
		} catch (Exception e) {
			return false;
		}
		
		return true;
	}

}
