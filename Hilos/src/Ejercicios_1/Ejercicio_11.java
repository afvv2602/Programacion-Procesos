package Ejercicios_1;

public class Ejercicio_11 extends Thread {

	String nombre;
	int numeroPruebas;

	public Ejercicio_11(String nombre, int numeroPruebas) {
		super();
		this.nombre = nombre;
		this.numeroPruebas = numeroPruebas;
	}

	public void run() {
		for (int i = this.numeroPruebas; i <= 12; i++) {
			try {
				System.out.println("El caballero: "+this.nombre+" ha superado: "+i+" pruebas");
				sleep(500);
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("El caballero: "+this.nombre+" obtuvo la armadura dorada");
		}
	}

	public static void main(String[] args) {
		new Ejercicio_11("Leo", 6).start();
		new Ejercicio_11("Reinhart", 2).start();
	}

}
