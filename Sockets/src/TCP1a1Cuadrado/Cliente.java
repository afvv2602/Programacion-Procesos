package TCP1a1Cuadrado;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
	final static int puerto = 1234;
	final static String ip = "127.0.0.1";
	public static void main(String[] args) {
		DataInputStream in;
		DataOutputStream out;
		Scanner sc = new Scanner(System.in);
		int aux;
		try {
			// 1) Creación del socket
			Socket soc = new Socket(ip,puerto);
			System.out.println("Introduce un numero para hacer su cuadrado");
			int numero = sc.nextInt();
			out = new DataOutputStream(soc.getOutputStream());
			in = new DataInputStream(soc.getInputStream());
			System.out.println("Numero enviado");
			aux = numero *numero;
			out.writeUTF(""+numero);
			while(true) {
			int cuadrado = Integer.parseInt(in.readUTF());
			if(cuadrado == aux) {
				System.out.println(""+cuadrado);
				break;
			}
			}
			System.out.println("Cliente cerrado");
			soc.close();
			sc.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
