package productorConsumidorMonitor;


public class Main
{
	public static void main(String[] args) 
	{
		
		System.out.println("Inicio del hilo principal");
	    Runtime run = Runtime.getRuntime();
	    int N = run.availableProcessors();
		Monitor monitor = new Monitor(N);	    
	    System.out.println("Generamos consumidores");
	    Consumidor listaConsumidores[] = new Consumidor[N];
	    for (int i = 0; i < listaConsumidores.length; i++)
	    {
	    	listaConsumidores[i] = new Consumidor(monitor,"Consumidor"+i,i);
	    	listaConsumidores[i].start();
		}
	    
	    System.out.println("Generamos productores");
	    Productor listaProductores[] = new Productor[N];
	    for (int i = 0; i < listaProductores.length; i++)
	    {
	    	listaProductores[i] = new Productor(monitor,i,"Productor"+i);
	    	listaProductores[i].start();
		}
	    
	    System.out.println("Fin del hilo principal");
		}
}
