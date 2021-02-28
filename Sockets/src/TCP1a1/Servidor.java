package TCP1a1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Servidor {

	public static void main(String[] args) {
		// 1)Creación del socket
		ServerSocket servidor = null;
		Scanner sc = new Scanner(System.in);
		Socket soc = null;
		DataInputStream in;
		DataOutputStream out;
		boolean sw = true;
		System.out.println("Introduce el puerto del servidor");
		int PUERTO = sc.nextInt();
		try {
			// 2) Asignación de puerto, de IP vamos a utilizar la nuestra
			servidor = new ServerSocket(PUERTO);
			System.out.println("Servidor incializado");

			while (true)// 3)Escuchar, en este intervalor ya estamos escuchando alguna petición por
						// parte del cliente
			{
				// 4) Aceptamos la conexión
				soc = servidor.accept();
				// 5) Envío y recepción de mensajes
				// Lectura de mensajes
				in = new DataInputStream(soc.getInputStream());
				// Escritura de mensajes
				while(true) {
				out = new DataOutputStream(soc.getOutputStream());
				// Leemos el mensaje
				String mensaje = in.readUTF();
				System.out.println("Cliente "+mensaje);
				if(mensaje.toLowerCase().equals("n")) {
					break;
				}
				}
				// Enviamos un mensaje al cliente
				soc.close();
				System.out.println("Cliente desconectado");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}