package lecture5;

public class Generics<T> {
	T theVariable;
	
	public Generics(T arg) {
		theVariable = arg;
	}
	
	public String toString() {
		return theVariable.getClass().getSimpleName();
	}
	
}
