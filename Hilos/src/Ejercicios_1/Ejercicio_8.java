package Ejercicios_1;

public class Ejercicio_8 extends Thread {

	
	public void run() {
		String meses[] = {"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre",
				"Octubre","Noviembre","Diciembre"};
		for (int i = 0; i <meses.length; i++) {
			try {
				if (meses.length <=3) {
					System.out.println(meses[i]);
					sleep(50);
				}else if (meses.length <=6) {
					System.out.println(meses[i]);
					sleep(150);
				}else if (meses.length <=9) {
					System.out.println(meses[i]);
					sleep(200);
				}else {
					System.out.println(meses[i]);
					sleep(50);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
	public static void main(String[] args) {
		new Ejercicio_8().start();
	}
}
