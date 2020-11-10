package Ejercicio1;

public class CUCU extends Thread {
	
	public void run() {
		while (true) {
			System.out.println("CUCU");
			try {
				wait();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}
}
