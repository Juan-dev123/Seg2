package model;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import exceptions.InvalidDayToGetOut;
import exceptions.UnderAge;

class MiniMarketTest {
	private MiniMarket miniMarket;
	
	private void setupScenary1() {
		miniMarket=new MiniMarket("Mi Barrio Te Quiere");
	}

	@Test
	public void testRegisterAPerson1() {
		setupScenary1();
		int typeId=2;
		String numberId;
		int currentDay=LocalDate.now().getDayOfMonth();
		if(currentDay%2==0) {
			//If the day is pair
			numberId="3355775";
			try {
				miniMarket.registerAPerson(typeId, numberId);
				miniMarket.addPersonTriedEnter();
				assertEquals(typeId,miniMarket.getPeople().get(0).getTypeId());
				assertEquals(numberId,miniMarket.getPeople().get(0).getNumberId());
				assertEquals(1, miniMarket.getPeopleTriedEnter());
			}catch(UnderAge ua) {
				fail("UnderAge was not expected");
			}catch(InvalidDayToGetOut idgetout) {
				fail("InvalidDayToGetOut was not expected");
			}
			
		}else {
			//If the day is odd
			numberId="1325764";
			try {
				miniMarket.registerAPerson(typeId, numberId);
				miniMarket.addPersonTriedEnter();
				assertEquals(typeId,miniMarket.getPeople().get(0).getTypeId());
				assertEquals(numberId,miniMarket.getPeople().get(0).getNumberId());
				assertEquals(1, miniMarket.getPeopleTriedEnter());
			}catch(UnderAge ua) {
				fail("UnderAge was not expected");
			}catch(InvalidDayToGetOut idgetout) {
				fail("InvalidDayToGetOut was not expected");
			}
		}
		
	}
	
	@Test
	public void testRegisterAPerson2() {
		setupScenary1();
		int typeId=1;
		String numberId="1298453";
		
		try {
			miniMarket.registerAPerson(typeId, numberId);
			fail("UnderAge was expected");
		}catch(UnderAge ua) {
			miniMarket.addPersonTriedEnter();
			assertEquals(0, miniMarket.getPeople().size());
			assertEquals(1, miniMarket.getPeopleTriedEnter());
		}catch(InvalidDayToGetOut idgetout) {
			fail("InvalidDayToGetOut was not expected");
		}

	}
	
	@Test
	public void testRegisterAPerson3() {
		setupScenary1();
		int typeId=2;
		int currentDay=LocalDate.now().getDayOfMonth();
		String numberId;
		if(currentDay%2==0){
			//If the day is pair
			numberId="2274807";
			try {
				miniMarket.registerAPerson(typeId, numberId);
				fail("InvalidDayToGetOut was expected");
			}catch(UnderAge ua){
				fail("UnderAge was not expected");
			}catch(InvalidDayToGetOut idgetout){
				miniMarket.addPersonTriedEnter();
				assertEquals(0, miniMarket.getPeople().size());
				assertEquals(1, miniMarket.getPeopleTriedEnter());
			}
		}else {
			//If the day is odd
			numberId="1274416";
			try {
				miniMarket.registerAPerson(typeId, numberId);
				fail("InvalidDayToGetOut was expected");
			}catch(UnderAge ua){
				fail("UnderAge was not expected");
			}catch(InvalidDayToGetOut idgetout){
				miniMarket.addPersonTriedEnter();
				assertEquals(0, miniMarket.getPeople().size());
				assertEquals(1, miniMarket.getPeopleTriedEnter());
			}
		}
	}

}
