package ClaseTCP;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
	public static void main(String[] args) {
		// (1) Creamos el servidor
		ServerSocket servidor = null;
		Socket sc = null;
		try {
			servidor = new ServerSocket(5000);
			//while (true) { // Podemos gestionar la entrada de varios clientes con la creacion de hilos
				// Establecemos la comunicacion con el cliente, UN SOLO CLIENTE.
				sc = servidor.accept();
				//Hilos :)
					// Trabajamos con el cliente
					// Gestionamos datos de entrada
				// Gestionamos datos de salida
				sc.close();
			//}
		} catch (IOException e) {
			e.printStackTrace();

		}

	}
}
