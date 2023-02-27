package lab6;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

public class GUI extends JFrame implements ActionListener {
	
	PhoneBook phoneBook;

	ArrayList<Person> currentSearchResults = new ArrayList<Person>();
	int personCounter = 0;
	
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
		nameField.setEditable(false);
		
		numberField = new JTextField();
		numberField.setFont(font);
		numberField.addActionListener(this);
		numberField.setEditable(false);
		
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
		searchField.requestFocus();
		setVisible(true);
	}

	public static void main(String[] args) {
		new GUI();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == buttonLoad || e.getSource() == searchField) {
			String input = searchField.getText();
			searchField.setText("");
			String LoadResult = phoneBook.load(input);
			nameField.setText(LoadResult);
			if (LoadResult.equals("Phone book loaded")) {
				buttonSave.setEnabled(true);
				buttonSearch.setEnabled(true);
				buttonAdd.setEnabled(true);
				buttonDelete.setEnabled(true);
			}
		}
		
		if (e.getSource() == buttonSave) {
			String input = searchField.getText();
			searchField.setText("");
			if (input.equals("")) {
				nameField.setText("Provide a file name");
			} else if (input.equals("PhoneList.txt")) {
				nameField.setText("File name already occupied");
			} else {
				nameField.setText(phoneBook.save(input));
			}
		}
		
		
		if (e.getSource() == buttonSearch) {
			String input = searchField.getText();
			searchField.setText("");
			currentSearchResults = phoneBook.search(input);
			if (currentSearchResults.size() == 0) {
				nameField.setText("Provide a name");
				numberField.setText("");
			} else if (currentSearchResults.size() == 1) {
				nameField.setText(currentSearchResults.get(0).getFullName());
				numberField.setText(String.valueOf(currentSearchResults.get(0).getPhoneNumber()));
			} else {
				buttonNext.setEnabled(true);
				personCounter = 0;
				nameField.setText(currentSearchResults.get(personCounter).getFullName());
				numberField.setText(String.valueOf(currentSearchResults.get(personCounter).getPhoneNumber()));
			}
		}
		
		if (e.getSource() == buttonNext) {
			personCounter++;
			nameField.setText(currentSearchResults.get(personCounter).getFullName());
			numberField.setText(String.valueOf(currentSearchResults.get(personCounter).getPhoneNumber()));
			
			if (personCounter == currentSearchResults.size() - 1) {
				buttonNext.setEnabled(false); 
				personCounter = 0;
			}
		}
		
		if (e.getSource() == buttonDelete) {
			if (phoneBook.search(numberField.getText()).size() != 0) {
				String returnStatement = phoneBook.deletePerson(nameField.getText(), Integer.parseInt(numberField.getText()));
				currentSearchResults.remove(personCounter);
				searchField.setText(returnStatement);
				personCounter--;
			}
		}
		
		if (e.getSource() == buttonAdd) {
			if (!nameField.isEditable() && !numberField.isEditable()) {
				searchField.setText("Type in name and phone number");
				nameField.setEditable(true);
				numberField.setEditable(true);				
			} else {
				phoneBook.addPerson(nameField.getText(), Integer.parseInt(numberField.getText()));
				nameField.setText("");
				numberField.setText("");
				nameField.setEditable(false);
				numberField.setEditable(false);
				searchField.setText("Person added");
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
