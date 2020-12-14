package solucionFilosofosMonitor;

public class Monitor {
	boolean palilloLibre[];

	public Monitor(int numPalillos) {
		// Creas un monitor con el numero de filosofos que hay
		palilloLibre = new boolean[numPalillos];

		for (int i = 0; i < numPalillos; i++) {
			// Y le dices que tiene un tenedor
			// Palillo libre == a un filosofo con tenedor
			palilloLibre[i] = true;
		}
	}

	public synchronized boolean intentarCogerPalillos(int pos1, int pos2)
	// En este metodo solo puede pasar un hilo a la vez
	// Y le pasas dos posiciones que son la posicion del palillo de la izquierda y
	// el de la derecha
	{
		boolean losCoge = (palilloLibre[pos1]) && (palilloLibre[pos2]);
		// Almacena los palillos en un boolean y si las dos posiciones
		// Izquierda y derecha

		// Vemos si podemos coger ambos tenedores, están libres
		if (losCoge) {
			// Los coge y los pone a false para que no los puedan coger otros
			palilloLibre[pos1] = false;
			palilloLibre[pos2] = false;
		}
		return losCoge;
	}

	public void liberarPalillos(int pos1, int pos2) {
		//Libera los palillos 
		palilloLibre[pos1] = true;
		palilloLibre[pos2] = true;
	}
}
