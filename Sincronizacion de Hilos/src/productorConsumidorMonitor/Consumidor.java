package productorConsumidorMonitor;

//import productorConsumidorSemaforo.Cola;

public class Consumidor extends Thread
{
	private Monitor monitor;
	private String r;
    int nVeces;
    
    Consumidor(Monitor monitor, String name, int nVeces) 
    { 
        this.monitor = monitor;
        this.setName(name);
        this.nVeces = nVeces;
    } 
  
    public void run() 
    { 

    	for (int i = 0; i < nVeces; i++)
        {
    		r = monitor.get(); 
    		System.out.println(r);
    		System.out.println("El consumidor"+this.getName()+" ha consumido el elemento: " + r);
            try
            {
				this.sleep(100);
			} catch (InterruptedException e) 
            {
				e.printStackTrace();
			}
        }
    } 
}
