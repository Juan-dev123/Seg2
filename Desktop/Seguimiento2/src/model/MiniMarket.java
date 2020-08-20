package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.time.LocalDate;

public class MiniMarket {
	private String name;
	private int peopleTriedEnter;
	
	private ArrayList<Person> people;
	
	public MiniMarket(String name) {
		this.name=name;
		peopleTriedEnter=0;
	}
	
	public void registerAPerson(int typeId, String numberId) throws InvalidTypeId, UnderAge{
		if(typeId<1 || typeId>4) {
			throw new InvalidTypeId();
		}
		if(typeId==Person.TI) {
			throw new UnderAge();
		}
		int currentDay=LocalDate.now().getDayOfMonth();
		boolean pair=true;
		int penultimateNumber=(int)numberId.charAt(numberId.length()-2);
		if(penultimateNumber%2!=0) {
			pair=false;
		}
		if(pair && (currentDay%2==0)) {
			
		}
		
	}
	
	public int getPeopleTriedEnter() {
		return peopleTriedEnter;
	}
	
	public String getName() {
		return name;
	}
	
	public ArrayList<Person> getPeople(){
		return people;
	}
}
