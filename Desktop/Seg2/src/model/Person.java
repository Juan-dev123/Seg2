package model;

public class Person {
	public static final int TI=1;
	public static final int CC=2;
	public static final int PP=3;
	public static final int CE=4;
	
	private int typeId;
	private String numberId;
	
	public Person(int typeId, String numberId) {
		this.typeId=typeId;
		this.numberId=numberId;
	}
	
	public int getTypeId() {
		return typeId;
	}
	
	public String getNumberId() {
		return numberId;
	}
	
}
