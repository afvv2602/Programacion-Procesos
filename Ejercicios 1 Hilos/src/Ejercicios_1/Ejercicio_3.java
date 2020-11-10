package Ejercicios_1;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Ejercicio_3 extends Thread {

	public void run() {
		try {
			System.out.println("Estamos en la bicicleta");
			for (int i = 0; i <= 180; i++) {
				System.out.println("Kilometro: " + i);
				sleep(100);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Terminamos la bicicleta");
		try {
			System.out.println("Estamos en la carrera");
			for (int i = 0; i <= 42; i++) {
				System.out.println("Kilometro: " + i);
				sleep(100);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Terminamos la carrera");
		try {
			System.out.println("Estamos en el nado");
			for (int i = 0; i <= 3800; i++) {
				if (i % 100 == 0) {
				System.out.println("Metros: " + i);
				sleep(100);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Teeminamos el nado");
	}

	public static void main(String[] args) {
		new Ejercicio_3().start();
		//BufferedReader br = new BufferedReader (new InputStreamReader(System.in)); // otra forma de leer por teclado en java
		
	}

}
