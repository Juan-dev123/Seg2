package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.time.LocalDate;
import exceptions.InvalidDayToGetOut;
import exceptions.UnderAge;

public class MiniMarket {
	private String name;
	private int peopleTriedEnter;
	
	private ArrayList<Person> people;
	
	public MiniMarket(String name) {
		this.name=name;
		peopleTriedEnter=0;
		people=new ArrayList<Person>();
	}
	
	public void registerAPerson(int typeId, String numberId) throws UnderAge, InvalidDayToGetOut{
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
			throw new InvalidDayToGetOut(pair);
		}
		if(!pair && (currentDay%2==1)) {
			throw new InvalidDayToGetOut(pair);
		}
		people.add(new Person(typeId, numberId));
	}
	
	public int getPeopleTriedEnter() {
		return peopleTriedEnter;
	}
	
	public void setPeopleTriedEnter(int number) {
		peopleTriedEnter=number;
	}
	
	public void addPersonTriedEnter() {
		peopleTriedEnter++;
	}
	
	public String getName() {
		return name;
	}
	
	public ArrayList<Person> getPeople(){
		return people;
	}
}
