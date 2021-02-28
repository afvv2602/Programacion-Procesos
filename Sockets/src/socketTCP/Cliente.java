package socketTCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Cliente 
{
	final static String HOST = "127.0.0.1";
	final static int PORT = 5000;
	
	public static void main(String[] args) 
	{
		DataInputStream in;
		DataOutputStream out;
		
		try 
		{
			//1) Creaci�n del socket 
			Socket sc;
			//2) Conexi�n con el socket
			sc = new Socket(HOST, PORT);

			//3) Env�o y recepci�n de mensajes
					//Recepci�n de mensajes
					in = new DataInputStream(sc.getInputStream());
					//Env�o de mensajes
					out = new DataOutputStream(sc.getOutputStream());
					
					//Escritura de mensaje
					out.writeUTF("�Hola mundo desde el cliente!");
					//Lectura de mensaje
					String mensaje = in.readUTF();
					
					System.out.println(mensaje);
			//4) Cierre de la conexi�n
			sc.close();
			
			System.out.println("Cerramos el cliente.java");
		}
		catch (Exception e)
		{
			// TODO: handle exception
		}
	}
}
