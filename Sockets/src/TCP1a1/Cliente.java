package TCP1a1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {

	public static void main(String[] args) {
		DataInputStream in;
		DataOutputStream out;
		Scanner sc = new Scanner(System.in);
		boolean sw = true;
		try {
			// 1) Creación del socket
			Socket soc;
			System.out.println("Introduce la ip del servidor");
			String ip = sc.nextLine();
			System.out.println("Introduce el puerto del servidor");
			int puerto = Integer.parseInt(sc.nextLine());
			// 2) Conexión con el socket
			soc = new Socket(ip, puerto);
			System.out.println("Conectado con el servidor");
			System.out.println("Puerto cliente " + soc.getLocalPort());
			System.out.println("Puerto servidor " + soc.getPort());
			System.out.println("Host servidor " + soc.getInetAddress());
			// 3) Envío y recepción de mensajes
			// Recepción de mensajes
			in = new DataInputStream(soc.getInputStream());
			// Envío de mensajes
			out = new DataOutputStream(soc.getOutputStream());
			while (true) {
				System.out.println("Enviar cadena al servidor: S/N");
				String opcion = sc.nextLine();
				if (opcion.toLowerCase().equals("s")) {
					System.out.println("Cadena a enviar al servidor");
					String mensajeOut = sc.nextLine();
					out.writeUTF(mensajeOut);
				} else if (opcion.toLowerCase().equals("n")) {
					String mensaje = in.readUTF();
					out.writeUTF(opcion);
					System.out.println("Cerrando conexion con el servidor");
					soc.close();
					sc.close();
				}

			}
			// Escritura de mensaje
			// Lectura de mensaje

			// 4) Cierre de la conexión
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
