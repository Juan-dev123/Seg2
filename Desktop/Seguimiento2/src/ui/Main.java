package ui;

import java.util.Scanner;
import model.MiniMarket;
import model.InvalidTypeId;

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
		System.out.println("Bienvenido, que desea hacer?");
		System.out.println("1 Registrar el ingreso de una persona");
		System.out.println("2 Cantidad de personas que han intentado ingresar");
		System.out.println("3 Salir");
		int option=read.nextInt();
		switch(option) {
		case 1:
			boolean personEnter=registerPerson();
			break;
		case 2:
			break;
		case 3:
			break;
		default:
			
			break;
		}
			
	}
	
	public boolean registerPerson() {
		System.out.println("Seleccione el tipo de documento de identificacion");
		System.out.println("1 Tarjeta de identidad");
		System.out.println("2 Cedula de ciudadania");
		System.out.println("3 Pasaporte");
		System.out.println("4 Cedula de extranjeria");
		
		int typeId=read.nextInt();
		if(typeId<1 && typeId>4) {
			
		}
		
		return true;
	}
}
