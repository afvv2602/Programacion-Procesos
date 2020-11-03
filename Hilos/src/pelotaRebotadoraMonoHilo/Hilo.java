package pelotaRebotadoraMonoHilo;

public class Hilo implements Runnable {

	Pelota pelota;
	LaminaPelota lamina;
	
	
	public Hilo(Pelota pelota, LaminaPelota lamina) {
		super();
		this.pelota = pelota;
		this.lamina = lamina;
	}


	public void run() {
		for (int i = 1; i <= 3000; i++) {

			pelota.mueve_pelota(lamina.getBounds());
			lamina.paint(lamina.getGraphics());
			Thread t = new Thread();
			try {
				t.sleep(4);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
