package UDP1a1Cuadrado;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente {
	final static int PUERTO_SERVIDOR = 5000;

	public static void main(String[] args) {
		byte[] buffer = new byte[1024];
		Scanner sc = new Scanner(System.in);
		int aux;
		try {
			// Otra forma de obtener nuestra IP
			InetAddress direccionServidor = InetAddress.getByName("localhost");// Misma función
																				// InetAddress.getLocalHost()
			DatagramSocket socketUDP = new DatagramSocket();// No es necesario un puerto, se lo asigna automática mente
															// el OS

			System.out.println("Introduce un numero para hacer su cuadrado");
			int numero = sc.nextInt();
			String mensaje =""+numero;
			buffer = mensaje.getBytes();
			// Creamos el paquete, mensaje
			DatagramPacket peticion = new DatagramPacket(buffer, buffer.length, direccionServidor, PUERTO_SERVIDOR);
			System.out.println("Numero enviado");
			aux = numero * numero;
			// enviamos el mensaje
			socketUDP.send(peticion);
			//Tienes que crear un nuevo buffer para la respuesta del servidor
			byte[] bufferRes = new byte[1024];
			DatagramPacket respuesta = new DatagramPacket(bufferRes, bufferRes.length);
			System.out.println("Recibido la petición del servidor"+respuesta.getData());
			socketUDP.receive(respuesta);

			String servidor = new String(respuesta.getData());
			System.out.println("Respuesta del servidor "+servidor);
			// Cerramos el socket
			socketUDP.close();
			sc.close();

		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
