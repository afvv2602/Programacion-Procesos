package Ping;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Main {

	 
	static boolean sw = true;

	public static void main(String[] args) {
		System.out.println("Bienvenido a la prueba de ping a un servidor");
		System.out.println("Cuantas pruebas quieres hacer de ping (generalmente se hacen entre 3 y 5 comprobaciones)");
		Scanner sc = new Scanner(System.in);
		int veces = sc.nextInt();
		System.out.println("Cuanto tiempo de espera maximo en milisegundo");
		int tiempo = sc.nextInt();
		System.out.println("Quieres comprobar el acceso parcialmente o general");
		System.out.println("0 para comprobar parcialmente, 1 para comprobar de forma general");
		int opcion = sc.nextInt();
		while (sw) {
			generarPing(tiempo,opcion,veces);
		}
		sc.close();
	}

	public static void generarPing(int tiempo, int opcion, int veces) {
		Scanner sc = new Scanner(System.in);
		System.out.println("A que host quieres hacer ping");
		System.out.println("Si deseas salir del programa pulsa 0");
		String ping = sc.nextLine();
		System.out.println(ping);
		if (ping.equals("0")) {
			System.out.println("Terminaste la ejecucion");
			sc.close();
			sw = false;
		} else if (!ping.equals("0")){
			for (int i = 0; i < veces; i++) {
				try {
					InetAddress direccion = InetAddress.getByName(ping);
					System.out.println(direccion.isReachable(tiempo));
					if (direccion.isReachable(tiempo)) {
						if (opcion == 0) {
							System.out.println("Tenemos acceso al host: " + ping);
						} else {
							System.out.println("Tenemos acceso al host: " + ping);
							System.out.println("Tenemos acceso local " + direccion.isAnyLocalAddress());
							System.out.println("Tenemos acceso local a nivel de enlace " + direccion.isLinkLocalAddress());
							System.out.println("Tenemos acceso de retorno " + direccion.isLoopbackAddress());
						}
					} else {
						System.out.println("No tenemos acceso al host: " + ping);
					}

				} catch (UnknownHostException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}
	}
}
