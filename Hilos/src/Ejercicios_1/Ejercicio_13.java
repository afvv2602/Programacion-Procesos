package Ejercicios_1;

import java.util.ArrayList;

public class Ejercicio_13 extends Thread {

	public void run() {
		Boolean sw = true;
		int dorsal ;
		ArrayList<Integer> Dorsales = new ArrayList<>();
		for (int i = 0; i <= 13; i++, sw = false) {
			dorsal = (int) (Math.random() * 100);
			if (sw) {
				Dorsales.add(dorsal);
			}
			for (int busquedaDorsales : Dorsales) {
				if (busquedaDorsales == dorsal) {
					sw = false;
					break;
				}else sw = true;
			}
			if (sw) {
				Dorsales.add(dorsal);
			}
		}
		try {
			System.out.println("Preparados");
			sleep(1000);
			System.out.println("Listos ya!");
			sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		for (int i = 0; i < Dorsales.size(); i++) {
			int tiempoTotal = (int) (Math.random() * (11 - 9 + 1) + 9);
			System.out.println(
					"El participante con dorsal: " + Dorsales.get(i) + " ha tardado un tiempo de: " + tiempoTotal);
			Dorsales.get(i);
		}
	}

	public static void main(String[] args) {
		new Ejercicio_13().start();
	}

}
