package ClaseUDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Servidor {
		public static void main(String[] args) {
			//Creamos el socketUDP
			try {
				//Abrir la comunicacion
				int PUERTO = 5000; 	
				byte[] buffer;
				buffer = new byte[1024];
				DatagramSocket socketUDP = new DatagramSocket(PUERTO);
				while(true) {
					
					DatagramPacket paqueteRecibido = null;
					socketUDP.receive(paqueteRecibido);
					
					InetAddress direccionIPDelPaqueteRecibido = paqueteRecibido.getAddress();
					int puerto = paqueteRecibido.getPort();
					
					//                                                 Buffer, tamaño buffer,         IP                    puerto		
					DatagramPacket paqueteEnviado = new DatagramPacket(buffer, buffer.length,direccionIPDelPaqueteRecibido, PUERTO);
					socketUDP.send(paqueteEnviado);
					
					socketUDP.close();
				}
								
			} catch (SocketException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
