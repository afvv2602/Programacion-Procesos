package plantillaAlgoritmos;

public class ain {

	public static void main(String[] args) {
		
		Hilo h1 = new Hilo ();
		Hilo h2 = new Hilo ();
		
		h1.setPriority(Thread.MAX_PRIORITY);
		h2.setPriority(Thread.MIN_PRIORITY);
		
		
		h1.start();
		h2.start();
		
		System.out.println("Terminan de ejecutarse los dos hilos");
	}

}
