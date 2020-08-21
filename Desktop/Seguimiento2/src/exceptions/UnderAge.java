package exceptions;

public class UnderAge extends Exception{
	public UnderAge() {
		super("Los menores de edad no pueden ingresar al local");
	}
}
