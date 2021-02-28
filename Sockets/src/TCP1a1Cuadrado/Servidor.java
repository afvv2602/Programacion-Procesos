package TCP1a1Cuadrado;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Servidor {

	final static int PUERTO = 1234;
	public static void main(String[] args) {
		// 1)Creación del socket
		ServerSocket servidor = null;
		Scanner sc = new Scanner(System.in);
		Socket soc = null;
		DataInputStream in;
		DataOutputStream out;
		boolean sw = true;
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
				int numero = Integer.parseInt(in.readUTF());
				int numeroE = numero*numero;
				// Escritura de mensajes
				out = new DataOutputStream(soc.getOutputStream());
				out.writeUTF(""+numeroE);
				// Leemos el mensaje
				soc.close();
				sc.close();
				System.out.println("Servidor cerrado");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}