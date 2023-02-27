package lesson6;
import javax.swing.*; import java.awt.*; import java.awt.event.*;

public class GUI extends JFrame implements ActionListener{
	
	private JTextField myTextField1, myTextField2;
	private JButton myButton1, myButton2;
	private JRadioButton myRadioButton1, myRadioButton2;
	//private JPanel leftPanel, rightPanel, centerPanel;
	
	public GUI() { setSize(400,200); setVisible(true);
		Container c = getContentPane();
		c.setLayout(new GridLayout(3,1));
		Font theFont = new Font("Serif",Font.ITALIC,25);
		
		myTextField1 = new JTextField();
		myTextField1.setFont(theFont);
		myTextField1.addActionListener(this); //activates when enter/return is pressed
		
		myTextField2 = new JTextField();
		myTextField2.setFont(theFont);
		myTextField2.setEditable(false); //can only write to, accepts no input
		
		myButton1 = new JButton("Copy text");
		myButton1.setFont(theFont);
		myButton1.addActionListener(this);
		
		myButton2 = new JButton("On");
		myButton2.setFont(theFont);
		myButton2.addActionListener(this);
		
		myRadioButton1 = new JRadioButton("Copy full text", true);
		myRadioButton1.setFont(theFont);
		myRadioButton1.addActionListener(this);
		
		myRadioButton2 = new JRadioButton("Copy selected text");
		myRadioButton2.setFont(theFont);
		myRadioButton2.addActionListener(this);
		
		JPanel leftPanel = new JPanel(); 
		leftPanel.setLayout(new GridLayout(1,2));
		leftPanel.add(myButton1); leftPanel.add(myButton2);
		//leftPanel.add(myButton1, myButton2);
		
		JPanel rightPanel = new JPanel();
		rightPanel.setLayout(new GridLayout(2,1));
		rightPanel.add(myRadioButton1); rightPanel.add(myRadioButton2);
		//rightPanel.add(myRadioButton1, myRadiobButton2);
		
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout(1,2));
		centerPanel.add(leftPanel); centerPanel.add(rightPanel);
		//centerPanel.add(leftPanel, rightPanel);
		
		c.add(myTextField1);
		c.add(centerPanel);
		c.add(myTextField2);
		
		//c.add(myTextField1, centerPanel, myTextField2);
		
		pack(); //must be at the bottom to pack inserted components after they are inserted
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == myButton1 || ae.getSource() == myTextField1) {
			if(myRadioButton1.isSelected() && myButton2.getText().equals("Off")) {
				myTextField2.setText(myTextField1.getText());
			}
			else if(myRadioButton2.isSelected() && myButton2.getText().equals("Off")) {
				myTextField2.setText(myTextField1.getSelectedText());
			}
		}
		if(ae.getSource() == myButton2) {
			if(myButton2.getText().equals("On")) {
				myTextField2.setEnabled(true);
				myButton2.setText("Off");
			} else {
				myTextField2.setEnabled(false);
				myButton2.setText("On");
			}
		}
		if(ae.getSource() == myRadioButton1) {
			if(myRadioButton1.isSelected()) myRadioButton2.setSelected(false);
			if(myRadioButton1.isSelected() == false && myRadioButton2.isSelected() == false) myRadioButton1.setSelected(true);
		}
		if(ae.getSource() == myRadioButton2) {
			if(myRadioButton2.isSelected()) myRadioButton1.setSelected(false);
			if(myRadioButton2.isSelected() == false && myRadioButton1.isSelected() == false) myRadioButton2.setSelected(true);
		}
	}
	
	public static void main(String[] args) {
		GUI mc = new GUI();
		
	}

}
