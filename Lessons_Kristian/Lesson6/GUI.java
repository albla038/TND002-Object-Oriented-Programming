import javax.swing.*; import java.awt.*; import java.awt.event.*;
public class GUI extends JFrame implements ActionListener {

	private JTextField text1, text2;
	private JButton tb1, tb2;
	private JPanel thePanel1, thePanel2, thePanel3;
	private JRadioButton rb1, rb2;
	
	public GUI() {
		Font theFont = new Font("Serif", Font.ITALIC, 25);
		
		rb1 = new JRadioButton("Copy full text"); rb1.doClick(); rb1.setFont(theFont); rb1.addActionListener(this);
		rb2 = new JRadioButton("Copy selected text"); rb2.setFont(theFont); rb2.addActionListener(this);
		
		thePanel1 = new JPanel(new GridLayout(2,1));
		thePanel1.add(rb1); thePanel1.add(rb2);
		
		tb1 = new JButton("Copy text"); tb1.setFont(theFont);tb1.addActionListener(this);
		tb2 = new JButton("On"); tb2.setFont(theFont);tb2.addActionListener(this);
		
		thePanel2 = new JPanel(new GridLayout(1,2));
		thePanel2.add(tb1); thePanel2.add(tb2);
		
		thePanel3 = new JPanel(new GridLayout(1,2));
		thePanel3.add(thePanel2); thePanel3.add(thePanel1);
		
		text1 = new JTextField(); text1.setFont(theFont); text1.addActionListener(this);
		text2 = new JTextField(); text2.setFont(theFont); text2.setEditable(false);
		
		Container c = getContentPane(); c.setLayout(new GridLayout(3,1));
		c.add(text1); c.add(thePanel3); c.add(text2);
		pack(); setVisible(true); setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == tb2) {
			if (tb2.getText().equals("On")) {
				tb2.setText("Off"); text2.setEditable(true); text2.setEnabled(false);
			}
			else {
				tb2.setText("On"); text2.setText("");text2.setEditable(false);
			}
		}
		if (ae.getSource() == tb1) {
			if (tb2.getText().equals("Off")) {
				if (rb1.isSelected()) {
					text2.setText(text1.getText());
				} else {
					text2.setText(text1.getSelectedText());
				}
			}
		}		
		if (ae.getSource() == rb1) {
			if (rb1.isSelected() && rb2.isSelected()) {
				rb2.doClick();
			}
		}
		if (ae.getSource() == rb2) {
			if (rb1.isSelected() && rb2.isSelected()) {
				rb1.doClick();
			}
		}
	}
	
	public static void main(String[] args) {
		
		GUI myGUI = new GUI();

	}

}
