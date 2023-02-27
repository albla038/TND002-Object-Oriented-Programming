package lab6;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class GUI extends JFrame implements ActionListener {
	
	PhoneBook phoneBook;
	
	JPanel leftPanel;
	JPanel rightPanel;
	
	JButton buttonLoad;
	JButton buttonSave;
	JButton buttonSearch;
	JButton buttonNext;
	JButton buttonAdd;
	JButton buttonDelete;
	
	JTextField searchField;
	JTextField nameField;
	JTextField numberField;
	
	public GUI() {
		phoneBook = new PhoneBook();
		
		setTitle("Interactive phone book");
		Font font = new Font("SansSerif", Font.PLAIN, 20);
		Container container = getContentPane();
		
		// BUTTONS
		buttonLoad = new JButton("Load phonebook");
		buttonLoad.setFont(font);
		buttonLoad.addActionListener(this);
		
		buttonSave = new JButton("Save phonebook");
		buttonSave.setFont(font);
		buttonSave.addActionListener(this);
		buttonSave.setEnabled(false);
		
		buttonSearch = new JButton("Search");
		buttonSearch.setFont(font);
		buttonSearch.addActionListener(this);
		buttonSearch.setEnabled(false);
				
		buttonNext = new JButton("Next name");
		buttonNext.setFont(font);
		buttonNext.addActionListener(this);
		buttonNext.setEnabled(false);
		
		buttonAdd = new JButton("Add person");
		buttonAdd.setFont(font);
		buttonAdd.addActionListener(this);
		buttonAdd.setEnabled(false);
		
		buttonDelete = new JButton("Delete person");
		buttonDelete.setFont(font);
		buttonDelete.addActionListener(this);
		buttonDelete.setEnabled(false);
		
		// TEXTFIELDS
		searchField = new JTextField();
		searchField.setFont(font);
		searchField.addActionListener(this);
		
		nameField = new JTextField();
		nameField.setFont(font);
		nameField.addActionListener(this);
		nameField.setEnabled(false);
		
		numberField = new JTextField();
		numberField.setFont(font);
		numberField.addActionListener(this);
		numberField.setEnabled(false);
		
		// LAYOUTS
		container.setLayout(new GridLayout(1,2));
		
		leftPanel = new JPanel(new GridLayout(3,2));
		leftPanel.add(buttonLoad);
		leftPanel.add(buttonSave);
		leftPanel.add(buttonSearch);
		leftPanel.add(buttonNext);
		leftPanel.add(buttonAdd);
		leftPanel.add(buttonDelete);
		container.add(leftPanel);
		
		rightPanel = new JPanel(new GridLayout(3,1));
		rightPanel.add(searchField);
		rightPanel.add(nameField);
		rightPanel.add(numberField);
		container.add(rightPanel);
	
		
		// SHOW GUI
		pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		
		new GUI();
		
		/*
		PhoneBook p = new PhoneBook();
		System.out.println(p.load("PhoneList.txt"));
		p.deletePerson("Erik Andersson", 10120);
		
		p.printArray();
		*/
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == buttonLoad || e.getSource() == searchField) {
			String input = searchField.getText();
			searchField.setText("");
			String LoadResult = phoneBook.load(input);
			nameField.setText(LoadResult);
			if(LoadResult.equals("Phone book loaded")) {
				buttonSave.setEnabled(true);
				buttonSearch.setEnabled(true);
				buttonAdd.setEnabled(true);
				buttonDelete.setEnabled(true);
			}
		}
			
//		JButton buttonLoad;
//		JButton buttonSave;
//		JButton buttonSearch;
//		JButton buttonNext;
//		JButton buttonAdd;
//		JButton buttonDelete;
	}

}
