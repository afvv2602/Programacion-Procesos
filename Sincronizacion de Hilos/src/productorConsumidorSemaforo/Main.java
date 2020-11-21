package productorConsumidorSemaforo;

public class Main
{
	public static void main(String[] args) 
	{
		System.out.println("Inicio del hilo principal");
        Cola cola = new Cola(); // Almacen donde todos trabajan
        Runtime run = Runtime.getRuntime();
        int N = run.availableProcessors();  
        
        System.out.println("Generamos consumidores");
        Consumidor listaConsumidores[] = new Consumidor[N];
        for (int i = 0; i < listaConsumidores.length; i++)
        {
        	listaConsumidores[i] = new Consumidor(cola," Consumidor "+i,N);
        	listaConsumidores[i].start();
		} // Creamos los consumidores
        
        System.out.println("Generamos productores");
        Productor listaProductores[] = new Productor[N];
        for (int i = 0; i < listaProductores.length; i++)
        {
        	listaProductores[i] = new Productor(cola," Productor "+i,N);
        	listaProductores[i].start();
		} // Creamos los productores
        
        System.out.println("Fin del hilo principal");
	}
}
