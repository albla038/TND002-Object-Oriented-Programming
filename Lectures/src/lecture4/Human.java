package lecture4;

public class Human {

	private String name;
	
		public Human(String arg) {
			setName(arg);
		}
	
		public void setName(String arg) {
			name = arg;
		}
		
		public String getName() {
			return name;
		}
		
		public Human deepCopy() {
			return new Human(name);
		}
		
		public Human shallowCopy() {
			return this;
		}
		
		public String toString() {
			return "The name is: " + getName();
		}
	
		public static String addNames(Human arg1, Human arg2) {
			String str1 = arg1.getName();
			String str2 = arg2.getName();
			
			return str1 + " and " + str2;
		}
}
