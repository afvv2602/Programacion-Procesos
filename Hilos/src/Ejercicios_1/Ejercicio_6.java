package Ejercicios_1;

public class Ejercicio_6 extends Thread {

	Boolean sw;

	public Ejercicio_6(Boolean sw) {
		super();
		this.sw = sw;
	}

	public void run() {
		String abecedario []= {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
		if (sw) {

			for (int i = 0; i <= 100; i++) {
				try {
					System.out.println(i);
					sleep(100);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} else {
			for (int i = 0; i <abecedario.length; i++) {
				try {
					System.out.println(abecedario[i]);
					sleep(100);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) {
		new Ejercicio_6(true).start();
		new Ejercicio_6(false).start();
	}

}
