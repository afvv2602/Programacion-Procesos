package Ejercicios_1;

public class Ejercicio_4 extends Thread{
	String nombre;
	
	public Ejercicio_4(String nombre) {
		super();
		this.nombre = nombre;
	}
	public void run() {
		for (int i = 0 ; i<100;i++) {
		try {
			System.out.println("El "+nombre+" va por el metro" +i);
			sleep(10);
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		}
		System.out.println("El "+nombre+" termina la carrera");
	}
	public static void main(String[] args) {
		new Ejercicio_4("conejo").start();
		new Ejercicio_4("Cigarra").start();
		new Ejercicio_4("Tortuga").start();
	}

}
