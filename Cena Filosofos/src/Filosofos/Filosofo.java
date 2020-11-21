package Filosofos;

import javax.management.monitor.Monitor;

public class Filosofo extends Thread {
	private Monitor monitor;
	String nombre;
	int tenedores;
	
	public Filosofo (Monitor monitor, String nombre, int tenedores) {
		this.monitor = monitor;
		this.setName(nombre);
		this.tenedores = tenedores;
	}
	
	public void run() {
		while(true) {
			
		}
	}

}
