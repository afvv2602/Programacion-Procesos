package Noviembre2;

public class Main {

	public static void main(String[] args) {

		Runtime runtime = Runtime.getRuntime();
		int nCores = runtime.availableProcessors();
		System.out.println("Numero de procesadores disponibles " + nCores);
		Hilo arrayHilos[] = new Hilo[nCores];

		for (int i = 0; i < arrayHilos.length; i++) {
			arrayHilos[i] = new Hilo();
			arrayHilos[i].setIdentificador(i+1);
			arrayHilos[i].start();

		}
		for (int i = 0; i < arrayHilos.length; i++) {
			try {
				arrayHilos[i].join();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
//		Hilo h1 = new Hilo ();
//		Hilo h2 = new Hilo ();
//		
//		h1.setPriority(Thread.MAX_PRIORITY);
//		h2.setPriority(Thread.MIN_PRIORITY);
//		
//		h1.setName("Primer hilo");
//		h2.setName("Segundo hilo");
////		
//		h1.start();
//		
//		try {
//			h1.join(); // Mientras que este hilo este ejecutandose pues se espera
//			// al resto de hilos
//		}catch(InterruptedException e){
//			e.printStackTrace();
//		}
//		
//		h2.start();
//		try {
//			h2.join();
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		
//		System.out.println("Terminan de ejecutarse los dos hilos");
//	}

	}
}
