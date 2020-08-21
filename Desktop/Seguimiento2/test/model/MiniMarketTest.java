package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import model.MiniMarket;

class MiniMarketTest {
	private MiniMarket miniMarket;
	
	private void setupScenary1() {
		miniMarket=new MiniMarket("Mi Barrio Te Quiere");
	}

	@Test
	//Solo funciona si el dia es par
	public void testRegisterAPerson1() {
		setupScenary1();
		int typeId=2;
		String numberId="3355775";
		try {
			miniMarket.registerAPerson(typeId, numberId);
			miniMarket.addPersonTriedEnter();
			
		}catch(UnderAge ua) {
			fail();
		}catch(InvalidDayToGetOut idgetout) {
			boolean pair=idgetout.getPair();
			String message;
			if(pair) {
				message="par. Solo tiene permitido salir los dias impares";
			}else {
				message="impar. Solo tiene permitido salir los dias pares";
			}
			System.out.println(idgetout.getMessage()+message);
			miniMarket.addPersonTriedEnter();
		}
	}

}
