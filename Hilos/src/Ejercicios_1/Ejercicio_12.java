package Ejercicios_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejercicio_12 extends Thread {

	int numero1;
	int numero2;

	public Ejercicio_12(int numero1, int numero2) {
		super();
		this.numero1 = numero1;
		this.numero2 = numero2;
	}
	
	public void run() {
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		char operador = ' ';
		int resultado;
		try {
			System.out.println("Introduce un operador");
			operador=br.readLine().charAt(0);
		} catch (IOException e) {
			e.printStackTrace();
		}
		switch (operador) {
		case '*':  resultado = this.numero1 * this.numero2; System.out.println(resultado); break;
		case '+':  resultado = this.numero1 + this.numero2; System.out.println(resultado); break;
		case '-':  resultado = this.numero1 - this.numero2; System.out.println(resultado); break;
		case '/':  resultado = this.numero1 / this.numero2; System.out.println(resultado); break;
		}
		
	}
	public static void main(String[] args) {
		new Ejercicio_12(9, 6).start();
	}
}
