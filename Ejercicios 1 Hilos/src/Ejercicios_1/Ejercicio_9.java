package Ejercicios_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejercicio_9 extends Thread{

	String nombre;
	
	public Ejercicio_9(String nombre) {
		super();
		this.nombre = nombre;
	}

	public void run() {
		int notas[] = new int [6];
		int promedio=0;
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		for(int i = 0; i<notas.length;i++) {
			try {
				System.out.println("Introduce una nota");
				notas[i]=Integer.parseInt(br.readLine());
			} catch (NumberFormatException | IOException e) {
				e.printStackTrace();
			}try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		for (int i = 0; i < notas.length; i++) {
			System.out.println("La nota numero: "+(i+1)+" del alumno: " +this.nombre+" es: "+notas[i]);
			promedio+=notas[i];
		}
		promedio/=notas.length;
		System.out.println("La nota promedio del alumno: "+this.nombre+" es: "+promedio);
		
	}
	public static void main(String[] args) {
		new Ejercicio_9("Pedro").start();
	//	new Ejercicio_9("Andrea").start();
//		new Ejercicio_9("Lucia").start();
	}
}
