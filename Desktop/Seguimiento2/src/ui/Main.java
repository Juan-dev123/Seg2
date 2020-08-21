package ui;

import java.util.Scanner;
import model.MiniMarket;
import model.UnderAge;
import model.InvalidDayToGetOut;

public class Main {
	private MiniMarket miniMarket;
	private Scanner read;
	
	public Main() {
		miniMarket=new MiniMarket("Mi Barrio Te Quiere");
		read=new Scanner(System.in);
	}
	public static void main(String[] args) {
		Main m=new Main();
		m.printMenu();
		
		
	}
	
	public void printMenu() {
		boolean continueLoop=true;
		do {
			System.out.println("Bienvenido, que desea hacer?");
			System.out.println("1 Registrar el ingreso de una persona");
			System.out.println("2 Cantidad de personas que han intentado ingresar");
			System.out.println("3 Salir");
			int option=read.nextInt();
			read.nextLine();
			switch(option) {
			case 1:
				registerPerson();
				break;
			case 2:
				getPeopleTriedEnter();
				break;
			case 3:
				continueLoop=false;
				System.out.println("Hasta luego");
				break;
			default:
				
				break;
			}
		}while(continueLoop);
		
			
	}
	
	public void registerPerson() {
		System.out.print("Ingrese el numero del documento de identificacion: ");
		String numberId=read.nextLine();
		int typeId;
		int cont=0;
		do {
			if(cont>0) {
				System.out.print("Ingresa un numero valido 1/2/3/4");
			}
			System.out.println("\nSeleccione el tipo de documento de identificacion");
			System.out.println("1 Tarjeta de identidad");
			System.out.println("2 Cedula de ciudadania");
			System.out.println("3 Pasaporte");
			System.out.println("4 Cedula de extranjeria");
			typeId=read.nextInt();
			cont++;
		}while(typeId<1 || typeId>4);
		
		try {
			miniMarket.registerAPerson(typeId, numberId);
			System.out.println("Se registro correctamente el usuario");
			miniMarket.addPersonTriedEnter();
			
		}catch(UnderAge ua) {
			System.out.println(ua.getMessage());
			miniMarket.addPersonTriedEnter();
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
	
	public void getPeopleTriedEnter() {
		if(miniMarket.getPeopleTriedEnter()==1) {
			System.out.println("1 persona ha intentado registrarse");
		}else {
			System.out.printf("%d personas han intentado registrarse%n", miniMarket.getPeopleTriedEnter());
		}
	}
	
}
