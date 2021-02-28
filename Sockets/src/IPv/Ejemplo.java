package IPv;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Ejemplo {

	public static void main(String[] args) {
		try {
			InetAddress direccion = InetAddress.getLocalHost();
			//Esto devuelve mi direccion con mi nombre del equipo
			System.out.println(direccion.toString());
			direccion = InetAddress.getByName("MSI");
			System.out.println(direccion.getHostAddress());
			InetAddress direccionAEnviar = InetAddress.getByName("MSI");
			boolean alcanzado = direccionAEnviar.isReachable(1000);
			System.out.println("Tenemos acceso al host "+" 192.168.43.67 "+alcanzado);
			System.out.println("Tenemos acceso local "+direccion.isAnyLocalAddress());
			System.out.println("Tenemos acceso local a nivel de enlace "+direccion.isLinkLocalAddress());
			System.out.println("Tenemos acceso de retorno "+direccion.isLoopbackAddress());
			InetAddress direccionAWeb = InetAddress.getByName("yahoo.com");
			System.out.println("IP de la web: "+direccionAWeb);
			InetAddress[] direccionesDeUnaWeb  = InetAddress.getAllByName("yahoo.com");
			for(InetAddress direccionWeb:direccionesDeUnaWeb) {
				System.out.println(direccionWeb.toString());
			}
			InetAddress raul = InetAddress.getByName("192.168.43.1");
			alcanzado = raul.isReachable(1000);
			System.out.println("Tenemos acceso al raul "+alcanzado);
			InetAddress cesar = InetAddress.getByName("172.16.200.154");
			InetAddress victor = InetAddress.getByName("172.16.200.82");

			} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
