package lesson6;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class GUI extends JFrame implements ActionListener {
	
	Container container;
	GridLayout gridLayout;
	JPanel centerPanel;
	JPanel leftPanel;
	JPanel rightPanel;
	
	JTextField textField1;
	JTextField textField2;
	
	JButton buttonCopyText;
	JButton buttonOn;
	
	JRadioButton rbFullText;
	JRadioButton rbSelectedText;
	
	public GUI() {
		// Std GUI method calls
		setTitle("Lesson 6");
		//setSize(600,300);
		container = getContentPane();
		gridLayout = new GridLayout(3,1);
		setLayout(gridLayout);
		Font font = new Font("Serif", Font.ITALIC, 25);
		
		// Text Field 1
		textField1 = new JTextField();
		textField1.setFont(font);
		container.add(textField1);
				
		// Center panel
		centerPanel = new JPanel(new GridLayout(1,2));
		container.add(centerPanel);
		
		// Left panel with button components
		leftPanel = new JPanel(new GridLayout(1,2));
		centerPanel.add(leftPanel);
		
		buttonCopyText = new JButton("Copy text");
		buttonCopyText.addActionListener(this);
		buttonCopyText.setFont(font);
		leftPanel.add(buttonCopyText);
		
		buttonOn = new JButton("On");
		buttonOn.addActionListener(this);
		buttonOn.setFont(font);
		leftPanel.add(buttonOn);
		
		// Radio buttons and panel
		rightPanel = new JPanel(new GridLayout(2,1));
		centerPanel.add(rightPanel);
		
		rbFullText = new JRadioButton("Copy full text", true);
		rbFullText.addActionListener(this);
		rbFullText.setFont(font);
		rightPanel.add(rbFullText);
		
		rbSelectedText = new JRadioButton("Copy selected text");
		rbSelectedText.addActionListener(this);
		rbSelectedText.setFont(font);
		rightPanel.add(rbSelectedText);
		
		// Text Field 2
		textField2 = new JTextField();
		textField2.setEnabled(false);
		textField2.setEditable(false);
		textField2.setFont(font);
		container.add(textField2);
		
		// Final GUI method calls
		pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		// buttonOn
		if (e.getSource() == buttonOn) {
			if (buttonOn.getText().equals("On")) {
				buttonOn.setText("Off");
				textField2.setEnabled(true);
			} else {
				buttonOn.setText("On");
				textField2.setEnabled(false);
			}
		}
		
		// buttonCopyText
		if (e.getSource() == buttonCopyText) {
			if (buttonOn.getText().equals("Off")) {
				String input = null;
				if (rbFullText.isSelected()) {
					input = textField1.getText();
				} else {
					input = textField1.getSelectedText();
				}
				textField2.setText(input);
			}
		}
		
		// rbFullText
		if (e.getSource() == rbFullText) {
			if (rbFullText.isSelected()) {
				rbSelectedText.setSelected(false);
			} else {
				rbFullText.setSelected(true);
			}
		}
		
		// rbSelectedText
		if (e.getSource() == rbSelectedText) {
			if (rbSelectedText.isSelected()) {
				rbFullText.setSelected(false);
			} else {
				rbSelectedText.setSelected(true);
			}
		}
		
	}
}
