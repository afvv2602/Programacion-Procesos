package Ejercicios_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejercicio_5 extends Thread{
	int tipoVehiculo;
	int distancia;
	
	public Ejercicio_5(int tipoVehiculo, int distancia) {
		super();
		this.tipoVehiculo = tipoVehiculo;
		this.distancia = distancia;
	}
	
	public String whichType() {
		String aux="";
		switch (this.tipoVehiculo) {
		case 0: aux="moto";; break;
		case 1: aux="coche";; break;
		case 2: aux="bicicleta"; break;
		default :break;
		}
		return aux;
	}
	
	public void run() {
		String nombre = whichType();
		System.out.println("El" +nombre+ "inicia la carrera");
		for (int i = 0 ; i<this.distancia;i++) {
		try {
			System.out.println("El "+nombre+" va por el kilometro" +i);
			sleep(10);
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		}
		System.out.println("El "+nombre+" termina la carrera");
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		new Ejercicio_5(0,Integer.parseInt(br.readLine())).start();
		new Ejercicio_5(1,Integer.parseInt(br.readLine())).start();
		new Ejercicio_5(2,Integer.parseInt(br.readLine())).start();
		br.close();
	}
}
