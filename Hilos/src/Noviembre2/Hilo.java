package Noviembre2;

public class Hilo extends Thread {

	private int identificador;

	// Son variables compartidas en memoria entre todos los objetos de tipo Hilo
	private static Object obj = new Object();
	private static int contador = 1;

	@Override
	public void run() {

		synchronized (obj) { // Hay que pasarle un obj
			while (contador != getIdentificador()) {
				try {
					obj.wait(); // "Dormidos " o ponemos en espera un hil
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			System.out.println("Se esta ejecutando el hilo: " + this.getIdentificador());
			contador++;
			obj.notifyAll();
		}
	}

	public void method2() {
		synchronized (obj) { // Hay que pasarle un obj
			if (contador == getIdentificador()) {
				System.out.println("Se esta ejecutando el hilo: " + this.getIdentificador());
				contador++;
				obj.notifyAll();
				// Despierta a todos los hilos que estan "dormidos" o a la espera
			} else {
				try {
					obj.wait(); // "Dormidos " o ponemos en espera un hilo
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println("Termina la ejecucion del hilo: " + this.getIdentificador());
		}
	}

	public void method1() {
		System.out.println("Se inicia la ejecucion del hilo " + this.getId() + " Con nombre: " + this.getName());
		for (int i = 0; i < 10; i++) {
			System.out.println("Se ejecuta el hilo " + this.getId() + " Con nombre: " + this.getName()
					+ " vuelta numero " + (i + 1));
			try {
				sleep(40);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("Finaliza la ejecucion del hilo " + this.getId() + " Con nombre: " + this.getName()
				+ " Con prioridad " + this.getPriority());
	}

	public int getIdentificador() {
		return identificador;
	}

	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}

	public static int getContador() {
		return contador;
	}

	public static void setContador(int contador) {
		Hilo.contador = contador;
	}
}
