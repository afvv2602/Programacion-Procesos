package plantillaAlgoritmos;

public class Hilo extends Thread {

	
	@Override
	public void run() {
		System.out.println("Se inicia la ejecucion del hilo "+this.getId()+" Con nombre: "+this.getName());
		for (int i = 0; i < 10; i++) {
			System.out.println("Se ejecuta el hilo "+this.getId()+" Con nombre: "+this.getName()+
					" vuelta numero " +(i+1));
			try {
				sleep(40);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("Finaliza la ejecucion del hilo "+this.getId()+" Con nombre: "+this.getName()+
				" Con prioridad "+this.getPriority());
	}
}
