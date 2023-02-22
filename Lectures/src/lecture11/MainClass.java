package lecture11;
import javax.swing.JOptionPane;

public class MainClass {

	public MainClass(String s) {
		System.out.println(s);
	}
	
	public static void main(String[] args) {
		System.out.println("Hello");
		MainClass mc = new MainClass("world");
		
//		JOptionPane.showMessageDialog(null, "Hello");
//		String input = JOptionPane.showInputDialog("User input:");
//		System.out.println(input);
	}

}