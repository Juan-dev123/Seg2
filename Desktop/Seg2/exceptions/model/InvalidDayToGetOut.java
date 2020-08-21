package model;

public class InvalidDayToGetOut extends Exception{
	private boolean pair;
	public InvalidDayToGetOut(boolean pair) {
		super("No puede ingresar porque el dia de hoy es ");
		this.pair=pair;
	}
	
	public boolean getPair() {
		return pair;
	}
}
