package Ejercicios_1;

public class Ejercicio_2 extends Thread{

	public void run() {
		for (int i = 1;i<=121;i++) {
			if (i%2 !=0) {
				System.out.println(i);
				try {
					Thread.sleep(1000);
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void main(String[] args) {
		
	}

}
