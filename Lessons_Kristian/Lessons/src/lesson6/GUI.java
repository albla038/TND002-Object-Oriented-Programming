package lesson6;
import javax.swing.JFrame; import javax.swing.JLabel;
import javax.swing.JPanel; import javax.swing.JButton;
import javax.swing.JRadioButton; import javax.swing.JTextField;
import java.awt.*;

public class GUI extends JFrame{
	public GUI() { setSize(400,200); setVisible(true);
		Container c = getContentPane();
		c.setLayout(new GridLayout(3,1));
		Font theFont = new Font("Serif",Font.ITALIC,25);
		
		JTextField myTextField1 = new JTextField();
		myTextField1.setFont(theFont);
		JTextField myTextField2 = new JTextField();
		myTextField2.setFont(theFont);
		myTextField2.setEditable(false);
		
		JButton myButton1 = new JButton("Copy text");
		myButton1.setFont(theFont);
		myButton1.isSelected();
		JButton myButton2 = new JButton("On");
		myButton2.setFont(theFont);
		JRadioButton myRadioButton1 = new JRadioButton("Copy full text", true);
		myRadioButton1.setFont(theFont);
		JRadioButton myRadioButton2 = new JRadioButton("Copy selected text");
		myRadioButton2.setFont(theFont);
		
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout(1,2));
		JPanel leftPanel = new JPanel(); 
		leftPanel.setLayout(new GridLayout(1,2));
		leftPanel.add(myButton1); leftPanel.add(myButton2);
		JPanel rightPanel = new JPanel();
		rightPanel.setLayout(new GridLayout(2,1));
		rightPanel.add(myRadioButton1); rightPanel.add(myRadioButton2);
		
		centerPanel.add(leftPanel); centerPanel.add(rightPanel);
		c.add(myTextField1);
		c.add(centerPanel);
		c.add(myTextField2);
		
		pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		GUI mc = new GUI();
	}

}
