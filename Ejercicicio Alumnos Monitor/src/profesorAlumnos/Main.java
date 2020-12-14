package profesorAlumnos;


public class Main extends Thread
{
	String nombre;
	Saludar saludo;
	boolean Profesor;
	Main(Saludar s, String n, boolean P)
	{
		nombre = n;
		saludo = s;
		Profesor = P;
	}
	public boolean getProfesor() {
		return this.Profesor; 
	}
	public void run(){
		System.out.println(" ( " + nombre + " ingresa ) ");
		if(Profesor){
			saludo.respondersaludo();
		}
		else{
			saludo.saludarProfe(nombre);
		}
	} 
	public static void main(String[]args){
		Saludar hola = new Saludar();
		Main Victor = new Main(hola, "Victor",false);
		Main Alberto = new Main(hola, "Alberto",false);
		Main Carlos = new Main(hola, "Carlos",false);
		Main Jose = new Main(hola, "Jose",false);
		Main Elena = new Main(hola, "Elena",false); 
		Main Alba = new Main(hola, "Alba",false);
		Main Fran = new Main(hola, "Fran",true);
		Victor.start();
		Alberto.start();
		Carlos.start();
		Jose.start();
		Elena.start();
		Alba.start();
		Fran.start();
		try{
			Victor.join();
			Alberto.join();
			Carlos.join();
			Jose.join();
			Elena.join();
			Alba.join();
			Fran.join();
		}
		catch(InterruptedException e ){
		}
	}
	}