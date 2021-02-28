package ClaseUDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Cliente {
	public static void main(String[] args) {
		
		//Creamos el socketUDP
		try {
			//Abrir la comunicacion
			DatagramSocket socketUDP = new DatagramSocket(); // En este caso no hay puerto porque es el cliente.
			InetAddress direccionIPServidor = InetAddress.getByName("localhost");
			int PUERTO = -1; // Para darle un valor cuando la quieres inicializar
			//Gestion de la comunicacion
				//Entrada		
			byte[] buffer;
			buffer = new byte[1024];
			//                                                 Buffer, tamaño buffer,         IP         puerto		
			DatagramPacket paqueteEnviado = new DatagramPacket(buffer, buffer.length,direccionIPServidor, PUERTO);
			socketUDP.send(paqueteEnviado);
			DatagramPacket paqueteRecibido = null;
			socketUDP.receive(paqueteRecibido);
			socketUDP.close();
			
			
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
