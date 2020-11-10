package Ejercicios_1;

import java.util.Scanner;

public class Ejercicio_1 {

	String nombre;
	int dia;
	String hora;
	
	public Ejercicio_1(String nombre, int dia, String hora) {
		super();
		this.nombre = nombre;
		this.dia = dia;
		this.hora = hora;
	}
	
	public  String whichDay() {
		String day="";
		switch (this.dia) {
		case 0: day = "lunes"; break;
		case 1: day = "Martes"; break;
		case 2: day = "Miercoles"; break;
		case 3: day = "Jueves"; break;
		case 4: day = "Viernes"; break;
		default: break;
		}
		return day;
	}
	
	public void run() {
		boolean found = false;
		String horaAux = "";
		int i = 0;
		
		while(!found) {
			found = hora.charAt(i) == ':';
		}if (!found) {
			horaAux += hora.charAt(i);
			i++; 
		}
		if (horaAux.length()<2 && Integer.parseInt(horaAux)<8) {
			System.out.println("El profesor ha llegado temprano");
		}else {
			System.out.println("El profesor ha llegado tarde");
		}
		//Opcion B
		System.out.println(horaAux.length()<2 && Integer.parseInt(horaAux)<8
			?"El profesor ha llegado temprano"
			:"El profesor ha llegado tarde");
	}
	public static void main(String[] args) {
		Scanner teclado = new Scanner (System.in);
		String nombre;
		int dia;
		String hora;
		
		for (int i = 0; i<10;i++) {
			nombre = teclado.nextLine();
			dia = teclado.nextInt(); 
			teclado.nextLine(); //
			hora = teclado.nextLine();
			new Ejercicio_1(nombre, dia, hora);
		}
		teclado.close();
	}
	
}
