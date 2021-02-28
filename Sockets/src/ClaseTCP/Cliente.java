package ClaseTCP;

import java.io.IOException;
import java.net.Socket;

public class Cliente {

	public static void main(String[] args) {
		// Lo podemos definir como constantes.
		String DIRECCION = "";
		int PUERTO = -1;
		// (1)Crear conexion
		Socket sc;
		try {
			// (2)Hemos establecido la conexion
			sc = new Socket(DIRECCION, PUERTO);
			//(3) Trabajamos
				//Gestionar datos de entrada
				//Gestionar datos de salida
			//(4) Cerramos la conexion
			sc.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
