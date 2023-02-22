package lecture11;

import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {
	
	public GUI() throws InterruptedException {
		
		setSize(400,200);
		setTitle("My First GUI");
		Container c = getContentPane();
		c.setBackground(Color.RED);
		
		JLabel myLabel1 = new JLabel("Wee", JLabel.CENTER);
		myLabel1.setFont(new Font("SansSerif", Font.ITALIC, 30));
		myLabel1.setForeground(Color.GREEN);
		
		JLabel myLabel2 = new JLabel("Ooo", JLabel.CENTER);
		myLabel2.setFont(new Font("SansSerif", Font.ITALIC, 30));
		myLabel2.setForeground(Color.MAGENTA);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
		int time = 400;
		
		for (int i = 0; i < 6; i++) {
			c.setBackground(Color.MAGENTA);
			c.add(myLabel1);
			Thread.sleep(time);
			
			c.remove(myLabel1);
			Thread.sleep(time);
			c.setBackground(Color.GREEN);
			c.add(myLabel2);
			Thread.sleep(time);
			c.remove(myLabel2);
		}
	}

	public static void main(String[] args) throws InterruptedException {
		GUI mc = new GUI();
	}
}
