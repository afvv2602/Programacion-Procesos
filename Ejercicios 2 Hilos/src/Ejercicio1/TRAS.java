package Ejercicio1;

public class TRAS extends Thread {
	public void run() {

		System.out.println("TRAS");
		try {
			notify();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
