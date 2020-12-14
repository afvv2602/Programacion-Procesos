package profesorAlumnos;

public class Saludar 
{
	synchronized void saludarProfe (String alumnos) {
	while(true){
	{
		try {
			Thread n = Thread.currentThread();
			System.out.println(n.getName());
			wait();
			System.out.println(n.getName()+" "+alumnos + " --> Buenos dias Profesor !");
			break;
		} catch (InterruptedException e) {
			System.out.println(e);
		}
	}
	}
	}

	synchronized void respondersaludo() {
		System.out.println("Profesor --> Buenos dias");
		notifyAll();
	}
}
