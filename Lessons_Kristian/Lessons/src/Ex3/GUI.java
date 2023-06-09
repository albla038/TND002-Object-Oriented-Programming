package Ex3;
import javax.swing.*; import java.awt.*; import java.awt.event.*;
import java.util.ArrayList;

public class GUI extends JFrame implements ActionListener {

	private JPanel upperHalf, lowerHalf, radioButtonPanel;
	private JRadioButton radio1, radio2;
	private JButton plus, minus, div, mult, equal;
	private JTextField textUp, textLow;
	
	public GUI() {
		
		textUp = new JTextField(); textUp.setEditable(true); textUp.addActionListener(this);
		textLow = new JTextField(); textLow.setEditable(false); 
		upperHalf = new JPanel();
		upperHalf.setLayout(new GridLayout(2,1));
		upperHalf.add(textUp); upperHalf.add(textLow);
		
		radioButtonPanel = new JPanel();
		radio1 = new JRadioButton("Button"); radio1.doClick(); radio1.addActionListener(this);
		radio2 = new JRadioButton("Return"); radio2.addActionListener(this);
		radioButtonPanel.setLayout(new GridLayout(2,1));
		radioButtonPanel.add(radio1); radioButtonPanel.add(radio2); 
		
		lowerHalf = new JPanel();
		plus = new JButton("+"); minus = new JButton("-");
		div = new JButton("/"); mult = new JButton("*"); equal = new JButton("=");
		plus.addActionListener(this); minus.addActionListener(this);
		div.addActionListener(this); mult.addActionListener(this); equal.addActionListener(this);
		lowerHalf.setLayout(new GridLayout(2,3));
		lowerHalf.add(plus); lowerHalf.add(minus); lowerHalf.add(radioButtonPanel);
		lowerHalf.add(div); lowerHalf.add(mult); lowerHalf.add(equal);
		
		Font theFont = new Font("SansSerif",Font.PLAIN,25);
		textUp.setFont(theFont); textLow.setFont(theFont);
		plus.setFont(theFont); minus.setFont(theFont); div.setFont(theFont); mult.setFont(theFont); equal.setFont(theFont);
		radio1.setFont(theFont); radio2.setFont(theFont);
		Container c = getContentPane();
		c.setLayout(new GridLayout(2,1));
		c.add(upperHalf); c.add(lowerHalf);
		pack(); setVisible(true); setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent ae) {
		
		if (ae.getSource() == radio1 || ae.getSource() == radio2) {
			if (radio1.isSelected() && !radio2.isSelected()) {
				plus.setEnabled(true); minus.setEnabled(true); mult.setEnabled(true);
				div.setEnabled(true); equal.setEnabled(true);
			}
			else if (ae.getSource() == radio1 || ae.getSource() == radio2) {
				if (!radio1.isSelected() && radio2.isSelected()) {
					plus.setEnabled(false); minus.setEnabled(false); mult.setEnabled(false);
					div.setEnabled(false); equal.setEnabled(false);
				}
			}
		}
		
		if (ae.getSource() == textUp) {
			textLow.setText(textUp.getText() + " " + compute(textUp.getText())); textUp.setText("");
		}
		
		
	}
	
	public double compute(String arg) {
		String[] result = arg.split(" +");
		
		ArrayList<String> source = new ArrayList<String>();
		for (int i=0; i < result.length; i++) {
			source.add(result[i]);
		}
		String calc;
		for (int i=1; i < source.size() - 2; i=i+2) {
			if (source.get(i).equals("/")) {
				calc = String.valueOf(Double.valueOf(source.get(i-1)) / Double.valueOf(source.get(i+1))); 
				source.set(i-1, calc); source.remove(i); source.remove(i); i = i - 2;
			}
		}
		for (int i=1; i < source.size() - 2; i=i+2) {
			if (source.get(i).equals("*")) {
				calc = String.valueOf(Double.valueOf(source.get(i-1)) * Double.valueOf(source.get(i+1))); 
				source.set(i-1, calc); source.remove(i); source.remove(i); i = i - 2;
			}
		}
		for (int i=1; i < source.size() - 2; i=i+2) {
			if (source.get(i).equals("+")) {
				calc = String.valueOf(Double.valueOf(source.get(i-1)) + Double.valueOf(source.get(i+1))); 
				source.set(i-1, calc); source.remove(i); source.remove(i); i = i - 2;
			}
		}
		for (int i=1; i < source.size() - 2; i=i+2) {
			if (source.get(i).equals("-")) {
				calc = String.valueOf(Double.valueOf(source.get(i-1)) - Double.valueOf(source.get(i+1))); 
				source.set(i-1, calc); source.remove(i); source.remove(i); i = i - 2;
			}
		}
		
		return Double.valueOf(source.get(0));
	}
	
	
	public static void main(String[] args) {
		GUI myGUI = new GUI();
	}
	
}
