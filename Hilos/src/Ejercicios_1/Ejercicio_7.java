package Ejercicios_1;

public class Ejercicio_7 extends Thread {

	Boolean sw;

	public Ejercicio_7(Boolean sw) {
		super();
		this.sw = sw;
	}

	public void run() {
		int totalPares=0,totalImpares=0;
		if (sw) {
			for (int i = 0; i <= 100; i++) {
				try {
					if (i % 2 == 0) {
						System.out.println("Ejecucion Hilo numeros pares: "+i);
						sleep(100);
						totalPares+=i;
					}
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			System.out.println("Ejecucion completada de numeros pares: "+totalPares);
		} else {
			for (int i = 0; i <= 100; i++) {
				try {
					if (i % 2 != 0) {
						System.out.println("Ejecucion Hilo numeros impares:"+i);
						sleep(100);
						totalImpares+=i;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			System.out.println("Ejecucion completada de numeros impares: "+totalImpares);

		}
	}

	public static void main(String[] args) {
		new Ejercicio_7(true).start();
		new Ejercicio_7(false).start();
	}
}
